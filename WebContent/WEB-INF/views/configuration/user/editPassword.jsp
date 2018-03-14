<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle"/>
<spring:message code="user.manager" var="i18n_userManager"/>
<spring:message code="user.editMyPass" var="i18n_userEditMyPass"/>
<spring:message code="user.editPass" var="i18n_userEditPass"/>
<spring:message code="user.newPass" var="i18n_userNewPass"/>
<spring:message code="user.newPass.placeholder" var="i18n_userNewPassPlaceholder"/>
<spring:message code="user.confirmPass" var="i18n_userConfirmPass"/>
<spring:message code="user.confirmPass.placeholder" var="i18n_userConfirmPassPlaceholder"/>
<spring:message code="common.message" var="i18n_commonMessage"/>

<jvnav:pagetitle>
	${i18n_userEditPass}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_userManager}" url="/user" />
	<jvnav:breadcrumbitem title="${i18n_userEditMyPass}" active="true" />
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
		<jvpanel:panel color="purple" title="${i18n_userEditPass}">
				<jvform:form id="userform" action="/admin/auth/user/editPassword">
				<jvform:hidden id="id" value="${userId}"></jvform:hidden>
				<jvform:password id="newPassword" title="${i18n_userNewPass}" placeholder="${i18n_userNewPassPlaceholder}"
					required="true" tooltrip="${i18n_userNewPassPlaceholder}"></jvform:password>
				<jvform:password id="confirmPassword" title="${i18n_userConfirmPass}" placeholder="${i18n_userConfirmPassPlaceholder}"
					required="true" tooltrip="${i18n_userConfirmPassPlaceholder}"></jvform:password>

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
