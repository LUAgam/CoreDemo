/**
 * 
 */
package org.lua.entity;

import org.lua.annotation.MetaData;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author onkyo
 *
 */
@Entity 
@Table(name="tbl_user_group")
public class UserGroup extends BaseEntity<UserGroup>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3352268296431809257L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="account")
	public User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="gro")
	public Group group;

	@NotNull
	@MetaData("是否当班")
	private Boolean isOnWork=false; 
	
	@Version
	private int version;
	
	public Group getGroup() {
		return group;
	}

	public User getUser() {
		return user;
	}

	public Boolean getIsOnWork() {
		return isOnWork;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setIsOnWork(Boolean isOnWork) {
		this.isOnWork = isOnWork;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
