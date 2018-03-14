/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 消息接受人
 * @author $Author: XLShu$
 * @version $Revision: 4277 $Date: 2014-4-15下午4:00:09$
 * 
 */
@Entity
@Table(name = "tbl_messagerepient")
public class MessageRepient extends BaseEntity<MessageRepient> {

    /**
     * 
     */
    private static final long serialVersionUID = 5880929282427675267L;

    @ManyToOne(fetch = FetchType.LAZY)
    private User repientUser;

    @ManyToOne(fetch = FetchType.LAZY)
    private Message message;
    
    @Column(name="isread")
    private Boolean read;

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public User getRepientUser() {
        return repientUser;
    }

    public void setRepientUser(User repientUser) {
        this.repientUser = repientUser;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
