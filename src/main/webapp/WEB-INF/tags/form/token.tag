<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建隐藏控件"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="value" required="false" type="java.lang.String" description="value of the textfield" %>

<c:set var="value" value="${empty value ? '' : value}" />

<input type="hidden" id="token" name="token" value="${value}"/>