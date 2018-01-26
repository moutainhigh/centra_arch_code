package com.ai.slp.order.service.atom.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ai.slp.order.dao.mapper.bo.OrdOdProdExtend;
import com.ai.slp.order.dao.mapper.bo.OrdOdProdExtendCriteria;
import com.ai.slp.order.dao.mapper.factory.MapperFactory;
import com.ai.slp.order.service.atom.interfaces.IOrdOdProdExtendAtomSV;

@Component
public class OrdOdProdExtendAtomSVImpl implements IOrdOdProdExtendAtomSV {

    @Override
    public int insertSelective(OrdOdProdExtend record) {
        return MapperFactory.getOrdOdProdExtendMapper().insertSelective(record);
    }

    @Override
    public List<OrdOdProdExtend> selectByExample(OrdOdProdExtendCriteria example) {
        return MapperFactory.getOrdOdProdExtendMapper().selectByExample(example);
    }

	@Override
	public OrdOdProdExtend selectByPrimaryKey(long prodDetalExtendId) {
		return MapperFactory.getOrdOdProdExtendMapper().selectByPrimaryKey(prodDetalExtendId);
	}

}
