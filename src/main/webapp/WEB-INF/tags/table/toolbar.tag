<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建表格控件中的工具条"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="newButton" required="true" type="java.lang.Boolean" description="是否显示新增按钮"%>
<%@ attribute name="delButton" required="true" type="java.lang.Boolean" description="是否显示删除按钮"%>
<%@ attribute name="search" required="true" type="java.lang.Boolean" description="是否显示右侧搜索栏"%>
<%@ attribute name="advSearch" required="true" type="java.lang.Boolean" description="是否显示高级搜索栏"%>
<%@ attribute name="searchLab" required="false" type="java.lang.String" description="搜索栏标题"%>
<%@ attribute name="searchProperty" required="false" type="java.lang.String" description="搜索栏搜索属性"%>
<%@ attribute name="newButtonTitle" required="false" type="java.lang.String" description="是否显示新增按钮"%>


<c:set var="newButtonTitle" value="${empty newButtonTitle ? '新增' : newButtonTitle}" />

<c:if test="${toolbarVarManagement}">
	<div class="clearfix">
           <div class="btn-group">
               <c:if test="${newButton eq true}">
					<a class="btn btn-sm btn-primary" href="${ctx}/${optionUrlString}/add/">${newButtonTitle}</a>
				</c:if>
				<c:if test="${delButton eq true}">
					<a class="btn btn-sm btn-danger" onclick="${tableId}_del_button_click()">删除</a>
				</c:if>
				
				<c:set var="commandManagement" value="true" scope="request" />
				<jsp:doBody />
				<c:set var="commandManagement" value="false" scope="request" />
           </div>
           <div class="pull-right">
               <c:if test="${search eq true}">
               		<div class="input-append">
                         <input class="input-medium" id="${tableId}_search" type="text" placeholder="${searchLab}" >
                         <button class="btn btn-info" type="button"  onclick="${tableId}_search();"><i class="icon-search"></i> </button>
                     </div>
				</c:if>
           </div>
       </div>


</c:if>
<script type="text/javascript">
$(function(){
	$("#${tableId}_search").bind('keypress',function(event){
     	  if(event.keyCode == 13){
     		 ${tableId}_search();
     	  };  
      }); 
});

</script>