package com.shsun.addata.entry;

import java.math.BigDecimal;

import com.shsun.addata.entry.common.CitySubChannelAgentEntry;

/**
 * 
 * @author shsun
 * 
 */
public class DW_ADS_ADI_DAYEntry extends CitySubChannelAgentEntry implements IPCFactDayRowEntry {

	private Short VIDEO_LENGTH_ID;

	private BigDecimal RADI;

	private BigDecimal FADI;

	public BigDecimal getRADI() {
		return RADI;
	}

	public void setRADI( BigDecimal rADI ) {
		RADI = rADI;
	}

	public BigDecimal getFADI() {
		return FADI;
	}

	public void setFADI( BigDecimal fADI ) {
		FADI = fADI;
	}

	public Short getVIDEO_LENGTH_ID() {
		return VIDEO_LENGTH_ID;
	}

	public void setVIDEO_LENGTH_ID( Short vIDEO_LENGTH_ID ) {
		VIDEO_LENGTH_ID = vIDEO_LENGTH_ID;
	}


}
