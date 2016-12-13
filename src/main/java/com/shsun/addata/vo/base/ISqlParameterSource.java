package com.shsun.addata.vo.base;

/**
 * 
 * @author shsun
 * 
 */
public interface ISqlParameterSource {

	public void setSQL( String sql );

	public String getSQL();

	public void inlineProperties();
	
	public IHttpServletRequestParameter getHttpServletRequestParameter();
}
