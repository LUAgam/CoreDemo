<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="table" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="piechart" tagdir="/WEB-INF/tags/piechart"%>
<%@ taglib prefix="infobox" tagdir="/WEB-INF/tags/infobox"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="charts" tagdir="/WEB-INF/tags/charts"%>
<%@ include file="../taglibs.jsp"%>

<spring:message code="menu.dashboard" var="i18n_dashboard"/>
<spring:message code="common.index" var="i18n_commonIndex"/>
<spring:message code="menu.dashboard.portal" var="i18n_dashboardPortal"/>

<jvnav:pagetitle>
	${i18n_dashboardPortal}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_dashboard}" url="/admin" />
	<jvnav:breadcrumbitem title="${i18n_dashboardPortal}" active="true" />
</jvnav:breadcrumb>

