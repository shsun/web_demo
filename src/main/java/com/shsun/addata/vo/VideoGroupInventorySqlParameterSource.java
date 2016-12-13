package com.shsun.addata.vo;

import java.util.ArrayList;

import com.youdo.orm.SelectedPropertiesDescriptor;
import com.shsun.addata.vo.base.BasicSqlParameterSource;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
public class VideoGroupInventorySqlParameterSource extends BasicSqlParameterSource {

	public String VIDEO_GROUP_ID = null;
	public String VIDEO_GROUP_NAME = null;
	//
	public String PROGRAMME_AGENT_ID = null;
	public String PROGRAMME_NAME = null;
	//
	public String DIM_TABLE_NAME = "DIM_ADS_VIDEOGROUP";
	public String P_KEY_NAME = "VIDEO_GROUP_ID";
	public String F_KEY_NAME = "VIDEO_GROUP_ID";
	
	public String NAME = "VIDEO_GROUP_NAME";
	
	public SelectedPropertiesDescriptor PROGRAMME_GROUP_BY_PROPERTIES = new SelectedPropertiesDescriptor(this.DIM_TABLE_NAME, "dim");
	
	public VideoGroupInventorySqlParameterSource(IHttpServletRequestParameter httpServletRequestParameter) {
		super(httpServletRequestParameter);
	}
	
	@Override
	public void inlineProperties() {
		super.inlineProperties();
		this.GROUP_BY_PROPERTIES.addAll(this.PROGRAMME_GROUP_BY_PROPERTIES.getProperties());
		this.GROUP_BY_ALIASED_PROPERTIES.addAll(this.PROGRAMME_GROUP_BY_PROPERTIES.getAliasedProperties());
	}

}
