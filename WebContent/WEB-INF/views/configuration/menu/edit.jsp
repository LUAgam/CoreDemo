<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>

<spring:message code="menu.editPageTitle" var="i18n_menuEditPageTitle"/>
<spring:message code="menu.configuration.menu" var="i18n_menuConfigurationMenu"/>
<spring:message code="system.pageTitle" var="i18n_systemPageTitle"/>
<spring:message code="menu.name" var="i18n_menuName"/>
<spring:message code="menu.name.placeholder" var="i18n_menuNamePlaceholder"/>
<spring:message code="menu.displayname" var="i18n_menuDisplayname"/>
<spring:message code="menu.displayname.tool" var="i18n_menuDisplaynameTool"/>
<spring:message code="menu.displayname.placeholder" var="i18n_menuDisplaynamePlaceholder"/>
<spring:message code="menu.icon" var="i18n_menuIcon"/>
<spring:message code="menu.icon.tool" var="i18n_menuIconTool"/>
<spring:message code="menu.url" var="i18n_menuUrl"/>
<spring:message code="menu.url.tool" var="i18n_menuUrlTool"/>
<spring:message code="menu.position" var="i18n_menuPosition"/>
<spring:message code="menu.position.tool" var="i18n_menuPositionTool"/>
<spring:message code="menu.desc" var="i18n_menuDesc"/>
<spring:message code="menu.desc.tool" var="i18n_menuDescTool"/>
<spring:message code="menu.chooseParentMenu" var="i18n_menuChooseParentMenu"/>
<spring:message code="menu.parentMenu" var="i18n_menuParentMenu"/>
<spring:message code="menu.choosePermisstion" var="i18n_menuChoosePermisstion"/>
<spring:message code="menu.permisstion" var="i18n_menuPermisstion"/>


<jvnav:pagetitle>
	${i18n_menuEditPageTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_menuConfigurationMenu}" url="/menu" />
	<jvnav:breadcrumbitem title="${i18n_menuEditPageTitle}" active="true" />
</jvnav:breadcrumb>

	<jvlayout:row>
		<jvlayout:col length="12">
			<!-- PAGE CONTENT BEGINS -->
			<jvpanel:panel color="purple" title="${i18n_menuEditPageTitle}">
			<jvform:form id="menuform" action="/menu/save">
				<jvform:hidden id="id" value="${menu.id}"></jvform:hidden>
				<jvform:textfield id="name" title="${i18n_menuName}" placeholder="${i18n_menuNamePlaceholder}"
					value="${menu.name}" required="true" tooltrip="${i18n_menuName}"></jvform:textfield>
				<jvform:textfield id="displayName" title="${i18n_menuDisplayname}" placeholder="${i18n_menuDisplaynamePlaceholder}"
					value="${menu.displayName}" required="true" tooltrip="${i18n_menuDisplaynameTool}"></jvform:textfield>	
				<jvform:textfield id="icon" title="${i18n_menuIcon}"	value="${menu.icon}" required="false" tooltrip="${i18n_menuIconTool}"></jvform:textfield>	
				<jvform:textfield id="url" title="${i18n_menuUrl}"	value="${menu.url}" required="false" tooltrip="${i18n_menuUrlTool}"></jvform:textfield>
				<jvform:textfield id="position" title="${i18n_menuPosition}"	value="${menu.position}" required="true" tooltrip="${i18n_menuPositionTool}"></jvform:textfield>
				<jvform:textareafield id="description" title="${i18n_menuDesc}" value="${menu.description}" tooltrip="${i18n_menuDescTool}" required="false"></jvform:textareafield>

				<jvform:entityselector id="parentMenuId" required="false"
					height="700" width="1024" url="${ctx}/dialog/menu/list"
					dialogtitle="${i18n_chooseParentMenu}" title="${i18n_menuParentMenu}" tableId="menuListTable"
					tableDisplayNameColumnName="name" valueId="${menu.parentMenuId}"
					value="${menu.parentMenuDisplayName}" />

				<jvform:entityselector id="permisstionId" required="false"
					height="700" width="1024" url="${ctx}/dialog/permission/list"
					dialogtitle="${i18n_menuChoosePermisstion}" title="${i18n_menuPermisstion}" tableId="permissionListTable"
					tableDisplayNameColumnName="name" valueId="${menu.permisstionId}"
					value="${menu.permisstionDisplayName}" />
				<jvform:footbar>
					<jvform:submit/>
					&nbsp; &nbsp; &nbsp;
					<jvform:cancel/>
					&nbsp; &nbsp; &nbsp;
				</jvform:footbar>
			</jvform:form>
			</jvpanel:panel>
		</jvlayout:col>
	</jvlayout:row>
	<!-- /row -->