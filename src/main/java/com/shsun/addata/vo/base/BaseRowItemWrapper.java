package com.shsun.addata.vo.base;

import com.shsun.addata.vo.DIM_COM_CITY;
import com.shsun.addata.vo.DIM_COM_PROVINCE;
import com.shsun.addata.support.vo.channel.ChannelSubChannelPair;
import com.shsun.addata.support.vo.channel.ChannelVO;
import com.shsun.addata.support.vo.channel.SubChannelVO;

/**
 * 
 * @author shsun
 * 
 */
public class BaseRowItemWrapper implements IRowItemWrapper {

	/**
	 * 
	 */
	private IHttpServletRequestParameter httpServletRequestParameter;

	/**
	 * 
	 */
	protected IRowResultSetItem rowItem;

	/**
	 * 
	 */
	private DIM_COM_CITY provinceVO;
	private DIM_COM_CITY cityVO;

	private ChannelVO channelVO;
	private SubChannelVO subChannelVO;

	/**
	 * 
	 */
	public BaseRowItemWrapper(IHttpServletRequestParameter parameter, IRowResultSetItem item) {
		this.setHttpServletRequestParameter(parameter);
		this.setRowItem(item);
	}

	/**
	 * 
	 */
	public void setRowItem( IRowResultSetItem item ) {
		this.rowItem = item;
		this.doMapping();
	}

	private void doMapping() {
		ApplicationSharedObject so = ApplicationSharedObject.getInstance();
		try {
			DIM_COM_CITY province = so.getRegionVOContainer().getFullCityVOByProvinceId(this.getRowItem().getPROVINCE_ID());
			this.setProvinceVO(province);
		} catch (Exception e) {
		}
		try {
			DIM_COM_CITY city = so.getRegionVOContainer().getFullCityVOByCityId(this.getRowItem().getCITY_ID());
			this.setCityVO(city);
		} catch (Exception e) {
		}
		//
		try {
			ChannelSubChannelPair pair = so.getChannelVOCollector().getChannelSubChannelPair(this.getRowItem().getCHANNEL_AGENT_ID(), this.getRowItem().getSUB_CHANNEL_AGENT_ID());
			this.setChannelVO(pair.getChannelVO());
			this.setSubChannelVO(pair.getSubChannelVO());
		} catch (Exception e) {
		}
	}

	public void setHttpServletRequestParameter( IHttpServletRequestParameter parameter ) {
		this.httpServletRequestParameter = parameter;
	}

	public IHttpServletRequestParameter getHttpServletRequestParameter() {
		return this.httpServletRequestParameter;
	}

	public IRowResultSetItem getRowItem() {
		return rowItem;
	}

	public ChannelVO getChannelVO() {
		return channelVO;
	}

	public void setChannelVO( ChannelVO channelVO ) {
		this.channelVO = channelVO;
	}

	public SubChannelVO getSubChannelVO() {
		return subChannelVO;
	}

	public void setSubChannelVO( SubChannelVO subChannelVO ) {
		this.subChannelVO = subChannelVO;
	}

	public void setProvinceVO( DIM_COM_CITY province ) {
		this.provinceVO = province;
	}

	public DIM_COM_CITY getProvinceVO() {
		return this.provinceVO;
	}

	public void setCityVO( DIM_COM_CITY city ) {
		this.cityVO = city;
	}

	public DIM_COM_CITY getCityVO() {
		return this.cityVO;
	}

}
