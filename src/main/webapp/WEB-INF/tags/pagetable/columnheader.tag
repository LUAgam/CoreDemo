<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列头"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="id" required="false" type="java.lang.String" description="列ID 列ID_ENTITYID 为所选值"%>
<%@ attribute name="style" required="false" type="java.lang.String" description="该隐藏列保存的值"%>

<c:if test="${columnheader}">
	<c:if test="${id != null && id !=''}">
		<input  name="HEADER_${id}" type="hidden" value="<jsp:doBody />"/>
	</c:if>
  	
	<th style="${style}" class="sorting_disabled" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="">
		<jsp:doBody />
	</th>
</c:if>