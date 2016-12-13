package com.shsun.addata.support.vo.slot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shsun.addata.vo.DIM_ADS_SLOT;

/**
 * 
 * @author shsun
 * 
 */
public class SlotCategoryCollector {

	private Map<Short, DIM_ADS_SLOT> collection = new HashMap<Short, DIM_ADS_SLOT>();

	/**
	 * 
	 * @param list
	 */
	public SlotCategoryCollector(List<DIM_ADS_SLOT> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				collection.put(list.get(i).getSLOT_ID(), list.get(i));
			}
		}
	}

	/**
	 * 
	 * @param slotId
	 * @return
	 */
	public DIM_ADS_SLOT getBySlotId(Short slotId) {
		return this.collection.get(slotId);
	}

	/**
	 * 
	 * @param adTypeId
	 * @return
	 */	
	/*
	public Map<Short, DIM_ADS_SLOT> getByAdTypeId(Short adTypeId) {
		Map<Short, DIM_ADS_SLOT> c = new HashMap<Short, DIM_ADS_SLOT>();
		//
		for (Short key : this.collection.keySet()) {
			if (adTypeId.equals(this.collection.get(key).getTYPE_ID())) {
				c.put(key, this.collection.get(key));
			}
		}
		//
		return c;
	}
	*/
	
	/*
	public List<String> getSLOT_IDListByAdTypeId(String adTypeId) {
		List<String> slotIds = new ArrayList<String>();
		//
		Map<Short, DIM_ADS_SLOT> map = this.getByAdTypeId(Short.parseShort(adTypeId));
		for (Short key : map.keySet()) {
			slotIds.add(key.toString());
		}
		return slotIds;
	}
	*/
}
