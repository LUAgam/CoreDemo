/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.index;

import org.lua.entity.TodoTask;
import org.lua.entity.User;
import org.lua.service.process.ProcessService;
import org.lua.service.process.TodoTaskService;
import org.lua.util.UserUtils;
import org.lua.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */
@Controller
@SessionAttributes(value={"taskCount", "taskPageList"})
@RequestMapping(value = "/admin/profile/portal")
public class PortalController extends BaseController {
	

	@Autowired
    ProcessService processService;
	
	@Autowired
    TodoTaskService todoTaskService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String portal(Model model) {
		User user = UserUtils.getCurrentUser();
		PageRequest pageRequest = new PageRequest(0, 20, new Sort(Sort.Direction.DESC, "createTime"));
		Page<TodoTask> taskCount = todoTaskService.findListByUser(user.getUsername(), pageRequest);
		model.addAttribute("taskCount", taskCount.getTotalElements());
		model.addAttribute("taskList", taskCount.getContent());
		
		return "admin/portal";
	}

}
