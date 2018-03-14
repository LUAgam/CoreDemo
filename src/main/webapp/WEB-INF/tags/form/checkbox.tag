<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建checkbox"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the textfield."%>
<%@ attribute name="required" required="false" rtexprvalue="false" type="java.lang.Boolean" description="label for the required."%>
<%@ attribute name="title" required="false" type="java.lang.String" description="title of the label"%>
<%@ attribute name="value" required="false" type="java.lang.String" description="value of the textfield"%>
<%@ attribute name="tooltrip" required="false" type="java.lang.String" description="tooltrip of the textfield" %>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="value" value="${empty value ? '' : value}" />
<c:set var="required" value="${empty required ? false : required}" />

<div class="control-group">
	<label class="control-label" for="${id}"><b>${title}</b> <c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label>

	<div class="controls">
    	<input type="hidden" value="on" name="_${id}">
			<c:choose>
			<c:when test="${value eq true}">
				<input type="checkbox" id="${id}" name="${id}" checked="checked" />
			</c:when>
			<c:otherwise>
				<input type="checkbox" id="${id}" name="${id}"/>
			</c:otherwise>
		</c:choose>
		 <c:if test="${not empty tooltrip}">
        	<span class="help-inline">${tooltrip}</span>
        </c:if>
    </div>
</div>
