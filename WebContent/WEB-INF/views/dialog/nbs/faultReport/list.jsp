<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="fault.report" var="i18n_faultReport"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="date.YYYYMMDD" var="i18n_YYYYMMDD"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="fault.deptNo" var="i18n_faultDeptNo"/>
<spring:message code="fault.machine" var="i18n_faultMachine"/>
<spring:message code="fault.fault" var="i18n_faultFault"/>
<spring:message code="fault.faultEffect" var="i18n_faultFaultEffect"/>
<spring:message code="fault.reportedBy" var="i18n_faultReportedBy"/>
<spring:message code="fault.reportTime" var="i18n_faultReportTime"/>
<spring:message code="fault.faultOccurTime" var="i18n_faultFaultOccurTime"/>
<spring:message code="fault.priority" var="i18n_faultPriority"/>
<spring:message code="fault.faultType" var="i18n_faultFaultType"/>
<spring:message code="fault.raultSource" var="i18n_faultRaultSource"/>
<spring:message code="fault.faultLevel" var="i18n_faultFaultLevel"/>
<spring:message code="fault.finishReportBy" var="i18n_faultFinishReportBy"/>
<spring:message code="fault.finishReportTime" var="i18n_faultFinishReportTime"/>
<spring:message code="fault.line" var="i18n_faultLine"/>
<spring:message code="fault.stationNo" var="i18n_faultStationNo"/>
<spring:message code="fault.endStationNo" var="i18n_faultEndStationNo"/>
<spring:message code="fault.areaType" var="i18n_faultAreaType"/>
<spring:message code="fault.receivedBy" var="i18n_faultRreceivedBy"/>
<spring:message code="fault.receiveTime" var="i18n_faultReceiveTime"/>
<spring:message code="fault.faultTime" var="i18n_faultFaultTime"/>
<spring:message code="fault.repairTime" var="i18n_faultRepairTime"/>
<spring:message code="fault.note" var="i18n_faultNote"/>
<spring:message code="fault.reportNote" var="i18n_faultReportNote"/>
<spring:message code="fault.startTime" var="i18n_faultStartTime"/>
<spring:message code="fault.finishTime" var="i18n_faultFinishTime"/>
<spring:message code="fault.dealPerson" var="i18n_faultDealPerson"/>
<spring:message code="fault.faultReason" var="i18n_faultFaultReason"/>
<spring:message code="fault.materialConsume" var="i18n_faultMaterialConsume"/>
<spring:message code="fault.workHours" var="i18n_faultWorkHours"/>
<spring:message code="fault.isCount" var="i18n_faultIsCount"/>
<spring:message code="fault.coach" var="i18n_faultCoach"/>
<spring:message code="fault.treaResult" var="i18n_faultRreaResult"/>
<spring:message code="fault.followMeasures" var="i18n_faultFollowMeasures"/>
<spring:message code="fault.faultPic" var="i18n_faultFaultPic"/>
<spring:message code="fault.faultAnalysis" var="i18n_faultFaultAnalysis"/>
<spring:message code="fault.orgStartTime" var="i18n_faultOrgStartTime"/>
<spring:message code="fault.orgFinishTime" var="i18n_faultOrgFinishTime"/>
<spring:message code="fault.orgEffectReason" var="i18n_faultOrgEffectReason"/>
<spring:message code="fault.personNumber" var="i18n_faultPersonNumber"/>

