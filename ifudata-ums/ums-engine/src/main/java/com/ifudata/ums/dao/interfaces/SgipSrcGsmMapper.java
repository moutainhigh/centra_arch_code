package com.ifudata.ums.dao.interfaces;

import com.ifudata.ums.dao.mapper.bo.SgipSrcGsm;
import com.ifudata.ums.dao.mapper.bo.SgipSrcGsmCriteria;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SgipSrcGsmMapper {
    int countByExample(SgipSrcGsmCriteria example);

    int deleteByExample(SgipSrcGsmCriteria example);

    int insert(SgipSrcGsm record);

    int insertSelective(SgipSrcGsm record);

    int insertToBackup(@Param("currmonth") String currmonth, @Param("record") SgipSrcGsm record);
    
    List<SgipSrcGsm> selectByExample(SgipSrcGsmCriteria example);

    int updateByExampleSelective(@Param("record") SgipSrcGsm record, @Param("example") SgipSrcGsmCriteria example);

    int updateByExample(@Param("record") SgipSrcGsm record, @Param("example") SgipSrcGsmCriteria example);
}