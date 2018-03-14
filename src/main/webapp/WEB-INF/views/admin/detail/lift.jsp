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

<spring:message code="detail.title.parent" var="i18n_detailTitleParent"/>
<spring:message code="detail.title" var="i18n_detailTitle"/>
<spring:message code="detail.YYYYMMDD" var="i18n_YYYYMMDD"/>
<spring:message code="detail.name" var="i18n_detailName"/>
<spring:message code="detail.line" var="i18n_detailLine"/>
<spring:message code="detail.station" var="i18n_detailStation"/>
<spring:message code="detail.liftLocation.name" var="i18n_detailLocationName"/>
<spring:message code="detail.manufacturer" var="i18n_detailManufacturer"/>
<spring:message code="detail.assetNumber" var="i18n_detailAssetNumber"/>
<spring:message code="detail.models" var="i18n_detailModels"/>
<spring:message code="detail.assetType" var="i18n_detailAssetType"/>
<spring:message code="detail.factoryDate" var="i18n_detailFactoryDate"/>
<spring:message code="detail.factoryNum" var="i18n_detailFactoryNum"/>
<spring:message code="detail.useDate" var="i18n_detailUseDate"/>
<spring:message code="detail.createDate" var="i18n_detailCreateDate"/>


<jvnav:pagetitle>
	${i18n_detailTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_detailTitleParent}" url="/portal" active="true" />
	<jvnav:breadcrumbitem title="${i18n_detailTitle}"/>
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
		<!-- PAGE CONTENT BEGINS -->
		<jvpanel:panel color="purple" title="${line.name}${type}${i18n_detailTitle}">
			<jvpagetable:table htmlTableId="liftListTable" page="${liftList}"
				url="/lms/portalDetail/lift/${type}/${line.id}">
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>


				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailName}</jvpagetable:columnheader>
				<jvpagetable:column id="name"><a href='<c:url value="/lms/lift/view/${entity.id}"/>'>${entity.name}</a></jvpagetable:column>

				<jvpagetable:columnheader>${i18n_detailLine}</jvpagetable:columnheader>
				<jvpagetable:column id="liftLocation">${entity.liftLocation.line.name}</jvpagetable:column>

				<jvpagetable:columnheader>${i18n_detailStation}</jvpagetable:columnheader>
				<jvpagetable:column id="liftLocation">${entity.liftLocation.station.name}</jvpagetable:column>


				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailLocationName}</jvpagetable:columnheader>
				<jvpagetable:column id="liftLocation">${entity.liftLocation.name}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailManufacturer}</jvpagetable:columnheader>
				<jvpagetable:column id="manufacturer">${entity.manufacturer}</jvpagetable:column>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailAssetNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="assetNumber">${entity.assetNumber}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailModels}</jvpagetable:columnheader>
				<jvpagetable:column id="models">${entity.models}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailAssetType}</jvpagetable:columnheader>
				<jvpagetable:column id="assetType">${entity.assetType}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailFactoryDate}</jvpagetable:columnheader>
				<jvpagetable:column id="factoryDate">
					<fmt:formatDate value="${entity.factoryDate}" pattern="${i18n_YYYYMMDD}" />
				</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailFactoryNum}</jvpagetable:columnheader>
				<jvpagetable:column id="factoryNum">${entity.factoryNum}</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailUseDate}</jvpagetable:columnheader>
				<jvpagetable:column id="useDate">
					<fmt:formatDate value="${entity.useDate}" pattern="${i18n_YYYYMMDD}" />
				</jvpagetable:column>
				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_detailModels}</jvpagetable:columnheader>
				<jvpagetable:column id="models">${entity.models}</jvpagetable:column>

				<!--Date 日期控件-->
				<jvpagetable:columnheader>${i18n_detailCreateDate}</jvpagetable:columnheader>
				<jvpagetable:column id="createDate">
					<fmt:formatDate value="${entity.createDate}" pattern="${i18n_YYYYMMDD}" />
				</jvpagetable:column>

			</jvpagetable:table>
		
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>