/**
 * 
 */
package org.lua.web.index.formbean;

import org.lua.web.BaseFormBean;

/**
 * @author WLL
 *
 */
public class PortalLiftPersonFB extends BaseFormBean {

	private String name;
	
	private Integer num;
	
	private Double percentNum;

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

	public Double getPercentNum() {
		return percentNum;
	}

	public void setPercentNum(Double percentNum) {
		this.percentNum = percentNum;
	}
}
