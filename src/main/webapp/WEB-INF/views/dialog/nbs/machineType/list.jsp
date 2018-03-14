<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="machine.type" var="i18n_machineType"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>

<jvlayout:row>
	<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong> <i class="icon-remove"></i> ${i18n_commonMessage}</strong> <br />
				${message}
			</div>
		</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_machineType}" icon="icon-table">
			<jvpagetable:table htmlTableId="machineTypeListTable" page="${machineTypeList}" url="/dialog/machineType/list">
					
				<jvpagetable:searchTextItem id="machineTypeListTable_search_name" title="${i18n_commonName}" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_commonName}</jvpagetable:columnheader>
					            <jvpagetable:column id="name">${entity.name}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
					            <jvpagetable:column id="description">${entity.description}</jvpagetable:column>
				
				
			</jvpagetable:table>
			</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


