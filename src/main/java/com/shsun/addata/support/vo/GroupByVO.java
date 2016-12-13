package com.shsun.addata.support.vo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author shsun
 * 
 */
public class GroupByVO {
	// TODO

	// inventory
	private FieldTitlePairVO date = new FieldTitlePairVO(false, "DATE_TIME", "DATE_NAME");
	private FieldTitlePairVO province = new FieldTitlePairVO(false, "PROVINCE_NAME", "PROVINCE_NAME");
	private FieldTitlePairVO city = new FieldTitlePairVO(false, "CITY_NAME", "CITY_NAME");
	private FieldTitlePairVO channel = new FieldTitlePairVO(false, "CHANNEL_NAME", "CHANNEL_NAME");
	private FieldTitlePairVO subchannel = new FieldTitlePairVO(false, "SUB_CHANNEL_NAME", "SUB_CHANNEL_NAME");
	private FieldTitlePairVO hour = new FieldTitlePairVO(false, "HOUR_ID", "HOUR_ID");
	// ad-tracking
	private FieldTitlePairVO cast = new FieldTitlePairVO(false, "CAST_ID", "CAST_NAME");
	private FieldTitlePairVO idea = new FieldTitlePairVO(false, "CREATIVE_ID", "CREATIVE_NAME");
	private FieldTitlePairVO order = new FieldTitlePairVO(false, "CONTRACT_ID", "CONTRACT_NAME");
	private FieldTitlePairVO slot = new FieldTitlePairVO(false, "SLOT_ID", "SLOT_NAME");
	private FieldTitlePairVO type = new FieldTitlePairVO(false, "TYPE_ID", "TYPE_NAME");
	private FieldTitlePairVO isAmount = new FieldTitlePairVO(false, "IS_AMOUNT", "contractTypeLabel");
	//
	private FieldTitlePairVO site = new FieldTitlePairVO(false, "SITE_ID", "SITE_NAME");
	//
	private FieldTitlePairVO videolength_type = new FieldTitlePairVO(false, "VIDEO_LENGTH_ID", "videoLengthTypeLabel");
	private FieldTitlePairVO mobile_platform_type = new FieldTitlePairVO(false, "PLATFORM_TYPE", "PLATFORM_TYPE");
	private FieldTitlePairVO mobile_client_type = new FieldTitlePairVO(false, "CLIENT_TYPE", "CLIENT_TYPE");
	
	private FieldTitlePairVO videogpid = new FieldTitlePairVO(false, "VIDEO_GROUP_ID", "VIDEO_GROUP_ID");
	private FieldTitlePairVO videogpname = new FieldTitlePairVO(false, "VIDEO_GROUP_NAME", "VIDEO_GROUP_NAME");
	
	

	/**
	 * @param request
	 */
	public void parse(HttpServletRequest request) {
		// inventory
		this.date.selected = "1".equals(request.getParameter("group_date"));
		this.province.selected = "1".equals(request.getParameter("group_province"));
		this.city.selected = "1".equals(request.getParameter("group_city"));
		this.channel.selected = "1".equals(request.getParameter("group_channel"));
		this.subchannel.selected = "1".equals(request.getParameter("group_subchannel"));
		this.hour.selected = "1".equals(request.getParameter("group_hour"));
		// ad-tracking
		this.cast.selected = "1".equals(request.getParameter("group_cast"));
		this.idea.selected = "1".equals(request.getParameter("group_idea"));
		this.order.selected = "1".equals(request.getParameter("group_order"));
		this.slot.selected = "1".equals(request.getParameter("group_slot_id"));
		this.type.selected = "1".equals(request.getParameter("group_type_id"));
		this.isAmount.selected = "1".equals(request.getParameter("group_isAmount"));
		//
		this.site.selected = "1".equals(request.getParameter("group_site"));
		//
		this.videolength_type.selected = "1".equals(request.getParameter("group_videolength_type"));
		this.mobile_platform_type.selected = "1".equals(request.getParameter("group_platform"));
		this.mobile_client_type.selected = "1".equals(request.getParameter("group_client"));
		
		this.videogpid.selected = "1".equals(request.getParameter("group_video_group_id"));
		this.videogpname.selected = "1".equals(request.getParameter("group_video_group_name"));
		//
		//
		//
	}

	public boolean hasSelectedGroup() {
		return this.getSelectedGroupNum() > 0;
	}

	public int getSelectedGroupNum() {
		return this.getSelectedGroup().size();
	}

