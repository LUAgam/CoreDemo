<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="system.pageTitle" var="i18n_systemPageTitle"/>
<spring:message code="person.manager" var="i18n_personManager"/>
<spring:message code="person.pageTitle" var="i18n_personPageTitle"/>
<spring:message code="person.name" var="i18n_personName"/>
<spring:message code="person.number" var="i18n_personNumber"/>
<spring:message code="person.departmentTitle" var="i18n_personDepartmentTitle"/>
<spring:message code="person.department" var="i18n_personDepartment"/>
<spring:message code="person.sex" var="i18n_personSex"/>
<spring:message code="person.title" var="i18n_personTitle"/>
<spring:message code="person.subject" var="i18n_personSubject"/>
<spring:message code="person.email" var="i18n_personEmail"/>
<spring:message code="person.phoneNumber" var="i18n_personPhoneNumber"/>
<spring:message code="person.shortNumber" var="i18n_personShortNumber"/>
<spring:message code="person.officeNumber" var="i18n_personOfficeNumber"/>
<spring:message code="person.officeRoom" var="i18n_personOfficeRoom"/>
<spring:message code="common.message" var="i18n_commonMessage"/>

<jvnav:pagetitle>
	${i18n_personPageTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_personManager}" url="/admin/sys/person" />
	<jvnav:breadcrumbitem title="${i18n_personPageTitle}" active="true" />
</jvnav:breadcrumb>


<c:if test="${not empty message}">
	<div class="alert alert-danger">
		<strong> <i class="icon-remove"></i> ${i18n_commonMessage}
		</strong> <br /> ${message}
	</div>
</c:if>

<jvlayout:row>
	<jvlayout:col length="12">
		<!-- PAGE CONTENT BEGINS -->
		<jvpanel:panel color="purple" title="${i18n_personPageTitle}">
			<jvform:form id="personform" action="/admin/sys/person/save">
				<jvform:hidden id="id" value="${person.id}"></jvform:hidden>
				<jvform:textfield id="name" readonly="false"
					required="true" title="${i18n_personName}" value="${person.name}"></jvform:textfield>
				<jvform:textfield id="number" readonly="false"
					required="true" title="${i18n_personNumber}" value="${person.number}"></jvform:textfield>
				
				<jvform:entityselector id="departmentId" required="true"
						height="700" width="1024" url="${ctx}/dialog/department/list"
						dialogtitle="${i18n_personDepartmentTitle}" title="${i18n_personDepartment}" tableId="departmentListTable"
						tableDisplayNameColumnName="name" valueId="${person.departmentId}"
						value="${person.departmentName}" ></jvform:entityselector>
				
				<%-- <jvform:entityselector url="${ctx}/dialog/department/list"
					 id="departmentId" width="1024" tableId="departmentList"
					 title="所属部门" value="${person.departmentName}" valueId="${person.departmentId}" dialogtitle="选择部门"
					 tableDisplayNameColumnName="name" height="700"></jvform:entityselector> --%>
					 
				<jvform:textfield id="gender" readonly="false"
					required="true" title="${i18n_personSex}" value="${person.gender}"></jvform:textfield>
				<jvform:textfield id="title" readonly="false"
					required="false" title="${i18n_personTitle}" value="${person.title}"></jvform:textfield>
				<jvform:textfield id="subject" readonly="false"
					required="false" title="${i18n_personSubject}" value="${person.subject}"></jvform:textfield>
				<jvform:textfield id="email" readonly="false"
					required="false" title="${i18n_personEmail}" value="${person.email}"></jvform:textfield>
				<jvform:textfield id="phoneNumber" readonly="false"
					required="false" title="${i18n_personPhoneNumber}" value="${person.phoneNumber}"></jvform:textfield>
				<jvform:textfield id="shortNumber" readonly="false"
					required="false" title="${i18n_personShortNumber}" value="${person.shortNumber}"></jvform:textfield>
				<jvform:textfield id="officeNumber" readonly="false"
					required="false" title="${i18n_personOfficeNumber}" value="${person.officeNumber}"></jvform:textfield>
				<jvform:textfield id="officeRoom" readonly="false"
					required="false" title="${i18n_personOfficeRoom}" value="${person.officeRoom}"></jvform:textfield>

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

