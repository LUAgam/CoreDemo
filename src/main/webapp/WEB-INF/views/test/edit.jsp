<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<jvnav:pagetitle>
	请假填写
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="请假填写" active="true" />
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
		<jvpanel:panel color="purple" title="请假填写">
			<jvform:form id="personform" action="/test/save" method="post">
				<jvform:hidden id="id" value="${plan.id}"></jvform:hidden>
				<jvform:textfield id="name" readonly="false" required="false" title="原因" value="${plan.name}"></jvform:textfield>
				<jvform:datetimefield id="createDate" readonly="false" required="false" title="时间" value="${plan.createDate}"></jvform:datetimefield>
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

