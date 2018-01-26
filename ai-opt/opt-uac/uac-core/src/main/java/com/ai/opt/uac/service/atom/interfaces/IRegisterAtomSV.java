package com.ai.opt.uac.service.atom.interfaces;

import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.dao.mapper.bo.GnAccount;

public interface IRegisterAtomSV {
    long registerByPhone(GnAccount account) throws SystemException;

    int getCountByPhone(String phone) throws SystemException;

    int getCountByEmail(String email) throws SystemException;
}
