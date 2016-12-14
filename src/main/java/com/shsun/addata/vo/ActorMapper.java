package com.shsun.addata.vo;

import com.shsun.addata.vo.Actor;

public interface ActorMapper {
    int deleteByPrimaryKey(Integer id);

    Actor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);
}