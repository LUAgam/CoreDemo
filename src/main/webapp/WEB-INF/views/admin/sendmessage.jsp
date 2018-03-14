<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>

<spring:message code="menu.dashboard" var="i18n_menuDashboard"/>
<spring:message code="message.pageTitle" var="i18n_messagePageTitle"/>
<spring:message code="message.editNewMessage" var="i18n_messageEditNewMessage"/>
<spring:message code="message.inPerson" var="i18n_messageInPerson"/>
<spring:message code="message.title" var="i18n_messageTitle"/>
<spring:message code="message.content" var="i18n_messageContent"/>
<spring:message code="message.fujiancontent" var="i18n_messageFujiancontent"/>
<spring:message code="message.placeholder" var="i18n_messagePlaceholder"/>
<spring:message code="message.editEmail" var="i18n_messageEditEmail"/>
<spring:message code="common.errMessage" var="i18n_commonErrMessage"/>
<spring:message code="widget.form.click" var="i18n_widgetFormClick"/>
<spring:message code="widget.form.cancel" var="i18n_widgetFormCancel"/>

<jvnav:pagetitle>
	${i18n_messageEditNewMessage}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_menuDashboard}" url="/admin" />
	<jvnav:breadcrumbitem title="${i18n_messagePageTitle}" active="<c:url value='/admin/profile/message/inbox/0'/>" />
	<jvnav:breadcrumbitem title="${i18n_messageEditNewMessage}" active="true" />
</jvnav:breadcrumb>

	<jvlayout:row>
		<jvlayout:col length="12">
			
				<div class="widget widget-tabs blue">
					<div class="widget-title">
                   <h4><i class="icon-edit"></i> ${i18n_messageEditEmail}</h4>
               </div>
               <div class="widget-body">
					<form id="id-message-form" action="<c:url value='/admin/profile/message/write'/>"	class="form-horizontal" method="post" enctype="multipart/form-data">
								<c:if test="${not empty message}">
									<div class="alert alert-danger">
										<strong> <i class="icon-remove"></i> ${i18n_commonErrMessage}
										</strong> <br /> ${message}
									</div>
								</c:if>
								
					<jvform:entityselector id="recipientId" height="700" width="1024" url="${ctx}/dialog/person/list" dialogtitle="${i18n_messageInPerson}" title="${i18n_messageInPerson}" tableId="personListTable" tableDisplayNameColumnName="name" value="${message.recipientStr}" valueId="${message.recipientId }"/>	
					<jvform:textfield id="title" title="${i18n_messageTitle}" placeholder="${i18n_messagePlaceholder}" value="${message.title}" size="span5" required="true"></jvform:textfield>
					<jvform:ueditor title="${i18n_messageContent}" id="messageContent" rows="20" >${message.messageContent}</jvform:ueditor>
					<jvform:fileupload title="${i18n_messageFujiancontent}" id="attachment[0]"></jvform:fileupload>
					
				
				<!-- 	<div class="pull-right">
						<button id="id-add-attachment" type="button" class="btn btn-sm btn-danger">
							<i class="icon-paper-clip bigger-140"></i> 添加附件
						</button>
					</div> -->
					<div class="space20"></div>
					
					<div class="form-actions">
    							<button type="submit" class="btn btn-primary"><i class="icon-ok"></i> ${i18n_widgetFormClick}</button>
    							<button type="button" class="btn" onclick="history.back();"><i class=" icon-remove"></i> ${i18n_widgetFormCancel}</button>
							</div>
					</form>

						</div>
						<!-- /.message-container -->
					</div>
					<!-- /.tab-pane -->
		</jvlayout:col>
	</jvlayout:row>
	<!-- /row -->

<script type="text/javascript">
<!--

//-->

var attachment_index = 0;

//the button to add a new file input
$('#id-add-attachment').on('click', function(){
	var file = $('<div class="space20"></div><div class="input-append"><div class="uneditable-input"><i class="icon-file fileupload-exists"></i><span class="fileupload-preview"></span></div><span class="btn btn-file"><span class="fileupload-new">选择文件</span><span class="fileupload-exists">修改</span><input type="file" name="attachment[' + attachment_index + ']"/></span><a data-dismiss="fileupload" class="btn fileupload-exists" href="form_component.html#">移除</a></div>').appendTo('#fileupload');
	attachment_index = attachment_index + 1;
});

</script>

