<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:if test="${toolbarButton}">	
	<input id="EXPORT" name="EXPORT" type="hidden" value="0"/>
	<a class="btn btn-primary" onclick="${htmlTableId}_export();">
		<i class="icon-table bigger-110"></i>
		<span class="bigger-110 no-text-shadow">导出</span>
	</a>
</c:if>
