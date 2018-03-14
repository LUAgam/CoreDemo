/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.configuration.formbean;

import org.lua.web.BaseFormBean;

/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4277 $ $Date: 2014-04-27 16:12:43 +0800 (星期日, 27 四月 2014) $
 */

public class MailFB extends BaseFormBean {
	private Integer userId;
	
	private String userName;
	
	private String subject;
	
	private String content;
	
	private String tutorName;
	
	private String tutorNumber;
	
	private String studentName;
	
	private String studentNumber;
	
	/**
	 * 收件人列表
	 */
	private String[] checkValues;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String[] getCheckValues() {
		return checkValues;
	}

	public void setCheckValues(String[] checkValues) {
		this.checkValues = checkValues;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getTutorNumber() {
		return tutorNumber;
	}

	public void setTutorNumber(String tutorNumber) {
		this.tutorNumber = tutorNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
}
