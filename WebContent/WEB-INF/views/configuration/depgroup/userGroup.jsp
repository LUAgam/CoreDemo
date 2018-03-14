<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>

<spring:message code="person.personManager" var="i18n_personPersonManager" />
<spring:message code="system.pageTitle" var="i18n_systemPageTitle" />
<spring:message code="widget.form.add" var="i18n_widgetFormAdd" />
<spring:message code="person.department" var="i18n_personDepartment" />
<spring:message code="widget.form.change" var="i18n_widgetFormChange" />
<spring:message code="common.delete" var="i18n_commonDelete" />
<spring:message code="common.message" var="i18n_commonMessage" />

<spring:message code="person.name" var="i18n_personName" />
<spring:message code="person.inDepartment" var="i18n_personInDepartment" />
<spring:message code="person.number" var="i18n_personNumber" />
<spring:message code="person.sex" var="i18n_personSex" />
<spring:message code="person.title" var="i18n_personTitle" />
<spring:message code="person.subject" var="i18n_personSubject" />
<spring:message code="person.email" var="i18n_personEmail" />
<spring:message code="person.phoneNumber" var="i18n_personPhoneNumber" />
<spring:message code="person.shortNumber" var="i18n_personShortNumber" />
<spring:message code="person.officeNumber" var="i18n_personOfficeNumber" />
<spring:message code="person.officeRoom" var="i18n_personOfficeRoom" />
<spring:message code="common.option" var="i18n_commonOption" />

<jvnav:pagetitle>
	用户配置-${group.name }
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" active="true" />
	<jvnav:breadcrumbitem title="岗位用户配置" active="true" />
</jvnav:breadcrumb>

<form action="${ctx }/admin/auth/depgroup" id="selectForm" method="post">
	<jvform:hidden id="roleId" value="${role.id }"></jvform:hidden>
	<jvform:hidden id="selectName"></jvform:hidden>
	<jvlayout:row>
		<jvlayout:col length="6">

			<jvpanel:panel color="blue" title="当前岗位用户">

				<div class="table-responsive">

					<table id="selectTable" class="table table-striped table-bordered table-hover">
						<thead>

							<tr>
								<th width="25%">用户名</th>
								<th width="25%">人员姓名</th>
								<th width="25%">备注</th>
								<th width="25%">操作</th>

							</tr>
						</thead>
						<tbody id="selectBody">
							<c:forEach var="item" items="${selectUsers}" varStatus="s">
								<tr id="select_${item.id }">
									<td>${item.username}</td>
									<td>${item.personName}</td>
									<td>${item.comment}</td>
									<td><button class="btn btn-warning" id="select_btn_${item.id }" type="button" onclick="deleteUser('${item.id }')">删除</button></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>

			</jvpanel:panel>
		</jvlayout:col>

		<jvlayout:col length="6">
			<jvpanel:panel color="blue" title="本部门所有用户">
				<div class="table-responsive">

					<table id="allTable" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width="25%">用户名</th>
								<th width="25%">人员姓名</th>
								<th width="25%">备注</th>
								<th width="25%">操作</th>
							</tr>
						</thead>
						<tbody id="allBody">
							<c:forEach items="${allUsers}" var="item">
								<tr id="all_${item.id }">
									<td>${item.username}</td>
									<td>${item.personName}</td>
									<td>${item.comment}</td>
									<td><button class="btn ${item.isSelect? '':'btn-info'}" value="${item.id }" id="all_btn_${item.id }" type="button"
											onclick="${item.isSelect? '':'addUser(value)'}">添加</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</jvpanel:panel>
		</jvlayout:col>

	</jvlayout:row>

</form>
<script type="text/javascript">
	function addUser(id) {
		//转义name中的冒号，用于根据id查找对象
		var tr = $("#all_" + id).html();
		$("#selectBody").append("<tr id=select_"+id+">" + tr + "</tr>");
		var select_btn = $("#select_" + id + " button");
		select_btn.attr("class", "btn btn-warning");
		select_btn.attr("id", "select_btn_" + id);
		select_btn.html('删除');
		select_btn.removeAttr("onclick");
		select_btn.attr("onclick", "deleteUser('" + id + "')");
		var all_btn = $("#all_btn_" + id);
		all_btn.removeAttr("onclick");
		all_btn.attr("class", "btn");

		$.ajax({
			url : "${ctx}/admin/auth/depgroup/saveUserGroup/${group.id}",
			type : "POST",
			data : "userId=" + id,
			dataType : "text",
			success : function(data) {

			}
		});
	}
	function deleteUser(id) {
		$("#select_" + id).remove();
		$("#all_btn_" + id).attr("class", "btn btn-info");
		$("#all_btn_" + id).attr("onclick", "addUser('" + id + "')");
		$.ajax({
			url : "${ctx}/admin/auth/depgroup/deleteUserGroup/${group.id}",
			type : "POST",
			data : "userId=" + id,
			dataType : "text",
			success : function(data) {

			}
		});
	}
</script>


