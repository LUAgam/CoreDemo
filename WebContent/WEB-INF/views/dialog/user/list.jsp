<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="user.message" var="i18n_userMessage"/>
<spring:message code="person.name" var="i18n_personName"/>
<spring:message code="person.number" var="i18n_personNumber"/>
<spring:message code="common.content" var="i18n_commonContent"/>
<spring:message code="user.userName" var="i18n_userUserName"/>


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
		<jvpanel:panelNoTools color="green" title="${i18n_userMessage}" icon="icon-table">
			<jvpagetable:table htmlTableId="userListTable" page="${userList}" url="/dialog/user/list">
					
				<jvpagetable:searchTextItem id="userListTable_search_name" title="${i18n_personName}" key="person.name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				<jvpagetable:searchTextItem id="userListTable_search_number" title="${i18n_personNumber}" key="person.number" operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>
			
				
				
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader style="width:100px;">${i18n_userUserName}</jvpagetable:columnheader>
				<jvpagetable:column id="username" >${entity.username}</jvpagetable:column>
				
				<jvpagetable:columnheader style="width:100px;">${i18n_personName}</jvpagetable:columnheader>
				<jvpagetable:column id="name" >${entity.person.name}</jvpagetable:column>
				
				<jvpagetable:columnheader style="width:300px">${i18n_personNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="number">${entity.person.number}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_commonContent}</jvpagetable:columnheader>
				<jvpagetable:column id="comment">${entity.comment}</jvpagetable:column>
				
			</jvpagetable:table>
		
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


