<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>

<spring:message code="menu.dashboard" var="i18n_dashboard"/>
<spring:message code="menu.dashboard.calendar" var="i18n_dashboardCalendar"/>
<spring:message code="calendar.dateList" var="i18n_calendarDateList"/>
<spring:message code="common.add" var="i18n_commonAdd"/>
<spring:message code="common.message" var="i18n_commonMessage"/>

<jvnav:pagetitle>
	日程展示 <span id="personName"></span>
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_dashboard}" url="/admin" />
	<jvnav:breadcrumbitem title="日程展示" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
		<div class="metro-nav">
               <div class="metro-nav-block  nav-block-blue">
                   <a href="<c:url value='/admin/profile/allcalendar/write'/>" data-original-title="">
                       <div class="text-center">
                           <i class="icon-plus"></i>
                       </div>
                       <div class="status">${i18n_commonAdd}</div>
                   </a>
               </div>
               
           </div>
           <div class="space10"></div>
           <!--END METRO STATES-->
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<c:if test="${not empty message}">
		<div class="alert alert-danger">
			<strong>
				<i class="ace-icon fa fa-info"></i>
				${i18n_commonMessage}
			</strong>
			<br />
			${message}
		</div>
		
	</c:if>
	<div class="span4">
		
			
			<c:forEach var="department"   items="${departmentList}"   varStatus="status">
				<jvpanel:panel color="green" title="${department.name}" icon="icon-person">
				<div class="space10"></div>
				<input type="hidden" id="currentPersonId" value="" />
				<c:forEach var="person" items="${department.personList}">
					<a href="javascript:showEvent(${person.id}, '${person.name}');" class="btn btn-info" id="add-regular">${person.name}</a>
				</c:forEach>
				
				</jvpanel:panel>		
			</c:forEach>
		
	</div>
	
	<div class="span8 responsive" data-tablet="span8 fix-margin"
		data-desktop="span8">
		<!-- BEGIN CALENDAR PORTLET-->
		<jvpanel:panel color="yellow" title="${i18n_calendarDateList}" icon="icon-calendar">
			<div id="calendar" class="has-toolbar"></div>
		</jvpanel:panel>
		<!-- END CALENDAR PORTLET-->
	</div>
</jvlayout:row>
<!-- /row -->

<!-- /.page-content -->

<script type="text/javascript">

	function showEvent(personId, personName){ 
		$('#currentPersonId').val(personId);
		//alert($('#currentPersonId').val());
		$("#personName").text(personName);
		$('#calendar').fullCalendar('refetchEvents');
	} 
	jQuery(function($) {
		
		var calendar = $('#calendar')
				.fullCalendar(
						{
							monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
									'七月', '八月', '九月', '十月', '十一月', '十二月' ],
							monthNamesShort : [ '一月', '二月', '三月', '四月', '五月',
									'六月', '七月', '八月', '九月', '十月', '十一月', '十二月' ],
							dayNames : [ '星期日', '星期一', '星期二', '星期三', '星期四',
									'星期五', '星期六' ],
							dayNamesShort : [ '周日', '周一', '周二', '周三', '周四',
									'周五', '周六' ],
							buttonText : {
								prev : '<i class="icon-chevron-left"></i>',
								next : '<i class="icon-chevron-right"></i>',
								today : '返回今天',
								month : '月',
								week : '周',
								day : '日'
							},

							header : {
								left : 'prev,next today',
								center : 'title',
								right : 'month,agendaWeek,agendaDay'
							},

							timeFormat : {
								'' : 'HH:mm'
							},

							editable : false,
							droppable : false, // this allows things to be dropped onto the calendar !!!
							selectable : true,
							selectHelper : true,
							events : function(start, end, callback) {

								var pData = [];

								pData.push({
									"name" : "start",
									"value" : start
								});
								pData.push({
									"name" : "end",
									"value" : end
								});
								
								pData.push({
									"name" : "person",
									"value" : $('#currentPersonId').val()
								});
								

								$.ajax({
									"type" : "POST",
									"contentType" : "application/json",
									"url" : "<c:url value='/admin/profile/allcalendar'/>",
									"dataType" : "json",
									"data" : JSON.stringify(pData), //以json格式传递
									"success" : function(data) {
										
										//给日历增加事件
										var events = [];
										var info = eval(data);
										for ( var i = 0; i < info.length; i++) {
											var ev = info[i];
											events.push({
												id : ev.id,
												title : ev.title,
												start : new Date(ev.start),
												startStr : ev.startStr,
												end : new Date(ev.end),
												endStr : ev.endStr,
												allDay : ev.allDay,
												color : ev.color,
												content : ev.content
											});
										}
										callback(events);

									}
								});
							},
							eventClick : function(calEvent, jsEvent, view) {
								var form = $("<label><strong>日程标题： &nbsp;</strong></label>");
								form.append("<label>" + calEvent.title
										+ "</label><br>");
								form
										.append("<label><strong>开始时间： &nbsp;</strong></label><label>"
												+ calEvent.startStr
												+ "</label><br>");
								if (calEvent.end != null) {
									form
											.append("<label><strong>结束时间： &nbsp;</strong></label><label>"
													+ calEvent.endStr
													+ "</label><br>");
								}

								if (calEvent.allDay) {
									form
											.append("<label>是否全天： &nbsp;</label><label>是</label><br>");
								} else {
									form
											.append("<label>是否全天： &nbsp;</label><label>否</label><br>");
								}

								form.append("<label>内容： &nbsp;</label><label>"
										+ calEvent.content + "</label><br>");

								var div = bootbox
										.dialog({
											message : form,
											buttons : {
												"edit" : {
													"label" : "<i class='icon-pencil'></i> 修改日程",
													"className" : "btn-sm btn-info",
													"callback" : function() {
														var urls = "<c:url value='/admin/profile/allcalendar/edit/" +calEvent.id+"'/>";
														location.href = urls;
													}
												},
												"delete" : {
													"label" : "<i class='icon-trash'></i> 删除日程",
													"className" : "btn-sm btn-danger",
													"callback" : function() {
														$
																.ajax({
																	"type" : "POST",
																	"url" : "<c:url value='/admin/profile/allcalendar/delete/"+calEvent.id+"'/>",
																	"success" : function() {
																		calendar
																				.fullCalendar(
																						'removeEvents',
																						function(
																								ev) {
																							return (ev._id == calEvent._id);
																						});
																	},
																	"error" : function() {
																		alert(arguments[1]);
																	}
																});
													}
												},
												"close" : {
													"label" : "<i class='icon-remove'></i> 关闭",
													"className" : "btn-sm"
												}
											}

										});

							}

						});
		
		
		
	})
</script>