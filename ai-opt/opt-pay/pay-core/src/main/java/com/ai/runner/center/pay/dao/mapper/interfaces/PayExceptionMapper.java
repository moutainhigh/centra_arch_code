package com.ai.runner.center.pay.dao.mapper.interfaces;

import com.ai.runner.center.pay.dao.mapper.bo.PayException;
import com.ai.runner.center.pay.dao.mapper.bo.PayExceptionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayExceptionMapper {
    int countByExample(PayExceptionCriteria example);

    int deleteByExample(PayExceptionCriteria example);

    int insert(PayException record);

    int insertSelective(PayException record);

    List<PayException> selectByExample(PayExceptionCriteria example);

    int updateByExampleSelective(@Param("record") PayException record, @Param("example") PayExceptionCriteria example);

    int updateByExample(@Param("record") PayException record, @Param("example") PayExceptionCriteria example);
}