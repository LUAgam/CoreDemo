<%@ page language="java"  pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>


<jvnav:pagetitle>
	任务列表
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="我的工作台" url="/admin" />
	<jvnav:breadcrumbitem title="我的代办" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
<jvlayout:col length="12">
	<div class="metro-nav">
               <div class="metro-nav-block  nav-block-red">
                   <a href="<c:url value='/admin/profile/task'/>" data-original-title="">
                       <div class="text-center">
                           <i class="icon-inbox"></i>
                       </div>
                       <div class="status">我的待办列表</div>
                   </a>
               </div>
               
               <div class="metro-nav-block  nav-block-green">
                   <a href="<c:url value='/admin/profile/task/doneTask'/>" data-original-title="">
                       <div class="text-center">
                           <i class="icon-location-arrow "></i>
                       </div>
                       <div class="status">我的已办列表</div>
                   </a>
               </div>
               
               <div class="metro-nav-block nav-block-blue ">
                   <a href="<c:url value='/admin/profile/task/finisheddone'/>" data-original-title="">
                       <div class="text-center">
                           <i class="icon-edit"></i>
                       </div>
                       <div class="status">我的办结列表</div>
                   </a>
               </div>
           </div>
           <div class="space10"></div>
           <!--END METRO STATES-->

	</jvlayout:col>
	<jvlayout:row>
	<jvlayout:col length="12">
	
		<jvpanel:panel color="red" title="待办任务列表">
	
			 <div class="tabbable custom-tab">
	              <ul class="nav nav-tabs">
	                  <li class="active"><a href="#tab_1_1" data-toggle="tab"><b>未签收</b></a></li>
	                  <li><a href="#tab_1_2" data-toggle="tab"><b>未办理</b></a></li>
	              </ul>
	              <div class="tab-content">
	                  <div class="tab-pane active" id="tab_1_1">
						<iframe src="${ctx}/dialog/task/candidate/list" marginheight="0"
						marginwidth="0" frameborder="0" scrolling="yes" width="100%"
						height="600px" id="iframepageCondidateList" name="iframepageCondidateList" onLoad="iFrameHeight();"></iframe>

	                  </div>
	                  <div class="tab-pane" id="tab_1_2">
	                    		<iframe src="${ctx}/dialog/task/assignee/list" marginheight="0"
					marginwidth="0" frameborder="0" scrolling="yes" width="100%"
					height="600px" id="iframepageAssigneeList" name="iframepageAssigneeList"
					onLoad="iFrameHeight();"></iframe>
	                  </div>
	             
	              </div>
	          </div>
 
		</jvpanel:panel>	
	</jvlayout:col>
	</jvlayout:row>
	<!-- /row -->
</jvlayout:row>


