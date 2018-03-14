/**
 * (c) 2006 Shanghai Joven Information Technologies Co., Ltd.
 * 
 * http://www.joven.com.cn
 */
package org.lua.service.account;

import org.lua.entity.Role;
import org.lua.entity.RoleMenu;
import org.lua.entity.User;
import org.lua.repository.RoleMenuDao;
import org.lua.repository.RolePermissionDao;
import org.lua.repository.UserDao;
import org.lua.repository.UserRoleDao;
import org.lua.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户管理类.
 * 
 * @author JHuang
 */
// Spring Service Bean的标识.
@Component
@Transactional
public class AccountService {

	@Autowired
    UserDao userDao;

	@Autowired
    UserRoleDao userRoleDao;
	
	@Autowired
    RolePermissionDao rolePermissionDao;
	
	@Autowired
    RoleMenuDao roleMenuDao;
	
	public List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}

	public User getUser(Long id) {
		return userDao.findOne(id);
	}

	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	
	
	public List<Role> getRoleListByUser(User user) {
		return userRoleDao.findByUser(user.getId());
	}
	
	public List<String> getPermissionListByRole(Role role) {
		return rolePermissionDao.findByRole(role.getId());
	}
	
	public User getCurrentUser() {
		return UserUtils.getCurrentUser();
	}
	
	public Set<String> getMenuPermissionSetByRole(Long roleId) {
		List<RoleMenu> parentRoleMenu = roleMenuDao.getByRole(roleId);
		Set<String> menuPermission = new HashSet<String>();
		for (RoleMenu roleMenu : parentRoleMenu) {
			List<RoleMenu> chrid = roleMenuDao.findByParentRoleMenu(roleMenu.getId());
			for (RoleMenu roleMenu2 : chrid) {
				menuPermission.add(roleMenu2.getName());
			}
		}
		return menuPermission;
	}
	
	
}
