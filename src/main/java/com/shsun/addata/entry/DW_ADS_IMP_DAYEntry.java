package com.shsun.addata.entry;

import java.math.BigDecimal;

import com.shsun.addata.entry.common.ProvinceChannelAgentEntry;

/**
 * 
 * @author shsun
 * 
 */
public class DW_ADS_IMP_DAYEntry extends ProvinceChannelAgentEntry implements IPCFactDayRowEntry {

	private Short TYPE_ID;

	private BigDecimal CREATIVE_ID;

	private BigDecimal IMP;

	private BigDecimal CLICK;

	private BigDecimal IMPOVER;

	private Short VIDEO_LENGTH_ID;

	public Short getVIDEO_LENGTH_ID() {
		return VIDEO_LENGTH_ID;
	}

	public void setVIDEO_LENGTH_ID( Short vIDEO_LENGTH_ID ) {
		VIDEO_LENGTH_ID = vIDEO_LENGTH_ID;
	}

	public Short getTYPE_ID() {
		return TYPE_ID;
	}

	public void setTYPE_ID( Short tYPE_ID ) {
		TYPE_ID = tYPE_ID;
	}

	public BigDecimal getCREATIVE_ID() {
		return CREATIVE_ID;
	}

	public void setCREATIVE_ID( BigDecimal cREATIVE_ID ) {
		CREATIVE_ID = cREATIVE_ID;
	}

	public BigDecimal getIMP() {
		return IMP;
	}

	public void setIMP( BigDecimal iMP ) {
		IMP = iMP;
	}

	public BigDecimal getCLICK() {
		return CLICK;
	}

	public void setCLICK( BigDecimal cLICK ) {
		CLICK = cLICK;
	}

	public BigDecimal getIMPOVER() {
		return IMPOVER;
	}

	public void setIMPOVER( BigDecimal iMPOVER ) {
		IMPOVER = iMPOVER;
	}
}
