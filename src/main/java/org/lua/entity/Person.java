/**
 * (c) 2009 Shanghai Schick Information Technologies Co., Ltd.
 * 
 * http://www.schickit.com
 */
package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import org.lua.constant.Constant;

/**
 * 人员实体
 * @author JHuang
 */
@Entity 
@Table(name="tbl_person", uniqueConstraints = {@UniqueConstraint(columnNames = "number")})
public class Person extends BaseEntity<Person> {

	
	private static final long serialVersionUID = -6395845029909268781L;
	
	
	/**
	 * 性别
	 */
	private String gender = Constant.MALE;
    
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
	 * 邮箱
	 */
	private String email;
	/**
	 * 手机号码
	 */
	private String phoneNumber;

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
	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;
	
	/**
	 * 离职
	 */
	private boolean dimission = false;
	/**
	 * 版本号
	 */
	@Version
    private int version;
	 /**
     * Image for the person
     */
    private String headImage;
    

	public Person() {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean isDimission() {
		return dimission;
	}

	public void setDimission(boolean dimission) {
		this.dimission = dimission;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
}