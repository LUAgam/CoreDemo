<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="menu.displayname" var="i18n_menuDisplayname"/>
<spring:message code="menu.message" var="i18n_menuMessage"/>
<spring:message code="menu.nameMessage" var="i18n_menuNameMessage"/>
<spring:message code="common.message" var="i18n_commonMessage"/>

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
		<jvpanel:panelNoTools color="green" title="${i18n_menuMessage}" icon="icon-table">
			<jvpagetable:table htmlTableId="menuListTable" page="${menuList}" url="/dialog/menu/list">
					
				<jvpagetable:searchTextItem id="menuListTable_search_displayName" title="${i18n_menuDisplayname}" key="displayName" operat="LIKE" placeholder="" value="${SEARCH_displayName}"></jvpagetable:searchTextItem>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader style="width:100px;">${i18n_menuNameMessage}</jvpagetable:columnheader>
				<jvpagetable:column id="name" >${entity.name}</jvpagetable:column>
				
				<jvpagetable:columnheader style="width:100px;">${i18n_menuDisplayname}</jvpagetable:columnheader>
				<jvpagetable:column id="displayName" >${entity.displayName}</jvpagetable:column>
				
				
			</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


