<%--
 (c) 2015 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="饼图"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="标识"%>
<%@ attribute name="width" required="false" type="java.lang.Long" description="宽度" %>
<%@ attribute name="height" required="false" type="java.lang.Long" description="高度" %>
<%@ attribute name="pie" required="true" type="com.joven.jvcore.web.chart.formbeans.Piebar" description="" %>

<c:set var="width" value="${empty width ? 350 : width}" />
<c:set var="height" value="${empty height ? 350 : height}" />

<div id="${id}" style="min-width: ${width}px; height: ${height}px"></div>

<script>
 $(function () {
	 $('#${id}').highcharts({
	     chart: {
	         plotBackgroundColor: null,
	         plotBorderWidth: null,
	         plotShadow: false
	     },
	     title: {
	         text: '${pie.name}'
	     },
	     tooltip: {
	 	    pointFormat: '{series.name}: <b>{point.percentage:.${pie.formMat}f}%</b>'
	     },
	      plotOptions: {
	         pie: {
	             allowPointSelect: true,
	             cursor: 'pointer',
	             dataLabels: {
	                 enabled: true,
	                 color: '#000000',
	                 connectorColor: '#000000',
	                 format: '<b>{point.name}</b>: {point.percentage:.${pie.formMat}f} %'
	             },
	             showInLegend: true
	         }
	     }, 
	     series: [{
	         type: 'pie',
	         name: '所占比例',
	         data:[
					<c:forEach var="item" items="${pie.items}" varStatus="vs">
						['${item.name}',${item.value}]  
						<c:if test="${vs.end != true}">
				       	,
				       	</c:if> 
					</c:forEach >
	               ]
	        /*  data: [
	             ['本部',10.9],
	             ['保障部',14.5],
	             ['山东分公司',7.3],
	              ['安徽分公司',12.7],
	              ['江西分公司',15.0],
	              ['河北分公司',5.9],
	              ['山西分公司',8.8],
	              ['宁波分公司',6.5],
	              ['云南分公司',9.1],
	             ['西北分公司',9.3]
	         ] */
	     }]
	 });
});
 	 
 
 
 </script>