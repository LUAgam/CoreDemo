<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建textfield"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="搜索项ID"%>
<%@ attribute name="title" required="true" type="java.lang.String" description="搜索项标题"%>
<%@ attribute name="key" required="true" type="java.lang.String" description="搜索项对应要搜索的字段"%>
<%@ attribute name="startDate" required="false" type="java.lang.String" description="搜索项值"%>
<%@ attribute name="endDate" required="false" type="java.lang.String" description="搜索项值"%>

<c:set var="placeholder" value="${empty placeholder ? '' : placeholder}" />
<c:if test="${searchBar}">	
<label><b>${title}:</b> <input id="start_${id}" name="SEARCH_${key}@>=@DATERANGE" type="SEARCH" class="laydate-icon input-medium" placeholder="YYYY-MM-DD" value="${startDate}" onclick="laydate({istime: false, festival: true, format: 'YYYY-MM-DD'})"> <input id="END_${id}" name="SEARCH_${key}@<@DATERANGE" type="SEARCH" class="laydate-icon input-medium" placeholder="YYYY-MM-DD" value="${endDate}" onclick="laydate({istime: false, festival: true, format: 'YYYY-MM-DD'})"> </label>&nbsp;&nbsp;&nbsp;&nbsp;
</c:if>
