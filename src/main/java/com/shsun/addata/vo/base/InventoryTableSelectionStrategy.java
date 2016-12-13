package com.shsun.addata.vo.base;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.vo.InventoryHttpServletRequestParameter;
import com.shsun.addata.vo.InventorySqlParameterSource;

/**
 * 
 * @author shsun
 * 
 */
public class InventoryTableSelectionStrategy extends AbstractTableSelectionStrategy {

	/**
	 * 
	 * @param httpServletRequestParameter
	 * @param sqlParameterSource
	 */
	public InventoryTableSelectionStrategy(IHttpServletRequestParameter httpServletRequestParameter, ISqlParameterSource sqlParameterSource) {
		super(httpServletRequestParameter, sqlParameterSource);
	}

	@Override
	protected void doSelect() {
		// TODO Auto-generated method stub
		InventoryHttpServletRequestParameter p = (InventoryHttpServletRequestParameter) this.httpServletRequestParameter;
		InventorySqlParameterSource s = (InventorySqlParameterSource) this.sqlParameterSource;

		if (p.isMobile()) {
			s.TABLE_NAME = "DW_ADS_M_ADI_CT_CHANNEL_DAY";
			// s.TABLE_NAME = "DW_ADS_MOBILE_ADI_DAY";
			p.timeLevel = ApplicationConstants.TableLevel.DAY;
		} else {
			if (!p.timeSLP.has1stLevelParameter()) {
				if (p.isOnlyCity() && p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_ADI_DAY";
				} else if (p.isOnlyCity() && !p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_ADI_CITY_CHANNEL_DAY";
				} else if (!p.isOnlyCity() && p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_ADI_DAY"; // "DW_ADS_ADI_P_SUBCHANNEL_DAY"
				} else if (!p.isOnlyCity() && !p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_ADI_P_CHANNEL_DAY";
				}
				p.timeLevel = ApplicationConstants.TableLevel.DAY;
			} else {
				s.TABLE_NAME = "DW_ADS_ADI_HOUR";
				p.timeLevel = ApplicationConstants.TableLevel.HOUR;
			}
		}

	}
}
