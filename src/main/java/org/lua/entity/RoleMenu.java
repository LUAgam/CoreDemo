package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role_menu")
public class RoleMenu extends BaseEntity<RoleMenu>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5866205749417815890L;

	@ManyToOne(fetch=FetchType.EAGER)
	private Role role;
	
	private String displayName;
	
	private int pos;
	
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private RoleMenu parentRoleMenu;
	
	private String icon;
	
	
	
	public RoleMenu() {
		super();
	}

	public RoleMenu(Role role, String displayName, int pos, String name, RoleMenu parentRoleMenu, String icon) {
		super();
		this.role = role;
		this.displayName = displayName;
		this.pos = pos;
		this.name = name;
		this.parentRoleMenu = parentRoleMenu;
		this.icon = icon;
	}

	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public RoleMenu getParentRoleMenu() {
		return parentRoleMenu;
	}

	public void setParentRoleMenu(RoleMenu parentRoleMenu) {
		this.parentRoleMenu = parentRoleMenu;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
