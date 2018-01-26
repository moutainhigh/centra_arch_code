package com.ifudata.ums.service.atom.interfaces;


import com.ifudata.ums.dao.mapper.bo.OrdApplyBatch;

public interface IOrdAppayBatchSV {
  void save(OrdApplyBatch bean) throws Exception;
  OrdApplyBatch query(String fileName) throws Exception;
}
