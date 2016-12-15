package com.shsun.addata.vo.base;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.vo.InventoryHttpServletResponseItem;
import com.shsun.addata.vo.InventoryRowItem;
import com.youdo.util.lang.reflect.YouDoReflectorUtil;
import com.youdo.util.text.DateFormatUtils;

/**
 * 
 * @author shsun
 * 
 * @param <W>
 * @param <T>
 */
public abstract class AbstractRowItemProcessor implements IRowItemProcessor {
	
	public static final String YES = "长视频";
	public static final String NO = "短视频";
	public static final String OTHERS = "其他";
	
	public static final String SLOT_NAME_PREFIX = "移动";
	
	/**
	 * TODO
	 */
	@SuppressWarnings("rawtypes")
	protected void doProcess(IRowItemWrapper wrapper, IRowResultSetItem rowItem, IHttpServletResponseItem responseItem) {
		try {
			String name = null;
			try {
				DIM_ADS_SLOT slot = ApplicationSharedObject.getInstance().getSlotCategoryCollector().getBySlotId(rowItem.getSLOT_ID());
				if (((IHttpServletRequestParameter) wrapper.getHttpServletRequestParameter()).isMobile()) {
					name = SLOT_NAME_PREFIX + slot.getSLOT_NAME();
				} else {
					name = slot.getSLOT_NAME();
				}
				rowItem.setSLOT_NAME(name);
			} catch (Exception e) {
				//
			}
			try {
				DIM_ADS_TYPE type = ApplicationSharedObject.getInstance().getTypeCategoryCollector().getByTypeId(rowItem.getTYPE_ID());
				name = type.getTYPE_NAME();// + "-" + rowItem.getSLOT_NAME();
				//name = rowItem.getSLOT_NAME();
				rowItem.setTYPE_NAME(name);
			} catch (Exception e) {
				//
			}
			//
			try {
				YouDoReflectorUtil.merge(rowItem, responseItem);
				this.afterRowItemMerging(wrapper, responseItem);
			} catch (Exception e) {
				// TODO: handle exception
			}
			//
			try {
				String code = "" + responseItem.getSITE_ID().intValue();
				responseItem.setSITE_NAME(ApplicationConstants.Site.getHolder().get(code).getLabel());
			} catch (Exception e) {
				// TODO: handle exception
			}
			//
			try {
				responseItem.setDATE_NAME(DateFormatUtils.format(responseItem.getDATE_TIME(), DateFormatUtils.DATE_FORMAT));
			} catch (Exception e) {
				// TODO: handle exception
			}
			// mobile
			try {
				DIM_ADS_MOBILE_SEG segment = ApplicationSharedObject.getInstance().getSegmentCollector().getDIM_ADS_MOBILE_SEG(rowItem.getMOBILE_SEGMENT_ID());
				responseItem.setDEVICE_TYPE(segment.getDEVICE_TYPE());
				responseItem.setOS_TYPE(segment.getOS_TYPE());
				responseItem.setCLIENT_TYPE(segment.getCLIENT_TYPE());
				responseItem.setPLATFORM_TYPE(segment.getPLATFORM_TYPE());
			} catch (Exception e) {
				// TODO: handle exception
			}
			//
			this.mergePublicData(wrapper, rowItem, responseItem);
		} catch (Exception e) {
			//
		} finally {
			//
		}
	}

	@SuppressWarnings("rawtypes")
	protected abstract void afterRowItemMerging(IRowItemWrapper wrapper, IHttpServletResponseItem responseItem);
	
	@SuppressWarnings("rawtypes")
	private void mergePublicData(IRowItemWrapper wrapper, IRowResultSetItem rowItem, IHttpServletResponseItem responseItem) {
		try {
			responseItem.setPROVINCE_ID(wrapper.getProvinceVO().getPROVINCE_ID());
			responseItem.setPROVINCE_NAME(wrapper.getProvinceVO().getPROVINCE_NAME());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			responseItem.setCITY_ID(wrapper.getCityVO().getCITY_ID());
			responseItem.setCITY_NAME(wrapper.getCityVO().getCITY_NAME());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			YouDoReflectorUtil.merge(wrapper.getChannelVO().getWrappedObj(), responseItem);
			YouDoReflectorUtil.merge(wrapper.getSubChannelVO().getWrappedObj(), responseItem);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
