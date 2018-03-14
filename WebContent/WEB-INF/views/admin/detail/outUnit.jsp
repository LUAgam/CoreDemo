<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="outUnit.title" var="i18n_outUnitTitle"/>
<spring:message code="detail.title.parent" var="i18n_detailTitleParent"/>
<spring:message code="detail.YYYYMMDD" var="i18n_YYYYMMDD"/>
<spring:message code="outUnit.name" var="i18n_Name"/>
<spring:message code="outUnit.outUnitName" var="i18n_outUnitName"/>
<spring:message code="outUnit.idCardNo" var="i18n_idCarNo"/>
<spring:message code="outUnit.phoneNumber" var="i18n_PhoneNumber"/>
<spring:message code="outUnit.education" var="i18n_education"/>
<spring:message code="outUnit.certificateName" var="i18n_certificateName"/>
<spring:message code="outUnit.certificateNum" var="i18n_certificateNum"/>
<spring:message code="outUnit.validDate" var="i18n_validDate"/>
<spring:message code="outUnit.titleName" var="i18n_titleName"/>
<spring:message code="outUnit.status" var="i18n_status"/>
<spring:message code="outUnit.workscopeName" var="i18n_workscopeName"/>

<jvnav:pagetitle>
	${i18n_outUnitTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_detailTitleParent}" active="true" />
</jvnav:breadcrumb>


<jvpanel:panel color="green" title="${i18n_outUnitTitle}" icon="icon-table">
	<jvlayout:row>


		<jvlayout:col length="12">

			<jvpagetable:table htmlTableId="outPersonListTable"
				page="${outUnitList}" url="/lms/portalDetail">

				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>


				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_Name}</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.name}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_outUnitName}</jvpagetable:columnheader>
				<jvpagetable:column id="outUnit">${entity.outUnit.name}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_idCarNo}</jvpagetable:columnheader>
				<jvpagetable:column id="idCardNo">${entity.idCardNo}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_PhoneNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="phoneNumber">${entity.phoneNumber}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_education}</jvpagetable:columnheader>
				<jvpagetable:column id="education">${entity.education}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_certificateName}</jvpagetable:columnheader>
				<jvpagetable:column id="certificateName">${entity.certificateName}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_certificateNum}</jvpagetable:columnheader>
				<jvpagetable:column id="certificateNum">${entity.certificateNum}</jvpagetable:column>

				<!--Date 日期控件-->
				<jvpagetable:columnheader>${i18n_validDate}</jvpagetable:columnheader>
				<jvpagetable:column id="validDate">
					<fmt:formatDate value="${entity.validDate}" pattern="${i18n_YYYYMMDD}" />
				</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_titleName}</jvpagetable:columnheader>
				<jvpagetable:column id="title">${entity.title.name}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_status}</jvpagetable:columnheader>
				<jvpagetable:column id="status">${entity.status}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_workscopeName}</jvpagetable:columnheader>
				<jvpagetable:column id="workscope">${entity.workscope.name}</jvpagetable:column>


			</jvpagetable:table>
		</jvlayout:col>
	</jvlayout:row>
</jvpanel:panel>

<!-- /.page-content -->


