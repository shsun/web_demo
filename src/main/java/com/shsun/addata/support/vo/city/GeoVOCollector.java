package com.shsun.addata.support.vo.city;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.youdo.interfaces.IMutableContainer;
import com.youdo.interfaces.IJSONObjectParsable;

/**
 * 
 * @author shsun
 * 
 */
public class GeoVOCollector implements IMutableContainer< ProvinceVO >, IJSONObjectParsable {

	private Map< Integer, ProvinceVO > collection = new HashMap< Integer, ProvinceVO >();

	public GeoVOCollector() {
		this.empty();
	}

	public void add( ProvinceVO value ) {
		this.collection.put(value.getWrappedObj().getPROVINCE_ID(), value);
	}

	public void remove( ProvinceVO vo ) {
		this.collection.remove(vo);
	}

	public boolean has( ProvinceVO value ) {
		return this.collection.containsValue(value);
	}

	public int size() {
		return this.collection.size();
	}

	public void empty() {
		this.collection = new HashMap< Integer, ProvinceVO >();
	}

	public ProvinceVO getVOBySubVOId( Integer subVOId ) {
		ProvinceVO vo = null;
		Set< Integer > set = this.collection.keySet();
		for (Integer key : set) {
			if (this.collection.get(key).containsSubVO(subVOId)) {
				vo = this.collection.get(key);
			}
		}
		return vo;
	}

	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("success", 0);
		JSONArray arr = new JSONArray();
		Set< Integer > set = this.collection.keySet();
		for (Integer key : set) {
			ProvinceVO v = this.collection.get(key);
			arr.add(v.toJSONObject());
		}
		object.put("data", arr);
		//
		object.put("success", arr.size() > 0);
		return object;
	}

	public JSONArray toJSONArray() {
		return new JSONArray();
	}
}