/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.repository;

import org.lua.entity.MessageSender;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author    $Author: XLShu$
 * @version   $Revision: 4306 $Date: 2014-4-15下午4:10:51$
 *
 */

public interface MessageSenderDao extends BaseRepository<MessageSender, Long>, JpaSpecificationExecutor<MessageSender>{

}

