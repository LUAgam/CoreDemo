/**
 * (c) 2006 Joven
 * 
 * http://www.joven.com.cn 版权所有 2006 上海悦闻信息技术有限公司
 */
package org.lua.repository;

import org.lua.entity.Group;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface GroupDao extends BaseRepository<Group, Long>,JpaSpecificationExecutor<Group>{
	
	

}
