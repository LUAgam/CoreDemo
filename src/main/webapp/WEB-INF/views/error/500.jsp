<%@ page language="java"  pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>


<spring:message code="error.jsp" var="i18n_errorJsp"/>
<spring:message code="error.message0" var="i18n_errorMessage0"/>
<spring:message code="error.message1" var="i18n_errorMessage1"/>
<spring:message code="error.message2" var="i18n_errorMessage2"/>

<!-- BEGIN BODY -->
<body class="error-500">
    <div class="error-wrap">
        <h1><font color="red">${i18n_errorJsp}</font></h1>
        <h2><font color="black">${i18n_errorMessage0}</font></h2>
        <div class="metro green">
           <span> 5 </span>
        </div>
        <div class="metro yellow">
            <span> 0 </span>
        </div>
        <div class="metro purple">
            <span> 0 </span>
        </div>
        <p>${i18n_errorMessage1}<a href="${ctx }">${i18n_errorMessage2}</a></p>
    </div>
</body>
<!-- END BODY -->

