<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建显示百分比的infobox"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String"
	description="DOM id of the percentinfobox."%>
<%@ attribute name="infoclass" required="false" type="java.lang.String"
	description="infobox style"%>
<%@ attribute name="content" required="false"	type="java.lang.String" description="描述"%>
<%@ attribute name="percentclass" required="false" type="java.lang.String"
	description="percent style"%>
<%@ attribute name="datepercent" required="false" type="java.lang.String"
	description="显示数据所占百分比（例如60则显示在所占比例为60%），该数值默认应等于percent值"%>
	<%@ attribute name="datesize" required="false" type="java.lang.Integer" 
	description="百分比图标的大小(默认40)"%>
<%@ attribute name="percent" required="true" type="java.lang.Integer"
	description="所占比例(最大值为100，最小值为0)"%>

<c:set var="datepercent" value="${empty datepercent ? percent : datepercent}" />
<c:set var="content" value="${empty content ? '' : content}" />
<c:set var="percent" value="${percent < 0 ? 0 : percent}" />
<c:set var="percent" value="${percent > 100 ? 100 : percent}" />  
<c:set var="datesize" value="${empty datesize ? 40 : datesize}" />
<c:set var="datesize" value="${'' eq datesize ? 40 : datesize}" />
  
<div class="${infoclass}">
	<div class="infobox-progress">
		<div class="${percentclass}" data-percent="${datepercent}" data-size="${datesize}">
			<span class="percent">${percent}</span>%
		</div>
	</div>

	<div class="infobox-data">
		<div class="infobox-content">${content}</div>
	</div>
</div>
