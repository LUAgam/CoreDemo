<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="yearPlan.info" var="i18n_yearPlanInfo"/>
<spring:message code="yearPlan.yearDU" var="i18n_yearPlanYearDU"/>
<spring:message code="department.department" var="i18n_department"/>
<spring:message code="equip.centre" var="i18n_equipCentre"/>
<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="yearPlan.unitMeas" var="i18n_yearPlanUnitMeas"/>

<jvlayout:row>
	<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong> <i class="icon-remove"></i> ${i18n_commonMessage} </strong> <br />
				${message}
			</div>
		</c:if>

	<jvlayout:col length="12">
			<jvpanel:panelNoTools color="green" title="${i18n_yearPlanInfo}" icon="icon-table">
			<jvpagetable:table htmlTableId="yearPlanListTable" page="${yearPlanList}" url="/dialog/yearPlan/list">
					
				<jvpagetable:searchTextItem id="yearPlanListTable_search_name" title="${i18n_commonName}" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_yearPlanYearDU}</jvpagetable:columnheader>
					            <jvpagetable:column id="name">${entity.year}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_department}</jvpagetable:columnheader>
					            <jvpagetable:column id="department">${entity.department.name}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_equipCentre}</jvpagetable:columnheader>
					            <jvpagetable:column id="centre">${entity.centre.name}</jvpagetable:column>
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_lineLine}</jvpagetable:columnheader>
					            <jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column>
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_yearPlanUnitMeas}</jvpagetable:columnheader>
					            <jvpagetable:column id="unitMeas">${entity.unitMeas.unitDesc}</jvpagetable:column>
		
			</jvpagetable:table>
			</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


