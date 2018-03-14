<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="person.message" var="i18n_personMessage"/>
<spring:message code="person.name" var="i18n_personName"/>
<spring:message code="person.number" var="i18n_personNumber"/>

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
		<jvpanel:panelNoTools color="green" title="${i18n_personMessage}" icon="icon-table">
			<jvpagetable:table htmlTableId="personListTable" page="${personList}" url="/dialog/person/list">
					
				<jvpagetable:searchTextItem id="personListTable_search_name" title="${i18n_personName}" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
				<jvpagetable:searchTextItem id="personListTable_search_number" title="${i18n_personNumber}" key="number" operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>
			
				
				
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader style="width:100px;">${i18n_personName}</jvpagetable:columnheader>
				<jvpagetable:column id="name" >${entity.name}</jvpagetable:column>
				
				<jvpagetable:columnheader style="width:200px">${i18n_personNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="number">${entity.number}</jvpagetable:column>
				
				<%-- 因为为空时页面显示有问题所以注释掉，只显示必须有的数据
				<jvpagetable:columnheader style="width:200px">备注</jvpagetable:columnheader>
				<jvpagetable:column id="comment">${entity.comment}</jvpagetable:column> --%>
				
			</jvpagetable:table>
		
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


