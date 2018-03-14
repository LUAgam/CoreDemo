/**
 *        (c) 2010 Shanghai SDGroup Information GmbH
 *
 *        http://www.sdgroup.com/
 */
package org.lua.web.configuration;

import com.schickit.utils.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.lua.constant.Constant;
import org.lua.entity.Department;
import org.lua.entity.DepartmentGroup;
import org.lua.entity.Group;
import org.lua.service.configuration.DepartmentGroupService;
import org.lua.service.configuration.DepartmentService;
import org.lua.service.configuration.GroupService;
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
 *
 * @author $JKe$
 * @version $Revision: 4306 $ 2014-1-9上午10:38:03
 **/
@Controller
@RequestMapping(value = "/admin/sys/department")
public class DepartmentContorller extends BaseController {

	@Autowired
    DepartmentService departmentService;

	@Autowired
    GroupService groupService;

	@Autowired
    DepartmentGroupService dgService;

	@RequiresPermissions("MENU:PROFILE:DEPARTMENT")
	@RequestMapping(method = RequestMethod.GET)
	public String do_get(HttpServletRequest request, Model model) {
		// 设置数据和分页信息
		PageParam pp = readPageRequest(request);
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "id"));
		model.addAttribute("departmentList", departmentService.getPage(pageRequest));
		return "configuration/department/list";
	}

	/**
	 * 部门列表
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String list(HttpServletRequest request, Model model) {
		// 得到整个请求的参数
		PageParam pp = readPageRequest(request);
		// 设置数据和分页信息
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "id"));

		model.addAttribute("departmentList", departmentService.getPage(builderSearchString(pp.getSearchParamter().keySet()),
				pp.getSearchParamter().values().toArray(), pageRequest));
		// 回写搜索参数
		writePageRequest(model, pp);
		return "configuration/department/list";
	}

	/**
	 * 进入修改界面
	 * 
	 * @param departmentId
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/edit/{departmentId}", method = RequestMethod.GET)
	public String do_edit(@PathVariable("departmentId") Long departmentId, ModelMap map) {

		Department department = departmentService.findOne(departmentId);
		DepartmentFB departmentFB = departmentService.toFB(department);
		map.addAttribute("department", departmentFB);
		return "configuration/department/edit";
	}

	/**
	 * 保存修改信息
	 * 
	 * @param departmentFB
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String do_save(@ModelAttribute @Valid DepartmentFB departmentFB, BindingResult result, ModelMap map) {
		if (result.hasErrors()) {
			map.addAttribute("message", ErrorUtils.fetchAllErrorMessages(result));
			map.addAttribute("department", departmentFB);
			return "configuration/department/edit";
		}
		if (StringUtils.isEmpty(departmentFB.getName())) {
			map.addAttribute("message", Constant.ERRORINFO_DEPARTMENTCONTORLLER_DEPARTMENT_NAME_EMPTY);
		}

		Department department;
		if (departmentFB.getId() != null) {
			department = departmentService.findOne(departmentFB.getId());
		} else {
			department = new Department();
		}
		BeanUtils.copyProperties(departmentFB,department);
		if (departmentFB.getParentId() != null) {
			department.setParentDepartment(departmentService.findOne(departmentFB.getParentId()));
		}
		departmentService.save(department);
		return "redirect:/admin/sys/department";
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String do_add(Model model) {

		return "configuration/department/edit";
	}

	/**
	 * 删除信息
	 * 
	 * @param departmentId
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/delete/{departmentId}", method = RequestMethod.GET)
	public String do_delete(Model model, @PathVariable("departmentId") Long departmentId, ModelMap map, RedirectAttributes redirectAttributes) {
		try {
			departmentService.delete(departmentId);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", Constant.DELETE_MESSAGE);
			model.addAttribute("message", Constant.DELETE_MESSAGE);
		}

		return "redirect:/admin/sys/department";
	}

	/**
	 * 配置岗位
	 * 
	 * @param depId
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editGroup/{depId}", method = { RequestMethod.GET, RequestMethod.POST })
	public String editGroup(@PathVariable("depId") Long depId, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Group> allGroupList = groupService.findAll();
		// 得到该岗位下的所有部门
		List<String> groupNameList = dgService.findGroupNameByDepartment(depId);
		List<GroupFB> allGroupFBList = new ArrayList<GroupFB>();
		for (Group group : allGroupList) {
			GroupFB fb = GroupFB.toFB(group);
			if (groupNameList.contains(group.getName())) {
				fb.setIsSelect(true);
			}
			allGroupFBList.add(fb);
		}
		model.addAttribute("groupList", allGroupFBList);
		model.addAttribute("department", departmentService.findOne(depId));
		return "configuration/department/departmentGroup";
	}

	/**
	 * 保存岗位信息
	 * 
	 * @param depId
	 * @param rowcheck
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveGroup/{depId}", method = { RequestMethod.POST })
	public String saveGroup(@PathVariable("depId") Long depId, @RequestParam(value = "rowcheck")Long[] rowcheck, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Department dep = departmentService.findOne(depId);
		// 删除岗位下的所有部门
		dgService.deleteByDepartment(depId);
		if (rowcheck != null) {
			for (Long groupId : rowcheck) {
				Group group = groupService.findOne(groupId);
				DepartmentGroup depGroup = new DepartmentGroup();
				depGroup.setGroup(group);
				depGroup.setDep(dep);
				depGroup.setNo(dep.getNo()+"-"+group.getNo());
				dgService.save(depGroup);
			}
		}

		return "redirect:/admin/sys/department";
	}
}
