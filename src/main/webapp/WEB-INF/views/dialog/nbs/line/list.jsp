<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="line.line" var="i18n_lineLine"/>
<spring:message code="line.No" var="i18n_lineNo"/>
<spring:message code="line.name" var="i18n_lineName"/>
<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="common.descroption" var="i18n_commonDescroption"/>

<jvlayout:row>
	<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong> <i class="icon-remove"></i> ${i18n_commonMessage}</strong> <br />
				${message}
			</div>
		</c:if>

	<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="${i18n_lineLine}" icon="icon-table">
			<jvpagetable:table htmlTableId="lineListTable" page="${lineList}" url="/dialog/line/list">
					
				<jvpagetable:searchTextItem id="lineListTable_search_lineName" title="${i18n_lineName}" key="lineName" operat="LIKE" placeholder="" value="${SEARCH_lineName}"></jvpagetable:searchTextItem>
				 
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_lineNo}</jvpagetable:columnheader>
		            <jvpagetable:column id="lineNo">${entity.lineNo}</jvpagetable:column>

					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_lineName}</jvpagetable:columnheader>
		            <jvpagetable:column id="lineName">${entity.lineName}</jvpagetable:column>

					<!--String 控件-->
 					<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
		            <jvpagetable:column id="note">${entity.note}</jvpagetable:column>

			</jvpagetable:table>
			</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


