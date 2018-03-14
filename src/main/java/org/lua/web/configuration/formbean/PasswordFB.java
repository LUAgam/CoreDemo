package org.lua.web.configuration.formbean;

import org.hibernate.validator.constraints.NotEmpty;

import org.lua.web.BaseFormBean;

/**
 * 修改密码
 * @author    $Author: YXYu$
 * @version   $Revision: 4277 $Date: 2014-1-23下午1:54:47$
 *
 */
public class PasswordFB extends BaseFormBean {
	
	@NotEmpty(message = "新密码不能为空！")
	private String newPassword;
	
	@NotEmpty(message = "确认密码不能为空！")
	private String confirmPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
