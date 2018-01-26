package com.ifudata.ic.data.service.busi.interfaces;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.ic.data.dao.mapper.bo.SysUser;

public interface ILoginBusiSV {
    SysUser queryByUserName(SysUser user) throws BusinessException;
    
}
