define('app/jsp/serviceDefine/save', function (require, exports, module) {
    'use strict';
    var $=require('jquery'),
	    Widget = require('arale-widget/1.2.0/widget'),
	    Dialog = require("optDialog/src/dialog"),
	    AjaxController = require('opt-ajax/1.0.0/index');
    require("jsviews/jsrender.min");
    require("jsviews/jsviews.min");
    require("my97DatePicker/WdatePicker");
    require("bootstrap-paginator/bootstrap-paginator.min");
    require("app/util/jsviews-ext");
    require("opt-paging/aiopt.pagination");
    
    require("jquery-validation/1.15.1/jquery.validate");
    require("app/util/aiopt-validate-ext");
    
    
    //实例化AJAX控制处理对象
    var ajaxController = new AjaxController();
    //定义页面组件类
    var prdlineAddPager = Widget.extend({
    	
    	//属性，使用时由类的构造函数传入
    	attrs: {
    	},
    	Statics: {
    	},
    	//事件代理
    	events: {
    		"click #submitSaveBtn":"_savePrdline",
    		"click #cancelBtn":"_cancelSave",
    		"click #srvCenterName":"_selectSrvCenter",
    		"click #srvCategoryName":"_selectCategory"
        },
    	//重写父类
    	setup: function () {
    		prdlineAddPager.superclass.setup.call(this);
    	},
    	_selectSrvCenter:function(){
    		this._showTree('srvCenterName','srvCenter');
    	},
    	_selectCategory:function(){
    		this._showTree('srvCategoryName','srvCategoryId');
    	},
    	_showTree:function(nameId, valueId) {
            $.get(_base+'/category/tree', function (data) {
                var options={
                		title : "服务目录",
        				message : data,
        				callback:function () {
        					 var categoryName = $("#selectName").val();
    	                     $("#"+nameId).val(categoryName);
    	                     var srvCenter = $("#selectId").val();
    	                     $("#"+valueId).val(srvCenter);
                        },
                        buttons:{
                        	ok:{
                        		label:'确定'
                        	}
                        }
                };
                bootbox.alert(options);
            });
        },
    	_cancelSave: function(){
    		window.history.go(-1);
			$('#serviceForm')[0].reset();
    	},
    	_savePrdline: function(){
    		var validateForm = $("#serviceForm").validate();
			if(!validateForm.form()){
				return;
			}
			ajaxController.ajax({
				type: "post",
				processing: true,
				message: "保存中，请等待...",
				url: _base+"/serviceDefine/save",
				data:$('#serviceForm').serializeArray(),
				success: function(data){
					if("1"===data.statusCode){
						var d = Dialog({
							title:"提示",
							content:"保存成功",
							icon:'success',
							cancelValue: '确 定',
							cancel:function(){
								this.close();
								//保存成功,回退到进入的列表页
								window.history.go(-1);
								$('#prdLineForm')[0].reset();
							}
						});
						d.show();
					}
				}
			});
    	}
    });
    
    module.exports = prdlineAddPager;
});

