package com.ai.slp.user.dao.mapper.interfaces;

import com.ai.slp.user.dao.mapper.bo.UcUserFavorite;
import com.ai.slp.user.dao.mapper.bo.UcUserFavoriteCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UcUserFavoriteMapper {
    int countByExample(UcUserFavoriteCriteria example);

    int deleteByExample(UcUserFavoriteCriteria example);

    int insert(UcUserFavorite record);

    int insertSelective(UcUserFavorite record);

    List<UcUserFavorite> selectByExample(UcUserFavoriteCriteria example);

    int updateByExampleSelective(@Param("record") UcUserFavorite record, @Param("example") UcUserFavoriteCriteria example);

    int updateByExample(@Param("record") UcUserFavorite record, @Param("example") UcUserFavoriteCriteria example);
}