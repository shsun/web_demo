package com.shsun.addata.enty.raw;

import com.shsun.addata.enty.raw.Actor;

public interface ActorMapper {
    int deleteByPrimaryKey(Integer id);

    Actor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Actor record);

    int updateByPrimaryKey(Actor record);
}