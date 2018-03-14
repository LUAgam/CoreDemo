/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.configuration.formbean;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.lua.constant.Constant;
import org.lua.entity.Person;
import org.lua.web.BaseFormBean;
import org.springframework.beans.BeanUtils;


/**
 * 
 *
 * @author       $Author: JHuang $
 * @version      $Revision: 4306 $ $Date: 2014-05-08 18:22:19 +0800 (星期四, 08 五月 2014) $
 */

public class PersonFB extends BaseFormBean {
	
	/**
	 * 注释内容
	 */
	private static final long serialVersionUID = 3965802591884279175L;
	/**
	 * 性别
	 */
	private String gender;
    
	/**
	 * 名称
	 */
	@NotNull
	@Length(max=30)
	private String name;
	
	/**
	 * 工号
	 */
	@Length(max=20)
	private String number;
	/**
	 * 职务
	 */
	private String title;
	/**
	 * 学科
	 */
	private String subject;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String phoneNumber;
	/**
	 * 短号
	 */
	private String shortNumber;
	/**
	 * 办公号码
	 */
	private String officeNumber;
	/**
	 * 办公房间
	 */
	private String officeRoom;
	/**
	 * 所属部门
	 */
	private Long departmentId;
	private String departmentName;
	 //调度代码
    private String code;
    
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getShortNumber() {
		return shortNumber;
	}

	public void setShortNumber(String shortNumber) {
		this.shortNumber = shortNumber;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getOfficeRoom() {
		return officeRoom;
	}

	public void setOfficeRoom(String officeRoom) {
		this.officeRoom = officeRoom;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public static PersonFB toFB(Person person) {
		PersonFB fb = new PersonFB();
		BeanUtils.copyProperties(person,fb);
		if (person.getDepartment() != null) {
			fb.setDepartmentId(person.getDepartment().getId());
			fb.setDepartmentName(person.getDepartment().getName());
		}
		if (person.getGender() != null && Constant.MALE .equals(person.getGender())) {
			fb.setGender("男");
		} else {
			fb.setGender("女");
		}
		return fb;
	}
	
}
