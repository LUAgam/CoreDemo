<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<jvnav:pagetitle>
	表格
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="首页" url="/admin"></jvnav:breadcrumbitem>
	<jvnav:breadcrumbitem title="示例" url="/examples"></jvnav:breadcrumbitem>
	<jvnav:breadcrumbitem title="表格" active="true"></jvnav:breadcrumbitem>
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
  		<jvpanel:panel color="green" title="表格" icon="icon-table">
  			<jvtable:table htmlTableId="personlist" ajaxSource="/person/list" check="true" option="true" optionUrlString="person" >
				<jvtable:toolbar newButton="true" delButton="false" search="true" advSearch="false" searchLab="姓名" searchProperty="name">
					
				</jvtable:toolbar>
				
				<jvtable:column title="序号" property="id" sortable="false" width="20px"/>
				<jvtable:column title="姓名" property="name" sortable="true" width="50px"/>
				<jvtable:column title="工号" property="number" sortable="true" width="50px"/>
			<%-- 	<jvtable:column title="身份证号码" property="number" sortable="false" width="200px"/> --%>
				<jvtable:column title="部门" property="departmentName" sortable="false" width="50px"/>
				<jvtable:column title="离职" property="dimissionString" sortable="false" width="50px"/>
				<jvtable:column title="备注" property="comment" width="100px"/>		
			</jvtable:table>
  		</jvpanel:panel>
  	</jvlayout:col>	
  	
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="12">
  		<jvpanel:panel color="red" title="表格" icon="icon-table">
	  		<jvpagetable:table htmlTableId="personListTable" page="${personList}" url="/config/person">
					
					<jvpagetable:toolbarButton color="btn-success" url="${ctx}/config/person/add" icon="icon-plus" title="添加"></jvpagetable:toolbarButton>
					<jvpagetable:toolbarButton color="btn-danger" url="#" icon="icon-trash" title="批量删除"></jvpagetable:toolbarButton>
					
					
					<jvpagetable:searchTextItem id="personListTable_search_name" title="姓名" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
					<jvpagetable:searchDatefield  id="personListTable_search_date" title="日期" key="dateString" value="${SEARCH_dateString}"></jvpagetable:searchDatefield>
					<jvpagetable:searchDateRange id="personListTable_search_dateRange" title="创建日期" key="name"></jvpagetable:searchDateRange>
					<jvpagetable:searchTextItem id="personListTable_search_number" title="工号" key="number" operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>
					<jvpagetable:searchTextItem id="personListTable_search_name" title="姓名" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
					<jvpagetable:searchTextItem id="personListTable_search_number" title="工号" key="number" operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>
					<jvpagetable:searchTextItem id="personListTable_search_name" title="姓名" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
					<jvpagetable:searchTextItem id="personListTable_search_number" title="工号" key="number" operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>
					<jvpagetable:searchTextItem id="personListTable_search_name" title="姓名" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
					<jvpagetable:searchTextItem id="personListTable_search_number" title="工号" key="number" operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>
					
					
					
					
					<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
					<jvpagetable:checkColumn></jvpagetable:checkColumn>
					
					<jvpagetable:columnheader style="width:100px;">姓名</jvpagetable:columnheader>
					<jvpagetable:column id="name">${entity.name}</jvpagetable:column>
					
					<jvpagetable:columnheader>工号</jvpagetable:columnheader>
					<jvpagetable:column id="number">${entity.number}</jvpagetable:column>
					
					
					<jvpagetable:columnheader>操作</jvpagetable:columnheader>
					<jvpagetable:OptionColumn>
						<jvpagetable:OptionColumnItem title="修改" url="${ctx}/config/person/edit/${entity.id}" style="btn btn-small btn-warning"></jvpagetable:OptionColumnItem>
						<jvpagetable:OptionColumnItem title="删除" url="${ctx}/config/person/delete/${entity.id}" style="btn btn-small btn-danger"></jvpagetable:OptionColumnItem>
					</jvpagetable:OptionColumn>
					
				</jvpagetable:table>
			</jvpanel:panel> 	
			
  	</jvlayout:col>

</jvlayout:row>