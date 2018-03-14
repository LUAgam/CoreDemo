<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建纵列标签"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="length" required="true" type="java.lang.Integer" description="纵列布局" %>
<%@ attribute name="offset" required="false" type="java.lang.Integer" description="偏移" %>

<c:set var="offset" value="${empty pageScope.offset ?  0:pageScope.offset}" />

<c:choose>
	<c:when test="${pageScope.offset > 0}">
		<div class="span${pageScope.length} offset${pageScope.offset}">
	</c:when>
	<c:otherwise>
		<div class="span${pageScope.length}">
	</c:otherwise>
</c:choose>

	<jsp:doBody />
</div>
