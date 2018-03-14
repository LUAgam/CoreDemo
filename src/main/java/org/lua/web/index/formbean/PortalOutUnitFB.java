/**
 * 
 */
package org.lua.web.index.formbean;

import org.lua.web.BaseFormBean;

/**
 * @author WLL
 *
 */
public class PortalOutUnitFB extends BaseFormBean {

	private Long outUnitId;
	private String name;
	
	private Integer num;

	public Long getOutUnitId() {
		return outUnitId;
	}

	public void setOutUnitId(Long outUnitId) {
		this.outUnitId = outUnitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
