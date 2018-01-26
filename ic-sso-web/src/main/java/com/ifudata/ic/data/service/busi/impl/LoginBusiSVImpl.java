package com.ifudata.ic.data.service.busi.impl;

import com.ifudata.centra.base.exception.BusinessException;
import com.ifudata.ic.data.dao.mapper.bo.SysUser;
import com.ifudata.ic.data.service.atom.interfaces.ILoginAtomSV;
import com.ifudata.ic.data.service.busi.interfaces.ILoginBusiSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LoginBusiSVImpl implements ILoginBusiSV {
    @Autowired
    ILoginAtomSV iLoginAtomSV;

    @Override
    public SysUser queryByUserName(SysUser user) throws BusinessException {

        return iLoginAtomSV.queryByUserName(user);

    }

}
