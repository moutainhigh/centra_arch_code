package com.ifudata.ic.dshm.dao.interfaces;

import com.ifudata.ic.dshm.dto.EbillingShmTableDb;
import com.ifudata.ic.dshm.dto.EbillingShmTableDbCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EbillingShmTableDbMapper {
    int countByExample(EbillingShmTableDbCriteria example);

    int deleteByExample(EbillingShmTableDbCriteria example);

    int deleteByPrimaryKey(String dbConnect);

    int insert(EbillingShmTableDb record);

    int insertSelective(EbillingShmTableDb record);

    List<EbillingShmTableDb> selectByExample(EbillingShmTableDbCriteria example);

    EbillingShmTableDb selectByPrimaryKey(String dbConnect);

    int updateByExampleSelective(@Param("record") EbillingShmTableDb record, @Param("example") EbillingShmTableDbCriteria example);

    int updateByExample(@Param("record") EbillingShmTableDb record, @Param("example") EbillingShmTableDbCriteria example);

    int updateByPrimaryKeySelective(EbillingShmTableDb record);

    int updateByPrimaryKey(EbillingShmTableDb record);
}