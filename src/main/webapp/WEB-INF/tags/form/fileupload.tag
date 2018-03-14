<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建表单"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the textfield." %>
<%@ attribute name="required" required="false" rtexprvalue="false" type="java.lang.Boolean" description="label for the required." %>
<%@ attribute name="title" required="false" type="java.lang.String" description="title of the label" %>
<%@ attribute name="size" required="false" type="java.lang.String" description="input-mini, input-small, input-medium, input-large, input-xlarge, input-xxlarge, span1~12" %>

<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="value" value="${empty value ? '' : value}" />
<c:set var="required" value="${empty required ? false : required}" />
<c:set var="size" value="${empty size ? 'input-medium' : size}" />

<div class="control-group">
    <label class="control-label" for="${id}"><b>${title}</b><c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label> 
    <div class="controls">
        <div id="fileupload" data-provides="fileupload" class="fileupload fileupload-new">
            <div class="input-append">
                <div class="uneditable-input">
                    <i class="icon-file fileupload-exists"></i>
                    <span class="fileupload-preview"></span>
                </div>
               <span class="btn btn-file">
               <span class="fileupload-new">选择文件</span>
               <span class="fileupload-exists">修改</span>
               <input id="${id}" type="file" name="${id}[]" class="${size}"/>
               </span>
                <a data-dismiss="fileupload" class="btn fileupload-exists" href="form_component.html#">移除</a>
            </div>
        </div>
        
       
    </div>
  </div>


	
