<%@ page language="java"  pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<spring:message code="user.manager" var="i18n_userManager"/>
<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle"/>
<spring:message code="user.list" var="i18n_user_List"/>
<spring:message code="widget.form.add" var="i18n_widgetFormAdd"/>
<spring:message code="user.name" var="i18n_user_Name"/>
<spring:message code="user.personName" var="i18n_userPersonName"/>
<spring:message code="widget.form.change" var="i18n_widgetFormChange"/>
<spring:message code="common.delete" var="i18n_commonDelete"/>
<spring:message code="user.primary" var="i18n_userPrimary"/>
<spring:message code="user.resetPass" var="i18n_userResetPass"/>

<spring:message code="common.message" var="i18n_commonMessage"/>
<spring:message code="user.name" var="i18n_userName"/>
<spring:message code="user.allowed" var="i18n_userAllowed"/>
<spring:message code="user.comment" var="i18n_userComment"/>
<spring:message code="common.option" var="i18n_commonOption"/>

<jvnav:pagetitle>
	${i18n_userManager}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_userManager}" active="true" />
</jvnav:breadcrumb>

	<jvlayout:row>
		
		<jvlayout:col length="12">
		<c:if test="${not empty message}">
			<div class="alert alert-danger">
				<strong>
					<i class="icon-remove"></i>	
					${i18n_commonMessage}
				</strong>
				<br />
				${message}
			</div>
		</c:if>
			<jvpanel:panel color="green" title="${i18n_userManager}" icon="icon-th-large">
				<%-- <jvtable:table htmlTableId="userlist" ajaxSource="/user/list" check="false" option="true" optionUrlString="user" 
						extCommand1Title="分配角色" extCommand1Action="role"  extCommand1Color="blue" extCommand1Icon="icon-user"
						extCommand2Title="重置密码" extCommand2Action="resetPassword"  extCommand2Color="yellow" extCommand2Icon="icon-refresh">
					<jvtable:toolbar newButton="true" delButton="false" search="true" advSearch="true" searchLab="用户名" searchProperty="username">
						<jvtable:searchTextfield id="username" title="用户名" searchProperty="username" value=""></jvtable:searchTextfield>
					</jvtable:toolbar>
					<jvtable:column title="序号" property="id" sortable="false" width="100px"/>
					<jvtable:column title="用户名" property="username" sortable="false" width="200px"/>
					<jvtable:column title="允许登录" property="loginAllowed" sortable="false" width="200px"/>
					<jvtable:column title="人员姓名" property="personName" width="200px"/>
					<jvtable:column title="备注" property="comment" width="*"/>		
				</jvtable:table> --%>
				<jvpagetable:table htmlTableId="userListTable"
				page="${userList}" url="/admin/auth/user/">

				<jvpagetable:toolbarButton color="btn-success"
						url="${ctx}/admin/auth/user/add"
						icon="icon-plus" title="${i18n_widgetFormAdd}"></jvpagetable:toolbarButton>
				<jvpagetable:searchTextItem id="userListTable_search_username" title="${i18n_user_Name}" key="username" 
					operat="LIKE" placeholder="" value="${SEARCH_username}"></jvpagetable:searchTextItem>
					
				<jvpagetable:searchTextItem id="userListTable_search_person.name" title="${i18n_userPersonName}" key="person.name" 
					operat="LIKE" placeholder="" value="${SEARCH_person_name}"></jvpagetable:searchTextItem>

				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>

				<!--String 控件-->
				<jvpagetable:columnheader>${i18n_userName}</jvpagetable:columnheader>
				<jvpagetable:column id="username">${entity.username}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_userAllowed}</jvpagetable:columnheader>
				<jvpagetable:column id="loginAllowed">${entity.loginAllowed}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_userPersonName}</jvpagetable:columnheader>
				<jvpagetable:column id="person">${entity.person.name}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_userComment}</jvpagetable:columnheader>
				<jvpagetable:column id="comment">${entity.comment}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18n_commonOption}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
					<jvpagetable:OptionColumnItem title="${i18n_widgetFormChange}"
							url="${ctx}/admin/auth/user/edit/${entity.id}"
							style="btn btn-small btn-warning"></jvpagetable:OptionColumnItem>
						<jvpagetable:OptionColumnItem title="${i18n_commonDelete}"
							url="${ctx}/admin/auth/user/delete/${entity.id}"
							style="btn btn-small btn-danger"></jvpagetable:OptionColumnItem>
						 <jvpagetable:OptionColumnItem title="${i18n_userPrimary}"
							url="${ctx}/admin/auth/user/role/${entity.id}"
							style="btn btn-small btn-primary"></jvpagetable:OptionColumnItem>
						<jvpagetable:OptionColumnItem title="${i18n_userResetPass}"
							url="${ctx}/admin/auth/user/resetPassword/${entity.id}"
							style="btn btn-small btn-primary"></jvpagetable:OptionColumnItem> 
				</jvpagetable:OptionColumn>
				

			</jvpagetable:table>
			</jvpanel:panel>
		</jvlayout:col>
		
		
		
		
	</jvlayout:row>
