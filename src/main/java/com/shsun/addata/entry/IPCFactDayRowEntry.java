package com.shsun.addata.entry;

import com.shsun.addata.entry.channel.IChannelAgentEntry;
import com.shsun.addata.entry.city.IProvinceEntry;

/**
 * 
 * @author shsun
 * 
 */
public interface IPCFactDayRowEntry extends IProvinceEntry, IChannelAgentEntry {

	// -----------------------------------------------------------------------------

	public Short getTYPE_ID();

	public void setTYPE_ID( Short typeId );

	// -----------------------------------------------------------------------------
	public Short getVIDEO_LENGTH_ID();

	public void setVIDEO_LENGTH_ID( Short VIDEO_LENGTH_ID );

	// -----------------------------------------------------------------------------
}
