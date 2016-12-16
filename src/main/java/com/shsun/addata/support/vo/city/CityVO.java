package com.shsun.addata.support.vo.city;

import net.sf.json.JSONObject;

import com.shsun.addata.vo.DIM_COM_CITY;
import com.youdo.interfaces.IJSONObjectParsable;

/**
 * 
 * @author shsun
 * 
 */
public class CityVO implements IJSONObjectParsable {

	private DIM_COM_CITY wrappedObj;

	private ProvinceVO parent;

	public CityVO(DIM_COM_CITY wrappedObj, ProvinceVO parent) {
		this.setWrappedObj(wrappedObj);
		this.setParent(parent);
	}

	public DIM_COM_CITY getWrappedObj() {
		return wrappedObj;
	}

	public void setWrappedObj( DIM_COM_CITY wrappedObj ) {
		this.wrappedObj = wrappedObj;
	}

	public ProvinceVO getParent() {
		return parent;
	}

	public void setParent( ProvinceVO parent ) {
		this.parent = parent;
	}

	public JSONObject toJSONObject() {
		return JSONObject.fromObject(this.getWrappedObj());
	}
}
