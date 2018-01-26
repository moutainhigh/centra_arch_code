package com.ifudata.ic.pay.dao.mapper.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ifudata.ic.pay.dao.mapper.bo.PayCenterLogState;
import com.ifudata.ic.pay.dao.mapper.bo.PayCenterLogStateCriteria;

public interface PayCenterLogStateMapper {
    int countByExample(PayCenterLogStateCriteria example);

    int deleteByExample(PayCenterLogStateCriteria example);

    int insert(PayCenterLogState record);

    int insertSelective(PayCenterLogState record);

    List<PayCenterLogState> selectByExample(PayCenterLogStateCriteria example);

    int updateByExampleSelective(@Param("record") PayCenterLogState record, @Param("example") PayCenterLogStateCriteria example);

    int updateByExample(@Param("record") PayCenterLogState record, @Param("example") PayCenterLogStateCriteria example);
}