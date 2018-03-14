/**
 * 待办任务
 */
package org.lua.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author JHuang
 *
 */
@Entity 
@Table(name="vw_tasklist")
public class TodoTask implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2025647525251479211L;
	
	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "task_id")
	private String taskId;
	
	@Column(name = "proc_inst_id")
	private String processInstanceId;
	
	@Column(name = "act_id")
	private String activeTaskId;
	
	@Column(name = "act_name")
	private String activeTaskName;
	
	@Column(name = "assignee")
	private String assignee;
	
	@Column(name = "delegationId")
	private String delegationId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "create_time")
	private Date createTime;
	
	@Column(name = "due_date")
	private String dueDate;
	
	@Column(name = "candidate")
	private String candidate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getActiveTaskId() {
		return activeTaskId;
	}

	public void setActiveTaskId(String activeTaskId) {
		this.activeTaskId = activeTaskId;
	}

	public String getActiveTaskName() {
		return activeTaskName;
	}

	public void setActiveTaskName(String activeTaskName) {
		this.activeTaskName = activeTaskName;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getDelegationId() {
		return delegationId;
	}

	public void setDelegationId(String delegationId) {
		this.delegationId = delegationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

}
