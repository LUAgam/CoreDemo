<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>

<%--shiro --%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%--

--%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<c:url value='/static/assets/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" />
<link href="<c:url value='/static/assets/bootstrap/css/bootstrap-responsive.min.css'/>" rel="stylesheet" />
<link href="<c:url value='/static/assets/bootstrap/css/bootstrap-fileupload.css'/>" rel="stylesheet" />
<link href="<c:url value='/static/assets/font-awesome/css/font-awesome.css'/>" rel="stylesheet" />
<link href="<c:url value='/static/assets/fullcalendar/fullcalendar/bootstrap-fullcalendar.css'/>" rel="stylesheet" />

<!-- 图片展示 -->
<link href="<c:url value='/static/assets/fancybox/source/jquery.fancybox.css'/>" rel="stylesheet" />
<!-- 表单美化展示 -->
<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/uniform/css/uniform.default.css'/>" />

<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/chosen-bootstrap/chosen/chosen.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/jquery-tags-input/jquery.tagsinput.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/clockface/css/clockface.css'/>" />

<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css'/>" />


<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/bootstrap-colorpicker/css/colorpicker.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/bootstrap-toggle-buttons/static/stylesheets/bootstrap-toggle-buttons.css'/>" />

<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/jquery-ui/jquery-ui.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/metr-folio/css/metro-gallery.css'/>" media="screen" />

<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" /> -->


</head>
<body class="fixed-top">
<jsp:include page="commonScript.jsp"></jsp:include>
   
<sitemesh:body />
	
<jsp:include page="commonScriptEnd.jsp"></jsp:include>
</body>
</html>