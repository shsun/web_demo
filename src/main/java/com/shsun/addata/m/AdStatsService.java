package com.shsun.addata.m;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shsun.addata.vo.DIM_ADS_CHANNEL;
import com.shsun.addata.vo.DIM_ADS_CHANNELMapper;
import com.shsun.addata.vo.DIM_ADS_CHANNEL_SUB;
import com.shsun.addata.vo.DIM_ADS_CHANNEL_SUBMapper;
import com.shsun.addata.vo.DIM_ADS_MOBILE_SEG;
import com.shsun.addata.vo.DIM_ADS_MOBILE_SEGMapper;
import com.shsun.addata.vo.DIM_ADS_SLOT;
import com.shsun.addata.vo.DIM_ADS_SLOTMapper;
import com.shsun.addata.vo.DIM_ADS_TYPE;
import com.shsun.addata.vo.DIM_ADS_TYPEMapper;
import com.shsun.addata.vo.DIM_ADS_VIDEOGROUP;
import com.shsun.addata.vo.DIM_ADS_VIDEOGROUPMapper;
import com.shsun.addata.vo.DIM_COM_CITY;
import com.shsun.addata.vo.DIM_COM_CITYMapper;
import com.shsun.addata.vo.DIM_COM_PROVINCE;
import com.shsun.addata.vo.DIM_COM_PROVINCEMapper;
import com.youdo.util.lang.TreeNode;
import com.shsun.addata.ApplicationConstants.Site;
import com.shsun.addata.support.vo.channel.ChannelVO;
import com.shsun.addata.support.vo.channel.ChannelVOCollector;
import com.shsun.addata.support.vo.city.GeoVOCollector;
import com.shsun.addata.support.vo.city.ProvinceVO;
import com.shsun.addata.support.vo.city.RegionVOContainer;
import com.shsun.addata.support.vo.segment.SegmentCollector;
import com.shsun.addata.support.vo.slot.SlotCategoryCollector;
import com.shsun.addata.support.vo.type.TypeCategoryCollector;
import com.shsun.addata.support.vo.videogroup.VideoGroupCollector;
import com.shsun.addata.vo.base.ApplicationSharedObject;

