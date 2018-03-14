/**
 * 
 */
package org.lua.web.index.formbean;

import org.hibernate.validator.constraints.NotEmpty;
import org.lua.web.BaseFormBean;

import javax.validation.constraints.NotNull;

/**
 * @author onkyo
 *
 */
public class MessageFB extends BaseFormBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7938247617313419661L;
	
	@NotNull(message="收件人不能为空！")
	private Long recipientId;
	
	private String recipientStr;
	
	
	@NotEmpty(message="标题不能为空！")
	private String title;
	
	private String messageContent;

	public Long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getRecipientStr() {
		return recipientStr;
	}

	public void setRecipientStr(String recipientStr) {
		this.recipientStr = recipientStr;
	}

}
