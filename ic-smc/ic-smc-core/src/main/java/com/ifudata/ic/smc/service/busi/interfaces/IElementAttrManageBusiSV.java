package com.ifudata.ic.smc.service.busi.interfaces;

import com.ifudata.ic.smc.dao.mapper.bo.StlElementAttr;

public interface IElementAttrManageBusiSV {
	
	
	 void createElementAttr(StlElementAttr strElementAttr);
	 
	 StlElementAttr searchElementAttrByElementId(Long elementId);
	 
	 void updateElementAttr(StlElementAttr strElementAttr);
	 
}
