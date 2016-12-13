package com.shsun.addata.entry;

import java.math.BigDecimal;

import com.shsun.addata.entry.common.ProvinceChannelAgentEntry;

/**
 * 
 * @author shsun
 * 
 */
public class DW_ADS_ADI_P_CHANNEL_DAYEntry extends ProvinceChannelAgentEntry {

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

}
