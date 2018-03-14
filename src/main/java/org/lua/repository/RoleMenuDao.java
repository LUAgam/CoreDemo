package org.lua.repository;

import org.lua.entity.RoleMenu;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleMenuDao extends BaseRepository<RoleMenu, Long>, JpaSpecificationExecutor<RoleMenu> {

	@Modifying
	@Query("DELETE FROM RoleMenu rm WHERE rm.role.id = ?1")
	public void deleteRoleMenuByRole(Long roleId);

	@Query("select trm from RoleMenu trm where trm.role.id = ?1")
	List<RoleMenu> findByRole(Long roleId);

	@Query("select trm from RoleMenu trm where trm.role.id = ?1 and trm.parentRoleMenu is null")
	List<RoleMenu> getByRole(Long id);

	@Query("select trm from RoleMenu trm where trm.parentRoleMenu.id = ?1")
	public List<RoleMenu> findByParentRoleMenu(Long id);

	@Query("select trm from RoleMenu trm where trm.name = ?1 and trm.role.id=?2")
	RoleMenu findByNameAndRoleId(String name, Long roleId);

}
