<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
				
			<jvpagetable:table htmlTableId="candidateTodoTaskTable" page="${candidateTodoTaskPage}" url="/dialog/task/candidate/list">

				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>

				<!--String 控件-->
				<jvpagetable:columnheader style="width:400px;">待办描述</jvpagetable:columnheader>
				<jvpagetable:column id="activeTaskName" >${entity.activeTaskName}</jvpagetable:column>
				
				<jvpagetable:columnheader>创建时间</jvpagetable:columnheader>
				<jvpagetable:column id="createTime"><fmt:formatDate var="dt" value="${entity.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
													${dt}</jvpagetable:column>
			
				<jvpagetable:columnheader>操作</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
					<button onclick="other('${ctx}/admin/profile/task/claim/${entity.taskId}')" class="btn btn-small btn-info" type="button">
						签收
					</button>
					
					<script type="text/javascript">
					function other(q) {
						if(confirm("确定要签收该条待办任务吗？"))
					    {
							window.parent.location.href = q;
					    }
					}
					</script>
					
				</jvpagetable:OptionColumn>
				

			</jvpagetable:table>