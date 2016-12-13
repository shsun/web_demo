package com.shsun.addata.entry.city;

import com.shsun.addata.entry.common.AbstractAdDataEntry;

/**
 * 
 * @author shsun
 * 
 */
public class ProvinceEntry extends AbstractAdDataEntry implements IProvinceEntry {

	private Integer PROVINCE_ID;

	public Integer getPROVINCE_ID() {
		return PROVINCE_ID;
	}

	public void setPROVINCE_ID( Integer PROVINCE_ID ) {
		this.PROVINCE_ID = PROVINCE_ID;
	}
}
