package com.shsun.addata.support.vo.channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.shsun.addata.ApplicationConstants.Site;
import com.youdo.m.IBaseKVObjectContainer;
import com.youdo.m.IJSONObjectParsable;

/**
 * 
 * @author shsun
 * 
 */
public class ChannelVOCollector implements IBaseKVObjectContainer<ChannelVO>, IJSONObjectParsable {

	private Map<Integer, ChannelVO> collection = new HashMap<Integer, ChannelVO>();

	public ChannelVOCollector() {
		this.empty();
	}

	public void add(ChannelVO value) {
		this.collection.put(value.getWrappedObj().getCHANNEL_AGENT_ID(), value);
	}

	public void remove(ChannelVO vo) {
		this.collection.remove(vo);
	}

	public boolean has(ChannelVO value) {
		return this.collection.containsValue(value);
	}

	public int size() {
		return this.collection.size();
	}

	public void empty() {
		this.collection = new HashMap<Integer, ChannelVO>();
	}
	
	/**
	 * 
	 * @param channelAgentId
	 * @param subChannelAgentId
	 * @return
	 */
	public ChannelSubChannelPair getChannelSubChannelPair(Integer channelAgentId, Long subChannelAgentId) {
		ChannelVO channelVO = null;
		SubChannelVO subChannelVO = null;
		//
		channelVO = this.collection.get(channelAgentId);
		if (channelVO != null) {
			subChannelVO = new SubChannelVO(channelVO.getChildren().get(subChannelAgentId));
		} else {
			channelVO = this.getChannelVOBySubChannelAgentId(subChannelAgentId);
			if (channelVO != null) {
				subChannelVO = new SubChannelVO(channelVO.getChildren().get(subChannelAgentId));
			}
		}
		return new ChannelSubChannelPair(channelVO, subChannelVO);
	}	
	
	public ChannelVO getChannelVOBySubChannelAgentId(Long subChannelAgentId) {
		ChannelVO channelVO = null;
		Set<Integer> set = this.collection.keySet();
		for (Integer key : set) {
			if (this.collection.get(key).containsSubChannel(subChannelAgentId)) {
				channelVO = this.collection.get(key);
			}
		}
		return channelVO;
	}
	
	public ChannelVO getChannelVOByChannelAgentId( Integer channelAgentId ) {
		return this.collection.get(channelAgentId);
	}
	
	// TMP
	public JSONObject toMobileJSONObject() {
		JSONObject object = new JSONObject();
		object.put("success", 0);
		JSONArray ykArray = new JSONArray();
		JSONArray tdArray = new JSONArray();
		Set<Integer> set = this.collection.keySet();
		for (Integer key : set) {
			ChannelVO v = this.collection.get(key);
			if (v.getWrappedObj().getSITE_ID().intValue() == Integer.parseInt(Site.SiteA.getCode())) {
				ykArray.add(v.toJSONObject());
			} else {
				tdArray.add(v.toMobileJSONObject());
			}
		}
		object.put("a", ykArray);
		object.put("b", tdArray);
		//
		object.put("success", (ykArray.size() + tdArray.size()) > 0);
		return object;
	}
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("success", 0);
		JSONArray ykArray = new JSONArray();
		JSONArray tdArray = new JSONArray();
		Set<Integer> set = this.collection.keySet();
		for (Integer key : set) {
			ChannelVO v = this.collection.get(key);
			if (v.getWrappedObj().getSITE_ID().intValue() == Integer.parseInt(Site.SiteA.getCode())) {
				ykArray.add(v.toJSONObject());
			} else {
				tdArray.add(v.toJSONObject());
			}			
		}
		object.put("a", ykArray);
		object.put("b", tdArray);
		//
		object.put("success", (ykArray.size() + tdArray.size()) > 0);
		return object;
	}
	
	public JSONArray toJSONArray() {
		return new JSONArray();
	}
}