/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.configuration;

import org.lua.constant.Constant;
import org.lua.entity.Role;
import org.lua.entity.User;
import org.lua.service.configuration.PersonService;
import org.lua.service.configuration.RoleService;
import org.lua.service.configuration.UserRoleService;
import org.lua.service.configuration.UserService;
import org.lua.util.ErrorUtils;
import org.lua.util.UserUtils;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.lua.web.configuration.formbean.PasswordFB;
import org.lua.web.configuration.formbean.RoleFB;
import org.lua.web.configuration.formbean.UserFB;
import org.lua.web.configuration.formbean.UserRoleFB;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */
@Controller
@RequestMapping(value = "/admin/auth/user")
public class UserController extends BaseController {
	
	@Autowired
    UserService userService;
	
	@Autowired
    UserRoleService userRoleService;
	
	@Autowired
    RoleService roleService;
	
	
	@Autowired
    PersonService personService;
	
	/**
	 * 初次打开列表
	 */
	@RequestMapping(method= RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		//设置数据和分页信息
		PageParam pp = readPageRequest(request);
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
		model.addAttribute("userList", userService.getPage(pageRequest));
		return "/configuration/user/list";
	}
	

	/**
	 * 列表搜索，分页或导出excel
	 */
	@RequestMapping(method= RequestMethod.POST)
	public String list(HttpServletRequest request, Model model) {
		//得到整个请求的参数
		PageParam pp = readPageRequest(request);
		//设置数据和分页信息
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
		
		model.addAttribute("userList", userService.getPage(builderSearchString(pp.getSearchParamter().keySet()), pp.getSearchParamter().values().toArray(), pageRequest));
		//回写搜索参数
		writePageRequest(model, pp);
		
		return "/configuration/user/list";
	}
	
	/*@RequestMapping(method= RequestMethod.GET)
	public String do_get(Model model) {
		List<User> userList = userService.findAll(new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> arg0,
                    CriteriaQuery<?> arg1,
                    CriteriaBuilder arg2) {
                
                return null;
            }
        }, new Sort(new Order(Direction.DESC, "id")));
	    
		List<UserFB> userFBList = new LinkedList<UserFB>();
		UserFB userFB;
		for (User user : userList) {
		    userFB = UserFB.toFB(user);
		    userFBList.add(userFB);
		}
	    model.addAttribute("userList", userFBList);
	    
		return "configuration/user/list";
	}*/
	
	/**
	 * 重置密码(密码重置为“111111”)
	 * 
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/resetPassword/{userId}",method = RequestMethod.GET)
	public String do_resetPassword(@PathVariable("userId") Long userId,Model model,RedirectAttributes redirectAttributes) {
	    User user = userService.findOne(userId);
	    user.setPassword("111111");
	    userService.saveUser(user);
	    redirectAttributes.addFlashAttribute("message",Constant.ERRORINFO_USERCONTROLLER_PASSWORD_RESETTING);
	    return "redirect:/admin/auth/user";
	}
	
	/**
	 * 修改密码
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/editPassword", method= RequestMethod.GET)
	public String do_editPassword(Model model) {
		model.addAttribute("userId", UserUtils.getCurrentUser().getId());
		return "configuration/user/editPassword";
	}
	
	@RequestMapping(value="/editPassword", method= RequestMethod.POST)
	public String do_editPassword(@ModelAttribute @Valid PasswordFB user, BindingResult result, ModelMap map){
		
		if(result.hasErrors()){  
	        map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
	        map.addAttribute("userId", user.getId());
	        return "configuration/user/editPassword";
	    }
		if(!user.getNewPassword().equals(user.getConfirmPassword())){
			map.addAttribute("message", Constant.ERRORINFO_USERCONTROLLER_PASSWORD_DIFFERENCE);
			map.addAttribute("userId", user.getId());
			return "configuration/user/editPassword";
		}
		
        User userEntity = userService.findOne(user.getId());
        userEntity.setPassword(user.getNewPassword());
		userService.saveUser(userEntity);
		return "redirect:/index";
	}
	
	/**
	 * 用户列表数据源 （分页）
	 * @param params
	 * @return
	 */
	/*@RequestMapping(value="/list", method= RequestMethod.POST)
    public @ResponseBody  JSONResponse list(@RequestBody JSONParam[] params) {
		HashMap<String, String> paramMap = JSONParamUtils.convertToMap(params);  

	    //int start = Integer.parseInt(paramMap.get("iDisplayStart"));  
	    int length = Integer.parseInt(paramMap.get("iDisplayLength"));
	    int page = Integer.parseInt(paramMap.get("iDisplayPage"));
	    
	    final String normalsearch = paramMap.get("normalsearch");
	    final String username = paramMap.get("username");
	    final String personname = paramMap.get("personname");
	    
		Pageable pr = new PageRequest(page, length, new Sort(new Order(Direction.DESC, "id")));
		Page<User> userPage = userService.findAll(new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root,
					CriteriaQuery<?> criteriaquery,
					CriteriaBuilder criteriabuilder) {
				 Path<String> usernamePath = root.get("username");
				 Path<Person> personPath = root.get("person");
				 Path<String> personnamePath = personPath.get("name");
				 if (StringUtils.isEmpty(username) 
				         && StringUtils.isEmpty(personname) 
				         && StringUtils.isEmpty(normalsearch)) {
				     criteriaquery.where();
				     return null;
				 }
				 criteriaquery.where(criteriabuilder.like(usernamePath, "%" + username + "%"), criteriabuilder.like(usernamePath, "%" + normalsearch + "%"),
				         criteriabuilder.like(personnamePath, "%" + personname + "%"));
				return null;
			}
			
		}, pr);
		
		List<UserFB> userFBList = new LinkedList<UserFB>();
		UserFB userFB;
		for (User user : userPage) {
		    userFB = UserFB.toFB(user);
		    userFBList.add(userFB);
		}
		return JSONResponseUtils.convert(userPage, paramMap, userFBList);
    }*/
	
