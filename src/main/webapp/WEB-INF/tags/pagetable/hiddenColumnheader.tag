<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列头"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${columnheader}">
  	
	<th class="sorting_disabled" tabindex="0" aria-controls="sample-table-2" rowspan="1" colspan="1" aria-label="" style="display:none;">
		<jsp:doBody />
	</th>
</c:if>