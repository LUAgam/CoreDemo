package org.lua.web.configuration.formbean;

import org.lua.web.BaseFormBean;

/**
 * @author AMGuo E-mail:www.guoao@foxmail.com
 * @version 创建时间：2017年3月23日 下午5:11:36 类说明
 */
public class RoleMenuFB extends BaseFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2800690627189643056L;

	private String displayName;

	private String name;

	private String tId;

	private String parentTId;

	private String role;
	
	private String icon;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
		this.tId = tId;
	}

	public String getParentTId() {
		return parentTId;
	}

	public void setParentTId(String parentTId) {
		this.parentTId = parentTId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
}
