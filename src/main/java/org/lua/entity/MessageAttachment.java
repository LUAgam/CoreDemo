/**
 * 
 */
package org.lua.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author onkyo
 * 
 */
@Entity
@Table(name = "tbl_messageattachment")
public class MessageAttachment extends BaseEntity<MessageAttachment> {

    /**
	 * 
	 */
    private static final long serialVersionUID = -796220563749196614L;

    /**
     * 文件路径 (相对路径)
     */
    @Column(name="filepath")
    private String file;

    /**
     * 文件大小
     */
    private Long fileLength;

    /**
     * 文件上传时文件名 (Old)
     */
    private String fileName;

    /**
     * 文件上传后的服务器上面的文件id
     */
    private Long fileNewId;

    /**
	 * 文件后缀名
	 */
    private String extName;

    /**
     * 文件所属的消息
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private Message message;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Long getFileLength() {
        return fileLength;
    }

    public void setFileLength(Long fileLength) {
        this.fileLength = fileLength;
    }

    public String getExtName() {
        return extName;
    }

    public void setExtName(String extName) {
        this.extName = extName;
    }

    public Long getFileNewId() {
        return fileNewId;
    }

    public void setFileNewId(Long fileNewId) {
        this.fileNewId = fileNewId;
    }

}
