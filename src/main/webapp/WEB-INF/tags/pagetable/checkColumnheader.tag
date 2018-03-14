<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列头"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="check" required="false" type="java.lang.Boolean" description="选择框"%>


<c:set var="check" value="${empty check ? true : check}" />

<c:if test="${columnheader}">

<c:if test="${check}">
<th style="width:13px;" class="center sorting_disabled" rowspan="1" colspan="1" role="columnheader" aria-label="">
	<label class="position-relative"> 
		<input type="checkbox" class="group-checkable"/> <span class="lbl"></span> 
	</label>
</th>
</c:if>
<th style="width:50px;text-align:center;" tabindex="0" aria-controls="sample-table-2" aria-label="">
	序号
</th>
</c:if>