package org.lua.web.configuration.formbean;

import org.hibernate.validator.constraints.NotEmpty;
import org.lua.web.BaseFormBean;

/**
 * 
 *
 * @author      $JKe$
 * @version      $Revision: 4306 $ 2014-1-9下午2:07:06
 **/
public class DepartmentFB extends BaseFormBean {
	/*--------------------------------------------
	 |             C O N S T A N T S             |
	 ============================================*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3293915523582810112L;

	/**
	 * 部门名称
	 */
	@NotEmpty(message = "部门名称不能为空！")
	private String name;
	
	/**
	 * 部门名称
	 */
	@NotEmpty(message = "部门编号不能为空！")
	private String no;
	
	/**
	 * 部门描述
	 */
	private String description;
	
	/**
	 * 排序
	 */
	private int priority;
	
	private Long parentId;
	
	private String parentName;

	private Boolean isSelect=false;
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
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

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Boolean getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Boolean isSelect) {
		this.isSelect = isSelect;
	}
	
	
}
