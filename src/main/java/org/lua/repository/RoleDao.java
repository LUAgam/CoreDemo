/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */
package org.lua.repository;

import org.lua.entity.Role;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface RoleDao extends BaseRepository<Role, Long>, JpaSpecificationExecutor<Role> {
	
    public Role findByName(String roleName);
}
