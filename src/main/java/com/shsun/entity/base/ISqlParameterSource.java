package com.shsun.entity.base;

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
