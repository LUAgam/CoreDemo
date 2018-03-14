<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>

<spring:message code="menu.dashboard" var="i18n_menuDashboard"/>
<spring:message code="message.pageTitle" var="i18n_messagePageTitle"/>
<spring:message code="date.YMDHM" var="i18n_YMDHM"/>
<spring:message code="common.delete" var="i18n_commonDelete"/>
<spring:message code="common.back" var="i18n_commonBack"/>
<spring:message code="common.jin" var="i18n_commonJin"/>
<spring:message code="common.option" var="i18n_commonOption"/>
<spring:message code="message.callBack" var="i18n_messageCallBack"/>
<spring:message code="message.trans" var="i18n_messageTrans"/>
<spring:message code="message.read" var="i18n_messageRead"/>
<spring:message code="message.unRead" var="i18n_messageUnRead"/>
<spring:message code="message.fujian" var="i18n_messageFuJian"/>
<spring:message code="message.files" var="i18n_messageFiles"/>
<spring:message code="message.MB" var="i18n_messageMB"/>
<spring:message code="message.fujianName" var="i18n_messageFuJianName"/>


<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_menuDashboard}" url="/admin" />
	<jvnav:breadcrumbitem title="${i18n_messagePageTitle}" active="true" />
</jvnav:breadcrumb>
                                                                          

<jvlayout:row>
	<jvlayout:col length="12">
		<div class="widget widget-tabs ${boxtype eq 'inbox'?'red':'green'}">
			<div class="widget-title">
                   <h4><i class="icon-envelope"></i> </h4>
            </div>
            <div class="widget-body">
					<p>
                         <a class="btn btn-large" onclick="history.back();">${i18n_commonBack}</a>
                         <a class="btn btn-large btn-primary" href="${ctx}/admin/profile/message/transpond/1/${message.id}">${i18n_messageCallBack}</a>
                         <a class="btn btn-large btn-info" href="${ctx}/admin/profile/message/transpond/2/${message.id}">${i18n_messageTrans}</a>
                         <a class="btn btn-large btn-success" href="${ctx}/admin/profile/message/sign/READ/${boxtype}/${message.id}">${i18n_messageRead}</a>
                         <a class="btn btn-large btn-warning" href="${ctx}/admin/profile/message/sign/UNREAD/${boxtype}/${message.id}">${i18n_messageUnRead}</a>
                         <a class="btn btn-large btn-danger" href="${ctx}/admin/profile/message/remove/${boxtype}/${message.id}"> ${i18n_commonDelete}</a>
                     </p>
                     
                   <div class="blog">
                                     
                         <div class="span12">
                             <h2>
                                  ${message.messageTitle} 
                             </h2>
 
                             	<fmt:formatDate var="dt" value="${message.date}" pattern="${i18n_YMDHM}" />
                                 <c:choose>
										<c:when test="${boxtype eq 'inbox'}">
											<span class="photo"><img alt="${sender.name}" 
												src="<c:url value='${empty sender.headImage?"/static/img/avatar-mini.png":sender.headImage}'/>"
												/></span>
											&nbsp; 
											<span class="author">${sender.name}</span> | ${dt}
										</c:when>
										<c:otherwise>
											<span class="photo"><img alt="${message.messageRecipientStr}" 
												src="<c:url value='/static/img/avatar-mini.png'/>"
												/></span>
											&nbsp; 
											<span class="author">${message.messageRecipientStr}</span> | ${dt}
										</c:otherwise>
									</c:choose> 
         
                             
                             <p> ${message.messageContent}</p>
                         </div>
                         	<p><span class="blue bolder bigger-110">${i18n_messageFuJian}</span> &nbsp; <span
										class="grey">(${attachment.filecount} ${i18n_messageFiles}<fmt:formatNumber
											value="${attachment.filelength/(1024*1024)}" type="number"
											pattern="#,##0.0#" /> ${i18n_messageMB})
									</span></p>
                         <table class="table table-striped">
                                    <thead>
                                    <tr>
                                        <th>${i18n_commonJin}</th>
                                        <th>${i18n_messageFuJianName}</th>
                                        <th>${i18n_commonOption}</th>
                                    
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="attachmentItem"
										items="${attachment.attachmentList}" varStatus="status">
										<tr>
										<td> ${status.index}	</td>
                                        <td>
                                   		<a
											href="<c:url value='/admin/profile/message/download/${attachmentItem.messageAttachmentId}'/>"
											class="attached-file inline"> <i
												class="icon-file-alt bigger-110 middle"></i>${attachmentItem.fileName}</a>
										</td>
										<td>
											<div class="action-buttons inline">
												<a
													href="<c:url value='/admin/profile/message/download/${attachmentItem.messageAttachmentId}'/>">
													<i class="icon-download-alt bigger-125 blue"></i>
												</a>

											</div>
											</td>
											 </tr>
									</c:forEach>
                     </div>

			</div>
				<!-- /.message-container -->
		</div>

	</jvlayout:col>
</jvlayout:row>
<!-- /row -->
