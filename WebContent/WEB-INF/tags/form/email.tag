<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建textfield"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the textfield." %>
<%@ attribute name="required" required="false" rtexprvalue="false" type="java.lang.Boolean" description="label for the required." %>
<%@ attribute name="title" required="false" type="java.lang.String" description="title of the label" %>
<%@ attribute name="value" required="false" type="java.lang.String" description="value of the textfield" %>
<%@ attribute name="placeholder" required="false" type="java.lang.String" description="value of the textfield" %>
<%@ attribute name="readonly" required="false" rtexprvalue="false" type="java.lang.Boolean" description="" %>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="value" value="${empty value ? '' : value}" />
<c:set var="placeholder" value="${empty placeholder ? '' : placeholder}" />
<c:set var="readonly" value="${empty readonly ? false : readonly}" />
<c:set var="required" value="${empty required ? false : required}" />

<div class="control-group">
    <label class="control-label" for="${id}"><b>${title}</b><c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label> 
    <div class="controls">
        <c:choose>
           <c:when test="${readonly eq true}">
              <input type="text" id="${id}" name="${id}" placeholder="${placeholder}" class="${size}" value="${value}" readonly="readonly"/>
           </c:when>
           <c:otherwise>
              <input type="text" id="${id}" name="${id}" placeholder="${placeholder}" class="${size}" value="${value}" />
           </c:otherwise>
        </c:choose>
        <c:if test="${not empty tooltrip}">
        	<span class="help-inline">${tooltrip}</span>
        </c:if>
    </div>
</div>