/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.index.formbean;

import com.schickit.utils.DateUtils;
import org.lua.entity.MessageRepient;
import org.lua.web.BaseFormBean;

import java.util.Date;

/**
 * 
 * @author $Author: XLShu$
 * @version $Revision: 4306 $Date: 2014-4-16下午1:27:27$
 * 
 */

public class MessageRepientFB extends BaseFormBean {
    
    private Long messageId;

    private String messageTitle;

    private String messageContent;

    private Long creatorId;
    private String creatorName;
    private String creatorHeadImage;
    
    private Date date;
    private String dateStr;
    
    private Boolean read;

    public String getCreatorHeadImage() {
        return creatorHeadImage;
    }

    public void setCreatorHeadImage(String creatorHeadImage) {
        this.creatorHeadImage = creatorHeadImage;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public static MessageRepientFB toFB(MessageRepient messageRepient) {
        MessageRepientFB fb = new MessageRepientFB();
        fb.setId(messageRepient.getId());
        fb.setRead(messageRepient.getRead());
        if (messageRepient.getMessage() != null) {
            fb.setMessageId(messageRepient.getMessage().getId());
            fb.setMessageTitle(messageRepient.getMessage().getTitle());
            fb.setMessageContent(messageRepient.getMessage().getContent());
            fb.setDate(messageRepient.getMessage().getDatetime());
            if (fb.getDate() != null) {
                fb.setDateStr(DateUtils.formatDateTime(fb.getDate()));
            }
            if (messageRepient.getMessage().getSender() != null) {
                fb.setCreatorId(messageRepient.getMessage().getSender().getId());
                if (messageRepient.getMessage().getSender().getPerson() != null) {
                    fb.setCreatorName(messageRepient.getMessage().getSender().getPerson().getName());
                    fb.setCreatorHeadImage(messageRepient.getMessage().getSender().getPerson().getHeadImage());
                }
            }
        }
        return fb;
    }
}
