/**
 *        (c) 2013 Shanghai SDGroup Information GmbH
 *
 *        http://www.sdgroup.com/
 */

package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 用户角色
 *
 */
@Entity
@Table(name="tbl_user_role")
public class UserRole extends BaseEntity<UserRole>{

    /**
     * 
     */
    private static final long serialVersionUID = 7140678847509200059L;

    @ManyToOne(fetch=FetchType.EAGER)
    private User account;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private Role role;

	public User getAccount() {
		return account;
	}

	public void setAccount(User account) {
		this.account = account;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
