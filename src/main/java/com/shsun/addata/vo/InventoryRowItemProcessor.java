package com.shsun.addata.vo;

import com.shsun.addata.vo.base.AbstractRowItemProcessor;
import com.shsun.addata.vo.base.IHttpServletResponseItem;
import com.shsun.addata.vo.base.IRowItemProcessor;
import com.shsun.addata.vo.base.IRowItemWrapper;

/**
 * 
 * @author shsun
 * 
 */
public class InventoryRowItemProcessor extends AbstractRowItemProcessor implements IRowItemProcessor {

	/**
	 * 
	 */
	public IHttpServletResponseItem process( IRowItemWrapper wrapper ) {
		IHttpServletResponseItem responseItem = new InventoryHttpServletResponseItem();
		super.doProcess(wrapper, wrapper.getRowItem(), responseItem);
		return responseItem;
	}

	@Override
	protected void afterRowItemMerging( IRowItemWrapper wrapper, IHttpServletResponseItem responseItem ) {
		this.updateDisplayedContent((InventoryRowItem) wrapper.getRowItem(), (InventoryHttpServletResponseItem) responseItem);
		this.formatDisplayedContent((InventoryRowItem) wrapper.getRowItem(), (InventoryHttpServletResponseItem) responseItem);
	}

	private void updateDisplayedContent( InventoryRowItem rowItem, InventoryHttpServletResponseItem responseItem ) {
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
		}

	}

	private void formatDisplayedContent( InventoryRowItem rowItem, InventoryHttpServletResponseItem responseItem ) {
	}
}
