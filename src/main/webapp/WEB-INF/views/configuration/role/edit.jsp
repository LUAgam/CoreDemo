<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>

<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle"/>
<spring:message code="role.manager" var="i18n_roleManager"/>
<spring:message code="role.number" var="i18n_roleNumber"/>
<spring:message code="role.number.placeholder" var="i18n_roleNumberPlaceholder"/>
<spring:message code="role.number.tool" var="i18n_roleNumberTool"/>
<spring:message code="role.name" var="i18n_roleName"/>
<spring:message code="role.name.placeholder" var="i18n_roleNamePlaceholder"/>
<spring:message code="role.description" var="i18n_roleDescription"/>
<spring:message code="role.description.tool" var="i18n_roleDescriptionTool"/>
<spring:message code="role.editPageTitle" var="i18n_roleEditPageTitle"/>

<jvnav:pagetitle>
	${i18n_roleEditPageTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_roleManager}" url="/role" />
	<jvnav:breadcrumbitem title="${i18n_roleEditPageTitle}" active="true" />
</jvnav:breadcrumb>

	
	<jvlayout:row>
		<jvlayout:col length="12">
		<jvpanel:panel color="purple" title="${i18n_roleEditPageTitle}">
			<jvform:form id="role" action="/admin/auth/role/save">
				<input type="hidden" name="token" value="${token}" />
				<jvform:hidden id="id" value="${role.id}"></jvform:hidden>
				<jvform:textfield id="number" title="${i18n_roleNumber}" placeholder="${i18n_roleNumberPlaceholder}"
					value="${role.number}" required="true" tooltrip="${i18n_roleNumberTool}"></jvform:textfield>
				<jvform:textfield id="name" title="${i18n_roleName}" placeholder="${i18n_roleNamePlaceholder}"
					value="${role.name}" required="true" ></jvform:textfield>
				<jvform:textareafield id="description" title="${i18n_roleDescription}" value="${role.description}" tooltrip="${i18n_roleDescriptionTool}" required="false"></jvform:textareafield>
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