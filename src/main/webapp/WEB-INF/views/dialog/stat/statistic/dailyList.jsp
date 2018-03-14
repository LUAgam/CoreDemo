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

<spring:message code="common.date1" var="i18N_commonDate1"/>
<spring:message code="stat.daily.missionName1" var="i18N_dailyMissionName1"/>
<spring:message code="statistic.query" var="i18N_statisticQuery"/>
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
				${reportClass.description}
				</jvlayout:col>
				<jvlayout:col length="3">
					${i18N_commonDate1}${date}
				</jvlayout:col>
				<jvlayout:col length="3">
					${i18N_dailyMissionName1}<input type="text" id="workName" name="workName" value="${workName}" style="height: 30px;" class="input-sm form-control">
				</jvlayout:col>
				<jvlayout:col length="3">
					<input type="button" value="${i18N_statisticQuery}" class="btn btn-sm btn-info" onclick="search()">
					<!-- <a href="#" onclick="search()" class="btn btn-sm btn-info">查询</a> -->
					<a href="#" onclick="history.back()" class="btn btn-sm">${i18N_commonBack}</a>
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
	 search();
}); 
function search() {  
	var parm = [];
	var id = '${id}';
	var date = '${date}';
 	parm.push( {"name": "id", "value": id}); 
 	parm.push( {"name": "date", "value": date}); 
 	parm.push( {"name": "workName", "value": $("#workName").val()}); 
 	var t = 0;
	$.ajax({
		"type" : "POST",
		"contentType" : "application/json",
		"url" : '<c:url value="/dialog/stat/statistic/json_dailyList/"/>',
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
