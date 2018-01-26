/*定义全局页面配置信息*/
var PagConfig = new Object();

//Ajax后台返回日志开关 true:开;false:关
PagConfig.debug = false;


/***
* 定义系统信息处理类,用来输入消息
* @version 1.0
* @author zhangchao
* based on easyUI
**/
(function($){
	
	/*定义信息处理类*/
	$.AilkMessageManager = function(){
		this.settings = $.extend(true,{},$.AilkMessageManager.defaults);
	}
	
	/*为信息处理类扩展属性,并 继承方法*/
	$.extend($.AilkMessageManager,{
		/*扩展属性*/
		defaults: {
			AI_WAIT_DIALOG: "x_aiwait_dialog",//处理进度对话框的DIV ID
			SELECTOR_AI_WAIT_DIALOG: "#x_aiwait_dialog", // 处理进度对话框选择器
			AI_DEBUG_WINDOW : "x_aidebug_window",//调试信息窗口DIV 标识
			SELECTOR_AI_DEBUG_WINDOW: "#x_aidebug_window",//调试信息窗口选择器
			AI_DEBUG_TEXTAREA: "x_aidebug_textarea",//调试信息输出的textarea
			SELECTOR_AI_DEBUG_TEXTAREA: "#x_aidebug_textarea", //调试信息输出的textarea选择器
			AI_EXCEPTION_WINDOW: "x_ai_exception_window",//异常信息窗口的div
			SELECTOR_AI_EXCEPTION_WINDOW: "#x_ai_exception_window", //异常信息窗口的选择器
			
			KEY_EXCEP_TYPE : "EXCEP_TYPE",//AJAX请求返回回来的异常类型标识码
			KEY_EXCEP_MESSAGE : "EXCEP_MESSAGE",//AJAX请求返回回来的异常信息标示码
			KEY_EXCEP_DETAIL : "EXCEP_DETAIL",//AJAX请返回的详细信息标识码
			KEY_EXCEP_NAME : "EXCEP_NAME",//AJAX请求返回回来的异常名称标识码
			KEY_EXCEP_PRINTEX : "EXCEP_PRINTEX",//AJAX请求返回的堆栈错误标识码
			KEY_OPERATOR : "OPERATOR"//AJAX请求返回的错误信息的测试人员标识
		},
		
		/*继承原型的方法*/
		prototype: {
			
			/**
			* 显示处理进度条
			* @param:options 全部入参为
				{ message:'正在处理中，请稍候..',//进度显示消息
				  modal:true/false,//是否遮罩
				  shadow:true/false,//是否有阴影边框
				  width: 250, //消息栏宽度，数字
				  height: 60 //消息栏高度，数字
				}
			**/
			showWait: function(options){
				
				/*内部函数，渲染对话框信息*/
				function renderAiWait(options){
					/*1.从入参对象中获取属性信息*/ 
					var width =  options && options.width ? options.width:260;
					var height = options && options.height ? options.height:60;
					var modal = options && options.modal==true ? true:false;
					var shadow = options && options.shadow==true ? true:false;
					
					/*2.执行渲染处理*/
					var _this=this;
					$(_this.settings.SELECTOR_AI_WAIT_DIALOG).dialog({
						title: "",
						width: width,
						height: height,
						modal: modal, 
						shadow: shadow
					});
				}
				
				/*1.获取wait对话框对象*/
				var aiwaitDialog = $(this.settings.SELECTOR_AI_WAIT_DIALOG);
				var message =  options && options.message ? options.message:"正在处理中，请稍候...";
				/*2.如果当前页面不存在，则创建一个*/
				if(!aiwaitDialog.length){
					/*2.1 拼装HTML*/
					var html = "<div id=\""+ this.settings.AI_WAIT_DIALOG +"\">";
					html+="<table width=\"100%\" height=\"100%\" border=0>";
					html+="<tr>"; 
					html+="<td width=60 align=center><span  class=\"AIAPPFRAME_WAIT_LOAD_CSS\"></span></td>";
					html+="<td id='wait_message_td'>"+ message +"</td>";
					html+="</tr>";
					html+="</table>"; 
					html+="</div>";
					/*2.2 载入到当前页面*/
					$(document.body).append(html);
				}else{
					/*2.3 如果存在，则需要更新消息栏上的提示信息*/
					$(this.settings.SELECTOR_AI_WAIT_DIALOG).find("#wait_message_td").html(message);
				} 
				
				/*3.渲染效果*/
				renderAiWait.call(this,options);
				
				//隐藏在IE6遮罩下的下拉框
				maskUtilProcesser.hideSelect();
			},
			
			/**隐藏处理消息框*/
			hideWait: function(){
				$(this.settings.SELECTOR_AI_WAIT_DIALOG).dialog('close');
				
				//显示在IE6遮罩下的隐藏的下拉框
				maskUtilProcesser.showSelect();
			},
			
			/**
			* 在调试窗口中输出指定的消息
			* @param:message-需要显示的信息
			* @options:配置参数
			**/
			showLogInfo: function(/*String*/message,/*json*/options){
				/**内部方法：渲染信息调试窗口*/
				function renderAiDebugWindow(message,options){
					var _this=this;
					/*1.渲染调试信息窗口*/
					$(_this.settings.SELECTOR_AI_DEBUG_WINDOW).window({
						title: options.title?options.title:'输出信息',
						width: options.width?options.width:720,
						modal: false,
						shadow: false,
						closed: true,
						minimizable:false,
						maximizable:false,
						resizable: false,
						height: options.height?options.height:370
					});
					/*2.渲染窗口中的关闭按钮*/
					$('#x-debug-closebtn').linkbutton({
						iconCls: 'icon-ok'
					}).bind("click",function(){
						$(_this.settings.SELECTOR_AI_DEBUG_WINDOW).window("close");
					});
					
					/*3.输出错误信息*/
					var debuTextarea = $(_this.settings.SELECTOR_AI_DEBUG_TEXTAREA);
					if(debuTextarea.length){
						/*如果需要先清除调试信息，则清空*/
						if(options.clear)debuTextarea.val("");
						var msg = debuTextarea.val();
						msg+=new Date().toLocaleString()+" 输出信息:\r\n";
						msg+=message;
						msg+="\r\n";//回车
						msg+="-----------------------------------------------------";
						msg+="\r\n";
						debuTextarea.val(msg);
					}
					/*4.默认开启窗口*/
					$(_this.settings.SELECTOR_AI_DEBUG_WINDOW).window("open");
				}
				options = options?options:{};
				var cols = options.cols?options.cols:100;
				var rows = options.rows?options.rows:20;
				/*1.获取当前界面上的调试窗口*/
				var xAiDebugWindow = $(this.settings.SELECTOR_AI_DEBUG_WINDOW);
				/*2.如果不存在，则默认构建一个*/
				if(!xAiDebugWindow.length){
					var windowHTML = "";
					windowHTML+="<div id=\""+ this.settings.AI_DEBUG_WINDOW +"\"  class=\"easyui-window\"  icon=\"icon-help\" >";
					windowHTML+="<div class=\"easyui-layout\">";
					windowHTML+="<div region=\"center\" border=\"false\" fit=\"true\" style=\"padding:1px;background:#fff;border:1px solid #ccc;\">";
					windowHTML+="<textarea cols=\""+cols+"\" rows=\""+rows+"\" id=\""+ this.settings.AI_DEBUG_TEXTAREA +"\"></textarea>";
					windowHTML+="</div>";
					windowHTML+="<div region=\"south\" border=\"false\" style=\"text-align:right;height:30px;line-height:30px;\">";
					windowHTML+="<a id=\"x-debug-closebtn\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">关闭</a>";
					windowHTML+="</div>";
					windowHTML+="</div>";
					windowHTML+="</div>";
					$(document.body).append(windowHTML);
				} 
				options = options?options:{};
				/*3.渲染调试信息*/
				renderAiDebugWindow.call(this,message,options);
			},
			
			/**
			* 在界面上显示完整的异常信息
			* @param options-异常信息
			**/
			showErrorPage: function(/*JSON*/options){
				var _this = this;
				
				/*生成界面异常信息内容*/
				function createExcept(options){
					/**1.获取异常信息*/
					var exceptType = options[this.settings.KEY_EXCEP_TYPE];
					var exceptMessage = options[this.settings.KEY_EXCEP_MESSAGE];
					var exceptDetail = options[this.settings.KEY_EXCEP_DETAIL];
					var exceptName = options[this.settings.KEY_EXCEP_NAME];
					var exceptTime = options[this.settings.KEY_EXCEP_TIME];
					var exceptPrintex = options[this.settings.KEY_EXCEP_PRINTEX];
					var operator = options[this.settings.KEY_OPERATOR];
					var exceptTime = new Date().toLocaleString();
					/**2.创建错误显示面板HTML*/ 
					var errorPagTableHTML = "<div id=\"errorPageTable\" class=\"errorPageTable\">";
					errorPagTableHTML += " <table width=\"100%\" align=\"center\">";
					errorPagTableHTML += " <tr>";
					errorPagTableHTML += "<td valign=\"middle\" align=\"center\">";
					/***错误提示界面图片区域 开始**/
					errorPagTableHTML += "<div class=\"float: left;width: 48px;height:70px;padding-left:2px;   \">";
					errorPagTableHTML += "<div class=\"messager-icon messager-error\"></div>";
					errorPagTableHTML += "</div>";
					/***错误提示界面图片区域 结束**/
					/***错误提示界面内容区域 开始**/
					errorPagTableHTML += "<div class=\"float: left;width: 228px;height:62px;padding-top:10px;text-align: left;text-indent: 24px;padding-left:20px;  \">";
					errorPagTableHTML+="<a name='x_error_pannel_anchor'></a>";
					errorPagTableHTML += "<table width=\"400\" height=\"60\">";
					errorPagTableHTML += "<tr>";
					errorPagTableHTML += "<td class='white-space: nowrap;' width='60'><b>错误信息:</b></td>";
					errorPagTableHTML += "<td>";
					errorPagTableHTML += " <font color='#D71920'>"+ exceptMessage + "</font>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					//errorPagTableHTML += "<tr>";
					//errorPagTableHTML += "<td class='white-space: nowrap;'><b>异常名称:</b></td>";
					//errorPagTableHTML += "<td>";
					//errorPagTableHTML += " <font color='#D71920'>"+ exceptName +"</font>";
					//errorPagTableHTML += "</td>";
					//errorPagTableHTML += "</tr>";
					errorPagTableHTML += "<tr>";
					errorPagTableHTML += "<td class='white-space: nowrap;' width='60'><b>提示时间:</b></td>";
					errorPagTableHTML += "<td>";
					errorPagTableHTML += " <font color='#D71920' >"+ exceptTime +"</font>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					errorPagTableHTML += "<tr>";
					errorPagTableHTML += "<td class='white-space: nowrap;' width='60'><b>操作人员:</b></td>";
					errorPagTableHTML += "<td>";
					errorPagTableHTML += " <font color='#D71920'>"+ operator +"</font>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					errorPagTableHTML += "<tr align=\"right\">";
					errorPagTableHTML += "<td colspan=\"2\">";
					errorPagTableHTML += "<div id=\"button\">";
					errorPagTableHTML += " <a href=\"#x_error_pannel_anchor\" id=\"showDetailDialogHref\"><b>展开\收起 详细信息</b></a>";
					errorPagTableHTML += "</div>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>"; 
					errorPagTableHTML += "</table>";
					errorPagTableHTML += "</div>";
					/***错误提示界面内容区域 结束**/
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					errorPagTableHTML += " </table>";
					
					/**错误详细信息显示界面 开始*/
					errorPagTableHTML += "<div id=\"popupContact\" style=\"width:100%;display:none\">";
					errorPagTableHTML += "<b>错误详细信息</b>";
					errorPagTableHTML += "<p id=\"contactArea\">";
					errorPagTableHTML += "原始信息：<br />";
					errorPagTableHTML += "<textarea style=\"width: 100%;height: 50px; no-repeat right top;border: 1px dotted #999666;\">"+ exceptMessage +"\n"+ exceptDetail +"</textarea> <br />";
					errorPagTableHTML += "异常信息：<br />";
					errorPagTableHTML += " <textarea style=\"width: 100%;height: 130px; no-repeat right top;border: 1px dotted #999666;\">"+ exceptPrintex +"</textarea>";
					errorPagTableHTML += "<br />"; 
					errorPagTableHTML += "</p>";
					errorPagTableHTML += "</div>";
					/**错误详细信息显示界面 结束*/
					errorPagTableHTML += "</div>";  
					return errorPagTableHTML;
				}
				
				/*渲染调试信息*/
				function renderExceptWindow(options){
					var _this=this;
					$(_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).dialog({
						title :"系统异常",
						modal: true,
						width:500,
						shadow: false,
						closable: false
					});
					
					/*绑定事件*/ 
					$("#showDetailDialogHref",_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).bind("click",function(){
						$("#popupContact",_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).toggle();
					})
					
					$(_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).window("open");
				}
				
				/*1.获取当前界面上的错误信息显示窗口*/
				var xAiExceptWindow = $(_this.settings.SELECTOR_AI_EXCEPTION_WINDOW);
				/*2.如果不存在，则默认构建一个窗口*/
				if(!xAiExceptWindow.length){
					var windowHtml = "";
					var content = createExcept.call(_this,options);
					windowHtml+="<div id=\""+_this.settings.AI_EXCEPTION_WINDOW+"\" class=\"easyui-window\" style=\"padding:5px;\">";
					windowHtml+=content;
					windowHtml+="</div>";
					$(document.body).append(windowHtml);
				}
				/*3.渲染窗口*/
				renderExceptWindow.call(_this,options); 
			},
			/**
			* 普通提示
			* @param message:提示信息
			* @param callFunc:回调函数
			* @param args:回调函数参数数组
			*/
			alert: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"确定",cancel:"取消"};
				$.messager.alert('提示',message,'alert',function(){
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* 错误提示
			* @param message:提示信息
			* @param callFunc:回调函数
			* @param args:回调函数参数数组
			*/
			error: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"确定",cancel:"取消"};
				$.messager.alert('错误提示',message,"error",function(){
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* 信息提示
			* @param message:提示信息
			* @param callFunc:调用函数
			* @param args:回调函数参数数组
			*/
			info: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"确定",cancel:"取消",closed:false};
				$.messager.alert('提示',message,"info",function(){ 
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* 问题提示
			* @param message:提示信息
			* @param callFunc:调用函数
			* @param args:回调函数参数数组
			*/
			question: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"确定",cancel:"取消"};
				$.messager.alert('确认',message,"question",function(){ 
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* 警告提示
			* @param message:提示信息
			* @param callFunc:调用函数
			* @param args:回调函数参数数组
			*/
			warning: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"确定",cancel:"取消"};
				$.messager.alert('警告',message,"warning",function(){ 
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* 确认信息
			* @param message:提示信息
			* @param callFunc:调用函数
			* @param args:函数参数列表
			**/
			confirm : function(/*String*/message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"确认",cancel:"取消"}; 
				$.messager.confirm('确认', message, function(r){ 
					maskUtilProcesser.showSelect();
					if (r){
						if(!args || args.constructor!=window.Array){
							args = arguments; 
						}  
						callFunc && callFunc.apply(this,args); 
					}
				});
			},
			/**
			* 确认信息
			* @param message:提示信息
			* @param options: 配置参数
			   {
			     okFunc: function(){},//确定按钮回调函数
			     okArgs: [],//确定按钮回调函数参数组
			   	 cancelFunc: function(){},//取消按钮回调函数
			   	 cancelArgs: [],//取消按钮回调函数参数组
			   }
			**/
			confirmNew: function(/*String*/message,/*JSON*/options){
				options = options ? options:{};
				/*转移焦点*/
				//this.transferFocus();
				/*获取参数*/
				var args =  options.okArgs;
				var callFunc = options.okFunc;
				var cancelArgs= options.cancelArgs;
				var cancelFunc= options.cancelFunc;
				/*设置提示框信息*/
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"确认",cancel:"取消"}; 
				$.messager.confirm('确认', message, function(r){ 
					maskUtilProcesser.showSelect();
					if (r){
						if(!args || args.constructor!=window.Array){
							args = arguments; 
						}  
						callFunc && callFunc.apply(this,args); 
					}else{
						if(!cancelArgs || cancelArgs.constructor!=window.Array){
							cancelArgs = arguments; 
						}  
						cancelFunc && cancelFunc.apply(this,cancelArgs); 
					}
				});
			},
			/**转移焦点*/
			transferFocus: function(){
				/*1.创建一个DIV*/
				var div="<div id='_x_div_focus_id' tabindex='-1'></div>";
				if(!$("#_x_div_focus_id").length){
					$(document.body).append(div);
				}
				/*2.使DIV获取到焦点*/
				if($("#_x_div_focus_id").length){
					$("#_x_div_focus_id").focus();
				} 
			}
		
		} 
	})
	
})(jQuery)

//实例化一个信息处理对象
var messageManager= new $.AilkMessageManager();

/***
* 定义页面交互信息调试类,根据配置输出调试信息 
* @version 1.0
* @author zhangchao 
**/
(function($){
	/*声明一个页面调试类*/
	$.PagDebug = function(){
		this.settings = $.extend(true,{},$.PagDebug.defaults);
	};
	/*扩展一些属性与方法*/
	$.extend($.PagDebug,{
		defaults : {
			
		},
		prototype : {
			
			/**
			* 输出调试信息
			* @parent message:调试日志信息 
			**/
			debug : function(/**String*/message){
				if(PagConfig.debug === false){
					return;
				}  
				messageManager.showLogInfo(message);
			}
		}
	});
})(jQuery)

//实例化一个页面日志调试类
var pagDebug = new $.PagDebug();

/***
* 定义页面控制处理类,用来控制页面交互处理
* @version 1.0
* @author zhangchao 
**/
(function($){
	
	/*定义页面交互处理类*/
	$.AilkPageInteractionManager = function(){
		this.settings = $.extend(true,{},$.AilkPageInteractionManager.defaults);
	}
	
	/*为页面交互处理类扩展属性,并 继承方法*/
	$.extend($.AilkPageInteractionManager,{
		/*扩展属性*/
		defaults: {
			AI_WAIT_DIALOG: "x_aiwait_dialog",//处理进度对话框的DIV ID
			SELECTOR_AI_WAIT_DIALOG: "#x_aiwait_dialog", // 处理进度对话框选择器
			AI_DEBUG_WINDOW : "x_aidebug_window",//调试信息窗口DIV 标识
			SELECTOR_AI_DEBUG_WINDOW: "#x_aidebug_window",//调试信息窗口选择器
			AI_DEBUG_TEXTAREA: "x_aidebug_textarea",//调试信息输出的textarea
			SELECTOR_AI_DEBUG_TEXTAREA: "#x_aidebug_textarea", //调试信息输出的textarea选择器
			AJAX_SUBMIT_CONTAINER: "_X_AJAX_SUBMIT_CONTAINER_DIV",//内部提交的AJAX容器DIV标识
			SELECTOR_AJAX_SUBMIT_CONTAINER: "#_X_AJAX_SUBMIT_CONTAINER_DIV",//内部提交的AJAX容器选择器
			AJAX_STATUS_SUCCESS: "1",//AJAX请求成功状态
			AJAX_STATUS_FAILURE: "0",//AJAX请求失败状态
			EXCEP_BUSINESS: "1",//业务异常
			EXCEP_SYSTEM: "2",//系统异常
			EXCEP_TYPE: "EXCEP_TYPE",//异常类型 1-业务异常  2-系统异常
			EXCEP_PRINTEX: "EXCEP_PRINTEX",//异常信息堆栈KEY
			SHOW_DETAIL: "SHOW_DETAIL",//错误提示中，是否有查看详细功能
			STATUS_CODE: "STATUS_CODE",//对应于appframe5.5封装的自定义消息CustomProperty的状态key值
			STATUS_INFO: "STATUS_INFO",//对应于appframe5.5封装的自定义消息CustomProperty的状态描述信息key值
			RETURN_INFO: "RETURN_INFO", //AJAX执行成功后的RETURN_INFO对象
			RETURN_INFO_TYPE: "RETURN_INFO_TYPE", //AJAX执行成功后的RETURN_INFO返回数据信息类型
			RETURN_INFO_DATA: "RETURN_INFO_DATA", //AJAX执行成功后的RETURN_INFO返回数据信息内容
			RETURN_INFO_TYPE_BUSI_VALID:"BUSI_VALID" //返回的数据类型是业务校验信息
		},
		
		/*继承原型的方法*/
		prototype: {
			
			/**
			* 载入iframe页面信息
			* @param:iframe --iframe选择器
			* @param:url --在iframe内加载的url
			* @param:options -json格式，额外的参数键值对.<br>
			  完整的参数：{
			  	showBusi： true/false, //是否显示载入进度条
			  	modal: true/false,//如果存在遮罩，是否模态形式遮罩
			  	message: "xx"//进度信息
			  } 
			**/
			loadIframe: function(/*selector*/iframe,/*String*/url,/*json*/options){
				/*1.获取是否显示载入进度条,进度消息，是否遮罩*/
				var showBusi = options && options.showBusi?true:false;
				var modal = options && options.modal?true:false;
				var message = options && options.message ? options.message: "页面正在加载，请稍候..";
				/*2.如果不显示处理进度条，则不显示*/
				if(showBusi)messageManager.showWait({ message:message,modal: modal});
				/*3.载入URL*/
				$(iframe).attr("src",url);
				/*4.侦听页面是否加载完毕，如果完毕，则根据配置隐藏进度信息栏*/
				$(iframe).load(function(){
					if(showBusi)messageManager.hideWait();
				})
			},
			
			/**
			* Ajax请求方法
			* @param options:参数信息
			* based on jquery.form.js
			**/
			goAjax: function(/*JSON*/options){
				var _this = this;
				/*1.转换各种回调函数*/
				var callbacks = {};
				if(typeof options.before == 'function'){
					callbacks["before"] = options.before;
					delete options.before;
				}
				if(typeof options.success=='function'){
					callbacks["success"] = options.success;
					delete options.success;
				}
				if(typeof options.failure=='function'){
					callbacks["failure"] = options.failure;
					delete options.failure;
				}
				if(typeof options.error=='function'){
					callbacks["error"] = options.error;
					delete options.error;
				}  
				var target = options.target;
				delete options.target;
				/*2.获取提交方式,如果没有指定，默认是request*/
				var postmode = options.postmode?options.postmode:"request";
				/*3.获取处理消息相关的信息*/
				//获取是否显示处理进度 如果没设置，则不显示
				var showBusi = options && options.showBusi==true?true:false;
				//获取消息处理进度框是否遮罩,如果不设置，默认为不遮罩
				var modal = options && options.modal==true?true:false;
				//获取消息处理进度框中显示的提示信息
				var message = options && options.message ? options.message: "正在处理中，请稍候..";
				//定义一个消息对象
				var msgManager = options.showArea=='parent'?parent.messageManager : messageManager;
				/*4.定义一个新的参数值对信息，继承入参相关参数*/
				var settings = {}; $.extend(settings,options); 
				
				/*5.实现一些jquery.form.js原生的回调函数*/
				/**
				* 实现ajax后端处理成功后的回调函数
				* @param transport:指ajax捕捉的服务端返回的信息
				**/
				settings["success"] = function(transport){ 
					//关闭进度条
					if(showBusi)msgManager.hideWait();
					
					/*5.1 首先判断返回值是否是JSON格式*/
					var returnObj = dataProcesser.parseJSON(options.dataType,transport);
					if(returnObj){ 
						/*5.1.1 获取特定的处理状态值*/
						var status = returnObj[_this.settings.STATUS_CODE];
						var statusInfo = returnObj[_this.settings.STATUS_INFO];
						var excepType = returnObj[_this.settings.EXCEP_TYPE];
						/*5.1.2 根据状态码进行处理*/
						if(status && status == _this.settings.AJAX_STATUS_FAILURE){
							/*如果状态码为失败，则回调failure函数*/ 
							var sessionInvalid = returnObj["_SESSION_INVALID_"]?returnObj["_SESSION_INVALID_"]:"1";
							var redirectURL = returnObj["_REDIRECT_URL_"];
							if(sessionInvalid == "0"){
								window.location=redirectURL;
								return false;
							}
							/*封装显示的详细信息*/
							var randTime = new Date().getTime();
							var showDetail = returnObj[_this.settings.SHOW_DETAIL];
							var info = showDetail?"处理失败(<a href='#x_alert_message_anchor' id='_frame_href_alert_message_"+ randTime +"' title='点击查看详细'><b>详情</b></a>)："
								:"";
							info = statusInfo? info+statusInfo:info+"请查看详细，并联系管理员解决"; 
							if(_this.settings.EXCEP_SYSTEM==excepType){
								//系统级异常提示		
								msgManager.warning(info,function(){
									callbacks["failure"] && callbacks["failure"].call(this);  
								});  
							}else{
								//业务级异常提示		
								msgManager.info(info,function(){
									callbacks["failure"] && callbacks["failure"].call(this);  
								});
							}
							/*绑定查看详细事件*/
							$("#_frame_href_alert_message_"+ randTime +"").bind("click",function(){
								var excepPrintex = returnObj[_this.settings.EXCEP_PRINTEX];
								msgManager.showLogInfo(excepPrintex,{
									title: "详细错误信息",
									width: 750,
									height: 400,
									clear: true
								});
							})    
						}else{
							/*如果状态码为成功，则回调success函数*/
							var returneInfo = returnObj[_this.settings.RETURN_INFO]; 
							if(returneInfo && dataProcesser.isJson(returneInfo) && _this.settings.RETURN_INFO_TYPE_BUSI_VALID==returneInfo[_this.settings.RETURN_INFO_TYPE] ){ 
								//如果是业务校验信息，则进行处理
								var returndata = returneInfo[_this.settings.RETURN_INFO_DATA]; 
								var validateBusiFrame =new $.ValidateBusiFrame(returndata); 
								var info=validateBusiFrame.info({
									title: settings.busiValidTitle,
									infolabel:settings.busiValidLabel, 
									failure:function(){ 
										//校验不通过的处理
										settings["busiFailure"] && settings["busiFailure"].call(this); 
									},
									success: function(){ 
										//校验通过的处理
										callbacks["success"] && callbacks["success"].call(this,returnObj);
									}
								});
								if(info){
									callbacks["success"] && callbacks["success"].call(this,returnObj);
								}
								return;
							}
							callbacks["success"] && callbacks["success"].call(this,returnObj);
						}
						pagDebug.debug("【返回数据格式】JSON  \r\n【数据内容】\r\n"+JSON.stringify(returnObj));
						return false;
					}
					/*5.2 判断返回值是否是XML格式*/
					var returnObj = dataProcesser.parseXML(options.dataType,transport);
					if(returnObj){
						/*5.2.1 调用appframe5.5 公有 api获取用户节点信息*/
						var xmlNode = transport.documentElement;
						var ud = createUserDataClass(xmlNode,true); 
						/*5.2.2 获取处理状态*/
						var status = ud.getValueByName(_this.settings.STATUS_CODE);
						var statusInfo = ud.getValueByName(_this.settings.STATUS_INFO);
						if(status && status == _this.settings.AJAX_STATUS_FAILURE){
							/*如果状态码为失败，则回调failure函数*/
							var info = statusInfo?"处理失败,错误信息:"+statusInfo+"":"处理失败，请联系管理员解决";
							msgManager.warning(info,function(){
								callbacks["failure"] && callbacks["failure"].call(this);  
							});   
						}else{
							/*如果状态码为成功，则回调success函数*/
							callbacks["success"] && callbacks["success"].call(this,transport);
						}
						pagDebug.debug("【返回数据格式】\r\nxml \r\n【数据内容】\r\n"+xmlNode.xml);
						return false;
					}
					
					/*5.3 其它数据格式*/
					pagDebug.debug("【返回数据格式】\r\ntext \r\n【数据内容】\r\n"+transport);
					if(postmode=="update")$(target).html(transport);
					callbacks["success"] && callbacks["success"].call(this,transport);
				};
				/**
				* 实现ajax处理前的句柄操作。如果返回为false,则终止操作 
				**/
				settings["beforeSubmit"] = function(){ 
					return callbacks["before"] && callbacks["before"].call(this);  
				};
				/**
				* 请求失败后的回调函数。如404错误等
				* 一般指服务器的异常，不能完成一次完整的请求
				**/
				settings["error"] = function(transport){  
					/*1.关闭处理进度信息*/
					if(showBusi)msgManager.hideWait();
					/*2.点击确定后执行回调函数*/ 
					msgManager.error("网络请求错误,错误码:"+transport.status+",请重试。",function(){
						callbacks["error"] && callbacks["error"].call(this,transport);
					});  
				};
				
				/*6.其它处理*/
				//生成遮罩效果
				if(showBusi)msgManager.showWait({ message:message,modal: modal,width: options.width,height: options.height});
				//附带数据部分的处理
				settings.data=options.data?options.data:{};
				var q="url_source=AilkPageInteractionManager";
				settings.url += (settings.url.indexOf('?') >= 0 ? '&' : '?') + q;
				/**对提交区域的容器进行处理*/
				if(options.postselectors && options.postselectors.length==1){ 
					/*如果待提交区域容器存在，而且仅仅只有一个，则不做任何处理，直接进行提交*/
					settings.semantic=true; 
					var postContainerSelector=options.postselectors[0]; 
					if($(postContainerSelector).length){
						$(postContainerSelector).ajaxSubmit(settings);
					}else{
						_this.processCombineParamContainer(options.postselectors);
						$(this.settings.SELECTOR_AJAX_SUBMIT_CONTAINER).ajaxSubmit(settings);
					}
					
				}else{
					/*如果待提交区域容器不存在，或者存在而且存在多个，则创建一个虚拟的提交区域作为提交区域*/
					settings.semantic=true;
					/**处理参数容器*/
					_this.processCombineParamContainer(options.postselectors);
					$(this.settings.SELECTOR_AJAX_SUBMIT_CONTAINER).ajaxSubmit(settings);
				}  
			}, 
			/**
			* 合并多区域提交的参数容器
			* @param postContainerSelectors: 需要批量提交的容器选择器数组
			**/
			processCombineParamContainer: function(/**Array*/postContainerSelectors){
				/**1.创建一个虚拟容器*/
				this.createSubmitContainer();
				var submitContainer = $(this.settings.SELECTOR_AJAX_SUBMIT_CONTAINER);
				/**3.处理批量提交的容器数据*/
				if(postContainerSelectors && $.isArray(postContainerSelectors)){
					$(postContainerSelectors).each(function(index,selector){
						if($(selector).length){
							$(selector).clone().prependTo(submitContainer);
						} 
					}); 
				}  
			},
			
			/**创建一个虚拟容器**/
			createSubmitContainer: function(){ 
				var xSubmitContainer = $(this.settings.SELECTOR_AJAX_SUBMIT_CONTAINER);
				if(!xSubmitContainer.length){
					$(document.body).append("<div id='"+ this.settings.AJAX_SUBMIT_CONTAINER +"' style='display:none'></div>");
				}else{
					xSubmitContainer.html("");
				}
			}
			
		}
	})
})(jQuery)

//实例化一个页面交互实例对象
var formPag = new $.AilkPageInteractionManager();

/**
* 定义一些javascript数据处理类
* 用于对xml，json,text等格式的数据进行处理
**/
(function($){
	/*声明一个数据处理类*/
	$.DataProcesser = function(){
		this.settings = $.extend(true,{},$.DataProcesser.defaults);
	}
	/*扩展一些属性与方法**/
	$.extend($.DataProcesser,{
		defaults: {
		},
		
		prototype: {
			
			/**
			* 判断是否是JSON格式,并将data解析成json对象
			* 如果不是json对象，返回false,如果是json对象，则直接返回
			* @param dataType: $.ajax能定义的返回数据类型
			* @param data:未知的数据类型
			*/
			parseJSON: function(dataType,data){
				if(dataType=="json" || dataType=="jsonp"){
					var isJSON = this.isJson(data);
					return isJSON?data:false;
				};
				try{
					var d=$.parseJSON(data);
					return d?d:false; 
				}catch(ex){ 
					return false;
				}
			},
			/**
			* 判断是否是JSON格式
			* 如果不是json对象，返回false,如果是json对象，则true
			* @param obj:未知的数据类型
			*/
			isJson: function(obj){
				var isjson = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length;    
				return isjson;
			},
			/**
			* 判断是否是xml格式,并将data解析成xmldocument对象
			* 如果是返回xmldocument， 否则返回false
			* @param dataType: $.ajax能定义的返回数据类型
			* @param data:未知的数据类型
			*/
			parseXML: function(dataType,data){ 
				var isXml = this.isXMLDoc(data);
				return isXml?data:false; 
			},
			/**
			* 判断是否是xml格式
			* 如果是返回true， 否则返回false
			* @param obj:未知的数据类型
			*/
			isXMLDoc: function(obj){
				return $.isXMLDoc(obj);
			}
		}
	})

})(jQuery)

//声明一个数据处理实例
var dataProcesser = new $.DataProcesser();


//声明一个数据处理实例
var dataProcesser = new $.DataProcesser();

/**
* 下拉框级联插件
* @author zhangchao
**/
(function($){
	
	/*声明一个级联处理类*/
	$.AiCascader = function(){
		this.settings = $.extend(true,{},$.AiCascader.defaults);
	}
	
	/*对级联处理类定义若干属性与方法*/
	$.extend($.AiCascader,{
		/*默认属性*/
		defaults: {
			OPTION_LABEL : "label", //选项值描述键值
			OPTION_VALUE : "value" //选项值键值
		},
		/*原型方法*/
		prototype: {
			/*初始化方法*/
			init: function(){
			
			},
			/**
			* 下拉选项级联
			* @options: json配置参数 {}
			* 配置项:
			* url: 远程请求的目标URL,此URL必须返回目标下拉列表的可选值JSONArray {label:xx,value:xx}
			* remote: true/false  是否远程请求
			* data: {}  远程请求额外的参数
			* optionData:静态数据值 json数组，格式为{label:xxx,value:xx}
			* targetSelect: 级联的目标下拉列表对象
			* defaultValue: 级联的目标下拉列表的默认值列表
			* defaultValues: 级联的目标下拉列表的默认值列表
			* showBusi: true/false 是否显示请求进度条
			* message: 请求进度条的消息
			* isShowAll: true/false 是否显示全部选项
			* labelAll: '全部' //全部选项名称
			* valueAll: 全部选项值
			* success: fn 目标下拉列表请求成功后的回调函数
			* failure: fn 目标下拉列表请求失败后的回调函数
			*/
			cascadeSelect: function(/*JSON*/options){
				options =  options?options:{};
				/*是否远程加载标记,如果没有设定，则默认为true*/
				var remote = options.remote && options.remote==true ? true:false;
				/*远程请求url如果url不存在，则远程载入标记为false*/
				var url = options.url?options.url:"";
				if(url=="")remote = false;
				/*目标下拉列表*/
				var targetSelect = options.targetSelect;
				if(!targetSelect){
					messageManager.alert("没有指定待刷新的下拉框");
					return false;
				}
				/*目标下拉列表的静态参数*/
				var optionData =  options.optionData?options.optionData:[];
				/*默认值列表，供多选时候使用*/
				var defaultValues =  options.defaultValues?options.defaultValues:[];
				var defaultValue = options.defaultValue?options.defaultValue:false;
				if(defaultValue)defaultValues.push(defaultValue);
				/*异步远程载入时候的进度消息信息*/
				var message = options.message?options.message:"正在请求数据，请稍候...";
				/*是否显示全部*/
				var isShowAll = options.isShowAll?options.isShowAll:false;
				/*显示全部选项的标签*/
				var labelAll = options.labelAll?options.labelAll:"全部";
				/*显示全部选项的标签值*/
				var valueAll = options.valueAll?options.valueAll:"";
				
				if(!remote){
					if(isShowAll){
						var alloption = {label:labelAll,value:valueAll};
						/*数组头部插入*/
						optionData.unshift(alloption);
					} 
					/*如果不是远程读取，则读取静态参数列表信息*/	
					this.refreshOptions(targetSelect,optionData,defaultValues);
					return;
				}
				var _this = this;
				/*如果是远程载入，则调用AJAX远程载入*/
				formPag.goAjax({
					type:"POST", 
					url: url,
					data : options.data?options.data:{},
					modal: true,
					showBusi: options.showBusi,
					message: message,  
					success:function(transport){  
						optionData = transport && transport.RETURN_INFO?transport.RETURN_INFO:{};
						if(isShowAll){
							var alloption = {label:labelAll,value:valueAll};
							/*数组头部插入*/
							optionData.unshift(alloption);
						} 
						//刷新结果列表
						_this.refreshOptions(targetSelect,optionData,defaultValues);
						//执行回调函数调用
						options["success"] && options["success"].call(this,transport);
					},
					failure: function(transport){
						//执行失败后的回调函数
						options["failure"] && options["failure"].call(this,transport);
					}
				});  
			},
			/**
			* 初始化下拉框静态选项数据
			* @param targetSelect:目标下拉列表
			* @param options: 目标下拉列表的配置选项信息 
			**/
			initOptions: function(targetSelect,options){
				/*目标下拉列表的静态参数*/
				var optionData =  options.optionData?options.optionData:[];
				/*默认值列表，供多选时候使用*/
				var defaultValues =  options.defaultValues?options.defaultValues:[];
				var defaultValue = options.defaultValue?options.defaultValue:false;
				if(defaultValue)defaultValues.push(defaultValue); 
				/*是否显示全部*/
				var isShowAll = options.isShowAll?options.isShowAll:false;
				/*显示全部选项的标签*/
				var labelAll = options.labelAll?options.labelAll:"全部";
				/*显示全部选项的标签值*/
				var valueAll = options.valueAll?options.valueAll:"";
				
				if(isShowAll){
					var alloption = {label:labelAll,value:valueAll};
					/*数组头部插入*/
					optionData.unshift(alloption);
				} 
				
				this.refreshOptions(targetSelect,optionData,defaultValues);
			},
			/**
			* 刷新目标下拉列表值
			* @param targetSelect:目标下拉列表
			* @param optionData: 目标下拉列表的选项信息[{label:xx,value:xx}]
			* @param defaultValues:目标下拉列表可选值
			**/
			refreshOptions: function(targetSelect,optionData,defaultValues){	
				var _this=this;
				/*1.清空所有选项*/
				_this.clearOptionAll(targetSelect);
				/*2.添加所有下拉列表数据*/
				$(optionData).each(function(index,d){
					_this.addOption(targetSelect,d.label,d.value);
				})
				/*3.设置选中项*/
				$(defaultValues).each(function(index,d){
					_this.setOptionSelected(targetSelect,d);
				})
			},
			/**
			* 清空目标下拉列表值
			* @param targetSelect:目标下拉列表
			**/
			clearOptionAll: function(targetSelect){
				if(!$(targetSelect).length)return;
				$(targetSelect).get(0).options.length = 0;
			},
			/**
			* 添加下拉列表值
			* @param targetSelect:目标下拉列表
			* @param label:文本描述
			* @param value: 值
			**/
			addOption: function(targetSelect,label,value){
				if(!$(targetSelect).length)return;
			    $(targetSelect).get(0).options.add(new Option(label,value));
			},
			/**
			* 设置指定的下拉选项为选中
			* @param targetSelect:目标下拉列表
			* @param value: 值
			**/
			setOptionSelected: function(targetSelect,value){
				if(!$(targetSelect).length)return;
			    var isExist = false;
			    var count = $(targetSelect).get(0).options.length;
			    for(var i=0;i<count;i++){
			        if($(targetSelect).get(0).options[i].value == value){
			            $(targetSelect).get(0).options[i].selected = true;
			            isExist = true;
			            break;
			        }
			    } 
			},
			/**
			* 判断选项是否已经存在
			* @param targetSelect:目标下拉列表 
			* @param value: 值
			**/
			optionIsExist: function(targetSelect,value){
				if(!$(targetSelect).length)return;
			    var isExist = false;
			    var count = $(targetSelect).get(0).options.length;
			    for(var i=0;i<count;i++){
			        if($(targetSelect).get(0).options[i].value == value){
			            isExist = true;
			            break;
			        }
			    }
			    return isExist;
			}
		}
	}); 
})(jQuery);

//声明一个级联对象
var cascader = new $.AiCascader();

/**
 * 遮罩辅助类
 * 解决遮罩页面显示的问题
 * @author zhangchao
 */
(function($){
	
	/*声明一个遮罩辅助类*/
	$.MaskUtilProcesser = function(){
		this.settings = $.extend(true,{},$.MaskUtilProcesser.defaults);
	}
	
	$.extend($.MaskUtilProcesser,{
		/*默认属性*/
		defaults: {
		}, 
		/*默认方法*/
		prototype: {
			/*在IE6遮罩情况下隐藏所有可见的下拉框*/
			hideSelect: function(){
				/*判断是否是IE6，如果不是，则不处理*/
				var isIE6 = $.browser.msie && /msie 6\.0/i.test(navigator.userAgent);
				if(!isIE6)return;
				/*获取所有处于显示状态的SELECT，存储并隐藏*/
				if($("select:visible").length){ 
					this.hideSelects = $("select:visible");
					$("select:visible").hide();
				}
			},
			/*在IE6遮罩情况下显示之前隐藏的所有下拉框*/
			showSelect: function(){
				/*判断是否是IE6，如果不是，则不处理*/
				var isIE6 = $.browser.msie && /msie 6\.0/i.test(navigator.userAgent);
				if(!isIE6)return;
				/*获取所有处于显示状态的SELECT，存储并隐藏*/
				if(this.hideSelects && this.hideSelects.length){
					this.hideSelects.show();
				} 
			}
		}
	})
	
})(jQuery);

//声明一个遮罩辅助处理类
var maskUtilProcesser = new $.MaskUtilProcesser(); 

(function($){
	
	/*定义一个限制输入处理类*/
	$.InputLimitProcessor = function(inputObj,showObj,limiteNumber,options){
		this.inputObj = inputObj;
		this.showObj = showObj;
		this.limiteNumber = limiteNumber; 
		this.settings = $.extend(true,{},$.MaskUtilProcesser.defaults,options?options:{});
		this.init();
	}
	
	/*扩展属性与配置*/
	$.extend($.InputLimitProcessor,{
		defaults: {
		},
		prototype: { 
			init: function(){
				var _this = this;
				$(this.inputObj).bind("keyup",function(){ 
					_this.check();
				})
				$(this.showObj).html(this.limiteNumber);
			}, 
			reset: function(){
				$(this.inputObj).val("");
				$(this.showObj).html(this.limiteNumber);
			},
			check: function(){ 
				var obj = $(this.inputObj);
				var objValue = obj.val();
				var len = this.limiteNumber ; 
				var currLength = objValue.replace(/[^\x00-\xFF]/g,'**').length; 
				if(currLength >= len) {
					obj.val(this.leftUTFString(objValue, len));
					$(this.showObj).html(len-currLength);
				} else { 
					$(this.showObj).html(len-currLength);
				}
			}, 
			getStringUTFLength:function(str) { 
				var value = str.replace(/[^\x00-\xff]/g,"  "); 
				return value.length; 
			}, 
			leftUTFString: function(str,len) { 
				alert(str);
				if(this.getStringUTFLength(str)<=len) 
					return str; 
				var value = str.substring(0,len); 
				while(this.getStringUTFLength(value)>len) { 
					value = value.substring(0,value.length-1); 
				}  
				return value; 
			}	
		}
	});
})(jQuery)

