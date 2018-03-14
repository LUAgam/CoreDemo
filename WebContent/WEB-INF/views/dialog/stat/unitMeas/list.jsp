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

<spring:message code="yearPlan.unitMeas.info" var="i18N_yuInfo"/>
<spring:message code="common.descroption" var="i18N_cDescription"/>
<spring:message code="stat.common.number" var="i18N_scNumber"/>

	<jvlayout:row>
		<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18N_yuInfo}" icon="icon-table">
			<jvpagetable:table url="/dialog/unitMeas" page="${unitMeasList}" htmlTableId="unitMeasListTable">
				<jvpagetable:searchTextItem id="search_unitDesc" title="${i18N_cDescription}" key="unitDesc" operat="LIKE" value="${SEARCH_unitDesc}"></jvpagetable:searchTextItem>		
				 
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>${i18N_scNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="unitCode">${entity.unitCode}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_cDescription}</jvpagetable:columnheader>
				<jvpagetable:column id="unitDesc">${entity.unitDesc}</jvpagetable:column>
				
			</jvpagetable:table>
			</jvpanel:panelNoTools>
		</jvlayout:col>
		
	</jvlayout:row>
<!-- /.page-content -->


