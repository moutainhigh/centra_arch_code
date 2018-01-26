package com.ifudata.ums.service.atom.interfaces;


import com.ifudata.ums.dao.mapper.bo.OrdServiceRouteConfig;

public interface IOrdSerRouteConfigSV {
    OrdServiceRouteConfig queryByType(String busiType) throws Exception;
}
