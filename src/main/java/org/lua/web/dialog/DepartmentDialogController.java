/**
 * 
 */
package org.lua.web.dialog;

import org.lua.constant.Constant;
import org.lua.service.configuration.DepartmentService;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * @author p.zhou
 *
 */
@Controller
@RequestMapping(value = "/dialog/department")
public class DepartmentDialogController extends BaseController {

	@Autowired
    DepartmentService departmentService;
	
	@RequestMapping(value="/list", method= RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		PageParam pp = readPageRequest(request);
		
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
		
		model.addAttribute("departmentList", departmentService.getPage(pageRequest));
		return "dialog/department/list";
	}
	
	/**
	 * 列表搜索，分页或导出excel
	 */
	@RequestMapping(value="/list", method= RequestMethod.POST)
	public String post(HttpServletRequest request, Model model) {
		//得到整个请求的参数
		PageParam pp = readPageRequest(request);
		
		//设置数据和分页信息
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
		
		model.addAttribute("departmentList", departmentService.getPage(builderSearchString(pp.getSearchParamter().keySet()), pp.getSearchParamter().values().toArray(), pageRequest));
		//回写搜索参数
		writePageRequest(model, pp);

		return "dialog/department/list";
	}
	
}
