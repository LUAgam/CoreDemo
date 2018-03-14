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
<spring:message code="stat.common.paramName" var="i18N_commonParamName"/>
<spring:message code="common.value" var="i18N_commonValue"/>
<spring:message code="stat.param.formula" var="i18N_paramFormula"/>
<spring:message code="common.content" var="i18N_commonContent"/>

	<jvlayout:row>

		<jvlayout:col length="12">
			<jvlayout:row>
				<jvlayout:col length="3">
					<a href="#" onclick="history.back()" class="btn btn-sm">${i18N_commonBack}</a>
				</jvlayout:col>
				<jvlayout:col length="3">
					${daily.no}
				</jvlayout:col>
			</jvlayout:row>
			<table id="usertable" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th width="150px;">${i18N_commonParamName}</th>
							<th width="150px;">${i18N_commonValue}</th>
							<th width="150px;">${i18N_paramFormula}</th>
							<th width="150px;">${i18N_commonContent}</th>
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
	var id = '${daily.id}';
 	parm.push( {"name": "id", "value": id}); 
 	var t = 0;
	$.ajax({
		"type" : "POST",
		"contentType" : "application/json",
		"url" : '<c:url value="/dialog/stat/statistic/json_Parameter/"/>',
		"dataType" : "json", 
		"data" : JSON.stringify(parm), //以json格式传递
		"success" : function(resp) {
 			// 表格内容
			var content = '';
			$.each(resp.content, function(i, item) {
				content+='<tr class="odd">'
							+'<td>'+item.parameterName+'</td>'
							+'<td>'+item.val+'</td>'
							+'<td>'+item.formula+'</td>'
							+'<td>'+item.note+'</td>'
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
