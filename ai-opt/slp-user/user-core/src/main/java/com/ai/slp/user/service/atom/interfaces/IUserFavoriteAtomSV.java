package com.ai.slp.user.service.atom.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.slp.user.dao.mapper.bo.UcUserFavorite;
import com.ai.slp.user.dao.mapper.bo.UcUserFavoriteCriteria;

public interface IUserFavoriteAtomSV {
    int insert(UcUserFavorite record);

    int updateByExample(@Param("record") UcUserFavorite record,
            @Param("example") UcUserFavoriteCriteria example);

    int deleteByExample(UcUserFavoriteCriteria example);

    List<UcUserFavorite> selectByExample(UcUserFavoriteCriteria example);

    int countByExample(UcUserFavoriteCriteria example);

    int updateByExampleSelective(@Param("record") UcUserFavorite record,
            @Param("example") UcUserFavoriteCriteria example);
}
