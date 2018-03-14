<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建单选按钮"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="唯一标记ID"%>
<%@ attribute name="required" required="false" type="java.lang.Boolean" description="必须填写。 默认为false"%>
<%@ attribute name="title" required="true" type="java.lang.String"	description="标题"%>
<%@ attribute name="options" required="true" type="java.util.Collection" description="选项值"%>
<%@ attribute name="optionsType" required="false" type="java.lang.Integer" description="1 集合中数据 是对象类型(默认)  2 集合中数据是基本类型    3 集合中的数据是map类型" %>
<%@ attribute name="idField" required="false" type="java.lang.String" description="数据的id" %>
<%@ attribute name="size" required="false" type="java.lang.String" description="input-mini, input-small, input-medium, input-large, input-xlarge, input-xxlarge, span1~12" %>
<%@ attribute name="nameField" required="false" type="java.lang.String" description="数据的显示值字段" %>
<%@ attribute name="value" required="false" type="java.lang.Object" description="值" %>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="required" value="${empty required ? false : required}" />
<c:set var="idField" value="${empty idField ? 'id' : idField}" />
<c:set var="nameField" value="${empty nameField ? 'name' : nameField}" />
<c:set var="optionsType" value="${empty optionsType ? 1 : optionsType}" />
<c:set var="size" value="${empty size ? 'input-medium' : size}" />

<div class="control-group">
    <label class="control-label" for="${id}"><b>${title}</b><c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label>
    <div class="controls">
			<c:if test="${optionsType eq 1}">
				<c:forEach var="optionItem" items="${options}" varStatus="status">
					<c:choose>
						<c:when test="${value[idField] eq optionItem[idField]}">
								<input name="${pageScope.id}" type="radio" class="${size}" value="${optionItem[idField]}" checked="checked"/> ${optionItem[nameField]} <br>
						</c:when>
						<c:otherwise>
							<input name="${pageScope.id}" type="radio" class="${size}" value="${optionItem[idField]}"/> ${optionItem[nameField]} <br>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			<c:if test="${optionsType eq 2}">
				<c:forEach var="optionItem" items="${options}" varStatus="status">
					<c:choose>
						<c:when test="${value eq optionItem}">
							<input name="${pageScope.id}" type="radio" class="${size}" value="${optionItem}" checked="checked"/> ${optionItem} <br>
						</c:when>
						<c:otherwise>
							<input name="${pageScope.id}" type="radio" class="${size}" value="${optionItem}"/> ${optionItem} <br>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>
			
			<c:if test="${optionsType eq 3}">
				<c:forEach var="optionItem" items="${options}" varStatus="status">
					<c:choose>
						<c:when test="${value eq optionItem.key}">
							<input name="${pageScope.id}" type="radio" class="${size}" value="${optionItem.key}" checked="checked"/> ${optionItem.value} <br>
						</c:when>
						<c:otherwise>
							<input name="${pageScope.id}" type="radio" class="${size}" value="${optionItem.key}"/> ${optionItem.value} <br>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</c:if>

    </div>
</div>