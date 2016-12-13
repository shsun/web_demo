package com.shsun.addata.entry.city;


/**
 * 
 * @author shsun
 * 
 */
public class CityEntry extends ProvinceEntry implements ICityEntry {

	private Integer CITY_ID;

	public Integer getCITY_ID() {
		return CITY_ID;
	}

	public void setCITY_ID( Integer CITY_ID ) {
		this.CITY_ID = CITY_ID;
	}

}
