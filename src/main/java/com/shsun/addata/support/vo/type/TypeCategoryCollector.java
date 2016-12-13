package com.shsun.addata.support.vo.type;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shsun.addata.vo.DIM_ADS_TYPE;

/**
 * 
 * @author shsun
 * 
 */
public class TypeCategoryCollector {

	private Map<Short, DIM_ADS_TYPE> collection = new HashMap<Short, DIM_ADS_TYPE>();

	/**
	 * 
	 * @param list
	 */
	public TypeCategoryCollector(List<DIM_ADS_TYPE> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				collection.put(list.get(i).getTYPE_ID(), list.get(i));
			}
		}
	}

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	public DIM_ADS_TYPE getByTypeId(Short typeId) {
		return this.collection.get(typeId);
	}
}
