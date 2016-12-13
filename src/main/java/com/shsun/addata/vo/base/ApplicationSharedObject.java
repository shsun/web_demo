package com.shsun.addata.vo.base;

import com.shsun.addata.support.PropertyWrapper;
import com.youdo.util.lang.TreeNode;
import com.youdo.util.mail.MailSenderInfo;
import com.youdo.util.mail.TextMailSender;
import com.shsun.addata.support.vo.campaign.CampaignVOCollector;
import com.shsun.addata.support.vo.channel.ChannelVOCollector;
import com.shsun.addata.support.vo.city.GeoVOCollector;
import com.shsun.addata.support.vo.city.RegionVOContainer;
import com.shsun.addata.support.vo.contract.ContractCollector;
import com.shsun.addata.support.vo.segment.SegmentCollector;
import com.shsun.addata.support.vo.slot.SlotCategoryCollector;
import com.shsun.addata.support.vo.type.TypeCategoryCollector;
import com.shsun.addata.support.vo.videogroup.VideoGroupCollector;

/**
 * 
 * @author shsun
 * 
 */
public class ApplicationSharedObject {
	/**
	 * 
	 */
	private static ApplicationSharedObject instance = null;
	
	// ------------------------------------------------------------------------------------------------------------------------------------
	public final PropertyWrapper DEVICE = new PropertyWrapper(false, "DEVICE_TYPE", "DEVICE_TYPE", "设备");
	public final PropertyWrapper OS = new PropertyWrapper(false, "OS_TYPE", "OS_TYPE", "操作系统");
	public final PropertyWrapper CLIENT = new PropertyWrapper(false, "CLIENT_TYPE", "CLIENT_TYPE", "WEB/APP");
	public final PropertyWrapper PLATFORM = new PropertyWrapper(false, "PLATFORM_TYPE", "PLATFORM_TYPE", "平台");
	//
	public final PropertyWrapper SHOWTIME = new PropertyWrapper(false, "SHOWTIME", "SHOWTIME", "广告时长");
	//
	public final PropertyWrapper SITE = new PropertyWrapper(false, "SHOWTIME", "SHOWTIME", "站点");
	//
	public final PropertyWrapper CHANNEL = new PropertyWrapper(false, "CHANNEL_NAME", "CHANNEL_NAME", "一级分类");
	public final PropertyWrapper SUB_CHANNEL = new PropertyWrapper(false, "SUB_CHANNEL_NAME", "SUB_CHANNEL_NAME", "二级分类");
	//
	public final PropertyWrapper REGION = new PropertyWrapper(false, "REGION_NAME", "REGION_NAME", "地区");
	public final PropertyWrapper PROVINCE = new PropertyWrapper(false, "PROVINCE_NAME", "PROVINCE_NAME", "省份");
	public final PropertyWrapper CITY = new PropertyWrapper(false, "CITY_NAME", "CITY_NAME", "城市");
	//
	public final PropertyWrapper DATE = new PropertyWrapper(false, "DATE_TIME", "DATE_NAME", "日期");
	public final PropertyWrapper HOUR = new PropertyWrapper(false, "HOUR_ID", "HOUR_ID", "小时");
	//
	public final PropertyWrapper IMP = new PropertyWrapper(false, "IMP", "IMP", "曝光数");
	public final PropertyWrapper IMPOVER = new PropertyWrapper(false, "IMPOVER", "IMPOVER", "播放完成数");
	public final PropertyWrapper percentComplete = new PropertyWrapper(false, "percentComplete", "percentComplete", "播放完成率");
	public final PropertyWrapper CLICK = new PropertyWrapper(false, "CLICK", "CLICK", "点击数");
	public final PropertyWrapper clickRate = new PropertyWrapper(false, "clickRate", "clickRate", "点击率");
	//
	public final PropertyWrapper contractTypeLabel = new PropertyWrapper(false, "contractTypeLabel", "contractTypeLabel", "主量/补量");
	public final PropertyWrapper CONTRACT = new PropertyWrapper(false, "CONTRACT_ID", "CONTRACT_NAME", "合同名称");
	public final PropertyWrapper CAST = new PropertyWrapper(false, "CAST_ID", "CAST_NAME", "投放");
	public final PropertyWrapper CREATIVE = new PropertyWrapper(false, "CREATIVE_ID", "CREATIVE_NAME", "素材");
	public final PropertyWrapper SLOT = new PropertyWrapper(false, "SLOT_ID", "SLOT_NAME", "投放顺序");
	//
	public final PropertyWrapper RADI = new PropertyWrapper(false, "RADI", "RADI", "真实容量");

