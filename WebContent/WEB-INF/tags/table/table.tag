<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建table表格"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="htmlTableId" required="true" type="java.lang.String" description="表格的DOM ID" %>
<%@ attribute name="ajaxSource" required="true" type="java.lang.String" description="获取表格内容JSON的URL" %>
<%@ attribute name="check" required="false" type="java.lang.Boolean" description="显示选择列" %>
<%@ attribute name="checkValue" required="false" type="java.lang.String" description="选择回调显示的值" %>
<%@ attribute name="option" required="false" type="java.lang.Boolean" description="显示选择操作列" %>
<%@ attribute name="optionUrlString" required="false" type="java.lang.String" description="指定操作URL" %>
<%@ attribute name="optionWidth" required="false" type="java.lang.String" description="指定操作URL" %>

<%@ attribute name="optionEdit" required="false" type="java.lang.Boolean" description="显示编辑按钮" %>
<%@ attribute name="optionDel" required="false" type="java.lang.Boolean" description="显示编辑删除" %>

<%@ attribute name="extCommand1Title" required="false" type="java.lang.String" description="额外按钮1" %>
<%@ attribute name="extCommand1Icon" required="false" type="java.lang.String" description="额外图标1" %>
<%@ attribute name="extCommand1Color" required="false" type="java.lang.String" description="额外颜色1" %>
<%@ attribute name="extCommand1Action" required="false" type="java.lang.String" description="额外操作URL1" %>

<%@ attribute name="extCommand2Title" required="false" type="java.lang.String" description="额外按钮2" %>
<%@ attribute name="extCommand2Icon" required="false" type="java.lang.String" description="额外图标2" %>
<%@ attribute name="extCommand2Color" required="false" type="java.lang.String" description="额外颜色2" %>
<%@ attribute name="extCommand2Action" required="false" type="java.lang.String" description="额外操作URL2" %>

<%@ attribute name="extCommand3Title" required="false" type="java.lang.String" description="额外按钮3" %>
<%@ attribute name="extCommand3Icon" required="false" type="java.lang.String" description="额外图标3" %>
<%@ attribute name="extCommand3Color" required="false" type="java.lang.String" description="额外颜色3" %>
<%@ attribute name="extCommand3Action" required="false" type="java.lang.String" description="额外操作URL3" %>

<%@ attribute name="extCommand4Title" required="false" type="java.lang.String" description="额外按钮4" %>
<%@ attribute name="extCommand4Icon" required="false" type="java.lang.String" description="额外图标4" %>
<%@ attribute name="extCommand4Color" required="false" type="java.lang.String" description="额外颜色4" %>
<%@ attribute name="extCommand4Action" required="false" type="java.lang.String" description="额外操作URL4" %>

<%-- ******************************************** --%>
<%-- Variables initialization --%>
<%-- ******************************************** --%>
<%-- Global ones --%>
<c:set var="delimitor" value="|" scope="request" />
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>
<c:set var="tableId" value="${htmlTableId}" scope="request" />

<%-- Column ones --%>
<c:set var="titles" scope="request" />
<c:set var="sortables" scope="request" />
<c:set var="properties" scope="request" />
<c:set var="widths" scope="request" />
<c:set var="searchids" scope="request" />

<%-- Table ones --%>
<c:set var="colCounter" value="0" scope="request" />
<c:set var="dataTableSortProperty" value="[]" />
<c:set var="sortPreProperty" value="${empty sort ? true : sort}" />
<c:set var="check" value="${empty check ? false : check}" />
<c:set var="checkValue" value="${empty checkValue ? 'id' : checkValue}" />
<c:set var="option" value="${empty option ? true : option}" />
<c:set var="optionUrlString" value="${empty optionUrlString ? '' : optionUrlString}" scope="request"/>
<c:set var="optionWidth" value="${empty optionWidth ? '100px' : optionWidth}" />
<c:set var="optionEdit" value="${empty optionEdit ? true : optionEdit}" />
<c:set var="optionDel" value="${empty optionDel ? true : optionDel}" />


<%-- Evaluation du corps du tag table --%>
<c:set var="htmlVarManagement" value="true" scope="request" />
<jsp:doBody />
<c:set var="htmlVarManagement" value="false" scope="request" />


<c:set var="toolbarVarManagement" value="true" scope="request" />
<jsp:doBody />
<c:set var="toolbarVarManagement" value="false" scope="request" />



	<table id="${htmlTableId}" class="table table-striped table-bordered">
	<thead>
	   
	   <tr>
	      <c:if test="${check eq true}">
		   	  <th class="center"><label> 
		   	  		<input type="checkbox" />
			  </label></th>
		  </c:if>
	      <c:forTokens items="${titles}" delims="${delimitor}" var="title" varStatus="s">
	         <th><c:out value="${title}" /></th>
	      </c:forTokens>
	      <c:if test="${option eq true}">
		   	  <th>操作</th>
		  </c:if>
	   </tr>
	</thead>
	<tbody>
	   
	</tbody>
	</table>


<%-- Evaluation du corps du tag table --%>
<c:set var="bodyManagement" value="true" scope="request" />
<jsp:doBody />
<c:set var="bodyManagement" value="false" scope="request" />

