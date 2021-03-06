<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the datetimefield."%>
<%@ attribute name="required" required="false" rtexprvalue="false" type="java.lang.Boolean" description="label for the required."%>
<%@ attribute name="size" required="false" type="java.lang.String" description="input-mini, input-small, input-medium, input-large, input-xlarge, input-xxlarge, span1~12" %>
<%@ attribute name="title" required="false" type="java.lang.String"	description="title of the label"%>
<%@ attribute name="value" required="false" type="java.util.Date" description="value of the datetimefield"%>
<%@ attribute name="readonly" required="false" rtexprvalue="false" type="java.lang.Boolean" description="只读" %>
<%@ attribute name="tooltrip" required="false" type="java.lang.String"
	description="tooltrip of the textfield"%>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="required" value="${empty required ? false : required}" />
<c:set var="size" value="${empty size ? 'input-large' : size}" />
<c:set var="value" value="${empty value ? null : value}" />
<c:set var="readonly" value="${empty readonly ? false : readonly}" />

<c:if test="${hasDatetimefield eq false}">
	<c:set var="hasDatetimefield" value="true" scope="request" />
</c:if>

<div class="control-group">
	<label class="control-label" for="${id}"><b>${title}</b> <c:if	test="${required eq true}">
			<font color="red"><b> *</b></font>
		</c:if></label>
	<div class="controls">
		<div class="input-append">
			<c:choose>
				<c:when test="${readonly eq true}">
					<input  class="laydate-icon ${size}"  id="${id}" value="<fmt:formatDate value="${value}" pattern="yyyy-MM-dd HH:mm:ss"/>" name="${id}" type="text" readonly="readonly"/>
					
				</c:when>
				<c:otherwise>
					<input  class="laydate-icon ${size}"  id="${id}" value="<fmt:formatDate value="${value}" pattern="yyyy-MM-dd HH:mm:ss"/>" name="${id}" type="text" onclick="laydate({istime: true, festival: true, format: 'YYYY-MM-DD hh:mm:ss'})"/>
				</c:otherwise>
			</c:choose>
			<c:if test="${not empty tooltrip}">
				<span class="help-inline">${tooltrip}</span>
			</c:if>
		</div>
	</div>
</div>