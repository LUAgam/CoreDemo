/**
 * 
 */
package org.lua.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * @author onkyo
 *
 */
@Entity
@Table(name = "tbl_schedule_job")
public class QuartzJob extends  BaseEntity<QuartzJob> {
	
	public static final String ACTIVE = "ACTIVE";
	public static final String RUNNING = "RUNNING";
	public static final String INACTIVE = "INACTIVE";

	/**
	 * 
	 */
	private static final long serialVersionUID = 4555633694700531055L;

	/**
     * 定时任务类型
     * 比如 DataUpdateJob 数据更新
     */
    @NotNull
    private String type;
    
    /**
     * 唯一的定时任务名
     * 比如SMSJob 
     */
    @NotNull
    String name;
    
    /**
     * 任务描述
     */
    String description;
    
    /**
     * 预留参数1，传递参数给定时器 （比如手机号等等...) 
     */
    String parameter1;
    
    /**
     * 预留参数2
     */
    String parameter2;
    
    /**
     * 预留参数3
     */
    String parameter3;

    /**
     * 是否保存最后一次执行时间
     */
    boolean saveExecutionTimes = true;
    
    /**
     * 最后一次执行的开始时间
     */
    Date lastExecutionStart;
    
    /**
     * 最后一次执行的结束时间 
     */
    Date lastExecutionEnd;
    
    /**
     * 下一次执行的开始时间
     */
    Date nextExecutionStart;

    /**
     * 定时器运行时的日志信息 （报错或者调试信息）
     */
    String message;
    
    /**
     * CRON 表达式
     * <pre>
     * <b>字段        范围                   通配符</b>
     * 秒             0-59                  , - * /
     * 分             0-59                  , - * /
     * 小时           0-23                  , - * /
     * 天             1-31                  , - * ? / L W
     * 月             1-12 oder JAN-DEC     , - * /
     * 星期几          1-7 oder SUN-SAT      , - * ? / L #
     * 年(optional)   空或者 1970-2099       , - * /
     * </pre>
     */
    @Column(length=32)
    String cronExpression;
    
    /**
     * 激活
     */
    boolean active = true;
    
    /**
     * 定时器状态
     */
    @NotNull
    String status = ACTIVE;

    /**
     * 是否在定时器执行时发生错误时向管理员发生消息
     */
    boolean sendMessageOnFailure = true;
    
    /**
     * 是否在定时器执行时成功时向管理员发生消息
     */
    boolean sendMessageOnSuccess = false;
    

    @Version
    private int version;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getParameter1() {
		return parameter1;
	}


	public void setParameter1(String parameter1) {
		this.parameter1 = parameter1;
	}


	public String getParameter2() {
		return parameter2;
	}


	public void setParameter2(String parameter2) {
		this.parameter2 = parameter2;
	}


	public String getParameter3() {
		return parameter3;
	}


	public void setParameter3(String parameter3) {
		this.parameter3 = parameter3;
	}


	public boolean isSaveExecutionTimes() {
		return saveExecutionTimes;
	}


	public void setSaveExecutionTimes(boolean saveExecutionTimes) {
		this.saveExecutionTimes = saveExecutionTimes;
	}


	public Date getLastExecutionStart() {
		return lastExecutionStart;
	}


	public void setLastExecutionStart(Date lastExecutionStart) {
		this.lastExecutionStart = lastExecutionStart;
	}


	public Date getLastExecutionEnd() {
		return lastExecutionEnd;
	}


	public void setLastExecutionEnd(Date lastExecutionEnd) {
		this.lastExecutionEnd = lastExecutionEnd;
	}


	public Date getNextExecutionStart() {
		return nextExecutionStart;
	}


	public void setNextExecutionStart(Date nextExecutionStart) {
		this.nextExecutionStart = nextExecutionStart;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getCronExpression() {
		return cronExpression;
	}


	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public boolean isSendMessageOnFailure() {
		return sendMessageOnFailure;
	}


	public void setSendMessageOnFailure(boolean sendMessageOnFailure) {
		this.sendMessageOnFailure = sendMessageOnFailure;
	}


	public boolean isSendMessageOnSuccess() {
		return sendMessageOnSuccess;
	}


	public void setSendMessageOnSuccess(boolean sendMessageOnSuccess) {
		this.sendMessageOnSuccess = sendMessageOnSuccess;
	}
	
}
