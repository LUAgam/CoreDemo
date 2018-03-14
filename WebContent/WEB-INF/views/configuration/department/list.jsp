<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="department.manager" var="i18n_departmentManager" />
<spring:message code="system.pageTitle" var="i18n_systemPageTitle" />
<spring:message code="department.departManager" var="i18n_departmentDepartManager" />
<spring:message code="widget.form.add" var="i18n_widgetFormAdd" />
<spring:message code="department.name" var="i18n_departmentName" />
<spring:message code="widget.form.change" var="i18n_widgetFormChange" />
<spring:message code="common.delete" var="i18n_commonDelete" />
<spring:message code="common.message" var="i18n_commonMessage" />
<spring:message code="common.num" var="i18n_commonNum" />
<spring:message code="common.name" var="i18n_commonName" />
<spring:message code="department.breiefName" var="i18n_departmentBreiefName" />
<spring:message code="department.parent" var="i18n_departmentParent" />
<spring:message code="common.type" var="commonType" />
<spring:message code="department.ifRightD" var="i18n_departmentIfRightD" />
<spring:message code="department.ifOCCD" var="i18n_departmentIfOCCD" />
<spring:message code="common.DESC" var="i18n_commonDESC" />
<spring:message code="common.descroption" var="i18n_commonDescroption" />
<spring:message code="common.option" var="i18n_commonOption" />

<jvnav:pagetitle>
	${i18n_departmentManager}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_departmentManager}" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
		<jvpanel:panel color="green" title="${i18n_departmentDepartManager}" icon="icon-th-large">
			<c:if test="${not empty message}">
				<div class="alert alert-danger">
					<strong> <i class="icon-remove"></i> ${i18n_commonMessage}
					</strong> <br /> ${message}
				</div>
			</c:if>


			<jvpagetable:table htmlTableId="departmentListTable" page="${departmentList}" url="/admin/sys/department">

				<jvpagetable:toolbarButton color="btn-success" url="${ctx}/admin/sys/department/add" icon="icon-plus" title="${i18n_widgetFormAdd}"></jvpagetable:toolbarButton>
				<jvpagetable:searchTextItem id="menuListTable_search_name" title="${i18n_departmentName}" key="name" operat="LIKE" placeholder=""
					value="${SEARCH_name}"></jvpagetable:searchTextItem>
				<jvpagetable:searchTextItem id="menuListTable_search_no" title="编号" key="no" operat="LIKE" placeholder="" value="${SEARCH_no}"></jvpagetable:searchTextItem>

				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				<jvpagetable:columnheader>编号</jvpagetable:columnheader>
				<jvpagetable:column id="no">${entity.no}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_commonName}</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_departmentParent}</jvpagetable:columnheader>
				<jvpagetable:column id="parentName">${entity.parentDepartment.name}</jvpagetable:column>
				<jvpagetable:columnheader>排序</jvpagetable:columnheader>
				<jvpagetable:column id="priority">${entity.priority}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_commonDescroption}</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.description}</jvpagetable:column>
				<jvpagetable:columnheader>${i18n_commonOption}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
					<jvpagetable:OptionColumnItem title="岗位" url="${ctx}/admin/sys/department/editGroup/${entity.id}" style="btn btn-small btn-info"></jvpagetable:OptionColumnItem>
					<jvpagetable:OptionColumnItem title="${i18n_widgetFormChange}" url="${ctx}/admin/sys/department/edit/${entity.id}"
						style="btn btn-small btn-warning"></jvpagetable:OptionColumnItem>
					<jvpagetable:OptionColumnItem title="${i18n_commonDelete}" url="${ctx}/admin/sys/department/delete/${entity.id}" style="btn btn-small btn-danger"></jvpagetable:OptionColumnItem>

				</jvpagetable:OptionColumn>
			</jvpagetable:table>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<!-- /.page-content -->


