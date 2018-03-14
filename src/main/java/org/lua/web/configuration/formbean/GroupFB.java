/**
 *        (c) 2006 JOVEN
 *
 *        http://www.joven.com.cn
 */

package org.lua.web.configuration.formbean;

import org.hibernate.validator.constraints.NotBlank;
import org.lua.annotation.MetaData;
import org.lua.entity.Group;
import org.lua.web.BaseFormBean;
import org.springframework.beans.BeanUtils;


/**
 * 
 * @author ZZWang
 * @Time 2017年3月29日 下午2:37:46
 *
 */
public class GroupFB extends BaseFormBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5911472535433707837L;

	@NotBlank(message="组编号不能为空")
	@MetaData(value = "组编号", comments = "组编号")
	private String no;

	@MetaData(value = "组名称", comments = "组名称")
	@NotBlank(message="名称不能为空")
	String name;

	@MetaData(value = "组描述", comments = "组描述")
	private String description;

	@MetaData(value = "排序", comments = "排序")
	int priority;

	@MetaData(value = "是否可用", comments = "是否可用")
	private Boolean available = false;

	@MetaData(value = "父组", comments = "父组")
	private Long parentGroupId;

	@MetaData(value = "父组", comments = "父组")
	private String parentGroupName;

	@MetaData(value = "部门是否拥有该岗位")
	private Boolean isSelect;
	
	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getPriority() {
		return priority;
	}

	public Boolean getAvailable() {
		return available;
	}

	public Long getParentGroupId() {
		return parentGroupId;
	}

	public String getParentGroupName() {
		return parentGroupName;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public void setParentGroupId(Long parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	public void setParentGroupName(String parentGroupName) {
		this.parentGroupName = parentGroupName;
	}

	public Boolean getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Boolean isSelect) {
		this.isSelect = isSelect;
	}

	public static GroupFB toFB(Group entity) {
		GroupFB groupFB = new GroupFB();
		BeanUtils.copyProperties(entity,groupFB);
		if (entity.getParentGroup() != null) {
			groupFB.setParentGroupId(entity.getParentGroup().getId());
			groupFB.setParentGroupName(entity.getParentGroup().getName());
		}
		return groupFB;

	}

}
