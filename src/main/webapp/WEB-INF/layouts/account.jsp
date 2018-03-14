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

<spring:message code="AC.TITLE" var="i18n_ACTITLE"/>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%--

--%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->  
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->  
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->  
<head>
    <title>${i18n_ACTITLE}</title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">    
    <link rel="shortcut icon" href="favicon.ico">  
	<link rel="stylesheet" href="<c:url value='/account/plugins/bootstrap2/bootstrap.min.css'/>"> 
	
	<link rel="stylesheet" href="<c:url value='/account/css/login.css'/>">
	<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    
</head>

<body>
	<sitemesh:body />
	<script type="text/javascript" src="<c:url value='/account/plugins/bootstrap2/jquery.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/account/plugins/bootstrap2/bootstrap.js'/>"></script> 
<%-- 	<script type="text/javascript" src="<c:url value='/account/plugins/backstretch/backstretch.min.js'/>"></script>  --%>
	<script type="text/javascript">
	
	/*jQuery(document).ready(function($) {

		$.backstretch([
	      "<c:url value='/account/images/bg1.png'/>", 
	      "<c:url value='/account/images/bg2.png'/>"
	  	], {duration: 3000, fade: 750});
			
	});*/
	
	
	
	
	</script>
	
</body>
</html>

