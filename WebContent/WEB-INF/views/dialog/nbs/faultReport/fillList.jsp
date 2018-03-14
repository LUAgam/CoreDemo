<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>

<spring:message code="widget.form.add" var="i18n_widgetFormAdd"/>
<spring:message code="widget.form.change" var="i18n_widgetFormChange"/>
<spring:message code="common.delete" var="i18n_commonDelete"/>
<spring:message code="fault.reportEdit" var="i18n_faultReportEdit"/>
<spring:message code="fault.faultList" var="i18n_faultFaultList"/>
<spring:message code="fault.waterNum" var="i18n_faultWaterNum"/>
<spring:message code="fault.reportNo" var="i18n_faultReportNo"/>
<spring:message code="fault.show" var="i18n_faultShow"/>
<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="fault.status" var="i18n_faultStatus"/>
<spring:message code="fault.detailMessage" var="i18n_faultDetailMessage"/>
<spring:message code="fault.type" var="i18n_faultType"/>
<spring:message code="fault.address" var="i18n_faultAddress"/>
<spring:message code="fault.editTime" var="i18n_faultEditTime"/>
<spring:message code="fault.depaCentre" var="i18n_faultDepaCentre"/>
<spring:message code="date.YMDHM" var="i18n_YMDHM"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="fault.happenTime" var="i18n_faultHappenTime"/>
<spring:message code="fault.closeFlag" var="i18n_faultCloseFlag"/>
<spring:message code="fault.closeYes" var="i18n_faultCloseYes"/>
<spring:message code="fault.closeNo" var="i18n_faultCloseNo"/>
<spring:message code="fault.equipCode" var="i18n_faultEquipCode"/>
<spring:message code="fault.editPerson" var="i18n_faultEditPerson"/>
<spring:message code="fault.happenPerson" var="i18n_faultHappenPerson"/>
<spring:message code="common.option" var="i18n_commonOption"/>

