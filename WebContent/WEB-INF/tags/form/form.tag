<%--
 (c) 2006 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建表单"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="DOM id of the form."%>
<%@ attribute name="action" required="false" type="java.lang.String" description="action url of the form."%>
<%@ attribute name="method" required="false" type="java.lang.String" description="get, post"%>
<%@ attribute name="orient" required="false" type="java.lang.String" description="horizontal, vertical"%>


<c:set var="action" value="${empty action ? '' : action}" />
<c:set var="method" value="${empty method ? 'post' : method}" />
<c:set var="orient" value="${empty orient ? 'horizontal' : orient}" />

<c:set var="hasDatefield" value="false" scope="request" />
<c:set var="hasDaterangefield" value="false" scope="request" />
<c:set var="hasTextareafield" value="false" scope="request" />
<c:set var="hasDatetimefield" value="false" scope="request" />
<c:set var="hasColorpicker" value="false" scope="request" />
<c:set var="hasCustomColorpicker" value="false" scope="request" />


<form class="form-${orient}" id="${id}" action="<c:url value='${action}'/>" method="${method}" enctype="multipart/form-data">
	<c:if test="${not empty message}">
		<div class="alert alert-danger">
			<strong>
				<i class="ace-icon fa fa-info"></i>
				友情信息：
			</strong>
			<br />
			${message}
		</div>
		
	</c:if>
	<jsp:doBody />
	
</form>

<script type="text/javascript">

	
	jQuery(function($) {
		
		//文本域
		<c:if test="${hasTextareafield eq true}">

			$('textarea[class*=autosize]').autosize({
				append : "\n"
			});
			
			$('textarea.limited').inputlimiter({
				remText : '%n character%s remaining...',
				limitText : 'max allowed : %n.'
			});
		</c:if>
		
		
		//时间控件（只显示到天）
		<c:if test="${hasDatetimefield eq true}">
			
		</c:if>
		
		//时间控件
		<c:if test="${hasDatefield eq true}">
		

		 </c:if>
		
		//颜色控件
		<c:if test="${hasColorpicker eq true}">
			$(".colorpicker1").colorpicker();
		</c:if>
		
		<c:if test="${hasCustomColorpicker eq true}">
			$(".colorpicker2").ace_colorpicker();
		</c:if>
		
		 // mask
	    $(".numeric0").numeric(".");
	    $(".numeric1").numeric(".");
	    $(".numeric2").numeric(".");
	    $(".numeric3").numeric(".");
	    $(".numeric4").numeric(".");
	    $(".numeric5").numeric(".");
	    $(".numeric6").numeric(".");
	    

		$(".numeric0").floatnumber(".",0);
		$(".numeric1").floatnumber(".",1);
		$(".numeric2").floatnumber(".",2);
	    $(".numeric3").floatnumber(".",3);
	    $(".numeric4").floatnumber(".",4);
	    $(".numeric5").floatnumber(".",5);
	    $(".numeric6").floatnumber(".",6); 
	
		$(".chosen-select").chosen();
		
		/* $(".file").pekeUpload({multi:false}); */
		
		
		$(".chzn-select").chosen(); 
	  	$(".chzn-select-deselect").chosen({allow_single_deselect:true});
		
	});
</script>

