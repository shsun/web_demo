package com.shsun.addata.entry;

/**
 * 
 * @author shsun
 * 
 */
public class DW_ADS_ADI_HOUREntry extends DW_ADS_ADI_DAYEntry implements IPCFactHourRowEntry {

	private Short HOUR_ID;

	public Short getHOUR_ID() {
		return HOUR_ID;
	}

	public void setHOUR_ID( Short hOUR_ID ) {
		HOUR_ID = hOUR_ID;
	}

}
