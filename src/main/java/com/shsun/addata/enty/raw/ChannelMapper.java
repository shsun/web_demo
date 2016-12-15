package com.shsun.addata.enty.raw;

import com.shsun.addata.enty.raw.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}