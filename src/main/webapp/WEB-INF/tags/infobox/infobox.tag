<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建infobox"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String"
	description="DOM id of the infobox."%>
<%@ attribute name="infoclass" required="false" type="java.lang.String"
	description="infobox style"%>
<%@ attribute name="icon" required="false" type="java.lang.String"
	description="图标"%>
<%@ attribute name="number" required="false" type="java.lang.Integer"
	description="数量"%>
<%@ attribute name="content" required="false"	type="java.lang.String" description="描述"%>
<%@ attribute name="percentclass" required="false" type="java.lang.String"
	description="percent style"%>
<%@ attribute name="percent" required="false" type="java.lang.String"
	description="所占比例"%>
<%@ attribute name="iconarrow" required="false" type="java.lang.String" 
description="百分比上升或下降图标"%>

<c:set var="number" value="${empty number ? '' : number}" />
<c:set var="content" value="${empty content ? '' : content}" />
<c:set var="percent" value="${empty percent ? '' : percent}" />
<c:set var="iconarrow" value="${empty iconarrow ? '' : iconarrow}" />
	<div class="${infoclass}">
		<div class="infobox-icon"> 
			<i class="${icon}"></i>
		</div>
		
		<div class="infobox-data">
			<span class="infobox-data-number">${number}</span>
			<div class="infobox-content">${content}</div>
		</div>
		
		<c:if test="${percent != ''}"> 
 		<div class="${percentclass}">${percent}%   
		<c:if test="${iconarrow !=''}">  
			<i class="${iconarrow}"></i>
		</c:if>  
		</div>
		</c:if>  
	</div>
