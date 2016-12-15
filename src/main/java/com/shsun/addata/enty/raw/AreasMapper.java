package com.shsun.addata.enty.raw;

import com.shsun.addata.enty.raw.Areas;

public interface AreasMapper {
    int deleteByPrimaryKey(Integer id);

    Areas selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Areas record);

    int updateByPrimaryKey(Areas record);
}