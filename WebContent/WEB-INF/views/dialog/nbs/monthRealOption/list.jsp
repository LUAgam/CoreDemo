<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="monthPlan.monthPlan" var="i18n_monthPlanMonthPlan"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="department.department" var="i18n_departmentDepartment"/>
<spring:message code="machine.machine" var="i18n_machineMachine"/>

<jvlayout:row>
	<c:if test="${not empty message}">
		<div class="alert alert-danger">
			<strong> <i class="icon-remove"></i> ${i18n_commonMessage}
			</strong> <br /> ${message}
		</div>
	</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_monthPlanMonthPlan}" icon="icon-table">
		<jvpagetable:table htmlTableId="monthRealOptionListTable"
			page="${monthRealOptionList}" url="/dialog/monthRealOption/list">

			<jvpagetable:searchTextItem id="monthRealOptionListTable_search_name"
				title="${i18n_commonName}" key="name" operat="LIKE" placeholder=""
				value="${SEARCH_name}"></jvpagetable:searchTextItem>

			<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
			<jvpagetable:checkColumn></jvpagetable:checkColumn>


			<!--String 控件-->
			<jvpagetable:columnheader>${i18n_departmentDepartment}</jvpagetable:columnheader>
			<jvpagetable:column id="department">${entity.department}</jvpagetable:column>

			<!--String 控件-->
			<jvpagetable:columnheader>${i18n_monthPlanMonthPlan}</jvpagetable:columnheader>
			<jvpagetable:column id="monthPlan">${entity.monthPlan.month}</jvpagetable:column>

			<!--String 控件-->
			<jvpagetable:columnheader>${i18n_machineMachine}</jvpagetable:columnheader>
			<jvpagetable:column id="machine">${entity.machine}</jvpagetable:column>

		</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


