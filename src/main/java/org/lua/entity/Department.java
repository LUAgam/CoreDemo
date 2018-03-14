/**
 * (c) 2006 JOVEN
 * 
 * http://www.joven.com.cn
 */
package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Length;

import org.lua.annotation.MetaData;

/**
 * 部门
 * 
 */
@Entity 
@Table(name="tbl_department")
public class Department extends BaseEntity<Department>  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1990267479889920523L;
	

	@MetaData(value="部门名称", comments="部门名称, 不能重复, 不能为空")
	@NotNull
	@Length(max=50)
	@Index(name="idx_department_name")
	private String name;
	
	@MetaData(value="部门编码", comments="部门编码, 不能重复, 不能为空")
	@NotNull
	private String no;
	
	@MetaData(value="部门描述", comments="部门描述" )
	private String description;
	
	/**
	 * 排序
	 */
	@MetaData(value="排序编号", comments="排序编号")
	private int priority;
	
	@MetaData(value="父部门", comments="父部门")
	@ManyToOne(fetch = FetchType.EAGER)
	private Department parentDepartment;
	
	@MetaData(value="是否可用", comments="是否可用")
	private Boolean available = false;

	public Department getParentDepartment() {
		return parentDepartment;
	}

	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
