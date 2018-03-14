/**
 * 
 */
package org.lua.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 消息
 * 
 */
@Entity
@Table(name = "tbl_message")
public class Message extends BaseEntity<Message> {

   
    /**
	 * 
	 */
    private static final long serialVersionUID = 2952162669086746010L;

    /**
     * 发件人
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private User sender;

    /**
     * 收件人
     */
    private String recipientStr;

    /**
     * 时间
     */
    private Date datetime;

    /**
     * 内容
     */
    private String content;

    /**
     * 标题
     */
    private String title;

    /**
     * 消息状态 （已读，未读，草稿等等）
     */
    private String status;

    /**
     * 附件列表
     */
    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<MessageAttachment> attachmentList = new LinkedList<MessageAttachment>();

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getRecipientStr() {
        return recipientStr;
    }

    public void setRecipientStr(String recipientStr) {
        this.recipientStr = recipientStr;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MessageAttachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<MessageAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

}
