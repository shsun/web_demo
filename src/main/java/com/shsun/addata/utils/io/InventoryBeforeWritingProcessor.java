package com.shsun.addata.utils.io;

import com.youdo.m.BaseKVObject;
import com.youdo.util.lang.YouDoNumberFormatUtil;

/**
 * 
 * @author shsun
 *
 */
public class InventoryBeforeWritingProcessor implements IBeforeWritingItemProcessor {

	public void process( BaseKVObject object ) {
		if (object.getKey() != null && object.getKey().equals("RADI")) {
			try {
				object.setValue(YouDoNumberFormatUtil.divideWithSimpleThousandsSeparator(Double.parseDouble(object.getValue().toString())));
			} catch (Exception e) {
				object.setValue("0");
			}
		}
	}

}
