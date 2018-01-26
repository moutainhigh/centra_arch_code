(function($){
	 
	$.PaginationTag = function(gridContainer, url, parameterContainer, pageInfo){
		this.settings = $.extend(true,{},$.PaginationTag.defaults);
		this.gridContainer = gridContainer;
		this.url = url;
		this.parameterContainer = parameterContainer;
		this.pageInfo = pageInfo;
	}
	
	$.extend($.PaginationTag,{
		defaults : {
			BTN_GO_FIRST: "#goFirst",
			BTN_GO_PRE: "#goPre",
			BTN_GO_NEXT: "#goNext" ,
			BTN_GO_LAST: "#goLast" ,
			CLASS_GO_FIRST: "goFirst",
			CLASS_GO_PRE: "goPre",
			CLASS_GO_NEXT: "goNext" ,
			CLASS_GO_LAST: "goLast" ,
			CLASS_GO_FIRST_DISABLED: "goFirstDisabled",
			CLASS_GO_PRE_DISABLED: "goPreDisabled",
			CLASS_GO_NEXT_DISABLED: "goNextDisabled" ,
			CLASS_GO_LAST_DISABLED: "goLastDisabled" ,
			CLASS_GO_PAGE: "goPage",
			BTN_GO : "#goPage",
			TEXT_PAGE_NO : "#pageNoTxt",
			CLASS_CURSORHAND: "crusorHand",
			CLASS_NOTALLOWED: "cursorNotAllow"
		},
		prototype :{ 
			/*��ʼ����ҳ��ǩ*/
			doTag : function(){
				var _this = this;
				var pageNo = _this.pageInfo.pageNo;
				var pageCount = _this.pageInfo.pageCount;
				var gridContainer = $(_this.gridContainer);
				if(!gridContainer.length){
					alert("��ҳ�ؼ���ʼ������û��ָ����ҳ�ؼ����ڵ�����");
					return;
				}
				//�����ǰҳ��Ϊ��һҳ������ҳ����һҳ������
				if(pageNo <= 1 ){
					//��ҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_FIRST).addClass(_this.settings.CLASS_GO_FIRST_DISABLED).addClass(_this.settings.CLASS_NOTALLOWED);
					//��һҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_PRE).addClass(_this.settings.CLASS_GO_PRE_DISABLED).addClass(_this.settings.CLASS_NOTALLOWED); 
				}
				//�����ǰҳ�����1����Ϊ��һҳ����ҳ�󶨰��¼�
				if(pageNo > 1 ){
					//��ҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_FIRST).addClass(_this.settings.CLASS_GO_FIRST).addClass(_this.settings.CLASS_CURSORHAND).bind("click",function(){
						_this.go(1); 
					});
					//��һҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_PRE).addClass(_this.settings.CLASS_GO_PRE).addClass(_this.settings.CLASS_CURSORHAND).bind("click",function(){
						_this.go(pageNo - 1); 
					}); 
				}
				//�����ǰҳС����ҳ������Ϊ��һҳ�����һҳ��ť��ʱ��
				if(pageNo < pageCount){ 
					//��һҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_NEXT).addClass(_this.settings.CLASS_GO_NEXT).addClass(_this.settings.CLASS_CURSORHAND).bind("click",function(){
						_this.go(pageNo + 1);
					}); 
					//���ҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_LAST).addClass(_this.settings.CLASS_GO_LAST).addClass(_this.settings.CLASS_CURSORHAND).bind("click",function(){
						_this.go(pageCount); 
					});
				}
				//�����ǰҳ��Ϊ���һҳ������һҳ��ĩҳ������
				if(pageNo == pageCount || pageCount<1){ 
					//��һҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_NEXT).addClass(_this.settings.CLASS_GO_NEXT_DISABLED).addClass(_this.settings.CLASS_NOTALLOWED);
					//���ҳ��ť�¼�
					gridContainer.find(_this.settings.BTN_GO_LAST).addClass(_this.settings.CLASS_GO_LAST_DISABLED).addClass(_this.settings.CLASS_NOTALLOWED);
				}
				//Ϊҳ����ת��ť���¼�
				gridContainer.find(_this.settings.BTN_GO).addClass(_this.settings.CLASS_GO_PAGE).bind("click",function(){
					//��ȡ�趨��ҳ��
					var gotoPageText = gridContainer.find(_this.settings.TEXT_PAGE_NO);
					var gotoPageNo = gotoPageText.val();
					if(!gotoPageNo.match(/^[0-9]*[1-9][0-9]*$/) || parseInt(gotoPageNo) > pageCount || parseInt(gotoPageNo) < 1){
						alert("����ֵ����Ϊ����0С�ڻ����" + pageCount + "��������");
						gotoPageText.focus();
						return false;
					}
					_this.go(gotoPageNo);
				}) 
			},
			/**��ת��ָ����ҳ��*/
			go: function(pageNo){
				var _this = this; 
				formPag.goAjax({
					type:"POST", 
					url:_this.url,
					showBusi: true,
					modal: true,
					message: "���ڴ����У����Ժ�...", 
					postselectors: [_this.parameterContainer],
					postmode: "update",
					target: _this.gridContainer,
					data: {pageNo:pageNo},
					success:function(transport){  
						
					}
				});
			}
		} 
	});
})(jQuery);
