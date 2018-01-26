package com.ifudata.ums.utils;

import com.ifudata.centra.sdk.component.sequence.util.SeqUtil;
import com.ifudata.centra.sdk.util.DateUtil;
import com.ifudata.ums.constants.OrdersSeqConstants;

public class UmsSeqUtil {
	 public static Long createOrdApplyBatchId() {
	        String date = DateUtil.getDateString("yyyyMMdd");
	        String seq = SeqUtil.getNewId(OrdersSeqConstants.ORD_APPLY_BATCH$BATCH_ID$SEQ, 9);
	        String batchId = date + seq;
	        return Long.valueOf(batchId);
	    }
	    public static Long createOrdApplyBatchDetailId() {
	        Long seq = SeqUtil.getNewId(OrdersSeqConstants.ORD_APPLY_BATCH_DETAIL$DETAIL_ID$SEQ);
	        return seq;
	    }
}
