package com.ifudata.ic.data.service.busi.impl;

import com.ifudata.centra.base.exception.SystemException;
import com.ifudata.ic.data.service.atom.interfaces.ISysUserAtomSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifudata.ic.data.dao.mapper.bo.SysUser;
import com.ifudata.ic.data.service.busi.interfaces.IUserBusiSV;

@Service
@Transactional
public class UserBusiSVImpl implements IUserBusiSV {

    @Autowired
    ISysUserAtomSV iSysUserAtomSV;

    @Override
    public SysUser queryByUserId(String userId) throws SystemException {
        return iSysUserAtomSV.queryByUserId(userId);
    }

    

}