<jvlayout:row>
	<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong> <i class="icon-remove"></i> ${i18n_commonMessage}</strong> <br />
				${message}
			</div>
		</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_faultReport}" icon="icon-table">
			<jvpagetable:table htmlTableId="faultReportListTable" page="${faultReportList}" url="/dialog/faultReport/list">
					
				<jvpagetable:searchTextItem id="faultReportListTable_search_name" title="${i18n_commonName}" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultDeptNo}</jvpagetable:columnheader>
					            <jvpagetable:column id="deptNo">${entity.deptNo}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultMachine}</jvpagetable:columnheader>
					            <jvpagetable:column id="machine">${entity.machine}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFault}</jvpagetable:columnheader>
					            <jvpagetable:column id="fault">${entity.fault}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFaultEffect}</jvpagetable:columnheader>
					            <jvpagetable:column id="faultEffect">${entity.faultEffect}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultReportedBy}</jvpagetable:columnheader>
					            <jvpagetable:column id="reportedBy">${entity.reportedBy}</jvpagetable:column>
		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultReportTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="reportTime"><fmt:formatDate value="${entity.reportTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultFaultOccurTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="faultOccurTime"><fmt:formatDate value="${entity.faultOccurTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultPriority}</jvpagetable:columnheader>
					            <jvpagetable:column id="priority">${entity.priority}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFaultType}</jvpagetable:columnheader>
					            <jvpagetable:column id="faultType">${entity.faultType}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultRaultSource}</jvpagetable:columnheader>
					            <jvpagetable:column id="raultSource">${entity.raultSource}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFaultLevel}</jvpagetable:columnheader>
					            <jvpagetable:column id="faultLevel">${entity.faultLevel}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFinishReportBy}</jvpagetable:columnheader>
					            <jvpagetable:column id="finishReportBy">${entity.finishReportBy}</jvpagetable:column>
		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultFinishReportTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="finishReportTime"><fmt:formatDate value="${entity.finishReportTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultLine}</jvpagetable:columnheader>
					            <jvpagetable:column id="line">${entity.line}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultStationNo}</jvpagetable:columnheader>
					            <jvpagetable:column id="stationNo">${entity.stationNo}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultEndStationNo}</jvpagetable:columnheader>
					            <jvpagetable:column id="endStationNo">${entity.endStationNo}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultAreaType}</jvpagetable:columnheader>
					            <jvpagetable:column id="areaType">${entity.areaType}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultRreceivedBy}</jvpagetable:columnheader>
					            <jvpagetable:column id="receivedBy">${entity.receivedBy}</jvpagetable:column>
		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultReceiveTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="receiveTime"><fmt:formatDate value="${entity.receiveTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFaultTime}</jvpagetable:columnheader>
					            <jvpagetable:column id="faultTime">${entity.faultTime}</jvpagetable:column>
		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultRepairTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="repairTime"><fmt:formatDate value="${entity.repairTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultNote}</jvpagetable:columnheader>
					            <jvpagetable:column id="note">${entity.note}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultReportNote}</jvpagetable:columnheader>
					            <jvpagetable:column id="reportNote">${entity.reportNote}</jvpagetable:column>
		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultStartTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="startTime"><fmt:formatDate value="${entity.startTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultFinishTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="finishTime"><fmt:formatDate value="${entity.finishTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultDealPerson}</jvpagetable:columnheader>
					            <jvpagetable:column id="dealPerson">${entity.dealPerson}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFaultReason}</jvpagetable:columnheader>
					            <jvpagetable:column id="faultReason">${entity.faultReason}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultMaterialConsume}</jvpagetable:columnheader>
					            <jvpagetable:column id="materialConsume">${entity.materialConsume}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultWorkHours}</jvpagetable:columnheader>
					            <jvpagetable:column id="workHours">${entity.workHours}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultIsCount}</jvpagetable:columnheader>
					            <jvpagetable:column id="isCount">${entity.isCount}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultCoach}</jvpagetable:columnheader>
					            <jvpagetable:column id="coach">${entity.coach}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultRreaResult}</jvpagetable:columnheader>
					            <jvpagetable:column id="treaResult">${entity.treaResult}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFollowMeasures}</jvpagetable:columnheader>
					            <jvpagetable:column id="followMeasures">${entity.followMeasures}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFaultPic}</jvpagetable:columnheader>
					            <jvpagetable:column id="faultPic">${entity.faultPic}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultFaultAnalysis}</jvpagetable:columnheader>
					            <jvpagetable:column id="faultAnalysis">${entity.faultAnalysis}</jvpagetable:column>
		
													<!--Date 日期控件-->
    							<jvpagetable:columnheader>${i18n_faultOrgStartTime}</jvpagetable:columnheader>	
    							<jvpagetable:column id="orgStartTime"><fmt:formatDate value="${entity.orgStartTime}" pattern="${i18n_YYYYMMDD}" /></jvpagetable:column>

		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultOrgFinishTime}</jvpagetable:columnheader>
					            <jvpagetable:column id="orgFinishTime">${entity.orgFinishTime}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultOrgEffectReason}</jvpagetable:columnheader>
					            <jvpagetable:column id="orgEffectReason">${entity.orgEffectReason}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_faultPersonNumber}</jvpagetable:columnheader>
					            <jvpagetable:column id="personNumber">${entity.personNumber}</jvpagetable:column>
				
				
			</jvpagetable:table>
			</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


