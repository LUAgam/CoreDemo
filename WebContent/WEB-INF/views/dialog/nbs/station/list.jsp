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

<spring:message code="station.information" var="i18n_stationInformation"/>
<spring:message code="station.name" var="i18n_stationName"/>
<spring:message code="station.numNo" var="i18n_stationNumNo"/>
<spring:message code="station.number" var="i18n_stationNumber"/>
<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="common.content" var="i18n_commonContent"/>

<jvpanel:panelNoTools color="green" title="${i18n_stationInformation}" icon="icon-table">
	<jvlayout:row>

		<jvlayout:col length="12">
			
			<jvpagetable:table url="/dialog/station/list" page="${stationList}" htmlTableId="stationListTable">
				
				<jvpagetable:searchTextItem id="search_stationNo" title="${i18n_stationNumber}" key="stationNo" operat="LIKE" placeholder="${i18n_stationNumber}" value="${SEARCH_stationNo}"></jvpagetable:searchTextItem>		
				<jvpagetable:searchTextItem id="search_stationName" title="${i18n_stationName}" key="stationName" operat="LIKE" placeholder="${i18n_stationName}" value="${SEARCH_stationName}"></jvpagetable:searchTextItem>		
				 
				 <jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>${i18n_lineLine}</jvpagetable:columnheader>
				<jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_stationNumNo}</jvpagetable:columnheader>
				<jvpagetable:column id="stationNo">${entity.stationNo}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_stationName}</jvpagetable:columnheader>
				<jvpagetable:column id="stationName">${entity.stationName}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_commonContent}</jvpagetable:columnheader>
				<jvpagetable:column id="note">${entity.note}</jvpagetable:column>
				
			</jvpagetable:table>
		</jvlayout:col>
	</jvlayout:row>
</jvpanel:panelNoTools>
<!-- /.page-content -->


