<%--
 (c) 2015 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="标识"%>
<%@ attribute name="minWidth" required="false" type="java.lang.Long" description="宽度" %>
<%@ attribute name="table" required="true" type="com.joven.jvcore.web.charts.formbean.WarningIndexCompanyTable" description="" %>

<c:set var="minWidth" value="${empty minWidth ? 350 : minWidth}" />
<div class="row-fluid">
	<form class="form-inline" action="<c:url value='/chart/tab/tab3/search'/>" id="${id}_form" method="post">
    	<div class="span1">
		</div>
    	<div class="span3">
    		 <label>显示：</label>
    		 <c:choose>
    		 	<c:when test="${table.showAll}">
    		 		<input type="radio" name="showAll" value="true" checked="checked"/>全部
			 		<input type="radio" name="showAll" value="false"/>异常
    		 	</c:when>
    		 	<c:otherwise>
    		 		<input type="radio" name="showAll" value="true"/>全部
			 		<input type="radio" name="showAll" value="false" checked="checked"/>异常
    		 	</c:otherwise>
    		 </c:choose>
		</div>
        <div class="span8">
          	    <label>公司：</label>
          	    <c:forEach items="${table.companys}" var="item">
          	    	<label class="checkbox"><span class=""><input type="checkbox" name="companyIds" value="${item.compyId}" ${item.show?'checked="checked"':''}>${item.compyName}</span></label>
          	    </c:forEach>
                <!-- <label class="checkbox"><span class=""><input type="checkbox" >上航</span></label>
                <label class="checkbox"><span class=""><input type="checkbox" >上航</span></label>
           		<label class="checkbox"><span class=""><input type="checkbox" >上航</span></label>
                <label class="checkbox"><span class=""><input type="checkbox" >上航</span></label>
                <label class="checkbox"><span class=""><input type="checkbox" >上航</span></label>
                <label class="checkbox"><span class=""><input type="checkbox" >上航</span></label> -->
		</div>
		
	</form>
</div>

<div class="row-fluid">
            <div class="span12">
	<table class="table" border="0">
		<thead>
			<tr>
				<c:forEach items="${table.colHeader}" var="head">
					<th>${head}</th>
				</c:forEach>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${table.data}" var="dataItem">
				<tr name="flagCount_${dataItem.key.flagCount}">
					<td>${dataItem.key.warningIndexType}</td>
					<td>${dataItem.key.waringIndexName}</td>
					<c:forEach items="${table.colHeader}" var="item" begin="2">
						<td>
							<c:choose>
								<c:when test="${dataItem.value[item].flag == 0}"><font color="green"></c:when>
								<c:when test="${dataItem.value[item].flag == 1}"><font color="orange"></c:when>
								<c:otherwise><font color="red"></c:otherwise>
							</c:choose>
							<b> ${dataItem.value[item].value}</b></font></td>
					</c:forEach>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</div>
<script>
function submitForm() {
	$("#${id}_form").submit();
}
function init_tr() {
	var showAll = ${table.showAll};
	if (false == showAll) {
		$("tr[name='flagCount_0']").addClass("hidden");
	}
}
$(function () {
	$("input[name='showAll']").change(function(){
		submitForm();  
	});
	$("input[name='companyIds']").change(function(){
		submitForm();
	});
	init_tr();
});
</script>