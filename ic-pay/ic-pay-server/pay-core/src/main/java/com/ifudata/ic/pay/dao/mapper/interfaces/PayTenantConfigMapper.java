package com.ifudata.ic.pay.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ifudata.ic.pay.dao.mapper.bo.PayTenantConfig;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantConfigCriteria;

public interface PayTenantConfigMapper {
    int countByExample(PayTenantConfigCriteria example);

    int deleteByExample(PayTenantConfigCriteria example);

    int insert(PayTenantConfig record);

    int insertSelective(PayTenantConfig record);

    List<PayTenantConfig> selectByExample(PayTenantConfigCriteria example);

    int updateByExampleSelective(@Param("record") PayTenantConfig record, @Param("example") PayTenantConfigCriteria example);

    int updateByExample(@Param("record") PayTenantConfig record, @Param("example") PayTenantConfigCriteria example);
}