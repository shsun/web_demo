package com.shsun.addata.support.vo.city;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.shsun.addata.vo.DIM_COM_CITY;
import com.shsun.addata.vo.DIM_COM_PROVINCE;
import com.youdo.m.IJSONObjectParsable;

;
/**
 * 
 * @author shsun
 * 
 */
public class ProvinceVO implements IJSONObjectParsable {

	private DIM_COM_PROVINCE wrappedObj;

	private Map< Integer, CityVO > children = new HashMap< Integer, CityVO >();

	public ProvinceVO(DIM_COM_PROVINCE wrappedObj, List< DIM_COM_CITY > list) {
		this.setWrappedObj(wrappedObj);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				this.children.put(list.get(i).getCITY_ID(), new CityVO(list.get(i), this));
			}
		}
	}

	public boolean containsSubVO( Integer subVOlId ) {
		return this.children.containsKey(subVOlId);
	}

	public Map< Integer, CityVO > getChildren() {
		return children;
	}

	public void setChildren( Map< Integer, CityVO > children ) {
		this.children = children;
	}

	public DIM_COM_PROVINCE getWrappedObj() {
		return wrappedObj;
	}

	public void setWrappedObj( DIM_COM_PROVINCE wrappedObj ) {
		this.wrappedObj = wrappedObj;
	}

	public JSONObject toJSONObject() {
		JSONObject object = JSONObject.fromObject(this.getWrappedObj());
		object.put("children", this.children2JSONArray());
		return object;
	}

	private JSONArray children2JSONArray() {
		JSONArray array = new JSONArray();
		Set< Integer > set = this.children.keySet();
		for (Integer key : set) {
			array.add(JSONObject.fromObject(this.children.get(key).getWrappedObj()));
		}
		return array;
	}
}
