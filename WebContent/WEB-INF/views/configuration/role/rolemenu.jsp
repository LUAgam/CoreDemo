<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>

<%@ include file="../../taglibs.jsp"%>

<%@ taglib prefix="jvmessage" tagdir="/WEB-INF/tags/message"%>
<%@ taglib prefix="jvnav" tagdir="/WEB-INF/tags/nav"%>
<%@ taglib prefix="jvlayout" tagdir="/WEB-INF/tags/layout"%>
<%@ taglib prefix="jvtable" tagdir="/WEB-INF/tags/table"%>
<%@ taglib prefix="jvpanel" tagdir="/WEB-INF/tags/panel"%>
<%@ taglib prefix="jvform" tagdir="/WEB-INF/tags/form"%>

<spring:message code="permission.superTitle" var="i18n_permissionSuperTitle" />
<spring:message code="role.manager" var="i18n_roleManager" />
<spring:message code="role.permission" var="i18n_rolePermission" />
<spring:message code="widget.form.submit" var="i18n_widgetFormSubmit" />
<spring:message code="common.name" var="i18n_commonName" />
<spring:message code="common.displayName" var="i18n_commonDisplayName" />
<spring:message code="common.descroption" var="i18n_commonDescroption" />
<style>
.ztree {
	margin: 0;
	padding: 5px;
	color: #333;
}
</style>
<jvnav:pagetitle>
	编辑角色-菜单信息
</jvnav:pagetitle>

<jvnav:breadcrumb>
	<jvnav:breadcrumbitem title="${i18n_permissionSuperTitle}" active="true" />
	<jvnav:breadcrumbitem title="${i18n_roleManager}" url="/admin/auth/role" />
	<jvnav:breadcrumbitem title="编辑角色-菜单信息" active="true" />
</jvnav:breadcrumb>

<jvlayout:row>
	<jvlayout:col length="12">
		<jvpanel:panel color="purple" title="编辑角色-菜单信息">
			<jvform:form id="roleMenu" method="post" orient="horizontal">
				<jvform:textfield id="displayName" title="一级菜单显示名称" size="input-large" placeholder="请输入名称"></jvform:textfield>
				<jvform:hidden id="name"></jvform:hidden>
				<jvform:textfield id="icon" title="一级菜单显示图标" size="input-large" placeholder="请自行查找bootstarp支持的图标"></jvform:textfield>
				<jvform:footbar>
					<button class="btn btn-info" id="saveParent" type="button">
						<i class="icon-ok"></i> 保存
					</button>
						&nbsp; &nbsp; &nbsp;
				</jvform:footbar>
			</jvform:form>
			<button class="btn" id="add" type="button">
				<i class="icon-add"></i> 添加一级菜单
			</button>
						&nbsp; &nbsp; &nbsp;
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span6">
						<h4>${role.name }显示的菜单
							<small>本系统仅支持二级菜单</small>
						</h4>
						<ul id="treeDemo" class="ztree" style="margin-top: 10px; border: 1px solid #617775; background: #d9edf7; overflow-y: scroll; overflow-x: auto; height: 360px;"></ul>
					</div>
					<div class="span6">
						<h4>本系统所有二级菜单</h4>
						<ul id="treeDemo2" class="ztree" style="margin-top: 10px; border: 1px solid #617775; background: #d9edf7; overflow-y: scroll; overflow-x: auto; height: 360px;"></ul>
					</div>
				</div>
			</div>
			<br>
			<button class="btn btn-info" type="button" onclick="save()">
				<i class="icon-ok"></i> 保存
			</button>
		</jvpanel:panel>
	</jvlayout:col>
