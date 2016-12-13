package com.shsun.addata.vo;

import java.text.NumberFormat;

import com.shsun.addata.vo.base.AbstractRowItemProcessor;
import com.shsun.addata.vo.base.ApplicationSharedObject;
import com.shsun.addata.vo.base.IHttpServletResponseItem;
import com.shsun.addata.vo.base.IRowItemProcessor;
import com.shsun.addata.vo.base.IRowItemWrapper;
import com.shsun.addata.vo.base.IRowResultSetItem;

/**
 * 
 * @author shsun
 * 
 */
public class ImpressionRowItemProcessor extends AbstractRowItemProcessor implements IRowItemProcessor {

	public static final String MASTER = "主量";
	public static final String SLAVE = "补量";

	/**
	 * 
	 */
	public IHttpServletResponseItem process( IRowItemWrapper wrapper ) {
		IHttpServletResponseItem responseItem = new ImpressionHttpServletResponseItem();
		super.doProcess(wrapper, wrapper.getRowItem(), responseItem);
		return responseItem;
	}

	@Override
	protected void afterRowItemMerging( IRowItemWrapper wrapper, IHttpServletResponseItem responseItem ) {
		this.updateDisplayedContent((ImpressionRowItem) wrapper.getRowItem(), (ImpressionHttpServletResponseItem) responseItem);
		this.formatDisplayedContent((ImpressionRowItem) wrapper.getRowItem(), (ImpressionHttpServletResponseItem) responseItem);
	}

	private void updateDisplayedContent( ImpressionRowItem rowItem, ImpressionHttpServletResponseItem responseItem ) {
		String UNDER_LINE = "__";
		try {
			responseItem.setCREATIVE_NAME(rowItem.getCREATIVE_ID().intValue() + UNDER_LINE + responseItem.getCREATIVE_NAME());
		} catch (Exception e) {
		}
		try {
			responseItem.setCAST_NAME(rowItem.getCAST_ID().intValue() + UNDER_LINE + responseItem.getCAST_NAME());
		} catch (Exception e) {
		}
		try {
			responseItem.setCONTRACT_NAME(rowItem.getCONTRACT_ID().intValue() + UNDER_LINE + responseItem.getCONTRACT_NAME());
		} catch (Exception e) {
		}
		//
		try {
			String label = rowItem.getIS_AMOUNT().intValue() == 0 ? MASTER : SLAVE;
			responseItem.setContractTypeLabel(label);
		} catch (Exception e) {
		}

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
		//
		
	}

	private void formatDisplayedContent( ImpressionRowItem rowItem, ImpressionHttpServletResponseItem responseItem ) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMaximumFractionDigits(2);
		//
		double result;
		//
		result = (rowItem.getCLICK().doubleValue() / rowItem.getIMP().doubleValue()) * 100;
		responseItem.setClickRate(formatter.format(result) + " %");
		//
		result = (rowItem.getIMPOVER().doubleValue() / rowItem.getIMP().doubleValue()) * 100;
		responseItem.setPercentComplete(formatter.format(result) + " %");
	}

}
