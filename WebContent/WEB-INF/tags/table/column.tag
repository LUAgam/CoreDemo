<%--
	fnRender 中 oObj.aData['id'] 为行变量
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建table表格"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ attribute name="property" required="true" type="java.lang.String" description="数据绑定属性名" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="列标题" %>
<%@ attribute name="width" required="true" type="java.lang.String" description="列宽" %>
<%@ attribute name="sortable" required="false" type="java.lang.Boolean" description="是否排序" %>
<%@ attribute name="fnRender" required="false" type="java.lang.String" description="修改当列值展示形式， 行变量为oObj" %>

  
<c:set var="colCounter" value="${colCounter + 1}" scope="request" />

<%-- HTML parameters --%>
<c:if test="${htmlVarManagement}">
	<c:choose>
		<c:when test="${empty titles}">
			<c:set var="titles" value="${title}" scope="request" />
		</c:when>
		<c:otherwise>
			<c:set var="titles" value="${titles}${delimitor}${title}" scope="request" />
		</c:otherwise>
	</c:choose>
	
</c:if>

<c:set var="sortable" value="${empty sortable ? false : sortable}" />

<%-- EVALUATION DU CORPS DU TAG COLUMN --%>
<c:if test="${bodyManagement}">
	<c:set var="dataProp" value="{\"mDataProp\" : \"${property}\"" />
	<c:set var="width" value="\"sWidth\" : \"${width}\"" />
	<c:set var="sortable" value="\"bSortable\" : ${sortable}" />
	
	<c:choose>
		<c:when test="${empty fnRender}">
			<c:set var="property" value="${dataProp},${width},${sortable}}" />
		</c:when>
		<c:otherwise>
			<c:set var="property" value="{\"mDataProp\" : null,\"sDefaultContent\" : \"\",${width},${sortable}, \"fnRender\" : function(oObj) { return '${fnRender}' }}" />
		</c:otherwise>
	</c:choose>
	
	
		
	<c:choose>
		<c:when test="${empty properties}">
			
			<c:set var="properties" value="${property eq null ? 'null' : property}" scope="request" />
		</c:when>
		<c:otherwise>
			<%--<c:set var="properties" value="${property eq null ? properties + delimitor + 'null' : properties + delimitor + property}" scope="request" /> --%>
			<c:choose>
				<c:when test="${property eq null}">
					<c:set var="properties" value="${properties}${delimitor}null" scope="request" />
				</c:when>
				<c:otherwise>
					<c:set var="properties" value="${properties}${delimitor}${property}" scope="request" />
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	
</c:if>