package com.shsun.addata.vo.base;

import com.shsun.addata.vo.DIM_COM_CITY;
import com.shsun.addata.support.vo.channel.ChannelVO;
import com.shsun.addata.support.vo.channel.SubChannelVO;

/**
 * 
 * @author shsun
 * 
 * @param <ROW_ITEM>
 * @param <POJO>
 */
public interface IRowItemWrapper {
	// ------------------------------------------------------------------------------------
	public void setRowItem(IRowResultSetItem item);

	public IRowResultSetItem getRowItem();

	// ------------------------------------------------------------------------------------
	public void setHttpServletRequestParameter(IHttpServletRequestParameter parameter);

	public IHttpServletRequestParameter getHttpServletRequestParameter();

	// ------------------------------------------------------------------------------------
	public void setProvinceVO(DIM_COM_CITY province);

	public DIM_COM_CITY getProvinceVO();

	public void setCityVO(DIM_COM_CITY city);

	public DIM_COM_CITY getCityVO();

	// ------------------------------------------------------------------------------------
	public void setChannelVO(ChannelVO channelVO);

	public void setSubChannelVO(SubChannelVO subChannelVO);

	public ChannelVO getChannelVO();

	public SubChannelVO getSubChannelVO();

}
