<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列头"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="id" required="true" type="java.lang.String" description="搜索项ID"%>
<%@ attribute name="title" required="true" type="java.lang.String" description="搜索项标题"%>
<%@ attribute name="key" required="true" type="java.lang.String" description="搜索项对应要搜索的字段"%>
<%@ attribute name="operat" required="true" type="java.lang.String" description="搜索项对应要搜索的字段"%>
<%@ attribute name="placeholder" required="false" type="java.lang.String" description="搜索项提示词"%>
<%@ attribute name="value" required="true" type="java.lang.String" description="搜索项值"%>

<c:set var="placeholder" value="${empty placeholder ? '' : placeholder}" />
<c:if test="${searchBar}">	
<label><b>${title}:</b> <input id=${id} name="SEARCH_${key}@${operat}@TEXT" type="SEARCH" class="input-medium" placeholder="${placeholder}" value="${value}"> </label>	&nbsp;&nbsp;&nbsp;&nbsp;				
</c:if>