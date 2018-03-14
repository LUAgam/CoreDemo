<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建消息框"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the form." %>
<%@ attribute name="length" required="false" type="java.lang.Integer" description="消息框的长度" %>
<%@ attribute name="content" required="false" type="java.lang.String" description="消息框的内容" %>
<%@ attribute name="icon" required="false" type="java.lang.String" description="消息框的图标" %>
<%@ attribute name="close" required="false" type="java.lang.Boolean" description="消息框的关闭按钮" %>
<%@ attribute name="alerttype" required="false" type="java.lang.Integer" description="消息框的颜色。 1 蓝色，2 绿色， 3 黄色， 4 红色" %>


<c:set var="length" value="${empty length ? 12 : length}" />
<c:set var="icon" value="${empty icon ? 'icon-hand-right' : icon}" />
<c:set var="close" value="${empty close ? true : close}" />
<c:set var="alerttype" value="${empty alerttype ? 1 : alerttype}" />

<div id="${id }" class="col-xs-${length}">
	<c:choose>
       <c:when test="${alerttype == 1}">
          <div class="alert alert-info">
       </c:when>
       <c:when test="${alerttype == 2}">
          <div class="alert alert-success">
       </c:when>
       <c:when test="${alerttype == 3}">
          <div class="alert alert-warning">
       </c:when>
       <c:otherwise>
       		<div class="alert alert-danger">
       </c:otherwise>
    </c:choose>
	
		<i class="${icon}"></i> ${content}
		<c:if test="${close eq true}">
			<button class="close" data-dismiss="alert">
				<i class="icon-remove"></i>
			</button>
		</c:if>
	</div>
</div>