package org.lua.web.examples;

import org.lua.constant.Constant;
import org.lua.service.configuration.PersonService;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/examples")
public class ExamplesController extends BaseController {
	
	@Autowired
    PersonService personService;
	
	@RequestMapping(value="/form", method= RequestMethod.GET)
	public String do_get(ModelMap map) {
		map.addAttribute("options1", personService.findAll());
		return "examples/form";
	}
	
	@RequestMapping(value="/layout", method= RequestMethod.GET)
	public String do_layout(ModelMap map) {
		return "examples/layout";
	}
	
	@RequestMapping(value="/table", method= RequestMethod.GET)
	public String do_table(HttpServletRequest request, ModelMap model) {
		//设置数据和分页信息
		PageParam pp = readPageRequest(request);
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, Constant.DEFAULT_SORT_KEY));
		model.addAttribute("personList", personService.getPage(pageRequest));
		return "examples/table";
	}
	

}
