package com.youdo.ad.entry;

/**
 * 
 * @author shsun
 *
 */
public class AdCreative extends IdNameObject {

	private AdCreativeRendition adCreativeRendition;

	public AdCreative(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	public AdCreativeRendition getAdCreativeRendition() {
		return adCreativeRendition;
	}

	
	public void setAdCreativeRendition( AdCreativeRendition adCreativeRendition ) {
		this.adCreativeRendition = adCreativeRendition;
	}


}