	// ------------------------------------------------------------------------------------------------------------------------------------

	private ApplicationSharedObject() {
	}

	public static ApplicationSharedObject getInstance() {
		if (instance == null) {
			instance = new ApplicationSharedObject();
		}
		return instance;
	}

	public void sendSQLExceptionMail(String content) {
		MailSenderInfo info = new MailSenderInfo();
		info.setMailServerHost("10.10.0.19");
		info.setMailServerPort("25");
		info.setValidate(true);
		info.setUserName("systeminformation");
		info.setPassword("123456");
		info.setFromAddress("systeminformation@shsun.com");
		info.setToAddresses(new String[] { "addata@shsun.com", "sunshanghai@shsun.com" });
		info.setSubject("AdData-SQL-Exception-Message");
		info.setContent(content);
		(new TextMailSender()).sendMail(info);
	}

	private ChannelVOCollector channelVOCollector;

	private CampaignVOCollector campaignVOCollector;
	// -------------------------------------------------------------------

	private SegmentCollector segmentCollector;

	// -------------------------------------------------------------------
	private SlotCategoryCollector slotCategoryCollector;
	private TypeCategoryCollector typeCategoryCollector;
	// -------------------------------------------------------------------

	private ContractCollector contractCollector;
	// -------------------------------------------------------------------
	private RegionVOContainer regionVOContainer;
	private GeoVOCollector geoVOCollector;
	
	// -------------------------------------------------------------------
	private VideoGroupCollector videoGroupCollector;
	
	public TreeNode geo = new TreeNode(Integer.MIN_VALUE, "geo_root");
	
	public GeoVOCollector getGeoVOCollector() {
		return geoVOCollector;
	}

	
	public void setGeoVOCollector( GeoVOCollector geoVOCollector ) {
		this.geoVOCollector = geoVOCollector;
	}

	// -------------------------------------------------------------------
	public RegionVOContainer getRegionVOContainer() {
		return regionVOContainer;
	}

	public void setRegionVOContainer(RegionVOContainer regionVOContainer) {
		this.regionVOContainer = regionVOContainer;
	}

	public ChannelVOCollector getChannelVOCollector() {
		return channelVOCollector;
	}

	public void setChannelVOCollector(ChannelVOCollector channelVOCollector) {
		this.channelVOCollector = channelVOCollector;
	}

	public CampaignVOCollector getCampaignVOCollector() {
		return campaignVOCollector;
	}

	public void setCampaignVOCollector(CampaignVOCollector campaignVOCollector) {
		this.campaignVOCollector = campaignVOCollector;
	}

	public SlotCategoryCollector getSlotCategoryCollector() {
		return slotCategoryCollector;
	}

	public void setSlotCategoryCollector(SlotCategoryCollector slotCategoryCollector) {
		this.slotCategoryCollector = slotCategoryCollector;
	}

	public TypeCategoryCollector getTypeCategoryCollector() {
		return typeCategoryCollector;
	}

	public void setTypeCategoryCollector(TypeCategoryCollector typeCategoryCollector) {
		this.typeCategoryCollector = typeCategoryCollector;
	}

	public ContractCollector getContractCollector() {
		return contractCollector;
	}

	public void setContractCollector(ContractCollector contractCollector) {
		this.contractCollector = contractCollector;
	}

	public SegmentCollector getSegmentCollector() {
		return segmentCollector;
	}

	public void setSegmentCollector(SegmentCollector segmentCollector) {
		this.segmentCollector = segmentCollector;
	}

	public VideoGroupCollector getVideoGroupCollector() {
		return videoGroupCollector;
	}

	public void setVideoGroupCollector(VideoGroupCollector videoGroupCollector) {
		this.videoGroupCollector = videoGroupCollector;
	}

}