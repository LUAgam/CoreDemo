<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="common.back" var="i18N_commonBack"/>
<spring:message code="stat.daily.reportNo" var="i18N_dailyReportNo"/>
<spring:message code="stat.daily.missionName" var="i18N_dailyMissionName"/>
<spring:message code="stat.daily.createTime" var="i18N_dailyCreateTime"/>
<spring:message code="stat.daily.report.person" var="i18N_dailyReportPerson"/>
<spring:message code="stat.daily.report.time" var="i18N_dailyReportTime"/>
<spring:message code="stat.daily.editProcess" var="i18N_dailyEditProcess"/>
<spring:message code="common.status" var="i18N_commonStatus"/>

	<jvlayout:row>

		<jvlayout:col length="12">
			<jvlayout:row>
				<jvlayout:col length="3">
					<a href="${ctx}/dialog/stat/statistic/list1" class="btn btn-sm">${i18N_commonBack}</a>
				</jvlayout:col>
				<jvlayout:col length="3">
				${reportClass.description}
				</jvlayout:col>
			</jvlayout:row>
			<table id="usertable" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th width="150px;">${i18N_dailyReportNo}</th>
							<th width="150px;">${i18N_dailyMissionName}</th>
							<th width="150px;">${i18N_dailyCreateTime}</th>
							<th width="150px;">${i18N_dailyReportPerson}</th>
							<th width="150px;">${i18N_dailyReportTime}</th>
							<th width="150px;">${i18N_dailyEditProcess}</th>
							<th width="150px;">${i18N_commonStatus}</th>
						</tr>
					</thead>
					<tbody id="usertablecontent">
						<tr>
						<td class = "center" colspan="8">
							<!-- 数据加载中... -->
						</td>
					  </tr>
				    </tbody>
			</table>
		</jvlayout:col>
	</jvlayout:row>
<!-- /.page-content -->

<script type="text/javascript">
 $().ready(function(){
	 searchStat(0);
}); 
function searchStat(pageNumber) {  
	var parm = [];
	var id = '${id}';
 	parm.push( {"name": "id", "value": id}); 
 	var t = 0;
	$.ajax({
		"type" : "POST",
		"contentType" : "application/json",
		"url" : '<c:url value="/dialog/stat/statistic/json_stat/"/>',
		"dataType" : "json", 
		"data" : JSON.stringify(parm), //以json格式传递
		"success" : function(resp) {
 			// 表格内容
			var content = '';
			$.each(resp.content, function(i, item) {
				content+='<tr class="odd">'
							+'<td><a href="${ctx}/dialog/stat/statistic/toParameterList/'+item.id+'">'+item.no+'</a></td>'
							+'<td>'+item.workName+'</td>'
							+'<td>'+item.createDateStr+'</td>'
							+'<td>'+item.fillUserName+'</td>'
							+'<td>'+item.fillDateStr+'</td>'
							+'<td>'+item.rate+'</td>'
							+'<td>'+item.statusFb+'</td>'
							+'</tr>';
			t = t + 1;
			});
			$("#usertablecontent").html(content);
			/* var cn = '共' + t + '条数据';
			$("#totle").html(cn); */
 		}
	});
}
</script>
