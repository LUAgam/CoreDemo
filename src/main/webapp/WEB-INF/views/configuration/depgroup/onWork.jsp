<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<spring:message code="department.manager" var="i18n_departmentManager" />
<spring:message code="system.pageTitle" var="i18n_systemPageTitle" />
<spring:message code="department.departManager" var="i18n_departmentDepartManager" />
<spring:message code="widget.form.add" var="i18n_widgetFormAdd" />
<spring:message code="department.name" var="i18n_departmentName" />
<spring:message code="widget.form.change" var="i18n_widgetFormChange" />
<spring:message code="common.delete" var="i18n_commonDelete" />
<spring:message code="common.message" var="i18n_commonMessage" />
<spring:message code="common.num" var="i18n_commonNum" />
<spring:message code="common.name" var="i18n_commonName" />
<spring:message code="department.breiefName" var="i18n_departmentBreiefName" />
<spring:message code="department.parent" var="i18n_departmentParent" />
<spring:message code="common.type" var="commonType" />
<spring:message code="department.ifRightD" var="i18n_departmentIfRightD" />
<spring:message code="department.ifOCCD" var="i18n_departmentIfOCCD" />
<spring:message code="common.DESC" var="i18n_commonDESC" />
<spring:message code="common.descroption" var="i18n_commonDescroption" />
<spring:message code="common.option" var="i18n_commonOption" />

<jvnav:pagetitle>
	当班配置-${group.name }
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_systemPageTitle}" />
	<jvnav:breadcrumbitem title="本部门岗位管理" />
	<jvnav:breadcrumbitem title="当班配置" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
		<jvpanel:panel color="green" title="用户列表-${group.name }" icon="icon-th-large">
			<c:if test="${not empty message}">
				<div class="alert alert-danger">
					<strong> <i class="icon-remove"></i> ${i18n_commonMessage}
					</strong> <br /> ${message}
				</div>
			</c:if>
			<form name="groupListTableForm" action="${ctx}/admin/auth/depgroup/saveOnWork/${group.id }" method="POST">
				<button class="btn btn-info" id="btn_submit" type="submit">
					<i class="icon-ok"></i>保存
				</button>
				<br>

				<table id="userGroupListTable" class="table table-striped table-bordered dataTable" aria-describedby="departmentListTable-table_info">
					<thead>
						<tr>
							<th style="width: 13px;" class="center sorting_disabled" rowspan="1" colspan="1" role="columnheader" aria-label=""><label
								class="position-relative"> <input type="checkbox" class="group-checkable" /> <span class="lbl"></span>
							</label></th>
							<th>用户名</th>
							<th>人员姓名</th>
							<th>描述</th>
						</tr>
					</thead>
					<c:forEach items="${userGroupList }" var="entity">
						<tbody>
							<tr>

								<td class="center"><label class="position-relative"> <c:if test="${entity.isOnWork  }">
											<input id="rowcheck" name="rowcheck" type="checkbox" class="ace" value="${entity.id}" checked="checked" />
										</c:if> <c:if test="${!entity.isOnWork }">
											<input id="rowcheck" name="rowcheck" type="checkbox" class="ace" value="${entity.id}" />
										</c:if>
								</label></td>
								<td>${entity.user.username}</td>
								<td>${entity.user.person.name}</td>
								<td>${entity.user.comment}</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</form>

		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>
<script type="text/javascript">
	jQuery(function($) {
		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

	});

	function submit() {

	}
</script>


