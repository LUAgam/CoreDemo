/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.repository;

import org.lua.entity.MessageAttachment;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */

public interface MessageAttachmentDao  extends BaseRepository<MessageAttachment, Long>, JpaSpecificationExecutor<MessageAttachment> {

	@Query("SELECT ma FROM MessageAttachment ma where ma.message.id = ?1")
	public List<MessageAttachment> findByMessageId(Long messageId);
}
