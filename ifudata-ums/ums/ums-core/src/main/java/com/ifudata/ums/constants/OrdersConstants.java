package com.ifudata.ums.constants;

public class OrdersConstants {

	public static final String YES = "YES";

	public static final String NO = "NO";

	/**
	 * Title: ums-CRM <br>
	 * Description:全系统唯一的支付方式，其它表里的PAY_TYPE引用 <br>
	 * Date: 2014年6月4日 <br>
	 * Copyright (c) 2014 AILK <br>
	 * 
	 * @author zhaixs
	 */


	public static class OrdApplyBatch {

		public static class BusiType {

			/**
			 * 1.批量开户
			 */
			public static final String BATCH_OPEN_ACCOUNT = "1";

			/**
			 * 3.批量预销户
			 */
			public static final String BATCH_PRE_CANCEL_ACCOUNT = "3";

			/**
			 * 4.批量正式销户
			 */
			public static final String BATCH_CANCEL_ACCOUNT = "4";

			/**
			 * 5.强制销户
			 */
			public static final String BATCH_FORCE_CANCEL_ACCOUNT = "5";

			/**
			 * 6.批量预开户
			 */
			public static final String BATCH_PRE_OPEN_ACCOUNT = "6";

			/**
			 * 7.批量加入集团客户
			 */
			public static final String BATCH_JOIN_GROUP_CUST = "7";

			/**
			 * 8.批量退出集团客户
			 */
			public static final String BATCH_EXIT_GROUP_CUST = "8";

			/**
			 * 9.强制销户
			 */
			public static final String BATCH_CANCELLATION = "21";

		}

		public static class State {

			/**
			 * 1.已提交
			 */
			public static final String SUBMITTED = "1";

			/**
			 * 2.处理中
			 */
			public static final String PROCESSING = "2";

			/**
			 * 3.完成
			 */
			public static final String PAID = "3";

			



		}

		public static class DealState {
			// 待处理
			public static final String WAIT_DEAL = "0";

			// 处理中
			public static final String PROCESSING = "1";

			// 处理完成
			public static final String COMMITTED = "2";
		}
	}

	public static class OrdApplyBatchDetail {

		public static class State {
			/**
			 * 0：未处理
			 */
			public static final String UNDO = "1";

			/**
			 * 2：处理成功；
			 */
			public static final String SUCCESS = "2";

			/**
			 * 3：处理失败
			 */
			public static final String FAILURE = "3";

		}
	}

		public static class ServiceRoute {

			// 服务类型
			public static class ServiceType {

			

				// 批量业务
				public static final String ABSTRACT_APPLY_BATCH = "AbstractGroupOrdApplyBatch";

			
			}

		}

	}

