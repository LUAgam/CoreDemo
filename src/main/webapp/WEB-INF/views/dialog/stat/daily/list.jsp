<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="../../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="stat.common.number" var="i18N_scNumber"/>
<spring:message code="stat.daily.missionName" var="i18N_sdMissionName"/>
<spring:message code="stat.common.line" var="i18N_scLine"/>
<spring:message code="stat.common.department" var="i18N_scDepartment"/>
<spring:message code="stat.reportClass.type" var="i18N_srType"/>
<spring:message code="stat.daily.report.person" var="i18N_sdrPerson"/>
<spring:message code="stat.daily.report.person.actually" var="i18N_sdrpActually"/>
<spring:message code="stat.daily.report.time" var="i18N_sdrTime"/>
<spring:message code="stat.daily.report.process" var="i18N_sdrProcess"/>
<spring:message code="stat.daily.report.isLate" var="i18N_sdrIsLate"/>
<spring:message code="stat.daily.report.change" var="i18N_sdrChange"/>
<spring:message code="stat.daily.statu" var="i18N_sdStatu"/>
<spring:message code="common.operate" var="i18N_cOperate"/>
<spring:message code="common.delete" var="i18N_cDelete"/>
<spring:message code="stat.daily.report.upload" var="i18N_sdrUpload"/>
<spring:message code="stat.daily.report.shang" var="i18N_sdrShang"/>
<spring:message code="stat.daily.log" var="i18N_sdLog"/>
<spring:message code="stat.daily.returnback" var="i18N_sdReturnback"/>
<spring:message code="stat.common.approve" var="i18N_scApprove"/>
<spring:message code="stat.daily.report.generate" var="i18N_sdrGenerate"/>
<spring:message code="stat.daily.report.moudleName" var="i18N_sdrMoudleName"/>
<spring:message code="stat.daily.report.baoTime" var="i18N_sdrBaoTime"/>
<spring:message code="stat.daily.write" var="i18N_sdWrite"/>

<jvlayout:row>
	<jvlayout:col length="12">
			<jvpagetable:table url="/dialog/daily/list/${mOrDay}/${flag}" page="${dailyList}" htmlTableId="dailyListATable">
				<shiro:hasPermission name="DAILY_CREATE">
					<jvpagetable:toolbarButton color="btn-success" isParent="true" url="${ctx}/daily/createDaily" icon="icon-plus" title="${i18N_sdrGenerate}"></jvpagetable:toolbarButton>
				</shiro:hasPermission>
				
				<jvpagetable:searchTextItem id="dailyListTable_search_no" title="${i18N_scNumber}" key="no" 
					operat="LIKE" placeholder="" value="${SEARCH_no}"></jvpagetable:searchTextItem>
				
