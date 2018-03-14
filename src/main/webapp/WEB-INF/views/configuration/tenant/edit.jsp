<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>

<spring:message code="tenant.manager" var="i18n_tenantManager"/>
<spring:message code="tenant.edit" var="i18n_tenantEdit"/>
<spring:message code="tenant.nubmer" var="i18n_tenantNubmer"/>
<spring:message code="tenant.number.placeholder" var="i18n_tenantNumberPlaceholder"/>
<spring:message code="tenant.number.tool" var="i18n_tenantNumberTool"/>
<spring:message code="tenant.name" var="i18n_tenantName"/>
<spring:message code="tenant.name.placeholder" var="i18n_tenantNamePlaceholder"/>
<spring:message code="tenant.description" var="i18n_tenantDescription"/>
<spring:message code="tenant.description.tool" var="i18n_tenantDescriptionTool"/>
<spring:message code="tenant.back" var="i18n_tenantBack"/>

<jvnav:breadcrumb id="breadcrumb">
	<jvnav:breadcrumbitem title="${i18n_tenantManager}" url="/tenant" active="false" icon="icon-home" />
	<jvnav:breadcrumbitem title="${i18n_tenantEdit}" active="true" />
</jvnav:breadcrumb>

<jvlayout:page>
	<h3 class="col-xs-12 header smaller lighter blue">
		<span class="col-xs-12 col-sm-7">${tenantEdit}</span> <span
			class="col-xs-12 col-sm-5"><button
				class="btn btn-xs btn-primary" style="width: 100px"
				onclick="history.back()">${i18n_tenantBack}</button>
		</span>
	</h3>
	<jvlayout:row>
		<jvlayout:col length="12">
			<jvform:form id="tenant" action="/tenant/save">
				<jvform:hidden id="id" value="${dao.id}"></jvform:hidden>
				<jvform:hidden id="version" value="${dao.version}"></jvform:hidden>
				<jvform:textfield id="number" title="${i18n_tenantNubmer}" placeholder="${i18n_tenantNumberPlaceholder}"
					value="${dao.number}" required="true" tooltrip="${i18n_tenantNumberTool}"></jvform:textfield>
				<jvform:textfield id="name" title="${i18n_tenantName}" placeholder="${i18n_tenantNamePlaceholder}"
					value="${dao.name}" required="true" ></jvform:textfield>
				<jvform:textareafield id="description" title="${i18n_tenantDescription}" placeholder="${i18n_tenantDescription}"
					value="${dao.description}" tooltrip="${i18n_tenantDescriptionTool}" required="false"></jvform:textareafield>
			</jvform:form>
		</jvlayout:col>
	</jvlayout:row>
</jvlayout:page>