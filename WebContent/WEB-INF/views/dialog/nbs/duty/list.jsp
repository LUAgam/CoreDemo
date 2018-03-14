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
	<jvpanel:panelNoTools color="green" title="因素" icon="icon-table">
		<jvpagetable:table url="/dialog/duty" page="${faultMethodList}" htmlTableId="dutyListTable">
			<jvpagetable:searchTextItem id="search_no" title="编号" key="no" operat="LIKE" placeholder="" value="${SEARCH_no}"></jvpagetable:searchTextItem>		
				<jvpagetable:searchTextItem id="search_name" title="描述" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>		
				 
				 <jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>编号</jvpagetable:columnheader>
				<jvpagetable:column id="no">${entity.no}</jvpagetable:column>
				
				<jvpagetable:columnheader>描述</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}</jvpagetable:column>
				
				<jvpagetable:columnheader>排序</jvpagetable:columnheader>
				<jvpagetable:column id="sort">${entity.sort}</jvpagetable:column>
			
		</jvpagetable:table>
		</jvpanel:panelNoTools>
	</jvlayout:col>
</jvlayout:row>