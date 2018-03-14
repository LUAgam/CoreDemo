/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.service.admin;

import org.lua.entity.MessageAttachment;
import org.lua.repository.MessageAttachmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */

@Component
@Transactional(readOnly = true)
public class MessageAttachmentService {
	
	@Autowired
	private MessageAttachmentDao messageAttachmentDao;
	
	@Transactional(readOnly = false)
	public void save(MessageAttachment messageAttachment) {
		this.messageAttachmentDao.save(messageAttachment);
	}
	
	public List<MessageAttachment> findByMessageId(Long messageId) {
		return this.messageAttachmentDao.findByMessageId(messageId);
	}
	
	public MessageAttachment findByOne(Long messageAttachmentId) {
		return this.messageAttachmentDao.findOne(messageAttachmentId);
	}
	
	
}
