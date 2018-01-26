define('app/jsp/product/insalelist', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
	    Widget = require('arale-widget/1.2.0/widget'),
	    Dialog = require("optDialog/src/dialog"),
	    Paging = require('paging/0.0.1/paging-debug'),
	    AjaxController = require('opt-ajax/1.0.0/index');
    require("jsviews/jsrender.min");
    require("jsviews/jsviews.min");
    require("bootstrap-paginator/bootstrap-paginator.min");
    require("app/util/jsviews-ext");
    
    require("opt-paging/aiopt.pagination");
    require("twbs-pagination/jquery.twbsPagination.min");
    var SendMessageUtil = require("app/util/sendMessage");
    
    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();
    var clickId = "";
    //定义页面组件类
    var InsalelistPager = Widget.extend({
    	
    	Implements:SendMessageUtil,
    	//属性，使用时由类的构造函数传入
    	attrs: {
    		clickId:""
    	},
    	Statics: {
    		DEFAULT_PAGE_SIZE: 30
    	},
    	//事件代理
    	events: {
    		//查询在售商品
            "click #selectProductInSale":"_selectProductInSale",
            "click #upConfirm":"_prodToInStore"
        },
    	//重写父类
    	setup: function () {
    		InsalelistPager.superclass.setup.call(this);
    		this._selectProductInSale();
    	},
    	//弹出下架确认提示框
    	_showUpConfirm:function(prodId){
    		$(".eject-big").show();
    		$(".eject-samll").show();
    		$(".eject-mask").show();
    		clickId = prodId;
    	},
    	//下架
    	_prodToInStore: function(){
    		$(".eject-big").hide();
    		$(".eject-samll").hide();
    		$(".eject-mask").hide();
    		var _this = this;
    		var prodId = clickId;
    		ajaxController.ajax({
				type: "post",
				processing: false,
				message: "下架中，请等待...",
				//url: _base+"/prodOperate/prodInStore",
				url: _base+"/prodOperate/prodInStore",
				data:{"productId":prodId},
				success: function(data){
					if("1"===data.statusCode){
						_this._selectProductInSale();
						var d = Dialog({
							content:"下架成功.",
							icon:'success',
							okValue: '确 定',
							ok:function(){
								this.close();
							}
						});
						d.show();
	            	}else{
	            		var d = Dialog({
							content:"下架失败:"+data.statusInfo,
							icon:'fail',
							okValue: '确 定',
							ok:function(){
								this.close();
							}
						});
						d.show();
	            	}
				}
			});
    	},
    	// 改变商品类目
    	_selectChange:function(osel){
    		var prodCatId = osel.options[osel.selectedIndex].value;
    		var clickId = $(osel).parent().attr('id');
    		//获取当前ID的最后数字
    		var index = Number(clickId.substring(10))+1;
    		//获取下拉菜单的总个数
    		var prodCat = document.getElementById("date1ProdCat");
    		var length = prodCat.getElementsByTagName("select").length;
    		if(index==length){
    			return;
    		}
    		//从当前元素开始移除后面的下拉菜单
    		for(var i=index;i<length;i++){
    			$("#productCat"+i).remove();
    		}
    		ajaxController.ajax({
				type: "post",
				processing: false,
				// message: "加载中，请等待...",
				url: _base+"/cat/query/child",
				data:{"prodCatId":prodCatId},
				success: function(data){
					if(data != null && data != 'undefined' && data.length>0){
	            		var template = $.templates("#prodCatTemple");
	            	    var htmlOutput = template.render(data);
	            	    $("#"+clickId).after(htmlOutput);
	            	}else{
	            		var d = Dialog({
							content:"获取类目信息出错:"+data.statusInfo,
							icon:'fail',
							okValue: '确 定',
							ok:function(){
								this.close();
							}
						});
						d.show();
	            	}
				}
			});
    	},
    	//查询在售商品
    	_selectProductInSale:function(){
    		var _this = this;
    		//获取下拉菜单的总个数-2即为ID后的数值
    		var div = document.getElementById("date1ProdCat");
    		var length = document.getElementsByTagName("select").length-2;
    		var productCatId = $("#productCat"+length+" option:selected").val();
    		var productType = $("#productType").val().trim();
    		var productId = $("#productId").val().trim();
    		var productName = $("#productName").val().trim();
    		$("#pagination-ul").runnerPagination({
	 			url: _base+"/prodquery/getInsaleList",
	 			method: "POST",
	 			dataType: "json",
	 			renderId:"searchProductData",
	 			messageId:"showMessageDiv",
	            data: {"productCatId":productCatId,"productType":productType,"productId":productId,"productName":productName},
	           	pageSize: InsalelistPager.DEFAULT_PAGE_SIZE,
	           	visiblePages:5,
	            render: function (data) {
	            	if(data != null && data != 'undefined' && data.length>0){
	            		var template = $.templates("#searchProductTemple");
	            	    var htmlOutput = template.render(data);
	            	    $("#searchProductData").html(htmlOutput);
	            	}
	            	_this._returnTop();
	            }
    		});
    	},
    	//滚动到顶部
    	_returnTop:function(){
    		var container = $('.wrapper-right');
    		container.scrollTop(0);//滚动到div 顶部
    	},
    	
    });
    
    module.exports = InsalelistPager
});


