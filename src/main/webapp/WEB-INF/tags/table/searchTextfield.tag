<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建textfield"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the textfield." %>
<%@ attribute name="title" required="true" type="java.lang.String" description="高级搜索文本框标题" %>
<%@ attribute name="value" required="true" type="java.lang.String" description="高级搜索文本框值" %>
<%@ attribute name="searchProperty" required="true" type="java.lang.String" description="高级搜索文本框" %>
<%-- HTML parameters --%>
<c:if test="${htmlVarManagement}">
	<c:choose>
		<c:when test="${empty searchids}">
			<c:set var="searchids" value="${id}" scope="request" />
		</c:when>
		<c:otherwise>
			<c:set var="searchids" value="${searchids}${delimitor}${id}" scope="request" />
		</c:otherwise>
	</c:choose>
</c:if>

<c:if test="${toolbarVarManagement}">
		
	<c:if test="${commandManagement eq false}">

		<div class="form-group col-sm-6">
			<label class="col-sm-4 control-label" for="${id}">${title}：</label>
			<div class="col-sm-8">
				<input  class="form-control" type="text" id="${id}" name="${searchProperty}" value="${value}">
			</div>
		</div>
	</c:if>

</c:if>