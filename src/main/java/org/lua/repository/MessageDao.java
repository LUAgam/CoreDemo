/**
 * 
 */
package org.lua.repository;

import org.lua.entity.Message;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @author onkyo
 *
 */
public interface MessageDao extends BaseRepository<Message, Long>, JpaSpecificationExecutor<Message> {
	

}
