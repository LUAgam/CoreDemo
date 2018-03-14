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

<spring:message code="fault.address" var="i18n_faultAddress"/>
<spring:message code="tenant.nubmer" var="i18n_tenantNubmer"/>
<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>

<jvlayout:row>
	<jvlayout:col length="12">
	<jvpanel:panelNoTools color="green" title="${i18n_faultAddress}" icon="icon-table">
		<jvpagetable:table url="/dialog/faultAddress/list" page="${faultAddressList}" htmlTableId="faultAddressListTable">
			<jvpagetable:searchTextItem id="search_no" title="${i18n_tenantNubmer}" key="no" operat="LIKE" placeholder="${i18n_tenantNubmer}" value="${SEARCH_no}"></jvpagetable:searchTextItem>		
			<jvpagetable:searchTextItem id="search_line.lineName" title="${i18n_lineLine}" key="line.lineName" operat="LIKE" placeholder="${i18n_lineLine}" value="${SEARCH_line_lineName}"></jvpagetable:searchTextItem>		
			<jvpagetable:searchTextItem id="search_name" title="${i18n_commonName}" key="name" operat="LIKE" placeholder="${i18n_commonName}" value="${SEARCH_name}"></jvpagetable:searchTextItem>		
			
			 <jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
			<jvpagetable:checkColumn></jvpagetable:checkColumn>
			
			<jvpagetable:columnheader>${i18n_lineLine}</jvpagetable:columnheader>
			<jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18n_tenantNubmer}</jvpagetable:columnheader>
			<jvpagetable:column id="no">${entity.no}</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18n_commonName}</jvpagetable:columnheader>
			<jvpagetable:column id="name">${entity.name}</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
			<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
		</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
