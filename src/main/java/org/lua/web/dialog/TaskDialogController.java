/**
 * 
 */
package org.lua.web.dialog;

import org.lua.entity.TodoTask;
import org.lua.entity.User;
import org.lua.service.process.ProcessService;
import org.lua.service.process.TodoTaskService;
import org.lua.util.UserUtils;
import org.lua.web.BaseController;
import org.lua.web.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author JHuang
 *
 */
@Controller
@RequestMapping(value = "/dialog/task")
public class TaskDialogController extends BaseController {
	
	@Autowired
    TodoTaskService todoTaskService;
	
	@Autowired
    ProcessService processService;
	
	/**
	 * 未办任务 get
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/assignee/list", method= RequestMethod.GET)
	public String assigneeList(HttpServletRequest request, Model model) {
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "createTime"));
		
		Page<TodoTask> assigneeTodoTaskPage = todoTaskService.findAssigneeByUser(user.getUsername(), pageRequest);
		model.addAttribute("assigneeTodoTaskPage", assigneeTodoTaskPage);
		
		return "dialog/task/assignee/list";
		
		/*Page<TodoTask> TodoCandidatePage = todoTaskService.findCandidateByUser(user.getUsername(), pageRequest);
		model.addAttribute("assigneeTodoTaskPage", assigneeTodoTaskPage);*/
	}
	
	/**
	 *  未办任务 post
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/assignee/list", method= RequestMethod.POST)
	public String assigneeListPost(HttpServletRequest request, Model model) {
		
		//得到整个请求的参数
		PageParam pp = readPageRequest(request);
		
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "createTime"));
		Page<TodoTask> assigneeTodoTaskPage = todoTaskService.findAssigneeByUser(user.getUsername(), pageRequest);
		model.addAttribute("assigneeTodoTaskPage", assigneeTodoTaskPage);
		
		return "dialog/task/assignee/list";
	}
	
	/**
	 * 未签任务 get
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/candidate/list", method= RequestMethod.GET)
	public String candidateList(HttpServletRequest request, Model model) {
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "createTime"));
		
		Page<TodoTask> candidateTodoTaskPage = todoTaskService.findCandidateByUser(user.getUsername(), pageRequest);
		model.addAttribute("candidateTodoTaskPage", candidateTodoTaskPage);
		
		return "dialog/task/candidate/list";
		
		
	}
	
	/**
	 * 未签任务 post
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/candidate/list", method= RequestMethod.POST)
	public String candidateListPost(HttpServletRequest request, Model model) {
		
		//得到整个请求的参数
		PageParam pp = readPageRequest(request);
		
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(pp.getPageNumber(), pp.getPageSize(), new Sort(Sort.Direction.DESC, "createTime"));
		Page<TodoTask> todoCandidatePage = todoTaskService.findCandidateByUser(user.getUsername(), pageRequest);
		model.addAttribute("todoCandidatePage", todoCandidatePage);
		
		return "dialog/task/candidate/list";
	}
	
	
	
	

}
