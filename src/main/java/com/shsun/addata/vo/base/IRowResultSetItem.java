package com.shsun.addata.vo.base;

import java.util.Date;

/**
 * 
 * @author shsun
 * 
 */
public interface IRowResultSetItem {

	// -----------------------------------------------------------------------------
	public Short getMOBILE_SEGMENT_ID();

	public void setMOBILE_SEGMENT_ID(Short MOBILE_SEGMENT_ID);

	public String getDEVICE_TYPE();

	public void setDEVICE_TYPE(String type);

	public String getOS_TYPE();

	public void setOS_TYPE(String type);

	public String getCLIENT_TYPE();

	public void setCLIENT_TYPE(String type);

	public String getPLATFORM_TYPE();

	public void setPLATFORM_TYPE(String type);

	// -----------------------------------------------------------------------------
	public Date getDATE_TIME();

	public void setDATE_TIME(Date DATE_TIME);

	public String getDATE_NAME();

	public void setDATE_NAME(String DATE_NAME);

	// -----------------------------------------------------------------------------

	public Short getSITE_ID();

	public void setSITE_ID(Short SITE_ID);

	public String getSITE_NAME();

	public void setSITE_NAME(String SITE_NAME);

	// -----------------------------------------------------------------------------
	public Integer getCHANNEL_AGENT_ID();

	public void setCHANNEL_AGENT_ID(Integer channelId);

	public String getCHANNEL_NAME();

	public void setCHANNEL_NAME(String CHANNEL_NAME);

	public Long getSUB_CHANNEL_AGENT_ID();

	public void setSUB_CHANNEL_AGENT_ID(Long subChannelId);

	public String getSUB_CHANNEL_NAME();

	public void setSUB_CHANNEL_NAME(String SUB_CHANNEL_NAME);

	// -----------------------------------------------------------------------------
	public Integer getPROVINCE_ID();

	public void setPROVINCE_ID(Integer provinceId);

	public String getPROVINCE_NAME();

	public void setPROVINCE_NAME(String provinceId);

	public Integer getCITY_ID();

	public void setCITY_ID(Integer cityId);

	public String getCITY_NAME();

	public void setCITY_NAME(String provinceId);

	// -----------------------------------------------------------------------------
	public Short getSLOT_ID();

	public void setSLOT_ID(Short slotId);

	public String getSLOT_NAME();

	public void setSLOT_NAME(String SLOT_NAME);

	public Short getTYPE_ID();

	public void setTYPE_ID(Short typeId);

	public String getTYPE_NAME();

	public void setTYPE_NAME(String TYPE_NAME);
	
	
    public Short getVIDEO_LENGTH_ID();
    public void setVIDEO_LENGTH_ID(Short VIDEO_LENGTH_ID);	
}
