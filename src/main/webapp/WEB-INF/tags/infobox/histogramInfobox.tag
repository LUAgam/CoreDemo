<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建显示柱状图infobox"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String"
	description="DOM id of the percentinfobox."%>
<%@ attribute name="infoclass" required="false" type="java.lang.String"
	description="infobox style"%>
<%@ attribute name="values" required="true" type="java.lang.String"
	description="给一串数值，按','分割，每个数值表示一个柱状图(例如1,2,3,4)"%>
<%@ attribute name="content" required="false"	type="java.lang.String" description="描述"%>
<%@ attribute name="number" required="false" type="java.lang.Integer"
	description="显示数量"%>

<%@ attribute name="viewPercent" required="false" type="java.lang.Boolean" 
description="是否显示增减百分比的值"%>
<%@ attribute name="percentclass" required="false" type="java.lang.String" 
description="百分比图标周围颜色框"%>
<%@ attribute name="iconarrow" required="false" type="java.lang.String" 
description="百分比上升或下降图标"%>
<%@ attribute name="percent" required="false" type="java.lang.String" 
description="增减百分比的数量"%>

<c:set var="number" value="${empty number ? '' : number}" />
<c:set var="content" value="${empty content ? '' : content}" />
<c:set var="viewPercent" value="${empty viewPercent  ? false : viewPercent}" />
<c:set var="percent" value="${empty percent? '' : percent}" />  
  
<div class="${infoclass}">
	<div class="infobox-chart">
		<span class="sparkline" data-values="${values}"></span>
	</div>

	<div class="infobox-data">
		<span class="infobox-data-number">${number}</span>
		<div class="infobox-content">${content}</div>
	</div>

	<c:if test="${viewPercent eq true}">
	<div class="${percentclass}">
		${percent}%  
		<i class="${iconarrow}"></i>
	</div>
	</c:if>
</div>
