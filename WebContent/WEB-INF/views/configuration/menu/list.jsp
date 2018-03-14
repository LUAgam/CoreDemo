<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="menu.configuration.menu" var="i18n_menuConfigurationMenu"/>
<spring:message code="system.pageTitle" var="i18n_systemPageTitle"/>
<spring:message code="menu.manager" var="i18n_menuManager"/>
<spring:message code="widget.form.add" var="i18n_widgetFormAdd"/>
<spring:message code="menu.displayname" var="i18n_menuDisplayname"/>
<spring:message code="widget.form.change" var="i18n_widgetFormChange"/>
<spring:message code="common.delete" var="i18n_commonDelete"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="common.num" var="i18n_commonNum"/>
<spring:message code="menu.num" var="i18n_menuNum"/>
<spring:message code="menu.icon" var="i18n_menuIcon"/>
<spring:message code="menu.url" var="i18n_menuUrl"/>
<spring:message code="menu.position" var="i18n_menuPosition"/>
<spring:message code="menu.parentMenu" var="i18n_menuParentMenu"/>
<spring:message code="menu.permisstion" var="i18n_menuPermisstion"/>
<spring:message code="menu.desc" var="i18n_menuDesc"/>
<spring:message code="common.option" var="i18n_commonOption"/>

<jvnav:pagetitle>
	${i18n_menuConfigurationMenu}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_menuConfigurationMenu}" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<c:if test="${not empty message}">
		<div class="alert alert-danger">
			<strong> <i class="icon-remove"></i> ${i18n_commonMessage}
			</strong> <br /> ${message}
		</div>
	</c:if>

	<jvlayout:col length="12">
		<jvpanel:panel color="green" title="${i18n_menuManager}" icon="icon-table">
			<jvpagetable:table htmlTableId="menuListTable" page="${menuList}" url="/menu">
			
			<jvpagetable:toolbarButton color="btn-success" url="${ctx}/menu/add" icon="icon-plus" title="${i18n_widgetFormAdd}"></jvpagetable:toolbarButton>
			<jvpagetable:searchTextItem id="menuListTable_search_displayName" title="${i18n_menuDisplayname}" key="displayName" operat="LIKE" placeholder="" value="${SEARCH_displayName}"></jvpagetable:searchTextItem>

				<jvpagetable:columnheader>${i18n_commonNum}</jvpagetable:columnheader>
				<jvpagetable:column id="id">${entity.id}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuNum}</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuDisplayname}</jvpagetable:columnheader>
				<jvpagetable:column id="displayName">${entity.displayName}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuIcon}</jvpagetable:columnheader>
				<jvpagetable:column id="icon">${entity.icon}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuUrl}</jvpagetable:columnheader>
				<jvpagetable:column id="url">${entity.url}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuPosition}</jvpagetable:columnheader>
				<jvpagetable:column id="position">${entity.position}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuParentMenu}</jvpagetable:columnheader>
				<jvpagetable:column id="parentMenuDisplayName">${entity.parent.displayName}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuPermisstion}</jvpagetable:columnheader>
				<jvpagetable:column id="permisstionDisplayName">${entity.permission.displayname}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_menuDesc}</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_commonOption}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
					<jvpagetable:OptionColumnItem title="${i18n_widgetFormChange}"
						url="${ctx}/menu/edit/${entity.id}"
						style="btn btn-small btn-warning"></jvpagetable:OptionColumnItem>
					<jvpagetable:OptionColumnItem title="${i18n_commonDelete}"
						url="${ctx}/menu/delete/${entity.id}"
						style="btn btn-small btn-danger"></jvpagetable:OptionColumnItem>
				</jvpagetable:OptionColumn>
				
			</jvpagetable:table>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<!-- /.page-content -->


