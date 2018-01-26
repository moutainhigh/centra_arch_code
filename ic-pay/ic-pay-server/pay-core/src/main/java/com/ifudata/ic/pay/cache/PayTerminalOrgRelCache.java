package com.ifudata.ic.pay.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ifudata.centra.sdk.cache.base.AbstractCache;
import com.ifudata.centra.sdk.component.mcs.MCSClientFactory;
import com.ifudata.centra.sdk.component.mcs.interfaces.ICacheClient;
import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ic.pay.api.terminalorgrelquery.param.TerminalOrgRelVo;
import com.ifudata.ic.pay.constants.CacheNSMapper;
import com.ifudata.ic.pay.dao.mapper.bo.PayTerminalOrgRel;
import com.ifudata.ic.pay.dao.mapper.bo.PayTerminalOrgRelCriteria;
import com.ifudata.ic.pay.dao.mapper.factory.MapperFactory;

/**
 * 终端与支付机构关系缓存
 *
 * Date: 2015年11月5日 <br>
 */
@Component
public class PayTerminalOrgRelCache extends AbstractCache  {

    public void write() throws Exception {
        List<PayTerminalOrgRel> payTerminalOrgRelList = MapperFactory.getChgTerminalOrgRelMapper()
                .selectByExample(new PayTerminalOrgRelCriteria());
        if (CollectionUtil.isEmpty(payTerminalOrgRelList)) {
            return;
        }

//        ICacheClient cacheClient = CacheFactoryUtil
//                .getCacheClient(CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL);

        ICacheClient cacheClient = MCSClientFactory.getDefaultCacheClient();
        
        Map<String, List<TerminalOrgRelVo>> terminalOrgRelVoMap = new HashMap<String, List<TerminalOrgRelVo>>();
        for (PayTerminalOrgRel payTerminalOrgRel : payTerminalOrgRelList) {
            TerminalOrgRelVo relVo = new TerminalOrgRelVo();
            relVo.setTenantId(payTerminalOrgRel.getTenantId());
            relVo.setRequestSource(payTerminalOrgRel.getRequestSource());
            relVo.setPayOrgCode(payTerminalOrgRel.getPayOrgCode());
            relVo.setIcoName(payTerminalOrgRel.getIcoName());
            String key = payTerminalOrgRel.getTenantId() + "."
                    + payTerminalOrgRel.getRequestSource();
            List<TerminalOrgRelVo> relVoList = terminalOrgRelVoMap.get(key);
            if(relVoList == null) {
                relVoList = new ArrayList<TerminalOrgRelVo>();
                terminalOrgRelVoMap.put(key, relVoList);
            }
            relVoList.add(relVo);
        }

        for(Map.Entry<String, List<TerminalOrgRelVo>> entry : terminalOrgRelVoMap.entrySet()) {
            cacheClient.hset(CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL, entry.getKey(),
                    JSON.toJSONString(entry.getValue()));
//        	RedisUtil.hset(entry.getKey(), CacheNSMapper.CACHE_PAY_TERMINAL_ORG_REL, JSON.toJSONString(entry.getValue()));

        }
    }

}
