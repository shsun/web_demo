package com.shsun.addata.support.vo.segment;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.vo.DIM_ADS_MOBILE_SEG;

/**
 * 
 * @author shsun
 * 
 */
public class SegmentCollector {

	private Map<Short, DIM_ADS_MOBILE_SEG> collection = new HashMap<Short, DIM_ADS_MOBILE_SEG>();

	/**
	 * 
	 * @param list
	 */
	public SegmentCollector(List<DIM_ADS_MOBILE_SEG> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				collection.put(list.get(i).getMOBILE_SEGMENT_ID(), list.get(i));
			}
		}
	}

	/**
	 * 
	 * @param MOBILE_SEGMENT_ID
	 * @return
	 */
	public DIM_ADS_MOBILE_SEG getDIM_ADS_MOBILE_SEG(Short MOBILE_SEGMENT_ID) {
		return this.collection.get(MOBILE_SEGMENT_ID);
	}

	/**
	 * 
	 * @param os
	 * @return
	 */
	public Map<Short, DIM_ADS_MOBILE_SEG> getDIM_ADS_MOBILE_SEGByOS(ApplicationConstants.OS os) {
		Map<Short, DIM_ADS_MOBILE_SEG> subCollection = new HashMap<Short, DIM_ADS_MOBILE_SEG>();
		for (Short o : this.collection.keySet()) {
			if (this.collection.get(o).getOS_TYPE().equals(os.getCode())) {
				subCollection.put(o, this.collection.get(o));
			}
		}
		return subCollection;
	}

	/**
	 * 
	 * @param device
	 * @return
	 */
	public Map<Short, DIM_ADS_MOBILE_SEG> getDIM_ADS_MOBILE_SEGByDevice(ApplicationConstants.Device device) {
		Map<Short, DIM_ADS_MOBILE_SEG> subCollection = new HashMap<Short, DIM_ADS_MOBILE_SEG>();
		for (Short o : this.collection.keySet()) {
			if (this.collection.get(o).getDEVICE_TYPE().equals(device.getCode())) {
				subCollection.put(o, this.collection.get(o));
			}
		}
		return subCollection;
	}

	/**
	 * 
	 * @param client
	 * @return
	 */
	public Map<Short, DIM_ADS_MOBILE_SEG> getDIM_ADS_MOBILE_SEGByIntent(ApplicationConstants.Client client) {
		Map<Short, DIM_ADS_MOBILE_SEG> subCollection = new HashMap<Short, DIM_ADS_MOBILE_SEG>();
		for (Short o : this.collection.keySet()) {
			if (this.collection.get(o).getCLIENT_TYPE().equals(client.getCode())) {
				subCollection.put(o, this.collection.get(o));
			}
		}
		return subCollection;
	}
}
