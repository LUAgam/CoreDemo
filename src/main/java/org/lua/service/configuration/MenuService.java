/**
 * (c) 2006 Shanghai Joven Information Technologies Co., Ltd.
 * 
 * http://www.joven.com.cn
 */
package org.lua.service.configuration;

import org.lua.entity.Menu;
import org.lua.entity.MenuRoot;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理类.
 * 
 * @author JHuang
 */
// Spring Service Bean的标识.
@Scope(value = "singleton")
@Component
@Transactional(readOnly = true)
public class MenuService {

	private static MenuRoot root = null;
	private static Map<String, Menu> cache = new HashMap<String, Menu>();
	private static Map<String, String> parentKey = new HashMap<String, String>();

	/**
	 * 加载菜单
	 */
	public MenuService() {
		
		
	}

	public MenuRoot findAjaxRoot() {
		if (root == null) {
			
		}
		return root;
	}

	public Menu findOneByNumber(String name) {
		return cache.get(name);
	}
	
	public Menu getParent(Menu child){
		String parentNumber = parentKey.get(child.getName());
		if (parentNumber != null) {
			return findOneByNumber(parentNumber);
		}
		return null;
	}

}