<jvlayout:row>
	<jvlayout:col length="12">
		<jvpagetable:table url="/dialog/faultReport/fillList/${type}/${flag}" page="${faultReportList}" htmlTableId="faultReportListTable">
				
				 <!-- 查询条件 -->
				 <c:if test="${type eq 'C'}">
				 <jvpagetable:searchTextItem id="dailyListTable_search_no" title="${i18n_faultWaterNum}" key="no" operat="LIKE" placeholder="" value="${SEARCH_no}"></jvpagetable:searchTextItem>
				 </c:if>
				 <c:if test="${type != 'C'}">
				 <jvpagetable:searchTextItem id="dailyListTable_search_number" title="${i18n_faultReportNo}" key="number" operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>
				 </c:if>
				 <jvpagetable:searchTextItem id="dailyListTable_search_fault.symptomCode" title="${i18n_faultShow}" key="fault.symptomCode" operat="LIKE" placeholder="" value="${SEARCH_fault_symptomCode}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_faultDescTwo" title="${i18n_faultDetailMessage}" key="faultDescTwo" operat="LIKE" placeholder="" value="${SEARCH_faultDescTwo}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_faultType.faultCategory" title="${i18n_faultType}" key="faultType.faultCategory" operat="LIKE" placeholder="" value="${SEARCH_faultType_faultCategory}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_station.name" title="${i18n_faultAddress}" key="station.name" operat="LIKE" placeholder="" value="${SEARCH_station_name}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_cause" title="故障原因" key="cause" operat="LIKE" placeholder="" value="${SEARCH_cause}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchSelectOption options="${statusList}" value="${SEARCH_status}" key="status" title="${i18n_faultStatus}" id="status"></jvpagetable:searchSelectOption>
				 <jvpagetable:searchSelectEntity options="${lineList}" value="${SEARCH_line_id}" key="line.id" title="${i18n_lineLine}" id="line_id" idField="id" nameField="lineName"></jvpagetable:searchSelectEntity>
				 
				  <jvpagetable:searchTextItem id="dailyListTable_search_dept.name" title="部门" key="dept" operat="LIKE" placeholder="" value="${SEARCH_dept}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_centre.name" title="中心" key="centre" operat="LIKE" placeholder="" value="${SEARCH_centre}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_major.name" title="专业" key="major" operat="LIKE" placeholder="" value="${SEARCH_major}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_machine.Type" title="设备类别" key="machineType" operat="LIKE" placeholder="" value="${SEARCH_machineType}"></jvpagetable:searchTextItem>
				 <jvpagetable:searchTextItem id="dailyListTable_search_team.name" title="班组" key="teamName" operat="LIKE" placeholder="" value="${SEARCH_teamName}"></jvpagetable:searchTextItem>
				 
				 <jvpagetable:searchDatetimeRange key="happenDate" title="${i18n_faultHappenTime}" id="happenDate" startDate="${SEARCH_START_happenDate}" endDate="${SEARCH_END_happenDate}"></jvpagetable:searchDatetimeRange>	
				 
				 <jvpagetable:toolbarExportButton></jvpagetable:toolbarExportButton>
				 
				<!--String 控件-->
 					<jvpagetable:columnheader>${type eq 'C' ? '流水号' : i18n_faultReportNo} </jvpagetable:columnheader>
		            <jvpagetable:column id="number">
		            <a href="${ctx}/fill/lookOne/${entity.id}" target="_parent">${type eq 'C' ? entity.no : entity.number}</a>
		            </jvpagetable:column>
		            
					<!--Date 日期控件-->
 					<jvpagetable:columnheader>${i18n_faultHappenTime}</jvpagetable:columnheader>	
 					<jvpagetable:column id="happenDate"><fmt:formatDate value="${entity.happenDate}" pattern="${i18n_YMDHM}" /></jvpagetable:column>
				
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_lineLine}</jvpagetable:columnheader>
		            <jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column>
		            
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_faultAddress}</jvpagetable:columnheader>
		            <jvpagetable:column id="station">${entity.station.name}</jvpagetable:column>
					
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_faultShow}</jvpagetable:columnheader>
		            <jvpagetable:column id="fault">${entity.fault.symptomCode}</jvpagetable:column>
					
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_faultDetailMessage}</jvpagetable:columnheader>
		            <jvpagetable:column id="faultDesc">${entity.faultDescTwo}</jvpagetable:column>
					
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_faultCloseFlag}</jvpagetable:columnheader>
		            <jvpagetable:column id="closeFalg">
		            	<c:if test="${entity.closeFalg}">${i18n_faultCloseYes}</c:if>
		            	<c:if test="${!entity.closeFalg}">${i18n_faultCloseNo}</c:if>
		            </jvpagetable:column>
					
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_faultType}</jvpagetable:columnheader>
		            <jvpagetable:column id="faultType">${entity.faultType.faultCategory}</jvpagetable:column>
					
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_faultEquipCode}</jvpagetable:columnheader>
		            <jvpagetable:column id="equipNumber">${entity.equipNumber}</jvpagetable:column>
					
					<!--String 控件-->
 					<%-- <jvpagetable:columnheader>${i18n_faultEditPerson}</jvpagetable:columnheader>
		            <jvpagetable:column id="reportUser">${entity.reportUser.person.name}</jvpagetable:column> --%>
					
 					<jvpagetable:columnheader>${i18n_faultHappenPerson}</jvpagetable:columnheader>
		            <jvpagetable:column id="reoprtPersonBy">${entity.reoprtPersonBy}</jvpagetable:column>
					
		            
		            <jvpagetable:columnheader>${i18n_faultStatus}</jvpagetable:columnheader>
		            <jvpagetable:column id="status">${entity.status}</jvpagetable:column>
					
				
				<jvpagetable:columnheader>${i18n_commonOption}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
				<!-- 如果为C类故障，只能修改自己的 -->
				<c:if test="${entity.faultType.faultCategory eq 'C'}">
					<c:if test="${user.id eq entity.reportUser.id}">
						<shiro:hasPermission name="LIST_EDIT">
							<A class="btn btn-small btn-warning" href="${ctx}/fill/edit/${entity.id}" target="_parent">${i18n_widgetFormChange}</A>
						</shiro:hasPermission>	
						<shiro:hasPermission name="LIST_DELETE">
							<A class="btn btn-small btn-danger" href="${ctx}/fill/delete/${entity.id}" target="_parent">${i18n_commonDelete}</A>
						</shiro:hasPermission>
					</c:if>
				</c:if>
				<!-- AB类故障不做控制 -->
				<c:if test="${entity.faultType.faultCategory != 'C'}">
					<shiro:hasPermission name="LIST_EDIT">
						<A class="btn btn-small btn-warning" href="${ctx}/fill/edit/${entity.id}" target="_parent">${i18n_widgetFormChange}</A>
					</shiro:hasPermission>	
					<shiro:hasPermission name="LIST_DELETE">
						<A class="btn btn-small btn-danger" href="${ctx}/fill/delete/${entity.id}" target="_parent">${i18n_commonDelete}</A>
					</shiro:hasPermission>
				</c:if>
				</jvpagetable:OptionColumn>
			</jvpagetable:table> 
	</jvlayout:col>
</jvlayout:row>