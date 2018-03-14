<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="monthPlan.message" var="i18n_monthPlanMessage"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="monthPlan.year" var="i18n_monthPlanYear"/>
<spring:message code="monthPlan.month" var="i18n_monthPlanMonth"/>
<spring:message code="monthPlan.times" var="i18n_monthPlanTimes"/>

<jvlayout:row>
	<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong> <i class="icon-remove"></i> ${i18n_commonMessage} </strong> <br />
				${message}
			</div>
		</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_monthPlanMessage}" icon="icon-table">
			<jvpagetable:table htmlTableId="monthPlanListTable" page="${monthPlanList}" url="/dialog/monthPlan/list">
					
				<jvpagetable:searchTextItem id="monthPlanListTable_search_name" title="${i18n_commonName}" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_monthPlanYear}</jvpagetable:columnheader>
					            <jvpagetable:column id="name">${entity.yearPlan.year}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_monthPlanMonth}</jvpagetable:columnheader>
					            <jvpagetable:column id="month">${entity.month}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_monthPlanTimes}</jvpagetable:columnheader>
					            <jvpagetable:column id="times">${entity.times}</jvpagetable:column>
				
			</jvpagetable:table>
			</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


