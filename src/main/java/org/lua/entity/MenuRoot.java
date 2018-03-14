package org.lua.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MenuRoot implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 394055213978953707L;
	
	List<Menu> MenuList;
	
	public MenuRoot() {
		MenuList = new ArrayList<Menu>();
	}

	public void addMenu(Menu Menu) {  
		MenuList.add(Menu);  
    }

	public List<Menu> getMenuList() {
		return MenuList;
	}

	public void setMenuList(List<Menu> MenuList) {
		this.MenuList = MenuList;
	}  
}
