package com.shsun.addata.entry.common;

import java.util.Date;

/**
 * 
 * @author shsun
 * 
 */
public interface IAdDataEntry {

	public Date getDATE_TIME();

	public void setDATE_TIME( Date DATE_TIME );

	public Integer getDATE_ID();

	public void setDATE_ID( Integer DATE_ID );

	public Short getSITE_ID();

	public void setSITE_ID( Short SITE_ID );

	public Short getSLOT_ID();

	public void setSLOT_ID( Short SLOT_ID );

	public Short getTYPE_ID();

	public void setTYPE_ID( Short tYPE_ID );
}
