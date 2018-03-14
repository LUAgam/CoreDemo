/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */
package org.lua.repository;

import org.lua.entity.RolePermission;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RolePermissionDao extends BaseRepository<RolePermission, Long> {
	
	@Query("SELECT rp.permission FROM RolePermission rp where rp.role.id = ?1")
	public List<String> findByRole(Long roleId);
	
	@Modifying
	@Query("DELETE FROM RolePermission rp where rp.role.id = ?1")
	public void deleteByRoleId(Long roleId);

	@Query("SELECT rp.permission FROM RolePermission rp where rp.role.id = ?1")
	public List<String> findNameByRole(Long roleId);
	
	@Modifying
	@Query("DELETE FROM RolePermission rp where rp.role.id = ? and rp.permission = ? ")
	public void deleteOnePermission(Long roleId,String name);
	
}