public class AdStatsService {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AdStatsService.class);

	@Autowired
	private DIM_COM_PROVINCEMapper dim_COM_PROVINCEMapper;
	
	@Autowired
	private DIM_COM_CITYMapper dim_COM_CITYMapper;
	
	@Autowired
	private DIM_ADS_SLOTMapper dim_ADS_SLOTMapper;

	@Autowired
	private DIM_ADS_TYPEMapper dim_ADS_TYPEMapper;

	@Autowired
	private DIM_ADS_CHANNELMapper dim_ADS_CHANNELMapper;

	@Autowired
	private DIM_ADS_CHANNEL_SUBMapper dim_ADS_CHANNEL_SUBMapper;

	@Autowired
	private DIM_ADS_MOBILE_SEGMapper dim_ADS_MOBILE_SEGMapper;
	
	@Autowired
	private DIM_ADS_VIDEOGROUPMapper dim_ADS_VIDEOGROUPMapper;

	/**
	 * 
	 * @param collector
	 */
	public void reloadChannel() {
		List< DIM_ADS_CHANNEL > ret = this.dim_ADS_CHANNELMapper.retrieveAll();
		if (ret != null && ret.size() > 0) {
			ApplicationSharedObject.getInstance().setChannelVOCollector(new ChannelVOCollector());
			for (int i = 0; i < ret.size(); i++) {
				List< DIM_ADS_CHANNEL_SUB > sublist = this.dim_ADS_CHANNEL_SUBMapper.retrieveAllByAgentId(ret.get(i).getCHANNEL_AGENT_ID());
				ApplicationSharedObject.getInstance().getChannelVOCollector().add(new ChannelVO(ret.get(i), sublist));
			}
		}
	}

	public void reloadGEO2() {
		/*
		ApplicationSharedObject.getInstance().geo = new TreeNode(Integer.MIN_VALUE, "root");
		//
		ApplicationSharedObject.getInstance().setGeoVOCollector(new GeoVOCollector());
		List< DIM_COM_PROVINCE > list = this.dim_COM_PROVINCEMapper.retrieveAll();
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				List< DIM_COM_CITY > sublist = this.dim_COM_CITYMapper.retrieveAllByProvinceId(list.get(i).getPROVINCE_ID());
				ApplicationSharedObject.getInstance().getGeoVOCollector().add(new ProvinceVO(list.get(i), sublist));
				//
				TreeNode p = new TreeNode(list.get(i).getPROVINCE_ID().intValue(), list.get(i).getPROVINCE_NAME(), list.get(i));
				ApplicationSharedObject.getInstance().geo.addChildNode(p);
				for (int j = 0; j < sublist.size(); j++) {
					p.addChildNode(new TreeNode(sublist.get(j).getCITY_ID().intValue(), sublist.get(j).getCITY_NAME(), sublist.get(j)));
				}
			}
		}
		*/
	}

	public void reloadGEO() {
		List< DIM_COM_CITY > ret = this.dim_COM_CITYMapper.retrieveAll();
		if (ret != null && ret.size() > 0) {
			ApplicationSharedObject.getInstance().setRegionVOContainer(new RegionVOContainer(ret));
		}
	}

	public void reloadAdSlot() {
		List<DIM_ADS_SLOT> ret = this.dim_ADS_SLOTMapper.retrieveAll();
		if (ret != null && ret.size() > 0) {
			ApplicationSharedObject.getInstance().setSlotCategoryCollector(new SlotCategoryCollector(ret));
		}
	}

	public void reloadAdType() {
		List<DIM_ADS_TYPE> ret = this.dim_ADS_TYPEMapper.retrieveAll();
		if (ret != null && ret.size() > 0) {
			ApplicationSharedObject.getInstance().setTypeCategoryCollector(new TypeCategoryCollector(ret));
		}
	}
	
	public void reloadSegment() {
		List<DIM_ADS_MOBILE_SEG> ret = this.dim_ADS_MOBILE_SEGMapper.retrieveAll();
		if (ret != null && ret.size() > 0) {
			ApplicationSharedObject.getInstance().setSegmentCollector(new SegmentCollector(ret));
		}
		
	}
	
	public void reloadVideoGroup() {
		List<DIM_ADS_VIDEOGROUP> ret = this.dim_ADS_VIDEOGROUPMapper.retrieveAll();
		if (ret != null && ret.size() > 0) {
			ApplicationSharedObject.getInstance().setVideoGroupCollector(new VideoGroupCollector(ret));
		}

	}
	
	//---------------------------------------------------------------------------------------------------------------------------------------
	public DIM_COM_CITYMapper getDim_COM_CITYMapper() {
		return dim_COM_CITYMapper;
	}

	public void setDim_COM_CITYMapper( DIM_COM_CITYMapper dim_COM_CITYMapper ) {
		this.dim_COM_CITYMapper = dim_COM_CITYMapper;
	}

	public DIM_ADS_SLOTMapper getDim_ADS_SLOTMapper() {
		return dim_ADS_SLOTMapper;
	}

	public void setDim_ADS_SLOTMapper( DIM_ADS_SLOTMapper dim_ADS_SLOTMapper ) {
		this.dim_ADS_SLOTMapper = dim_ADS_SLOTMapper;
	}

	public DIM_ADS_TYPEMapper getDim_ADS_TYPEMapper() {
		return dim_ADS_TYPEMapper;
	}

	public void setDim_ADS_TYPEMapper( DIM_ADS_TYPEMapper dim_ADS_TYPEMapper ) {
		this.dim_ADS_TYPEMapper = dim_ADS_TYPEMapper;
	}

	public DIM_ADS_CHANNELMapper getDim_ADS_CHANNELMapper() {
		return dim_ADS_CHANNELMapper;
	}

	public void setDim_ADS_CHANNELMapper( DIM_ADS_CHANNELMapper dim_ADS_CHANNELMapper ) {
		this.dim_ADS_CHANNELMapper = dim_ADS_CHANNELMapper;
	}

	public DIM_ADS_CHANNEL_SUBMapper getDim_ADS_CHANNEL_SUBMapper() {
		return dim_ADS_CHANNEL_SUBMapper;
	}

	public void setDim_ADS_CHANNEL_SUBMapper( DIM_ADS_CHANNEL_SUBMapper dim_ADS_CHANNEL_SUBMapper ) {
		this.dim_ADS_CHANNEL_SUBMapper = dim_ADS_CHANNEL_SUBMapper;
	}

	public DIM_ADS_MOBILE_SEGMapper getDim_ADS_MOBILE_SEGMapper() {
		return dim_ADS_MOBILE_SEGMapper;
	}

	public void setDim_ADS_MOBILE_SEGMapper( DIM_ADS_MOBILE_SEGMapper dim_ADS_MOBILE_SEGMapper ) {
		this.dim_ADS_MOBILE_SEGMapper = dim_ADS_MOBILE_SEGMapper;
	}

}
