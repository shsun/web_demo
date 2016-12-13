package com.shsun.addata.vo.base;

/**
 * @author shsun
 * 
 */
public interface IRowItemProcessor {

	/**
	 * 
	 * @param wrapper
	 * @return
	 */
	public IHttpServletResponseItem process( IRowItemWrapper wrapper );
}
