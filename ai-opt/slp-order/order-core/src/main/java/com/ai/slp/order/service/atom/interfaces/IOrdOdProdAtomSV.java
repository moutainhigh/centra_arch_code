package com.ai.slp.order.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.order.dao.mapper.bo.OrdOdProd;
import com.ai.slp.order.dao.mapper.bo.OrdOdProdCriteria;

public interface IOrdOdProdAtomSV {
	
	int countByExample(OrdOdProdCriteria example);
	
    int insertSelective(OrdOdProd record);

    List<OrdOdProd> selectByExample(OrdOdProdCriteria example);
   
    List<OrdOdProd> selectOrdProd(String tenantId,long orderId,String cusServiceFlag);

    int updateById(OrdOdProd ordOdProd);
    
    int updateCusServiceFlag(OrdOdProd ordOdProd);
    
    OrdOdProd selectByPrimaryKey(long prodDetalId);
    
    List<OrdOdProd> selectSaleProd(String tenantId,long orderId,String skuId);
    
    List<OrdOdProd> selectByOrd(String tenantId,long orderId);
    
    List<OrdOdProd> selectByProdName(String tenantId,String prodName);
    
    int updateByExampleSelective(@Param("record") OrdOdProd record, @Param("example") OrdOdProdCriteria example);
    
}
