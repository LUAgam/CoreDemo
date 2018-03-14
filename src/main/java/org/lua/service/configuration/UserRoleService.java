/**
 * 
 */
package org.lua.service.configuration;

import org.lua.entity.Role;
import org.lua.entity.User;
import org.lua.entity.UserRole;
import org.lua.repository.RoleDao;
import org.lua.repository.UserDao;
import org.lua.repository.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author onkyo
 *
 */
@Component
@Transactional(readOnly = true)
public class UserRoleService {
	
	@Autowired
    UserRoleDao userRoleDao;
	
	@Autowired
    UserDao userDao;
	
	@Autowired
    RoleDao roleDao;
	
	public List<Role> findByUser(Long userId) {
		return userRoleDao.findByUser(userId);
	}
	
	@Transactional(readOnly = false)
	public void save(Long userId, String[] roleIds) {
		this.userRoleDao.deleteByUserId(userId);
		User user = userDao.findOne(userId);
		if (roleIds != null) {
			for (String roleId : roleIds) {
				UserRole userRole = new UserRole();
				userRole.setAccount(user);
				userRole.setRole(roleDao.findOne(Long.valueOf(roleId)));
				userRoleDao.save(userRole);
			}
		}
	}

}
