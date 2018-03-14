<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="equip.manager" var="i18n_equipManager"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="common.name" var="i18n_commonName"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>
<spring:message code="common.parent" var="i18n_commonParent"/>

<jvlayout:row>
	<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong> <i class="icon-remove"></i> ${i18n_commonMessage} </strong> <br />
				${message}
			</div>
		</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_equipManager}" icon="icon-table">
			<jvpagetable:table htmlTableId="equipDepartmentListTable" page="${equipDepartmentList}" url="/dialog/equipDepartment/list">
					
				<%-- <jvpagetable:searchTextItem id="equipDepartmentListTable_search_name" title="名称" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem> --%>
				
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_lineLine}</jvpagetable:columnheader>
					            <jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_commonName}</jvpagetable:columnheader>
					            <jvpagetable:column id="name">${entity.name}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
					            <jvpagetable:column id="description">${entity.description}</jvpagetable:column>
		
								<!--String 控件-->
    						    <jvpagetable:columnheader>${i18n_commonParent}</jvpagetable:columnheader>
					            <jvpagetable:column id="dept">${entity.dept.name}</jvpagetable:column>
			</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


