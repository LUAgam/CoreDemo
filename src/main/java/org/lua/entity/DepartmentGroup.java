/**
 * 
 */
package org.lua.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.lua.annotation.MetaData;

/**
 * 
 * @author ZZWang
 * @Time 2017年3月30日  下午5:29:28
 *
 */
@Entity 
@Table(name="tbl_department_group")
public class DepartmentGroup extends BaseEntity<DepartmentGroup>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7963444945373775553L;

	@ManyToOne(fetch = FetchType.EAGER)
	public Department dep;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="gro")
	public Group group;
	
	@NotNull
	@MetaData(value="部门岗位编号", comments="部门岗位编号" )
	private String no;
	
	@Version
	private int version;

	public Department getDep() {
		return dep;
	}


	public Group getGroup() {
		return group;
	}


	public int getVersion() {
		return version;
	}


	public void setDep(Department dep) {
		this.dep = dep;
	}


	public void setGroup(Group group) {
		this.group = group;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	

}
