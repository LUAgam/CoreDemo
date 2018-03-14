<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>

<spring:message code="common.delete" var="i18n_commonDelete"/>
<spring:message code="common.option" var="i18n_commonOption"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="date.YMDHM" var="i18n_YMDHM"/>
<spring:message code="equip.major" var="i18n_equipMajor"/>
<spring:message code="equip.type" var="i18n_equipType"/>
<spring:message code="fault.reportEdit" var="i18n_faultReportEdit"/>
<spring:message code="fault.faultList" var="i18n_faultFaultList"/>
<spring:message code="fault.reportNo" var="i18n_faultReportNo"/>
<spring:message code="fault.show" var="i18n_faultShow"/>
<spring:message code="fault.status" var="i18n_faultStatus"/>
<spring:message code="fault.detailMessage" var="i18n_faultDetailMessage"/>
<spring:message code="fault.type" var="i18n_faultType"/>
<spring:message code="fault.address" var="i18n_faultAddress"/>
<spring:message code="fault.editTime" var="i18n_faultEditTime"/>
<spring:message code="fault.waterNum" var="i18n_faultWaterNum"/>
<spring:message code="fault.happenTime" var="i18n_faultHappenTime"/>
<spring:message code="fault.closeFlag" var="i18n_faultCloseFlag"/>
<spring:message code="fault.closeYes" var="i18n_faultCloseYes"/>
<spring:message code="fault.closeNo" var="i18n_faultCloseNo"/>
<spring:message code="fault.equipCode" var="i18n_faultEquipCode"/>
<spring:message code="fault.editPerson" var="i18n_faultEditPerson"/>
<spring:message code="fault.happenPerson" var="i18n_faultHappenPerson"/>
<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="widget.form.change" var="i18n_widgetFormChange"/>

