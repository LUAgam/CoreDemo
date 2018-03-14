package org.lua.web.test;

import org.lua.entity.test.Plan;
import org.lua.service.process.ProcessService;
import org.lua.service.test.PlanService;
import org.lua.web.test.formbean.PlanFB;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/** 
* @author AMGuo E-mail:www.guoao@foxmail.com 
* @version 创建时间：2017年3月27日 上午10:38:04 
* 类说明 
*/
@Controller
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
    PlanService planService;
	
	@Autowired
    ProcessService processService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String do_add(){
		 return "test/edit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String do_save(@ModelAttribute @Valid PlanFB planFB, BindingResult result){
		Plan plan = new Plan();
		BeanUtils.copyProperties(planFB,plan);
		plan.setStatus("新建");
		planService.save(plan);
		Map<String, Object> variables = new HashMap<String, Object>();
		String processInstanceId = processService.startProcess(plan, variables);
		processService.completeTask(processInstanceId,"同意",null);
		return "test/edit";
	}
	
	/*@RequestMapping(value="/approveBefore/{processInstanceId}",method=RequestMethod.GET)
	public String do_approveBefore(@PathVariable(value = "processInstanceId") String processInstanceId,ModelMap map){
		List<String> flowList = processService.getFlows(processInstanceId);
		map.addAttribute("flowList", flowList);
		map.addAttribute("processInstanceId", processInstanceId);
		return "test/approve";
	}
	
	@RequestMapping(value="/approve",method=RequestMethod.POST)
	public String do_approve(@ModelAttribute @Valid ApproveFB approveFB,BindingResult result,ModelMap map){
		processService.completeTask(approveFB.getProcessInstanceId(), approveFB.getFlow());
		return "test/approve";
	}*/
	
}
