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

<spring:message code="statistic.query" var="i18N_statisticQuery"/>
<spring:message code="stat.daily.report.moudleName" var="i18N_dailyReportMoudleName"/>
<spring:message code="stat.daily.editProcess" var="i18N_dailyEditProcess"/>
<spring:message code="common.date1" var="i18N_commonDate1"/>

	<jvlayout:row>
		<jvlayout:col length="12">
			<form action="${ctx}/dialog/stat/statistic/lookReported" method="post"> 
				<table id="usertable">
					<tr>
						<td width="10%" align="right"><b>${i18N_commonDate1}</b></td>
						<td width="40%">
							<div class="input-append datetimepicker1">
								<input id="date" value="${date}" name="date"  data-date-format="yyyy-MM-dd" type="search"/>
								<span class="add-on"><i class="icon-calendar"></i></span>
							</div>
						</td>
						<td>
							<button class="btn btn-info" type="submit">
								<i class="icon-ok"></i> ${i18N_statisticQuery}
							</button>
						</td>
					</tr>
				</table>
			</form>
		</jvlayout:col>
	</jvlayout:row>
	<jvlayout:row>
		<jvlayout:col length="12">
			<table id="usertable" class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th width="150px;">${i18N_dailyReportMoudleName}</th>
							<th width="150px;">${i18N_dailyEditProcess}</th>
						</tr>
					</thead>
					<tbody id="usertablecontent">
						<c:forEach items="${allMap}" var="map">
							<tr>
								 <td><a href="${ctx}/dialog/stat/statistic/toDailyList/${map.key}/${date}">${map.value.className}</a></td>
								 <td>${map.value.rate}</td>
							</tr>
						</c:forEach>
				    </tbody>
			</table>
		</jvlayout:col>
	</jvlayout:row>
<!-- /.page-content -->

<script type="text/javascript">

	 	 $(function() {
		 		 $('.datetimepicker1').datetimepicker({
		 			 format: 'yyyy-MM-dd',  
		        language: 'ch',  
		        pickDate: true,  
		        pickTime: true,
		        pick12HourFormat:false,
		        hourStep: 1,  
		        minuteStep: 15,  
		        secondStep: 30,  
		        inputMask: true  
				});
	 	  });  
   	
</script>
