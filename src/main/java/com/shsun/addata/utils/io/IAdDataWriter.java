package com.shsun.addata.utils.io;

import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
public interface IAdDataWriter {

	/**
	 * 
	 * @param parameter
	 */
	public void write();

	/**
	 * 
	 * @return
	 */
	public IHttpServletRequestParameter getHttpServletRequestParameter();

	/**
	 * 
	 * @param httpServletRequestParameter
	 */
	public void setHttpServletRequestParameter( IHttpServletRequestParameter httpServletRequestParameter );

	// -------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @return
	 */
	public IBeforeWritingItemProcessor getBeforeWritingItemProcessor();

	/**
	 * 
	 * @param beforeWritingItemProcessor
	 */
	public void setBeforeWritingItemProcessor( IBeforeWritingItemProcessor beforeWritingItemProcessor );
}
