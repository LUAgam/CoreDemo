<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建textfield"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="title" required="true" type="java.lang.String" description="title of the label" %>
<%@ attribute name="value" required="true" type="java.lang.String" description="value of the textfield" %>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="value" value="${empty value ? '' : value}" />

<div class="control-group">
    <label class="control-label" for="${id}"><b>${title}</b> </label> 
    <div class="controls">
        <span>${value}</span>
    </div>
</div>
