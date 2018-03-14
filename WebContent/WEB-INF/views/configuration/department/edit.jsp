<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="department.pageTitle" var="i18n_departmentPageTitle" />
<spring:message code="system.pageTitle" var="i18n_systemPageTitle" />
<spring:message code="department.manager" var="i18n_departmentManager" />
<spring:message code="department.name" var="i18n_departmentName" />
<spring:message code="department.name.placeholder" var="i18n_departmentNamePlaceholder" />
<spring:message code="department.breiefName" var="i18n_departmentBreiefName" />
<spring:message code="department.breiefName.placeholder" var="i18n_departmentBreiefNamePlaceholder" />
<spring:message code="department.chooseparent" var="i18n_departmentChooseparent" />
<spring:message code="department.parent" var="i18n_departmentParent" />
<spring:message code="department.ifRightD" var="i18n_departmentIfRightD" />
<spring:message code="department.ifOCCD" var="i18n_departmentIfOCCD" />
<spring:message code="common.DESC" var="i18n_commonDESC" />
<spring:message code="common.type" var="i18n_commonType" />
<spring:message code="common.descroption" var="i18n_commonDescroption" />
<spring:message code="common.message" var="i18n_commonMessage" />

<jvnav:pagetitle>
	${i18n_departmentPageTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_departmentManager}" url="/admin/sys/department" />
	<jvnav:breadcrumbitem title="${i18n_departmentPageTitle}" active="true" />
</jvnav:breadcrumb>


<jvlayout:row>
	<jvlayout:col length="12">
		<!-- PAGE CONTENT BEGINS -->
		<jvpanel:panel color="purple" title="${i18n_departmentPageTitle}">
			<jvform:form id="departmentform" action="/admin/sys/department/save">
				<jvform:hidden id="id" value="${department.id}"></jvform:hidden>
				<jvform:textfield id="name" title="${i18n_departmentName}" placeholder="${i18n_departmentNamePlaceholder}" value="${department.name}"
					required="true" size="input-large"></jvform:textfield>
				<jvform:textfield id="no" title="部门编号" placeholder="" value="${department.no}"
					required="true" size="input-large"></jvform:textfield>
				<jvform:entityselector id="parentId" required="false" height="700" width="1024" url="${ctx}/dialog/department/list"
					dialogtitle="${i18n_departmentChooseparent}" title="${i18n_departmentParent}" tableId="departmentListTable" tableDisplayNameColumnName="name"
					valueId="${department.parentId}" value="${department.parentName}"></jvform:entityselector>


				<jvform:number id="priority" title="${i18n_commonDESC}" decimals="0" value="${department.priority}" required="false"></jvform:number>
				<jvform:textareafield id="description" title="${i18n_commonDescroption}" size="input-large" value="${department.description}" required="false"></jvform:textareafield>
				<%-- <jvform:checkbox id="funFlag" title="${i18n_departmentIfRightD}" value="${department.funFlag}"></jvform:checkbox>
					<jvform:checkbox id="occFlag" title="${i18n_departmentIfOCCD}" value="${department.occFlag}"></jvform:checkbox> --%>
				<jvform:footbar>
					<jvform:submit />
							&nbsp; &nbsp; &nbsp;
							<jvform:cancel />
							&nbsp; &nbsp; &nbsp;

				</jvform:footbar>
			</jvform:form>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>
<!-- /row -->