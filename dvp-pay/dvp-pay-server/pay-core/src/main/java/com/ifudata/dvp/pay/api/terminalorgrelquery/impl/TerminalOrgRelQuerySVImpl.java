package com.ifudata.dvp.pay.api.terminalorgrelquery.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.dvp.pay.api.terminalorgrelquery.interfaces.ITerminalOrgRelQuerySV;
import com.ifudata.dvp.pay.api.terminalorgrelquery.param.TerminalOrgRelQryParam;
import com.ifudata.dvp.pay.api.terminalorgrelquery.param.TerminalOrgRelVo;
import com.ifudata.dvp.pay.constants.ExceptCodeConstants;
import com.ifudata.dvp.pay.util.TerminalOrgRelUtil;
import com.ifudata.dvp.sdk.util.CollectionUtil;
import com.ifudata.dvp.sdk.util.StringUtil;

/**
 * 终端与支付机构关系查询服务
 * Date: 2015年8月20日 <br>
 */
@Service
@Component
public class TerminalOrgRelQuerySVImpl implements ITerminalOrgRelQuerySV {

    private static final Log LOG = LogFactory.getLog(TerminalOrgRelQuerySVImpl.class);
        
    @Override
    public List<TerminalOrgRelVo> queryTerminalOrgRels(TerminalOrgRelQryParam param)
             {
        LOG.info("终端与支付机构关系查询开始");
        if (param == null) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:终端与支付机构关系查询请求参数不能为空");
        }
        
        if (StringUtil.isBlank(param.getTenantId())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:租户ID不能为空");
        }
                
        if(StringUtil.isBlank(param.getRequestSource())) {
            throw new BusinessException(ExceptCodeConstants.PARAM_IS_NULL, "获取参数失败:终端来源不能为空");
        }
        
        List<TerminalOrgRelVo> relVoList = TerminalOrgRelUtil.getTerminalOrgRels(
                param.getTenantId(), param.getRequestSource());
        if(CollectionUtil.isEmpty(relVoList)) {
            return new ArrayList<TerminalOrgRelVo>();
        }
        LOG.info("终端与支付机构关系查询结束");
        return relVoList;
    }

}
