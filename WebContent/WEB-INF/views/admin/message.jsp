<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>

<spring:message code="message.pageTitle" var="i18n_messagePageTitle"/>
<spring:message code="menu.dashboard" var="i18n_menuDashboard"/>
<spring:message code="common.num" var="i18n_commonNum"/>
<spring:message code="common.title" var="i18n_commonTitle"/>
<spring:message code="common.date" var="i18n_commonDate"/>
<spring:message code="message.outPerson" var="i18n_messageOutPerson"/>
<spring:message code="message.inPerson" var="i18n_messageInPerson"/>
<spring:message code="message.inBox" var="i18n_messageInBox"/>
<spring:message code="message.outBox" var="i18n_messageOutBox"/>
<spring:message code="message.writeEmail" var="i18n_messageWriteBox"/>


<jvnav:pagetitle>
	${i18n_messagePageTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_menuDashboard}" url="/admin" />
	<jvnav:breadcrumbitem title="${i18n_messagePageTitle}" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
<jvlayout:col length="12">
	<div class="metro-nav">
               <div class="metro-nav-block  nav-block-red">
                   <a href="<c:url value='/admin/profile/message/inbox'/>" data-original-title="">
                       <div class="text-center">
                           <i class="icon-inbox"></i>
                       </div>
                       <div class="status">${i18n_messageInBox}</div>
                   </a>
               </div>
               
               <div class="metro-nav-block  nav-block-green">
                   <a href="<c:url value='/admin/profile/message/sent'/>" data-original-title="">
                       <div class="text-center">
                           <i class="icon-location-arrow "></i>
                       </div>
                       <div class="status">${i18n_messageOutBox}</div>
                   </a>
               </div>
               
               <div class="metro-nav-block nav-block-blue ">
                   <a href="<c:url value='/admin/profile/message/write'/>" data-original-title="">
                       <div class="text-center">
                           <i class="icon-edit"></i>
                       </div>
                       <div class="status">${i18n_messageWriteBox}</div>
                   </a>
               </div>
           </div>
           <div class="space10"></div>
           <!--END METRO STATES-->

	</jvlayout:col>
	<jvlayout:row>
	<jvlayout:col length="12">

	<div class="widget widget-tabs ${boxtype eq 'inbox'?'red':'green'}">
               <div class="widget-title">
                   <h4><i class="${boxtype eq 'inbox'?'icon-inbox':'icon-location-arrow'}"></i> ${boxtype eq 'inbox'?'收件箱邮件列表':'发件箱邮件列表'}</h4>
               </div>
               <div class="widget-body">
                   	<jvtable:table htmlTableId="maillist" ajaxSource="/admin/profile/message/ ${boxtype}" check="false" option="false" optionUrlString="message" >
							<jvtable:column title="${i18n_commonNum}" property="id" sortable="false" width="10%"/>
							<jvtable:column title="${i18n_commonTitle}" property="" sortable="false" width="60%" fnRender="<a href=\"${ctx}/admin/profile/message/read/${boxtype }/'+oObj.aData['id']+\'\">\' + oObj.aData['messageTitle'] + \' </a>"   > 
							</jvtable:column>
							 <c:choose>
									<c:when test="${boxtype eq 'inbox'}">
										<jvtable:column title="${i18n_messageOutPerson}" property="creatorName" width="15%"/>
									</c:when>
									<c:otherwise>
										<jvtable:column title="${i18n_messageInPerson}" property="messageRecipientStr" width="15%"/>
									</c:otherwise>
								</c:choose> 
								
	
							
							
							
							<jvtable:column title="${i18n_commonDate}" property="date" width="*"/>
						</jvtable:table> 
                        
                  </div>
           </div>
	</jvlayout:col>
	</jvlayout:row>
	<!-- /row -->
</jvlayout:row>


