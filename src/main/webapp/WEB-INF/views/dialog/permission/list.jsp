<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="permission.message" var="i18n_permissionMessage"/>
<spring:message code="permission.name" var="i18n_permissionName"/>
<spring:message code="permission.displayName" var="i18n_permissionDisplayName"/>

<jvlayout:row>
	<c:if test="${not empty message}">
		<div class="alert alert-danger">
			<strong>
				<i class="icon-remove"></i>	
				${i18n_commonMessage}
			</strong>
			<br />
			${message}
		</div>
	</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_permissionMessage}" icon="icon-table">
			<jvpagetable:table htmlTableId="permissionListTable" page="${permissionList}" url="/dialog/permission/list">
					
				<jvpagetable:searchTextItem id="permissionListTable_search_displayname" title="${i18n_permissionDisplayName}" key="displayname" operat="LIKE" placeholder="" value="${SEARCH_displayname}"></jvpagetable:searchTextItem>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader style="width:100px;">${i18n_permissionName}</jvpagetable:columnheader>
				<jvpagetable:column id="name" >${entity.name}</jvpagetable:column>
				<jvpagetable:columnheader style="width:100px;">${i18n_permissionDisplayName}</jvpagetable:columnheader>
				<jvpagetable:column id="displayname" >${entity.displayname}</jvpagetable:column>
			</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


