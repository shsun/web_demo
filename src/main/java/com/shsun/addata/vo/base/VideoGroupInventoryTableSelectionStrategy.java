package com.shsun.addata.vo.base;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.vo.InventoryHttpServletRequestParameter;
import com.shsun.addata.vo.InventorySqlParameterSource;
import com.shsun.addata.vo.VideoGroupInventoryHttpServletRequestParameter;
import com.shsun.addata.vo.VideoGroupInventorySqlParameterSource;

/**
 * 
 * @author shsun
 * 
 */
public class VideoGroupInventoryTableSelectionStrategy extends AbstractTableSelectionStrategy {

	public VideoGroupInventoryTableSelectionStrategy(IHttpServletRequestParameter httpServletRequestParameter,
			ISqlParameterSource sqlParameterSource) {
		super(httpServletRequestParameter, sqlParameterSource);
		// TODO Auto-generated constructor stub

	}

	@Override
	protected void doSelect() {
		// TODO Auto-generated method stub
		VideoGroupInventoryHttpServletRequestParameter p = (VideoGroupInventoryHttpServletRequestParameter) this.httpServletRequestParameter;
		VideoGroupInventorySqlParameterSource s = (VideoGroupInventorySqlParameterSource) this.sqlParameterSource;
		if (p.isMobile()) {
			s.TABLE_NAME = "DW_ADS_M_ADI_VIDEOGP_DAY";
		} else {
			if (p.is_video_group) {
				s.TABLE_NAME = "DW_ADS_ADI_VIDEOGP_DAY";
				s.DIM_TABLE_NAME = "DIM_ADS_VIDEOGROUP";
				s.P_KEY_NAME = "VIDEO_GROUP_ID";
				s.F_KEY_NAME = "VIDEO_GROUP_ID";
				s.NAME = "VIDEO_GROUP_NAME";
			} else {
				s.TABLE_NAME = "DW_ADS_ADI_PROGRAMME_DAY";
				s.DIM_TABLE_NAME = "DIM_ADS_PROGRAMME";
				s.P_KEY_NAME = "PROGRAMME_ID";
				s.F_KEY_NAME = "PROGRAMME_AGENT_ID";
				s.NAME = "PROGRAMME_NAME";
			}
		}
		p.timeLevel = ApplicationConstants.TableLevel.DAY;
	}

}
