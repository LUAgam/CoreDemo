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
<%@ attribute name="value" required="false" type="java.lang.String" description="搜索项值"%>

<c:if test="${searchBar}">	
<label><b>${title}:</b> <input id="${id}" class="laydate-icon input-medium" name="SEARCH_${key}@=@DATE" type="SEARCH" class="laydate-icon input-medium" placeholder="YYYY-MM-DD" value="${value}" onclick="laydate({istime: false, festival: true, format: 'YYYY-MM-DD'})"> </label>	&nbsp;&nbsp;&nbsp;&nbsp;
</c:if>
