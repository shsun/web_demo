package com.shsun.addata.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shsun.addata.support.PropertyWrapper;
import com.youdo.m.BaseKVObject;
import com.youdo.util.lang.StringUtils;
import com.youdo.util.lang.YouDoNumberFormatUtil;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.ApplicationSharedObject;

/**
 * 
 * @author shsun
 * 
 */
public class ImpressionHttpServletRequestParameter extends AbstractHttpServletRequestParameter {
	//
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ImpressionHttpServletRequestParameter.class);
	//
	public String orderId = "";
	public String orderName = "";
	/**
	 * 2 indicate the 1st ad of certain slot, 
	 * 3 indicate the 2nd ad of certain slot, 
	 * 9 indicate the 3rd ad of certain slot,
	 */
	public String typeId;
	
	/**
	 * true indicate inclue supplement, otherwise not.
	 */
	public boolean includeSupplement = false;

	/**
	 * 
	 * @param request
	 */
	public ImpressionHttpServletRequestParameter(HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		//
		this.orderId = StringUtils.isValidValue(request.getParameter("orderId")) ? request.getParameter("orderId").trim() : null;
		this.orderName = StringUtils.isValidValue(request.getParameter("orderName")) ? request.getParameter("orderName").trim() : null;
		// 
		this.typeId = request.getParameter("typeId");
		//
		this.includeSupplement = "1".equals(request.getParameter("includeSupplement"));
	}
	
	@Override
	public void buildDisplayPriority( ) {
		String[] englishPriorityArray = null;
		if(super.isMobile()) {
			englishPriorityArray = new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "contractTypeLabel", "CONTRACT_NAME", "CAST_NAME", "CREATIVE_NAME", "PLATFORM_TYPE","CLIENT_TYPE", "TYPE_NAME", "PROVINCE_NAME", "CITY_NAME",
					"CHANNEL_NAME", /*"SUB_CHANNEL_NAME",*/ "IMP", "CLICK", "clickRate", "IMPOVER", "percentComplete"/*, "SLOT_NAME"*/ };
		}else{
			if (!this.timeSLP.has1stLevelParameter()) {
				if (!this.isOnlyCity() && !this.isOnlySubChannel()) {
					englishPriorityArray = new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "contractTypeLabel", "CONTRACT_NAME", "CAST_NAME", "CREATIVE_NAME", "PROVINCE_NAME", /*"CITY_NAME",*/
						"CHANNEL_NAME", /*"SUB_CHANNEL_NAME",*/ "IMP", "CLICK", "clickRate", "IMPOVER", "percentComplete", "SLOT_NAME" };	
				} else if (this.isOnlyCity() && !this.isOnlySubChannel()) {
					englishPriorityArray = new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "contractTypeLabel", "CONTRACT_NAME", "CAST_NAME", "CREATIVE_NAME", "PROVINCE_NAME", "CITY_NAME",
						"CHANNEL_NAME", /*"SUB_CHANNEL_NAME",*/ "IMP", "CLICK", "clickRate", "IMPOVER", "percentComplete", "SLOT_NAME" };	
				} else {
					englishPriorityArray = new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "contractTypeLabel", "CONTRACT_NAME", "CAST_NAME", "CREATIVE_NAME", "PROVINCE_NAME", "CITY_NAME",
						"CHANNEL_NAME", "SUB_CHANNEL_NAME", "IMP", "CLICK", "clickRate", "IMPOVER", "percentComplete", "SLOT_NAME" };	
				}
			} else {
				englishPriorityArray = new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "contractTypeLabel", "CONTRACT_NAME", "CAST_NAME", "CREATIVE_NAME", "PROVINCE_NAME", "CITY_NAME",
						"CHANNEL_NAME", "SUB_CHANNEL_NAME", "IMP", "CLICK", "clickRate", "IMPOVER", "percentComplete", "SLOT_NAME" };
			}
		}
		this.setEnglishPriorityArray(englishPriorityArray);
		
		this.titles = new PropertyWrapper[] {ApplicationSharedObject.getInstance().DATE,
				ApplicationSharedObject.getInstance().HOUR,
				ApplicationSharedObject.getInstance().SITE,
				ApplicationSharedObject.getInstance().contractTypeLabel,
				ApplicationSharedObject.getInstance().CONTRACT,
				ApplicationSharedObject.getInstance().CAST,
				ApplicationSharedObject.getInstance().CREATIVE,
				ApplicationSharedObject.getInstance().PROVINCE,
				ApplicationSharedObject.getInstance().CITY,
				ApplicationSharedObject.getInstance().CHANNEL,
				ApplicationSharedObject.getInstance().SUB_CHANNEL,
				ApplicationSharedObject.getInstance().IMP,
				ApplicationSharedObject.getInstance().CLICK,
				ApplicationSharedObject.getInstance().clickRate,
				ApplicationSharedObject.getInstance().IMPOVER,
				ApplicationSharedObject.getInstance().percentComplete,
				ApplicationSharedObject.getInstance().SLOT};
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
		if (this.includeSupplement) {
			list.add("contractTypeLabel");
		}
		list.add("CONTRACT_NAME");
		list.add("CAST_NAME");
		list.add("CREATIVE_NAME");
		list.add("PROVINCE_NAME");
		list.add("CITY_NAME");
		list.add("CHANNEL_NAME");
		list.add("SUB_CHANNEL_NAME");
		//if (super.adType == YouDoConstants.AdType.AD_TYPE_LONG_PREROLL) {
			list.add("SLOT_NAME");
		//}
		list.add("TYPE_NAME");	
	}
	@Override
	protected void updateDisplayedListWithRequiredProperties(List<String> list) {
		list.add("IMP");
		list.add("CLICK");
		list.add("clickRate");
		list.add("IMPOVER");
		list.add("percentComplete");
	}
	@Override
	protected void updateTitleListWithOptionalProperties(List<PropertyWrapper> list) {
		list.add(ApplicationSharedObject.getInstance().DATE);
		if (this.timeSLP.size() > 0) {
			list.add(ApplicationSharedObject.getInstance().HOUR);
		}
		list.add(ApplicationSharedObject.getInstance().SITE);
		if (this.includeSupplement) {
			list.add(ApplicationSharedObject.getInstance().contractTypeLabel);
		}
		list.add(ApplicationSharedObject.getInstance().CONTRACT);
		list.add(ApplicationSharedObject.getInstance().CAST);
		list.add(ApplicationSharedObject.getInstance().CREATIVE);
		list.add(ApplicationSharedObject.getInstance().PROVINCE);
		list.add(ApplicationSharedObject.getInstance().CITY);
		list.add(ApplicationSharedObject.getInstance().CHANNEL);
		list.add(ApplicationSharedObject.getInstance().SUB_CHANNEL);
		//if (super.adType == YouDoConstants.AdType.AD_TYPE_LONG_PREROLL) {
			list.add(ApplicationSharedObject.getInstance().SLOT);
		//}
	}
	@Override
	protected void updateTitleListWithRequiredProperties(List<PropertyWrapper> list) {
		list.add(ApplicationSharedObject.getInstance().IMP);
		list.add(ApplicationSharedObject.getInstance().CLICK);
		list.add(ApplicationSharedObject.getInstance().clickRate);
		list.add(ApplicationSharedObject.getInstance().IMPOVER);
		list.add(ApplicationSharedObject.getInstance().percentComplete);
	}

	@Override
	protected BaseKVObject doItemProcess(String name, String value) {
		if (name != null && (name.equals("IMP") || name.equals("IMPOVER") || name.equals("CLICK"))) {
			try {
				value = YouDoNumberFormatUtil.divideWithSimpleThousandsSeparator(Double.parseDouble(value.toString()));
			} catch (Exception e) {
				value = "0";
			}
		}
		return new BaseKVObject(name, value);
	}
}