	/**
     * 新增
     * @return
     */
    @RequestMapping(value="/add",method=RequestMethod.GET)
    public String do_add(ModelMap map){
    	UserFB user = new UserFB();
    	user.setVersion(1);
    	map.addAttribute("user", user);
        return "configuration/user/edit";
    }
    
	/**
	 * 保存用户
	 * @param user
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String do_save(@ModelAttribute @Valid UserFB user, BindingResult result, ModelMap map) {
		
		if(result.hasErrors()){  
	        map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
	        map.addAttribute("user", user);
	        return "configuration/user/edit";
	    }
		
        User userEntity;
        if (user.getId() != null) {
        	userEntity = userService.findOne(user.getId());
        } else {
        	userEntity = new User();
        	
        }
		BeanUtils.copyProperties(user,userEntity);
		userEntity.setUsername(user.getUsername().trim());
		if (user.getId() == null) {
			userEntity.setPassword("111111");
		}
		
		if (user.getPersonId() != null && user.getPersonId()>0) {
			userEntity.setPerson(personService.findOne(user.getPersonId()));
		}

		userService.saveUser(userEntity);
		return "redirect:/admin/auth/user";
		
	}
	
	@RequestMapping(value="/edit/{userId}", method= RequestMethod.GET)
	public String do_edit(@PathVariable("userId") Long userId, ModelMap map) {
		User userEntity = userService.findOne(userId);
		UserFB user = new UserFB();
		BeanUtils.copyProperties(userEntity, user);
		if (userEntity.getPerson() != null) {
			user.setPersonId(userEntity.getPerson().getId());
			user.setPersonName(userEntity.getPerson().getName());
		}
		map.addAttribute("user", user);
		return "configuration/user/edit";
	}
	
	/**
     * @return
     */
    @RequestMapping(value="delete/{userId}",method=RequestMethod.GET)
    public String do_delete(@PathVariable("userId") Long userId,RedirectAttributes redirectAttributes) {
    	try {
    	 	userService.remove(userId);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message",Constant.DELETE_MESSAGE);
		}
   
        return "redirect:/admin/auth/user";
    }
    
    /**
     * 为用户分配角色
     * @return
     */
    @RequestMapping(value="role/{userId}",method=RequestMethod.GET)
    public String do_userrole(@PathVariable("userId") Long userId, ModelMap map) {
    	
    	List<Role> allRole = roleService.findAll();
    	List<Role> selectRole = userRoleService.findByUser(userId);
    	User user = userService.findOne(userId);
    	
    	map.addAttribute("user", user);
    	List<RoleFB> allRoleList = new LinkedList<RoleFB>();
    	for (Role r : allRole) {
    		RoleFB rFB = new RoleFB();
    		BeanUtils.copyProperties(r, rFB);
    		if (selectRole.contains(r)) {
    			rFB.setChecked(true);
    		}
    		allRoleList.add(rFB);
    	}
    	
    	map.addAttribute("allRole", allRoleList);
    	
    	
    	return "configuration/user/userrole";
    }
    
    /**
     * 为用户分配角色
     * @return
     */
    @RequestMapping(value="/role", method= RequestMethod.POST)
    public String do_save_userrole(@ModelAttribute UserRoleFB userRoleFB) {
    	
    	userRoleService.save(userRoleFB.getUserId(), userRoleFB.getSelectrole());
    	
    	return "redirect:/admin/auth/user";
    	
    	
    }
}
