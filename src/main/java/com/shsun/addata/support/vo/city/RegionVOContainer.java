package com.shsun.addata.support.vo.city;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.shsun.addata.vo.DIM_COM_CITY;
import com.youdo.m.IBaseKVObjectContainer;
import com.youdo.m.IJSONObjectParsable;

/**
 * 
 * @author shsun
 * 
 */
public class RegionVOContainer implements IBaseKVObjectContainer<DIM_COM_CITY>,IJSONObjectParsable {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RegionVOContainer.class);

	private Map<Integer, DIM_COM_CITY> collection;

	public RegionVOContainer(List<DIM_COM_CITY> list) {
		this.empty();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				this.add(list.get(i));
			}
		}
	}

	public void add(DIM_COM_CITY value) {
		this.collection.put(value.getCITY_ID(), value);
	}

	public void remove(DIM_COM_CITY value) {
		this.collection.remove(value.getCITY_ID());
	}

	public boolean has(DIM_COM_CITY value) {
		return this.collection.containsValue(value);
	}

	public int size() {
		return this.collection.size();
	}

	public void empty() {
		this.collection = new HashMap<Integer, DIM_COM_CITY>();
	}
	
	public int indexOf(DIM_COM_CITY value) {
		return 0;
	}

	public DIM_COM_CITY getVOByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public DIM_COM_CITY getFullCityVOByCityId(Integer cityId) {
		return this.collection.get(cityId);
	}
	
	/**
	 * get the 1st cityVO via provinceid
	 * 
	 * @param provinceId
	 * @return
	 */
	public DIM_COM_CITY getFullCityVOByProvinceId(Integer provinceId) {
		Map<Integer, DIM_COM_CITY> map = this.getAllCityVOByProvinceId(provinceId);
		DIM_COM_CITY p = null;
		for (Integer cityId : map.keySet()) {
			p = map.get(cityId);
			break;
		}
		return p;
	}
	
	/**
	 * 
	 * @param provinceId
	 * @return
	 */
	public Map<Integer, DIM_COM_CITY> getAllCityVOByProvinceId(Integer provinceId) {
		Map<Integer, DIM_COM_CITY> map = new HashMap<Integer, DIM_COM_CITY>();
		//
		DIM_COM_CITY p = null;
		for (Integer cityId : this.collection.keySet()) {
			p = this.collection.get(cityId);
			if (p.getPROVINCE_ID().intValue() == provinceId.intValue()) {
				map.put(cityId, p);
			}
		}
		//
		return map;
	}
	
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		JSONArray arr = new JSONArray();
		Set< Integer > set = this.collection.keySet();
		for (Integer key : set) {
			arr.add(JSONObject.fromObject(this.collection.get(key)));
		}
		object.put("data", arr);
		object.put("success", arr.size() > 0);
		return object;
	}

	public JSONArray toJSONArray() {
		return null;
	}
}
