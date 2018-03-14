<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建textfield"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the textfield." %>
<%@ attribute name="required" required="false" rtexprvalue="false" type="java.lang.Boolean" description="label for the required." %>
<%@ attribute name="title" required="false" type="java.lang.String" description="title of the label" %>
<%@ attribute name="value" required="false" type="java.lang.String" description="value of the textfield" %>
<%@ attribute name="rows" required="false" type="java.lang.Integer" description="height of the textfield" %>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="value" value="${empty value ? '' : value}" />
<c:set var="required" value="${empty required ? false : required}" />
<c:set var="rows" value="${empty rows ? 20 : rows}" />

<div class="control-group">
	<label class="control-label" for="${id}"><b>${title}</b><c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label> 
    <div class="controls">
    	<textarea id="${id}" name="${id}" rows="${rows}">${value}</textarea>
    </div>
</div>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="${id}"]', {
			uploadJson : "<c:url value='/editk/file_upload'/>",
            fileManagerJson : "<c:url value='/editk/file_manager'/>",
            allowFileManager : true
		});
	});
</script>