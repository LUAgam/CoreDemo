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

<spring:message code="XXH.TITLE" var="i18n_XXHTITLE"/>

<%--shiro --%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%--

--%>
<html lang="zh" class="dialogshowX">
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!-- BEGIN HEAD -->
<head>
<title>${i18n_XXHTITLE}</title>
<meta charset="utf-8" />


<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<style type="text/css">
.dialogshowX 
{
overflow: auto!important;
}
</style>
<jsp:include page="commonCss.jsp">
	<jsp:param name="jspParameterForInclude" value="index"></jsp:param>
</jsp:include>
</head>

<body class="width:95%;margin: 0px;padding: 0px;">
     <jsp:include page="commonScript.jsp"></jsp:include>
	

 	<div id="container" class="row-fluid">
	 
	 <!-- BEGIN PAGE -->  
      <div id="main-content" style=" margin-left: 0px;margin-bottom: 0px !important;"><!--add margin-bottom: 0px !important;因为网页最下面会有一行黑色方块  -->
         <!-- BEGIN PAGE CONTAINER-->
        
			<sitemesh:body />

         <!-- END PAGE CONTAINER-->
      </div>
      <!-- END PAGE -->  
   </div>
   
   <!-- END CONTAINER -->   <!-- END FOOTER -->
	<jsp:include page="commonScriptEnd.jsp"></jsp:include>

</body>
</html>