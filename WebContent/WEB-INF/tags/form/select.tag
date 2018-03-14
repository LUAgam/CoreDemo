<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建select box"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="唯一标记ID"%>
<%@ attribute name="required" required="false" type="java.lang.Boolean" description="必须填写。 默认为false"%>
<%@ attribute name="title" required="true" type="java.lang.String"	description="标题"%>
<%@ attribute name="selectType" required="false" type="java.lang.Integer" description="下拉框类型  1、单选不可搜索 (默认) 2、文本框中多选  3、单选可搜索  4、单行多选 " %>
<%@ attribute name="options" required="true" type="java.util.Collection" description="选项值"%>
<%@ attribute name="optionsType" required="false" type="java.lang.Integer" description="1 集合中数据 是对象类型(默认)  2 集合中数据是基本类型    3 集合中的数据是map类型" %>
<%@ attribute name="idField" required="false" type="java.lang.String" description="数据的id" %>
<%@ attribute name="size" required="false" type="java.lang.String" description="input-mini, input-small, input-medium, input-large, input-xlarge, input-xxlarge, span1~12" %>
<%@ attribute name="nameField" required="false" type="java.lang.String" description="数据的显示值字段" %>
<%@ attribute name="value" required="false" type="java.lang.Object" description="" %>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="required" value="${empty required ? false : required}" />
<c:set var="selectType" value="${empty selectType ? 1 : selectType}" />
<c:set var="idField" value="${empty idField ? 'id' : idField}" />
<c:set var="nameField" value="${empty nameField ? 'name' : nameField}" />
<c:set var="optionsType" value="${empty optionsType ? 1 : optionsType}" />
<c:set var="size" value="${empty size ? 'input-medium' : size}" />
<%-- <c:set var="value" value="${empty value ? '' : value}" /> --%>

 <div class="control-group">
    <label class="control-label" for="${id}"><b>${title}</b> <c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label>
    <div class="controls">
    	<c:choose>
			<c:when test="${selectType eq 1}">
				<select class="${size}" id="${id}" name="${id}" data-placeholder="请选择记录">
					<option value="">请选择记录</option>
					<c:if test="${optionsType eq 1}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${value eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${optionsType eq 2}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${optionItem eq value}">
									<option value="${optionItem}" selected="selected">${optionItem}</option>
								</c:when>
								<c:otherwise>
									<option value="${optionItem}">${optionItem}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${optionsType eq 3}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
							<c:when test="${value eq optionItem.key}">
								<option value="${optionItem.key}" selected="selected">${optionItem.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${optionItem.key}">${optionItem.value}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<option value="${optionItem.key}">${optionItem.value}</option>
						</c:forEach>
					</c:if>
					<c:if test="${optionsType eq 4}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${value eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</select>
			</c:when>
			
			<c:when test="${selectType eq 2}">
				<select class="chzn-select ${size}" id="${id}" multiple="multiple" name="${id}" data-placeholder="请选择记录">
					<c:if test="${optionsType eq 1}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${value[idField] eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${optionsType eq 2}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
							<c:when test="${value eq optionItem}">
								<option value="${optionItem}" selected="selected">${optionItem}</option>
							</c:when>
							<c:otherwise>
								<option value="${optionItem}">${optionItem}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					
					<c:if test="${optionsType eq 3}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
							<c:when test="${value eq optionItem.key}">
								<option value="${optionItem.key}" selected="selected">${optionItem.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${optionItem.key}">${optionItem.value}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					
					<c:if test="${optionsType eq 4}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${idField eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</select>
			</c:when>
			
			<c:when test="${selectType eq 3}">
				<select class="chzn-select ${size}" id="${id}" name="${id}">
					<option value="">&nbsp;</option>
					<c:if test="${optionsType eq 1}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${value[idField] eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${optionsType eq 2}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
							<c:when test="${value eq optionItem}">
								<option value="${optionItem}" selected="selected">${optionItem}</option>
							</c:when>
							<c:otherwise>
								<option value="${optionItem}">${optionItem}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					
					<c:if test="${optionsType eq 3}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
							<c:when test="${value eq optionItem.key}">
								<option value="${optionItem.key}" selected="selected">${optionItem.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${optionItem.key}">${optionItem.value}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${optionsType eq 4}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${value eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</select>
			</c:when>
			
			<c:otherwise>
				<select multiple="multiple" class="chzn-select ${size}" id="${id}" data-placeholder="请选择记录" name="${id}">
					<c:if test="${optionsType eq 1}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${value[idField] eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					<c:if test="${optionsType eq 2}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
							<c:when test="${value eq optionItem}">
								<option value="${optionItem}" selected="selected">${optionItem}</option>
							</c:when>
							<c:otherwise>
								<option value="${optionItem}">${optionItem}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					
					<c:if test="${optionsType eq 3}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
							<c:when test="${value eq optionItem.key}">
								<option value="${optionItem.key}" selected="selected">${optionItem.value}</option>
							</c:when>
							<c:otherwise>
								<option value="${optionItem.key}">${optionItem.value}</option>
							</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
					
					<c:if test="${optionsType eq 4}">
						<c:forEach var="optionItem" items="${options}" varStatus="status">
							<c:choose>
								<c:when test="${idField eq optionItem[idField]}">
									<option value="${optionItem[idField]}" selected="selected">${optionItem[nameField]}</option> 
								</c:when>
								<c:otherwise>
									<option value="${optionItem[idField]}">${optionItem[nameField]}</option> 
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:if>
				</select>
			</c:otherwise>
		
		</c:choose>
    </div>
</div>