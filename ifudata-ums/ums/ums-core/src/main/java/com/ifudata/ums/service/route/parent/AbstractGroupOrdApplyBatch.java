package com.ifudata.ums.service.route.parent;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ums.api.applybatch.param.OrdApplyBatchBaseInfo;
import com.ifudata.ums.api.applybatch.param.RequestHeader;
import com.ifudata.ums.vo.ApplyBatchDetailBody;
import org.springframework.util.StringUtils;

import java.util.List;

public abstract class AbstractGroupOrdApplyBatch {
	protected String busiType;
	public static AbstractGroupOrdApplyBatch getInstance(String clazzName) {
		AbstractGroupOrdApplyBatch groupBase = null;
		if (StringUtils.isEmpty(clazzName)) {
			throw new SystemException("获取批量业务处理组件出错：没有指定实现类");
		}
		try {
			groupBase = (AbstractGroupOrdApplyBatch) (Class.forName(clazzName).newInstance());
		} catch (Exception e) {
			throw new SystemException("获取批量业务处理组件出错", e);
		}
		return groupBase;
	}

	/**
	 * 解析传入的批量业务报文，转换成单挑明细信息
	 * 
	 * @param baseInfo
	 * @param requestHeader
	 * @return
	 * @throws Exception
	 * @author zhaixs
	 */
	public abstract List<ApplyBatchDetailBody> analyBatchApplyReqData(
			OrdApplyBatchBaseInfo baseInfo, RequestHeader requestHeader) throws Exception;

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
}
