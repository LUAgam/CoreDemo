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
<%@ attribute name="url" required="true" type="java.lang.String" description="action url of the form."%>
<%@ attribute name="width" required="true" type="java.lang.String" description="width of the dialog"%>
<%@ attribute name="height" required="true" type="java.lang.String" description="height of the dialog"%>
<%@ attribute name="dialogtitle" required="false" type="java.lang.String" description="弹出按钮标题" %>
<%@ attribute name="tableId" required="true" type="java.lang.String" description="内嵌表格的ID"%>
<%@ attribute name="tableDisplayNameColumnName" required="true" type="java.lang.String" description="表格中要显示在内容框上的字段名称"%>
<%@ attribute name="valueId" required="false" type="java.lang.Integer" description="对应的entityId" %>
<%@ attribute name="value" required="false" type="java.lang.String" description="对应的entityName" %>
<%@ attribute name="size" required="false" type="java.lang.String" description="input-mini, input-small, input-medium, input-large, input-xlarge, input-xxlarge, span1~12" %>

<c:set var="size" value="${empty size ? 'input-medium' : size}" />
<c:set var="title" value="${empty title ? '' : title}" />
<c:set var="required" value="${empty required ? false : required}" />
<c:set var="dialogtitle" value="${empty dialogtitle ? '' : dialogtitle}" />
<c:set var="valueId" value="${empty valueId ? 0 : valueId}" />
<c:set var="value" value="${empty value ? '' : value}" />

<div class="control-group">
	<input type="hidden" id="${id}" name="${id}" value="${valueId}">
	<label class="control-label" for="${id}"><b>${title}</b> <c:if test="${required eq true}"><font color="red"><b> *</b></font></c:if></label> 


	 <div class="controls">
		
        <div class="input-append">
            <input type="text" id="${id}_text" name="${id}_text"  class="${size}" value="${value}" readonly="readonly"/>
            <button id="${id}_button" type="button" class="btn btn-info"><i class="icon-search"></i></button>
            <button id="${id}_button_trash" type="button" class="btn btn-info"><i class="icon-trash"></i></button>
        </div>
    </div>

</div>
<script type="text/javascript">
jQuery(function($) {
	



	$('#${id}_button').on('click', function (e) {

		layer.open({
			type: 2,
			title: "${dialogtitle}",
			maxmin: true,
			shadeClose: true,
			area : ['${width}px' , '${height}px'],
		    content:  '${url}',
		    btn: ['选择', '关闭'],
		    success: function(layero, index){
		    	var body = layer.getChildFrame('body', index);
		    	 body.find("input[name=${tableId}_rowcheck][value='" + $("#${id}").val() +  "']").attr("checked","checked");	
		      },
		    yes: function(index, layero){
				var selectedIds = [];
				var body = layer.getChildFrame('body', index);
				body.find("#${tableId}_rowcheck:checked").each(function() {
					selectedIds.push($(this).val());
				});
				
				if (selectedIds.length > 1) {
					alert("只能选择一个！");
				} else {
					if (selectedIds.length == 1) {
						$("#${id}").val(selectedIds[0]);
						$("#${id}_text").val(body.find("#${tableDisplayNameColumnName}_" + selectedIds[0]).html()); 
					} else if(selectedIds.length == 0) {
						alert("没有选择任何的, 数据将清空！");
						$("#${id}").val(0);
						$("#${id}_text").val(""); 
					}
				}

		        layer.close(index); //如果设定了yes回调，需进行手工关闭
		      },
		      btn2: function(index, layero){
		    	    //按钮【按钮二】的回调
		    	     layer.close(index); //如果设定了yes回调，需进行手工关闭
		     },
		      cancel: function(index){ return true; }
			});	
		});
	
	$('#${id}_button_trash').on('click', function (e) {

		$("#${id}").val(0);
	    $("#${id}_text").val(""); 
	});
	});
</script>
