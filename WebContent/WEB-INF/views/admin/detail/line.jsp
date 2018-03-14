<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="detail.line.title" var="i18n_detailLineTitle"/>
<spring:message code="detail.station" var="i18n_detailStation"/>
<spring:message code="detail.name" var="i18n_detailName"/>
<spring:message code="detail.liftLocation.name" var="i18n_detailLocationName"/>
<spring:message code="detail.manufacturer" var="i18n_detailManufacturer"/>
<spring:message code="detail.assetNumber" var="i18n_detailAssetNumber"/>
<spring:message code="detail.models" var="i18n_detailModels"/>
<spring:message code="detail.assetType" var="i18n_detailAssetType"/>

<jvnav:pagetitle>
	${line.name}${i18n_detailLineTitle}
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="个人门户" active="true" />
</jvnav:breadcrumb>


<jvpanel:panel color="green" title="${line.name}${i18n_detailLineTitle}" icon="icon-table">
	<jvlayout:row>
		<jvlayout:col length="12">
			<div class="span3">
				<div class="timeline-messages">
					<c:forEach items="${stationList}" var="station">
						<!-- Comment -->
						<div class="msg-time-chat">
							<div class="message-body msg-in">
								<span class="arrow"></span>
								<div style="padding-left: 10px;padding-right: 10px;padding-top: 10px;">
									<p class="attribution">
										<a  onclick="liftList(${station.id});">${station.name}</a>
									</p>
								</div>
							</div>
						</div>
						<!-- /comment -->
					</c:forEach>
				</div>
			</div>
			<div class="span9">
				<input type="hidden" value="${ctx}" id="ctx">
				<table class="table table-bordered table-striped" style="color: #000000">
					<thead>
						<tr>
							<td>${i18n_detailStation}</td>
							<td>${i18n_detailName}</td>
							<td>${i18n_detailLocationName}</td>
							<td>${i18n_detailManufacturer}</td>
							<td>${i18n_detailAssetNumber}</td>
							<td>${i18n_detailModels}</td>
							<td>${i18n_detailAssetType}</td>
						</tr>
					</thead>
					<tbody id="liftStation">
					</tbody>
				</table>
			</div>
			<%-- <div class="span1">
			</div>
			<div class="span2">
				<c:forEach items="${stationList}" var="station">
					<div class="itemdiv dialogdiv">
						<div class="user" align="center">	
							<div>
								<a onclick="liftList(${station.id});">${station.name}</a>
							</div>
						</div>
					</div>
					
				</c:forEach>
			</div>
			<div class="span9">
				<input type="hidden" value="${ctx}" id="ctx">
				<table class="table table-bordered table-striped" style="color: #000000">
					<thead>
						<tr>
							<td>车站</td>
							<td>电梯名称</td>
							<td>电梯位置</td>
							<td>制造单位</td>
							<td>设备编码</td>
							<td>规格型号</td>
							<td>设备类型</td>
						</tr>
					</thead>
					<tbody id="liftStation">
					</tbody>
				</table>
			</div> --%>
		</jvlayout:col>
	</jvlayout:row>
</jvpanel:panel>	
<script type="text/javascript">
	function liftList(stationId) {
		var parm = [];
		var ctx = $("#ctx").val();
		parm.push({
			"name" : "stationId",
			"value" : stationId
		});
		$
				.ajax({
					"type" : "POST",
					"contentType" : "application/json",
					"url" : '<c:url value="/lms/portalDetail/lift"/>',
					"dataType" : "json",
					"data" : JSON.stringify(parm), //以json格式传递
					"success" : function(resp) {
						var content = '';
						$
								.each(
										resp.content,
										function(i, item) {
											content += '<tr>'
													+ '<td>'
													+ item.liftLocation.station.name
													+ '</td>'
													+ '<td><a href="'+ctx+'/lms/lift/view/'+item.id+'">'
													+ item.name + '</a></td>'
													+ '<td>'
													+ item.liftLocation.name
													+ '</td>' + '<td>'
													+ item.manufacturer
													+ '</td>' + '<td>'
													+ item.assetNumber
													+ '</td>' + '<td>'
													+ item.models + '</td>'
													+ '<td>' + item.assetType
													+ '</td>' + '</tr>';
										});
						$("#liftStation").html(content);
					}
				});
	}
</script>
