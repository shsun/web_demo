package com.shsun.addata.vo;

import com.shsun.addata.vo.Cities;

public interface CitiesMapper {
    int deleteByPrimaryKey(Integer id);

    Cities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cities record);

    int updateByPrimaryKey(Cities record);
}