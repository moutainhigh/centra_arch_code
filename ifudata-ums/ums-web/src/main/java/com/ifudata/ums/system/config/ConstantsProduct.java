package com.ifudata.ums.system.config;

/**
 * 产品相关静态常量 Title: ums-CRM <br>
 * Description: <br>
 * Date: 2014年3月25日 <br>
 * Copyright (c) 2014 ifudata <br>
 * 
 * @author moubd
 */
public class ConstantsProduct {
    /**
     * Title: ums-CRM <br>
     * Description: 产品ID<br>
     * Date: 2014年6月13日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author moubd
     */
    public static class ProductId{
        //来电显示
        public static final String LDXS_PRODUCT = "1000300010";
    }
    
	public static class ProductClass {
		public static final String MAIN_PRODUCT = "1";// 主产品
		public static String SON_PRODUCT = "2";// 子产品
	}
	/**
	 * 生失效区别类型
	 * Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年8月27日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author NeoEvan
	 */
	public static class OpType{
		/**
		 * 老用户订购
		 */
		public static final String OLD_USER_SUBS="1";
		/**
		 * 老用户退订
		 */
		public static final String OLD_USER_CANCEL="2";
		/**
		 * 新用户订购
		 */
		public static final String NEW_USER_SUBS="3";
		/**
		 * 新用户退订
		 */
		public static final String NEW_USER_CANCEL="4";
	}

	/**
	 * 产品类型 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月16日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class PruoductType {
		/* 流量叠加包 10002 */
		public static final String LLDJB = "10002";
		/* 语音叠加包 10004 */
		public static final String YYDJB = "10004";
		/* 漫游产品 10005 */
		public static final String MYPP = "10005";
		/* 短信叠加包 10007 */
		public static final String DXDJB = "10007";
		/* 联通增值产品 10003 */
		public static final String LTZZCP = "10003";
		/* 加油叠加包 10010 */
        public static final String JYDJB = "10010";

		/* 流量叠加包 10002 */
		public static final String LLDJB_TEXT = "流量叠加包";
		/* 语音叠加包 10004 */
		public static final String YYDJB_TEXT = "语音叠加包";
		/* 漫游产品 10005 */
		public static final String MYPP_TEXT = "漫游产品 ";
		/* 短信叠加包 10007 */
		public static final String DXDJB_TEXT = "短信叠加包";
		/* 联通增值产品 10003 */
		public static final String LTZZCP_TEXT = "特服产品";
		/* 加油叠加包 10010 */
        public static final String JYDJB_TEXT = "加油叠加包";

		/* 产品当月资费：0 当月生效 1次月生效 */
		public static final String EFFECTDATE_CURRENT_MONTH = "0";
		public static final String EFFECTDATE_NEXT_MONTH = "1";
		/**
		 * 通讯类 - 主产品
		 */
		public static final String TXL_ZCP = "10001";
		/**
		 * 主产品合约类 - 存费送费合约主产品
		 */
		public static final String HWL_CFSHY = "20001";
		/**
		 * 主产品合约类 - 存费送实物合约主产品
		 */
		public static final String HWL_CFSSW = "20002";
		