	// TODO
	public List<FieldTitlePairVO> getSelectedGroup() {
		List<FieldTitlePairVO> resultList = new ArrayList<FieldTitlePairVO>();
		//
		if (this.date.selected) {
			resultList.add(this.date);
		}
		if (this.province.selected) {
			resultList.add(this.province);
		}
		if (this.city.selected) {
			resultList.add(this.city);
		}
		if (this.channel.selected) {
			resultList.add(this.channel);
		}
		if (this.subchannel.selected) {
			resultList.add(this.subchannel);
		}
		if (this.hour.selected) {
			resultList.add(this.hour);
		}
		//
		if (this.cast.selected) {
			resultList.add(this.cast);
		}
		if (this.idea.selected) {
			resultList.add(this.idea);
		}
		if (this.order.selected) {
			resultList.add(this.order);
		}
		//
		if (this.site.selected) {
			resultList.add(this.site);
		}
		//
		if (this.slot.selected) {
			resultList.add(this.slot);
		}
		if (this.type.selected) {
			resultList.add(this.type);
		}
		if (this.isAmount.selected) {
			resultList.add(this.isAmount);
		}
		if (this.videolength_type.selected) {
			resultList.add(this.videolength_type);
		}
		if (this.mobile_platform_type.selected) {
			resultList.add(this.mobile_platform_type);
		}
		if (this.mobile_client_type.selected) {
			resultList.add(this.mobile_client_type);
		}
		if (this.videogpid.selected) {
			resultList.add(this.videogpid);
		}
		if (this.videogpname.selected) {
			resultList.add(this.videogpname);
		}
		/*
		 * PropertyDescriptor[] list =
		 * YouDoReflectorUtil.getPropertyDescriptorsWithoutClass(this); for (int
		 * i = 0; i < list.length; i++) { try { LabelAlternativeVO vo =
		 * (LabelAlternativeVO) list[i].getReadMethod().invoke(this); if
		 * (list[i].getPropertyType() == LabelAlternativeVO.class &&
		 * vo.selected) { resultList.add(vo); } } catch
		 * (IllegalArgumentException e) {
		 * 
		 * e.printStackTrace(); } catch (IllegalAccessException e) {
		 * 
		 * e.printStackTrace(); } catch (InvocationTargetException e) {
		 * 
		 * e.printStackTrace(); } }
		 */
		return resultList;
	}

	public FieldTitlePairVO getDate() {
		return date;
	}

	public void setDate(FieldTitlePairVO date) {
		this.date = date;
	}

	public FieldTitlePairVO getHour() {
		return hour;
	}

	public void setHour(FieldTitlePairVO hour) {
		this.hour = hour;
	}

	public FieldTitlePairVO getProvince() {
		return province;
	}

	public void setProvince(FieldTitlePairVO province) {
		this.province = province;
	}

	public FieldTitlePairVO getCity() {
		return city;
	}

	public void setCity(FieldTitlePairVO city) {
		this.city = city;
	}

	public FieldTitlePairVO getCast() {
		return cast;
	}

	public void setCast(FieldTitlePairVO cast) {
		this.cast = cast;
	}

	public FieldTitlePairVO getIdea() {
		return idea;
	}

	public void setIdea(FieldTitlePairVO idea) {
		this.idea = idea;
	}

	public FieldTitlePairVO getChannel() {
		return channel;
	}

	public void setChannel(FieldTitlePairVO channel) {
		this.channel = channel;
	}

	public FieldTitlePairVO getSubchannel() {
		return subchannel;
	}

	public void setSubchannel(FieldTitlePairVO subchannel) {
		this.subchannel = subchannel;
	}

	public FieldTitlePairVO getSite() {
		return site;
	}

	public void setSite(FieldTitlePairVO site) {
		this.site = site;
	}

	public FieldTitlePairVO getOrder() {
		return order;
	}

	public void setOrder(FieldTitlePairVO order) {
		this.order = order;
	}

	public FieldTitlePairVO getSlot() {
		return slot;
	}

	public void setSlot(FieldTitlePairVO slot) {
		this.slot = slot;
	}

	public FieldTitlePairVO getType() {
		return type;
	}

	public void setType(FieldTitlePairVO type) {
		this.type = type;
	}

	public FieldTitlePairVO getIsAmount() {
		return isAmount;
	}

	public void setIsAmount(FieldTitlePairVO isAmount) {
		this.isAmount = isAmount;
	}

	public FieldTitlePairVO getVideolength_type() {
		return videolength_type;
	}

	public void setVideolength_type(FieldTitlePairVO isLongVideo) {
		this.videolength_type = isLongVideo;
	}

	public FieldTitlePairVO getMobile_platform_type() {
		return mobile_platform_type;
	}

	public void setMobile_platform_type(FieldTitlePairVO mobile_platform_type) {
		this.mobile_platform_type = mobile_platform_type;
	}

	public FieldTitlePairVO getMobile_client_type() {
		return mobile_client_type;
	}

	public void setMobile_client_type(FieldTitlePairVO mobile_client_type) {
		this.mobile_client_type = mobile_client_type;
	}

	public FieldTitlePairVO getVideogpid() {
		return videogpid;
	}

	public void setVideogpid(FieldTitlePairVO videogpid) {
		this.videogpid = videogpid;
	}

	public FieldTitlePairVO getVideogpname() {
		return videogpname;
	}

	public void setVideogpname(FieldTitlePairVO videogpname) {
		this.videogpname = videogpname;
	}

}
