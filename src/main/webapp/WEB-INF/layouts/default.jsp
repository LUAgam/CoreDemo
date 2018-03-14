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
<title>${i18n_ACTITLE}</title>
<meta charset="utf-8" />


<meta name="description" content="overview &amp; stats" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<jsp:include page="commonCss.jsp">
	<jsp:param name="jspParameterForInclude" value="index"></jsp:param>
</jsp:include>
</head>

<body class="fixed-top">
    <jsp:include page="commonScript.jsp"></jsp:include>
	<jsp:include page="commonNav.jsp"></jsp:include>



 	<!-- BEGIN CONTAINER -->
   <div id="container" class="row-fluid">
	 
	 <jsp:include page="commonMenu.jsp"></jsp:include>
      
	 <!-- BEGIN PAGE -->  
      <div id="main-content">
         <!-- BEGIN PAGE CONTAINER-->
         <div class="container-fluid">

			<sitemesh:body />

         </div>
         <!-- END PAGE CONTAINER-->
      </div>
      <!-- END PAGE -->  
   </div>
   <!-- END CONTAINER -->


	 <!-- BEGIN FOOTER -->
   <div id="footer">
      <!--  2014 &copy; 上海悦闻信息技术有限公司. -->
   </div>
   <!-- END FOOTER -->
	<jsp:include page="commonScriptEnd.jsp"></jsp:include>

</body>
</html>