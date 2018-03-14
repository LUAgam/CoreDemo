/**
 * 
 */
package org.lua.repository;

import org.lua.entity.LoginLog;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author onkyo
 *
 */
public interface LoginLogDao  extends BaseRepository<LoginLog, Long>, JpaSpecificationExecutor<LoginLog> {
	
	@Query("SELECT ll FROM LoginLog ll WHERE ll.loginUser.id=?1 AND ll.logindatetime IS NOT NULL AND ll.logoutdatetime IS NULL ORDER BY ll.logindatetime DESC")
	public List<LoginLog> findByUser(Long userId);
	
	@Query("SELECT ll FROM LoginLog ll WHERE ll.sessionId=?1 AND ll.logindatetime IS NOT NULL AND ll.logoutdatetime IS NULL ORDER BY ll.logindatetime DESC")
	public List<LoginLog> findBySessionId(String sessionId);

}
