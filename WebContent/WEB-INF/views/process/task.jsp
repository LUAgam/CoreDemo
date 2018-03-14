<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<spring:message code="process.task.ID" var="i18N_processTaskID"/>
<spring:message code="process.task.executor" var="i18N_processTaskExecutor"/>
<spring:message code="common.operate" var="i18N_commonOperate"/>
<spring:message code="process.template.process" var="i18N_ptProcess"/>
<spring:message code="process.deployed" var="i18N_processDeployed"/>
<spring:message code="process.started" var="i18N_processStarted"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table,table td,table th {
	border: 1px solid gray;
	border-collapse: collapse;
}

a {
	height: 30px;
	line-height: 30px;
	border: 1px solid black;
	background: gray;
	color: white;
	text-decoration: none;
	padding: 3px;
	font-weight: bold;
}
</style>
</head>
<body>

	<div style="margin: 0 auto; width: 400px; padding-top: 50px;">
		<h2>${i18N_srList}</h2>
		<table width="400px;">
			<thead>
				<tr>
					<th>${i18N_processTaskID}</th>
					<th>${i18N_sdMissionName}</th>
					<th>${i18N_processTaskExecutor}</th>
					<th>${i18N_commonOperate}</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="temp" items="${list}">
					<tr>
						<td>${temp.id}</td><td>${temp.name}</td><td>${temp.assignee}</td><td><a href="../process/complete?id=${temp.id}">完成</a> <a href="../process/graphics?taskId=${temp.id}">图形</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="../process">${i18N_ptProcess}</a>
		<a href="../process/deployed">${i18N_processDeployed}</a>
		<a href="../process/started">${i18N_processStarted}</a>
	</div>
</body>
</html>