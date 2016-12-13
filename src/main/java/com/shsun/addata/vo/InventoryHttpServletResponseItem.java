package com.shsun.addata.vo;

import com.shsun.addata.vo.base.IHttpServletResponseItem;

/**
 * 
 * @author shsun
 * 
 */
public class InventoryHttpServletResponseItem extends InventoryRowItem implements IHttpServletResponseItem {

	//
	private String videoLengthTypeLabel;
	private String regionName;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName( String regionName ) {
		this.regionName = regionName;
	}

	public String getVideoLengthTypeLabel() {
		return videoLengthTypeLabel;
	}

	public void setVideoLengthTypeLabel( String videoLengthTypeLabel ) {
		this.videoLengthTypeLabel = videoLengthTypeLabel;
	}
}
