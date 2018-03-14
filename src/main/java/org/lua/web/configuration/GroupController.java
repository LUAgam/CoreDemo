package org.lua.web.configuration;

import org.lua.constant.Constant;
import org.lua.entity.Department;
import org.lua.entity.DepartmentGroup;
import org.lua.entity.Group;
import org.lua.service.configuration.DepartmentGroupService;
import org.lua.service.configuration.DepartmentService;
import org.lua.service.configuration.GroupService;
import org.lua.service.configuration.UserGroupService;
import org.lua.util.ErrorUtils;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.lua.web.configuration.formbean.DepartmentFB;
import org.lua.web.configuration.formbean.GroupFB;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author ZZWang
 * @Time 2017年3月29日 下午2:33:35
 *
 */
@Controller
@RequestMapping(value = "/admin/auth/group")
public class GroupController extends BaseController {

	@Autowired
    GroupService groupService;

	@Autowired
    UserGroupService ugService;

	@Autowired
    DepartmentGroupService dgService;

	@Autowired
    DepartmentService depService;

//	private static Logger logger = Logger.getLogger(GroupController.class);

	/**
	 * 初次打开列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		// 设置数据和分页信息
		PageParam pp = readPageRequest(request);
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.ASC, "priority"));
		model.addAttribute("groupList", groupService.getPage(pageRequest));
		return "/configuration/group/list";
	}

	/**
	 * 列表搜索，分页或导出excel
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		// 得到整个请求的参数
		PageParam pp = readPageRequest(request);

		// 设置数据和分页信息
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.ASC, "priority"));

		model.addAttribute("groupList",
				groupService.getPage(builderSearchString(pp.getSearchParamter().keySet()), pp.getSearchParamter().values().toArray(), pageRequest));
		// 回写搜索参数
		writePageRequest(model, pp);

		return "/configuration/group/list";
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String do_add(Model model) {

		return "configuration/group/edit";
	}

	/**
	 * 保存岗位
	 * 
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String do_save(@ModelAttribute @Valid GroupFB groupFB, BindingResult result, ModelMap map) {

		if (result.hasErrors()) {
			map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
			map.addAttribute("group", groupFB);
			return "configuration/group/edit";
		}

		// 保存人员信息
		Group entity = new Group();
		if (groupFB.getId() != null) {
			entity = groupService.findOne(groupFB.getId());
		}

		BeanUtils.copyProperties(groupFB,entity);
		if (groupFB.getParentGroupId() != null) {
			entity.setParentGroup(groupService.findOne(groupFB.getParentGroupId()));
		}
		try {
			groupService.save(entity);
		} catch (Exception e) {
			map.addAttribute("message", "   编号不能重复！");
			if (groupFB.getParentGroupId() != null && groupFB.getParentGroupId() > 0) {
				groupFB.setParentGroupName(groupService.findOne(groupFB.getParentGroupId()).getName());
			}
			map.addAttribute("group", groupFB);
			return "configuration/group/edit";
		}
		return "redirect:/admin/auth/group";

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String do_edit(@PathVariable("id") Long id, ModelMap map, RedirectAttributes redirectAttributes) {
		Group group = groupService.findOne(id);
		GroupFB groupFB = GroupFB.toFB(group);
		map.addAttribute("group", groupFB);
		return "configuration/group/edit";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String do_delete(@PathVariable("id") Long id, Model model,RedirectAttributes reAttributes) {
		try {
			groupService.remove(id);
		} catch (Exception e) {
			reAttributes.addFlashAttribute("message", Constant.DELETE_MESSAGE);
		}
		return "redirect:/admin/auth/group";
	}

	/**
	 * 配置岗位下的部门
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editDep/{groupId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String editDep(@PathVariable("groupId") Long groupId, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Department> allDepList = depService.findAll();
		// 得到该岗位下的所有部门
		List<String> groupDepNo = dgService.findDepNoByGroup(groupId);
		List<DepartmentFB> allDepFBList = new ArrayList<DepartmentFB>();
		for (Department dep : allDepList) {
			DepartmentFB fb = depService.toFB(dep);
			if (groupDepNo.contains(dep.getNo())) {
				fb.setIsSelect(true);
			}
			allDepFBList.add(fb);
		}
		model.addAttribute("departmentList", allDepFBList);
		model.addAttribute("group", groupService.findOne(groupId));

		return "configuration/group/departmentGroup";
	}

	/**
	 * 保存岗位部门
	 * 
	 * @param groupId
	 * @param rowcheck
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveDep/{groupId}", method = { RequestMethod.POST })
	public String saveDep(@PathVariable("groupId") Long groupId,@RequestParam(value="rowcheck") Long[] rowcheck, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Group group = groupService.findOne(groupId);
		//删除岗位下的所有部门
		dgService.deleteByGroup(groupId);
		if (rowcheck != null) {
			for (Long depId : rowcheck) {
				Department dep = depService.findOne(depId);
				DepartmentGroup depGroup = new DepartmentGroup();
				depGroup.setDep(dep);
				depGroup.setGroup(group);
				depGroup.setNo(dep.getNo()+"-"+group.getNo());
				dgService.save(depGroup);
			}
		}

		return "redirect:/admin/auth/group";
	}
}