</jvlayout:row>
<SCRIPT type="text/javascript">
	$('#roleMenu').hide();
	$('#add').click(function() {
		$('#displayName').val('');
		$('#icon').val('');
		$('#roleMenu').show();
		$(this).hide();
	})
	var setting = {
		edit : {
			enable : true,
			showRemoveBtn : false,
			showRenameBtn : false
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : 0
			},
			key : {
				name : "displayName"
			}
		},
		callback : {
			beforeDrag : beforeDrag,
			beforeDrop : beforeDrop
		}
	};
	var setting2 = {
		edit : {
			enable : true,
			showRemoveBtn : true,
			showRenameBtn : true
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "tId",
				pIdKey : "parentTId",
				rootPId : 0
			},
			key : {
				name : "displayName"
			},
			keep : {
				leaf : true,
				parent : true
			}
		},
		callback : {
			beforeDrag : beforeDrag2,
			beforeDrop : beforeDrop2
		}
	};
	//所有二级菜单
	var zNodes;
	$.ajax({
		type : "GET",
		url : "${ctx}/admin/auth/role/menu/jsonData",
		dataType : "json",
		success : function(data) {
			zNodes = new Array();
			zNodes = data;
			$.fn.zTree.init($("#treeDemo2"), setting, zNodes);
		},
		error : function(msg) {
			alert("失败");
		}
	});
	//本角色的菜单
	var zNodes2;
	$.ajax({
		type : "GET",
		url : "${ctx}/admin/auth/role/menu/roleJsonData?roleId=${roleId}",
		dataType : "json",
		success : function(data) {
			zNodes2 = new Array();
			zNodes2 = data;
			$.each(zNodes2, function(i, n) {
				n.open = true;
			});
			$.fn.zTree.init($("#treeDemo"), setting2, zNodes2);
		},
		error : function(msg) {
			alert("失败");
		}
	});

	function beforeDrag(treeId, treeNodes) {
		for (var i = 0, l = treeNodes.length; i < l; i++) {
			if (treeNodes[i].drag === false) {
				return false;
			}
		}
		return true;
	}
	function beforeDrop(treeId, treeNodes, targetNode, moveType) {

		return targetNode ? targetNode.drop !== false : true;
	}
	function beforeDrag2(treeId, treeNodes) {
		var flag = false;
		$.each(treeNodes, function(idx, obj) {
			if (obj.isParent != true)
				flag = true;
		});
		return flag;
	}
	function beforeDrop2(treeId, treeNodes, targetNode, moveType) {
		return true;
	}

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting2);
		$.fn.zTree.init($("#treeDemo2"), setting, zNodes);
		zTree = $.fn.zTree.getZTreeObj("treeDemo");
	});

	//保存修改的树信息
	function save() {
		//检查
		check();
		saveZtree();

	};

	function saveZtree() {
		var node = zTree.getNodes();
		var nodes = zTree.transformToArray(node);
		var nodeList = [];
		for (var i = 0; i < nodes.length; i++) {
			nodeList.push({
				"displayName" : nodes[i].displayName,
				"name" : nodes[i].name,
				"tId" : nodes[i].tId,
				"parentTId" : nodes[i].parentTId,
				"role" : '${roleId}',
				"icon" : nodes[i].icon
			});
		}

		$.ajax({
			type : "POST",
			url : "${ctx}/admin/auth/role/saveRoleMenu",
			contentType:'application/json;charset=UTF-8',//关键是要加上这行
			traditional:true,//这使json格式的字符不会被转码
			data : JSON.stringify(nodeList),
			dataType : "text",
			success : function(data) {
				if (data == 'success')
					window.location.reload();
				else
					alert('菜单配置失败！');

			},
			error : function(msg) {
				alert("失败");
			}
		});
	}

	function check() {
		var treeObj = $.fn.zTree.getZTreeObj('treeDemo');
		var node = treeObj.getNodes();
		var nodes = treeObj.transformToArray(node);
		$.each(nodes, function(n, item) {
			if (item.isParent && item.parentTId != null && item.parentTId != 0)
				alert('只允许二级目录！');
		});
	}

	$('#saveParent').click(function() {
		if ($('#displayName').val() == null || $('#displayName').val() == '')
			alert('请填写名称');
		else {
			$('#roleMenu').hide();
			$('#add').show();
			addTreeNode();
			zTree.reAsyncChildNodes(null, "refresh");
		}

	})

	var zTree;
	function addTreeNode() {
		var newNode = {
			displayName : $('#displayName').val(),
			name : 'MENU:' + $('#displayName').val(),
			icon : $('#icon').val(),
			isParent : true,
			open : true
		};
		zTree.addNodes(null, newNode);
	}
</SCRIPT>