<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<spring:message code="stat.common.data" var="i18N_scData"/>
<spring:message code="stat.carCondition.service" var="i18N_scarService"/>
<spring:message code="stat.unitMeas.information" var="i18N_suInformation"/>
<spring:message code="stat.carCondition.run.manage" var="i18N_scarrManage"/>
<spring:message code="stat.carCondition.add" var="i18N_scarAdd"/>
<spring:message code="stat.carCondition.late" var="i18N_scarLate"/>
<spring:message code="stat.carCondition.clean" var="i18N_scarClean"/>
<spring:message code="stat.carCondition.rescue" var="i18N_scarRescue"/>
<spring:message code="stat.carCondition.offline" var="i18N_scarOffline"/>
<spring:message code="stat.carCondition.select" var="i18N_scarSelect"/>
<spring:message code="stat.carCondition.process.late" var="i18N_scarpLate"/>
<spring:message code="common.append" var="i18N_cAppend"/>
<spring:message code="common.date" var="i18N_cDate"/>
<spring:message code="common.edit" var="i18N_cEdit"/>
<spring:message code="common.operate" var="i18N_cOperate"/>
<spring:message code="common.delete" var="i18N_cDelete"/>

<spring:message code="stat.common.line" var="i18N_scLine"/>
<spring:message code="stat.common.note" var="i18N_scNote"/>
<spring:message code="stat.carCondition.reason" var="i18N_scarReason"/>
<spring:message code="stat.carCondition.late.time" var="i18N_scarlTime"/>
<spring:message code="stat.carCondition.direction" var="i18N_scarDirection"/>
<spring:message code="stat.carCondition.address" var="i18N_scarAddress"/>
<spring:message code="stat.carCondition.train.number" var="i18N_scartNumber"/>
<spring:message code="stat.common.sequence" var="i18N_scSequence"/>
<spring:message code="stat.carCondition.add.area" var="i18N_scaraArea"/>
<spring:message code="stat.carCondition.run.empty" var="i18N_scarrEmpty"/>
<spring:message code="stat.carCondition.lateTime" var="i18N_scarLateTime"/>
<spring:message code="stat.carCondition.selectAddress" var="i18N_scarSelectAddress"/>
<spring:message code="stat.carCondition.offlineAdress" var="i18N_scarOfflineAddress"/>
<spring:message code="stat.carCondition.rescueAddress" var="i18N_scarRescueAddress"/>
<spring:message code="stat.carCondition.cleanAddress" var="i18N_scarCleanAddress"/>
<spring:message code="line.line" var="i18N_line"/>
<spring:message code="common.time" var="i18N_time"/>
<jvlayout:row>
	<jvlayout:col length="12">
			
			<jvpagetable:table url="/dialog/CarCondition/list/${flag}" page="${carConditionList}" htmlTableId="carConditionAListTable">
				<jvpagetable:toolbarButton isParent="true" color="btn-success" url="${ctx}/carCondition/add/${flag}" icon="icon-plus" title="${i18N_cAppend}"></jvpagetable:toolbarButton>
				
				<jvpagetable:searchTextItem id="dailyListTable_search_line.lineName" title="${i18N_line}" key="line.lineName" 
					operat="LIKE" placeholder="" value="${SEARCH_line_lineName}"></jvpagetable:searchTextItem>
				<jvpagetable:searchDatefield id="importTransferList0Table_search_timeStr" title="${i18N_time}" key="timeStr" value="${SEARCH_timeStr}"></jvpagetable:searchDatefield>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>${i18N_scLine}</jvpagetable:columnheader>
				<jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column> 
				
				<jvpagetable:columnheader>${i18N_cDate}</jvpagetable:columnheader>
				<jvpagetable:column id="timeStr">
					<fmt:formatDate value="${entity.timeStr}" pattern="yyyy-MM-dd"/>
				</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_scartNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="carNo">${entity.carNo}</jvpagetable:column>
				
				 <jvpagetable:columnheader>${i18N_scarAddress}</jvpagetable:columnheader>
				<jvpagetable:column id="station">${entity.station.stationName}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_scarDirection}</jvpagetable:columnheader>
				<jvpagetable:column id="direct">${entity.direct}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_scarlTime}</jvpagetable:columnheader>
				<jvpagetable:column id="delayTime">${entity.delayTime}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_scarReason}</jvpagetable:columnheader>
				<jvpagetable:column id="reason">${entity.reason}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_scNote}</jvpagetable:columnheader>
				<jvpagetable:column id="note">${entity.note}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_cOperate}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
					<A class="btn btn-small btn-warning" href="${ctx}/carCondition/edit/${entity.id}/${flag}" target="_parent">${i18N_cEdit}</A>
					<A class="btn btn-small btn-danger" href="${ctx}/carCondition/delete/${entity.id}/${flag}" target="_parent">${i18N_cDelete}</A>
				</jvpagetable:OptionColumn>
			</jvpagetable:table>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


