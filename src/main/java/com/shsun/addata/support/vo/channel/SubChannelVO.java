package com.shsun.addata.support.vo.channel;

import net.sf.json.JSONObject;

import com.shsun.addata.vo.DIM_ADS_CHANNEL_SUB;
import com.youdo.m.IJSONObjectParsable;

/**
 * 
 * @author shsun
 * 
 */
public class SubChannelVO implements IJSONObjectParsable {

	private DIM_ADS_CHANNEL_SUB wrappedObj;

	public SubChannelVO(DIM_ADS_CHANNEL_SUB wrappedObj) {
		this.setDim_ADS_CHANNEL_SUB(wrappedObj);
	}

	public DIM_ADS_CHANNEL_SUB getWrappedObj() {
		return wrappedObj;
	}

	public void setDim_ADS_CHANNEL_SUB(DIM_ADS_CHANNEL_SUB wrappedObj) {
		this.wrappedObj = wrappedObj;
	}

	public JSONObject toJSONObject() {
		return JSONObject.fromObject(this.getWrappedObj());
	}
}