		/**
		 *20003   合约类 - 存费送通讯业务合约(如：送1G流量
		*/	
		public static final String HDL_CFSTXYW="20003";
		/**
		 * 20004   合约类 - 购机送费
		 */
		public static final String HDL_GJSHF="20004";
		/**
		 * 20005   合约类 - 存费送其他业务合约(无实体，如期货咨询、VIP服务
		 */
		public static final String HDL_CFSQTYW="20005";
		/**
		 * 20006   合约类 - 存费送费合约        
		 */
		public static final String HDL_CFSHFHY="20006";
		/**
		 * 20007   合约类 - 存费送实物合约 
		 */
		public static final String HDL_CFSSWHY="20007";
		/**
		 * 20008   合约类 - 靓号活动合约
		 */
		public static final String HDL_LHHDHY="20008";
		/**
		 * 20009   合约类 - 购家电送费
		 */
		public static final String HDL_GJDSF="20009";
		/**
		 * 20011   合约类 - 存费送补贴卡
		 */
		public static final String HDL_CFSBTK="20011";
		/**
		 * 20012 合约类 - 员工卡转合约
		 */
		public static final String HDL_YGKZHY="20012";

	}

	/**
	 * 产品内涵元素 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月16日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class ElementType {
		// 余额中心相关元素
		public static final String AMOUNT = "AMOUNT";
		// MU：通讯类资费相关元素
		public static final String MU = "MU";
		// MATERIAL：实物元素
		public static final String MATERIAL = "MATERIAL";
		// PROTO：协议元素（含补贴）
		public static final String PROTO = "PROTO";
		// DEPOSIT：押金
		public static final String DEPOSIT = "DEPOSIT";
	}

	/**
	 * 协议元素 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月16日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class PmProto {
		/*
		 * 周期单位
		 */
		public static class PeriodUnit {
			public static final String YEAR = "年";
			public static final String MONTH = "月";
			public static final String DAY = "日";

			public static final String YEAR_VALUE = "3";
			public static final String MONTH_VALUE = "2";
			public static final String DAY_VALUE = "1";
		}
	}

	/**
	 * 物料元素 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月16日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class PmMaterial {
		public static class MeterialType {
			// 1、终端类（串号精确管理）
			public static final String TERMINAL = "1";
			// 2、礼品类（数量管理）
			public static final String GIFT_MANAGER = "2";
			// 3、礼品类（不管理）
			public static final String GIFT_NOT_MANAGER = "3";
		}
	}

	/**
	 * 余额中心 Title: ums-CRM <br>
	 * Description: <br>
	 * Date: 2014年3月19日 <br>
	 * Copyright (c) 2014 ifudata <br>
	 * 
	 * @author moubd
	 */
	public static class Amount {
		// 余额类型
		public static class AmountType {
			// 1、转兑规则
			public static final String TURN_RULE = "1";
			// 2、指定账本
			public static final String FIXED_AMOUNT = "2";
			// 3、积分（若存于余额中心，则不需要独立type）
			public static final String INTEGRAL = "3";
		}
	}
	
    /**
     * 
     * Title: ums-CRM <br>
     * Description: 订购用户类型<br>
     * Date: 2014年4月10日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author suntq
     */
    public static class SUBS_TYPE{
        //用户
        public static final String SUBS_TYPE_USER = "1";
        //群组
        public static final String SUBS_TYPE_GROUP = "2";
    }
    
    /**
     * 
     * Title: ums-CRM <br>
     * Description: 特服类型<br>
     * Date: 2014年4月9日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author lirong
     */
    public static class PE_TYPE{
        //收费特服1
        public static final String PE_TYPE_SF = "1";
        //不收费为2
        public static final String PE_TYPE_BSF = "2";
        //呼叫转移为3
        public static final String PE_TYPE_HJZY = "3";
        //运营商增值业务为3
        public static final String PE_TYPE_YYSZZYW = "4";
        //虚拟运营商增值业务为3
        public static final String PE_TYPE_XNYYSZZYW = "5";
    }
    /**
     * PE业务编码
     * Title: ums-CRM <br>
     * Description: <br>
     * Date: 2014年6月5日 <br>
     * Copyright (c) 2014 ifudata <br>
     * 
     * @author NeoEvan
     */
    public static class PE_ID{
    	/**
    	 * 来电显示
    	 */
    	public static final String PE_ID_LDXS="LDXS";
    }
    /**
     * 产品变更标志
     */
    public static class CHANGE_FLAG{
    	/**
    	 * 订购
    	 */
        public static final String DING_GOU = "1";
        /**
         * 退订
         */
        public static final String TUI_DING = "2";

    }  
    /**
     * 订单类型
     */
    public static class ORDER_TYPE{
    	/**
    	 * 正常单
    	 */
        public static final String NORMAL = "1";
        /**
         * 撤销单
         */
        public static final String CANCEL = "2";

    }  
}
