package com.ifudata.ums.system.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
    /**
     * 系统参数
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年4月14日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author moubd
     */
    public static class GN_SYS_PARAM{
        public static class TYPE_CODE{
            //客户信息
            public static final String CM_CUST = "CM_CUST"; 
            //账户信息
            public static final String CM_ACCT = "CM_ACCT";
            //顺延月份
            public static final String SUBS_PRODUCT_DELAY = "SUBS_PRODUCT_DELAY";
            //开户（资源信息）卡种类      白卡 成卡
            public static final String RESOURCE_MESSAGE = "RESOURCE_MESSAGE";
            //费用科目项定义
            public static final String GN_FEE_ITEM_DEF = "GN_FEE_ITEM_DEF";
            //渠道管理本部
            public static final String TF_CHL_KIND = "TF_CHL_KIND";
            //产品
            public static final String ORD_PM_PRODUCT = "ORD_PM_PRODUCT";
            //产品资源类型
            public static final String PM_COMM_RES_DEF = "PM_COMM_RES_DEF";
        }
        
        public static class PARAM_CODE{
            //证件类型
            public static final String CERT_TYPE = "CERT_TYPE";
            //性别
            public static final String SEX = "SEX";
            //付款方式
            public static final String PAY_TYPE = "PAY_TYPE";
            //寄送方式
            public static final String POST_TYPE = "POST_TYPE";
            //顺延月份
            public static final String DELAY_MONTH = "DELAY_MONTH";
            //支持合约顺延的产品类型
            public static final String SUPPORT_PRODUCT_TYPE="SUPPORT_PRODUCT_TYPE";
            //开户（资源信息）卡种类  白卡 成卡
            public static final String CARD_TYPE = "CARD_TYPE";
            //开户（资源信息）卡类型     普卡 微卡 NaNo卡
            public static final String PHONE_CARD_TYPE = "PHONE_CARD_TYPE";
            //费用科目项ID
            public static final String FEE_ITEM_ID = "FEE_ITEM_ID";
            //渠道管理本部
            public static final String PARENT_CHL_KIND = "PARENT_CHL_KIND";
            //产品类型
            public static final String PRODUCT_TYPE="PRODUCT_TYPE";
            //产品资源type
            public static final String RES_TYPE = "RES_TYPE";
            //产品资源单位
            public static final String RES_UNIT = "RES_UNIT";
        }
    }
    /**
     * Title: ums-CRM <br>
     * Description:基础运营商 <br>
     * Date: 2014年5月16日 <br>
     * Copyright (c) 2014 ifudata <br>
     * @author moubd
     */
    public static class BASIC_ORG_ID{
        //0 中国联通 1 中国电信 2 中国移动
        public static final String UNICOM = "0";
        public static final String TELECOM = "1";
        public static final String MOBILE = "2";
    }
    /**
     * 发票类型
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年3月28日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author chenrui
     */
    public static class INVOICE_TYPE{
        /**一次打印*/
        public static final String ONCE = "1";
        /**分月打印*/
        public static final String MONTHLY = "2";
        /**不需要*/
        public static final String NO = "0";
        
    }
 
	/**
	 * 配送方式 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月21日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author chenrui
	 */
	public static class LOGISTICS_TYPE {

		/** 无 */
		public static final String NO = "0";
		/** 快递 */
		public static final String EXPRESS = "1";
		/** 自提 */
		public static final String AUTO = "2";
		/** 现取 */
		public static final String NOW_TAKE = "3";
		/** 顺丰 */
        public static final String SF = "SF";
	}

	/**
	 * 产品类别 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月20日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author chenrui
	 */
	public static class PRODUCT_TYPE {

		/** 主产品 */
		public static final String MAIN = "1";
		/** 子产品 */
		public static final String SUB = "2";
	    /**自定义套餐**/
		public static final String SELF_DEFINE_PALN="60002";
		/**X计划非自定义套餐 **/
		public static final String NO_SELEF_DEFINE_PLAN = "60001";
		/**固定套餐**/
		public static final String FIXD_PLAN="10016";
		/**专业应用 **/
		public static final String PROFESSIONAL_APP_PLAN="30001,30002";
		/**
		 * 30001 华办公，30002 华企通
		 */
		public static final String PROFESSIONAL_APP_HUA_OFFICE = "30001";
		public static final String PROFESSIONAL_APP_HUA_COMPANY = "30002";
		
	}

	/**
	 * 受理渠道 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月27日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author chenrui
	 */
	public static class FROM_TYPE {
		/** 网厅 */
		public static final String NET = "1";
		/** 营业厅 */
		public static final String CRM = "2";
		/** 客服 */
		public static final String CUST_SERVICE = "3";
		/** 掌厅 */
		public static final String HAND = "4";
		/** 短信厅 */
		public static final String MSG = "5";

	}

	/**
	 * 
	 * Title: ums-SP <br>
	 * Description: 订单模块静态变量——订单状态<br>
	 * Date: 2014年3月12日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author zhangfan
	 */
	public static class ORDER_STATE {
		// 创建
		public static final String STATE_CREATE = "10";
		// 待支付
		public static final String STATE_NEED_PAY = "11";
		// 待支付
		public static final String STATE_DONE_PAY = "111";
		// 待审核
		public static final String STATE_NEED_AUDIT = "12";
		// 已审核
		public static final String STATE_DONE_AUDIT = "121";
		// 待配货
		public static final String STATE_NEED_PREPARE_GOODS = "13";
		// 已配货
		public static final String STATE_DONE_PREPARE_GOODS = "131";
		// 待出库
		public static final String STATE_NEED_OUT_STORE = "14";
		// 已出库
		public static final String STATE_DONE_OUT_STORE = "141";
		// 待收货
		public static final String STATE_NEED_RECEIVE_GOODS = "15";
		// 已收货
		public static final String STATE_DONE_RECEIVE_GOODS = "151";
		// 待确认
		public static final String STATE_NEED_CONFIRM = "16";
		// 已确认
		public static final String STATE_DNOE_CONFIRM = "161";
		// 待写卡
        public static final String STATE_NEED_WRITE= "17";
        // 已写卡
        public static final String STATE_DONE_WRITE = "171";

		// 申请撤销(撤销)
		public static final String STATE_APPLY_CANCEL = "20";
		//待审核(撤销)
		public static final String STATE_CANCEL_NEED_AUDIT = "21";
		//已审核(撤销)
		public static final String STATE_CANCEL_DONE_AUDIT = "211";
		//待退款(撤销)
		public static final String STATE_CANCEL_PAY_BACK = "23";
		//已退款(撤销)
		public static final String STATE_CANCEL_DONE_PAY_BACK = "231";
		//订单自动执行失败
		public static final String STATE_EXECUTE_FAIL = "802";
		// 完成
		public static final String STATE_FINISH = "90";
		//取消
        public static final String STATE_CANCEL = "91";		
		//撤销
        public static final String STATE_REVOKE = "92";

		public static Map<String, String> STATE_MAP() {
			Map<String, String> map = new HashMap<String, String>();
			map.put("STATE_NEED_PAY", STATE_NEED_PAY);
			map.put("STATE_NEED_PREPARE_GOODS", STATE_NEED_PREPARE_GOODS);
			map.put("STATE_NEED_OUT_STORE", STATE_NEED_OUT_STORE);
			map.put("STATE_NEED_RECEIVE_GOODS", STATE_NEED_RECEIVE_GOODS);
			map.put("STATE_NEED_AUDIT", STATE_NEED_AUDIT);
			map.put("STATE_NEED_CONFIRM", STATE_NEED_CONFIRM);
			map.put("STATE_FINISH", STATE_FINISH);
			map.put("STATE_CANCEL_DONE_PAY_BACK", STATE_CANCEL_DONE_PAY_BACK);
			return map;
		}
	}

	/**
	 * 账号相关信息
	 */
	public static class OperMessage {
		// 用户级别
		public static final String OPER_LEVEL_ALL = "0"; // 总部级

		public static final String OPER_LEVEL_PROVINCE = "1"; // 省级

		public static final String OPER_LEVEL_CITY = "2"; // 地市级

		public static final String OPER_LEVEL_COUNTY = "3"; // 县级

		public static final String OPER_LEVEL_DEPT = "4"; // 部门级

		public static final String OPER_LEVEL_PERSON = "5"; // 个人级

		public static final String CITY_CENTER = "000"; // 省本级

		public static final String COUNTY_CENTER = "00000"; // 市本级

		// 总部
		public static final String ALL_CENTER = "00";
	}

	/**
	 * 登录返回编码信息 -- 网厅登录
	 */
	public static class LoginReturnMessage {
		// 验证成功
		public static final String SUCCESS = "0";
		// 验证码为空
		public static final String VERIFY_CODE_IS_BLANK = "1";
		// 验证码错误
		public static final String VERIFY_CODE_IS_ERROR = "2";
		// 用户名或密码为空
		public static final String USERCODE_OR_PASSWD_IS_BLANk = "3";
		// 用户名或密码错误
		public static final String USERCODE_OR＿PASSWD_IS_ERROR = "4";
	}

	/**
	 * 放入session中的oper
	 */
	public static final String SESSION_OPER = "CRM_SESSION_OPER";

	/**
	 * 标签定义ID Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月13日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class PmTagId {
		// 月消费金额
		public static final String XFJE = "XFJE";
		// 月通话时长
		public static final String THSC = "THSC";
		// 月上网流量
		public static final String SWLL = "SWLL";
		// 月短信条数
		public static final String DXTS = "DXTS";
		// 套餐类型
		public static final String TCLX = "TCLX";
		// 资源品牌
		public static final String ZYPP = "ZYPP";
		// 产品包价格范围
		public static final String JGFW = "JGFW";
		// 资源操作系统
		public static final String CZXT = "CZXT";
		// 资源特点
		public static final String ZYTD = "ZYTD";
		// 是否合约套餐
		public static final String SFHY = "SFHY";
		// 优惠活动类型
		public static final String HDLX = "HDLX";
		// 预存话费
		public static final String YCHF = "YCHF";
		// 靓号类型
		public static final String LHLX = "LHLX";
		// 产品入口
		public static final String CPRK = "CPRK";
		//存费送实物合约主产品
		public static final String CFSJRK="=CFSJRK";
	}

	/**
	 * 开户订单提交的静态常量 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月19日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class OrderSubmitSession {
		// 主产品VO ProductVo
		public static final String MAIN_PRODUCTVO = "MAIN_PRODUCTVO";
		//余额中心的List<Map<String,String>>
		public static final String AMOUNT_LIST = "AMOUNT_LIST";
		// 余额中心的FeeItemID String
		public static final String AMOUNT_FEE_ITEMID = "AMOUNT_FEE_ITEMID";
		// 余额中心的Fee
		public static final String AMOUNT_FEE = "AMOUNT_FEE";
		// 余额中心的总价格 String
		public static final String PRODUCT_AMOUNT = "PRODUCT_AMOUNT";
		// 终端FeeItemID String
		public static final String TERMINAL_FEE_ITEMID = "TERMIANL_FEE_ITEMID";
		// 终端价格 String
		public static final String TERMINAL_PRICE = "TERMINAL_PRICE";
		// 终端名称 String
		public static final String TERMINAL_NAME = "TERMINAL_NAME";
		// 终端小型号 String
		public static final String MOBILE_TYPE = "MOBILE_TYPE";
		// 主产品总价格 String
		public static final String MAIN_PRODUCT_PRICE = "MAIN_PRODUCT_PRICE";
		// 当月资费：0 当月生效 1次月生效 String
		public static final String EFFECT_DATE = "EFFECT_DATE";
		// 产品VO
		public static final String PRODUCT_VO = "PRODUCT_VO";
		// MU元素 Key value:3678901,3678901
		public static final String MU_ELEMENTID = "MU_ELEMENTID";
		// 可选业务包：List<Map<String,Object>> 其中map 包含PRODUCT_VO\
		// MU_ELEMENTID(MU元素id)\EFFECT_DATE(产品当月资)
		public static final String BUSI_PACKAGE = "BUSI_PACKAGE";
		// 靓号活动
		public static final String BE_NUM = "BE_NUM";
		// 可选增值包：List<Map<String,Object>> 其中map 包含PRODUCT_VO\
		// MU_ELEMENTID(MU元素id)\EFFECT_DATE(产品当月资)
		public static final String ADD_PACKAGE = "ADD_PACKAGE";
		// 卡模式 ：100 普卡 200 微型卡 400 NANO卡 String
		public static final String CARD_MODEL = "CARD_MODEL";
		// 卡类型
		public static final String CARD_TYPE = "CARD_TYPE";
		// 手机卡号 string
		public static final String PHONE_CARD = "PHONE_CARD";
		public static final String PHONE_CARD_IMSI = "PHONE_CARD_IMSI";
		// 客户信息 CustVo
		public static final String CUSTVO = "custVo";
		// 经办人 GestorVo
		public static final String GESTORVO = "gestorVo";
		//是否预约号码
        public static final String IS_PRE_NUM = "IS_PRE_NUM";
		// 选中号码号 String
		public static final String CHECKED_NUM = "checked_num";
		// 选中号码号省份 String
		public static final String CHECKED_NUM_PROVINCE = "CHECKED_NUM_PROVINCE";
		// 选中号码号地市 String
		public static final String CHECKED_NUM_REGION = "CHECKED_NUM_REGION";
		// 选中号码仓库号 String
		public static final String CHECKED_NUM_STORAGE = "CHECKED_NUM_STORAGE";
		// 选中号码的预占码
		public static final String CHECKED_NUM_PRECODE = "CHECKED_NUM_PRECODE";
		// 选中号码的受理单ID
        public static final String CHECKED_NUM_BOOKID = "CHECKED_NUM_BOOKID";
		// 手机号对应的基础运营商 0 中国联通 1 中国电信 2 中国移动
		public static final String BASIC_ORG_ID = "BASIC_ORG_ID";
		// 选中号码费用 String
		public static final String CHECKED_NUM_FEE = "checked_num_fee";
		// 营业费用列表 List<OrdBusiOperFee>
		public static final String ORD_BUSIOPER_FEES = "ordBusiOperFees";
		//营业费用列表转换为综合提交的VO
		public static final String ORD_BUSI_FEES = "ORD_BUSI_FEES";
		// 产品费用列表 List<OrdFeeDetails> 或 List<OrdChangeFeeDetail>
		public static final String ORD_FEE_DETAILS = "ordFeeDetails";
		// 是否需要发票 String key
		public static final String INVOICE_FLAG = "INVOICE_FLAGE";
		public static final String MON_INVOICE_FLAG = "MON_INVOICE_FLAG";
		//发票抬头
		public static final String INVOICE_TITLE = "INVOICE_TITLE";
		//0 不需要 1 需要
		public static final String INVOICE_FLAG_Y = "1";
		public static final String INVOICE_FLAG_N = "0";
		//public static final String INVOICE_FLAG = "INVOICE_FLAGE";
		// 账户信息 OrdAcct
		public static final String ORD_ACCT = "ORD_ACCT";
		// 账户ID
        public static final String ACCT_ID = "ACCT_ID";
		// 账户名称
		public static final String ACCT_NAME = "ACCT_NAME";
		// 终端串号
		public static final String MOBILE_NUM = "MOBILE_NUM";
		//发展人ID
		public static final String DEV_ID = "DEV_ID";
		//费用计算 产品费用
		public static final String PRODUCT_FEE = "PRODUCT_FEE";
		//费用itemId
		public static final String PRODUCT_ITEMID = "PRODUCT_ITEMID";
		//能否减免标志：0可以减免，1不能减免
		public static final String DISCOUNT_MARK = "DISCOUNT_MARK";
		public static final String IS_DISCOUNT_MARK = "0";
		public static final String NOT_DISCOUNT_MARK = "1";
		//是白卡提交还是成卡提交
		public static final String CARDTYPE = "CARDTYPE";
		//白卡
		public static final String WHITE_CARD = "WHITE_CARD";
		public static final String WHITE_CARD_VALUE="2";
		//成卡
		public static final String SIM_CARD = "SIM_CARD";
		public static final String SIM_CARD_VALUE="1";
	}
	/**
	 * 手机卡 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月25日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class PhoneCard {
		// 按卡号查询
		public static final String CARD_NUM = "10";
		// 按卡模式，卡容量查询
		public static final String CARD_MODEL = "20";

	}
	/**
	 * Title: ums-CRM <br>
	 * Description: 账户类型<br>
	 * Date: 2014年4月15日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class ACCT_TYPE{
	    // 预付
        public static final String PREPAY = "1";
        // 后付
        public static final String AFTER_PAY = "0";
	}
	/**
	 * Title: ums-CRM <br>
	 * Description: 客户类型<br>
	 * Date: 2014年4月15日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class CUST_TYPE{
        // 公共客户
        public static final String COMMEN_CUST = "1";
        // 集团客户
        public static final String GROUP_CUST = "2";
    }
	/**
	 * Title: ums-CRM <br>
	 * Description: 客户校验结果标记<br>
	 * Date: 2014年4月15日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class VERIFY_FLAG{
        // 未核实
        public static final String NO_CHECK = "0";
        // 已核实
        public static final String CHECKED = "1";
    }
	
	/**
	 * 手机号码 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月25日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class PhoneNumber {
		/**
		 * 手机号码状态 Title: ums-CRM <br>
		 * Description: <br>
		 * Date: 2014年3月25日 <br>
		 * Copyright (c) 2014 ifudata <br>
		 * 
		 * @author moubd
		 */
		public static class NumStatus {
			// 空闲
			public static final String FREE = "0";
		}
	}

	/**
	 * 操作渠道 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月25日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author liangmeng
	 */
	public static class PAY_CHANNEL {
		// 营业厅缴费
		public static final int YYTJF = 1;
		// 网厅缴费
		public static final int WTJF = 2;
		// 一卡充充值
		public static final int YKCCZ = 3;
	}

	public static class CommonQueryType {
		public static final String QUERYTYPE_ZJH = "0";// 根据证件号查询客户资料
		public static final String QUERYTYPE_FWH = "1";// 根据服务号查询客户资料
		public static final String QUERYTYPE_FWMM = "2";// 根据服务密码查询客户资料
	}

	public static class AreaLevel {
		// 地域级别：其中0－全国，1－省，2－地市，3－地市以下1级 ,4－地市以下2级 ,5－地市以下3级.... 以此类推
		public static final String ALL = "0";
		public static final String PROVINCE = "1";
		public static final String CITY = "2";
		public static final String COUNTY = "3";
		public static final String TOWN = "4";
	}

	/**
	 * 用户类型
	 */
	public static class SUBS_TYPE {
		public static final String USER = "1";
		public static final String GROUP = "2";

	}
	/**
	 * 客户级优惠类型
	 */
	public static class CUST_DIS_TYPE {
		public static final String BZ = "0";//优惠标识——标准优惠
		public static final String FBZ = "1";//非标准优惠
		public static final String TS = "1";//非标准优惠——特殊优惠
		public static final String GX = "2";//非标准优惠——个性优惠
		public static final String FH = "1";//优惠方式——返还
		public static final String ZK = "2";//优惠方式——折扣
		public static final String GXH = "3";//优惠方式——个性化
		public static final String YHZT_X = "1000";//优惠主题——X计划套餐
		public static final String YHLX = "1";//优惠类型——总费用优惠
		public static final String YHBM = "0";//优惠编码——非佳博优惠
		public static final String YHBM_JB = "2011";//优惠编码——佳博优惠
		public static final String YHZLX_BFB = "1";//优惠值类型——百分比
		public static final String YHZLX_GDZ = "2";//优惠值类型——固定值
		public static final String BZYH_ZK = "1";//标准优惠——折扣
		public static final String BZYH_FH = "2";//标准优惠——返还
		public static final String TSYH_ZK = "1";//特殊优惠——折扣
		public static final String TSYH_FH = "2";//特殊优惠——返还
	}
	/**
	 * 群组等级
	 */
	public static class GROUP_LEVEL {
//		0：全国群组
//		1：全省群组
//		2：本地群组
		public static final String COUNTRY = "0";
		public static final String PROVINCE = "1";
		public static final String LOCAL = "2";

	}
	/**
	 * 订单类型
	 */
	public static class ORDER_TYPE {
		/**
		 * 正常单
		 */
		public static final String NORMAL = "1";
		/**
		 * 撤销单
		 */
		public static final String CANCEL = "2";
		/*
		 * 订单类型、正常订单
		 * */
		public static final String ORDER_TYPE_PRO  ="0";
		public static final String ORDER_TYPE_NUM  ="1";
		public static final String ORDER_TYPE_TEM  ="2";

	}

	public static class BusiChange {
		public static final String SERVICENUM = "SERVICENUM";// 服务号码 String
		public static final String CUST_ID = "custId";// 客户ID String
		public static final String ACCT_ID = "acctID";// 账户ID String
		public static final String ACCT_TYPE = "acctType";// 账户ID String
		public static final String ACCT_NAME = "acctName";// 账户ID String
		public static final String SUBS_ID = "subsId";// subsID String
		public static final String GROUP_ID = "groupId";// groupId String
		public static final String PRODUCT_ID = "productId";// productId String
		public static final String OLD_PRODUCT_ID = "oldProductId";// productId String
		public static final String SIM_NUM = "simNum";// 卡号 String
		public static final String SIM_TYPE = "simType";// 卡类型 String
		public static final String CUST_NAME = "custName";//客户名称
		// public static final String BUSI_OPER_CODE_CZLX = "czlx";// 操作类型
		// String
		// 费用计算 公用传参
		public static final String BUSICODE = "busiCode";// 业务编码 String
		public static final String EXPRESSTYPE = "expressType";// 邮寄类型 String
		public static final String RETURNURL = "returnUrl";// 回调url String
		//经办人
		public static final String JBR_NAME = "JBR_NAME";//名称 String
		public static final String JBR_CERTTYPE = "JBR_CERTTYPE";//证件类型 String
		public static final String JBR_CERTVALUE = "JBR_CERTVALUE";//证件值String
		public static final String JBR_TEL = "JBR_TEL";//手机 String
		public static final String JBR_REMARK = "JBR_REMARK";//备注 String
		//生效方式
		public static final String EFFECTIVE_WAY = "EFFECTIVE_WAY";
		//省市
		public static final String PRIVENCECODE = "PRIVENCECODE";//省份编码 String
		public static final String CITYCODE = "CITYCODE";//地市编码 String
		public static final String STORAGEID = "STORAGEID";//仓库号 String
		public static final String PAYTYPE = "PAYTYPE";//支付方式 String
		public static final String SERVICE_STATUS = "SERVICE_STATUS";//用户状态  String
		public static final String TERMINAL_MODEL = "TERMINAL_MODEL" ; //终端型号  String
		
		public static final String TERMINAL_SERIAL_OLD = "TERMINAL_SERIAL_OLD" ; //老终端串号  String
		public static final String TERMINAL_SERIAL_NEW = "TERMINAL_SERIAL_NEW" ; //新终端串号   String
		
		public static final String CARD_ISVALADATE = "01" ; //终端换机卡入库校验  String
		public static final String CARD_NOTVALADATE = "00" ; //终端换机卡入库不校验 String
		
		public static final String FAULT_NUM = "FAULT_NUM" ; // String
		public static final String FAULT_REASON = "FAULT_REASON" ;
		
		public static final String COMMONQUERY_ISVALIDATE = "ISVALIDATE" ;//查询散户信息是否校验 String
		
		public static final String COMMONQUERY_VALIDATE = "1" ; //做校验 String
		public static final String COMMONQUERY_NOTVALIDATE = "2" ;//不做校验 String
		
		public static final String PRODUCT_TYPE_GX = "10009" ;//共享产品 类型 String
		public static final String SVR_TYPE_GX = "100" ;//共享产品 电信类型 String
		public static final String BASICORGID = "BASICORGID" ;// 电信类型 String
		public static final String PRODUCT_ID_DX="1000200002";//华翔X计划套餐独享版
		public static final String PRODUCT_ID_GX="1000200001";//华翔X计划套餐共享版
		public static final String PRODUCT_ID_HUA_OFFICE = "1000100001";//华办公
		public static final String PRODUCT_ID_HUA_COMPANY = "1000100002";//华企通
		
		//备注
		public static final String REMARK ="REMARK";
	}
	
	/**
	 * 
	 * Title: ums-CRM <br>
	 * Description: 退费属性<br>
	 * Date: 2014年4月3日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author liangmeng
	 */
	public static class RefundId{
	    public static final String COULD_REFUND = "1000";// 可退费
	    public static final String CANT_REFUND = "0";// 不可退费
	}
	
	
	
	public static class AREA_OPTION{
	    
	    public static final String DEFAULT_VALUE = "请选择";
	}
	/**
	 * subs_user表中service_status描述
	 * @author root
	 *
	 */
	public static class SERVICE_STATUS{
		
		 public static final String SHUTDOWN_DESC = "停机";
		 
		 public static final String BOOT_DESC = "开机";
		 
		 public static final String HALF_DESC="半停";
		 
		 public static final String SHUTDOWN_STATUS = "2";
		 
		 public static final String BOOT_STATUS = "1";
		 
		 public static final String HALF_STATUS="3";
	}
	
	 /**
     * 支付方式
     * @author chenrui
     *
     */
    public static class PAY_TYPE{
        /**现金*/
        public static final String COUNTER_PAY = "1";
        /**在线支付*/
        public static final String ONLINE_PAY = "2";
        /**充值卡*/
        public static final String RECHARGE_CARD_PAY = "3";
        /**赠送预存*/
        public static final String GIVE_DESPOIT_PAY = "4";
        /**积分*/
        public static final String ACCUMULATE_PAY = "5";
        /**POS机*/
        public static final String POS_PAY = "6";
        /**货到付款*/
        public static final String DELI_PAY = "7";
        /**优惠券*/
        public static final String COUPONS_PAY = "8";
        
        public static Map<String, String> PAY_MAP() {
            Map<String, String> map = new HashMap<String, String>();
            map.put("COUNTER_PAY", COUNTER_PAY);
            map.put("ONLINE_PAY", ONLINE_PAY);
            map.put("RECHARGE_CARD_PAY", RECHARGE_CARD_PAY);
            map.put("GIVE_DESPOIT_PAY", GIVE_DESPOIT_PAY);
            map.put("ACCUMULATE_PAY", ACCUMULATE_PAY);
            map.put("POS_PAY", POS_PAY);
            map.put("DELI_PAY", DELI_PAY);
            map.put("COUPONS_PAY", COUPONS_PAY);
            return map;
        }
    }
    
    /**
     * 支付状态
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年4月15日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author moubd
     */
    public static class PAY_STATE{
        //支付失败
        public static final String FAILURE = "0";
        //支付完成
        public static final String SUCCESS = "1";
    }
    /**
     * 账户权限
     * @author root
     *
     */
 public static  class ORDER_RIGHT_ID{
	 //审核权限
	 public static final String AUDIT = "100001";
	 //配货权限
	 public static final String PREPARE_GOODS = "100002";
	 //出库权限
	 public static final String OUT_STORE = "100003";
	 //审核权限（撤销）
	 public static final String CANCEL_AUDIT = "100004";
	 //退款权限（撤销）
	 public static final String CANCEL_PAY_BACK = "100005";
	 
 }
 /**
  * 
  * Title: ums-CRM <br>
  * Description: 缴费查询方式<br>
  * Date: 2014年4月10日 <br>
  * Copyright (c) 2014 ifudata <br>
  * 
  * @author liangmeng
  */
 public static class PAYMENT_QRY_TYPE{
     public static final String SERVICENUM = "0"; //服务号码
     public static final String APPLYID = "1";//缴费流水
 }
 /**
  * 
  * Title: ums-CRM <br>
  * Description: 国际漫游类别<br>
  * Date: 2014年4月11日 <br>
  * Copyright (c) 2014 ifudata <br>
  * 
  * @author lixc
  */
 public static class GLOABAL_PACKAGE_TYPE{
	 /**国际漫游*/
	 public static final String RAOMING = "10005";
	 /**国际长途*/
	 public static final String DAILING = "10008";
 }
 
 /**
	 * 收归稽核成功失败标志
	 * Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年4月2日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author zhangyichi
	 */
	public static class AuditResult {
		public static final String SUCCESS = "0";
		public static final String FAILED = "-1";
		public static final String NORESULT = "noresult";
		public static final String PASSDUE = "999999";
	}
	public static class IS_MUST {
		public static final String YES = "1";
		public static final String NO = "0";
	}
	
	/**
	 * 发票打印类型
	 * 0-收据
	 * 1-发票
	 * @author sunhl
	 *
	 */
	public static class InvoicePrintType{
		public static final String RECEPT = "0"; //收据
		public static final String INVOICE = "1"; //发票
	}
	
	/**
	 * 扎帐类型
	 * 
	 * Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年5月9日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author sicl
	 */
	public static class PitchAccountType{
        public static final String NO_NEED_PITCH = "0"; //不需要扎帐
        public static final String UNPITCH = "1"; //未扎帐
        public static final String PITCHED = "2"; //已扎帐
    }
	
	/**
	 * 报表查询类型
	 * 
	 * Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年5月9日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author sicl
	 */
	public static class ReportQueryType{
        public static final String PITCH_QUERY = "1"; //扎帐查询
        public static final String DETAIL_QUERY = "2"; //明细查询
    }
	/**
	 * 汇总查询类型
	 */
	public static class ReportHZQueryType{
        public static final String YYY = "1"; //营业员
        public static final String QD = "2"; //渠道
    }
	//是否预约号码
	public static class IS_PRE_NUM{
	    //1-预约开户，0-非预约开户
	    public static final String YES = "1";
	    public static final String NO = "0";
	}
	
	public static class Org_Type{
		public static final String DEPART = "1";
		public static final String CHANNEL = "2";
	}
	
	//pos机内部操作类型
	public static class INTRA_TRANS_TYPE{
		public static final String REGISTRATION_TYPE = "QD";//签到
		public static final String CONSUME_TYPE = "XF";//消费
		public static final String REVOCATION_TYPE = "CX";//撤销
		public static final String RETURN_GOODS_TYPE = "TH";//隔日退货
		public static final String REPRINT_TYPE = "DDY";//重打印
		public static final String SETTLE_ACCOUNTS_TYPE = "JS";//结算
		public static final String SHIFT_STATISTICS_TYPE = "HB";//换班统计
		public static final String REPRINT_SETTLEMENT_TYPE = "CDJSD";//重打结算单
	}
	
	//pos机型
	public static class POS_TYPE{
		public static final String CUP_TYPE = "1";//银商
		public static final String UNICOM_TYPE = "2";//通联
		public static final String ICBC_TYPE = "3";//工商
	}
	
	//pos机      交易系统
	public static class TRANS_SYSTEM{
		public static final String CRM = "1";//crm
		public static final String ACCOUNTS = "2";//账务
	}
	
	/**
	 * 
	 * Title: ums-CRM <br>
	 * Description: 获取CFG_PROPERTIES值<br>
	 * Date: 2014年5月28日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author zhangfan
	 */
	public static class CFG_PROPERTIES{
	    
	    public static class CFGTYPE {
	        
	        //系统
	        public static final String SYSTEM = "SYSTEM";
	    }
	    
	    public static class PROPERTY {
            
	        //版本
            public static final String VERSION = "VERSION";
        }
	}
	/**
	 * 支付方式
	 * Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年5月29日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author liangmeng
	 */
	public static class PAY_STYLE{
	    public static final int XJ = 1;
	    public static final int POS = 6;
	}
	
	/**
	 * 资源类型
	 * 
	 * Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年6月10日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author sicl
	 */
	public static class RESOURCE_TYPE{
	    
	    public static final String VOICE = "10";//语音
	    
	    public static final String SHORT_MSG = "50";//短信
	    
	    public static final String FLOW = "60";//流量
	    
	    public static final String FIXED = "3";//混合
	}
	 /**
     * 发票类型
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年6月13日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author NeoEvan
     */
    public static class INVOICE_CONTENT_TYPE{
        /**
         * 实际际内容打印
         */
        public static final String TRUTH_CONTENT_PRINT="0";
        /**
         * 登记内容打印
         */
        public static final String REG_CONTENT_PRINT="1";
    }
    /**
     * 智能卡类型
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年6月30日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author chenrui
     */
    public static class CARDX_TYPE{
        /**联通智能卡*/
        public static final String UNICOM = "unicom";
    }
    
    /**
     * 发票打印界面“全国服务热线”
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年6月30日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author yangzh
     */
    public static class INVOICE_SERV_LINE{
        /**
         * 全国服务热线--国美
         */
        public static final String SERV_LINE_GM="4008113333";
       
    }
    
    /**
     * 发票打印票据类型--对应资源接口定义
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年7月3日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author yangzh
     */
    public static class INVOICE_BILL_TYPE{
        /**
         * 票据类型--增值税普通发票
         */
        public static final String TYPE_GENERAL="100100";
        /**
         * 票据类型--增值税专用发票
         */
        public static final String TYPE_SPECIAL="100200";        
        /**
         * 票据类型--零售业发票	
         */
        public static final String TYPE_RESAL="100300";
        /**
         * 票据类型--收据
         */
        public static final String TYPE_RECEIPT="200100";
       
    }
    
    /**
     * 资源量批发对订单费用明细的影响--减免项显示方式
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年7月8日 <br>
     * Copyright (c) 2014 ifudata <br>
     * @author ycj
     */
    public static class OPER_DISCOUNT_SHOW_TYPE{
    	/**
    	 * 显示减免金额和减免原因
    	 */
    	public static final String SHOW_OPER_DISCOUNT = "1";
    	/**
    	 * 不显示减免金额和减免原因
    	 */
    	public static final String HIDDEN_OPER_DISCOUNT = "2";
    	/**
    	 * 集团客户资源量批发，在订单费用明细中显示打折和打折原因
    	 */
    	public static final String SHOW_DISCOUNT = "3";
    }
    /**
     * 性别
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年8月21日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author chenrui
     */
    public static class GENDER{
        /**女性*/
        public static final String FEMALE = "0";
        /**男性*/
        public static final String MALE = "1";
        /**未知*/
        public static final String UNKOWN = "2";
    }
    /**
     * 渠道请求参数
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年9月19日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author yangyang
     */
    public static class CHANNEL{
        /**渠道新建*/
        public static final String CHNL_NEW = "CHNL_NEW";
        /**渠道正式资料修改*/
        public static final String CHNL_MOD = "CHNL_MOD";
        /**渠道订单资料改单*/
        public static final String CHNL_ORDER_MOD = "CHNL_ORDER_MOD";
    }
    
    
    /**
     * 电信号码交费参数
     * @author zhangkq
     *
     */
    public static class TELECOM_PAY{
        public static final String SUCCESS ="0000";
        public static final String  BALANCE_ITEMTYPE_ID= "0";// 帐本类型 0：默认（本金）
        public static final String CHARGE_SOURCE ="0410510000";// 接入渠道编码（见接口文档附录，国美为固定值）
        public static final String DESTINATION_ATTR ="2";// 被充值用户属性2：移动手机用户
        public static final String DESTINATION_ID_TYPE ="3";// 被充值用户号码类型：3 –用户号码（充帐户帐本）
        public static final String PROLONG_DAYS ="0"; // 充值延长有效期(天数)0：默认值
        public static final String REQUEST_AMOUNT ="0";// 赠送条数当赠送为分月形式时，RequestAmount！＝1。没有赠送金额时填0。
        public static final String UNIT_TYPE_ID ="0"; // 充值单位类型0 – 分（金额）
        public static final String TCP_CONT_IN ="recharge.charge";//充值接口码
        public static final int PAY_CHNL_ID = 2;
    }
    
    
    /**
     * 电信月结发票打印参数
     * @author zhangkq
     *
     */
    public static class TELECOM_PRINT{
    	
    	public static final String   DD ="01";  			 //YYYYMMDD DD:DD 默认为 01，无帐期要求则填 0
    	public static final String   RECEPT_CLASS ="0";	 //0：普通发票1：营改增凭证
    	public static final String   QUERY_FLAG = "0";	 //0：按帐户 1：按用户 仅对预付费号码有效。当票据类型为 1，仅提供按帐户打印
    	public static final String   PRINT_FLAG  ="0";	 //0：表示默认方式
    	public static final String   PRINT_CODE  ="GM";	
    	
    }
    /**
     * 属性有效性
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年9月26日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author chenrui
     */
    public static class STATE{
        /**有效*/
        public static final String EFFECT = "1";
        /**失效*/
        public static final String UN_EFFECT = "0";
    }
    /**
     * 卡类别
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年10月9日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author chenrui
     */
    public static class CARD_KIND{
        /**白卡*/
        public static final String WRITE_CARD = "SIMW";
        /**成卡*/
        public static final String SIM_CARD = "SIMG";
        
    }
    
    /**
     * 营业员操作轨迹
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年10月16日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author yicj
     */
    public static class OPER_OPT_LOG {
    	
    	public static Map<String,String> getOperUrlMap() {
    		//定义拦截的URL和操作描述
    		Map<String,String> url_map = new HashMap<String, String>();
    		//初始化拦截信息
//    		url_map.put("/sale/subsUser/cAccountStep2_submitOrder", "操作了开户的订单提交");
//    		url_map.put("/enterpriseGroup/submitBatch", "操作了新增集团成员提交");
//    		url_map.put("/enterpriseGroup/saveGroupClientInfo", "操作了集团客户资料的创建提交");
//    		url_map.put("/enterpriseGroup/queryGroupMemberInfo", "操作了查询集团信息及成员查询");
//    		url_map.put("/busichg/product/executeFee", "操作了产品变更费用计算");
//    		url_map.put("/busichg/changeCard/toFeeCal", "操作了补换卡费用计算");
    		//预销户和取消预销户的费用计算按钮是同一个请求,根据busiType区分
//    		url_map.put("/busichg/subsuser/close/toFeeCal", "");
//    		url_map.put("/busichg/close/toCalculateFee", "操作了正式销户费用计算");
    		//强制销户和妥投转拒销户的费用计算按钮是同一个请求,描述根据busicode判断
//    		url_map.put("/busichg/forceCloseAccountController/toFeeCal", "");
//    		url_map.put("/busichg/contractPostponed/executeFee", "操作了合约顺延费用计算");
//    		url_map.put("/cust/transfer/doTransferCust", "操作了过客户提交");
//    		url_map.put("/busichg/chg/changeTradeFeeCal", "操作了停开机费用计算");
//    		url_map.put("/busichg/chg/toForceChangeTrade", "操作了强停强开费用计算");
//    		url_map.put("/cust/acct/updateAcctInfo", "操作了账户资料修改提交");
//    		url_map.put("/cust/custChg", "操作了客户资料修改提交");
//    		url_map.put("/busichg/chg/updatePassWord", "操作了服务密码变更提交");
//    		url_map.put("/busichg/terminalChange/toFeeCal", "操作了终端换机费用计算");
//    		url_map.put("/busichg/changePe/openAndClose/updateProductInfo", "操作了业务停开提交");
//    		url_map.put("/busichg/globalRoamingDialingController/feeCalculate", "提交了国际长途国际漫游费用计算");
    		url_map.put("/comprehensiveQuery_gm/mainDisplay", "操作了综合查询[用户信息]查询");
    		url_map.put("/comprehensiveQuery_gm/businessReceptionQuery", "操作了综合查询[业务受理信息]查询");
    		url_map.put("/comprehensiveQuery_gm/customerQuery", "操作了综合查询[客户资料]查询");
    		url_map.put("/comprehensiveQuery_gm/accountDataQuery", "操作了综合查询[账户资料]查询");
    		url_map.put("/comprehensiveQuery_gm/toGroupRelation", "操作了综合查询[群组关系]查询");
//    		url_map.put("/busichg/subsCredit/submitCancelSubsCreditInfo", "操作了取消免催免停提交");
//    		url_map.put("/busichg/subsCredit/submitSubsCreditInfo", "操作了设置免催免停提交");
    		url_map.put("/billDetail/bill_detail_content", "操作了详单查询");
    	
    		//赋值完成并返回
    		return url_map;
    	}
    }
    
    /**
     * 发票调用资源销售接口票据项编码定义
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年10月27日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author yangzh
     */
    public static class SALEINTERFACE_ITEMCODE{                         
        /**分公司id*/
        public static final String ITEM_COMPANYID = "001";
        /**分公司名称*/
        public static final String ITEM_COMPANYNAME= "002";
        /**分公司税号*/
        public static final String ITEM_CERTIFICATENO = "003";
        /**打印日期*/
        public static final String ITEM_PAYDATE = "004";
        /**计费周期*/
        public static final String ITEM_JFCYCLE = "005";
        /**通信服务费*/
        public static final String ITEM_TXFEE = "006";
        /**折扣金额*/
        public static final String ITEM_GIFTFEE = "007";
        /**金额合计大写*/
        public static final String ITEM_TOTALFEEDX = "008";
        /**收款人、营业员*/
        public static final String ITEM_STAFFNAME = "009";
        /**备注*/
        public static final String ITEM_REMARK = "010";
        /**全国服务热线*/
        public static final String ITEM_SERVLINE = "011";
    }
    
    /**
     * 调用电信接口失败状态码
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年11月14日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author yangzh
     */
    public static class INVOICE_EOP_SERVICECODE {    
    	public static final String CODE_SUCESS = "0";
        /**用户帐期有欠费，不允许打印发票或营改增凭证*/
        public static final String CODE_QF = "16752";
        /**用户帐期内无消费，无法打印*/
        public static final String CODE_WXF= "16753";       
    }
    
    /**
     * 
     * @author yangyang
     *
     */
    public static class FEE_ITEM_ID{
        /**违约金*/
        public static final String PENALTY_FEE = "10001005";
    }
    /**
     * 封顶解封类型
     * @author NeoEvan
     *
     */
    public static class BUSI_FD_JF{
    	/**
    	 * 封顶
    	 */
    	public static final String CHANGE_TYPE_FD="1";
    	/**
    	 * 解封
    	 */
    	public static final String CHANGE_TYPE_JF="0";
    	/**
    	 * 按客户
    	 */
    	public static final String SEARCH_BY_CUST="0";
    	/**
    	 * 按用户
    	 */
    	public static final String SEARCH_BY_USER="1";
    }
    
    /**
     * 用户状态
     * @author yicj
     *
     */
    public static class USER_STATE {
    	/* 正常 */
    	public static final String normal = "1";
    	/* 未返档 */
    	public static final String unReturn = "2";
    	/* 注册 */
    	public static final String register = "3";
    	/* 欠费*/
    	public static final String oweFee = "4";
    	/* 冻结 */
    	public static final String freeze = "5";
    }
    
    /**
     * 初始化密码
     */
    public static class CUST_INFO_PWD_FLAG{
    	/**
    	 * 是初始化密码
    	 */
    	public static final String INIT_PWD = "1";
    	/**
    	 * 不是初始化密码
    	 */
    	public static final String NO_INIT_PWD = "0";
    }
    
    /**
     * 个性化类别
     * @author Wuhf
     */
    public static class  CUST_INFO_TYPE{
    	/**
    	 * 集团客户扩展信息表
    	 */
    	public static final String CUST_GROUP_EXTEND = "CM_GROUP_CUST_EXTEND";
    	
    	public static final String CUST_GROUP_SERVICE = "SERVICE_NEED";
    	
    	public static final String CUST_GROUP_APP = "APP_NEED";
    	/**
    	 * 参数表名
    	 */
    	public static final String CUST_INFO_APP_MOBILE_PARAM_TABLE = "CM_CUST_EXTEND";
    	/**
    	 * 服务需求
    	 */
    	public static final String CUST_INFO_SERVICE = "SERVICE";
    	/**
    	 * 应用需求
    	 */
    	public static final String CUST_INFO_APP = "APP";
    	/**
    	 * 应用需求-互联网移动应用
    	 */
    	public static final String CUST_INFO_APP_MOBILE = "MOBILE_LIKE";
    	/**
    	 * 应用需求-社交应用
    	 */
    	public static final String CUST_INFO_APP_SOCIAL_CONTACT  = "SOCIAL_CONTACT";
    	
    	/**
    	 * 喜好
    	 */
    	public static final String CUST_INFO_LIKE = "LIKE";
    	
    	/**
    	 * 喜好-体育
    	 */
    	public static final String CUST_INFO_LIKE_SPORT = "SPORT";
    	
    	/**
    	 * 交通工具
    	 */
    	public static final String CUST_INFO_TRAFFIC = "TRAFFIC";
    	
    	/**
    	 * 旅游交通工具
    	 */
    	public static final String CUST_INFO_TRAVEL_TRAFFIC= "TRAVEL_TRAFFIC";
    	
    	/**
    	 * 日常交通工具
    	 */
    	public static final String CUST_INFO_DAILY_TRAFFIC = "DAILY_TRAFFIC";
    }
    
    /**
     * 发展人是否必填
     */
    public static class CUST_DEV_IS_NOT_NEED{
    	/**
    	 * 是 必填
    	 */
    	public static final String CUST_DEV_IS_NEED = "1";
    	
    	
    	/**
    	 * 非 必填
    	 */
    	public static final String CUST_DEV_NOT_NEED = "2";
    }
    
    /**
     * 账户付费方式
     */
    public static class ACCT_PAY_TYPE{
    	/*
    	 *现金 
    	 */
    	public static final String PAY_TYPE_XIANJIN="1";
    	
    	/**
    	 * 代收
    	 */
    	public static final String PAY_TYPE_DAISHOU="0";
    	
    	/*
    	 *托收 
    	 */
    	public static final String PAY_TYPE_TUOSHOU="2";
    }
    
    /**
     * 公共页面入口是否显示服务号码列表
     * 
     * @author yicj
     *
     */
    public static class SHOW_SERVICENUM_LIST {
    	//显示
    	public static final String SHOW = "1";
    	//隐藏
    	public static final String HIDDEN = "0";
    }
    
    /**
     * 证件类型
     * @author zhangfan
     *
     */
	public static class CERT_TYPE{
        // 组织机构代码证
        public static final String CERT_ZZJGDMZ = "14";
    }
	/**
	 * 计费方式
	 * 
	 * @author sicl
	 *
	 */
	public static class PLAN_FEE_TYPE {
		//半月套餐方式
		public static final String HALF_MONTH_FEE = "1";
		
		//全月套餐方式
		public static final String FULL_MONTH_FEE = "2";
		
		//套外资费方式
		public static final String OUT_MONTH_FEE = "3";
	}
	
	/**
	 * 产品订购
	 */
	public static class ORDER_PRODUCT{
		//指定号码方式
		public static final String NUMBER_TYPE_SOME="1";
		//全部号码
		public static final String NUMBER_TYPE_ALL="2";
		
		//计费方式
		public static final String PLAN_FEE_TYPE_ALL_MONTH="2";
	}
	
	/**
	 * 批量导入相关的常量配置
	 * 
	 * @author sicl
	 *
	 */
	public static class BATCH_IMPORT_TEMPLATE{
		//文件模板的路径
		public static final String TEMPLATE_FILE_PATH = "/excel_config/templet/";
		 
		//批量产品上传文件模板名称
		public static final String PRODUCT_IMPORT_TEMPLET_NAME = "HX_BatchProductTemplate.xls";
		
		//批量产品错误信息导出模板
		public static final String PRODUCT_EXPORT_TEMPLATE_NAME = "HX_BatchProductExportFailTemplate.xls";
		 
		//批量产品上传校验错误后的模板名称
		public static final String PRODUCT_CHECK_TEMPLATE_NAME = "HX_BatchProductCheckFailTemplate.xls";
				
		//批量号码上传文件模板名称
		public static final String RESOURCE_IMPORT_TEMPLATE_NAME = "HX_BatchResourceTemplate.xls";
		
		//批量号码错误信息导出模板
		public static final String RESOURCE_EXPORT_TEMPLATE_NAME = "HX_BatchResourceExportFailTemplate.xls";
		
		//批量号码上传校验错误后的模板名称
		public static final String RESOURCE_CHECK_TEMPLATE_NAME = "HX_BatchResourceCheckFailTemplate.xls";
		
		//业务受理时，如果当前操作员归属部门，则对于的GnChannelVo对象为空.则要给出操作员如下的提示信息
		public static final String ERROR_MSG = "当前操作员归属部门，不能使用业务受理类的功能";
	}
	
	/**
	 * 批量业务编码
	 * 
	 * @author sicl
	 *
	 */
	public static class BATCH_BUSI_TYPE{
		//批量号码业务类型
		public static final String RESOURCE_TYPE = "11";
		
		//批量产品业务类型
		public static final String PRODUCT_TYPE = "15";
	}
	
	/**
	 * 特服编码
	 */
	public static class SPECIAL_SERVER_PE_ID{
		//无条件呼叫转移
		public static final String WTJZY="WTJZY";
		//遇忙转移
		public static final String YMZY = "YMZY";
		//无应答转移
		public static final String WYDZY = "WYDZY";
		// 不可及转移
		public static final String BKJZY= "BKJZY";
	}
	
	
	public static class EMPLOYEE_TYPE{
		// 0:普通客户
		public static final String NOMAL_CUST = "0";
		// 1:员工客户
		public static final String EMPLOYEE_CUST = "1";
		// 2:测试客户
		public static final String TEST_CUST = "2";
		
	}
	
	public static class CUST_COMMON_SEARCH {
		//显示服务号码列表标识
		public static final String SHOW_LIST_FLAG = "showListFlag";
		//同步显示号码
		public static final String SYNC_SEARCH_NUMBER = "syncShowNumber";

		// limy6
		// 是从哪里发来的 到公共页面的请求
		public static final String FROM_WHERE = "from_where";

        public static final String FROM_PACKAGE_BALANCE = "1";// "1" 代表从 "套餐余量查询" 入口

        public static final String FROM_RESOUCE_BALANCE = "2";// "2" 代表从 "资源余量查询" 入口
        
	}
	
	public static class SYNC_SEARCH_NUMBER {
    	// 同步显示
    	public static final String SYNC_SHOW = "1";
    	// 异步显示
    	public static final String ASYNC_SHOW = "0";
    }
	
	
	public static List<String> getInvoiceApplyTitle(){
		List<String> titleList = new ArrayList<String>();
			titleList.add("序列号");
			titleList.add("订单号码");
			titleList.add("客户名称");
			titleList.add("账户ID");
			titleList.add("手机号码");
			titleList.add("账期");
			titleList.add("收件人");
			titleList.add("联系电话");
			titleList.add("邮编");
			titleList.add("邮寄地址");
			titleList.add("发票类型");
			titleList.add("当前状态");
			titleList.add("申请邮寄时间");
			titleList.add("操作员");
		return titleList;
		
	}
	
	
	/**
	 * 对账明细 Excel文件标题 ReconciliationQueryVo
	 * @return
	 */
	public static List<String> getCheckBillTitle(){
		List<String> titleList = new ArrayList<String>();
			titleList.add("支付平台");
			titleList.add("日期");
			titleList.add("第三方支付平台订单号");
			titleList.add("订单名称");
			titleList.add("订单金额（元）");
			titleList.add("我方订单号");
			titleList.add("我方订单金额（元）");
			titleList.add("差异金额");
		return titleList;
	}
	
}
