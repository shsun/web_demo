package com.shsun.addata.vo;

import com.shsun.addata.vo.XCities;

public interface XCitiesMapper {
    int deleteByPrimaryKey(Integer id);

    XCities selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(XCities record);

    int updateByPrimaryKey(XCities record);
}