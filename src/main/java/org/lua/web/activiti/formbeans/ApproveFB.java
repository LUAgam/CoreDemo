package org.lua.web.activiti.formbeans;

import org.hibernate.validator.constraints.NotBlank;
import org.lua.annotation.MetaData;

/**
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月29日 上午10:08:25 类说明
 */
public class ApproveFB {

	@MetaData(value = "流程定义Id", comments = "流程定义Id")
	private String processInstanceId;

	@MetaData(value = "流程走向", comments = "流程走向(出线上面的文字)")
	@NotBlank(message = "操作不为空！")
	private String flow;
	
	@MetaData(value = "意见", comments = "意见")
	@NotBlank(message = "意见不为空！")
	private String opinion;

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getFlow() {
		return flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

}
