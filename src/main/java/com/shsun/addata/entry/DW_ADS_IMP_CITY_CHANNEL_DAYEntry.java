package com.shsun.addata.entry;

import com.shsun.addata.entry.city.ICityEntry;

/**
 * 
 * @author shsun
 * 
 */
public class DW_ADS_IMP_CITY_CHANNEL_DAYEntry extends DW_ADS_IMP_P_CHANNEL_DAYEntry implements ICityEntry {

	private Integer CITY_ID;

	public Integer getCITY_ID() {
		return CITY_ID;
	}

	public void setCITY_ID( Integer CITY_ID ) {
		this.CITY_ID = CITY_ID;
	}

}
