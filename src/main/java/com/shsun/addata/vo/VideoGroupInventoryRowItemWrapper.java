package com.shsun.addata.vo;

import com.shsun.addata.vo.base.ApplicationSharedObject;
import com.shsun.addata.vo.base.BaseRowItemWrapper;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IRowResultSetItem;

/**
 * 
 * @author shsun
 * 
 */
public class VideoGroupInventoryRowItemWrapper extends BaseRowItemWrapper {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VideoGroupInventoryRowItemWrapper.class);

	private DIM_ADS_VIDEOGROUP videoGroupVO;

	public VideoGroupInventoryRowItemWrapper(IHttpServletRequestParameter parameter, IRowResultSetItem item) {
		super(parameter, item);
	}

	@Override
	public void setRowItem( IRowResultSetItem item ) {
		super.setRowItem(item);

		//VideoGroupInventoryRowItem rowItem = (VideoGroupInventoryRowItem) this.getRowItem();
		//DIM_ADS_VIDEOGROUP v = ApplicationSharedObject.getInstance().getVideoGroupCollector().getByVGId(rowItem.getVIDEO_GROUP_ID());
		//this.setVideoGroupVO(v);
	}

	public DIM_ADS_VIDEOGROUP getVideoGroupVO() {
		return videoGroupVO;
	}

	public void setVideoGroupVO( DIM_ADS_VIDEOGROUP videoGroupVO ) {
		this.videoGroupVO = videoGroupVO;
	}

}
