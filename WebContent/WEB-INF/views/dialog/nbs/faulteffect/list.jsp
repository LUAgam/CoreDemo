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
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>

<spring:message code="fault.effect" var="i18n_faultEffect"/>
<spring:message code="common.code" var="i18n_commonCode"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>
<spring:message code="common.id" var="i18n_commonId"/>
<spring:message code="fault.num" var="i18n_faultNum"/>
<spring:message code="fault.effectLate" var="i18n_faultEffectLate"/>
<spring:message code="fault.effectType" var="i18n_faultEffectType"/>
<spring:message code="fault.effectMain" var="i18n_faultEffectMain"/>
<spring:message code="fault.effectTime" var="i18n_faultEffectTime"/>

	<jvlayout:row>

		<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_faultEffect}" icon="icon-table">
			<jvpagetable:table url="/dialog/faulteffect" page="${faultEffectList}" htmlTableId="faultEffectListTable">
				
				<jvpagetable:searchTextItem id="search_no" title="${i18n_faultNum}" key="no" operat="LIKE" placeholder="${i18n_faultNum}" value="${SEARCH_no}"></jvpagetable:searchTextItem>		
				<jvpagetable:searchTextItem id="search_name" title="${i18n_commonDescroption}" key="name" operat="LIKE" placeholder="${i18n_commonDescroption}" value="${SEARCH_name}"></jvpagetable:searchTextItem>		
				 
				 <jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>${i18n_faultNum}</jvpagetable:columnheader>
				<jvpagetable:column id="no">${entity.no}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}</jvpagetable:column>
				
				
				<jvpagetable:columnheader>所属中心</jvpagetable:columnheader>
				<jvpagetable:column id="centre">${entity.centre.name}</jvpagetable:column>
			</jvpagetable:table>
			</jvpanel:panelNoTools>
		</jvlayout:col>
	</jvlayout:row>

