package com.shsun.addata.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.p;

import com.shsun.addata.support.PropertyWrapper;
import com.youdo.m.BaseKVObject;
import com.youdo.util.lang.YouDoNumberFormatUtil;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.ApplicationSharedObject;
import com.shsun.addata.vo.base.ITableSelectionStrategy;

/**
 * 
 * @author shsun
 * 
 */
public class InventoryHttpServletRequestParameter extends AbstractHttpServletRequestParameter {
	/**
	 * 
	 * @param request
	 * @param response
	 */
	public InventoryHttpServletRequestParameter(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
	}

	@Override
	public void buildDisplayPriority() {
		String[] englishPriorityArray = null;
		if(super.isMobile()) {
			englishPriorityArray 
				= new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "PLATFORM_TYPE","CLIENT_TYPE","TYPE_NAME", "PROVINCE_NAME", "CITY_NAME", "CHANNEL_NAME",
					/*"SUB_CHANNEL_NAME",*/ "RADI"/*, "SLOT_NAME"*/ };
		} else {
			if (!this.timeSLP.has1stLevelParameter()) {
				if (!this.isOnlyCity() && !this.isOnlySubChannel()) {
					englishPriorityArray 
						= new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "PROVINCE_NAME", /*"CITY_NAME",*/ "CHANNEL_NAME",
						/*"SUB_CHANNEL_NAME",*/ "RADI", "SLOT_NAME" };
				} else if (this.isOnlyCity() && !this.isOnlySubChannel()) {
					englishPriorityArray 
						= new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "PROVINCE_NAME", "CITY_NAME", "CHANNEL_NAME",
						/*"SUB_CHANNEL_NAME",*/ "RADI", "SLOT_NAME" };
				} else {
					englishPriorityArray
						= new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "PROVINCE_NAME", "CITY_NAME", "CHANNEL_NAME",
						"SUB_CHANNEL_NAME", "RADI", "SLOT_NAME" };
				}
			} else {
				englishPriorityArray 
					= new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "PROVINCE_NAME", "CITY_NAME", "CHANNEL_NAME",
						"SUB_CHANNEL_NAME", "RADI", "SLOT_NAME" };
			}
		}
		this.setEnglishPriorityArray(englishPriorityArray);
		
		this.titles = new PropertyWrapper[] { ApplicationSharedObject.getInstance().DATE, 
				ApplicationSharedObject.getInstance().HOUR, 
				ApplicationSharedObject.getInstance().SITE,
				ApplicationSharedObject.getInstance().PROVINCE, 
				ApplicationSharedObject.getInstance().CITY, 
				ApplicationSharedObject.getInstance().CHANNEL, 
				ApplicationSharedObject.getInstance().SUB_CHANNEL, 
				ApplicationSharedObject.getInstance().RADI,
				ApplicationSharedObject.getInstance().SLOT };
		//
		super.generateDisplayedList();
	}
	
	@Override
	protected void updateDisplayedListWithOptionalProperties(List<String> list) {
		list.add("DATE_NAME");
		if (this.timeSLP.size() > 0) {
			list.add("HOUR_ID");
		}
		
		list.add("videoLengthTypeLabel");
		list.add("PLATFORM_TYPE");
		list.add("CLIENT_TYPE");
		
		list.add("SITE_NAME");
		list.add("PROVINCE_NAME");
		list.add("CITY_NAME");
		list.add("CHANNEL_NAME");
		list.add("SUB_CHANNEL_NAME");
		list.add("SLOT_NAME");
		list.add("TYPE_NAME");
	}
	@Override
	protected void updateDisplayedListWithRequiredProperties(List<String> list) {
		list.add("RADI");
	}
	@Override
	protected void updateTitleListWithOptionalProperties(List<PropertyWrapper> list) {
		list.add(ApplicationSharedObject.getInstance().DATE);
		if (this.timeSLP.size() > 0) {
			list.add(ApplicationSharedObject.getInstance().HOUR);
		}
		list.add(ApplicationSharedObject.getInstance().SITE);
		list.add(ApplicationSharedObject.getInstance().PROVINCE);
		list.add(ApplicationSharedObject.getInstance().CITY);
		list.add(ApplicationSharedObject.getInstance().CHANNEL);
		list.add(ApplicationSharedObject.getInstance().SUB_CHANNEL);
		list.add(ApplicationSharedObject.getInstance().SLOT);
	}
	@Override
	protected void updateTitleListWithRequiredProperties(List<PropertyWrapper> list) {
		list.add(ApplicationSharedObject.getInstance().RADI);
	}
	
	@Override
	protected BaseKVObject doItemProcess(String name, String value) {
		if (name != null && name.equals("RADI")) {
			try {
				value = YouDoNumberFormatUtil.divideWithSimpleThousandsSeparator(Double.parseDouble(value.toString()));
			} catch (Exception e) {
				value = "0";
			}
		}
		return new BaseKVObject(name, value);
	}

}