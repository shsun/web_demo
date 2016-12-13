package com.shsun.addata.vo;

import java.math.BigDecimal;

import com.shsun.addata.vo.base.IRowResultSetItem;

/**
 * 
 * @author shsun
 * 
 */
public class ImpressionRowItem extends EXTENSION_DW_ADS_IMP implements IRowResultSetItem {

	private String DATE_NAME;

	private String SITE_NAME;

	private String CONTRACT_NAME;

	private String CREATIVE_NAME;

	private String CAST_NAME;

	private BigDecimal CAST_ID;

	private BigDecimal CONTRACT_ID;

	private String contractType;

	private Short IS_AMOUNT;
	
	//
	private String SLOT_NAME;
	private String TYPE_NAME;
	private String PROVINCE_NAME;
	private String CITY_NAME;
	private String CHANNEL_NAME;
	private String SUB_CHANNEL_NAME;

	//
	public String getCREATIVE_NAME() {
		return CREATIVE_NAME;
	}

	public void setCREATIVE_NAME(String CREATIVE_NAME) {
		this.CREATIVE_NAME = CREATIVE_NAME;
	}

	public String getCAST_NAME() {
		return CAST_NAME;
	}

	public void setCAST_NAME(String CAST_NAME) {
		this.CAST_NAME = CAST_NAME;
	}

	public String getSLOT_NAME() {
		return SLOT_NAME;
	}

	public void setSLOT_NAME(String SLOT_NAME) {
		this.SLOT_NAME = SLOT_NAME;
	}

	public String getTYPE_NAME() {
		return TYPE_NAME;
	}

	public void setTYPE_NAME(String tYPE_NAME) {
		TYPE_NAME = tYPE_NAME;
	}

	public String getCONTRACT_NAME() {
		return CONTRACT_NAME;
	}

	public void setCONTRACT_NAME(String CONTRACT_NAME) {
		this.CONTRACT_NAME = CONTRACT_NAME;
	}

	public BigDecimal getCAST_ID() {
		return CAST_ID;
	}

	public void setCAST_ID(BigDecimal CAST_ID) {
		this.CAST_ID = CAST_ID;
	}

	public BigDecimal getCONTRACT_ID() {
		return CONTRACT_ID;
	}

	public void setCONTRACT_ID(BigDecimal CONTRACT_ID) {
		this.CONTRACT_ID = CONTRACT_ID;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Short getIS_AMOUNT() {
		return IS_AMOUNT;
	}

	public void setIS_AMOUNT(Short IS_AMOUNT) {
		this.IS_AMOUNT = IS_AMOUNT;
	}

	public String getPROVINCE_NAME() {
		return PROVINCE_NAME;
	}

	public void setPROVINCE_NAME(String PROVINCE_NAME) {
		this.PROVINCE_NAME = PROVINCE_NAME;
	}

	public String getCITY_NAME() {
		return CITY_NAME;
	}

	public void setCITY_NAME(String CITY_NAME) {
		this.CITY_NAME = CITY_NAME;
	}

	public String getCHANNEL_NAME() {
		return CHANNEL_NAME;
	}

	public void setCHANNEL_NAME(String CHANNEL_NAME) {
		this.CHANNEL_NAME = CHANNEL_NAME;
	}

	public String getSUB_CHANNEL_NAME() {
		return SUB_CHANNEL_NAME;
	}

	public void setSUB_CHANNEL_NAME(String SUB_CHANNEL_NAME) {
		this.SUB_CHANNEL_NAME = SUB_CHANNEL_NAME;
	}

	public String getDATE_NAME() {
		return this.DATE_NAME;
	}

	public void setDATE_NAME(String DATE_NAME) {
		this.DATE_NAME = DATE_NAME;
	}

	public String getSITE_NAME() {
		return this.SITE_NAME;
	}

	public void setSITE_NAME(String SITE_NAME) {
		this.SITE_NAME = SITE_NAME;
	}

	// -----------------------------------------------------------------------------------
	private String DEVICE_TYPE;

	private String OS_TYPE;

	private String CLIENT_TYPE;

	private String PLATFORM_TYPE;

	public String getDEVICE_TYPE() {
		return DEVICE_TYPE;
	}

	public void setDEVICE_TYPE(String DEVICE_TYPE) {
		this.DEVICE_TYPE = DEVICE_TYPE;
	}

	public String getOS_TYPE() {
		return OS_TYPE;
	}

	public void setOS_TYPE(String OS_TYPE) {
		this.OS_TYPE = OS_TYPE;
	}

	public String getCLIENT_TYPE() {
		return CLIENT_TYPE;
	}

	public void setCLIENT_TYPE(String CLIENT_TYPE) {
		this.CLIENT_TYPE = CLIENT_TYPE;
	}

	public String getPLATFORM_TYPE() {
		return PLATFORM_TYPE;
	}

	public void setPLATFORM_TYPE(String PLATFORM_TYPE) {
		this.PLATFORM_TYPE = PLATFORM_TYPE;
	}
}
