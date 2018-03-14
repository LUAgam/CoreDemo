/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.service.admin;

import org.lua.entity.MessageRepient;
import org.lua.repository.MessageRepientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author    $Author: XLShu$
 * @version   $Revision: 4306 $Date: 2014-4-16上午10:24:34$
 *
 */
@Component
@Transactional(readOnly = true)
public class MessageRepientService {

    @Autowired
    MessageRepientDao messageRepientDao;
    
    public Page<MessageRepient> findAll(Specification<MessageRepient> specification, Pageable pageable) {
        return this.messageRepientDao.findAll(specification, pageable);
    }
    
    /**
     * 当前用户未读消息总数
     * @return
     */
    public Long findUnreadCount(Long userId) {
        return messageRepientDao.findUnreadCount(userId);
    }
    
    /**
     * 消息置为已读
     * @param id
     */
    @Transactional
    public void read(Long id) {
        messageRepientDao.read(id);
    }
    
    /**
     * 消息置为未读
     */
    @Transactional
    public void unRead(Long id) {
        messageRepientDao.unRead(id);
    }
    
    public MessageRepient findOne(Long id) {
        return messageRepientDao.findOne(id);
    }
    
    /**
     * 删除
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        messageRepientDao.delete(id);
    }
}

