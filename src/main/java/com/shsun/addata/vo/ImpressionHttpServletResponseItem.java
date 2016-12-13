package com.shsun.addata.vo;

import com.shsun.addata.vo.base.IHttpServletResponseItem;

public class ImpressionHttpServletResponseItem extends ImpressionRowItem implements IHttpServletResponseItem {

	private String videoLengthTypeLabel;
	private String clickRate;
	private String percentComplete;

	/**
	 * 主量 / 补量
	 */
	private String contractTypeLabel;

	public String getClickRate() {
		return clickRate;
	}

	public void setClickRate( String clickRate ) {
		this.clickRate = clickRate;
	}

	public String getPercentComplete() {
		return percentComplete;
	}

	public void setPercentComplete( String percentComplete ) {
		this.percentComplete = percentComplete;
	}

	public String getContractTypeLabel() {
		return contractTypeLabel;
	}

	public void setContractTypeLabel( String contractTypeLabel ) {
		this.contractTypeLabel = contractTypeLabel;
	}

	public String getVideoLengthTypeLabel() {
		return videoLengthTypeLabel;
	}

	public void setVideoLengthTypeLabel( String videoLengthTypeLabel ) {
		this.videoLengthTypeLabel = videoLengthTypeLabel;
	}

}
