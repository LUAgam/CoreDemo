<%--
 (c) 2015 JOVEN
 
 http://www.joven.com.cn
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="计量器"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ attribute name="id" required="true" type="java.lang.String" description="标识"%>
<%-- <%@ attribute name="title" required="true" type="java.lang.String"	description="计量器总标题"%>
<%@ attribute name="title_indoor" required="false" type="java.lang.String" description="计量器表盘标题" %>
<%@ attribute name="title_series" required="true" type="java.lang.String" description="计量器指针标题" %>
<%@ attribute name="title_series_unit" required="false" type="java.lang.String" description="计量器指针标题_数据单位" %>
 --%>
<%@ attribute name="width" required="false" type="java.lang.Long" description="宽度" %>
<%@ attribute name="height" required="false" type="java.lang.Long" description="高度" %>
<%-- <%@ attribute name="plotBands_min" required="true" type="java.lang.Double" description="计量器表盘最小值" %>
<%@ attribute name="plotBands_min1" required="true" type="java.lang.Double" description="计量器表盘最小值1" %>
<%@ attribute name="plotBands_min2" required="true" type="java.lang.Double" description="计量器表盘最小值2" %>
<%@ attribute name="plotBands_max2" required="true" type="java.lang.Double" description="计量器表盘最大值2" %>
<%@ attribute name="plotBands_max1" required="true" type="java.lang.Double" description="计量器表盘最大值1" %>
<%@ attribute name="plotBands_max" required="true" type="java.lang.Double" description="计量器表盘最大值" %>
<%@ attribute name="value" required="true" type="java.lang.Double" description="计量器指针的值" %> --%>
<%@ attribute name="gauge" required="true" type="com.joven.jvcore.web.charts.formbean.Gauge" description="计量器对象" %>
<%-- <c:set var="title" value="${empty title ? '' : title}" />
<c:set var="title_series" value="${empty title_series ? '' : title_series}" /> --%>
<c:set var="width" value="${empty width ? 350 : width}" />
<c:set var="height" value="${empty height ? 350 : height}" />

<div id="${id}" style="min-width: ${width}px; height: ${height}px"></div>

<script>
$(function() {
	var ${id}_colorArrays=new Array();
	${id}_colorArrays[0]={from:${gauge.plotBandsMin1},to:${gauge.plotBandsMin2},color:"#DF5353"};
	${id}_colorArrays[1]={from:${gauge.plotBandsMin2},to:${gauge.plotBandsMin3},color:"#DDDF0D"};
	${id}_colorArrays[2]={from:${gauge.plotBandsMin3},to:${gauge.plotBandsMax3},color:"#55BF3B"};
	${id}_colorArrays[4]={from:${gauge.plotBandsMax3},to:${gauge.plotBandsMax2},color:"#DDDF0D"};
	${id}_colorArrays[5]={from:${gauge.plotBandsMax2},to:${gauge.plotBandsMax1},color:"#DF5353"};
	//var colorArrays2 = ${plotBands_array};
	//alert(${plotBands_array}.length);
	//alert(colorArrays2.length);
	
	$('#${id}').highcharts({
	    chart: {
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    
	    title: {
	        text: '${gauge.name}'
	    },
	    
	    pane: {
	        startAngle: -150,
	        endAngle: 150,
	        background: [{
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#FFF'],
	                    [1, '#333']
	                ]
	            },
	            borderWidth: 0,
	            outerRadius: '109%'
	        }, {
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#333'],
	                    [1, '#FFF']
	                ]
	            },
	            borderWidth: 1,
	            outerRadius: '107%'
	        }, {
	            // default background
	        }, {
	            backgroundColor: '#DDD',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
	       
	    // the value axis
	    yAxis: {
	        min: ${gauge.plotBandsMin1},
	        max: ${gauge.plotBandsMax1},
	        
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 10,
	        tickColor: '#666',
	        labels: {
	            step: 2,
	            rotation: 'auto'
	        },
	        title: {
	            text: '${gauge.titleIndoor}'
	        },
	        plotBands:${id}_colorArrays
	        //plotBands:${plotBands_array}
	        /* plotBands: [{
	            from: 0,
	            to: 3.05,
	            color: '#DF5353' // green
	        }, {
	            from: 3.05,
	            to: 3.48,
	            color: '#DDDF0D' // red
	        }, {
	            from: 3.48,
	            to: 5.22,
	            color: '#55BF3B' // yellow
	        },{
	            from: 5.22,
	            to: 5.66,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 5.66,
	            to: 8.71,
	            color: '#DF5353' // red
	        }] */        
	    },
	
	    series: [{
	        name: '${gauge.series}',
	        data: [${gauge.value}],
	        tooltip: {
	            valueSuffix: ' ${gauge.seriesUnit}'
	        }
	    }]
	
	}
	/* , 
	// Add some life
	function (chart) {
		if (!chart.renderer.forExport) {
		    setInterval(function () {
		        var point = chart.series[0].points[0],
		            newVal,
		           // inc = Math.round((Math.random() - 0.5) * 20);
		        	inc = 4.35;
		        //newVal = point.y + inc;
		        newVal = inc;
		        if (newVal < 0 || newVal > 200) {
		           // newVal = point.y - inc;
		           newVal = inc;
		        }
		        
		        point.update(newVal);
		        
		    }, 3000);
		}
	} */
	);
});
</script>