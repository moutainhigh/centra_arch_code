package com.ifudata.ums.service.atom.interfaces;


import com.ifudata.ums.dao.mapper.bo.OrdApplyBatchDetailWithBLOBs;

import java.util.List;

public interface IOrdAppayBatchDetailSV {
 void sava(OrdApplyBatchDetailWithBLOBs bean) throws Exception;
 void sava(List<OrdApplyBatchDetailWithBLOBs> beans) throws Exception;
}
