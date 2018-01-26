package com.ifudata.ums.system.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Title: ums-CRM <br>
 * Description: 订单模块静态变量<br>
 * Date: 2014年3月11日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author zhangfan
 */
public class ConstantsOrder {
    
    //缴费渠道
    public static class PAY_CHANNEL{
        //网上营业厅收款
        public static final String PAY_CHANNEL_RECEIVE = "2";
        //网上营业厅充值缴费
        public static final String PAY_CHANNEL_RECHARGE = "4";
    }
    
    /**
     * 
     * Title: ums-CRM <br>
     * Description: 订单模块——请求跳转路径<br>
     * Date: 2014年3月11日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author zhangfan
     */
    public static class ORDER_REQUEST_PATH{
        
        //订单提交后页面，入口：开户点击提交订单
        public static final String ORDER_AFTER_COMMIT = "order/orderAfterCommit";
        
        //订单提交后页面，入口：订单处理模块点击处理按钮，状态为待支付
        public static final String ORDER_AFTER_COMMIT1 = "order/orderAfterCommit1";
        
        //订单处理界面
        public static final String ORDER_OPERATE = "order/orderOperate";
        
        //订单查询
        public static final String ORDER_ORDERLIST = "order/orderList";
        
        //订单待处理查询
        public static final String ORDER_HANDLELIST = "order/handleList";
        
        //受理订单查询
        public static final String ORDER_ACCEPTLIST = "order/acceptList";
        
        //自提查询
        public static final String ORDER_AUTOLIST = "order/autoList";
        
        //退费查询
        public static final String ORDER_PAYBACKLIST = "order/payBackList";
        
        public static final String ORDER_PRINTORDER = "order/printOrder";
        
        public static final String ORDER_SOURCE = "order/orderSource";
        //受理单详情
        public static final String ORDER_APPLY_QUERY = "order/orderApplyQuery";
        
        public static final String ORDER_PACKAGE = "order/orderPackage";
      //支付完成
        public static final String ORDER_PAYOVER = "order/payOver";
    }
  /*
     * 订单权限
     * @author root
     *
     */
    public static class ORDER_RIGHT_ID{
    	 //审核权限
    	 public static final String AUDIT= "100001";
    	 //资源调配权限
    	 public static final String PREPARE_GOODS = "100002";
    	 //商品出库权限
    	 public static final String OUT_STORE = "100003";
    	 
    	 public static  Map<String, String> RIGHT_MAP(){
     		Map<String, String> map=new HashMap<String, String>();
     		map.put("AUDIT", AUDIT);
     		map.put("PREPARE_GOODS", PREPARE_GOODS);
     		map.put("OUT_STORE", OUT_STORE);
     		return map;
     	}
    }
    
    /**
     * 配货生产界面需要的状态
     * 三个字段，用 _ 分割,分别代表资源类型、是否有、是否校验过
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年3月13日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author zhangfan
     */
    public static class ORDER_RES_DISPLAY{
        
        /**
         * 终端_有_未校验过
         */
        public static final String MATER_Y_N = "10";
        /**
         * 终端_有_且校验过
         */
        public static final String MATER_Y_Y = "11";
        /**
         * 终端_无_未校验过
         */
        public static final String MATER_N_N = "00";
        
        /**
         * 卡号_有_且校验过
         */
        public static final String CARD_Y_Y = "11";
        
        /**
         * 卡号_有_未校验过
         */
        public static final String CARD_Y_N = "10";
        
        public static  Map<String, String> RES_STATE_MAP(){
            Map<String, String> map=new HashMap<String, String>();
            map.put("MATER_Y_N", MATER_Y_N);
            map.put("MATER_Y_Y", MATER_Y_Y);
            map.put("MATER_N_N", MATER_N_N);
            map.put("CARD_Y_Y", CARD_Y_Y);
            map.put("CARD_Y_N", CARD_Y_N);
            return map;
        }
    }
    
    public static class METERIAL_TYPE{
        
        public static final String TYPE_TERMINAL = "1";
        public static final String TYPE_GIFT_MANAGE = "2";
        public static final String TYPE_GIFT_NO_MANAGE = "3";
    }
    
    /**
     * 
     * Title: ums-CRM <br>
     * Description: 订单详情纵表<br>
     * Date: 2014年3月19日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author zhangfan
     */
    public static class ORDER_EXTEND{
        
        //扩展表中type为10的是资源预占流水
        public static final String ATTR_TYPE_RESERVED = "10";
        //号码预占ID
        public static final String ATTR_ID_NUMBER = "NUMBER_OCCU_NO";
        //卡预占ID
        public static final String ATTR_ID_CARD = "CARD_OCCU_NO";
        //卡预占ID
        public static final String ATTR_ID_MAT = "MATERIAL_OCCU_NO";
        //有记录的为新客户
        public static final String ATTR_TYPE_NEW_CUST = "SYNC_BILLING";
        //有记录的为新客户
        public static final String ATTR_ID_NEW_CUST = "SYNC_BILLING_NEW_CUST";
    }
    
    public static class SOURCE_CHECK_STATE{
        //需要校验，还未校验
        public static final String STATE_UNCHECKED = "0";
        //已校验
        public static final String STATE_CHECKED = "1";
        
        //2代表没有该校验类型，一般是没有终端校验
        public static final String STATE_NONE  = "2";
        
        //卡预占类型，配货为10
        public static final String CARD_OCCU_TYPE = "10";
        
        //号预占类型，销售为2
        public static final String NUMBER_OCCU_TYPE  = "2";
        
        //返回出库结果成功为1
        public static final String STATE_OUT_OK = "1";
        //返回出库结果失败为0
        public static final String STATE_OUT_UN = "0";
        
        public static final String MATERIAL_TYPE = "1";
        
        //校验位,第一位为号卡，第二位为终端；
        //1表示配货，0表示无需配货。
        //举例说明：10表示需要配卡和号，无需配置终端；11表示卡号、终端都需要调配
        public static final String PREPARE_CARDNUM = "10";
        
        public static final String PREPARE_CARDNUM_MAT = "11";
        
        public static final String PREPARE_NONE = "00";
        
        public static final String PREPARE_MAT = "01";
    }
    /**
     * 分页信息
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年5月4日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author chenrui
     */
    public static class PAGE_INFO{
        
        public static final int PAGE_START = 1;
        public static final int PAGE_SIZE = 10;
        
    }
}
