package com.ifudata.ums.service.route;

import java.util.List;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ums.api.applybatch.param.BatchCreditReformDate;
import com.ifudata.ums.api.applybatch.param.OrdApplyBatchBaseInfo;
import com.ifudata.ums.api.applybatch.param.RequestHeader;
import com.ifudata.ums.service.route.parent.AbstractGroupOrdApplyBatch;
import com.ifudata.ums.vo.ApplyBatchDetailBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OrderAppayBatchCreditReform extends AbstractGroupOrdApplyBatch {
	private static Log log = LogFactory.getLog(OrderAppayBatchCreditReform.class);

	@Override
	public List<ApplyBatchDetailBody> analyBatchApplyReqData(
			OrdApplyBatchBaseInfo baseInfo, RequestHeader requestHeader)
			throws Exception {
		log.debug("开始解析批量重做请求的业务报文");
		if(!(baseInfo instanceof BatchCreditReformDate)){
			throw new SystemException("批量重做业务请求解析失败，类型不匹配");
		}
		
		return null;
	}

}
