<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="role.manager" var="i18n_roleManager"/>
<spring:message code="role.menu" var="i18n_roleMenu"/>
<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle"/>
<spring:message code="role.list" var="i18n_role_List"/>
<spring:message code="widget.form.add" var="i18n_widgetFormAdd"/>
<spring:message code="widget.form.change" var="i18n_widgetFormChange"/>
<spring:message code="common.delete" var="i18n_commonDelete"/>
<spring:message code="permission.permission" var="i18n_permissionPermission"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="role.number" var="i18n_roleNumber"/>
<spring:message code="role.name" var="i18n_roleName"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>
<spring:message code="common.option" var="i18n_commonOption"/>

<jvnav:pagetitle>
	${i18n_roleManager}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_roleManager}" active="true" />
</jvnav:breadcrumb>

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
		<jvpanel:panel color="green" title="${i18n_role_List}" icon="icon-th-large">
			<jvpagetable:table htmlTableId="roleListTable" url="/admin/auth/role" page="${roleList}" >
					<jvpagetable:toolbarButton color="btn-success" url="${ctx}/admin/auth/role/add" icon="icon-plus" title="${i18n_widgetFormAdd}"></jvpagetable:toolbarButton>
				<jvpagetable:searchTextItem id="roleListTable_search_name" title="${i18n_roleName}" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				<jvpagetable:columnheader>${i18n_roleNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="number">${entity.number}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_roleName}</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_commonOption}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
					<jvpagetable:OptionColumnItem title="${i18n_widgetFormChange}"
						url="${ctx}/admin/auth/role/edit/${entity.id}"
						style="btn btn-small btn-warning"></jvpagetable:OptionColumnItem>
					<jvpagetable:OptionColumnItem title="${i18n_commonDelete}"
						url="${ctx}/admin/auth/role/delete/${entity.id}"
						style="btn btn-small btn-danger"></jvpagetable:OptionColumnItem>
					<%-- <jvpagetable:OptionColumnItem title="${i18n_permissionPermission}"
						url="${ctx}/admin/auth/role/permission/${entity.id}"
						style="btn btn-small btn-primary"></jvpagetable:OptionColumnItem> --%>
					<jvpagetable:OptionColumnItem title="${i18n_roleMenu }"
						url="${ctx}/admin/auth/role/menu/${entity.id}"
						style="btn btn-small btn-primary"></jvpagetable:OptionColumnItem>
				</jvpagetable:OptionColumn>
			</jvpagetable:table>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>
