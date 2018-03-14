/**
 * 
 */
package org.lua.service.process;

import org.lua.entity.TodoTask;
import org.lua.repository.TodoTaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author JHuang
 *
 */
@Component
@Transactional(readOnly = true)
public class TodoTaskService {
	
	@Autowired
    TodoTaskDao todoTaskDao;

	public Page<TodoTask> findListByUser(String username, Pageable pageable) {
		Object[] parameter = new Object[]{username, username};
		return todoTaskDao.findPage("assignee=? OR candidate=?", parameter, pageable);
	}
	
	public Page<TodoTask> findCandidateByUser(String username, Pageable pageable) {
		Object[] parameter = new Object[]{username};
		return todoTaskDao.findPage("candidate=?", parameter, pageable);
	}
	
	public Page<TodoTask> findAssigneeByUser(String username, Pageable pageable) {
		Object[] parameter = new Object[]{username};
		return todoTaskDao.findPage("assignee=?", parameter, pageable);
	}
	

}
