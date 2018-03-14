<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>


<jvnav:pagetitle>
	网格布局
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="首页" url="/admin"></jvnav:breadcrumbitem>
	<jvnav:breadcrumbitem title="示例" url="/examples"></jvnav:breadcrumbitem>
	<jvnav:breadcrumbitem title="网格" active="true"></jvnav:breadcrumbitem>
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
  		<jvpanel:panel color="red" title="Grid 12"><code> class="span12" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="10">
  		<jvpanel:panel color="blue" title="Grid 10"><code> class="span10" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="2">
  		<jvpanel:panel color="green" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="10">
  		<jvpanel:panel color="blue" title="Grid 10"><code> class="span10" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="2">
  		<jvpanel:panel color="green" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="8">
  		<jvpanel:panel color="purple" title="Grid 8"><code> class="span8" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="4">
  		<jvpanel:panel color="green" title="Grid 4"><code> class="span4" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="6">
  		<jvpanel:panel color="orange" title="Grid 6"><code> class="span6" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="6">
  		<jvpanel:panel color="" title="Grid 6"><code> class="span6" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="4">
  		<jvpanel:panel color="green" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="4">
  		<jvpanel:panel color="red" title="Grid 4"><code> class="span4" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="4">
  		<jvpanel:panel color="yellow" title="Grid 4"><code> class="span4" </code></jvpanel:panel>
	</jvlayout:col>
	
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="2">
  		<jvpanel:panel color="purple" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="2">
  		<jvpanel:panel color="blue" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="2">
  		<jvpanel:panel color="" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="2">
  		<jvpanel:panel color="blue" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="2">
  		<jvpanel:panel color="purple" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
	
	<jvlayout:col length="2">
  		<jvpanel:panel color="" title="Grid 2"><code> class="span2" </code></jvpanel:panel>
	</jvlayout:col>
	
</jvlayout:row>
	
<jvlayout:row>
	<jvlayout:col length="10" offset="2">
  		<jvpanel:panel color="orange" title="Grid 10 offset2"><code> class="span10 offset2" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="8" offset="4">
  		<jvpanel:panel color="green" title="Grid 8 offset4"><code> class="span8 offset4" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="6" offset="6">
  		<jvpanel:panel color="red" title="Grid 6 offset6"><code> class="span6 offset6" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="4" offset="8">
  		<jvpanel:panel color="blue" title="Grid 4 offset8"><code> class="span4 offset8" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>
        
<jvlayout:row>
	<jvlayout:col length="2" offset="10">
  		<jvpanel:panel color="" title="Grid 2 offset10"><code> class="span2 offset10" </code></jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>