<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="taglibs.jsp"%>

<spring:message code="common.unReadCount1" var="i18n_commonUnReadCount1"/>
<spring:message code="common.unReadCount2" var="i18n_commonUnReadCount2"/>
<spring:message code="common.showAllMessages" var="i18n_commonShowAllMessages"/>
<spring:message code="date.YMDHM" var="i18n_YMDHM"/>
<spring:message code="common.myNotes" var="i18n_commonMyNotes"/>
<spring:message code="common.changePass" var="i18n_commonChangePass"/>
<spring:message code="common.loginOut" var="i18n_commonLoginOut"/>

<!-- BEGIN HEADER -->
   <div id="header" class="navbar navbar-inverse navbar-fixed-top">
       <!-- BEGIN TOP NAVIGATION BAR -->
       <div class="navbar-inner">
           <div class="container-fluid">
               <!--BEGIN SIDEBAR TOGGLE-->
               <div class="sidebar-toggle-box hidden-phone">
                   <div class="icon-reorder tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
               </div>
               <!--END SIDEBAR TOGGLE-->
               <!-- BEGIN LOGO -->
               <a class="brand" href="index.html">
                    
               </a>
               <!-- END LOGO -->
               <!-- BEGIN RESPONSIVE MENU TOGGLER -->
               <a class="btn btn-navbar collapsed" id="main_menu_trigger" data-toggle="collapse" data-target=".nav-collapse">
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="arrow"></span>
               </a>
               <!-- END RESPONSIVE MENU TOGGLER -->
               <div id="top_menu" class="nav notify-row">
                   <!-- BEGIN NOTIFICATION -->
                   <ul class="nav top-menu">

                       <!-- BEGIN INBOX DROPDOWN -->
                       <li class="dropdown" id="header_inbox_bar">
                           <a href="index.html#" class="dropdown-toggle" data-toggle="dropdown">
                               <i class="icon-envelope-alt"></i>
                               <span class="badge badge-important">${unReadCount}</span>
                           </a>
                           <ul class="dropdown-menu extended inbox">
                               <li>
                                   <p>${i18n_commonUnReadCount1}${unReadCount}${i18n_commonUnReadCount2}</p>
                               </li>
                               
                               <c:forEach var="message" items="${messageLists}">
									<li><a href="<c:url value='/admin/profile/message/read/inbox/${message.id}'/>">
										<c:if test="${not empty message.creatorHeadImage}">
											<span class="photo"><img src="<c:url value='${message.creatorHeadImage}'/>" alt="${message.creatorHeadImage}"  /></span>
										</c:if>
										<c:if test="${empty message.creatorHeadImage}">
											<span class="photo"><img src="<c:url value='/static/img/avatar-mini.png'/>" alt="${message.creatorHeadImage}" /></span>
										</c:if>
										<span class="subject">
										<span class="from">${message.creatorName}</span>
									<span class="time"><fmt:formatDate var="dt" value="${message.date}" pattern="${i18n_YMDHM}"/>
													${dt}</span>
									</span>
									<span class="message">
									    ${message.messageTitle}
									</span>
									</a></li>
								</c:forEach>
                               
                          
                              <li><a href="<c:url value='/admin/profile/message/inbox'/>"> ${i18n_commonShowAllMessages} <i
								class="icon-arrow-right"></i>
						</a></li>
                           </ul>
                       </li>
                       <!-- END INBOX DROPDOWN -->
 						<li class="dropdown" id="header_notification_bar">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">

                               <i class="icon-tasks"></i>
                               <span class="badge badge-warning">${taskCount}</span>
                           </a>
                           <ul class="dropdown-menu extended notification">
                               <li>
                                   <p>你有${taskCount}条待办信息</p>
                               </li>
                               <c:forEach var="task" items="${taskList}">
									<li><a href="#">
											  <span class="label label-important"><i class="icon-bolt"></i></span>
                                      ${task.description}
                                      <br><span class="time"><fmt:formatDate var="dt" value="${task.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
													${dt}</span>
									</a> </li>
							</c:forEach>
                               <li>
                                   <a href="${ctx}/admin/profile/task">查看待办列表 <i class="icon-arrow-right"></i></a>
                               </li>
                           </ul>
                       </li>
                   </ul>
               </div>
               <!-- END  NOTIFICATION -->
               <div class="top-nav ">
                   <ul class="nav pull-right top-menu" >
                       <!-- BEGIN USER LOGIN DROPDOWN -->
                       <li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <c:if test="${not empty currentUser.person.headImage}">
									<img src="<c:url value='${currentUser.person.headImage}'/>" alt="${currentUser.person.name}" height=30 width=30 />
								</c:if>
                               <c:if test="${empty currentUser.person.headImage}">
									<img src="<c:url value='/static/img/avatar1_small.jpg'/>" alt="${currentUser.person.name}" />
								</c:if>
                               <span class="username">${currentUser.person.name}</span>
                               <b class="caret"></b>
                           </a>
                           <ul class="dropdown-menu extended logout">
                               <li><a href="<c:url value='/admin/sys/person/editInfo' />"><i class="icon-user"></i>${i18n_commonMyNotes}</a></li>
                               <li><a href="<c:url value='/admin/auth/user/editPassword' />"><i class="icon-lock"></i>${i18n_commonChangePass}</a></li>
                               <li><a href="<c:url value='/logout'/>"><i class="icon-off"></i>${i18n_commonLoginOut}</a></li>
                           </ul>
                       </li>
                       <!-- END USER LOGIN DROPDOWN -->
                   </ul>
                   <!-- END TOP NAVIGATION MENU -->
               
               </div>
           </div>
       </div>
       <!-- END TOP NAVIGATION BAR -->
   </div>
   <!-- END HEADER -->
   
