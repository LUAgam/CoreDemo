<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="menu.dashboard" var="i18n_menuDashboard"/>
<spring:message code="menu.dashboard.calendar" var="i18n_menuDashboardCalendar"/>
<spring:message code="editevent.createDaily" var="i18n_editeventCreateDaily"/>
<spring:message code="editevent.writeEvent" var="i18n_editeventWriteEvent"/>
<spring:message code="common.title" var="i18n_commonTitle"/>
<spring:message code="editevent.placeholder" var="i18n_editeventPlaceholder"/>
<spring:message code="editevent.startTime" var="i18n_editeventStartTime"/>
<spring:message code="editevent.endTime" var="i18n_editeventEndTime"/>
<spring:message code="editevent.allDay" var="i18n_editeventAllDay"/>
<spring:message code="editevent.content" var="i18n_editeventContent"/>
<spring:message code="editevent.color" var="i18n_editeventColor"/>
<spring:message code="editevent.create" var="i18n_editEventCreate"/>
<spring:message code="message.inPerson" var="i18n_messageInPerson"/>

<jvnav:pagetitle>
	编写日程
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_menuDashboard}" url="/admin" />
	<jvnav:breadcrumbitem title="日程展示" url="/admin/profile/allcalendar" />
	<jvnav:breadcrumbitem title="编写日程" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
		<jvpanel:panel color="green" title="${i18n_editeventWriteEvent}" icon="icon-edit">
			<!-- PAGE CONTENT BEGINS -->

			<jvform:form id="eventform" action="/admin/profile/allcalendar/write">
				<jvform:entityselector id="recipientId" height="700" width="1024" url="${ctx}/dialog/person/list" dialogtitle="${i18n_messageInPerson}" title="人员" tableId="personListTable" tableDisplayNameColumnName="name" value="${event.recipientStr}" valueId="${event.recipientId }" required="true"/>	
				<jvform:textfield id="title" title="${i18n_commonTitle}" placeholder="${i18n_editeventPlaceholder}" size="xlarge"  value="${event.title}"	required="true"></jvform:textfield>
				<jvform:datetimefield id="startDate" required="true" title="${i18n_editeventStartTime}"  value="${event.startDate}"></jvform:datetimefield>
				<jvform:datetimefield id="endDate" required="false" title="${i18n_editeventEndTime}"  value="${event.endDate}"></jvform:datetimefield>
				<jvform:checkbox id="allDay" title="${i18n_editeventAllDay}"  value="${event.allDay}"></jvform:checkbox>
				<jvform:ueditor id="content" title="${i18n_editeventContent}"  value="${event.content}"></jvform:ueditor>
				<jvform:colorpicker id="color" title="${i18n_editeventColor}" value="${event.color}" required="true"></jvform:colorpicker>
				
				<jvform:footbar>
					<jvform:submit />
						&nbsp; &nbsp; &nbsp;
						<jvform:cancel />
						&nbsp; &nbsp; &nbsp;
				</jvform:footbar>
				
			</jvform:form>
		
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>
<!-- /row -->

<!-- /.page-content -->
