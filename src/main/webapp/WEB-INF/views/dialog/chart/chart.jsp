<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../taglibs.jsp"%>
<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message" %>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvpagetable" tagdir="/WEB-INF/tags/pagetable"%>

<div id="container" style="min-width:700px;height:400px"></div>

<script type="text/javascript">

$(function () {
    $('#container').highcharts({
        chart: {
            type: 'column',
            margin: [ 50, 50, 100, 80]
        },
        title: {
            text: '故障统计'
        },
        xAxis: {
            categories: [
                'Tokyo',
                'Jakarta',
                'New York',
                'Seoul',
                'Manila',
                'Mumbai',
                'Sao Paulo',
                'Mexico City',
                'Dehli',
                'Osaka',
                'Cairo',
                'Kolkata',
                'Los Angeles',
                'Shanghai',
                'Moscow',
                'Beijing',
                'Buenos Aires',
                'Guangzhou',
                'Shenzhen',
                'Istanbul'
            ],
            labels: {
                rotation: -45,
                align: 'right',
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Population (millions)'
            }
        },
        legend: {
            enabled: false
        },
        tooltip: {
            pointFormat: 'Population in 2008: <b>{point.y:.1f} millions</b>',
        },
        series: [{
            name: 'Population',
            data: [34.4, 21.8, 20.1, 20, 19.6, 19.5, 19.1, 18.4, 18,
                17.3, 16.8, 15, 14.7, 14.5, 13.3, 12.8, 12.4, 11.8,
                11.7, 11.2],
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                x: 4,
                y: 10,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif',
                    textShadow: '0 0 3px black'
                }
            }
        }]
    });
});
				

</script>