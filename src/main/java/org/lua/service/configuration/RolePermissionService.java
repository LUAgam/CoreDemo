/**
 * 
 */
package org.lua.service.configuration;

import org.lua.entity.Role;
import org.lua.entity.RolePermission;
import org.lua.repository.RoleDao;
import org.lua.repository.RolePermissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author onkyo
 *
 */
@Component
@Transactional(readOnly = true)
public class RolePermissionService {

	@Autowired
    RoleDao roleDao;

	@Autowired
    RolePermissionDao dao;

	public List<String> findByRole(Long roleId) {
		return this.dao.findByRole(roleId);
	}

	public List<String> findNameByRole(Long roleId) {
		return this.dao.findNameByRole(roleId);
	}

	@Transactional(readOnly = false)
	public void save(Long roleId, String[] permissions) {
		this.dao.deleteByRoleId(roleId);
		Role role = roleDao.findOne(roleId);
		if (permissions != null) {
			for (String permission : permissions) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRole(role);
				rolePermission.setPermission((permission));
				dao.save(rolePermission);
			}
		}
	}

	/**
	 * 新增一个权限
	 * @param roleId
	 * @param name
	 */
	@ResponseBody
	@Transactional(readOnly = false)
	public void saveOnePermission(Long roleId, String name) {
		Role role = roleDao.findOne(roleId);
		RolePermission rolePermission = new RolePermission();
		rolePermission.setRole(role);
		rolePermission.setPermission(name);
		dao.save(rolePermission);
		return;
	}
	
	/**
	 * 删除一个权限
	 * @param roleId
	 * @param name
	 */
	@ResponseBody
	@Transactional(readOnly = false)
	public void deleteOnePermission(Long roleId, String name) {
		dao.deleteOnePermission(roleId, name);
		return;
	}



	@Transactional(readOnly = false)
	public void deleteByRole(Long roleId) {
		this.dao.deleteByRoleId(roleId);
	}

	@Transactional(readOnly = false)
	public void saveRolePermission(Long roleId, String[] names) {
		this.dao.deleteByRoleId(roleId);
		Role role = roleDao.findOne(roleId);
		if (names != null) {
			for (String name : names) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRole(role);
				rolePermission.setPermission(name);
				dao.save(rolePermission);
			}
		}
	}

}
