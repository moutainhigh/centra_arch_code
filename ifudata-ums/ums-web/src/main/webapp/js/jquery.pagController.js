/*����ȫ��ҳ��������Ϣ*/
var PagConfig = new Object();

//Ajax��̨������־���� true:��;false:��
PagConfig.debug = false;


/***
* ����ϵͳ��Ϣ������,����������Ϣ
* @version 1.0
* @author zhangchao
* based on easyUI
**/
(function($){
	
	/*������Ϣ������*/
	$.AilkMessageManager = function(){
		this.settings = $.extend(true,{},$.AilkMessageManager.defaults);
	}
	
	/*Ϊ��Ϣ��������չ����,�� �̳з���*/
	$.extend($.AilkMessageManager,{
		/*��չ����*/
		defaults: {
			AI_WAIT_DIALOG: "x_aiwait_dialog",//������ȶԻ����DIV ID
			SELECTOR_AI_WAIT_DIALOG: "#x_aiwait_dialog", // ������ȶԻ���ѡ����
			AI_DEBUG_WINDOW : "x_aidebug_window",//������Ϣ����DIV ��ʶ
			SELECTOR_AI_DEBUG_WINDOW: "#x_aidebug_window",//������Ϣ����ѡ����
			AI_DEBUG_TEXTAREA: "x_aidebug_textarea",//������Ϣ�����textarea
			SELECTOR_AI_DEBUG_TEXTAREA: "#x_aidebug_textarea", //������Ϣ�����textareaѡ����
			AI_EXCEPTION_WINDOW: "x_ai_exception_window",//�쳣��Ϣ���ڵ�div
			SELECTOR_AI_EXCEPTION_WINDOW: "#x_ai_exception_window", //�쳣��Ϣ���ڵ�ѡ����
			
			KEY_EXCEP_TYPE : "EXCEP_TYPE",//AJAX���󷵻ػ������쳣���ͱ�ʶ��
			KEY_EXCEP_MESSAGE : "EXCEP_MESSAGE",//AJAX���󷵻ػ������쳣��Ϣ��ʾ��
			KEY_EXCEP_DETAIL : "EXCEP_DETAIL",//AJAX�뷵�ص���ϸ��Ϣ��ʶ��
			KEY_EXCEP_NAME : "EXCEP_NAME",//AJAX���󷵻ػ������쳣���Ʊ�ʶ��
			KEY_EXCEP_PRINTEX : "EXCEP_PRINTEX",//AJAX���󷵻صĶ�ջ�����ʶ��
			KEY_OPERATOR : "OPERATOR"//AJAX���󷵻صĴ�����Ϣ�Ĳ�����Ա��ʶ
		},
		
		/*�̳�ԭ�͵ķ���*/
		prototype: {
			
			/**
			* ��ʾ���������
			* @param:options ȫ�����Ϊ
				{ message:'���ڴ����У����Ժ�..',//������ʾ��Ϣ
				  modal:true/false,//�Ƿ�����
				  shadow:true/false,//�Ƿ�����Ӱ�߿�
				  width: 250, //��Ϣ����ȣ�����
				  height: 60 //��Ϣ���߶ȣ�����
				}
			**/
			showWait: function(options){
				
				/*�ڲ���������Ⱦ�Ի�����Ϣ*/
				function renderAiWait(options){
					/*1.����ζ����л�ȡ������Ϣ*/ 
					var width =  options && options.width ? options.width:260;
					var height = options && options.height ? options.height:60;
					var modal = options && options.modal==true ? true:false;
					var shadow = options && options.shadow==true ? true:false;
					
					/*2.ִ����Ⱦ����*/
					var _this=this;
					$(_this.settings.SELECTOR_AI_WAIT_DIALOG).dialog({
						title: "",
						width: width,
						height: height,
						modal: modal, 
						shadow: shadow
					});
				}
				
				/*1.��ȡwait�Ի������*/
				var aiwaitDialog = $(this.settings.SELECTOR_AI_WAIT_DIALOG);
				var message =  options && options.message ? options.message:"���ڴ����У����Ժ�...";
				/*2.�����ǰҳ�治���ڣ��򴴽�һ��*/
				if(!aiwaitDialog.length){
					/*2.1 ƴװHTML*/
					var html = "<div id=\""+ this.settings.AI_WAIT_DIALOG +"\">";
					html+="<table width=\"100%\" height=\"100%\" border=0>";
					html+="<tr>"; 
					html+="<td width=60 align=center><span  class=\"AIAPPFRAME_WAIT_LOAD_CSS\"></span></td>";
					html+="<td id='wait_message_td'>"+ message +"</td>";
					html+="</tr>";
					html+="</table>"; 
					html+="</div>";
					/*2.2 ���뵽��ǰҳ��*/
					$(document.body).append(html);
				}else{
					/*2.3 ������ڣ�����Ҫ������Ϣ���ϵ���ʾ��Ϣ*/
					$(this.settings.SELECTOR_AI_WAIT_DIALOG).find("#wait_message_td").html(message);
				} 
				
				/*3.��ȾЧ��*/
				renderAiWait.call(this,options);
				
				//������IE6�����µ�������
				maskUtilProcesser.hideSelect();
			},
			
			/**���ش�����Ϣ��*/
			hideWait: function(){
				$(this.settings.SELECTOR_AI_WAIT_DIALOG).dialog('close');
				
				//��ʾ��IE6�����µ����ص�������
				maskUtilProcesser.showSelect();
			},
			
			/**
			* �ڵ��Դ��������ָ������Ϣ
			* @param:message-��Ҫ��ʾ����Ϣ
			* @options:���ò���
			**/
			showLogInfo: function(/*String*/message,/*json*/options){
				/**�ڲ���������Ⱦ��Ϣ���Դ���*/
				function renderAiDebugWindow(message,options){
					var _this=this;
					/*1.��Ⱦ������Ϣ����*/
					$(_this.settings.SELECTOR_AI_DEBUG_WINDOW).window({
						title: options.title?options.title:'�����Ϣ',
						width: options.width?options.width:720,
						modal: false,
						shadow: false,
						closed: true,
						minimizable:false,
						maximizable:false,
						resizable: false,
						height: options.height?options.height:370
					});
					/*2.��Ⱦ�����еĹرհ�ť*/
					$('#x-debug-closebtn').linkbutton({
						iconCls: 'icon-ok'
					}).bind("click",function(){
						$(_this.settings.SELECTOR_AI_DEBUG_WINDOW).window("close");
					});
					
					/*3.���������Ϣ*/
					var debuTextarea = $(_this.settings.SELECTOR_AI_DEBUG_TEXTAREA);
					if(debuTextarea.length){
						/*�����Ҫ�����������Ϣ�������*/
						if(options.clear)debuTextarea.val("");
						var msg = debuTextarea.val();
						msg+=new Date().toLocaleString()+" �����Ϣ:\r\n";
						msg+=message;
						msg+="\r\n";//�س�
						msg+="-----------------------------------------------------";
						msg+="\r\n";
						debuTextarea.val(msg);
					}
					/*4.Ĭ�Ͽ�������*/
					$(_this.settings.SELECTOR_AI_DEBUG_WINDOW).window("open");
				}
				options = options?options:{};
				var cols = options.cols?options.cols:100;
				var rows = options.rows?options.rows:20;
				/*1.��ȡ��ǰ�����ϵĵ��Դ���*/
				var xAiDebugWindow = $(this.settings.SELECTOR_AI_DEBUG_WINDOW);
				/*2.��������ڣ���Ĭ�Ϲ���һ��*/
				if(!xAiDebugWindow.length){
					var windowHTML = "";
					windowHTML+="<div id=\""+ this.settings.AI_DEBUG_WINDOW +"\"  class=\"easyui-window\"  icon=\"icon-help\" >";
					windowHTML+="<div class=\"easyui-layout\">";
					windowHTML+="<div region=\"center\" border=\"false\" fit=\"true\" style=\"padding:1px;background:#fff;border:1px solid #ccc;\">";
					windowHTML+="<textarea cols=\""+cols+"\" rows=\""+rows+"\" id=\""+ this.settings.AI_DEBUG_TEXTAREA +"\"></textarea>";
					windowHTML+="</div>";
					windowHTML+="<div region=\"south\" border=\"false\" style=\"text-align:right;height:30px;line-height:30px;\">";
					windowHTML+="<a id=\"x-debug-closebtn\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\">�ر�</a>";
					windowHTML+="</div>";
					windowHTML+="</div>";
					windowHTML+="</div>";
					$(document.body).append(windowHTML);
				} 
				options = options?options:{};
				/*3.��Ⱦ������Ϣ*/
				renderAiDebugWindow.call(this,message,options);
			},
			
			/**
			* �ڽ�������ʾ�������쳣��Ϣ
			* @param options-�쳣��Ϣ
			**/
			showErrorPage: function(/*JSON*/options){
				var _this = this;
				
				/*���ɽ����쳣��Ϣ����*/
				function createExcept(options){
					/**1.��ȡ�쳣��Ϣ*/
					var exceptType = options[this.settings.KEY_EXCEP_TYPE];
					var exceptMessage = options[this.settings.KEY_EXCEP_MESSAGE];
					var exceptDetail = options[this.settings.KEY_EXCEP_DETAIL];
					var exceptName = options[this.settings.KEY_EXCEP_NAME];
					var exceptTime = options[this.settings.KEY_EXCEP_TIME];
					var exceptPrintex = options[this.settings.KEY_EXCEP_PRINTEX];
					var operator = options[this.settings.KEY_OPERATOR];
					var exceptTime = new Date().toLocaleString();
					/**2.����������ʾ���HTML*/ 
					var errorPagTableHTML = "<div id=\"errorPageTable\" class=\"errorPageTable\">";
					errorPagTableHTML += " <table width=\"100%\" align=\"center\">";
					errorPagTableHTML += " <tr>";
					errorPagTableHTML += "<td valign=\"middle\" align=\"center\">";
					/***������ʾ����ͼƬ���� ��ʼ**/
					errorPagTableHTML += "<div class=\"float: left;width: 48px;height:70px;padding-left:2px;   \">";
					errorPagTableHTML += "<div class=\"messager-icon messager-error\"></div>";
					errorPagTableHTML += "</div>";
					/***������ʾ����ͼƬ���� ����**/
					/***������ʾ������������ ��ʼ**/
					errorPagTableHTML += "<div class=\"float: left;width: 228px;height:62px;padding-top:10px;text-align: left;text-indent: 24px;padding-left:20px;  \">";
					errorPagTableHTML+="<a name='x_error_pannel_anchor'></a>";
					errorPagTableHTML += "<table width=\"400\" height=\"60\">";
					errorPagTableHTML += "<tr>";
					errorPagTableHTML += "<td class='white-space: nowrap;' width='60'><b>������Ϣ:</b></td>";
					errorPagTableHTML += "<td>";
					errorPagTableHTML += " <font color='#D71920'>"+ exceptMessage + "</font>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					//errorPagTableHTML += "<tr>";
					//errorPagTableHTML += "<td class='white-space: nowrap;'><b>�쳣����:</b></td>";
					//errorPagTableHTML += "<td>";
					//errorPagTableHTML += " <font color='#D71920'>"+ exceptName +"</font>";
					//errorPagTableHTML += "</td>";
					//errorPagTableHTML += "</tr>";
					errorPagTableHTML += "<tr>";
					errorPagTableHTML += "<td class='white-space: nowrap;' width='60'><b>��ʾʱ��:</b></td>";
					errorPagTableHTML += "<td>";
					errorPagTableHTML += " <font color='#D71920' >"+ exceptTime +"</font>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					errorPagTableHTML += "<tr>";
					errorPagTableHTML += "<td class='white-space: nowrap;' width='60'><b>������Ա:</b></td>";
					errorPagTableHTML += "<td>";
					errorPagTableHTML += " <font color='#D71920'>"+ operator +"</font>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					errorPagTableHTML += "<tr align=\"right\">";
					errorPagTableHTML += "<td colspan=\"2\">";
					errorPagTableHTML += "<div id=\"button\">";
					errorPagTableHTML += " <a href=\"#x_error_pannel_anchor\" id=\"showDetailDialogHref\"><b>չ��\���� ��ϸ��Ϣ</b></a>";
					errorPagTableHTML += "</div>";
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>"; 
					errorPagTableHTML += "</table>";
					errorPagTableHTML += "</div>";
					/***������ʾ������������ ����**/
					errorPagTableHTML += "</td>";
					errorPagTableHTML += "</tr>";
					errorPagTableHTML += " </table>";
					
					/**������ϸ��Ϣ��ʾ���� ��ʼ*/
					errorPagTableHTML += "<div id=\"popupContact\" style=\"width:100%;display:none\">";
					errorPagTableHTML += "<b>������ϸ��Ϣ</b>";
					errorPagTableHTML += "<p id=\"contactArea\">";
					errorPagTableHTML += "ԭʼ��Ϣ��<br />";
					errorPagTableHTML += "<textarea style=\"width: 100%;height: 50px; no-repeat right top;border: 1px dotted #999666;\">"+ exceptMessage +"\n"+ exceptDetail +"</textarea> <br />";
					errorPagTableHTML += "�쳣��Ϣ��<br />";
					errorPagTableHTML += " <textarea style=\"width: 100%;height: 130px; no-repeat right top;border: 1px dotted #999666;\">"+ exceptPrintex +"</textarea>";
					errorPagTableHTML += "<br />"; 
					errorPagTableHTML += "</p>";
					errorPagTableHTML += "</div>";
					/**������ϸ��Ϣ��ʾ���� ����*/
					errorPagTableHTML += "</div>";  
					return errorPagTableHTML;
				}
				
				/*��Ⱦ������Ϣ*/
				function renderExceptWindow(options){
					var _this=this;
					$(_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).dialog({
						title :"ϵͳ�쳣",
						modal: true,
						width:500,
						shadow: false,
						closable: false
					});
					
					/*���¼�*/ 
					$("#showDetailDialogHref",_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).bind("click",function(){
						$("#popupContact",_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).toggle();
					})
					
					$(_this.settings.SELECTOR_AI_EXCEPTION_WINDOW).window("open");
				}
				
				/*1.��ȡ��ǰ�����ϵĴ�����Ϣ��ʾ����*/
				var xAiExceptWindow = $(_this.settings.SELECTOR_AI_EXCEPTION_WINDOW);
				/*2.��������ڣ���Ĭ�Ϲ���һ������*/
				if(!xAiExceptWindow.length){
					var windowHtml = "";
					var content = createExcept.call(_this,options);
					windowHtml+="<div id=\""+_this.settings.AI_EXCEPTION_WINDOW+"\" class=\"easyui-window\" style=\"padding:5px;\">";
					windowHtml+=content;
					windowHtml+="</div>";
					$(document.body).append(windowHtml);
				}
				/*3.��Ⱦ����*/
				renderExceptWindow.call(_this,options); 
			},
			/**
			* ��ͨ��ʾ
			* @param message:��ʾ��Ϣ
			* @param callFunc:�ص�����
			* @param args:�ص�������������
			*/
			alert: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"ȷ��",cancel:"ȡ��"};
				$.messager.alert('��ʾ',message,'alert',function(){
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* ������ʾ
			* @param message:��ʾ��Ϣ
			* @param callFunc:�ص�����
			* @param args:�ص�������������
			*/
			error: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"ȷ��",cancel:"ȡ��"};
				$.messager.alert('������ʾ',message,"error",function(){
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* ��Ϣ��ʾ
			* @param message:��ʾ��Ϣ
			* @param callFunc:���ú���
			* @param args:�ص�������������
			*/
			info: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"ȷ��",cancel:"ȡ��",closed:false};
				$.messager.alert('��ʾ',message,"info",function(){ 
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* ������ʾ
			* @param message:��ʾ��Ϣ
			* @param callFunc:���ú���
			* @param args:�ص�������������
			*/
			question: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"ȷ��",cancel:"ȡ��"};
				$.messager.alert('ȷ��',message,"question",function(){ 
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* ������ʾ
			* @param message:��ʾ��Ϣ
			* @param callFunc:���ú���
			* @param args:�ص�������������
			*/
			warning: function(message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"ȷ��",cancel:"ȡ��"};
				$.messager.alert('����',message,"warning",function(){ 
					maskUtilProcesser.showSelect();
					if(!args || args.constructor!=window.Array){
						args = arguments; 
					}
					callFunc && callFunc.apply(this,args); 
				});
			},
			/**
			* ȷ����Ϣ
			* @param message:��ʾ��Ϣ
			* @param callFunc:���ú���
			* @param args:���������б�
			**/
			confirm : function(/*String*/message,/*Function*/callFunc,/*Array*/args){
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"ȷ��",cancel:"ȡ��"}; 
				$.messager.confirm('ȷ��', message, function(r){ 
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
			* ȷ����Ϣ
			* @param message:��ʾ��Ϣ
			* @param options: ���ò���
			   {
			     okFunc: function(){},//ȷ����ť�ص�����
			     okArgs: [],//ȷ����ť�ص�����������
			   	 cancelFunc: function(){},//ȡ����ť�ص�����
			   	 cancelArgs: [],//ȡ����ť�ص�����������
			   }
			**/
			confirmNew: function(/*String*/message,/*JSON*/options){
				options = options ? options:{};
				/*ת�ƽ���*/
				//this.transferFocus();
				/*��ȡ����*/
				var args =  options.okArgs;
				var callFunc = options.okFunc;
				var cancelArgs= options.cancelArgs;
				var cancelFunc= options.cancelFunc;
				/*������ʾ����Ϣ*/
				maskUtilProcesser.hideSelect();
				$.messager.defaults={ok:"ȷ��",cancel:"ȡ��"}; 
				$.messager.confirm('ȷ��', message, function(r){ 
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
			/**ת�ƽ���*/
			transferFocus: function(){
				/*1.����һ��DIV*/
				var div="<div id='_x_div_focus_id' tabindex='-1'></div>";
				if(!$("#_x_div_focus_id").length){
					$(document.body).append(div);
				}
				/*2.ʹDIV��ȡ������*/
				if($("#_x_div_focus_id").length){
					$("#_x_div_focus_id").focus();
				} 
			}
		
		} 
	})
	
})(jQuery)

//ʵ����һ����Ϣ�������
var messageManager= new $.AilkMessageManager();

/***
* ����ҳ�潻����Ϣ������,�����������������Ϣ 
* @version 1.0
* @author zhangchao 
**/
(function($){
	/*����һ��ҳ�������*/
	$.PagDebug = function(){
		this.settings = $.extend(true,{},$.PagDebug.defaults);
	};
	/*��չһЩ�����뷽��*/
	$.extend($.PagDebug,{
		defaults : {
			
		},
		prototype : {
			
			/**
			* ���������Ϣ
			* @parent message:������־��Ϣ 
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

//ʵ����һ��ҳ����־������
var pagDebug = new $.PagDebug();

/***
* ����ҳ����ƴ�����,��������ҳ�潻������
* @version 1.0
* @author zhangchao 
**/
(function($){
	
	/*����ҳ�潻��������*/
	$.AilkPageInteractionManager = function(){
		this.settings = $.extend(true,{},$.AilkPageInteractionManager.defaults);
	}
	
	/*Ϊҳ�潻����������չ����,�� �̳з���*/
	$.extend($.AilkPageInteractionManager,{
		/*��չ����*/
		defaults: {
			AI_WAIT_DIALOG: "x_aiwait_dialog",//������ȶԻ����DIV ID
			SELECTOR_AI_WAIT_DIALOG: "#x_aiwait_dialog", // ������ȶԻ���ѡ����
			AI_DEBUG_WINDOW : "x_aidebug_window",//������Ϣ����DIV ��ʶ
			SELECTOR_AI_DEBUG_WINDOW: "#x_aidebug_window",//������Ϣ����ѡ����
			AI_DEBUG_TEXTAREA: "x_aidebug_textarea",//������Ϣ�����textarea
			SELECTOR_AI_DEBUG_TEXTAREA: "#x_aidebug_textarea", //������Ϣ�����textareaѡ����
			AJAX_SUBMIT_CONTAINER: "_X_AJAX_SUBMIT_CONTAINER_DIV",//�ڲ��ύ��AJAX����DIV��ʶ
			SELECTOR_AJAX_SUBMIT_CONTAINER: "#_X_AJAX_SUBMIT_CONTAINER_DIV",//�ڲ��ύ��AJAX����ѡ����
			AJAX_STATUS_SUCCESS: "1",//AJAX����ɹ�״̬
			AJAX_STATUS_FAILURE: "0",//AJAX����ʧ��״̬
			EXCEP_BUSINESS: "1",//ҵ���쳣
			EXCEP_SYSTEM: "2",//ϵͳ�쳣
			EXCEP_TYPE: "EXCEP_TYPE",//�쳣���� 1-ҵ���쳣  2-ϵͳ�쳣
			EXCEP_PRINTEX: "EXCEP_PRINTEX",//�쳣��Ϣ��ջKEY
			SHOW_DETAIL: "SHOW_DETAIL",//������ʾ�У��Ƿ��в鿴��ϸ����
			STATUS_CODE: "STATUS_CODE",//��Ӧ��appframe5.5��װ���Զ�����ϢCustomProperty��״̬keyֵ
			STATUS_INFO: "STATUS_INFO",//��Ӧ��appframe5.5��װ���Զ�����ϢCustomProperty��״̬������Ϣkeyֵ
			RETURN_INFO: "RETURN_INFO", //AJAXִ�гɹ����RETURN_INFO����
			RETURN_INFO_TYPE: "RETURN_INFO_TYPE", //AJAXִ�гɹ����RETURN_INFO����������Ϣ����
			RETURN_INFO_DATA: "RETURN_INFO_DATA", //AJAXִ�гɹ����RETURN_INFO����������Ϣ����
			RETURN_INFO_TYPE_BUSI_VALID:"BUSI_VALID" //���ص�����������ҵ��У����Ϣ
		},
		
		/*�̳�ԭ�͵ķ���*/
		prototype: {
			
			/**
			* ����iframeҳ����Ϣ
			* @param:iframe --iframeѡ����
			* @param:url --��iframe�ڼ��ص�url
			* @param:options -json��ʽ������Ĳ�����ֵ��.<br>
			  �����Ĳ�����{
			  	showBusi�� true/false, //�Ƿ���ʾ���������
			  	modal: true/false,//����������֣��Ƿ�ģ̬��ʽ����
			  	message: "xx"//������Ϣ
			  } 
			**/
			loadIframe: function(/*selector*/iframe,/*String*/url,/*json*/options){
				/*1.��ȡ�Ƿ���ʾ���������,������Ϣ���Ƿ�����*/
				var showBusi = options && options.showBusi?true:false;
				var modal = options && options.modal?true:false;
				var message = options && options.message ? options.message: "ҳ�����ڼ��أ����Ժ�..";
				/*2.�������ʾ���������������ʾ*/
				if(showBusi)messageManager.showWait({ message:message,modal: modal});
				/*3.����URL*/
				$(iframe).attr("src",url);
				/*4.����ҳ���Ƿ������ϣ������ϣ�������������ؽ�����Ϣ��*/
				$(iframe).load(function(){
					if(showBusi)messageManager.hideWait();
				})
			},
			
			/**
			* Ajax���󷽷�
			* @param options:������Ϣ
			* based on jquery.form.js
			**/
			goAjax: function(/*JSON*/options){
				var _this = this;
				/*1.ת�����ֻص�����*/
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
				/*2.��ȡ�ύ��ʽ,���û��ָ����Ĭ����request*/
				var postmode = options.postmode?options.postmode:"request";
				/*3.��ȡ������Ϣ��ص���Ϣ*/
				//��ȡ�Ƿ���ʾ������� ���û���ã�����ʾ
				var showBusi = options && options.showBusi==true?true:false;
				//��ȡ��Ϣ������ȿ��Ƿ�����,��������ã�Ĭ��Ϊ������
				var modal = options && options.modal==true?true:false;
				//��ȡ��Ϣ������ȿ�����ʾ����ʾ��Ϣ
				var message = options && options.message ? options.message: "���ڴ����У����Ժ�..";
				//����һ����Ϣ����
				var msgManager = options.showArea=='parent'?parent.messageManager : messageManager;
				/*4.����һ���µĲ���ֵ����Ϣ���̳������ز���*/
				var settings = {}; $.extend(settings,options); 
				
				/*5.ʵ��һЩjquery.form.jsԭ���Ļص�����*/
				/**
				* ʵ��ajax��˴���ɹ���Ļص�����
				* @param transport:ָajax��׽�ķ���˷��ص���Ϣ
				**/
				settings["success"] = function(transport){ 
					//�رս�����
					if(showBusi)msgManager.hideWait();
					
					/*5.1 �����жϷ���ֵ�Ƿ���JSON��ʽ*/
					var returnObj = dataProcesser.parseJSON(options.dataType,transport);
					if(returnObj){ 
						/*5.1.1 ��ȡ�ض��Ĵ���״ֵ̬*/
						var status = returnObj[_this.settings.STATUS_CODE];
						var statusInfo = returnObj[_this.settings.STATUS_INFO];
						var excepType = returnObj[_this.settings.EXCEP_TYPE];
						/*5.1.2 ����״̬����д���*/
						if(status && status == _this.settings.AJAX_STATUS_FAILURE){
							/*���״̬��Ϊʧ�ܣ���ص�failure����*/ 
							var sessionInvalid = returnObj["_SESSION_INVALID_"]?returnObj["_SESSION_INVALID_"]:"1";
							var redirectURL = returnObj["_REDIRECT_URL_"];
							if(sessionInvalid == "0"){
								window.location=redirectURL;
								return false;
							}
							/*��װ��ʾ����ϸ��Ϣ*/
							var randTime = new Date().getTime();
							var showDetail = returnObj[_this.settings.SHOW_DETAIL];
							var info = showDetail?"����ʧ��(<a href='#x_alert_message_anchor' id='_frame_href_alert_message_"+ randTime +"' title='����鿴��ϸ'><b>����</b></a>)��"
								:"";
							info = statusInfo? info+statusInfo:info+"��鿴��ϸ������ϵ����Ա���"; 
							if(_this.settings.EXCEP_SYSTEM==excepType){
								//ϵͳ���쳣��ʾ		
								msgManager.warning(info,function(){
									callbacks["failure"] && callbacks["failure"].call(this);  
								});  
							}else{
								//ҵ���쳣��ʾ		
								msgManager.info(info,function(){
									callbacks["failure"] && callbacks["failure"].call(this);  
								});
							}
							/*�󶨲鿴��ϸ�¼�*/
							$("#_frame_href_alert_message_"+ randTime +"").bind("click",function(){
								var excepPrintex = returnObj[_this.settings.EXCEP_PRINTEX];
								msgManager.showLogInfo(excepPrintex,{
									title: "��ϸ������Ϣ",
									width: 750,
									height: 400,
									clear: true
								});
							})    
						}else{
							/*���״̬��Ϊ�ɹ�����ص�success����*/
							var returneInfo = returnObj[_this.settings.RETURN_INFO]; 
							if(returneInfo && dataProcesser.isJson(returneInfo) && _this.settings.RETURN_INFO_TYPE_BUSI_VALID==returneInfo[_this.settings.RETURN_INFO_TYPE] ){ 
								//�����ҵ��У����Ϣ������д���
								var returndata = returneInfo[_this.settings.RETURN_INFO_DATA]; 
								var validateBusiFrame =new $.ValidateBusiFrame(returndata); 
								var info=validateBusiFrame.info({
									title: settings.busiValidTitle,
									infolabel:settings.busiValidLabel, 
									failure:function(){ 
										//У�鲻ͨ���Ĵ���
										settings["busiFailure"] && settings["busiFailure"].call(this); 
									},
									success: function(){ 
										//У��ͨ���Ĵ���
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
						pagDebug.debug("���������ݸ�ʽ��JSON  \r\n���������ݡ�\r\n"+JSON.stringify(returnObj));
						return false;
					}
					/*5.2 �жϷ���ֵ�Ƿ���XML��ʽ*/
					var returnObj = dataProcesser.parseXML(options.dataType,transport);
					if(returnObj){
						/*5.2.1 ����appframe5.5 ���� api��ȡ�û��ڵ���Ϣ*/
						var xmlNode = transport.documentElement;
						var ud = createUserDataClass(xmlNode,true); 
						/*5.2.2 ��ȡ����״̬*/
						var status = ud.getValueByName(_this.settings.STATUS_CODE);
						var statusInfo = ud.getValueByName(_this.settings.STATUS_INFO);
						if(status && status == _this.settings.AJAX_STATUS_FAILURE){
							/*���״̬��Ϊʧ�ܣ���ص�failure����*/
							var info = statusInfo?"����ʧ��,������Ϣ:"+statusInfo+"":"����ʧ�ܣ�����ϵ����Ա���";
							msgManager.warning(info,function(){
								callbacks["failure"] && callbacks["failure"].call(this);  
							});   
						}else{
							/*���״̬��Ϊ�ɹ�����ص�success����*/
							callbacks["success"] && callbacks["success"].call(this,transport);
						}
						pagDebug.debug("���������ݸ�ʽ��\r\nxml \r\n���������ݡ�\r\n"+xmlNode.xml);
						return false;
					}
					
					/*5.3 �������ݸ�ʽ*/
					pagDebug.debug("���������ݸ�ʽ��\r\ntext \r\n���������ݡ�\r\n"+transport);
					if(postmode=="update")$(target).html(transport);
					callbacks["success"] && callbacks["success"].call(this,transport);
				};
				/**
				* ʵ��ajax����ǰ�ľ���������������Ϊfalse,����ֹ���� 
				**/
				settings["beforeSubmit"] = function(){ 
					return callbacks["before"] && callbacks["before"].call(this);  
				};
				/**
				* ����ʧ�ܺ�Ļص���������404�����
				* һ��ָ���������쳣���������һ������������
				**/
				settings["error"] = function(transport){  
					/*1.�رմ��������Ϣ*/
					if(showBusi)msgManager.hideWait();
					/*2.���ȷ����ִ�лص�����*/ 
					msgManager.error("�����������,������:"+transport.status+",�����ԡ�",function(){
						callbacks["error"] && callbacks["error"].call(this,transport);
					});  
				};
				
				/*6.��������*/
				//��������Ч��
				if(showBusi)msgManager.showWait({ message:message,modal: modal,width: options.width,height: options.height});
				//�������ݲ��ֵĴ���
				settings.data=options.data?options.data:{};
				var q="url_source=AilkPageInteractionManager";
				settings.url += (settings.url.indexOf('?') >= 0 ? '&' : '?') + q;
				/**���ύ������������д���*/
				if(options.postselectors && options.postselectors.length==1){ 
					/*������ύ�����������ڣ����ҽ���ֻ��һ���������κδ���ֱ�ӽ����ύ*/
					settings.semantic=true; 
					var postContainerSelector=options.postselectors[0]; 
					if($(postContainerSelector).length){
						$(postContainerSelector).ajaxSubmit(settings);
					}else{
						_this.processCombineParamContainer(options.postselectors);
						$(this.settings.SELECTOR_AJAX_SUBMIT_CONTAINER).ajaxSubmit(settings);
					}
					
				}else{
					/*������ύ�������������ڣ����ߴ��ڶ��Ҵ��ڶ�����򴴽�һ��������ύ������Ϊ�ύ����*/
					settings.semantic=true;
					/**�����������*/
					_this.processCombineParamContainer(options.postselectors);
					$(this.settings.SELECTOR_AJAX_SUBMIT_CONTAINER).ajaxSubmit(settings);
				}  
			}, 
			/**
			* �ϲ��������ύ�Ĳ�������
			* @param postContainerSelectors: ��Ҫ�����ύ������ѡ��������
			**/
			processCombineParamContainer: function(/**Array*/postContainerSelectors){
				/**1.����һ����������*/
				this.createSubmitContainer();
				var submitContainer = $(this.settings.SELECTOR_AJAX_SUBMIT_CONTAINER);
				/**3.���������ύ����������*/
				if(postContainerSelectors && $.isArray(postContainerSelectors)){
					$(postContainerSelectors).each(function(index,selector){
						if($(selector).length){
							$(selector).clone().prependTo(submitContainer);
						} 
					}); 
				}  
			},
			
			/**����һ����������**/
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

//ʵ����һ��ҳ�潻��ʵ������
var formPag = new $.AilkPageInteractionManager();

/**
* ����һЩjavascript���ݴ�����
* ���ڶ�xml��json,text�ȸ�ʽ�����ݽ��д���
**/
(function($){
	/*����һ�����ݴ�����*/
	$.DataProcesser = function(){
		this.settings = $.extend(true,{},$.DataProcesser.defaults);
	}
	/*��չһЩ�����뷽��**/
	$.extend($.DataProcesser,{
		defaults: {
		},
		
		prototype: {
			
			/**
			* �ж��Ƿ���JSON��ʽ,����data������json����
			* �������json���󣬷���false,�����json������ֱ�ӷ���
			* @param dataType: $.ajax�ܶ���ķ�����������
			* @param data:δ֪����������
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
			* �ж��Ƿ���JSON��ʽ
			* �������json���󣬷���false,�����json������true
			* @param obj:δ֪����������
			*/
			isJson: function(obj){
				var isjson = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length;    
				return isjson;
			},
			/**
			* �ж��Ƿ���xml��ʽ,����data������xmldocument����
			* ����Ƿ���xmldocument�� ���򷵻�false
			* @param dataType: $.ajax�ܶ���ķ�����������
			* @param data:δ֪����������
			*/
			parseXML: function(dataType,data){ 
				var isXml = this.isXMLDoc(data);
				return isXml?data:false; 
			},
			/**
			* �ж��Ƿ���xml��ʽ
			* ����Ƿ���true�� ���򷵻�false
			* @param obj:δ֪����������
			*/
			isXMLDoc: function(obj){
				return $.isXMLDoc(obj);
			}
		}
	})

})(jQuery)

//����һ�����ݴ���ʵ��
var dataProcesser = new $.DataProcesser();


//����һ�����ݴ���ʵ��
var dataProcesser = new $.DataProcesser();

/**
* �����������
* @author zhangchao
**/
(function($){
	
	/*����һ������������*/
	$.AiCascader = function(){
		this.settings = $.extend(true,{},$.AiCascader.defaults);
	}
	
	/*�Լ��������ඨ�����������뷽��*/
	$.extend($.AiCascader,{
		/*Ĭ������*/
		defaults: {
			OPTION_LABEL : "label", //ѡ��ֵ������ֵ
			OPTION_VALUE : "value" //ѡ��ֵ��ֵ
		},
		/*ԭ�ͷ���*/
		prototype: {
			/*��ʼ������*/
			init: function(){
			
			},
			/**
			* ����ѡ���
			* @options: json���ò��� {}
			* ������:
			* url: Զ�������Ŀ��URL,��URL���뷵��Ŀ�������б�Ŀ�ѡֵJSONArray {label:xx,value:xx}
			* remote: true/false  �Ƿ�Զ������
			* data: {}  Զ���������Ĳ���
			* optionData:��̬����ֵ json���飬��ʽΪ{label:xxx,value:xx}
			* targetSelect: ������Ŀ�������б����
			* defaultValue: ������Ŀ�������б��Ĭ��ֵ�б�
			* defaultValues: ������Ŀ�������б��Ĭ��ֵ�б�
			* showBusi: true/false �Ƿ���ʾ���������
			* message: �������������Ϣ
			* isShowAll: true/false �Ƿ���ʾȫ��ѡ��
			* labelAll: 'ȫ��' //ȫ��ѡ������
			* valueAll: ȫ��ѡ��ֵ
			* success: fn Ŀ�������б�����ɹ���Ļص�����
			* failure: fn Ŀ�������б�����ʧ�ܺ�Ļص�����
			*/
			cascadeSelect: function(/*JSON*/options){
				options =  options?options:{};
				/*�Ƿ�Զ�̼��ر��,���û���趨����Ĭ��Ϊtrue*/
				var remote = options.remote && options.remote==true ? true:false;
				/*Զ������url���url�����ڣ���Զ��������Ϊfalse*/
				var url = options.url?options.url:"";
				if(url=="")remote = false;
				/*Ŀ�������б�*/
				var targetSelect = options.targetSelect;
				if(!targetSelect){
					messageManager.alert("û��ָ����ˢ�µ�������");
					return false;
				}
				/*Ŀ�������б�ľ�̬����*/
				var optionData =  options.optionData?options.optionData:[];
				/*Ĭ��ֵ�б�����ѡʱ��ʹ��*/
				var defaultValues =  options.defaultValues?options.defaultValues:[];
				var defaultValue = options.defaultValue?options.defaultValue:false;
				if(defaultValue)defaultValues.push(defaultValue);
				/*�첽Զ������ʱ��Ľ�����Ϣ��Ϣ*/
				var message = options.message?options.message:"�����������ݣ����Ժ�...";
				/*�Ƿ���ʾȫ��*/
				var isShowAll = options.isShowAll?options.isShowAll:false;
				/*��ʾȫ��ѡ��ı�ǩ*/
				var labelAll = options.labelAll?options.labelAll:"ȫ��";
				/*��ʾȫ��ѡ��ı�ǩֵ*/
				var valueAll = options.valueAll?options.valueAll:"";
				
				if(!remote){
					if(isShowAll){
						var alloption = {label:labelAll,value:valueAll};
						/*����ͷ������*/
						optionData.unshift(alloption);
					} 
					/*�������Զ�̶�ȡ�����ȡ��̬�����б���Ϣ*/	
					this.refreshOptions(targetSelect,optionData,defaultValues);
					return;
				}
				var _this = this;
				/*�����Զ�����룬�����AJAXԶ������*/
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
							/*����ͷ������*/
							optionData.unshift(alloption);
						} 
						//ˢ�½���б�
						_this.refreshOptions(targetSelect,optionData,defaultValues);
						//ִ�лص���������
						options["success"] && options["success"].call(this,transport);
					},
					failure: function(transport){
						//ִ��ʧ�ܺ�Ļص�����
						options["failure"] && options["failure"].call(this,transport);
					}
				});  
			},
			/**
			* ��ʼ��������̬ѡ������
			* @param targetSelect:Ŀ�������б�
			* @param options: Ŀ�������б������ѡ����Ϣ 
			**/
			initOptions: function(targetSelect,options){
				/*Ŀ�������б�ľ�̬����*/
				var optionData =  options.optionData?options.optionData:[];
				/*Ĭ��ֵ�б�����ѡʱ��ʹ��*/
				var defaultValues =  options.defaultValues?options.defaultValues:[];
				var defaultValue = options.defaultValue?options.defaultValue:false;
				if(defaultValue)defaultValues.push(defaultValue); 
				/*�Ƿ���ʾȫ��*/
				var isShowAll = options.isShowAll?options.isShowAll:false;
				/*��ʾȫ��ѡ��ı�ǩ*/
				var labelAll = options.labelAll?options.labelAll:"ȫ��";
				/*��ʾȫ��ѡ��ı�ǩֵ*/
				var valueAll = options.valueAll?options.valueAll:"";
				
				if(isShowAll){
					var alloption = {label:labelAll,value:valueAll};
					/*����ͷ������*/
					optionData.unshift(alloption);
				} 
				
				this.refreshOptions(targetSelect,optionData,defaultValues);
			},
			/**
			* ˢ��Ŀ�������б�ֵ
			* @param targetSelect:Ŀ�������б�
			* @param optionData: Ŀ�������б��ѡ����Ϣ[{label:xx,value:xx}]
			* @param defaultValues:Ŀ�������б��ѡֵ
			**/
			refreshOptions: function(targetSelect,optionData,defaultValues){	
				var _this=this;
				/*1.�������ѡ��*/
				_this.clearOptionAll(targetSelect);
				/*2.������������б�����*/
				$(optionData).each(function(index,d){
					_this.addOption(targetSelect,d.label,d.value);
				})
				/*3.����ѡ����*/
				$(defaultValues).each(function(index,d){
					_this.setOptionSelected(targetSelect,d);
				})
			},
			/**
			* ���Ŀ�������б�ֵ
			* @param targetSelect:Ŀ�������б�
			**/
			clearOptionAll: function(targetSelect){
				if(!$(targetSelect).length)return;
				$(targetSelect).get(0).options.length = 0;
			},
			/**
			* ��������б�ֵ
			* @param targetSelect:Ŀ�������б�
			* @param label:�ı�����
			* @param value: ֵ
			**/
			addOption: function(targetSelect,label,value){
				if(!$(targetSelect).length)return;
			    $(targetSelect).get(0).options.add(new Option(label,value));
			},
			/**
			* ����ָ��������ѡ��Ϊѡ��
			* @param targetSelect:Ŀ�������б�
			* @param value: ֵ
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
			* �ж�ѡ���Ƿ��Ѿ�����
			* @param targetSelect:Ŀ�������б� 
			* @param value: ֵ
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

//����һ����������
var cascader = new $.AiCascader();

/**
 * ���ָ�����
 * �������ҳ����ʾ������
 * @author zhangchao
 */
(function($){
	
	/*����һ�����ָ�����*/
	$.MaskUtilProcesser = function(){
		this.settings = $.extend(true,{},$.MaskUtilProcesser.defaults);
	}
	
	$.extend($.MaskUtilProcesser,{
		/*Ĭ������*/
		defaults: {
		}, 
		/*Ĭ�Ϸ���*/
		prototype: {
			/*��IE6����������������пɼ���������*/
			hideSelect: function(){
				/*�ж��Ƿ���IE6��������ǣ��򲻴���*/
				var isIE6 = $.browser.msie && /msie 6\.0/i.test(navigator.userAgent);
				if(!isIE6)return;
				/*��ȡ���д�����ʾ״̬��SELECT���洢������*/
				if($("select:visible").length){ 
					this.hideSelects = $("select:visible");
					$("select:visible").hide();
				}
			},
			/*��IE6�����������ʾ֮ǰ���ص�����������*/
			showSelect: function(){
				/*�ж��Ƿ���IE6��������ǣ��򲻴���*/
				var isIE6 = $.browser.msie && /msie 6\.0/i.test(navigator.userAgent);
				if(!isIE6)return;
				/*��ȡ���д�����ʾ״̬��SELECT���洢������*/
				if(this.hideSelects && this.hideSelects.length){
					this.hideSelects.show();
				} 
			}
		}
	})
	
})(jQuery);

//����һ�����ָ���������
var maskUtilProcesser = new $.MaskUtilProcesser(); 

(function($){
	
	/*����һ���������봦����*/
	$.InputLimitProcessor = function(inputObj,showObj,limiteNumber,options){
		this.inputObj = inputObj;
		this.showObj = showObj;
		this.limiteNumber = limiteNumber; 
		this.settings = $.extend(true,{},$.MaskUtilProcesser.defaults,options?options:{});
		this.init();
	}
	
	/*��չ����������*/
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

