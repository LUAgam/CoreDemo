/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.configuration.formbean;

import org.lua.web.BaseFormBean;


/**
 *
 * @author    $Author: XLShu$
 * @version   $Revision: 4306 $Date: 2014-1-9下午4:02:47$
 *
 */

public class RolePermissionFB extends BaseFormBean {
	
    private Long roleId;
    
    private String[] selectpermission;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String[] getSelectpermission() {
		return selectpermission;
	}

	public void setSelectpermission(String[] selectpermission) {
		this.selectpermission = selectpermission;
	}

    
}

