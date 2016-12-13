package com.shsun.addata.support;

import java.util.HashMap;
import java.util.Map;

import com.shsun.addata.vo.VideoGroupInventoryHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

public class CEMapper {

	private static CEMapper instance = null;

	private Map<String, String> map;

	private CEMapper(IHttpServletRequestParameter parameter) {
		this.map = new HashMap<String, String>();
		//
		this.map.put("DEVICE_TYPE", "设备");
		this.map.put("OS_TYPE", "系统");
		this.map.put("CLIENT_TYPE", "WEB/APP");
		this.map.put("PLATFORM_TYPE", "平台");
		//
		this.map.put("videoLengthTypeLabel", "视频时长类型");
		this.map.put("MOBILE_SEGMENT_ID", "平台类型");
		//
		this.map.put("SITE_NAME", "站点");
		//
		this.map.put("CHANNEL_NAME", "一级分类");
		this.map.put("SUB_CHANNEL_NAME", "二级分类");
		//
		this.map.put("REGION_NAME", "地区");
		this.map.put("PROVINCE_NAME", "省份");
		this.map.put("CITY_NAME", "城市");
		//
		this.map.put("DATE_NAME", "日期");
		this.map.put("HOUR_ID", "小时");
		//
		this.map.put("IMP", "曝光数");
		this.map.put("IMPOVER", "播放完成数");
		this.map.put("percentComplete", "播放完成率");
		this.map.put("CLICK", "点击数");
		this.map.put("clickRate", "点击率");
		//
		this.map.put("contractTypeLabel", "主量/补量");
		this.map.put("CONTRACT_NAME", "合同名称");
		this.map.put("CAST_NAME", "投放");
		this.map.put("CREATIVE_ID", "素材");
		this.map.put("CREATIVE_NAME", "素材");
		this.map.put("SLOT_NAME", "投放顺序");
		if (parameter instanceof VideoGroupInventoryHttpServletRequestParameter) {
			this.map.put("SLOT_NAME", "广告类型");
		}
		this.map.put("TYPE_NAME", "广告类型");
		//
		this.map.put("VIDEO_GROUP_ID", "视频组(节目)ID");
		this.map.put("VIDEO_GROUP_NAME", "视频组(节目)名称");
		//
		this.map.put("RADI", "真实容量");
	}

	public static CEMapper getInstance(IHttpServletRequestParameter parameter) {
		if (instance == null) {
			instance = new CEMapper(parameter);
		}
		return instance;
	}

	public String getChineseName(String key) {
		return this.map.get(key) + "";
	}
}
