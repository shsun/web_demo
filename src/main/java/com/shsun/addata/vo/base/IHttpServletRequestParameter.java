package com.shsun.addata.vo.base;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youdo.interfaces.IJSONObjectParsable;
import com.youdo.mybatis.Page;
import com.shsun.addata.support.vo.ErrorDescriptor;
import com.shsun.addata.support.vo.GroupByVO;

/**
 * 
 * @author shsun
 * 
 */
public interface IHttpServletRequestParameter extends IJSONObjectParsable {

	/**
	 * 
	 */
	public void buildDisplayPriority( );

	/**
	 * 
	 * @return true indicate is mobile mode, otherwise PC mode.
	 */
	public boolean isMobile();

	/**
	 * 
	 * @return
	 */
	public Page< IRowResultSetItem > getPager();

	/**
	 * 
	 * @param out
	 */
	public void exportFile( OutputStream out );

	// -------------------------------------------------------------------------------
	/**
	 * 
	 * @return
	 */
	public HttpServletRequest getHttpServeltRequest();

	/**
	 * 
	 * @param request
	 */
	public void setHttpServeltRequest( HttpServletRequest request );

	/**
	 * 
	 * @return
	 */
	public HttpServletResponse getHttpServletResponse();

	/**
	 * 
	 * @param response
	 */
	public void setHttpServletResponse( HttpServletResponse response );

	// -------------------------------------------------------------------------------
	/**
	 * 
	 * @return
	 */
	public SecondLevelParameter getCitySLP();

	/**
	 * 
	 * @param citySLP
	 */
	public void setCitySLP( SecondLevelParameter citySLP );

	/**
	 * 
	 * @return
	 */
	public SecondLevelParameter getChannelSLP();

	/**
	 * 
	 * @param channelSLP
	 */
	public void setChannelSLP( SecondLevelParameter channelSLP );

	// -------------------------------------------------------------------------------
	/**
	 * 
	 * @return
	 */
	public GroupByVO getGroupByVO();

	/**
	 * 
	 * @param groupByVO
	 */
	public void setGroupByVO( GroupByVO groupByVO );

	// -------------------------------------------------------------------------------

	public String toSQL();

	// -------------------------------------------------------------------------------

	public String getTimecost();
	public void setTimecost( String timecost );

	// -------------------------------------------------------------------------------

	/**
	 * 
	 * @param errorDescriptor
	 */
	public void setErrorDescriptor( ErrorDescriptor errorDescriptor );

	/**
	 * 
	 * @return
	 */
	public ErrorDescriptor getErrorDescriptor();

	
	public String[] getEnglishPriorityArray();
	public void setEnglishPriorityArray( String[] englishPriorityArray );	
	
	
	public String getTimestamp();
	public void setTimestamp( String timestamp );
	// ------------------------------------------------------------------------------------------------------------------
	public boolean isOnlyCity();

	public boolean isOnlySubChannel();
}
