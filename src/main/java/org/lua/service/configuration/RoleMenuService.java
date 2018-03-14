package org.lua.service.configuration;

import com.schickit.utils.StringUtils;
import org.lua.constant.ResourceFactory;
import org.lua.entity.Menu;
import org.lua.entity.Role;
import org.lua.entity.RoleMenu;
import org.lua.repository.RoleMenuDao;
import org.lua.web.configuration.formbean.RoleMenuFB;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class RoleMenuService {

	@Autowired
	private RoleMenuDao dao;

	@Autowired
	RoleService roleService;

	/**
	 * 根据角色到RoleMenu表中查找对应的菜单number集合
	 * 
	 * @param roleId
	 * @return
	 */
	public List<Menu> getMenusByRole(Long roleId) {
		List<Menu> ret = new LinkedList<Menu>();
		return ret;
	}

	/**
	 * 添加新的菜单给角色
	 * 
	 * @param roleId
	 * @param menu
	 */
	@Transactional(readOnly = false)
	public void updateRoleMenu(Long roleId, Menu menu) {
		// this.deleteRoleMenu(roleId);

	}

	/**
	 * 根据角色删除RoleMenu表中对应的记录
	 * 
	 * @param roleId
	 */
	@Transactional(readOnly = false)
	public void deleteRoleMenu(Long roleId) {
		dao.deleteRoleMenuByRole(roleId);
	}

	/**
	 * 通过角色查找所有的menu
	 * 
	 * @param roleId
	 * @return
	 */
	public List<RoleMenu> findByRole(Long roleId) {
		return dao.findByRole(roleId);
	}

	public List<Menu> getMenuByRole(Long id) {
		List<RoleMenu> parentRoleMenu = dao.getByRole(id);
		List<Menu> parentMenu = new ArrayList<Menu>();
		Menu menu;
		for (RoleMenu roleMenu : parentRoleMenu) {
			menu = new Menu(roleMenu.getId(),roleMenu.getName(), roleMenu.getDisplayName(), "#", roleMenu.getIcon(), roleMenu.getPos());
			List<RoleMenu> chrid = dao.findByParentRoleMenu(roleMenu.getId());
			List<Menu> children = new ArrayList<Menu>();
			Menu menu2;
			for (RoleMenu roleMenu2 : chrid) {
				String url = ResourceFactory.getInstance().getURLByName(roleMenu2.getName());
				menu2 = new Menu(roleMenu2.getId(),roleMenu2.getName(), roleMenu2.getDisplayName(), url, roleMenu2.getIcon(), roleMenu2.getPos());
				children.add(menu2);
			}
			menu.setChildren(children);
			parentMenu.add(menu);
		}
		return parentMenu;
	}

	/**
	 * 
	 * @param rs
	 * @return
	 */
	@Transactional(readOnly = false)
	public void saveRoleMenuFBList(List<RoleMenuFB> rs) {
		RoleMenu roleMenu;
		for (RoleMenuFB roleMenuFB : rs) {
			if (StringUtils.isEmpty(roleMenuFB.getParentTId())) {
				Role role = roleService.findOne(Long.parseLong(roleMenuFB.getRole()));
				roleMenu = new RoleMenu(role, roleMenuFB.getDisplayName(), 1, roleMenuFB.getName(), null, "");
				dao.save(roleMenu);
			}
		}
		for (RoleMenuFB roleMenuFB : rs) {
			if (!StringUtils.isEmpty(roleMenuFB.getParentTId())) {
				Role role = roleService.findOne(Long.parseLong(roleMenuFB.getRole()));
				String parentTId = roleMenuFB.getParentTId();
				String name = "";
				for (RoleMenuFB roleMenuFB2 : rs) {
					if (roleMenuFB2.gettId().equals(parentTId)) {
						name = roleMenuFB2.getName();
						break;
					}
				}
				RoleMenu menu = dao.findByNameAndRoleId(name, role.getId());
				roleMenu = new RoleMenu(role, roleMenuFB.getDisplayName(), 1, roleMenuFB.getName(), menu, roleMenuFB.getIcon());
				dao.save(roleMenu);
			}
		}
	}

	/**
	 * 将rolemenulist转换为fblist
	 * @param roleMenuList
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public List<RoleMenuFB> toFB(List<RoleMenu> roleMenuList) throws IllegalAccessException, InvocationTargetException {
		RoleMenuFB fb;
		List<RoleMenuFB> fbList = new ArrayList<RoleMenuFB>();
		for (RoleMenu roleMenu : roleMenuList) {
			fb = new RoleMenuFB();
			BeanUtils.copyProperties(roleMenu,fb);
			fb.settId(roleMenu.getId().toString());
			fb.setParentTId(roleMenu.getParentRoleMenu() != null ? roleMenu.getParentRoleMenu().getId().toString() : "");
			fb.setRole(roleMenu.getRole().getId().toString());
			fbList.add(fb);
		}
		return fbList;
	}

	public RoleMenu findOne(long id) {
		return dao.findOne(id);
	}
}
