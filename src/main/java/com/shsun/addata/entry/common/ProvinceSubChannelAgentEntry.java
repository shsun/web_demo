package com.shsun.addata.entry.common;

import com.shsun.addata.entry.channel.ISubChannelAgentEntry;
import com.shsun.addata.entry.city.ProvinceEntry;

/**
 * 
 * @author shsun
 * 
 */
public class ProvinceSubChannelAgentEntry extends ProvinceEntry implements ISubChannelAgentEntry {

	private Integer CHANNEL_AGENT_ID;

	public Integer getCHANNEL_AGENT_ID() {
		return CHANNEL_AGENT_ID;
	}

	public void setCHANNEL_AGENT_ID( Integer CHANNEL_AGENT_ID ) {
		this.CHANNEL_AGENT_ID = CHANNEL_AGENT_ID;
	}

	private Integer SUB_CHANNEL_AGENT_ID;

	public Integer getSUB_CHANNEL_AGENT_ID() {
		return SUB_CHANNEL_AGENT_ID;
	}

	public void setSUB_CHANNEL_AGENT_ID( Integer SUB_CHANNEL_AGENT_ID ) {
		this.SUB_CHANNEL_AGENT_ID = SUB_CHANNEL_AGENT_ID;
	}

}
