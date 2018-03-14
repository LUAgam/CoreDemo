<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="person.personManager" var="i18n_personPersonManager"/>
<spring:message code="system.pageTitle" var="i18n_systemPageTitle"/>
<spring:message code="widget.form.add" var="i18n_widgetFormAdd"/>
<spring:message code="person.department" var="i18n_personDepartment"/>
<spring:message code="widget.form.change" var="i18n_widgetFormChange"/>
<spring:message code="common.delete" var="i18n_commonDelete"/>
<spring:message code="common.message" var="i18n_commonMessage"/>

<spring:message code="person.name" var="i18n_personName"/>
<spring:message code="person.inDepartment" var="i18n_personInDepartment"/>
<spring:message code="person.number" var="i18n_personNumber"/>
<spring:message code="person.sex" var="i18n_personSex"/>
<spring:message code="person.title" var="i18n_personTitle"/>
<spring:message code="person.subject" var="i18n_personSubject"/>
<spring:message code="person.email" var="i18n_personEmail"/>
<spring:message code="person.phoneNumber" var="i18n_personPhoneNumber"/>
<spring:message code="person.shortNumber" var="i18n_personShortNumber"/>
<spring:message code="person.officeNumber" var="i18n_personOfficeNumber"/>
<spring:message code="person.officeRoom" var="i18n_personOfficeRoom"/>
<spring:message code="common.option" var="i18n_commonOption"/>

<jvnav:pagetitle>
	${i18n_personPersonManager}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_personPersonManager}" active="true" />
</jvnav:breadcrumb>

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
		<jvpanel:panel color="green" title="${i18n_personPersonManager}" icon="icon-table">
			<jvpagetable:table htmlTableId="personListTable"
				page="${personList}" url="/admin/sys/person">


				
				<jvpagetable:searchTextItem id="personListTable_search_name" title="${i18n_personName}" key="name" 
					operat="LIKE" placeholder="" value="${SEARCH_name}"></jvpagetable:searchTextItem>
					
				<jvpagetable:searchTextItem id="personListTable_search_number" title="${i18n_personNumber}" key="number" 
				operat="LIKE" placeholder="" value="${SEARCH_number}"></jvpagetable:searchTextItem>

	
				<jvpagetable:toolbarButton color="btn-success"	url="${ctx}/admin/sys/person/add" icon="icon-plus" title="${i18n_widgetFormAdd}"></jvpagetable:toolbarButton>
				<jvpagetable:toolbarExportButton></jvpagetable:toolbarExportButton>
					

				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>


				<!--String 控件-->
				<jvpagetable:columnheader id="name">${i18n_personName}</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}	</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader id="department_name">${i18n_personInDepartment}</jvpagetable:columnheader>
				<jvpagetable:column id="department_name">${entity.department.name}</jvpagetable:column>
				
				<!--Date 日期控件-->
				<jvpagetable:columnheader id="number">${i18n_personNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="number">${entity.number}</jvpagetable:column>

				<!--Date 日期控件-->
				<jvpagetable:columnheader  id="gender">${i18n_personSex}</jvpagetable:columnheader>
				<jvpagetable:column id="gender">${entity.gender eq 'MALE' ? '男':'女'}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader  id="title">${i18n_personTitle}</jvpagetable:columnheader>
				<jvpagetable:column id="title">${entity.title}</jvpagetable:column>
				
				<!--String 控件-->
				<jvpagetable:columnheader id="email">${i18n_personEmail}</jvpagetable:columnheader>
				<jvpagetable:column id="email">${entity.email}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader id="phoneNumber">${i18n_personPhoneNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="phoneNumber">${entity.phoneNumber}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader id="officeNumber">${i18n_personOfficeNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="officeNumber">${entity.officeNumber}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader id="officeRoom">${i18n_personOfficeRoom}</jvpagetable:columnheader>
				<jvpagetable:column id="officeRoom">${entity.officeRoom}</jvpagetable:column>
					
				<jvpagetable:columnheader>${i18n_commonOption}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
						<jvpagetable:OptionColumnItem title="${i18n_widgetFormChange}"
							url="${ctx}/admin/sys/person/edit/${entity.id}"
							style="btn btn-small btn-warning"></jvpagetable:OptionColumnItem>
						<jvpagetable:OptionColumnItem title="${i18n_commonDelete}"
							url="${ctx}/admin/sys/person/delete/${entity.id}"
							style="btn btn-small btn-danger"></jvpagetable:OptionColumnItem>
						<jvpagetable:OptionColumnItem title="创建账号"
							url="${ctx}/admin/sys/person/user/${entity.id}"
						style="btn btn-small btn-success"></jvpagetable:OptionColumnItem>
				</jvpagetable:OptionColumn>

			</jvpagetable:table>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<!-- /.page-content -->


