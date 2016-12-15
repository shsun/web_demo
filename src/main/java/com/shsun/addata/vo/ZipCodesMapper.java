package com.shsun.addata.vo;

import com.shsun.addata.vo.ZipCodes;

public interface ZipCodesMapper {
    int deleteByPrimaryKey(Integer id);

    ZipCodes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ZipCodes record);

    int updateByPrimaryKey(ZipCodes record);
}