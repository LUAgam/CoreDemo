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

<spring:message code="stat.daily.report.moudleName" var="i18N_dailyReportMoudleName"/>
<spring:message code="stat.daily.editProcess" var="i18N_dailyEditProcess"/>

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
								 <td><a href="${ctx}/dialog/stat/statistic/toList/${map.key}">${map.value.className}</a></td>
								 <td>${map.value.rate}</td>
							</tr>
						</c:forEach>
				    </tbody>
			</table>
		</jvlayout:col>
	</jvlayout:row>
<!-- /.page-content -->


