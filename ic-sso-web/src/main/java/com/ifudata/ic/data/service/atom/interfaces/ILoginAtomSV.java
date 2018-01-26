package com.ifudata.ic.data.service.atom.interfaces;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ic.data.dao.mapper.bo.SysUser;

public interface ILoginAtomSV {
    SysUser queryByUserName(SysUser user) throws SystemException;
}
