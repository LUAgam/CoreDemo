<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="department.message" var="i18n_departmentMessage"/>
<spring:message code="department.name" var="i18n_departmentName"/>
<spring:message code="common.type" var="i18n_commonType"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="common.num" var="i18n_commonNum"/>
<spring:message code="department.parent" var="i18n_departmentParent"/>
<spring:message code="common.content" var="i18n_commonContent"/>

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
	<jvlayout:col length="12">
			<jvpanel:panelNoTools color="green" title="${i18n_departmentMessage}" icon="icon-table">
			<jvpagetable:table htmlTableId="departmentListTable" page="${departmentList}" url="/dialog/department/list">
					
				<jvpagetable:searchTextItem id="departmentListTable_search_name" title="${i18n_departmentName}" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				<jvpagetable:searchTextItem id="menuListTable_search_no" title="编号" key="no" operat="LIKE" placeholder="" value="${SEARCH_no}"></jvpagetable:searchTextItem>
				<%-- <jvpagetable:searchSelectfield options="${typeList}" name="typeStr" value="${typeStr}" title="${i18n_commonType}" id="typeStr"></jvpagetable:searchSelectfield>
				 --%><jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				<jvpagetable:columnheader>编号</jvpagetable:columnheader>
				<jvpagetable:column id="no">${entity.no}</jvpagetable:column>
				<jvpagetable:columnheader style="width:100px;">${i18n_departmentName}</jvpagetable:columnheader>
				<jvpagetable:column id="name" >${entity.name}</jvpagetable:column>
				
				<jvpagetable:columnheader style="width:100px;">${i18n_departmentParent}</jvpagetable:columnheader>
				<jvpagetable:column id="name" >${entity.parentDepartment.name}</jvpagetable:column>
			
				<jvpagetable:columnheader style="width:100px;">${i18n_commonContent}</jvpagetable:columnheader>
				<jvpagetable:column id="description" >${entity.description}</jvpagetable:column>
						
			</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


