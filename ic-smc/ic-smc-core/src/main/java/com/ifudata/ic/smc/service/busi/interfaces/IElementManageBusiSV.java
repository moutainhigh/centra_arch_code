package com.ifudata.ic.smc.service.busi.interfaces;

import com.ifudata.dvp.base.exception.BusinessException;
import com.ifudata.dvp.base.vo.PageInfo;
import com.ifudata.ic.smc.api.elementmanage.param.ElementSearchRequest;
import com.ifudata.ic.smc.api.elementmanage.param.ElementSearchResponseVO;
import com.ifudata.ic.smc.dao.mapper.bo.StlElement;

public interface IElementManageBusiSV {

	   void createElement(StlElement stlElement);
	   
	   void deleteElement(Long elementId,String tenantId)throws BusinessException;
	   
	   
	   void updateElement(StlElement stlElement);
	   
	   StlElement searchElementById(Long elementId) throws BusinessException;
	   
	   
	   PageInfo<ElementSearchResponseVO> searchElementList(ElementSearchRequest elementSearchRequest);
	   
	   boolean checkElementCode(StlElement stlElement);
}
