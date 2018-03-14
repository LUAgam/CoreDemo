/**
 * (c) 2006 JOVEN
 * <p>
 * http://www.joven.com.cn
 */

package org.lua.web.configuration;

import com.schickit.utils.FileUtils;
import org.lua.constant.Constant;
import org.lua.datatables.JSONParam;
import org.lua.datatables.JSONResponse;
import org.lua.entity.Person;
import org.lua.entity.User;
import org.lua.service.configuration.DepartmentService;
import org.lua.service.configuration.PersonService;
import org.lua.service.configuration.UserService;
import org.lua.util.*;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.lua.web.configuration.formbean.PersonFB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.criteria.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * @author $Author: JHuang $
 * @version $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */
@Controller
@RequestMapping(value = "/admin/sys/person")
public class PersonController extends BaseController {

    @Autowired
    PersonService personService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;

    private static Logger logger = LoggerFactory.getLogger(PersonController.class);

    /**
     * 初次打开列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public String get(HttpServletRequest request, Model model) {
        //设置数据和分页信息
        PageParam pp = readPageRequest(request);
        PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
        model.addAttribute("personList", personService.getPage(pageRequest));
        return "/configuration/person/list";
    }


    /**
     * 列表搜索，分页或导出excel
     */
    @RequestMapping(method = RequestMethod.POST)
    public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
        //得到整个请求的参数
        PageParam pp = readPageRequest(request);

        if (Constant.EXCEL_TYPE.equals(pp.getType())) {
            String where = builderSearchString(pp.getSearchParamter().keySet());
            List<Person> personList = null;
            if (where != null && where.length() > 0) {
                personList = personService.findAll("SELECT entity FROM Person entity WHERE " + where, pp.getSearchParamter().values().toArray());
            } else {
                personList = personService.findAll();
            }

            ExcelUtil.exportExcel(response, ExcelUtil.create(personList, pp.getExportParamter()), "人员.xls");

        }


