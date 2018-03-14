<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建表格上的其它按钮"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ attribute name="title" required="true" type="java.lang.String" description="按钮名称" %>
<%@ attribute name="color" required="true" type="java.lang.String" description="按钮颜色" %>
<%@ attribute name="commandUrlString" required="true" type="java.lang.String" description="按钮路径" %>
  
 <c:if test="${commandManagement}">
  	<a class="btn btn-sm ${color}" href="${ctx}/${optionUrlString}/${commandUrlString}/">${title}</a>
 </c:if>