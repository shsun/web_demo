package com.shsun.addata.enty.raw;

import com.shsun.addata.enty.raw.ZipCodes;

public interface ZipCodesMapper {
    int deleteByPrimaryKey(Integer id);

    ZipCodes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZipCodes record);

    int updateByPrimaryKey(ZipCodes record);
}