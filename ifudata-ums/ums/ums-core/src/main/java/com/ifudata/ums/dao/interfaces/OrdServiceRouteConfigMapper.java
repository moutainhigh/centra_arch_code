package com.ifudata.ums.dao.interfaces;

import com.ifudata.ums.dao.mapper.bo.OrdServiceRouteConfig;
import com.ifudata.ums.dao.mapper.bo.OrdServiceRouteConfigCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdServiceRouteConfigMapper {
    int countByExample(OrdServiceRouteConfigCriteria example);

    int deleteByExample(OrdServiceRouteConfigCriteria example);

    int deleteByPrimaryKey(Long routeId);

    int insert(OrdServiceRouteConfig record);

    int insertSelective(OrdServiceRouteConfig record);

    List<OrdServiceRouteConfig> selectByExampleWithBLOBs(OrdServiceRouteConfigCriteria example);

    List<OrdServiceRouteConfig> selectByExample(OrdServiceRouteConfigCriteria example);

    OrdServiceRouteConfig selectByPrimaryKey(Long routeId);

    int updateByExampleSelective(@Param("record") OrdServiceRouteConfig record, @Param("example") OrdServiceRouteConfigCriteria example);

    int updateByExampleWithBLOBs(@Param("record") OrdServiceRouteConfig record, @Param("example") OrdServiceRouteConfigCriteria example);

    int updateByExample(@Param("record") OrdServiceRouteConfig record, @Param("example") OrdServiceRouteConfigCriteria example);

    int updateByPrimaryKeySelective(OrdServiceRouteConfig record);

    int updateByPrimaryKeyWithBLOBs(OrdServiceRouteConfig record);

    int updateByPrimaryKey(OrdServiceRouteConfig record);
}