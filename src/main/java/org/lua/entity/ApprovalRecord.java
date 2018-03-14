package org.lua.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.lua.annotation.MetaData;

/**
 * 工作流日志表
 * 
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月27日 上午11:17:01 类说明
 */
@Entity
@Table(name = "tbl_approvalrecord")
public class ApprovalRecord extends BaseEntity<ApprovalRecord> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2540359084170173981L;

	@MetaData(value = "操作名称", comments = "操作名称")
	private String name;

	@MetaData(value = "操作人", comments = "操作人")
	@ManyToOne
	@JoinColumn(name = "operate_user")
	private User user;

	@MetaData(value = "时间", comments = "时间")
	private Date date;

	@MetaData(value = "操作动作", comments = "操作动作（同意或驳回）")
	private String action;

	@MetaData(value = "意见", comments = "意见")
	private String opinion;

	@MetaData(comments = "对应的taskId", value = "taskId")
	private String taskId;

	@MetaData(comments = "对应的processInstanceId", value = "processInstanceId")
	private String processInstanceId;

	public ApprovalRecord() {
		super();
	}

	public ApprovalRecord(String name, User user, Date date, String action, String opinion, String taskId, String processInstanceId) {
		super();
		this.name = name;
		this.user = user;
		this.date = date;
		this.action = action;
		this.opinion = opinion;
		this.taskId = taskId;
		this.processInstanceId = processInstanceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
}
