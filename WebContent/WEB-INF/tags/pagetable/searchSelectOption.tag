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
<%@ attribute name="options" required="true" type="java.util.Collection" description="选项值"%>

<%-- HTML parameters --%>
<c:set var="idField" value="${empty idField ? 'id' : idField}" />
<c:set var="keyField" value="${empty keyField ? 'key' : keyField}" />
<c:if test="${searchBar}">
<label><b>${title}:</b>
	<select class="input-medium" id="${id}" name="SEARCH_${key}@=@OPTIONS"> 
			<c:if test="${value != null && value != ''}">
				<option value="">----</option>
			</c:if>
			<c:if test="${value == null || value == ''}">
				<option value="" selected>----</option>
			</c:if>
			
			<c:forEach var="optionItem" items="${options}" varStatus="status">
			
					<option value="${optionItem}"  ${value eq optionItem ? 'selected' : ''}>${optionItem}</option> 
			</c:forEach>
	</select>
</c:if>
</label>	&nbsp;&nbsp;&nbsp;&nbsp;	
