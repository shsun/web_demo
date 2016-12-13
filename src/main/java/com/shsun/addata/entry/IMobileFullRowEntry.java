package com.shsun.addata.entry;

/**
 * 
 * @author shsun
 * 
 */
public interface IMobileFullRowEntry extends IPCFullRowEntry {

	// -----------------------------------------------------------------------------

	public String getDEVICE_TYPE();

	public void setDEVICE_TYPE( String type );

	public String getOS_TYPE();

	public void setOS_TYPE( String type );

	public String getCLIENT_TYPE();

	public void setCLIENT_TYPE( String type );

	public String getPLATFORM_TYPE();

	public void setPLATFORM_TYPE( String type );
}
