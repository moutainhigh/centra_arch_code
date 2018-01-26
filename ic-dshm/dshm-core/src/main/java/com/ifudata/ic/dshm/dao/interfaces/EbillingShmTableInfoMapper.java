package com.ifudata.ic.dshm.dao.interfaces;

import com.ifudata.ic.dshm.dto.EbillingShmTableInfo;
import com.ifudata.ic.dshm.dto.EbillingShmTableInfoCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EbillingShmTableInfoMapper {
    int countByExample(EbillingShmTableInfoCriteria example);

    int deleteByExample(EbillingShmTableInfoCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(EbillingShmTableInfo record);

    int insertSelective(EbillingShmTableInfo record);

    List<EbillingShmTableInfo> selectByExample(EbillingShmTableInfoCriteria example);

    EbillingShmTableInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EbillingShmTableInfo record, @Param("example") EbillingShmTableInfoCriteria example);

    int updateByExample(@Param("record") EbillingShmTableInfo record, @Param("example") EbillingShmTableInfoCriteria example);

    int updateByPrimaryKeySelective(EbillingShmTableInfo record);

    int updateByPrimaryKey(EbillingShmTableInfo record);
    
    int maxByTableId();
}