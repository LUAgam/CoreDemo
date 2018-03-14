/**
 *        (c) 2009 Shanghai Schick Information Technologies Co., Ltd.
 *
 *        http://www.schickit.com
 */
package org.lua.entity;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Length;
import org.lua.annotation.MetaData;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity object that represents a security role.
 * 
 * @author $Author: JHuang $
 * @version $Revision: 4277 $ $Date: 2013-07-12 18:06:42 +0800 (Fri, 12 Jul
 *          2013) $
 */
@Entity
@Table(name = "tbl_role", uniqueConstraints = {@UniqueConstraint(columnNames = "number")})
public class Role extends BaseEntity<Role> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -845963723333578564L;

	@NotNull
	@Length(max = 30)
	@Index(name = "idx_role_number")
	private String number;

	private String description;

	@NotNull
	private String name;

	@MetaData(value="父角色", comments="父角色")
	@ManyToOne(fetch = FetchType.EAGER)
	private Role parent;
	
    @OneToMany(mappedBy="role", cascade = CascadeType.ALL)
    private Set<RolePermission> rolePermissions = new HashSet<RolePermission>(0);
    
    @OneToMany(mappedBy="role", cascade = CascadeType.ALL)
    private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	
	@OneToMany(mappedBy="role",cascade = CascadeType.ALL)
	private Set<RoleMenu> roleMenus = new HashSet<RoleMenu>();

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Set<RolePermission> getRolePermissions() {
		return rolePermissions;
	}

	public void setRolePermissions(Set<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Set<RoleMenu> getRoleMenus() {
		return roleMenus;
	}

	public void setRoleMenus(Set<RoleMenu> roleMenus) {
		this.roleMenus = roleMenus;
	}

	public Role getParent() {
		return parent;
	}

	public void setParent(Role parent) {
		this.parent = parent;
	}
	
	

}
