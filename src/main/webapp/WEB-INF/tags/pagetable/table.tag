<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="创建table表格"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<%@ attribute name="htmlTableId" required="true" type="java.lang.String" description="表格的DOM ID"%>
<%@ attribute name="url" required="true" type="java.lang.String" description="表格内容"%>
<%@ attribute name="page" required="true" type="org.springframework.data.domain.Page" description="表格内容"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"	scope="request" />
<c:set var="htmlTableId" value="${htmlTableId}" scope="request" />

<%
int paginationSize = page.getSize();
int current =  page.getNumber() + 1;
int begin = Math.max(1, current - 10/2);
int total = page.getTotalPages();
int end = Math.min(begin + (10 - 1), page.getTotalPages());
long totalElements = page.getTotalElements();
int from = (current-1) * paginationSize + 1;
long to = Math.min(from + paginationSize-1, totalElements); 
if(totalElements<1){
	from=0;
}

request.setAttribute("current", current);
request.setAttribute("begin", begin);
request.setAttribute("end", end);
request.setAttribute("totalPages", total);
request.setAttribute("totalElements", totalElements);
request.setAttribute("from", from);
request.setAttribute("to", to);

%>
	
<form name="${htmlTableId}pageForm" action="${ctx}${url}" method="POST">
	<input type="hidden" id="${htmlTableId}pageNo" name="PAGE_NUMBER_KEY" value="0"/>

	<div id="${htmlTableId}_wrapper" class="dataTables_wrapper form-inline" role="grid">

		<!-- toolbar按钮和搜索条 -->
		<div class="row-fluid">
			
			
			
			<div class="span12">

					<div id="${htmlTableId}_filter" class="dataTables_filter">
						<c:set var="searchBar" value="true" scope="request" />
							<jsp:doBody />
						<c:set var="searchBar" value="false" scope="request" />
						<a class="btn btn-purple" onclick="${htmlTableId}_page(1);">
							<i class="icon-search bigger-110"></i>
							<span class="bigger-110 no-text-shadow">过滤搜索</span>
						</a>
						
						<a class="btn" onclick="${htmlTableId}_clearSearch();">
							<i class="icon-remove bigger-110"></i>
							<span class="bigger-110 no-text-shadow">清除过滤</span>
						</a>
					</div>
			</div>
		
		</div>
		<div class="row-fluid">
			                   
			<div class="form-actions">
			
					<c:set var="toolbarButton" value="true" scope="request" />
						<jsp:doBody />
					<c:set var="toolbarButton" value="false" scope="request" />


			</div>
		</div>

		<table id="${htmlTableId}" class="table table-striped table-bordered dataTable" aria-describedby="${htmlTableId}-table_info">
			<thead>
				<tr role="row">
					<c:set var="columnheader" value="true" scope="request" />
					<jsp:doBody />
					<c:set var="columnheader" value="false" scope="request" />
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${page.content}" var="item" varStatus="status">
					<c:set var="entity" value="${item}" scope="request" />
					<c:set var="currentrow" value="${page.size *  page.number + status.index+1}" scope="request" />
					<c:choose>
					

						<c:when test="${status.index%2==0}">
							<tr role="row" class="gradeX odd">
						</c:when>

						<c:otherwise>
							<tr role="row" class="odd gradeX even">
						</c:otherwise>

					</c:choose>


					<c:set var="column" value="true" scope="request" />
						<jsp:doBody />
					<c:set var="column" value="false" scope="request" />

				</c:forEach>


			</tbody>
		</table>

		<!-- 分页控件 -->
		<div class="row-fluid">
			<div class="span6">
				<div class="dataTables_info" id="${htmlTableId}_l_length">

					<label>显示
					<select id="${htmlTableId}pageSize" name="PAGE_SIZE_KEY" class="input-mini" style="width:80px;" onchange="${htmlTableId}_page(1);">
							<c:choose>
								<c:when test="${page.size eq 10}">
									<option value="10" selected>10</option>
								</c:when>
								<c:otherwise>
									<option value="10">10</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${page.size eq 20}">
									<option value="20" selected>20</option>
								</c:when>
								<c:otherwise>
									<option value="20">20</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${page.size eq 50}">
									<option value="50" selected>50</option>
								</c:when>
								<c:otherwise>
									<option value="50">50</option>
								</c:otherwise>
							</c:choose>
							
					</select> 记录 </label>
					
					<label>[从 ${from} 到 ${to} 条记录，共 ${totalElements} 条记录]</label>

				</div>
			</div>
			<div class="span6">
				<div class="dataTables_paginate paging_bootstrap pagination" id="${htmlTableId}_paginate">
					<ul>
						<% if (page.getNumber()>0){%>
						<li class="prev" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_previous"><a href="javascript:;" onclick="${htmlTableId}_page(${1});">首页</a></li>
						<li class="prev" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_previous"><a href="javascript:;" onclick="${htmlTableId}_page(${current-1});">上一页</a></li>
						<%}else{%>
						<li class="prev disabled" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_previous"><a href="#">←首页</a>	</li>
						<li class="prev disabled" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_previous"><a href="#">←上一页</a>	</li>
						<%} %>

						<c:forEach var="i" begin="${begin}" end="${end}">
							<c:choose>
								<c:when test="${i == current}">
									<li class="active" aria-controls="${htmlTableId}" tabindex="0"><a href="#">${i}</a>
									</li>
								</c:when>
								<c:otherwise>
									<li aria-controls="${htmlTableId}" tabindex="0"><a href="javascript:;" onclick="${htmlTableId}_page(${i});">${i}</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<% if ((page.getNumber()+1)<page.getTotalPages()){%>
						<li class="next" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_next"><a href="javascript:;" onclick="${htmlTableId}_page(${current+1});">下一页</a>
						<li class="next" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_next"><a href="javascript:;" onclick="${htmlTableId}_page(${totalPages});">末页</a>
						</li>
						<%}else{%>
						<li class="next disabled" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_next"><a href="#">下一页 →</a>
						<li class="next disabled" aria-controls="${htmlTableId}" tabindex="0" id="${htmlTableId}_next"><a href="#">末页 →</a>
						</li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<input type="submit" id="${htmlTableId}pageFormSubmit" name="argsubmit" style="display:none"/>
</form>

<script type="text/javascript">
laydate.skin('danlan');

function ${htmlTableId}_export(){
	$("#EXPORT").val("1");
	$("#${htmlTableId}pageNo").val(0);
	$("#${htmlTableId}pageFormSubmit").click();
	return false;
}

function ${htmlTableId}_page(n){
	$("#EXPORT").val("0");
	$("#${htmlTableId}pageNo").val(n-1);
	$("#${htmlTableId}pageFormSubmit").click();
	return false;
}
	
function ${htmlTableId}_clearSearch() {
	$("#EXPORT").val("0");
	$('input[type=search]').val("");
	$('select').val("");
	${htmlTableId}_page(1);
}

</script>

<c:set var="optioncolumnScript" value="true" scope="request" />
	<jsp:doBody />
<c:set var="optioncolumnScript" value="false" scope="request" />