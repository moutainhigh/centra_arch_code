package com.ifudata.ic.pay.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ifudata.ic.pay.dao.mapper.bo.PayTenantInfo;
import com.ifudata.ic.pay.dao.mapper.bo.PayTenantInfoCriteria;

public interface PayTenantInfoMapper {
    int countByExample(PayTenantInfoCriteria example);

    int deleteByExample(PayTenantInfoCriteria example);

    int deleteByPrimaryKey(String partnerId);

    int insert(PayTenantInfo record);

    int insertSelective(PayTenantInfo record);

    List<PayTenantInfo> selectByExample(PayTenantInfoCriteria example);

    PayTenantInfo selectByPrimaryKey(String partnerId);

    int updateByExampleSelective(@Param("record") PayTenantInfo record, @Param("example") PayTenantInfoCriteria example);

    int updateByExample(@Param("record") PayTenantInfo record, @Param("example") PayTenantInfoCriteria example);

    int updateByPrimaryKeySelective(PayTenantInfo record);

    int updateByPrimaryKey(PayTenantInfo record);
}