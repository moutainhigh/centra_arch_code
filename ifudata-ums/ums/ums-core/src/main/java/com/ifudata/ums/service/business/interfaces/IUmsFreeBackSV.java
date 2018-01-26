package com.ifudata.ums.service.business.interfaces;


import com.ifudata.centra.base.vo.PageInfo;
import com.ifudata.ums.api.applybatch.param.OrdSendStatusRequest;
import com.ifudata.ums.api.applybatch.param.SendStatusInfo;

public interface IUmsFreeBackSV {
  PageInfo<SendStatusInfo> getPageInfo(OrdSendStatusRequest request, Long batchId) throws Exception;
}
