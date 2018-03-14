/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.account.formbean;

/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */

public class AccountFB {
	
	private String username;
	private String password;
	private boolean rememberme;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRememberme() {
		return rememberme;
	}
	public void setRememberme(boolean rememberme) {
		this.rememberme = rememberme;
	}

}
