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

<spring:message code="fault.type" var="i18n_faultType"/>
<spring:message code="common.code" var="i18n_commonCode"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>
<spring:message code="common.id" var="i18n_commonId"/>

	<jvlayout:row>

		<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_faultType}" icon="icon-table">
			<jvpagetable:table url="/dialog/faulttype/list" page="${faultTypeList}" htmlTableId="faultTypeListTable">
				
				<jvpagetable:searchTextItem id="search_faultCategory" title="${i18n_commonCode}" key="faultCategory" operat="LIKE" placeholder="${i18n_commonCode}" value="${SEARCH_faultCategory}"></jvpagetable:searchTextItem>		
				<jvpagetable:searchTextItem id="search_description" title="${i18n_commonDescroption}" key="description" operat="LIKE" placeholder="${i18n_commonDescroption}" value="${SEARCH_description}"></jvpagetable:searchTextItem>		
				 
				 <jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>${i18n_commonId}</jvpagetable:columnheader>
				<jvpagetable:column id="id">${entity.id}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_commonCode}</jvpagetable:columnheader>
				<jvpagetable:column id="faultCategory">${entity.faultCategory}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
				
			</jvpagetable:table>
			</jvpanel:panelNoTools>
		</jvlayout:col>
	</jvlayout:row>


