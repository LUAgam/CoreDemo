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

	<jvlayout:row>

		<jvlayout:col length="12">
		<jvpanel:panelNoTools color="green" title="报表类型" icon="icon-table">
			<jvpagetable:table url="/dialog/statReportClass" page="${statReportClassList}" htmlTableId="statReportClassListTable">
				
				<jvpagetable:searchTextItem operat="LIKE" key="numNo" value="${SEARCH_numNo}" title="报表编号" id="numNo"></jvpagetable:searchTextItem>
				<jvpagetable:searchTextItem operat="LIKE" key="description" value="${SEARCH_description}" title="描述" id="description"></jvpagetable:searchTextItem>
				<jvpagetable:searchSelectOption options="${typeList}" key="typeStr" title="类型" value="${SEARCH_typeStr}" id="typeStr"></jvpagetable:searchSelectOption>
 
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>编号</jvpagetable:columnheader>
				<jvpagetable:column id="tableCo">${entity.tableCo}</jvpagetable:column>
				
				<jvpagetable:columnheader>描述</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
				
				<jvpagetable:columnheader>类型</jvpagetable:columnheader>
				<jvpagetable:column id="typeStr">${entity.typeStr}</jvpagetable:column>
				
				
			</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
	</jvlayout:row>
<!-- /.page-content -->


