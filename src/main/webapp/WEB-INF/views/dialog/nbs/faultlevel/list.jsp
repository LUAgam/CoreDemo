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

<spring:message code="fault.level" var="i18n_faultLevel"/>
<spring:message code="common.code" var="i18n_commonCode"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>
<spring:message code="common.id" var="i18n_commonId"/>

<jvlayout:row>

	<jvlayout:col length="12">
	<jvpanel:panelNoTools color="green" title="${i18n_faultLevel}" icon="icon-table">
		<jvpagetable:table url="/dialog/faultlevel/list" page="${faultLevelList}" htmlTableId="faultlevelListTable">
			
			<jvpagetable:searchTextItem id="search_levelNo" title="${i18n_commonCode}" key="levelNo" operat="LIKE" placeholder="${i18n_commonCode}" value="${SEARCH_levelNo}"></jvpagetable:searchTextItem>		
			<jvpagetable:searchTextItem id="search_description" title="${i18n_commonDescroption}" key="description" operat="LIKE" placeholder="${i18n_commonDescroption}" value="${SEARCH_description}"></jvpagetable:searchTextItem>		
			 
			 <jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
			<jvpagetable:checkColumn></jvpagetable:checkColumn>
			
			<jvpagetable:columnheader>${i18n_commonId}</jvpagetable:columnheader>
			<jvpagetable:column id="id">${entity.id}</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18n_commonCode}</jvpagetable:columnheader>
			<jvpagetable:column id="levelNo">${entity.levelNo}</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
			<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
			
		</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>


