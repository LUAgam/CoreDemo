/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.service.admin;

import org.lua.entity.MessageSender;
import org.lua.repository.MessageSenderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author    $Author: XLShu$
 * @version   $Revision: 4306 $Date: 2014-4-16上午10:24:15$
 *
 */
@Component
@Transactional(readOnly = true)
public class MessageSenderService {

    @Autowired
    MessageSenderDao messageSenderDao;
    
    public Page<MessageSender> findAll(Specification<MessageSender> specification, Pageable pageable) {
        return this.messageSenderDao.findAll(specification, pageable);
    }
    
    public MessageSender findOne(Long id) {
        return messageSenderDao.findOne(id);
    }
    
    @Transactional
    public void delete(Long id) {
        messageSenderDao.delete(id);
    }
}