<script type="text/javascript">
	
	var ${tableId}_oTable;
	
	function ${tableId}_search() {
		${tableId}_oTable.fnDraw();
	}
	
	function ${tableId}_clear() {
		 <c:forTokens items="${searchids}" delims="${delimitor}" var="searchid" varStatus="s">
		 	$("#${searchid}").val("");
    	  </c:forTokens>
	}
	//href="${ctx}/${optionUrlString}/delete/' + oObj.aData['id'] + '
	function ${tableId}_deleteT(q) {
		 if(confirm("确定删除吗")){
			 var url = "${ctx}/${optionUrlString}/delete/" + q;
	          location.href=url;
	      }else{
	      }
	}
	jQuery(function($) {
		function ${tableId}_retrieveData(sSource, aoData, fnCallback) {
			
			//aoData.push("iDisplayPage",this.fnPagingInfo().iPage);
			
			$('.dataTables_length select').addClass("input-mini"); 
			
			aoData.push( {"name": "iDisplayPage", "value": this.fnPagingInfo().iPage}); 
			
			var normalSearchValue =  $("#${tableId}_search").val();
			aoData.push({"name": "normalsearch", "value": normalSearchValue}); 
			
			var dropDownBoxValue = $("#${tableId}_dropDownBox").val();
			aoData.push({"name": "dropDownBox", "value": dropDownBoxValue}); 
			
			<c:forTokens items="${searchids}" delims="${delimitor}" var="searchid" varStatus="s">
				var searchValue =  $("#${searchid}").val();
				var searchKey =  $("#${searchid}").attr("name");
				
				aoData.push( {"name": searchKey, "value": searchValue}); 
	    	 </c:forTokens>
			
			$.ajax({
				"type" : "POST",
				"contentType" : "application/json",
				"url" : sSource,
				"dataType" : "json",
				"data" : JSON.stringify(aoData), //以json格式传递
				"success" : function(resp) {
					fnCallback(resp); //服务器端返回的对象的returnObject部分是要求的格式
				}
			});
		}

		${tableId}_oTable = $('#${htmlTableId}')
				.dataTable(
						{
							"bDestroy": true,
							"bScrollCollapse": true,  //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false) 
							"bAutoWidth": false,  //自适应宽度    
							"bProcessing" : true, //加载数据时显示正在加载信息  
							"bFilter" : false, //不使用过滤功能
							"bServerSide" : true, //指定从服务器端获取数据  
							"bStateSave": true,
							"sAjaxSource" : "<c:url value='${ajaxSource}'/>", //获取数据的url
							"aoColumns" : [
							        <c:if test="${check eq true}">
										{
											"sClass" : "center",
											"mDataProp" : null,
											"sWidth" : "8px",
											"sDefaultContent" : "",
											"fnRender" : function(oObj) {
												return '<input id="${htmlTableId}_rowcheck" type="checkbox" value="' + oObj.aData['id'] + '" />'
												          + '<input id="${htmlTableId}_' + oObj.aData['id'] +'_rowvalue" type="hidden" value="' + oObj.aData['${checkValue}'] + '" />';
											},
											"bSortable" : false
										},
									</c:if>
									<c:forTokens var="property" items="${properties}" delims="${delimitor}" varStatus="p">
										${property},
									</c:forTokens>	
									<c:if test="${option eq true}">
										{
											"mDataProp" : null, 
											"sDefaultContent" : "",
											"sWidth" : "${optionWidth}",
											"fnRender" : function(oObj) {
												
												return '<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">'
														<c:if test="${optionEdit}">
															+ '<a title="修改" href="${ctx}/${optionUrlString}/edit/' + oObj.aData['id'] + '"><i class="icon-pencil bigger-130"></i></a> '
														</c:if>
														<c:if test="${optionDel}">
																+ '<a title="删除"  onclick="${tableId}_deleteT('+oObj.aData['id']+')"><i class="icon-trash bigger-130"></i></a> '
														</c:if>
														<c:if test="${not empty extCommand1Title}">
															+ '<a title="${extCommand1Title}" href="${ctx}/${optionUrlString}/${extCommand1Action}/' + oObj.aData['id'] + '"><i class="${extCommand1Icon} bigger-130"></i></a> '
														</c:if>
														<c:if test="${not empty extCommand2Title}">
															+ '<a title="${extCommand2Title}" href="${ctx}/${optionUrlString}/${extCommand2Action}/' + oObj.aData['id'] + '"><i class="${extCommand2Icon} bigger-130"></i></a> '
														</c:if>
														<c:if test="${not empty extCommand3Title}">
															+ '<a title="${extCommand3Title}" href="${ctx}/${optionUrlString}/${extCommand3Action}/' + oObj.aData['id'] + '"><i class="${extCommand3Icon} bigger-130"></i></a> '
														</c:if>
														<c:if test="${not empty extCommand4Title}">
															+ '<a title="${extCommand4Title}" href="${ctx}/${optionUrlString}/${extCommand4Action}/' + oObj.aData['id'] + '"><i class="${extCommand4Icon} bigger-130"></i></a> '
														</c:if>
														+ '</div>';
														
											},
											"bSortable" : false
										}
									</c:if>
									
									],
							"fnServerData" : ${tableId}_retrieveData, //获取数据的处理函数  
							
							"oLanguage" : {
								"sUrl" : "<c:url value='/static/assets/data-tables/jquery.data.table.cn.txt'/>"
							}
						});

		<c:if test="${check eq true}">
			$('table th input:checkbox').on(
					'click',
					function() {
						var that = this;
						$(this).closest('table').find(
								'tr > td:first-child input:checkbox').each(
								function() {
									this.checked = that.checked;
									$(this).closest('tr').toggleClass('selected');
								});
	
					});
		</c:if>	
	
	});
	
	

	
</script>


