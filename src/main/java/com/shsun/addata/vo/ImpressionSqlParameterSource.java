package com.shsun.addata.vo;

import com.youdo.orm.SelectedPropertiesDescriptor;
import com.shsun.addata.vo.base.BasicSqlParameterSource;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
public class ImpressionSqlParameterSource extends BasicSqlParameterSource {

	public String AMOUNT_SOUR_ID = "";
	//
	public String CONTRACT_ID = "";
	public String CONTRACT_NAME = "";

	// ---------------------------------------------------------------------------------
	public String CREATIVE_TABLE_NAME = "DIM_ADS_CREATIVE";

	public String CONTRACT_TABLE_NAME = "DIM_ADS_CONTRACT";

	public SelectedPropertiesDescriptor CREATIVE_GROUP_BY_PROPERTIES = new SelectedPropertiesDescriptor(this.CREATIVE_TABLE_NAME, "creative");

	public SelectedPropertiesDescriptor CONTRACT_GROUP_BY_PROPERTIES = new SelectedPropertiesDescriptor(this.CONTRACT_TABLE_NAME, "contract");

	/**
	 * 
	 */
	public ImpressionSqlParameterSource(IHttpServletRequestParameter httpServletRequestParameter) {
		super(httpServletRequestParameter);
	}

	public void inlineProperties() {
		super.inlineProperties();
		//
		this.GROUP_BY_PROPERTIES.addAll(this.CREATIVE_GROUP_BY_PROPERTIES.getProperties());
		this.GROUP_BY_PROPERTIES.addAll(this.CONTRACT_GROUP_BY_PROPERTIES.getProperties());
		//
		this.GROUP_BY_ALIASED_PROPERTIES.addAll(this.CREATIVE_GROUP_BY_PROPERTIES.getAliasedProperties());
		this.GROUP_BY_ALIASED_PROPERTIES.addAll(this.CONTRACT_GROUP_BY_PROPERTIES.getAliasedProperties());
	}
}
