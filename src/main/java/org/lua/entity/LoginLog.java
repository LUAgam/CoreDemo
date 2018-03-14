/**
 * 
 */
package org.lua.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 系统登录日志
 * @author onkyo
 *
 */
@Entity
@Table(name = "tbl_loginlog")
public class LoginLog extends BaseEntity<LoginLog> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8157493144165103601L;
	
	/**
	 * 登陆人
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	private User loginUser;
	
	private String sessionId;
	
	private Date logindatetime = null;
	
	private Date logoutdatetime = null;

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public Date getLogindatetime() {
		return logindatetime;
	}

	public void setLogindatetime(Date logindatetime) {
		this.logindatetime = logindatetime;
	}

	public Date getLogoutdatetime() {
		return logoutdatetime;
	}

	public void setLogoutdatetime(Date logoutdatetime) {
		this.logoutdatetime = logoutdatetime;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
