<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib uri="/jvtabletag" prefix="table"%>
<%@ taglib uri="/jvstatetag" prefix="state"%>

<jvnav:pagetitle>
	审批界面
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="审批界面" active="true" />
</jvnav:breadcrumb>


<c:if test="${not empty message}">
	<div class="alert alert-danger">
		<strong> <i class="icon-remove"></i> ${i18n_commonMessage}
		</strong> <br /> ${message}
	</div>
</c:if>

<jvlayout:row>
	<jvlayout:col length="12">
		<state:out statusKey="status" value="${baseEntity}" statesKey="state"></state:out>
		<table:out column="4" value="${tableBean}" title="基础信息界面" color="green"/>
		<!-- PAGE CONTENT BEGINS -->
		<jvpanel:panel color="green" title="审批界面">
			<div class="tab-content">
				<div id="approvalRecord_wrapper" class="dataTables_wrapper form-inline" role="grid">
					<div>
						<h5>
							<i class="icon-th-large"><b>&nbsp;工作流审批日志</b></i>
						</h5>
					</div>
					<table id="approvalRecord" class="table table-striped table-bordered dataTable" aria-describedby="approvalRecord-table_info">
						<thead>
							<tr role="row">
								<th>名称</th>
								<th>意见</th>
								<th>时间</th>
								<th>操作人</th>
								<th>动作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${approvalRecords }" var="entity">
								<tr role="row" class="odd gradeX even">
									<td>${entity.name}</td>
									<td>${entity.opinion}</td>
									<td><fmt:formatDate value="${entity.date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${entity.user.comment}</td>
									<td>${entity.action}</td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
			<div class="tab-content">
				<div>
					<h5>
						<i class="icon-indent-right"><b>&nbsp;审批</b></i>
					</h5>
				</div>
				<jvform:form id="personform" action="/admin/profile/task/approve">
					<jvform:hidden id="processInstanceId" value="${processInstanceId}"></jvform:hidden>
					<jvform:textareafield id="opinion" title="审批意见" required="true" value="${approve.opinion}" size="span10"></jvform:textareafield>
					<jvform:select id="flow" title="操作" required="true" options="${flowList}" optionsType="2" value="${approve.flow}"></jvform:select>
					<jvform:footbar>
						<jvform:submit />
						&nbsp; &nbsp; &nbsp;
					<jvform:cancel />
					&nbsp; &nbsp; &nbsp;
				</jvform:footbar>

				</jvform:form>
			</div>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>
<!-- /row -->

