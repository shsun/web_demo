package com.shsun.addata.utils.io;

import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
public abstract class AbstractAdDataWriter implements IAdDataWriter {

	/**
	 * 
	 */
	private IHttpServletRequestParameter httpServletRequestParameter;
	/**
	 * 
	 */
	private IBeforeWritingItemProcessor beforeWritingItemProcessor;

	/**
	 * 你好test
	 * 
	 * @param parameter
	 */
	public AbstractAdDataWriter(IHttpServletRequestParameter parameter, IBeforeWritingItemProcessor processor) {
		this.setHttpServletRequestParameter(parameter);
		this.setBeforeWritingItemProcessor(processor);
	}

	public void write() {
		//
		//this.doWrite();
	}

	//protected abstract void doWrite();

	// -----------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	public IHttpServletRequestParameter getHttpServletRequestParameter() {
		return httpServletRequestParameter;
	}

	/**
	 * 
	 */
	public void setHttpServletRequestParameter( IHttpServletRequestParameter httpServletRequestParameter ) {
		this.httpServletRequestParameter = httpServletRequestParameter;
	}

	// -----------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	public IBeforeWritingItemProcessor getBeforeWritingItemProcessor() {
		return beforeWritingItemProcessor;
	}

	/**
	 * 
	 */
	public void setBeforeWritingItemProcessor( IBeforeWritingItemProcessor beforeWritingItemProcessor ) {
		this.beforeWritingItemProcessor = beforeWritingItemProcessor;
	}

}
