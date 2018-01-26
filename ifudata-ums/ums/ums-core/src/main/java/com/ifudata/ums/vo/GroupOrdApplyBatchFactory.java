package com.ifudata.ums.vo;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ums.dao.mapper.bo.OrdServiceRouteConfig;
import com.ifudata.ums.service.atom.interfaces.IOrdSerRouteConfigSV;
import com.ifudata.ums.service.route.parent.AbstractGroupOrdApplyBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashMap;


public class GroupOrdApplyBatchFactory {
	@Autowired
	private static IOrdSerRouteConfigSV serRouteConfigSV;

	 private static HashMap<String, AbstractGroupOrdApplyBatch> baseGroupMap = new HashMap<String, AbstractGroupOrdApplyBatch>();

	    /**
	     * 获取批量业务处理组件实现类
	     * 
	     * @param busiType
	     * @return
	     * @author zhaixs
	     * @throws Exception 
	     */
	    public static AbstractGroupOrdApplyBatch getInstance(String busiType) throws Exception {
	        if (!baseGroupMap.containsKey(busiType)) {
	            /* 1.获取配置的服务标识 */
	        	OrdServiceRouteConfig queryByType = serRouteConfigSV.queryByType(busiType);
	            String serviceId = queryByType.getRouteService();
	            /* 2.获取对应的实例 */
	            if (!StringUtils.isEmpty(serviceId)) {
	                AbstractGroupOrdApplyBatch base = AbstractGroupOrdApplyBatch.getInstance(serviceId);
	                base.setBusiType(busiType);
	                baseGroupMap.put(busiType, base);
	            }
	        }
	        AbstractGroupOrdApplyBatch group = baseGroupMap.get(busiType);
	        if (group == null) {
	            throw new SystemException("没有配置批量业务类型BUSI_TYPE为[" + busiType + "]的组件实现类");
	        }
	        return group;
	    }


}
