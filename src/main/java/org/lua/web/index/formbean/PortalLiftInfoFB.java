package org.lua.web.index.formbean;

import org.lua.web.BaseFormBean;

public class PortalLiftInfoFB extends BaseFormBean {
	
	private Long lineId;
	private String lineName;
	
	private Integer runNumber;
	
	private Integer stopRunNumber;
	
	private Integer faultNumber;
	
	private Integer repairNumber;

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

	public Integer getRunNumber() {
		return runNumber;
	}

	public void setRunNumber(Integer runNumber) {
		this.runNumber = runNumber;
	}

	public Integer getStopRunNumber() {
		return stopRunNumber;
	}

	public void setStopRunNumber(Integer stopRunNumber) {
		this.stopRunNumber = stopRunNumber;
	}

	public Integer getFaultNumber() {
		return faultNumber;
	}

	public void setFaultNumber(Integer faultNumber) {
		this.faultNumber = faultNumber;
	}

	public Integer getRepairNumber() {
		return repairNumber;
	}

	public void setRepairNumber(Integer repairNumber) {
		this.repairNumber = repairNumber;
	}
	
}