        //设置数据和分页信息
        PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "id"));

        model.addAttribute("personList", personService.getPage(builderSearchString(pp.getSearchParamter().keySet()), pp.getSearchParamter().values().toArray(), pageRequest));
        //回写搜索参数
        writePageRequest(model, pp);

        return "/configuration/person/list";
    }
	
	/*@RequestMapping(method= RequestMethod.GET)
	public String do_get() {
		logger.info("do_get\n\n");
		return "configuration/person/list";
	}*/

    /**
     * 修改个人信息
     * @param model
     * @return
     */
    @RequestMapping(value = "/editInfo", method = RequestMethod.GET)
    public String do_editInfo(Model model) {

        Person person = personService.findOne(UserUtils.getCurrentUser().getPerson().getId());
        PersonFB fb = PersonFB.toFB(person);
        List<String> genders = new ArrayList<String>();
        genders.add(Constant.MAN);
        genders.add(Constant.WOMAN);
        model.addAttribute("genders", genders);
        model.addAttribute("person", fb);
        return "configuration/person/editInfo";
    }

    @RequestMapping(value = "/editInfo", method = RequestMethod.POST)
    public String do_editInfo(@ModelAttribute @Valid PersonFB personFB, BindingResult result, ModelMap map, MultipartHttpServletRequest request) {

        if (result.hasErrors()) {
            map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
            map.addAttribute("person", personFB);
            return "configuration/person/editInfo";
        }

        Person personEntity = personService.findOne(personFB.getId());

        String headImagePath = FileUploadUtil.getCurrentPath(request) + ResourceUtils.getProperty(ResourceUtils.FILEUPLOAD_HEADERIMAGE);
        String headImage = FileUploadUtil.upload(headImagePath, personEntity.getId().toString(), request);

        if (headImage != null) {
            headImage = ResourceUtils.getProperty(ResourceUtils.FILEUPLOAD_HEADERIMAGE) + FileUtils.getFileName(headImage);
            personEntity.setHeadImage(headImage);
        }
        personService.savePerson(personEntity);

        return "redirect:/index";
    }

    /**
     * 用户列表数据源 （分页）
     * @param params
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public @ResponseBody
    JSONResponse list(@RequestBody JSONParam[] params) {

        logger.info("//list\n\n");

        HashMap<String, String> paramMap = JSONParamUtils.convertToMap(params);

        int length = Integer.parseInt(paramMap.get("iDisplayLength"));
        int page = Integer.parseInt(paramMap.get("iDisplayPage"));
        final String normalsearch = paramMap.get("normalsearch");

        int col = Integer.parseInt(paramMap.get("iSortCol_0"));
        String dir = paramMap.get("sSortDir_0");

        Pageable pr = new PageRequest(page, length, new Sort(new Order(Direction.ASC, "id")));
        Page<Person> personPage = personService.findAll(new Specification<Person>() {

            @Override
            public Predicate toPredicate(Root<Person> root,
                                         CriteriaQuery<?> criteriaquery,
                                         CriteriaBuilder criteriabuilder) {
                Path<String> namePath = root.get("name");
                Path<String> statusPath = root.get("status");
                if (normalsearch != null) {
                    /**
                     * 连接查询条件, 不定参数，可以连接0..N个查询条件
                     */
                    criteriaquery.where(criteriabuilder.like(namePath, "%" + normalsearch + "%"));
                }
                return null;
            }
        }, pr);
        List<PersonFB> personFBList = new LinkedList<PersonFB>();
        for (Person person : personPage) {
            PersonFB fb = PersonFB.toFB(person);
            personFBList.add(fb);
        }


        return JSONResponseUtils.convert(personPage, paramMap, personFBList);
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String do_add(Model model) {
        logger.info("do_add add\n\n");
        PersonFB fb = new PersonFB();
        fb.setDepartmentId(departmentService.findAll().get(0).getId());
        fb.setDepartmentName(departmentService.findOne(fb.getDepartmentId()).getName());
        fb.setGender(Constant.MAN);
        model.addAttribute("person", fb);

        return "configuration/person/edit";
    }

    /**
     * 保存用户
     * @param result
     * @param map
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String do_save(@ModelAttribute @Valid PersonFB personFB, BindingResult result, ModelMap map) {

        if (result.hasErrors()) {
            map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
            if (personFB.getDepartmentId() != null && personFB.getDepartmentId() != 0) {
                personFB.setDepartmentName(departmentService.findOne(personFB.getDepartmentId()).getName());
            }
            map.addAttribute("person", personFB);
            return "configuration/person/edit";
        }
        String error = "";
        if (StringUtils.isEmpty(personFB.getName())) {
            error = error + Constant.ERROR_PERSONCONTROLLER_NAME_EMPTY;
        }
        if (StringUtils.isEmpty(personFB.getNumber())) {
            error = error + Constant.ERROR_PERSONCONTROLLER_NUMBER_EMPTY;
        }
        if (personFB.getDepartmentId() == null || personFB.getDepartmentId() == 0) {
            error = error + Constant.ERROR_PERSONCONTROLLER_DEPARTMENT_EMPTY;
        }
        if (StringUtils.isEmpty(personFB.getGender())) {
            error = error + Constant.ERROR_PERSONCONTROLLER_GENDER_EMPTY;
        }
        if (!"".equals(error)) {
            map.addAttribute("message", error);
            if (personFB.getDepartmentId() != null && personFB.getDepartmentId() != 0) {
                personFB.setDepartmentName(departmentService.findOne(personFB.getDepartmentId()).getName());
            }
            map.addAttribute("person", personFB);
            return "/configuration/person/edit";
        }

        //保存人员信息
        Person personEntity = new Person();
        if (personFB.getId() != null) {
            personEntity = personService.findOne(personFB.getId());
        } else {
            personEntity.setDimission(false);
        }
        BeanUtils.copyProperties(personFB,personEntity);
        if (personFB.getDepartmentId() != null) {
            personEntity.setDepartment(departmentService.findOne(personFB.getDepartmentId()));
        }
        if (personFB.getGender() != null && Constant.MAN.equals(personFB.getGender())) {
            personEntity.setGender(Constant.MALE);
        } else {
            personEntity.setGender(Constant.FEMALE);
        }
        try {
            personService.savePerson(personEntity);
        } catch (Exception e) {
            map.addAttribute("message", Constant.ERRORINFO_PERSONCONTROLLER_UNMBER_CANNOT_REPEATED);
            map.addAttribute("person", personFB);
            return "configuration/person/edit";
        }
        return "redirect:/admin/sys/person";

    }

    @RequestMapping(value = "/edit/{personId}", method = RequestMethod.GET)
    public String do_edit(@PathVariable("personId") Long personId, ModelMap map, RedirectAttributes redirectAttributes) {
        logger.info("//do_edit\n\n");
        Person person = personService.findOne(personId);
        PersonFB personFB = PersonFB.toFB(person);
        map.addAttribute("person", personFB);

        return "configuration/person/edit";
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delete/{personId}", method = RequestMethod.GET)
    public String do_delete(@PathVariable("personId") Long personId, RedirectAttributes redirectAttributes) {
        personService.remove(personId);
        //redirectAttributes.addFlashAttribute("message",person.getMetroLine().getName()+"人数不能小于3");
        return "redirect:/admin/sys/person";
    }

    /**
     * 创建用户
     * @return
     */
    @RequestMapping(value = "/user/{personId}", method = RequestMethod.GET)
    public String createUser(@PathVariable("personId") Long personId, RedirectAttributes redirectAttributes) {

        Person person = personService.findOne(personId);
        String message = "";
        User user = userService.findByUsername(person.getNumber());
        message = "用户账号" + person.getNumber() + "已经重新创建！";
        if (user == null) {
            user = new User();
            message = "用户账号" + person.getNumber() + "已经创建！";

        }

        user.setUsername(person.getNumber());
        user.setPassword(Constant.DEFAULT_PASSWORD);
        user.setLoginAllowed(true);
        user.setComment(person.getName());
        user.setPerson(person);
        userService.saveUser(user);

        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/admin/sys/person";
    }
}
