<%--
	图标、title、收缩、底色
 --%>
<%@ tag language="java" pageEncoding="UTF-8" description="panel"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="icon" required="false" type="java.lang.String" description="图标：icon-star orange;。。。" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="标题"%><!--  -->
<%@ attribute name="color" required="true" type="java.lang.String" description="背景色（red, blue, green, purple, yellow, orange）"%><!--  -->

<div class="widget ${color}">
	<div class="widget-title">
    	<h4><i class="${icon}"></i>${title}</h4>
          <span class="tools">
              <a href="javascript:;" class="icon-chevron-down"></a>
             <!--  <a href="javascript:;" class="icon-remove"></a> -->
          </span>
   	</div>
    <div class="widget-body">
        <jsp:doBody/>
    </div>
</div>
		

		