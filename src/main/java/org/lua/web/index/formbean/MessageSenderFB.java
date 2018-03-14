/**
 *        (c) 2010 SDGroup
 *
 *        http://www.sdgroup.com
 */

package org.lua.web.index.formbean;

import com.schickit.utils.DateUtils;
import org.lua.entity.MessageSender;
import org.lua.web.BaseFormBean;

import java.util.Date;

/**
 * 
 * @author $Author: XLShu$
 * @version $Revision: 4277 $Date: 2014-4-16下午1:27:07$
 * 
 */
public class MessageSenderFB extends BaseFormBean {

    private Integer messageId;

    private String messageTitle;

    private String messageContent;

    private String messageRecipientStr;

    private Date date;
    private String dateStr;

    private Boolean read = true;

    private String creatorName;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
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

    public String getMessageRecipientStr() {
        return messageRecipientStr;
    }

    public void setMessageRecipientStr(String messageRecipientStr) {
        this.messageRecipientStr = messageRecipientStr;
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

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public static MessageSenderFB toFB(MessageSender messageSender) {
        MessageSenderFB fb = new MessageSenderFB();
        fb.setId(messageSender.getId());
        if (messageSender.getMessage() != null) {
            fb.setDate(messageSender.getMessage().getDatetime());
            if (fb.getDate() != null) {
                fb.setDateStr(DateUtils.formatDateTime(fb.getDate()));
            }
            fb.setMessageContent(messageSender.getMessage().getContent());
            fb.setMessageTitle(messageSender.getMessage().getTitle());
            fb.setMessageRecipientStr(messageSender.getMessage().getRecipientStr());
        }
        return fb;
    }

}
