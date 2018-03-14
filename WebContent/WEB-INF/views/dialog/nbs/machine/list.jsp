<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="machine.message" var="i18n_machineMessage"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="machine.code" var="i18n_machineCode"/>
<spring:message code="machine.name" var="i18n_machineName"/>
<spring:message code="machine.type" var="i18n_machineType"/>
<spring:message code="machine.machineType" var="i18n_machineMachineType"/>

<jvlayout:row>
	<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong> <i class="icon-remove"></i> ${i18n_commonMessage}</strong> <br />
				${message}
			</div>
		</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_machineMessage}" icon="icon-table">
			<jvpagetable:table htmlTableId="machineListTable" page="${machineList}" url="/dialog/machine/list">
					
				<%-- <jvpagetable:searchTextItem id="machineListTable_search_name" title="名称" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				 --%>
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_machineCode}</jvpagetable:columnheader>
					            <jvpagetable:column id="machCode">${entity.machCode}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_machineName}</jvpagetable:columnheader>
					            <jvpagetable:column id="name">${entity.machName}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_machineType}</jvpagetable:columnheader>
					            <jvpagetable:column id="type">${entity.type}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_machineMachineType}</jvpagetable:columnheader>
					            <jvpagetable:column id="machineType">${entity.machineType.name}</jvpagetable:column>
		
			</jvpagetable:table>
			</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


