/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 消息发送人
 * 
 * @author $Author: XLShu$
 * @version $Revision: 4277 $Date: 2014-4-15下午3:59:07$
 * 
 */
@Entity
@Table(name = "tbl_messagecreator")
public class MessageSender extends BaseEntity<MessageSender> {

    /**
     * 
     */
    private static final long serialVersionUID = -155298616716023352L;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    private Message message;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
