<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="person.personManager" var="i18n_personPersonManager" />
<spring:message code="system.pageTitle" var="i18n_systemPageTitle" />
<spring:message code="widget.form.add" var="i18n_widgetFormAdd" />
<spring:message code="person.department" var="i18n_personDepartment" />
<spring:message code="widget.form.change" var="i18n_widgetFormChange" />
<spring:message code="common.delete" var="i18n_commonDelete" />
<spring:message code="common.message" var="i18n_commonMessage" />

<spring:message code="person.name" var="i18n_personName" />
<spring:message code="person.inDepartment" var="i18n_personInDepartment" />
<spring:message code="person.number" var="i18n_personNumber" />
<spring:message code="person.sex" var="i18n_personSex" />
<spring:message code="person.title" var="i18n_personTitle" />
<spring:message code="person.subject" var="i18n_personSubject" />
<spring:message code="person.email" var="i18n_personEmail" />
<spring:message code="person.phoneNumber" var="i18n_personPhoneNumber" />
<spring:message code="person.shortNumber" var="i18n_personShortNumber" />
<spring:message code="person.officeNumber" var="i18n_personOfficeNumber" />
<spring:message code="person.officeRoom" var="i18n_personOfficeRoom" />
<spring:message code="common.option" var="i18n_commonOption" />
<jvlayout:row>
	<jvlayout:col length="12">
		<jvpanel:panel color="green" title="岗位列表" icon="icon-table">
			<jvpagetable:table htmlTableId="groupListTable" page="${groupList}" url="/dialog/group/list">

				<jvpagetable:searchTextItem id="groupListTable_search_name" title="名称" key="name" operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>

				<jvpagetable:searchTextItem id="personListTable_search_no" title="编号" key="number" operat="LIKE" placeholder="" value="${SEARCH_no}"></jvpagetable:searchTextItem>
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				<!--String 控件-->
				<jvpagetable:columnheader id="name">名称</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}	</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader id="no">编号</jvpagetable:columnheader>
				<jvpagetable:column id="no">${entity.no}</jvpagetable:column>

				<!--Date 日期控件-->
				<jvpagetable:columnheader id="description">描述</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.description}</jvpagetable:column>

				<!--Date 日期控件-->
				<jvpagetable:columnheader id="available">是否启用</jvpagetable:columnheader>
				<jvpagetable:column id="available">${entity.available? '是':'否'}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader id="parentGroup">父组</jvpagetable:columnheader>
				<jvpagetable:column id="parentGroup">${entity.parentGroup.name}</jvpagetable:column>
				<jvpagetable:columnheader id="priority">序号</jvpagetable:columnheader>
				<jvpagetable:column id="priority">${entity.priority}</jvpagetable:column>
			</jvpagetable:table>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>



