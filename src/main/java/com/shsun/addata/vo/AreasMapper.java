package com.shsun.addata.vo;

import com.shsun.addata.vo.Areas;

public interface AreasMapper {
    int deleteByPrimaryKey(Integer id);

    Areas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Areas record);

    int updateByPrimaryKey(Areas record);
}