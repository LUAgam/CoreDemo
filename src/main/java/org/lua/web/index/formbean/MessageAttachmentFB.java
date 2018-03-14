/**
 * 
 */
package org.lua.web.index.formbean;

import java.util.List;

/**
 * @author onkyo
 *
 */
public class MessageAttachmentFB {
	
	private int filecount;
	
	private long filelength;
	
	private List<AttachmentFB> attachmentList;

	public int getFilecount() {
		return filecount;
	}

	public void setFilecount(int filecount) {
		this.filecount = filecount;
	}

	public long getFilelength() {
		return filelength;
	}

	public void setFilelength(long filelength) {
		this.filelength = filelength;
	}

	public List<AttachmentFB> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentFB> attachmentList) {
		this.attachmentList = attachmentList;
	}

}
