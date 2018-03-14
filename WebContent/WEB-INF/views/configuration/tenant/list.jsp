<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>

<%@ include file="../../taglibs.jsp"%>

<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>

<spring:message code="tenant.manager" var="i18n_tenantManager"/>
<spring:message code="tenant.message" var="i18n_tenantMessage"/>
<spring:message code="tenant.list" var="i18n_tenantList"/>
<spring:message code="tenant.name" var="i18n_tenantName"/>
<spring:message code="common.num" var="i18n_commonNum"/>
<spring:message code="tenant.nubmer" var="i18n_tenantNubmer"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>
<spring:message code="common.message" var="i18n_commonMessage" />

<!-- 域 list -->
<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
	</script>
	<ul class="breadcrumb">
		<li><i class="icon-home icon-large"></i> <a href="#">${i18n_tenantManager}</a>
		</li>
	</ul>
</div>

<jvlayout:page>
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
		<jvmessage:rowmessage id="message" content="${i18n_tenantMessage}" icon="icon-th-large" close="false" alerttype="1"/>
		<jvlayout:col length="12">
			<jvtable:table htmlTableId="tenantList" htmlTableHeader="${tenantList}" ajaxSource="/tenant/list" check="true" option="true" optionUrlString="tenant">
				<jvtable:toolbar newButton="true" delButton="false" search="true" advSearch="false" searchLab="${i18n_tenantName}" searchProperty="name">
					
				</jvtable:toolbar>
				<jvtable:column title="${i18n_commonNum}" property="id" sortable="false" width="100px"/>
				<jvtable:column title="${i18n_tenantNubmer}" property="number" sortable="false" width="200px"/>
				<jvtable:column title="${i18n_commonName}" property="name" sortable="false" width="200px"/>
				<jvtable:column title="${i18n_commonDescroption}" property="description" width="*"/>
			</jvtable:table>
		</jvlayout:col>
	</jvlayout:row>
</jvlayout:page>
