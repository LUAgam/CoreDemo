<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>

<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle"/>
<spring:message code="user.manager" var="i18n_userManager"/>
<spring:message code="user.editTitle" var="i18n_userEditTitle"/>
<spring:message code="user.name" var="i18n_userName"/>
<spring:message code="user.name.placeholder" var="i18n_userNamePlaceholder"/>
<spring:message code="user.name.tool" var="i18n_userNameTool"/>
<spring:message code="user.pass" var="i18n_userPass"/>
<spring:message code="user.pass.placeholder" var="i18n_userPassPlaceholder"/>
<spring:message code="user.newPass" var="i18n_userNewPass"/>
<spring:message code="user.newPass.placeholder" var="i18n_useNewPassPlaceholder"/>
<spring:message code="user.newPass.tool" var="i18n_userNewPassTool"/>
<spring:message code="user.comment" var="i18n_userComment"/>
<spring:message code="user.comment.tool" var="i18n_userCommentTool"/>
<spring:message code="user.allowed" var="i18n_userAllowed"/>
<spring:message code="user.choosePerson" var="i18n_userChoosePerson"/>
<spring:message code="user.person" var="i18n_userPerson"/>

<jvnav:pagetitle>
	${i18n_userEditTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_userManager}" url="/admin/auth/user" />
	<jvnav:breadcrumbitem title="${i18n_userEditTitle}" active="true" />
</jvnav:breadcrumb>

	<jvlayout:row>
		<jvlayout:col length="12"> 
			<!-- PAGE CONTENT BEGINS -->
			<jvpanel:panel color="purple" title="${i18n_userEditTitle}">
				<jvform:form id="userform" action="/admin/auth/user/save">
					<jvform:hidden id="id" value="${user.id}"></jvform:hidden>
					<jvform:hidden id="version" value="${user.version}"></jvform:hidden>
					<jvform:textfield id="username" title="${i18n_userName}" placeholder="${i18n_userNamePlaceholder}"
						value="${user.username}" required="true" tooltrip="${i18n_userNameTool}" readonly="false"></jvform:textfield>
					<jvform:textareafield id="comment" title="${i18n_userComment}" value="${user.comment}" tooltrip="${i18n_userCommentTool}" required="false"></jvform:textareafield>
					<jvform:checkbox id="loginAllowed" title="${i18n_userAllowed}"
						value="${user.loginAllowed}" required="true"></jvform:checkbox>


				 <jvform:entityselector id="personId" required="false"
						height="700" width="1024" url="${ctx}/dialog/person/list"
						dialogtitle="${i18n_userChoosePerson}" title="${i18n_userPerson}" tableId="personListTable"
						tableDisplayNameColumnName="name" valueId="${user.personId}"
						value="${user.personName}" /> 
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
