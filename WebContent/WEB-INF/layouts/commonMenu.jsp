<%--

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="taglibs.jsp"%>
<%--shiro --%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<!-- BEGIN SIDEBAR -->
<div class="sidebar-scroll">
	<div id="sidebar" class="nav-collapse collapse">
		<!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
		<!-- END RESPONSIVE QUICK SEARCH FORM -->
		<!-- BEGIN SIDEBAR MENU -->
		<ul class="sidebar-menu">
			<c:forEach var="menu" items="${allMenu }">
				<li class="${menu.displayName==currentMenuParent?'sub-menu active': 'sub-menu'}"><a href="#" title="${menu.displayName}"> <i class="${menu.icon}"></i> <span><b> ${menu.displayName} </b></span>
				</a>
					<ul class="sub">
						<c:forEach var="childrenItem" items="${menu.children}" varStatus="substatus">
							<li class="${childrenItem.displayName==currentMenuItem?'active':''}"><a href="<c:url value='/menu/${childrenItem.id}'/>"> ${childrenItem.displayName} </a></li>
						</c:forEach>
					</ul></li>
			</c:forEach>
		</ul>
		<!-- END SIDEBAR MENU -->
	</div>
</div>
<!-- END SIDEBAR -->