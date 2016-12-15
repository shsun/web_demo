package com.shsun.addata.enty.raw;

import com.shsun.addata.enty.raw.Provinces;

public interface ProvincesMapper {
    int deleteByPrimaryKey(Integer id);

    Provinces selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Provinces record);

    int updateByPrimaryKey(Provinces record);
}