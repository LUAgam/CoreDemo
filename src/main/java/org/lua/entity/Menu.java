/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 菜单
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */
public class Menu  implements Serializable {


	private Long id;
	/**
	 * 
	 */
	private static final long serialVersionUID = 480913418993514934L;

	/**
	 * 名称 （唯一标示符）
	 */
	private String name;
	
	/**
	 * 显示名称 （可重复）
	 */	
	public Menu() {
			
	}
	 
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
	 * 子菜单
	 */
	private List<Menu> children = new ArrayList<Menu>();
    
	/**
	 * 顺序
	 */
	private int position;

	public Menu(Long id,String name, String displayName, String url, String icon, int position) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
		this.url = url;
		this.icon = icon;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * 判断是否有子菜单
	 * @return
	 */
	public boolean hasChildren() {
		if (getChildren() != null && getChildren().size()>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 添加子菜单
	 * @param submenu
	 */
	public void addSubMenu(Menu submenu) {
		getChildren().add(submenu);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
