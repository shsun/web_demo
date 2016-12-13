package com.shsun.addata.entry.common;

import com.shsun.addata.entry.channel.IChannelAgentEntry;
import com.shsun.addata.entry.city.ProvinceEntry;

/**
 * 
 * @author shsun
 *
 */
public class ProvinceChannelAgentEntry extends ProvinceEntry implements IChannelAgentEntry {

	private Integer CHANNEL_AGENT_ID;

	public Integer getCHANNEL_AGENT_ID() {
		return CHANNEL_AGENT_ID;
	}

	public void setCHANNEL_AGENT_ID( Integer CHANNEL_AGENT_ID ) {
		this.CHANNEL_AGENT_ID = CHANNEL_AGENT_ID;
	}

}
