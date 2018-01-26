package com.ifudata.dvp.pay.api.terminalorgrelquery.interfaces;


import java.util.List;

import com.ifudata.dvp.pay.api.terminalorgrelquery.param.TerminalOrgRelQryParam;
import com.ifudata.dvp.pay.api.terminalorgrelquery.param.TerminalOrgRelVo;

/**
 * 终端与支付机构关系查询服务.<br>
 * Date: 2015年8月20日 <br>
 * 
 */
public interface ITerminalOrgRelQuerySV {

    /**
     * 查询租户在对应终端来源下所支持的支付方式<br>
     * @param param 终端与支付机构关系查询请求参数，其中租户ID、终端来源必填
     * @return 终端与支付机构关系列表
     * @ApiDocMethod 
     * @ApiCode PAY_0004
     */
    List<TerminalOrgRelVo> queryTerminalOrgRels(TerminalOrgRelQryParam param) ; 
    
}
