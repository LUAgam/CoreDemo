<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../taglibs.jsp"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav" %>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel" %>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form" %>

<jvnav:pagetitle>
	表单布局
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="首页" url="/admin"></jvnav:breadcrumbitem>
	<jvnav:breadcrumbitem title="示例" url="/examples"></jvnav:breadcrumbitem>
	<jvnav:breadcrumbitem title="表格" active="true"></jvnav:breadcrumbitem>
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
  		<jvpanel:panel color="green" title="水平表单例子" icon="icon-editor">
  			<jvform:form id="exampleform1" action="/examples/form1" orient="horizontal">
					<jvform:textfield id="textfield-mini" size="input-mini" placeholder="mini" title="文本输入框:" tooltrip="最小" required="true" ></jvform:textfield>
					<jvform:textfield id="textfield-small" size="input-small" placeholder="small" title="文本输入框:" tooltrip="小" readonly="true"></jvform:textfield>
					<jvform:textfield id="textfield-medium" size="input-medium" placeholder="medium" title="文本输入框:" tooltrip="中"></jvform:textfield>
					<jvform:textfield id="textfield-large" size="input-large" placeholder="large" title="文本输入框:" tooltrip="大"></jvform:textfield>
					<jvform:textfield id="textfield-xlarge" size="input-xlarge" placeholder="xlarge" title="文本输入框:" tooltrip="特大"></jvform:textfield>
					<jvform:textfield id="textfield-xxlarge" size="input-xxlarge" placeholder="xxlarge" title="文本输入框:" tooltrip="超特大"></jvform:textfield>
					
					<jvform:password id="password-medium" size="input-medium" placeholder="medium" title="密码输入框:" tooltrip="中" required="true"></jvform:password>
					
					<jvform:textareafield id="textareafield-mini" size="input-mini" title="文本输入框:" tooltrip="最小" required="true" ></jvform:textareafield>
					<jvform:textareafield id="textareafield-small" size="input-small" title="文本输入框:" tooltrip="小" readonly="true"></jvform:textareafield>
					<jvform:textareafield id="textareafield-medium" size="input-medium" title="文本输入框:" tooltrip="中"></jvform:textareafield>
					<jvform:textareafield id="textareafield-large" size="input-large" title="文本输入框:" tooltrip="大"></jvform:textareafield>
					<jvform:textareafield id="textareafield-xlarge" size="input-xlarge" title="文本输入框:" tooltrip="特大"></jvform:textareafield>
					<jvform:textareafield id="textareafield-xxlarge" size="input-xxlarge" title="文本输入框:" tooltrip="超特大"></jvform:textareafield>
					
					
					<jvform:datetimefield id="datetimefield" title="日期时间输入框:"  readonly="true"></jvform:datetimefield>
					<jvform:datetimefield id="datetimefield1" title="日期时间输入框:"  required="true" size="input-xlarge" tooltrip="特大"></jvform:datetimefield>
					<jvform:datetimefield id="datetimefield2" title="日期时间输入框:"  required="false" size="input-large" tooltrip="大"></jvform:datetimefield>
					
					<jvform:datefield id="datefield" title="日期输入框:"></jvform:datefield>
					<jvform:datefield id="datefield1" title="日期输入框:"  required="true" size="input-xlarge" tooltrip="特大"></jvform:datefield>
					
					<jvform:entityselector id="personList1" height="798" width="1024" url="${ctx}/dialog/person/list" dialogtitle="选择人员" title="人员" tableId="personListTable" tableDisplayNameColumnName="name"/>
				
					<jvform:ueditor id="ueditor1" title="富文本编辑框大:"  required="false" rows="50" ></jvform:ueditor>
					<jvform:ueditor id="ueditor2" title="富文本编辑框小:"  required="true"  ></jvform:ueditor>
					
					<jvform:checkbox id="checkbox1" required="true" title="checkbox1:" value="false"></jvform:checkbox>
					<jvform:checkbox id="checkbox2" required="false" title="checkbox2:" value="true"  tooltrip="选择框"></jvform:checkbox>
					
					<!-- 颜色选择 -->
					<jvform:colorpicker id="colorpicker1" required="true" title="颜色选择:" tooltrip="选择颜色"  size="input-small" value="#3be810"></jvform:colorpicker>
					
					<!-- 文件上传 -->
					<jvform:fileupload id="fileupload" required="false" title="文件上传:"></jvform:fileupload>
					
					<!-- 数字 -->
					<jvform:number id="number1" required="true" title="保留小数2位" decimals="2" size="input-small"></jvform:number>
					<jvform:number id="number2" required="false" title="保留小数3位" decimals="3" ></jvform:number>
					<jvform:number id="number3" required="false" title="保留小数4位" decimals="4" size="input-large"></jvform:number>
					
					<!-- 选择框 -->
					<jvform:select id="select1" title="combox 1" options="${options1}" selectType="1" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
					
					<jvform:select id="select2" title="combox 2" options="${options1}" selectType="2" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
					
					<jvform:select id="select3" title="combox 3" options="${options1}" selectType="3" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
				
					<jvform:select id="select4" title="combox 4" options="${options1}" selectType="4" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
					
					<!-- radio框 -->
					<jvform:radio id="radio1" title="radio 1" options="${options1}" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:radio>
					
					<jvform:footbar>
						<jvform:submit/>
						&nbsp; &nbsp; &nbsp;
						<jvform:cancel/>
						&nbsp; &nbsp; &nbsp;
						<button id="openBtn" class="btn">dialog 测试</button>
					
					</jvform:footbar>
			</jvform:form>
  		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>

