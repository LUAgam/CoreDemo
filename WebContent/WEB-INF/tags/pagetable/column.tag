<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="id" required="true" type="java.lang.String" description="列ID 列ID_ENTITYID 为所选值"%>


<c:if test="${column}">	
	<td id="${id}_${entity.id}" ><jsp:doBody /></td>
</c:if>

