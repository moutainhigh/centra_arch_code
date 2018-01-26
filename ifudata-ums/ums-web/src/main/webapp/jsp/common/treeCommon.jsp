<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/jsp/common/common.jsp"%>
<link rel="stylesheet" href="${_base}/js/jquery/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="${_base}/ui/css/css.css" type="text/css">
<script type="text/javascript" src="${_base}/js/jquery/zTree/js/jquery.ztree.core-3.5.min.js"></script>
<style type="text/css">
<!--
.treedatadiv ul li {clear:both;float:none}
.main_shu_cd ul{clear:both;float:none}
-->
</style>
<div
	style="position: absolute; z-index: 9999; display: none; background-color: #FFFFFF;border:1px solid black;height: 250px;width:250px;overflow: auto;"
	id="dept_tree" class="treedatadiv">
	<div style="text-align:right;padding:5px 5px;">
		<span style="text-align:right;font-weight:700;">
		<a href="javascript:void(0)" onclick="qingkongBm('#depart_id');return false;">[清空]</a>
		<a href="javascript:void(0)" onclick="$('#dept_tree').hide();return false;">X</a></span>
	</div>
	<div class="main_shu_cd" >
  		<ul id="tree_dept_content" class="ztree" ></ul>
    </div>
</div>

<!-- 区域 -->
<div
	style="position: absolute; z-index: 9999; display: none; background-color: #FFFFFF;border:1px solid black;height: 250px;width:250px;overflow: auto;"
	id="area_tree" class="treedatadiv">
	<div style="text-align:right;padding:5px 5px;">
		<span style="text-align:right;font-weight:700;">
		<a href="javascript:void(0)" onclick="qingkongBm('#area_code');return false;">[清空]</a>
		<a href="javascript:void(0)" onclick="$('#area_tree').hide();return false;">X</a></span>
	</div>
	<div class="main_shu_cd" >
  		<ul id="tree_area_content" class="ztree" ></ul>
    </div>
</div>

<!-- 渠道类型 -->
<div
	style="position: absolute; z-index: 9999; display: none; background-color: #FFFFFF;border:1px solid black;height: 250px;width:250px;overflow: auto;"
	id="chl_kind_tree" class="treedatadiv">
	<div style="text-align:right;padding:5px 5px;">
		<span style="text-align:right;font-weight:700;">
		<a href="javascript:void(0)" onclick="qingkongBm('#chal_kind_id');return false;">[清空]</a>
		<a href="javascript:void(0)" onclick="$('#chl_kind_tree').hide();return false;">X</a></span>
	</div>
	<div class="main_shu_cd" >
  		<ul id="tree_chl_kind_content" class="ztree" ></ul>
    </div>
</div>

<input id="chl_kind_input" type="hidden">
<input id="area_input" type="hidden">
<input id="dept_input" type="hidden">


<script>
	var setting = {
		check: {
			enable: true,
			chkStyle: "radio",
			radioType: "all"
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode){
				return (treeNode && !treeNode.isParent);
			},
			onClick: function(event, treeId, treeNode){
				$("#dept_input").val(treeNode.id);
				$("#depart_id").val(treeNode.name);
				$("#dept_tree").hide();
				
				//级联区域
				if(typeof cascadeArea === 'function'){
					cascadeArea(treeNode.id, treeNode.provinceCode, treeNode.cityCode, treeNode.areaCode, treeNode.areaName);
				}
			}
		}
	};	
	
	var settingArea = {
			check: {
				enable: true,
				chkStyle: "radio",
				radioType: "all"
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: function(event, treeId, treeNode){
					$("#area_input").val(treeNode.id);
					$("#area_code").val(treeNode.name);
					$("#area_tree").hide();
				}
			}
		};	
	
	
	var settingChlKind = {
			check: {
				enable: true,
				chkStyle: "radio",
				radioType: "all"
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: function(event, treeId, treeNode){
					$("#chal_kind_id").val(treeNode.name);
					$("#chl_kind_input").val(treeNode.id);
					$("#chl_kind_tree").hide();

				}
			}
		};	
	
	
	$(document).ready(function(){
		
		//部门树
		$.ajax({
			type : "POST",
			async: false,
			data:{
				jxcompanyId: "${jxcompanyId}"
			},
			url : "${_base}/common/tree/depart",
			dataType : "JSON",
			success : function(data) {
				var tag = data.RES_RESULT;
				if (tag == "SUCCESS") {
					var zNodes = data.RES_DATA.zNodes;
					$.fn.zTree.init($("#tree_dept_content"), setting, zNodes);
					deptBind();
				}else{
					$.dialog.alert(data.RES_MSG);
				}
			}
		});
		
		//区域树
		$.ajax({
			type : "POST",
			async: false,
			url : "${_base}/common/tree/area",
			dataType : "JSON",
			success : function(data) {
				var tag = data.RES_RESULT;
				if (tag == "SUCCESS") {
					var aNodes = data.RES_DATA.aNodes;
					$.fn.zTree.init($("#tree_area_content"), settingArea, aNodes);
					$("#area_a").bind("click",function(){
						var position = $(this).position();
						$("#area_tree").css("left",position.left);
						$("#area_tree").css("top",position.top);
						$("#area_tree").show();
						$("body").bind("mousedown", onBodyDown);
						return false;
					});
				}else{
					$.dialog.alert(data.RES_MSG);
				}
			}
		});
		
		
		//渠道类别树
		$.ajax({
			type : "POST",
			async: false,
			url : "${_base}/common/tree/chlKind",
			dataType : "JSON",
			success : function(data) {
				var tag = data.RES_RESULT;
				if (tag == "SUCCESS") {
					var cNodes = data.RES_DATA.cNodes;
					$.fn.zTree.init($("#tree_chl_kind_content"), settingChlKind, cNodes);
					chalKindBind();
				}else{
					$.dialog.alert(data.RES_MSG);
				}
			}
		});
		if(tip != null){
			tip.close();
		}
		
		
		
		
	});
	
	/**
	 *清空操作
	 */
	function qingkongBm(input){
		$(input).val("");
	}
	
	function getDeptId(){
		return $("#dept_input").val();
	}
	
	function getAreaId(){
		return $("#area_input").val();
	}
	
	function getChlKindId(){
		return $("#chl_kind_input").val();
	}
	function hideMenu() {
		$(".treedatadiv").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "dept_a" || event.target.id == "area_a" || event.target.id == "chal_kind_a" || event.target.getAttribute("class") == "treedatadiv" || $(event.target).parents(".treedatadiv").length>0)) {
			hideMenu();
		}
	}
	function deptBind(){
		$("#dept_a").bind("click",function(){
			var position = $(this).position();
			$("#dept_tree").css("left",position.left);
			$("#dept_tree").css("top",position.top);
			$("#dept_tree").show();
			$("body").bind("mousedown", onBodyDown);
			return false;
		});
	}
	function chalKindBind(){
		$("#chal_kind_a").bind("click",function(){
			var position = $(this).position();
			$("#chl_kind_tree").css("left",position.left);
			$("#chl_kind_tree").css("top",position.top);
			$("#chl_kind_tree").show();
			$("body").bind("mousedown", onBodyDown);
			return false;
		});
	}

</script>