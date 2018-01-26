/*
package com.ifudata.ums.system.base;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ifudata.client.filter.interf.CustomMenuService;
import com.ifudata.ums.crm.api.base.vo.RequestHeader;
import com.ifudata.ums.crm.api.base.vo.ResponseHeader;
import com.ifudata.ums.crm.api.commons.rolemenumaintain.interfaces.IGnMenuDubboSV;
import com.ifudata.ums.crm.api.commons.rolemenumaintain.param.MenuMaintainRequest;
import com.ifudata.ums.crm.api.commons.rolemenumaintain.param.MenuMaintainResponse;

public class CrmCustomMenuServiceImp implements CustomMenuService {
	private static final Log logger = LogFactory.getLog(CrmCustomMenuServiceImp.class);

	@Override
	public List<String> getAllMenuUrls() {
		logger.debug("-------------------------------------------获取操作员功能菜单列表---------------------------------------------begin");
		IGnMenuDubboSV iGnMenuDubboSV = (IGnMenuDubboSV)BeanFactory.getBean("iGnMenuDubboSV");
		MenuMaintainRequest menuRequest = new MenuMaintainRequest();
		RequestHeader  rh = new RequestHeader();
		rh.setApplyChlId("1");
		rh.setOperId(1l);
		menuRequest.setRequest(rh);
		menuRequest.setOperId(1l);
		MenuMaintainResponse menuRes = iGnMenuDubboSV.queryRoleMenuUrlList(menuRequest);
		ResponseHeader res = menuRes.getResponse();
		if(!"000000".equals(res.getResultCode())){
			//throw new Exception(menuRes.getResponse().getResultMessage());
		}
		logger.debug("-------------------------------------------获取操作员功能菜单列表---------------------------------------------end");
		return menuRes.getUrList();
	}

}
*/
