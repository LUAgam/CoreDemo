<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="person.manager" var="i18n_personManager"/>
<spring:message code="person.editPerson" var="i18n_personEditPerson"/>
<spring:message code="person.name" var="i18n_personName"/>
<spring:message code="person.number" var="i18n_personNumber"/>
<spring:message code="person.name.placeholder" var="i18n_personNamePlaceholder"/>
<spring:message code="person.number.placeholder" var="i18n_personNumberPlaceholder"/>
<spring:message code="person.image" var="i18n_personImage"/>
<spring:message code="common.message" var="i18n_commonMessage"/>

<jvnav:pagetitle>
	${i18n_personEditPerson}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_personManager}" url="/admin/sys/person" />
	<jvnav:breadcrumbitem title="${i18n_personEditPerson}" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<c:if test="${not empty message}">
		<div class="alert alert-danger">
			<strong> <i class="icon-remove"></i> ${i18n_commonMessage}
			</strong> <br /> ${message}
		</div>
	</c:if>

	<jvlayout:col length="12">
		<!-- PAGE CONTENT BEGINS -->
		<jvpanel:panel color="purple" title="${i18n_personEditPerson}">
			<jvform:form id="personform" action="/admin/sys/person/editInfo" method="post">
				<jvform:hidden id="id" value="${person.id}"></jvform:hidden>
				<jvform:textfield id="name" placeholder="${i18n_personNamePlaceholder}" readonly="true"
					required="true" title="${i18n_personName}" value="${person.name}"></jvform:textfield>
				<jvform:textfield id="number" placeholder="${i18n_personNumberPlaceholder}" readonly="true"
					required="true" title="${i18n_personNumber}" value="${person.number}"></jvform:textfield>

				<jvform:fileupload id="headImage" title="${i18n_personImage}"></jvform:fileupload>
				

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