<jvlayout:row>
	<jvlayout:col length="12">
		<jvpagetable:table url="/dialog/faultReport/againList/${type}" page="${centreReportList}" htmlTableId="centreReportListTable">
				
				 <!-- 查询条件 -->
				  <c:if test="${type eq 'C'}">
				 <jvpagetable:searchTextItem id="dailyListTable_search_report.no" title="${i18n_faultWaterNum}" key="report.no" operat="LIKE" placeholder="" value="${SEARCH_report_no}"></jvpagetable:searchTextItem>
				 </c:if>
				 <c:if test="${type != 'C'}">
				 <jvpagetable:searchTextItem id="dailyListTable_search_report.number" title="${i18n_faultReportNo}" key="report.number" operat="LIKE" placeholder="" value="${SEARCH_report_number}"></jvpagetable:searchTextItem>
				 </c:if>
				 <jvpagetable:searchTextItem id="dailyListTable_search_report.fault.symptomCode" title="${i18n_faultShow}" key="report.fault.symptomCode" operat="LIKE" placeholder="" value="${SEARCH_report_fault_symptomCode}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_report.faultDescTwo" title="${i18n_faultDetailMessage}" key="report.faultDescTwo" operat="LIKE" placeholder="" value="${SEARCH_report_faultDescTwo}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_report.faultType.faultCategory" title="${i18n_faultType}" key="report.faultType.faultCategory" operat="LIKE" placeholder="" value="${SEARCH_report_faultType_faultCategory}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_report.station.name" title="${i18n_faultAddress}" key="report.station.name" operat="LIKE" placeholder="" value="${SEARCH_report_station_name}"></jvpagetable:searchTextItem>
				<jvpagetable:searchTextItem id="dailyListTable_search_cause" title="故障原因" key="cause" operat="LIKE" placeholder="" value="${SEARCH_cause}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_team.name" title="班组" key="teamName" operat="LIKE" placeholder="" value="${SEARCH_teamName}"></jvpagetable:searchTextItem>
				 
				 <jvpagetable:searchSelectOption options="${statusCentreList}" value="${SEARCH_status}" key="status" title="${i18n_faultStatus}" id="status"></jvpagetable:searchSelectOption>
				 <jvpagetable:searchSelectEntity options="${lineList}" value="${SEARCH_report_line_id}" key="report.line.id" title="${i18n_lineLine}" id="line_id" idField="id" nameField="lineName"></jvpagetable:searchSelectEntity>
				 
				 <jvpagetable:searchDatetimeRange key="report.happenDate" title="${i18n_faultHappenTime}" id="report.happenDate" startDate="${SEARCH_START_report_happenDate}" endDate="${SEARCH_END_report_happenDate}"></jvpagetable:searchDatetimeRange>	
				 
				 <!-- 部门专业设备类别 -->
				 <jvpagetable:searchTextItem id="dailyListTable_search_centre.name" title="中心" key="centre.name" operat="LIKE" placeholder="" value="${SEARCH_centre_name}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_equipType.equipType.name" title="专业" key="equipType.equipType.name" operat="LIKE" placeholder="" value="${SEARCH_equipType_equipType_name}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_equipType.name" title="设备类别" key="equipType.name" operat="LIKE" placeholder="" value="${SEARCH_equipType_name}"></jvpagetable:searchTextItem>
				 
				  <jvpagetable:toolbarExportButton></jvpagetable:toolbarExportButton>
				<!--String 控件-->
 				<jvpagetable:columnheader>${type eq 'C' ? i18n_faultWaterNum : i18n_faultReportNo}</jvpagetable:columnheader> 
		            <jvpagetable:column id="number">
		            <a href="${ctx}/fill/lookOne/${entity.report.id}" target="_parent">${type eq 'C' ? entity.report.no : entity.report.number}</a>
		            </jvpagetable:column>
		         
					<!--Date 日期控件-->
						<jvpagetable:columnheader>${i18n_faultHappenTime}</jvpagetable:columnheader>	
						<jvpagetable:column id="happenDate"><fmt:formatDate value="${entity.report.happenDate}" pattern="${i18n_YMDHM}" /></jvpagetable:column>
				
					<!--String 控件-->
						<jvpagetable:columnheader>${i18n_lineLine}</jvpagetable:columnheader>
		            <jvpagetable:column id="line">${entity.report.line.lineName}</jvpagetable:column>
		            
					<!--String 控件-->
						<jvpagetable:columnheader>${i18n_faultAddress}</jvpagetable:columnheader>
		            <jvpagetable:column id="station">${entity.report.station.name}</jvpagetable:column>
					
					<!--String 控件-->
						<jvpagetable:columnheader>${i18n_faultShow}</jvpagetable:columnheader>
		            <jvpagetable:column id="fault">${entity.report.fault.symptomCode}</jvpagetable:column>
					
					<!--String 控件-->
						<jvpagetable:columnheader>${i18n_faultDetailMessage}</jvpagetable:columnheader>
		            <jvpagetable:column id="faultDesc">${entity.report.faultDescTwo}</jvpagetable:column>
						<jvpagetable:columnheader>${i18n_equipMajor}</jvpagetable:columnheader>
		            <jvpagetable:column id="equipTypeName">${entity.equipType.equipType.name}</jvpagetable:column>
					
						<jvpagetable:columnheader>${i18n_equipType}</jvpagetable:columnheader>
		            <jvpagetable:column id="equipTypeEquipType">${entity.equipType.name}</jvpagetable:column>
					
					<!--String 控件-->
						<jvpagetable:columnheader>${i18n_faultCloseFlag}</jvpagetable:columnheader>
		            <jvpagetable:column id="closeFalg">
		            	<c:if test="${entity.report.closeFalg}">${i18n_faultCloseYes}</c:if>
		            	<c:if test="${!entity.report.closeFalg}">${i18n_faultCloseNo}</c:if>
		            </jvpagetable:column>
					
					<!--String 控件-->
						<jvpagetable:columnheader>${i18n_faultType}</jvpagetable:columnheader>
		            <jvpagetable:column id="faultType">${entity.report.faultType.faultCategory}</jvpagetable:column>
					
					<!--String 控件-->
						<jvpagetable:columnheader>${i18n_faultEquipCode}</jvpagetable:columnheader>
		            <jvpagetable:column id="equipNumber">${entity.report.equipNumber}</jvpagetable:column>
					
					<!--String 控件-->
					<%-- 	<jvpagetable:columnheader>${i18n_faultEditPerson}</jvpagetable:columnheader>
		            <jvpagetable:column id="reportUser">${entity.report.reportUser.person.name}</jvpagetable:column>
					 --%>
						<jvpagetable:columnheader>${i18n_faultHappenPerson}</jvpagetable:columnheader>
		            <jvpagetable:column id="reoprtPersonBy">${entity.report.reoprtPersonBy}</jvpagetable:column>
					
		            
		            <jvpagetable:columnheader>${i18n_faultStatus}</jvpagetable:columnheader>
		            <jvpagetable:column id="status">${entity.status}</jvpagetable:column>
			</jvpagetable:table> 
	</jvlayout:col>
</jvlayout:row>