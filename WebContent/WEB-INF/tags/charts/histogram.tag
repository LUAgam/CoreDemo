<%--
 (c) 2015 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="柱状图"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="标识"%>
<%@ attribute name="width" required="false" type="java.lang.Long" description="宽度" %>
<%@ attribute name="height" required="false" type="java.lang.Long" description="高度" %>
<%@ attribute name="histogram" required="true" type="com.joven.jvcore.web.charts.formbean.Histogram" description="" %>

<c:set var="width" value="${empty width ? 350 : width}" />
<c:set var="height" value="${empty height ? 350 : height}" />

<div id="${id}" style="min-width: ${width}px; height: ${height}px"></div>

<script>
$(function () {
	 $('#${id}').highcharts({                                          
	        chart: {                                                          
	        },                                                                
	        title: {                                                          
	            text: '${histogram.name}'                                     
	        },                                                                
	        xAxis: {                                                          
	            //categories: ['云南分公司', '北京分公司', '四川分公司', '安徽分公司', '山东分公司','山西分公司','江西分公司','浙江分公司','甘肃分公司','西北分公司']
	        	categories:[
					<c:forEach var="item" items="${histogram.items}" varStatus="vs">
					'${item.name}'  
						<c:if test="${vs.end != true}">
						,
						</c:if> 
					</c:forEach >
	        	    ]
	        
	        },                                                                
	        tooltip: {                                                        
	            formatter: function() {                                       
	                var s;                                                    
	                if (this.point.name) { // the pie chart                   
	                    s = ''+                                               
	                        this.point.name +': '+ this.y +' fruits';         
	                } else {                                                  
	                    s = ''+                                               
	                        this.x  +': '+ this.y;                            
	                }                                                         
	                return s;                                                 
	            }                                                             
	        },                                                                
	        labels: {                                                         
	            items: [{                                                     
	                html: '',                          
	                style: {                                                  
	                    left: '40px',                                         
	                    top: '8px',                                           
	                    color: 'black'                                        
	                }                                                         
	            }]                                                            
	        },                                                                
	        series: [{                                                        
	            type: 'column',                                               
	            name: '${histogram.histogramTitle}',                                                 
	            //data: [0.48,1.18, 6.16, 3.08, 0.53,7.07,0.95,0.52,4.61,7.36]
	            data: [
					<c:forEach var="item" items="${histogram.items}" varStatus="vs">
						${item.value}
						<c:if test="${vs.end != true}">
						,
						</c:if> 
					</c:forEach >
	                   ]
	        },  {                                                              
	            type: 'spline',                                               
	            name: '平均线',                                              
	            //data: [3.19, 3.19, 3.19, 3.19, 3.19, 3.19, 3.19, 3.19, 3.19, 3.19],                               
	            data: [
					<c:forEach var="item" items="${histogram.items}" varStatus="vs">
						${histogram.avg}
						<c:if test="${vs.end != true}">
						,
						</c:if> 
					</c:forEach >
	                   ],                               
	            color:Highcharts.getOptions().colors[5],
	            marker: {                                                     
	            	lineWidth: 2,                                               
	            	lineColor: Highcharts.getOptions().colors[3],               
	            	fillColor: 'white'  
	            }
	        }]                                                                
	    });
}); 	 

	
</script>