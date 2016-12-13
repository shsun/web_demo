package com.shsun.addata.entry;

/**
 * 
 * @author shsun
 * 
 */
public interface IPCFullRowEntry extends IPCFactDayRowEntry {

	// -----------------------------------------------------------------------------

	public String getDATE_NAME();

	public void setDATE_NAME( String DATE_NAME );

	// -----------------------------------------------------------------------------

	public String getSITE_NAME();

	public void setSITE_NAME( String SITE_NAME );

	// -----------------------------------------------------------------------------

	public String getCHANNEL_NAME();

	public void setCHANNEL_NAME( String CHANNEL_NAME );

	public String getSUB_CHANNEL_NAME();

	public void setSUB_CHANNEL_NAME( String SUB_CHANNEL_NAME );

	// -----------------------------------------------------------------------------

	public String getPROVINCE_NAME();

	public void setPROVINCE_NAME( String provinceId );

	public String getCITY_NAME();

	public void setCITY_NAME( String provinceId );

	// -----------------------------------------------------------------------------

	public String getSLOT_NAME();

	public void setSLOT_NAME( String SLOT_NAME );

	// -----------------------------------------------------------------------------

	public String getTYPE_NAME();

	public void setTYPE_NAME( String TYPE_NAME );

	// -----------------------------------------------------------------------------

	public String getVIDEO_LENGTH_NAME();

	public void setVIDEO_LENGTH_NAME( String VIDEO_LENGTH_NAME );
	// -----------------------------------------------------------------------------
}
