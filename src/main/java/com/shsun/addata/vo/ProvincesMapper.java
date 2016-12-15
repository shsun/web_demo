package com.shsun.addata.vo;

import com.shsun.addata.vo.Provinces;

public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);
}