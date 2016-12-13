package com.shsun.addata.support.vo.channel;


/**
 * 
 * @author shsun
 * 
 */
public class ChannelSubChannelPair {
	private ChannelVO channelVO;
	private SubChannelVO subChannelVO;

	public ChannelSubChannelPair(ChannelVO channelVO, SubChannelVO subChannelVO) {
		this.channelVO = channelVO;
		this.subChannelVO = subChannelVO;
	}

	public ChannelVO getChannelVO() {
		return channelVO;
	}

	public SubChannelVO getSubChannelVO() {
		return subChannelVO;
	}

}
