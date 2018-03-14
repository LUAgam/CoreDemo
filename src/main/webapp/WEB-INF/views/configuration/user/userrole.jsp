<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>

<%@ include file="../../taglibs.jsp"%>

<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>

<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle"/>
<spring:message code="user.manager" var="i18n_userManager"/>
<spring:message code="user.editTitle" var="i18n_userEditTitle"/>
<spring:message code="permission.contentList" var="i18n_permissionContentList"/>
<spring:message code="widget.form.submit" var="i18n_widgetFormSubmit"/>
<spring:message code="tenant.nubmer" var="i18n_tenantNumber"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>

<jvnav:pagetitle>
	${i18n_userEditTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_userManager}" url="/user" />
	<jvnav:breadcrumbitem title="${i18n_userEditTitle}" active="true" />
</jvnav:breadcrumb>


	<jvlayout:row>
		<jvlayout:col length="12">
			<jvpanel:panel color="purple" title="${user.username} ${i18n_permissionContentList}">
			<form action="<c:url value='/admin/auth/user/role/'/>" method="post">
				<input type="hidden" id="userId" name="userId" value="${user.id}">
				<div class="operate panel panel-default">
					<div class="panel-body">
						<div class="pull-left col-xs-8">
							<input class="btn btn-sm btn-primary" type="submit" value="${i18n_widgetFormSubmit}"/>
						</div>
					</div>
				</div>
				
				<div class="table-responsive">
					<table id="userrole" class="table table-striped table-bordered table-hover">
					<thead>
					   
					   <tr>
				      	  <th class="center">
				      	  		<label><input type="checkbox" class="ace" /> <span class="lbl"></span></label>
						  </th>
						  <th>
						  		${i18n_tenantNumber}
						  </th>
						  <th>
						  		${i18n_commonName}
						  </th>
						  <th>
						  		${i18n_commonDescroption}
						  </th>
						  
					   </tr>
					</thead>
					<tbody>
					   <c:forEach var="item" items="${allRole}" varStatus="s">
							<tr>
								<td class="center"><label><input id="selectrole" name="selectrole" type="checkbox" class="ace" value="${item.id}" ${item.checked? 'checked':''}/>	<span class="lbl"></span></label></td>
								<td>${item.number}</td>
								<td>${item.name}</td>
								<td>${item.description}</td>
							</tr>
						</c:forEach>
					</tbody>
					</table>
				</div>
			</form>
			</jvpanel:panel>
		</jvlayout:col>
	</jvlayout:row>
