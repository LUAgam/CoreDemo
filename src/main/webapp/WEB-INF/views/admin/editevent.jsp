<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>

<spring:message code="menu.dashboard" var="i18n_menuDashboard"/>
<spring:message code="menu.dashboard.calendar" var="i18n_dashboardCalendar"/>
<spring:message code="editevent.pageTitle" var="i18n_editeventPageTitle"/>
<spring:message code="editevent.placeholder" var="i18n_editeventPlaceholder"/>
<spring:message code="editevent.startTime" var="i18n_editeventStartTime"/>
<spring:message code="editevent.endTime" var="i18n_editeventEndTime"/>
<spring:message code="editevent.allDay" var="i18n_editeventAllDay"/>
<spring:message code="editevent.content" var="i18n_editeventContent"/>
<spring:message code="editevent.color" var="i18n_editeventColor"/>
<spring:message code="common.title" var="i18n_editeventTitle"/>

<jvnav:pagetitle>
	${i18n_editeventPageTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_menuDashboard}" url="/admin" />
	<jvnav:breadcrumbitem title="${i18n_dashboardCalendar}" url="/admin/profile/calendar" />
	<jvnav:breadcrumbitem title="${i18n_editeventPageTitle}" active="true" />
</jvnav:breadcrumb>

	<jvlayout:row>
		<jvlayout:col length="12">
			<!-- PAGE CONTENT BEGINS -->

			<jvform:form id="eventform" action="/admin/profile/calendar/write">	
				<jvform:hidden id="id" value="${event.id}"></jvform:hidden>
				<jvform:textfield id="title" title="${i18n_editeventTitle}" placeholder="${i18n_editeventPlaceholder}"  size="xlarge"	value="${event.title}" required="true"></jvform:textfield>
				<jvform:datetimefield id="startDate" required="true" title="${i18n_editeventStartTime}" value="${event.startDate}"></jvform:datetimefield>
				<jvform:datetimefield id="endDate" required="false" title="${i18n_editeventEndTime}" value="${event.endDate}"></jvform:datetimefield>
				<jvform:checkbox id="allDay" title="${i18n_editeventAllDay}" value="${event.allDay}"></jvform:checkbox>
				<jvform:ueditor id="content" title="${i18n_editeventContent}" value="${event.content}"></jvform:ueditor>
				<jvform:colorpicker id="color" title="${i18n_editeventColor}" required="true" value="${event.color}"></jvform:colorpicker>
				
				<jvform:footbar>
					<jvform:submit />
						&nbsp; &nbsp; &nbsp;
						<jvform:cancel />
						&nbsp; &nbsp; &nbsp;
				</jvform:footbar>
			
			</jvform:form>
		</jvlayout:col>
	</jvlayout:row>
	<!-- /row -->

