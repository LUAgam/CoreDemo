<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="color" required="true" type="java.lang.String" description="颜色" %>
<%@ attribute name="icon" required="true" type="java.lang.String" description="图标" %>
<%@ attribute name="url" required="true" type="java.lang.String" description="url" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="标题" %>
<%@ attribute name="isParent" required="false" rtexprvalue="false" type="java.lang.Boolean" description="parent" %>

<c:if test="${toolbarButton}">	
	<a href="${url}" class="btn ${color}" target="${isParent ? '_parent' : ''}">
		<i class="${icon} bigger-110"></i>
		<span class="bigger-110 no-text-shadow">${title}</span>
	</a>
</c:if>
