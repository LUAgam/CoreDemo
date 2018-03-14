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
	<jvnav:breadcrumbitem title="我的已办" active="true" />
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

</jvlayout:row>

	<jvlayout:row>
	<jvlayout:col length="12">
		<jvpanel:panel color="blue" title="办结任务列表">

              	<jvpagetable:table htmlTableId="taskTodoTable" page="${finishedTaskPage}" url="/doneTask">

				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>

				<!--String 控件-->
				<jvpagetable:columnheader>待办描述</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.name}</jvpagetable:column>
				
				
				<jvpagetable:columnheader>开始时间</jvpagetable:columnheader>
				<jvpagetable:column id="startTime"><fmt:formatDate var="dt" value="${entity.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
													${dt}</jvpagetable:column>
													
				<jvpagetable:columnheader>结束时间</jvpagetable:columnheader>
				<jvpagetable:column id="startTime"><fmt:formatDate var="dt" value="${entity.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
													${dt}</jvpagetable:column>
				
	
			
				<jvpagetable:columnheader>操作</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
					<jvpagetable:OptionColumnItem title="查看"
						url="${ctx}/task/todo/"
						style="btn btn-small btn-success"></jvpagetable:OptionColumnItem>
				</jvpagetable:OptionColumn>
				

			</jvpagetable:table>
		</jvpanel:panel>
	</jvlayout:col>
	</jvlayout:row>
	<!-- /row -->


