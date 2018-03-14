<%--
 (c) 2006 JOVEN
 
JHuang
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建面包屑每一层"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="title" required="true" type="java.lang.String"	description="标题"%>
<%@ attribute name="url" required="false" type="java.lang.String"	description="url链接"%>
<%@ attribute name="active" required="false" type="java.lang.Boolean" description="是否可以点击。true：ur无效，false：url有效"%>

<%-- <c:set var="icon" value="${empty title ? 'icon-home' : icon}" /> --%>
<c:set var="active" value="${empty active ? 'false' : active}" />

<c:choose>
	<c:when test="${active}">
		<li class="active">
			${title}
	</c:when>
	<c:otherwise>
		<li>
			<a href="<c:url value='${url}'/>">
				<c:choose>
					<c:when test="${url != '#'}">
							<B><font color="red">${title}</font></B>
					</c:when>
					<c:otherwise>
						${title}
					</c:otherwise>
				</c:choose>
			</a>
    		<span class="divider">/</span>
	</c:otherwise>
</c:choose>
</li>