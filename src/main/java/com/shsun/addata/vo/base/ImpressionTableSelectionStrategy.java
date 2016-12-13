package com.shsun.addata.vo.base;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.vo.ImpressionHttpServletRequestParameter;
import com.shsun.addata.vo.ImpressionSqlParameterSource;

/**
 * 
 * @author shsun
 * 
 */
public class ImpressionTableSelectionStrategy extends AbstractTableSelectionStrategy {

	/**
	 * 
	 * @param httpServletRequestParameter
	 * @param sqlParameterSource
	 */
	public ImpressionTableSelectionStrategy(IHttpServletRequestParameter httpServletRequestParameter, ISqlParameterSource sqlParameterSource) {
		super(httpServletRequestParameter, sqlParameterSource);
	}

	@Override
	protected void doSelect() {
		// TODO Auto-generated method stub
		ImpressionHttpServletRequestParameter p = (ImpressionHttpServletRequestParameter) this.httpServletRequestParameter;
		ImpressionSqlParameterSource s = (ImpressionSqlParameterSource) this.sqlParameterSource;

		if (p.isMobile()) {
			s.TABLE_NAME = "DW_ADS_M_IMP_CT_CHANNEL_DAY";
			// s.TABLE_NAME = "DW_ADS_MOBILE_IMP_DAY";
			p.timeLevel = ApplicationConstants.TableLevel.DAY;
		} else {
			if (!p.timeSLP.has1stLevelParameter()) {
				if (p.isOnlyCity() && p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_IMP_DAY";
				} else if (p.isOnlyCity() && !p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_IMP_CITY_CHANNEL_DAY";
				} else if (!p.isOnlyCity() && p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_IMP_DAY"; // "DW_ADS_IMP_P_SUBCHANNEL_DAY"
				} else if (!p.isOnlyCity() && !p.isOnlySubChannel()) {
					s.TABLE_NAME = "DW_ADS_IMP_P_CHANNEL_DAY";
				}
				p.timeLevel = ApplicationConstants.TableLevel.DAY;
			} else {
				s.TABLE_NAME = "DW_ADS_IMP_HOUR";
				p.timeLevel = ApplicationConstants.TableLevel.HOUR;
			}
		}

	}
}
