package com.shsun.addata.entry.common;

import java.util.Date;

/**
 * 
 * @author shsun
 * 
 */
public abstract class AbstractAdDataEntry implements IAdDataEntry {

	private Date DATE_TIME;

	private Integer DATE_ID;

	private Short SITE_ID;

	private Short SLOT_ID;

	private Short TYPE_ID;

	public Date getDATE_TIME() {
		return DATE_TIME;
	}

	public void setDATE_TIME( Date DATE_TIME ) {
		this.DATE_TIME = DATE_TIME;
	}

	public Integer getDATE_ID() {
		return DATE_ID;
	}

	public void setDATE_ID( Integer DATE_ID ) {
		this.DATE_ID = DATE_ID;
	}

	public Short getSITE_ID() {
		return SITE_ID;
	}

	public void setSITE_ID( Short SITE_ID ) {
		this.SITE_ID = SITE_ID;
	}

	public Short getSLOT_ID() {
		return SLOT_ID;
	}

	public void setSLOT_ID( Short SLOT_ID ) {
		this.SLOT_ID = SLOT_ID;
	}

	public Short getTYPE_ID() {
		return TYPE_ID;
	}

	public void setTYPE_ID( Short tYPE_ID ) {
		TYPE_ID = tYPE_ID;
	}

}
