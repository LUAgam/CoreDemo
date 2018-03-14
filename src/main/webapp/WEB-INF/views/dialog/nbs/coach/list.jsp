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

<spring:message code="coach.message" var="i18n_coachMessage"/>
<spring:message code="coach.carNo1" var="i18n_coachCarNo1"/>
<spring:message code="common.code" var="i18n_commonCode"/>
<spring:message code="common.id" var="i18n_commonId"/>
<spring:message code="coach.carNo2" var="i18n_coachCarNo2"/>
<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="machine.machine" var="i18n_machineMachine"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>

	<jvlayout:row>
		<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_coachMessage}" icon="icon-table">
			<jvpagetable:table url="/dialog/coach/list" page="${coachList}" htmlTableId="coachListTable">
				
				<jvpagetable:searchTextItem id="search_carNo1" title="${i18n_coachCarNo1}" key="carNo1" operat="LIKE" placeholder="${i18n_commonCode}" value="${SEARCH_carNo1}"></jvpagetable:searchTextItem>		
				 
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>${i18n_commonId}</jvpagetable:columnheader>
				<jvpagetable:column id="id">${entity.id}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_coachCarNo1}</jvpagetable:columnheader>
				<jvpagetable:column id="carNo1">${entity.carNo1}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_coachCarNo2}</jvpagetable:columnheader>
				<jvpagetable:column id="carNo2">${entity.carNo2}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_lineLine}</jvpagetable:columnheader>
				<jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_machineMachine}</jvpagetable:columnheader>
				<jvpagetable:column id="machine">${entity.machine.machName}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
				
			</jvpagetable:table>
			</jvpanel:panelNoTools>
		</jvlayout:col>
	</jvlayout:row>
