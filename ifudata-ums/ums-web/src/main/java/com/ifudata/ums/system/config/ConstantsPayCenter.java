package com.ifudata.ums.system.config;

/**
 * 支付中心常量定义
 * Title: ums-CRM <br>
 * Description: <br>
 * Date: 2015年7月20日 <br>
 * Copyright (c) 2015 ifudata <br>
 * 
 * @author fanpw
 */
public class ConstantsPayCenter {

    /**
     * 
     * Title: ums-CRM <br>
     * Description: 支付状态<br>
     * Date: 2015年6月18日 <br>
     * Copyright (c) 2015 ifudata <br>
     * 
     * @author fanpw
     */
    public static class Status {
        /*状态包括：
        -1：申请支付
         1：待支付（向第三方支付发起支付）；
         2：支付交易成功
         3：支付失败
         4、支付成功，交费或充值失败
         6、支付成功：支付成功后立即改成这个状态。调EOP之前已经是6了。
         7、银行退款成功，回调失败
         8、退款成功
         9、退款失败
        10、退款到账
        11、提现成功
        12、提现失败
     */
     public static final String CREATE = "-1";
     public static final String WAIT_BUYER = "0";
     public static final String APPLY = "1";
     public static final String PAYED_SUCCESS = "2";
     public static final String PAYED_FAILED = "3";
     public static final String PAYED_SUCCESS_RECHARGE_FAIL = "4";
     public static final String PAYED_SUCCESS_WAIT_RECHARGE = "6";
     public static final String REFUND_SUCCESS_NOTIFY_FAIL = "7";
     public static final String REFUND_SUCCESS = "8";
     public static final String REFUND_FAIL = "9";
     public static final String REFUND_FINISH = "10";
     public static final String TAKE_SUCCESS = "11";
     public static final String TAKE_FAIL = "12";
     
    }
    
    /**
     * 
     * Title: ums-CRM <br>
     * Description: 支付请求来源<br>
     * Date: 2015年6月25日 <br>
     * Copyright (c) 2015 ifudata <br>
     * 
     * @author fanpw
     */
    public static class PayChannel {
        //优酷支付
        public static final String YK = "10";
        
    }
    
    /**
     * 
     * Title: ums-CRM <br>
     * Description: 支付请求类型<br>
     * Date: 2015年6月25日 <br>
     * Copyright (c) 2015 ifudata <br>
     * 
     * @author fanpw
     */
    public static class PayRequestType {
        //虚商代扣
        public static final int MVNEPAYMENT = 4;
        //虚商退费
        public static final int MVNEREFUND = 5;
        
    }
    
    /**
     * 支付方式
     * Title: PAYMENT-PLATFORM <br>
     * Description: <br>
     * Date: 2015年1月20日 <br>
     * Copyright (c) 2015 ifudata <br>
     * 
     * @author LiangMeng
     */
    public static class PAY_TYPE{
        
        /**
         * 1、现金；2、网上支付;9、支票支付*  10、转账汇款;11、银行卡代扣;12、银行卡托收;
         * 20、网付通;21、支付宝；22、银联；
         * 23、鸿支付；24、微信支付;25:优酷支付;26:畅捷支付；3、充值卡；
         * 4、赠送预存；5、积分；6、银行卡(POS)；7、货到付款；8、优惠券;
         */
        //网付通
        public static final String WFT = "20";
        
        //支付宝
        public static final String ZFB = "21";
        
        //银联
        public static final String ZTYL = "22";
        
        //鸿支付
        public static final String HZF = "23";
        
        //优酷支付
        public static final String YK = "25";
        
        //快捷支付
        public static final String KJZF = "26";
        
        //微信
        public static final String WX = "24";
        
        //宝易互通
        public static final String BYHT = "28";
    }
    
    /**
     * 支付机构
     * Title: PAYMENT-PLATFORM <br>
     * Description: <br>
     * Date: 2015年1月6日 <br>
     * Copyright (c) 2015 ifudata <br>
     * 
     * @author LiangMeng
     */
    public class PAY_ORG_CODE{
        public static final String ZFB = "ZFB";

        public static final String WFT = "WFT";
        
        public static final String ZTYL = "ZTYL";
        
        public static final String YLWAP = "YLWAP";
        /*鸿支付网银个人*/
        public static final String HZFWYC = "HZFWYC";
        /*鸿支付网银企业*/
        public static final String HZFWYB = "HZFWYB";
        /*鸿支付无卡支付*/
        public static final String HZFWK = "HZFWK";
        /*鸿支付全民付*/
        public static final String HZFQMF = "HZFQMF";
        /*优酷支付***/
        public static final String YKPAY = "YKPAY";
        /*快捷支付**/
        public static final String CJPAY = "CJPAY";
        /*微信**/
        public static final String WEIXIN = "WEIXIN";
        /*宝易互通**/
        public static final String BYHT = "BYHT";
        /*宝易互通快捷**/
        public static final String BYHTKJ = "BYHTKJ";        
              
    }
    
}
