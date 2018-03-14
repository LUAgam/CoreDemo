/**
 * 
 */
package org.lua.web.index.formbean;

import org.lua.web.BaseFormBean;

/**
 * @author WLL
 *
 */
public class PortalFaultInfoFB extends BaseFormBean {
	
	private Long lineId;
	private String lineName;

	private Integer zdftNum;
	private Integer wzadtNum;
	
	private Integer yearNum;
	
	public Integer getYearNum() {
		return yearNum;
	}
	public void setYearNum(Integer yearNum) {
		this.yearNum = yearNum;
	}
	public Long getLineId() {
		return lineId;
	}
	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public Integer getZdftNum() {
		return zdftNum;
	}
	public void setZdftNum(Integer zdftNum) {
		this.zdftNum = zdftNum;
	}
	public Integer getWzadtNum() {
		return wzadtNum;
	}
	public void setWzadtNum(Integer wzadtNum) {
		this.wzadtNum = wzadtNum;
	}
}
