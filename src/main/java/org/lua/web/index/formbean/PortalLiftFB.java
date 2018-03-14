package org.lua.web.index.formbean;

import org.lua.web.BaseFormBean;

public class PortalLiftFB extends BaseFormBean {

	private Long lineId;
	private String lineName;
	//自动扶梯数
	private Integer type1Count;
	//无障碍电梯数
	private Integer type2Count;
	//总数
	private Integer liftCount;
	
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

	public Integer getType1Count() {
		return type1Count;
	}

	public void setType1Count(Integer type1Count) {
		this.type1Count = type1Count;
	}

	public Integer getType2Count() {
		return type2Count;
	}

	public void setType2Count(Integer type2Count) {
		this.type2Count = type2Count;
	}

	public Integer getLiftCount() {
		return liftCount;
	}

	public void setLiftCount(Integer liftCount) {
		this.liftCount = liftCount;
	}
	
}