<%-- 				<jvpagetable:searchTextItem operat="LIKE" key="work.dept.name" value="${SEARCH_work_dept_name}" title="${i18N_scDepartment}" id="dept"></jvpagetable:searchTextItem>
 --%>				<jvpagetable:searchTextItem operat="LIKE" key="work.reportClass.description" value="${SEARCH_work_reportClass_description}" title="${i18N_sdrMoudleName}" id="workName"></jvpagetable:searchTextItem>
				<jvpagetable:searchTextItem operat="LIKE" key="work.name" value="${SEARCH_work_name}" title="${i18N_sdMissionName}" id="workName"></jvpagetable:searchTextItem>
				<jvpagetable:searchSelectEntity options="${lineList}" key="work.line.id" title="${i18N_scLine}" id="line" idField="id" nameField="lineName" value="${SEARCH_work_line_id}"></jvpagetable:searchSelectEntity>
				<jvpagetable:checkColumnheader></jvpagetable:checkColumnheader>
				<jvpagetable:checkColumn></jvpagetable:checkColumn>
				
				<jvpagetable:columnheader>${i18N_scNumber}</jvpagetable:columnheader>
				<jvpagetable:column id="no">
				<a href="${ctx}/daily/lookOne/${entity.id}" target="_parent">${entity.no}</a>
				</jvpagetable:column>
				
				<jvpagetable:columnheader>${mOrDay eq 1 ? '日' : '月'}${i18N_sdrBaoTime}</jvpagetable:columnheader>
				<jvpagetable:column id="createDate">
				<fmt:formatDate value="${entity.createDate}" pattern="yyyy-MM-dd"/>
				</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdrMoudleName}</jvpagetable:columnheader>
				<jvpagetable:column id="description">${entity.work.reportClass.description}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdMissionName}</jvpagetable:columnheader>
				<jvpagetable:column id="name">${entity.work.name}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_srType}</jvpagetable:columnheader>
				<jvpagetable:column id="typeStr">${entity.work.reportClass.typeStr}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_scLine}</jvpagetable:columnheader>
				<jvpagetable:column id="line">${entity.work.line.lineName}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_scDepartment}</jvpagetable:columnheader>
				<jvpagetable:column id="dept">${entity.work.dept.name}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdrPerson}</jvpagetable:columnheader>
				<jvpagetable:column id="fillUser">${entity.fillUser.person.name}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdrpActually}</jvpagetable:columnheader>
				<jvpagetable:column id="factFill">${entity.factFill}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdrTime}</jvpagetable:columnheader>
				<jvpagetable:column id="fillDate">
				<fmt:formatDate value="${entity.fillDate}" pattern="yyyy-MM-dd HH:mm"/>
				</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdrProcess}</jvpagetable:columnheader>
				<jvpagetable:column id="rate">${entity.rate}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdrIsLate}</jvpagetable:columnheader>
				<jvpagetable:column id="late">
					<input type="checkbox" value="${entity.late}" ${entity.late eq true ? 'checked' : ''}/>
				</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdrChange}</jvpagetable:columnheader>
				<jvpagetable:column id="revise">
					<input type="checkbox" value="${entity.revise}" ${entity.revise eq true ? 'checked' : ''}/>
				</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_sdStatu}</jvpagetable:columnheader>
				<jvpagetable:column id="status">${entity.status}</jvpagetable:column>
				
				<jvpagetable:columnheader>${i18N_cOperate}</jvpagetable:columnheader>
				<jvpagetable:OptionColumn>
				<shiro:hasPermission name="DELETE_DAILY">
					<A class="btn btn-small btn-danger" href="${ctx}/daily/delete/${entity.id}" target="_parent">${i18N_cDelete}</A>
				</shiro:hasPermission>	
				<shiro:hasPermission name="FILL_DAILY">
					<A class="btn btn-small btn-warning" href="${ctx}/daily/toFill/${entity.id}" target="_parent">${i18N_sdWrite}</A>
				</shiro:hasPermission>
				<c:if test="${user.id != entity.fillUser.id && entity.status == '待审核'}">
					<A class="btn btn-small btn-warning" href="${ctx}/daily/toApp/${entity.id}" target="_parent">审批</A>
				</c:if>
				<c:if test="${user.id == entity.fillUser.id}">
				<shiro:hasPermission name="REPORT_DAILY">
				<A class="btn btn-small btn-success" href="${ctx}/daily/report/${entity.id}" target="_parent">${i18N_sdrShang}</A>
				</shiro:hasPermission>					
				</c:if>
				<shiro:hasPermission name="CHANGE_NOTE">
					<A class="btn btn-small btn-primary" href="${ctx}/daily/note/${entity.id}" target="_parent">${i18N_sdLog}</A>
				</shiro:hasPermission>	
				<shiro:hasPermission name="ROLE_INDEX_APPROVAL">
					<%-- <A class="btn btn-small btn-primary" href="${ctx}/daily/toApp/${entity.id}" target="_parent">${i18N_scApprove}</A> --%>
					<A class="btn btn-small btn-primary" href="${ctx}/daily/saveApp/${entity.id}/2" target="_parent">${i18N_sdReturnback}</A>
				</shiro:hasPermission>	
				</jvpagetable:OptionColumn>
			</jvpagetable:table> 
	</jvlayout:col>
</jvlayout:row>
<!-- /.page-content -->


