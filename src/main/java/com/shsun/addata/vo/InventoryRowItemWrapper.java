package com.shsun.addata.vo;

import com.shsun.addata.vo.base.BaseRowItemWrapper;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IRowItemWrapper;
import com.shsun.addata.vo.base.IRowResultSetItem;


/**
 * 
 * @author shsun
 * 
 */
public class InventoryRowItemWrapper extends BaseRowItemWrapper implements IRowItemWrapper {
	//
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(InventoryRowItemWrapper.class);

	public InventoryRowItemWrapper(IHttpServletRequestParameter parameter, IRowResultSetItem item) {
		super(parameter, item);
	}

	/*
	public InventoryRowItemWrapper() {

	}

	public InventoryRowItemWrapper(IHttpServletRequestParameter p) {
		this.setHttpServletRequestParameter(p);
	}

	public InventoryRowItemWrapper(IHttpServletRequestParameter p, InventoryRowItem item) {
		this.setHttpServletRequestParameter(p);
		this.setRowItem(item);
	}
	*/
}
