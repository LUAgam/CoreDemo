<%--

 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="表格列头"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ attribute name="check" required="false" type="java.lang.Boolean" description="选择框"%>
<%@ attribute name="checked" required="false" type="java.lang.Boolean" description="是否选中,checked"%>

<c:set var="check" value="${empty check ? true : check}" />
<c:set var="checked" value="${checked ==true? true: false}" />
<c:if test="${column}">

	<c:if test="${check}">
		<td class="center"><label class="position-relative"> <c:choose>
					<c:when test="${checked }">
						<input id="${htmlTableId}_rowcheck" name="${htmlTableId}_rowcheck" type="checkbox" class="ace" value="${entity.id}" checked="checked" />
						<span class="lbl"></span>
					</c:when>
					<c:otherwise>
						<input id="${htmlTableId}_rowcheck" name="${htmlTableId}_rowcheck" type="checkbox" class="ace" value="${entity.id}" />
						<span class="lbl"></span>
					</c:otherwise>
				</c:choose>
		</label></td>
	</c:if>
	<td class="center" id="xuhaoID" style="text-align: center;">${page.size + currentrow}</td>
</c:if>



<c:if test="${optioncolumnScript}">
	<script type="text/javascript">
		jQuery(function($) {
			$('table th input:checkbox').on(
					'click',
					function() {
						var that = this;
						$(this).closest('table').find(
								'tr > td:first-child input:checkbox').each(
								function() {
									this.checked = that.checked;
									$(this).closest('tr').toggleClass(
											'selected');
								});

					});

		});
	</script>
</c:if>