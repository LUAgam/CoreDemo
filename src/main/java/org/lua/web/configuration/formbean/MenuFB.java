/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.configuration.formbean;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import org.lua.web.BaseFormBean;

/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */

public class MenuFB extends BaseFormBean {

	/**
	 * 名称 （唯一标示符）
	 */
	@NotEmpty(message = "菜单编号不为空！")
	private String name;
	
	/**
	 * 显示名称 （可重复）
	 */
	@NotEmpty(message = "显示名称不为空！")
	private String displayName;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 点击响应的URL
	 */
	private String url;
	
	
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 父菜单
	 */

	private Long parentMenuId;
	
	private String parentMenuDisplayName;
	/**
	 * 权限
	 */
    private Long permisstionId;
    
    private String permisstionDisplayName;
	
	/**
	 * 顺序
	 */
    @NotNull(message = "顺序不为空！")
    @DecimalMin(value = "1",message = "顺序号为大于0的整数")
	private Integer position;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Long parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public Long getPermisstionId() {
		return permisstionId;
	}

	public void setPermisstionId(Long permisstionId) {
		this.permisstionId = permisstionId;
	}


	public String getParentMenuDisplayName() {
		return parentMenuDisplayName;
	}

	public void setParentMenuDisplayName(String parentMenuDisplayName) {
		this.parentMenuDisplayName = parentMenuDisplayName;
	}

	public String getPermisstionDisplayName() {
		return permisstionDisplayName;
	}

	public void setPermisstionDisplayName(String permisstionDisplayName) {
		this.permisstionDisplayName = permisstionDisplayName;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	
}
