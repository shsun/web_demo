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
public class ImpressionRowItemWrapper extends BaseRowItemWrapper implements IRowItemWrapper {
	//
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ImpressionRowItemWrapper.class);

	public ImpressionRowItemWrapper(IHttpServletRequestParameter parameter, IRowResultSetItem item) {
		super(parameter, item);
	}


	/*
	 * 
	public ImpressionRowItemWrapper() {

	}

	public ImpressionRowItemWrapper(IHttpServletRequestParameter p) {
		this.setHttpServletRequestParameter(p);
	}
	
	public ImpressionRowItemWrapper(IHttpServletRequestParameter p, ImpressionRowItem item) {
		this.setHttpServletRequestParameter(p);
		this.setRowItem(item);
	}
	*/
}
