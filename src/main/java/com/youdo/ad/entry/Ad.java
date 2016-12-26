package com.youdo.ad.entry;

/**
 * 
 * @author shsun
 * 
 */
public class Ad extends IdNameObject {

	private AdCreative adCreative;

	public Ad(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}

	public AdCreative getAdCreative() {
		return adCreative;
	}

	public void setAdCreative( AdCreative adCreative ) {
		this.adCreative = adCreative;
	}
}
