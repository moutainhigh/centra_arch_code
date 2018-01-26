package com.ifudata.ums.service.business.interfaces;


import com.ifudata.ums.api.applybatch.param.OrdApplyBatchRequest;
import com.ifudata.ums.dao.mapper.bo.OrdApplyBatch;

public interface IOrdApplyBatchProcessSV {
	 /**
     * 接收批量业务受理请求
     * 
     * @param request
     * @return
     * @throws Exception
     * @author wangyongxin
     */
     long batchApply(OrdApplyBatchRequest request) throws Exception;
     /**
      * 批次号查询
      * 
      * @param fileName
      * @return
      * @throws Exception
      * @author wangyongxin
      */
     OrdApplyBatch getBatchId(String fileName) throws Exception;
}
