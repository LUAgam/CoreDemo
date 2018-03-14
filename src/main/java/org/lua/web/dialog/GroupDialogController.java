package org.lua.web.dialog;

import org.lua.service.configuration.GroupService;
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
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @author ZZWang
 * @Time 2017年3月29日  下午2:33:35
 *
 */
@Controller
@RequestMapping(value = "/dialog/group")
public class GroupDialogController extends BaseController {
	
	@Autowired
    GroupService groupService;
	
	/**
	 * 初次打开列表
	 */
	@RequestMapping(value="/list",method= RequestMethod.GET)
	public String get(HttpServletRequest request, Model model) {
		//设置数据和分页信息
		PageParam pp = readPageRequest(request);
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.ASC, "priority"));
		model.addAttribute("groupList", groupService.getPage(pageRequest));
		return "/dialog/group/list";
	}

	/**
	 * 列表搜索，分页或导出excel
	 */
	@RequestMapping(value="/list",method= RequestMethod.POST)
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		//得到整个请求的参数
		PageParam pp = readPageRequest(request);
		
		//设置数据和分页信息
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.ASC, "priority"));
		
		model.addAttribute("groupList", groupService.getPage(builderSearchString(pp.getSearchParamter().keySet()), pp.getSearchParamter().values().toArray(), pageRequest));
		//回写搜索参数
		writePageRequest(model, pp);
		
		return "/dialog/group/list";
	}
}
