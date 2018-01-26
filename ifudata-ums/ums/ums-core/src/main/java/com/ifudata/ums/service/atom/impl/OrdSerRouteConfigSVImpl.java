package com.ifudata.ums.service.atom.impl;


import com.ifudata.centra.sdk.util.CollectionUtil;
import com.ifudata.ums.dao.interfaces.OrdServiceRouteConfigMapper;
import com.ifudata.ums.dao.mapper.bo.OrdServiceRouteConfig;
import com.ifudata.ums.dao.mapper.bo.OrdServiceRouteConfigCriteria;
import com.ifudata.ums.service.atom.interfaces.IOrdSerRouteConfigSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdSerRouteConfigSVImpl implements IOrdSerRouteConfigSV {
	@Autowired
	private OrdServiceRouteConfigMapper ordServiceRouteConfigMapper;

	@Override
	public OrdServiceRouteConfig queryByType(String busiType) throws Exception {
		OrdServiceRouteConfigCriteria criteria = new OrdServiceRouteConfigCriteria();
		criteria.createCriteria().andRouteParamValueEqualTo(busiType);
		List<OrdServiceRouteConfig> ordServiceRouteConfigs = ordServiceRouteConfigMapper.selectByExample(criteria);
		if(CollectionUtil.isEmpty(ordServiceRouteConfigs)){
			throw new Exception("order域paramvalue:"+busiType+"未配置");
		}
		if(ordServiceRouteConfigs.size()>1){
			throw new Exception("order域paramvalue:"+busiType+"配置重复请检查");
		}
		return ordServiceRouteConfigs.get(0);
	}

}
