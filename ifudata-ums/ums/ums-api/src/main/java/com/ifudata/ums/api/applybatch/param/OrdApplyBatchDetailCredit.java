package com.ifudata.ums.api.applybatch.param;

import java.util.ArrayList;
import java.util.List;

public class OrdApplyBatchDetailCredit extends OrdApplyBatchBaseInfo {

	/**
	 * com.ifudata.msg.crm.api.msg.applybatch.OrdApplyBatchDetailCredit
	 *  cannot be cast to com.ifudata.msg.crm.orders.base.AbstractGroupOrdApplyBatch
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BatchAccCreditDate> dateList=new ArrayList<BatchAccCreditDate>();

	public List<BatchAccCreditDate> getDateList() {
		return dateList;
	}

	public void setDateList(List<BatchAccCreditDate> dateList) {
		this.dateList = dateList;
	}
	

}
