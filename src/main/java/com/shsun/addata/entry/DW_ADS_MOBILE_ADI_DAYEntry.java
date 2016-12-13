package com.shsun.addata.entry;

/**
 * 
 * @author shsun
 * 
 */
public class DW_ADS_MOBILE_ADI_DAYEntry extends DW_ADS_ADI_DAYEntry implements IMobileFactDayRowEntry {

	private Short MOBILE_SEGMENT_ID;

	private Short PREDEFINED1;

	private Short PREDEFINED2;

	private Short VIDEO_LENGTH_ID;

	public Short getMOBILE_SEGMENT_ID() {
		return MOBILE_SEGMENT_ID;
	}

	public void setMOBILE_SEGMENT_ID( Short mOBILE_SEGMENT_ID ) {
		MOBILE_SEGMENT_ID = mOBILE_SEGMENT_ID;
	}

	public Short getPREDEFINED1() {
		return PREDEFINED1;
	}

	public void setPREDEFINED1( Short pREDEFINED1 ) {
		PREDEFINED1 = pREDEFINED1;
	}

	public Short getPREDEFINED2() {
		return PREDEFINED2;
	}

	public void setPREDEFINED2( Short pREDEFINED2 ) {
		PREDEFINED2 = pREDEFINED2;
	}

	public Short getVIDEO_LENGTH_ID() {
		return VIDEO_LENGTH_ID;
	}

	public void setVIDEO_LENGTH_ID( Short VIDEO_LENGTH_ID ) {
		this.VIDEO_LENGTH_ID = VIDEO_LENGTH_ID;
	}

}
