/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.repository;

import org.lua.entity.Role;
import org.lua.entity.UserRole;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */

public interface UserRoleDao extends BaseRepository<UserRole, Long>, JpaSpecificationExecutor<UserRole> {
	
	@Query("SELECT ur.role FROM UserRole ur where ur.account.id = ?1")
	public List<Role> findByUser(Long userId);
	
	@Modifying
	@Query("DELETE FROM UserRole ur where ur.account.id = ?1")
	public void deleteByUserId(Long userId);

	public List<UserRole> findByAccountIdAndRoleId(Long id, Long id2);
	 
}
