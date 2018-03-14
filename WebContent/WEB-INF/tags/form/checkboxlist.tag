<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建多项按钮"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="唯一标记ID"%>
<%@ attribute name="required" required="false" rtexprvalue="false" type="java.lang.Boolean" description="必须填写。 默认为false"%>
<%@ attribute name="inline" required="false" rtexprvalue="false" type="java.lang.Boolean" description="默认为false"%>
<%@ attribute name="title" required="false" type="java.lang.String"	description="标题"%>
<%@ attribute name="options" required="true" type="java.util.Collection" description="选项值"%>
<%@ attribute name="values" required="false" type="java.util.Collection"  description="值（多选值）"%>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="value" value="${empty value ? '' : value}" />
<c:set var="required" value="${empty required ? false : required}" />
<c:set var="inline" value="${empty inline ? false : inline}" />

<div class="control-group">
    <label class="control-label" for="${id}"><b>${title}</b> <c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label>
    <div class="controls">
		<c:forEach var="optionItem" items="${options}" varStatus="status">
					<label class="checkbox <c:if test="${inline eq true}">inline</c:if>">
						<c:choose>
				           <c:when test="${fn:contains(values, optionItem)}">
				              <input name="${id}" type="checkbox" checked="checked" value="${optionItem}"/> ${optionItem} 
				           </c:when>
				           <c:otherwise>
				              <input name="${id}" type="checkbox" value="${optionItem}" /> ${optionItem}
				           </c:otherwise>
				        </c:choose>
					</label>
			</c:forEach>    	
    </div>
</div>
