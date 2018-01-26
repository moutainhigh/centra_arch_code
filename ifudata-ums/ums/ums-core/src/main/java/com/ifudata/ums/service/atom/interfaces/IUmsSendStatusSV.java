package com.ifudata.ums.service.atom.interfaces;


import com.ifudata.ums.api.applybatch.param.OrdSendStatusRequest;
import com.ifudata.ums.dao.mapper.bo.UmsSendStatus;

import java.util.List;

public interface IUmsSendStatusSV {
  List<UmsSendStatus> getBeans(OrdSendStatusRequest request, long batchId)  throws Exception ;
  int getBeansCount(OrdSendStatusRequest request, long batchId)  throws Exception ;
}
