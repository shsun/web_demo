package com.shsun.addata.vo.base;

import java.util.ArrayList;
import java.util.List;

import com.shsun.addata.ApplicationConstants;
import com.youdo.orm.SelectedPropertiesDescriptor;

public class BasicSqlParameterSource implements ISqlParameterSource {

	//
	private String sql;

	// 
	public String TABLE_NAME = "DIM_COM_CITY";
	public String DIM_ADS_SLOT = "DIM_ADS_SLOT";
	public String DIM_ADS_MOBILE_SEG = "DIM_ADS_MOBILE_SEG";
	//
	public String level = ApplicationConstants.TableLevel.DAY.getCode();
	//
	public String START_DATE = "";
	public String END_DATE = "";
	//
	//
	public String SITE_ID = "";
	//
	public String PROVINCE_ID = "";
	public String CITY_ID = "";
	//
	public String CHANNEL_AGENT_ID = "";
	public String SUB_CHANNEL_AGENT_ID = "";
	//
	public String DATE_TIME = "";
	public String HOUR_ID = "";
	//
	public String SLOT_ID = "";
	//

	//
	public String START_ROW = "0";
	public String END_ROW = "60";
	//
	//
	public List< String > GROUP_BY_ALIASED_PROPERTIES = new ArrayList< String >();
	public List< String > GROUP_BY_PROPERTIES = new ArrayList< String >();
	//
	public SelectedPropertiesDescriptor DRIVER_GROUP_BY_PROPERTIES = new SelectedPropertiesDescriptor(this.TABLE_NAME, "driver");
	//
	public SelectedPropertiesDescriptor SLOT_GROUP_BY_PROPERTIES = new SelectedPropertiesDescriptor(this.DIM_ADS_SLOT, "slot");
	//
	public SelectedPropertiesDescriptor MOBILE_SEGMENT_GROUP_BY_PROPERTIES = new SelectedPropertiesDescriptor(this.DIM_ADS_MOBILE_SEG, "seg");
	//
	// -------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	public String MOBILE_SEGMENT_ID = "";
	public String VIDEO_LENGTH_ID;

	
	private IHttpServletRequestParameter httpServletRequestParameter;
	
	public BasicSqlParameterSource(IHttpServletRequestParameter httpServletRequestParameter) {
		this.httpServletRequestParameter = httpServletRequestParameter;
	}

	//
	public void setSQL( String sql ) {
		this.sql = sql;
	}

	public String getSQL() {
		return this.sql;
	}

	public void inlineProperties() {
		this.GROUP_BY_PROPERTIES = new ArrayList<String>();
		this.GROUP_BY_PROPERTIES.addAll(this.DRIVER_GROUP_BY_PROPERTIES.getProperties());
		this.GROUP_BY_PROPERTIES.addAll(this.SLOT_GROUP_BY_PROPERTIES.getProperties());
		this.GROUP_BY_PROPERTIES.addAll(this.MOBILE_SEGMENT_GROUP_BY_PROPERTIES.getProperties());
		//
		this.GROUP_BY_ALIASED_PROPERTIES = new ArrayList<String>();
		this.GROUP_BY_ALIASED_PROPERTIES.addAll(this.DRIVER_GROUP_BY_PROPERTIES.getAliasedProperties());
		this.GROUP_BY_ALIASED_PROPERTIES.addAll(this.SLOT_GROUP_BY_PROPERTIES.getAliasedProperties());
		this.GROUP_BY_ALIASED_PROPERTIES.addAll(this.MOBILE_SEGMENT_GROUP_BY_PROPERTIES.getAliasedProperties());
	}

	public IHttpServletRequestParameter getHttpServletRequestParameter() {
		return this.httpServletRequestParameter;
	}
}
