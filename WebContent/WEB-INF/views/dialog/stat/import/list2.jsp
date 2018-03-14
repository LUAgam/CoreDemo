<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>

<spring:message code="stat.common.data" var="i18N_scData"/>
<spring:message code="stat.import.excel" var="i18N_siExcel"/>
<spring:message code="stat.import.interChange" var="i18N_siInterChange"/>
<spring:message code="stat.import.income" var="i18N_siIncome"/>
<spring:message code="stat.reportClass.info" var="i18N_srInfo"/>
<spring:message code="stat.import.time.sectionForm" var="i18N_sitSectionForm"/>
<spring:message code="stat.import.ticket.flow" var="i18N_sitFlow"/>
<spring:message code="common.date" var="i18N_cDate"/>
<spring:message code="stat.import.select.table" var="i18N_sisTable"/>
<spring:message code="stat.import" var="i18N_sImport"/>
<spring:message code="stat.import.tableName" var="i18N_siTableName"/>
<spring:message code="stat.common.line" var="i18N_scLine"/>
<spring:message code="stat.import.time" var="i18N_siTime"/>
<spring:message code="stat.import.person" var="i18N_siPerson"/>
<spring:message code="common.friendly.tips" var="i18N_cfTips"/>
<spring:message code="stat.reportClass.param" var="i18N_srParam"/>
<spring:message code="stat.common.paramName" var="i18N_scParamName"/>
<spring:message code="common.value" var="i18N_cValue"/>
<spring:message code="stat.import.ticket.exitFlow" var="i18N_sitExitFlow"/>
<spring:message code="common.time" var="i18N_cTime"/>

<jvlayout:row>
	<jvlayout:col length="12">
		<jvform:form id="up${flag}" action="/importAcc/saveImportTransfer" method="post">
			<jvform:hidden id="flag" value="${flag}"></jvform:hidden>
			<jvform:datefield id="date" required="true" title="${i18N_cDate}" value="${date}"></jvform:datefield>
			<jvform:fileupload id="addbegin" required="true" size="input-xlarge" title="${i18N_sisTable}"></jvform:fileupload>
			<button class="btn btn-info" type="button" onclick="func(${flag})">
				<i class="icon-ok"></i> ${i18N_sImport}
			</button>
		</jvform:form>
		<jvpagetable:table url="/dialog/import/list/${flag}" page="${importTransferList}" htmlTableId="importTransferListTable">
			<jvpagetable:searchTextItem id="dailyListTable_search_line.lineName" title="${i18N_scLine}" key="line.lineName" operat="LIKE" placeholder="" value="${SEARCH_line_lineName}"></jvpagetable:searchTextItem>
			<jvpagetable:searchDatefield id="importTransferListTable_search_operaDate" title="${i18N_cTime}" key="operaDate" value="${SEARCH_operaDate}"></jvpagetable:searchDatefield>
				
			<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
			<jvpagetable:checkColumn></jvpagetable:checkColumn>
			
			<jvpagetable:columnheader>${i18N_siTableName}</jvpagetable:columnheader>
			<jvpagetable:column id="name">
			<a href="${ctx}/importAcc/look${flag}/${entity.id}/${flag}" target="_parent">${entity.name}</a>
			</jvpagetable:column> 
			
			<jvpagetable:columnheader>${i18N_scLine}</jvpagetable:columnheader>
			<jvpagetable:column id="line">${entity.line.lineName}</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18N_cDate}</jvpagetable:columnheader>
			<jvpagetable:column id="operaDate">
				<fmt:formatDate value="${entity.operaDate}" pattern="yyyy-MM-dd"/>
			</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18N_siTime}</jvpagetable:columnheader>
			<jvpagetable:column id="createDate">
				<fmt:formatDate value="${entity.createDate}" pattern="yyyy-MM-dd HH:mm"/>
			</jvpagetable:column>
			
			<jvpagetable:columnheader>${i18N_siPerson}</jvpagetable:columnheader>
			<jvpagetable:column id="createUser">${entity.createUser.person.name}</jvpagetable:column>
			
		</jvpagetable:table>
	</jvlayout:col>
</jvlayout:row>

<script type="text/javascript">
function func(q) {
	
	$("#up"+q).submit();
}
</script>