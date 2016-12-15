package com.shsun.addata.enty.raw;

import com.shsun.addata.enty.raw.Cities;

public interface CitiesMapper {
    int deleteByPrimaryKey(Integer id);

    Cities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);
}