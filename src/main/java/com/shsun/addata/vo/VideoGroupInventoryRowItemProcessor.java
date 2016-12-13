package com.shsun.addata.vo;

import com.shsun.addata.vo.base.AbstractRowItemProcessor;
import com.shsun.addata.vo.base.ApplicationSharedObject;
import com.shsun.addata.vo.base.IHttpServletResponseItem;
import com.shsun.addata.vo.base.IRowItemWrapper;

/**
 * 
 * @author shsun
 * 
 */
public class VideoGroupInventoryRowItemProcessor extends AbstractRowItemProcessor {

	public IHttpServletResponseItem process(IRowItemWrapper wrapper) {
		IHttpServletResponseItem responseItem = new VideoGroupInventoryHttpServletResponseItem();
		super.doProcess(wrapper, wrapper.getRowItem(), responseItem);
		return responseItem;
	}

	@Override
	protected void afterRowItemMerging(IRowItemWrapper wrapper, IHttpServletResponseItem responseItem) {
		VideoGroupInventoryRowItem rowItem = (VideoGroupInventoryRowItem) wrapper.getRowItem();
		
		// video group name
		try {
			/*
			DIM_ADS_VIDEOGROUP v = ApplicationSharedObject.getInstance().getVideoGroupCollector().getByVGId(rowItem.getVIDEO_GROUP_ID());
			((VideoGroupInventoryHttpServletResponseItem) responseItem).setVIDEO_GROUP_NAME(v == null ? "VGNAME_"
					+ rowItem.getVIDEO_GROUP_ID().intValue() : v.getVIDEO_GROUP_NAME());*/
			((VideoGroupInventoryHttpServletResponseItem) responseItem).setVIDEO_GROUP_NAME(rowItem.getVIDEO_GROUP_NAME());
		} catch (Exception e) {
			// TODO: handle exception
		}

		// video length type label
		try {
			// TODO, should remove the hard code.
			String label = OTHERS;
			if (rowItem.getVIDEO_LENGTH_ID().intValue() == 0) {
				label = NO;
			} else if (rowItem.getVIDEO_LENGTH_ID().intValue() == 1) {
				label = YES;
			} else {
				label = OTHERS;
			}
			responseItem.setVideoLengthTypeLabel(label);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			// Overwrite slot_name with slot_group1_name
			DIM_ADS_SLOT slot = ApplicationSharedObject.getInstance().getSlotCategoryCollector().getBySlotId(rowItem.getSLOT_ID());
			responseItem.setSLOT_NAME(slot.getTYPE_NAME());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
