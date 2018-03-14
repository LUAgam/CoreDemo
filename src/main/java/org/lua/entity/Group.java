package org.lua.entity;

import org.lua.annotation.MetaData;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * 组 （用于工作流引擎中的经办人，签收人等）相当与职位，
 * @author JHuang
 *
 */
@Entity
@Table(name = "tbl_group", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Group extends BaseEntity<Group> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5088171900646948819L;
	
	@MetaData(value="版本号", comments="版本号")
	@Version
	int version;
	
	@MetaData(value="组编号", comments="组编号" )
	private String no;
	
	@MetaData(value="组名称", comments="组名称")
	@NotNull
	String name;
	
	@MetaData(value="组描述", comments="组描述" )
	private String description;
	
	@MetaData(value="排序", comments="排序")
	int priority;
	
	@MetaData(value="是否可用", comments="是否可用")
	private Boolean available = false;
	
	@MetaData(value="父组", comments="父组")
	@ManyToOne(fetch = FetchType.LAZY)
	private Group parentGroup;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
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

	public Group getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Group parentGroup) {
		this.parentGroup = parentGroup;
	}

	
}
