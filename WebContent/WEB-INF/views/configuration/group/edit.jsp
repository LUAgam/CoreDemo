<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="system.pageTitle" var="i18n_systemPageTitle"/>

<jvnav:pagetitle>
	岗位管理
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="岗位管理"  />
	<jvnav:breadcrumbitem title="修改岗位信息" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
		<!-- PAGE CONTENT BEGINS -->
		<jvpanel:panel color="purple" title="修改岗位信息">
			<jvform:form id="groupform" action="/admin/auth/group/save">
				<jvform:hidden id="id" value="${group.id}"></jvform:hidden>
				<jvform:textfield id="name" readonly="false"
					required="true" title="名称" value="${group.name}"></jvform:textfield>
				<jvform:textfield id="no" readonly="false"
					required="true" title="编号" value="${group.no}"></jvform:textfield>
				<jvform:textareafield id="description" rows="4" size="input-medium" title="描述" value="${group.description }" ></jvform:textareafield>
				<jvform:checkbox id="available" title="是否启用"  value="${group.available }" ></jvform:checkbox>
				<jvform:entityselector id="parentGroupId"
						height="700" width="1024" url="${ctx}/dialog/group/list"
						dialogtitle="选择父组" title="父组" tableId="groupListTable"
						tableDisplayNameColumnName="name" valueId="${group.parentGroupId}"
						value="${group.parentGroupName}" ></jvform:entityselector>
					 
				<jvform:number id="priority" readonly="false" decimals="0" 
					 title="序号" value="${group.priority}"></jvform:number>

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

