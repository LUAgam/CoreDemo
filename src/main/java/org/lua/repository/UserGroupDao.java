/**
 * (c) 2006 Joven
 * 
 * http://www.joven.com.cn 版权所有 2006 上海悦闻信息技术有限公司
 */
package org.lua.repository;

import org.lua.entity.UserGroup;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupDao extends BaseRepository<UserGroup, Long>,JpaSpecificationExecutor<UserGroup>{
	
	
	
	@Modifying
	@Query("delete from UserGroup entity where entity.user.id=? and entity.group.id=?")
	public void deleteByUserAndGroup(Long userId,Long groupId);
	
	@Query("select entity.user.username from UserGroup entity where  entity.group.id=?1 and entity.user.person.department.id=?2")
	public List<String> findUsernameByGroupAndDep(Long groupId,Long depId);
	
	@Query("select entity from UserGroup entity where  entity.group.id=?1 and entity.user.person.department.id=?2 order by entity.id desc")
	public List<UserGroup> findByGroupAndDep(Long groupId,Long depId);
	
	@Query("select entity.user.username from UserGroup entity where  entity.group.id=?1 and entity.user.person.department.id=?2 and entity.isOnWork=true")
	public List<String> findOnWorkUsernameByGroupAndDep(Long groupId,Long depId);
	
	@Modifying(clearAutomatically=true)
	@Query("update UserGroup entity set entity.isOnWork=false where entity.group.id=?  and entity.user.person.department.id=?")
	public void updateOnWork(Long groupId,Long depId);
		
}
