package com.shsun.addata.support.vo.channel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.vo.DIM_ADS_CHANNEL;
import com.shsun.addata.vo.DIM_ADS_CHANNEL_SUB;
import com.youdo.m.IJSONObjectParsable;

/**
 * 
 * @author shsun
 * 
 */
public class ChannelVO implements IJSONObjectParsable {

	private DIM_ADS_CHANNEL wrappedObj;

	/**
	 * DIM_ADS_CHANNEL_SUB.SUB_CHANNEL_AGENT_ID <----> DIM_ADS_CHANNEL_SUB
	 */
	private Map< Long, DIM_ADS_CHANNEL_SUB > children = new HashMap< Long, DIM_ADS_CHANNEL_SUB >();

	public ChannelVO(DIM_ADS_CHANNEL wrappedObj, List< DIM_ADS_CHANNEL_SUB > list) {
		this.setWrappedObj(wrappedObj);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				this.children.put(list.get(i).getSUB_CHANNEL_AGENT_ID(), list.get(i));
			}
		}
	}

	public boolean containsSubChannel( Long subChannelAgentId ) {
		return this.children.containsKey(subChannelAgentId);
	}

	public Map< Long, DIM_ADS_CHANNEL_SUB > getChildren() {
		return this.children;
	}

	public void setChildren( Map< Long, DIM_ADS_CHANNEL_SUB > children ) {
		this.children = children;
	}

	public DIM_ADS_CHANNEL getWrappedObj() {
		return wrappedObj;
	}

	public void setWrappedObj( DIM_ADS_CHANNEL wrappedObj ) {
		this.wrappedObj = wrappedObj;
	}

	public JSONObject toJSONObject() {
		JSONObject object = JSONObject.fromObject(this.getWrappedObj());
		object.put("children", this.children2JSONArray());
		return object;
	}
	
	// TMP
	public JSONObject toMobileJSONObject() {
		JSONObject object = JSONObject.fromObject(this.getWrappedObj());
		JSONArray children = ApplicationConstants.Site.SiteB.equals(String.valueOf(this.getWrappedObj().getSITE_ID().intValue())) ? new JSONArray() : this.children2JSONArray();
		object.put("children", children);
		return object;
	}

	private JSONArray children2JSONArray() {
		JSONArray array = new JSONArray();
		Set< Long > set = this.children.keySet();
		for (Long key : set) {
			array.add(JSONObject.fromObject(this.children.get(key)));
		}
		return array;
	}
}
