<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>

<%@ include file="../../taglibs.jsp"%>

<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>

<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle" />
<spring:message code="role.manager" var="i18n_roleManager" />
<spring:message code="role.permission" var="i18n_rolePermission" />
<spring:message code="widget.form.submit" var="i18n_widgetFormSubmit" />
<spring:message code="common.name" var="i18n_commonName" />
<spring:message code="common.displayName" var="i18n_commonDisplayName" />
<spring:message code="common.descroption" var="i18n_commonDescroption" />
<spring:message code="role.permission.name" var="i18n_permissionType" />

<script type="text/javascript">
	$(function($) {
		var type = $("select option:selected").val();
		$("#all_" + type + "Body").show();
		$("#select_" + type + "Body").show();

	})

	//新增权限
	function addPer(type, name) {
		var oldName = name;
		//转义name中的冒号，用于根据id查找对象
		name = jq(name);
		var tr = $("#all_" + name).html();
		$("#select_" + type + "Body").append(
				"<tr id=select_"+oldName+">" + tr + "</tr>");
		var select_btn = $("#select_" + name + " button");
		select_btn.attr("class", "btn btn-warning");
		select_btn.attr("id", "select_btn_" + oldName);
		select_btn.html('删除');
		select_btn.removeAttr("onclick");
		select_btn.attr("onclick", "deletePer('" + oldName + "','" + type
				+ "')");
		var all_btn = $("#all_btn_" + name);
		all_btn.removeAttr("onclick");
		all_btn.attr("class", "btn");
		var roleId = "${role.id}";

		$.ajax({
			url : "${ctx}/admin/auth/role/saveOnePermission",
			type : "POST",
			data : "name=" + oldName + "&roleId=" + roleId,
			dataType : "text",
			success : function(data) {

			}
		});

	}

	//删除权限
	function deletePer(name, type) {
		var oldName = name;
		//转义name中的冒号，用于根据id查找对象
		name = jq(name);
		$("#select_" + name).remove();
		$("#all_btn_" + name).attr("class", "btn btn-info");
		$("#all_btn_" + name).attr("onclick",
				"addPer('" + type + "','" + oldName + "')");
		var roleId = "${role.id}";
		$.ajax({
			url : "${ctx}/admin/auth/role/deleteOnePermission",
			type : "POST",
			data : "name=" + oldName + "&roleId=" + roleId,
			dataType : "text",
			success : function(data) {

			}
		});
	}

	function submitForm() {
		var selectName = '';
		var trsId = '';
		$("#selectPermissionTable tr").each(function() {
			selectName = selectName + $(this).attr('id') + ','
		})
		$("#selectName").val(selectName);
		$("#selectForm").submit();

	}

	function typeChange() {
		//隐藏全部权限
		$("#allPermissionTable tbody").each(function() {
			$(this).hide();
		})
		$("#selectPermissionTable tbody").each(function() {
			$(this).hide();
		})

		var type = $("select option:selected").val();
		$("#all_" + type + "Body").show();
		$("#select_" + type + "Body").show();

	}

	function jq(str) {
		return str.replace(/:/g, '\\:');
	}
</script>
<jvnav:pagetitle>
	${i18n_rolePermission}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_roleManager}" url="/role" />
	<jvnav:breadcrumbitem title="${i18n_rolePermission}" active="true" />
</jvnav:breadcrumb>
<form action="${ctx }/admin/auth/role/saveRolePermission" id="selectForm" method="post">
	<jvform:hidden id="roleId" value="${role.id }"></jvform:hidden>
	<jvform:hidden id="selectName"></jvform:hidden>
	<jvlayout:row>
		<span style="display: inline;"><b><font size="3">权限类型：</</font></b> </span>
		<select class="input-medium" id="resourceType" name="resourceType" data-placeholder="请选择记录" onchange="typeChange()">
			<c:forEach var="optionItem" items="${resourceTypes}" varStatus="status">
				<option value="${optionItem}">${optionItem}</option>
			</c:forEach>
		</select>
	</jvlayout:row>
	<jvlayout:row>
		<jvlayout:col length="6">

			<jvpanel:panel color="blue" title="当前角色权限">

				<div class="table-responsive">

					<table id="selectPermissionTable" class="table table-striped table-bordered table-hover">
						<thead>

							<tr>
								<th width="25%">${i18n_commonDisplayName}</th>
								<th width="25%">${i18n_commonName}</th>
								<th width="25%">url</th>
								<th width="25%">操作</th>

							</tr>
						</thead>
						<c:forEach items="${resourceTypes }" var="type">
							<tbody id="select_${type }Body" style="display: none">
								<c:forEach var="item" items="${selectedResouceMap[type]}" varStatus="s">
									<tr id="select_${item.name }">
										<td>${item.displayName}</td>
										<td>${item.name}</td>
										<td>${item.url}</td>
										<td><button class="btn btn-warning" id="select_btn_${item.name }" type="button" onclick="deletePer('${item.name }','${type }')">删除</button></td>
									</tr>
								</c:forEach>

							</tbody>
						</c:forEach>
						<!-- <tfoot>
							<tr>
								<td colspan="4"><button class="btn btn-success" id="save" type="button" onclick="submitForm()">
										<i class="icon-ok"></i>保存
									</button></td>
							</tr>
						</tfoot> -->
					</table>

				</div>

			</jvpanel:panel>
		</jvlayout:col>

		<jvlayout:col length="6">
			<jvpanel:panel color="blue" title="所有权限">
				<div class="table-responsive">

					<table id="allPermissionTable" class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th width="25%">${i18n_commonDisplayName}</th>
								<th width="25%">${i18n_commonName}</th>
								<th width="25%">url</th>
								<th width="25%">操作</th>
							</tr>
						</thead>
						<c:forEach items="${resourceTypes }" var="type">
							<tbody id="all_${type }Body" style="display: none">
								<c:forEach items="${allResouceMap[type] }" var="item">
									<tr id="all_${item.name }">
										<td>${item.displayName}</td>
										<td>${item.name}</td>
										<td>${item.url}</td>
										<td><button class="btn ${item.selected? '':'btn-info'}" value="${item.name }" name="${type }" id="all_btn_${item.name }" type="button"
												onclick="${item.selected? '':'addPer(name,value)'}">添加</button></td>
									</tr>
								</c:forEach>
							</tbody>
						</c:forEach>
					</table>

				</div>
			</jvpanel:panel>
		</jvlayout:col>

	</jvlayout:row>
</form>

