<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列头"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="操作项标题"%>
<%@ attribute name="style" required="true" type="java.lang.String" description="操作项图标"%>
<%@ attribute name="url" required="true" type="java.lang.String" description="操作项url"%>
<%@ attribute name="alertFlag" required="false" type="java.lang.Boolean" description="是否显示弹出框"%>
<c:if test="${alertFlag != null && alertFlag}">
<button onclick="deleteA('${url}')" class="${style}" type="button">
	${title}
</button>
</c:if>
<c:if test="${alertFlag == null || !alertFlag}">
<button onclick="other('${url}')" class="${style}" type="button">
	${title}
</button>
</c:if>

<script type="text/javascript">
function deleteA(q) {
	if(confirm("确定要删除吗？"))
    {
		 window.location.href = q;
    }
}
function other(q) {
	window.location.href = q;
}
</script>