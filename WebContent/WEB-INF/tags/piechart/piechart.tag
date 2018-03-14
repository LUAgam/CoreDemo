<%@ tag language="java" pageEncoding="UTF-8" description="饼图"  %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="widget-box">
	<div class="widget-header widget-header-flat widget-header-small">
		<h5>
			<i class="icon-signal"></i>
			Traffic Sources
		</h5>

		<div class="widget-toolbar no-border">
			<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
				This Week
				<i class="icon-angle-down icon-on-right bigger-110"></i>
			</button>

			<ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
				<li class="active">
					<a href="index.html#" class="blue">
						<i class="icon-caret-right bigger-110">&nbsp;</i>
						This Week
					</a>
				</li>

				<li>
					<a href="index.html#">
						<i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
						Last Week
					</a>
				</li>

				<li>
					<a href="index.html#">
						<i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
						This Month
					</a>
				</li>

				<li>
					<a href="index.html#">
						<i class="icon-caret-right bigger-110 invisible">&nbsp;</i>
						Last Month
					</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="widget-body">
		<div class="widget-main">
			<div id="piechart-placeholder"></div>

			<div class="hr hr8 hr-double"></div>

			<div class="clearfix">
				<div class="grid3">
					<span class="grey">
						<i class="icon-facebook-sign icon-2x blue"></i>
						&nbsp; likes
					</span>
					<h4 class="bigger pull-right">1,255</h4>
				</div>

				<div class="grid3">
					<span class="grey">
						<i class="icon-twitter-sign icon-2x purple"></i>
						&nbsp; tweets
					</span>
					<h4 class="bigger pull-right">941</h4>
				</div>

				<div class="grid3">
					<span class="grey">
						<i class="icon-pinterest-sign icon-2x red"></i>
						&nbsp; pins
					</span>
					<h4 class="bigger pull-right">1,050</h4>
				</div>
			</div>
		</div><!-- /widget-main -->
	</div><!-- /widget-body -->
</div><!-- /widget-box -->

<script type="text/javascript">
jQuery(function($) {
	var placeholder = $('#${pageScope.id}').css({'width':'90%' , 'min-height':'150px'});
	var data = [
		{ label: "social networks",  data: 38.7, color: "#68BC31"},
		{ label: "search engines",  data: 24.5, color: "#2091CF"},
		{ label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
		{ label: "direct traffic",  data: 5.6, color: "#DA5430"},
		{ label: "other",  data: 10, color: "#FEE074"}
	]
	function drawPieChart(placeholder, data, position) {
		$.plot(placeholder, data, {
			series: {
				pie: {
					show: true,
					tilt:0.8,
					highlight: {
						opacity: 0.25
					},
					stroke: {
						color: '#fff',
						width: 2
					},
					startAngle: 2
				}
			},
			legend: {
				show: true,
				position: position || "ne", 
				labelBoxBorderColor: null,
				margin:[-30,15]
			},
			grid: {
				hoverable: true,
				clickable: true
			}
		})
	}
	drawPieChart(placeholder, data);
	
	 /**
	 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
	 so that's not needed actually.
	 */
	placeholder.data('chart', data);
	placeholder.data('draw', drawPieChart);
	
	var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
	var previousPoint = null;
	
	placeholder.on('plothover', function (event, pos, item) {
		if(item) {
			if (previousPoint != item.seriesIndex) {
				previousPoint = item.seriesIndex;
				var tip = item.series['label'] + " : " + item.series['percent']+'%';
				$tooltip.show().children(0).text(tip);
			}
			$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
		} else {
			$tooltip.hide();
			previousPoint = null;
		}
	 });
})
</script>