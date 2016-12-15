package com.shsun.addata.enty.raw;

import com.shsun.addata.enty.raw.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}