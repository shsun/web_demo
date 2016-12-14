package com.shsun.addata.vo;

import com.shsun.addata.vo.Channel;

public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}