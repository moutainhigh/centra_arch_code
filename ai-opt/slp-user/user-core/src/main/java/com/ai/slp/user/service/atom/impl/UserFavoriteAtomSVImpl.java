package com.ai.slp.user.service.atom.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ai.slp.user.dao.mapper.bo.UcUserFavorite;
import com.ai.slp.user.dao.mapper.bo.UcUserFavoriteCriteria;
import com.ai.slp.user.dao.mapper.interfaces.UcUserFavoriteMapper;
import com.ai.slp.user.service.atom.interfaces.IUserFavoriteAtomSV;

@Component
public class UserFavoriteAtomSVImpl implements IUserFavoriteAtomSV {

    @Autowired
    private transient UcUserFavoriteMapper userFavoriteMapper;
    
    @Override
    public int insert(UcUserFavorite record) {
        return userFavoriteMapper.insert(record);
    }

    @Override
    public int updateByExample(UcUserFavorite record, UcUserFavoriteCriteria example) {
        return userFavoriteMapper.updateByExample(record, example);
    }

    @Override
    public int deleteByExample(UcUserFavoriteCriteria example) {
        return userFavoriteMapper.deleteByExample(example);
    }

    @Override
    public List<UcUserFavorite> selectByExample(UcUserFavoriteCriteria example) {
        return userFavoriteMapper.selectByExample(example);
    }

    @Override
    public int countByExample(UcUserFavoriteCriteria example) {
        return userFavoriteMapper.countByExample(example);
    }

    @Override
    public int updateByExampleSelective(UcUserFavorite record, UcUserFavoriteCriteria example) {
        return userFavoriteMapper.updateByExampleSelective(record, example);
    }

}
