package com.shsun.addata.vo;

import com.shsun.addata.vo.Item;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}