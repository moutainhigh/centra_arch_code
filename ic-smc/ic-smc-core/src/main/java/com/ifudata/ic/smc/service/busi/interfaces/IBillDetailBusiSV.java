package com.ifudata.ic.smc.service.busi.interfaces;

import com.ifudata.dvp.base.vo.BaseResponse;
import com.ifudata.dvp.base.vo.HBasePager;
import com.ifudata.ic.smc.api.billdetail.param.BillDetailDataImportRequest;
import com.ifudata.ic.smc.api.billdetail.param.CheckResultDiffDetailQueryRequest;
import com.ifudata.ic.smc.api.billdetail.param.CheckResultQueryRequest;
import com.ifudata.ic.smc.api.billdetail.param.CheckResultQueryResponse;
import com.ifudata.ic.smc.api.billdetail.param.DiffDetailDataInfo;
import com.ifudata.ic.smc.api.billdetail.param.SettlementCheckStartRequest;

public interface IBillDetailBusiSV {

    String importBillDetailData(BillDetailDataImportRequest request);

    BaseResponse startSettlementCheck(SettlementCheckStartRequest request);

    CheckResultQueryResponse queryCheckResult(CheckResultQueryRequest request);

    HBasePager<DiffDetailDataInfo> queryCheckResultDiffDetail(
            CheckResultDiffDetailQueryRequest request);

}
