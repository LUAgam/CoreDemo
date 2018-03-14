/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 *人员和权限关系表
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */
@Entity
@Table(name = "tbl_role_permission")
public class RolePermission extends  BaseEntity<RolePermission>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 328263103203243255L;
	

    @ManyToOne(fetch=FetchType.EAGER)
	private Role role;
	
	private String permission;

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}



}
