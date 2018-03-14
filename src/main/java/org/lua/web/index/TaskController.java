/**
 * 
 */
package org.lua.web.index;

import org.activiti.engine.history.HistoricProcessInstance;
import org.lua.entity.ApprovalRecord;
import org.lua.entity.BaseEntity;
import org.lua.entity.TodoTask;
import org.lua.entity.User;
import org.lua.service.process.ApprovalRecordService;
import org.lua.service.process.GeneralEntityService;
import org.lua.service.process.ProcessService;
import org.lua.service.process.TodoTaskService;
import org.lua.util.UserUtils;
import org.lua.web.BaseController;
import org.lua.web.BaseFormBean;
import org.lua.web.PageParam;
import org.lua.web.activiti.formbeans.ApproveFB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


/**
 * @author onkyo
 *
 */
@Controller
@SessionAttributes(value={"taskCount", "taskLists"})
@RequestMapping(value = "/admin/profile/task")
public class TaskController extends BaseController {
	
final Logger logger = LoggerFactory.getLogger(TaskController.class);
	
	@Autowired
    ProcessService processService;
	
	@Autowired
    TodoTaskService todoTaskService;

	@Autowired
    GeneralEntityService generalEntityService;
	
	@Autowired
    ApprovalRecordService approvalRecordService;

	/**
	 * 初次打开待办列表
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String task(HttpServletRequest request, Model model) {
		
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "createTime"));
		Page<TodoTask> taskCount = todoTaskService.findListByUser(user.getUsername(), pageRequest);
		model.addAttribute("taskCount", taskCount.getTotalElements());
		model.addAttribute("taskList", taskCount.getContent());
		
		
		return "admin/task";
	}
	
	
	/**
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String doto(HttpServletRequest request, ModelMap map) {
		
		PageParam pp = readPageRequest(request);
		
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "task.createTime"));
		

		return "admin/task";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/doTask/{processInstanceId}/{taskId}")
	public String doTask(@PathVariable("processInstanceId") String processInstanceId, @PathVariable("taskId") String taskId,  HttpServletRequest request, Model model) {
		//TODO 通过processInstanceId找到业务键，反射出实例
		String[] buinessKey = processService.findKeyByProcessInstanceId(processInstanceId);
		BaseEntity baseEntity = generalEntityService.findOne(buinessKey);
		BaseFormBean tableBean = baseEntity.toTableBean(baseEntity);
		/*if(baseEntity instanceof StateMachine)
			*/
		//出线情况
		List<String> flowList = processService.getFlows(processInstanceId);
		//工作流日志
		List<ApprovalRecord> approvalRecords = approvalRecordService.findByProcessInstanceId(processInstanceId);
		model.addAttribute("baseEntity", baseEntity);
		model.addAttribute("tableBean", tableBean);
		model.addAttribute("approvalRecords", approvalRecords);
		model.addAttribute("flowList", flowList);
		model.addAttribute("processInstanceId", processInstanceId);
		return "test/approve";
	}
	
	/**
	 * 通用审批
	 * @param approveFB
	 * @param result
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/approve",method=RequestMethod.POST)
	public String do_approve(@ModelAttribute @Valid ApproveFB approveFB, BindingResult result, ModelMap map){
		processService.completeTask(approveFB.getProcessInstanceId(), approveFB.getFlow(), approveFB.getOpinion());
		return "admin/task";
	}
	
	/**
	 * 初次打开已办列表
	 */
	@RequestMapping(value="/doneTask", method = RequestMethod.GET)
	public String doneTask(HttpServletRequest request, Model model) {
		
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "startTime"));
		Page<HistoricProcessInstance> doneTaskList = processService.findDoneTask(user.getUsername(), pageRequest);
		model.addAttribute("doneTaskPage", doneTaskList);

		return "admin/taskdo";
	}
	
	/**
	 * 打开已办列表
	 */
	@RequestMapping(value="/doneTask", method = RequestMethod.POST)
	public String doneTaskPost(HttpServletRequest request, Model model) {
		
		User user = UserUtils.getCurrentUser();
		PageParam pp = readPageRequest(request);
		
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "startTime"));
		

		Page<HistoricProcessInstance> doneTaskList = processService.findDoneTask(user.getUsername(), pageRequest);
		model.addAttribute("doneTaskPage", doneTaskList);
		
		return "admin/taskdo";
	}
	
	/**
	 * 初次打开办结列表
	 */
	@RequestMapping(value="/finisheddone", method = RequestMethod.GET)
	public String finishedTask(HttpServletRequest request, Model model) {
		
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "startTime"));
		Page<HistoricProcessInstance> finishedTaskList = processService.findFinishedTask(user.getUsername(), pageRequest);
		model.addAttribute("finishedTaskPage", finishedTaskList);

		return "admin/taskfinished";
	}
	
	/**
	 * 打开办结列表
	 */
	@RequestMapping(value="/finisheddone", method = RequestMethod.POST)
	public String finishedTaskPost(HttpServletRequest request, Model model) {
		
		User user = UserUtils.getCurrentUser();
		PageParam pp = readPageRequest(request);
		
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "startTime"));
		
		Page<HistoricProcessInstance> finishedTaskList = processService.findFinishedTask(user.getUsername(), pageRequest);
		model.addAttribute("finishedTaskPage", finishedTaskList);

		return "admin/taskfinished";
	}
	
	/**
	 * 签收
	 * @param taskId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/claim/{taskId}", method = RequestMethod.GET)
	public String claim(@PathVariable("taskId") String taskId, HttpServletRequest request, Model model) {
		User user = UserUtils.getCurrentUser();
		processService.claim(taskId, user.getUsername());
		return "redirect:/admin/profile/task";
	}

}