<jvlayout:row>
	<jvlayout:col length="12">
  		<jvpanel:panel color="red" title="垂直表单例子" icon="icon-editor">
  			<jvform:form id="exampleform2" action="/examples/form2" orient="vertical">
  				<jvlayout:row>
  					<jvlayout:col length="3">
						<jvform:textfield id="textfield-mini" size="input-mini" placeholder="mini" title="文本输入框:" tooltrip="最小" required="true" ></jvform:textfield>
					</jvlayout:col>
					<jvlayout:col length="3">
						<jvform:textfield id="textfield-small" size="input-small" placeholder="small" title="文本输入框:" tooltrip="小" readonly="true"></jvform:textfield>
					</jvlayout:col>
					<jvlayout:col length="3">
						<jvform:textfield id="textfield-medium" size="input-medium" placeholder="medium" title="文本输入框:" tooltrip="中"></jvform:textfield>
					</jvlayout:col>
					<jvlayout:col length="3">
						<jvform:textfield id="textfield-large" size="input-large" placeholder="large" title="文本输入框:" tooltrip="大"></jvform:textfield>
					</jvlayout:col>
				</jvlayout:row>
				<jvlayout:row>
					<jvlayout:col length="6">
						<jvform:textfield id="textfield-xlarge" size="input-xlarge" placeholder="xlarge" title="文本输入框:" tooltrip="特大"></jvform:textfield>
					</jvlayout:col>
					<jvlayout:col length="6">
						<jvform:textfield id="textfield-xxlarge" size="input-xxlarge" placeholder="xxlarge" title="文本输入框:" tooltrip="超特大"></jvform:textfield>
					</jvlayout:col>
					
				</jvlayout:row>
				<jvlayout:row>
					<jvlayout:col length="6" offset="6">
						<jvform:password id="password-medium" size="input-medium" placeholder="medium" title="密码输入框:" tooltrip="中" required="true"></jvform:password>
					</jvlayout:col>
				</jvlayout:row>
				
					<jvform:textareafield id="textareafield-mini" size="input-mini" title="文本输入框:" tooltrip="最小" required="true" ></jvform:textareafield>
					<jvform:textareafield id="textareafield-small" size="input-small" title="文本输入框:" tooltrip="小" readonly="true"></jvform:textareafield>
					<jvform:textareafield id="textareafield-medium" size="input-medium" title="文本输入框:" tooltrip="中"></jvform:textareafield>
					<jvform:textareafield id="textareafield-large" size="input-large" title="文本输入框:" tooltrip="大"></jvform:textareafield>
					<jvform:textareafield id="textareafield-xlarge" size="input-xlarge" title="文本输入框:" tooltrip="特大"></jvform:textareafield>
					<jvform:textareafield id="textareafield-xxlarge" size="input-xxlarge" title="文本输入框:" tooltrip="超特大"></jvform:textareafield>
					
					<jvform:datefield id="datefield" title="日期输入框:" ></jvform:datefield>
					<jvform:datefield id="datefield1" title="日期输入框:"  required="true" size="input-xlarge" tooltrip="特大"></jvform:datefield>
					
					<jvform:datetimefield id="datetimefield" title="日期时间输入框:"  readonly="true"></jvform:datetimefield>
					<jvform:datetimefield id="datetimefield1" title="日期时间输入框:"  required="true" size="input-xlarge" tooltrip="特大"></jvform:datetimefield>
					<jvform:datetimefield id="datetimefield2" title="日期时间输入框:"  required="false" size="input-large" tooltrip="大"></jvform:datetimefield>
					
					<jvform:ueditor id="ueditor1" title="富文本编辑框大:"  required="false" rows="50" ></jvform:ueditor>
					<jvform:ueditor id="ueditor2" title="富文本编辑框小:"  required="true"  ></jvform:ueditor>
					
					<jvform:checkbox id="checkbox1" required="true" title="checkbox1:" value="false"></jvform:checkbox>
					<jvform:checkbox id="checkbox2" required="false" title="checkbox2:" value="true"  tooltrip="选择框"></jvform:checkbox>
					
					<!-- 颜色选择 -->
					<jvform:colorpicker id="colorpicker1" required="true" title="颜色选择:" tooltrip="选择颜色"  size="input-small" value="#3be810"></jvform:colorpicker>
					
					<!-- 文件上传 -->
					<jvform:fileupload id="fileupload" required="false" title="文件上传:"></jvform:fileupload>
					
					<!-- 数字 -->
					<jvform:number id="number1" required="true" title="保留小数2位" decimals="2" size="input-small"></jvform:number>
					<jvform:number id="number2" required="false" title="保留小数3位" decimals="3" ></jvform:number>
					<jvform:number id="number3" required="false" title="保留小数4位" decimals="4" size="input-large"></jvform:number>
					
					<!-- 选择框 -->
					<jvform:select id="select21" title="combox 1" options="${options1}" selectType="1" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
					
					<jvform:select id="select22" title="combox 2" options="${options1}" selectType="2" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
					
					<jvform:select id="select23" title="combox 3" options="${options1}" selectType="3" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
				
					<jvform:select id="select24" title="combox 4" options="${options1}" selectType="4" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:select>
					
					<!-- radio框 -->
					<jvform:radio id="radio21" title="radio 1" options="${options1}" optionsType="1" size="input-large"  idField="id" nameField="name"></jvform:radio>
					
					<jvform:footbar>
						<jvform:submit/>
						&nbsp; &nbsp; &nbsp;
						<jvform:cancel/>
						&nbsp; &nbsp; &nbsp;
						<button id="openBtn" class="btn">dialog 测试</button>
						
					</jvform:footbar>
			</jvform:form>
  		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>