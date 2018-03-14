<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<spring:message code="common.dealError" var="i18n_commonDealError"/>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->

<head>
   <meta charset="utf-8" />
   <title>${i18n_commonDealError}</title>
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link href="<c:url value='/static/assets/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" />
   <link href="<c:url value='/static/assets/bootstrap/css/bootstrap-responsive.min.css'/>" rel="stylesheet" />
   <link href="<c:url value='/static/assets/font-awesome/css/font-awesome.css'/>" rel="stylesheet" />
   <link href="<c:url value='/static/css/style.css'/>" rel="stylesheet" />
   <link href="<c:url value='/static/css/style-responsive.css'/>" rel="stylesheet" />
   <link href="<c:url value='/static/css/style-default.css'/>" rel="stylesheet" id="style_color" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="error-500">
<sitemesh:body />
</body>
<!-- END BODY -->
</html>