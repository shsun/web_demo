package com.shsun.addata.vo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shsun.addata.support.PropertyWrapper;
import com.youdo.m.BaseKVObject;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.ApplicationSharedObject;

/**
 * 
 * @author shsun
 * 
 */
public class VideoGroupInventoryHttpServletRequestParameter extends AbstractHttpServletRequestParameter {

	//
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VideoGroupInventoryHttpServletRequestParameter.class);
	//
	public boolean is_video_group = false;
	public String video_group_id = null;
	public String video_group_name = null;
	public boolean slot_preroll_selected = false;
	public boolean slot_pause_selected = false;
	public boolean slot_postroll_selected = false;
	public boolean slot_midroll_selected = false;

	//
	// public String group_video_group_id;

	public VideoGroupInventoryHttpServletRequestParameter(
			HttpServletRequest request, HttpServletResponse response) {
		super(request, response);
		// 
		this.is_video_group = "1".equals(request.getParameter("is_video_group"));
		this.video_group_id = request.getParameter("video_group_id");
		this.video_group_name = request.getParameter("video_group_name");
		// tidy
		if (this.video_group_id != null) {
			this.video_group_id = this.video_group_id.trim();
		}
		if (this.video_group_name != null) {
			this.video_group_name = this.video_group_name.trim();
		}
		/*
		if (request.getMethod().equalsIgnoreCase("GET")) {
			try {
				this.video_group_name = java.net.URLDecoder.decode(this.video_group_name, "UTF-8");
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				this.video_group_name = null;
			}
		}
		*/
		
		this.slot_preroll_selected = "1".equals(request.getParameter("slot_preroll_selected"));
		this.slot_pause_selected = "1".equals(request.getParameter("slot_pause_selected"));
		this.slot_postroll_selected = "1".equals(request.getParameter("slot_postroll_selected"));
		this.slot_midroll_selected = "1".equals(request.getParameter("slot_midroll_selected"));
		
		ArrayList<Integer> slots = new ArrayList();
		if (this.slot_preroll_selected) {
			slots.add(2);
		}
		if (this.slot_pause_selected) {
			slots.add(4);
		}
		if (this.slot_postroll_selected) {
			slots.add(5);
		}
		if (this.slot_midroll_selected) {
			slots.add(40);
		}
		if (slots.size() > 0) {
			this.slotIds = slots.toString().replace("[", "(").replace("]", ")");
		}
		// Overwrite
		try {
			this.startRow = Integer.parseInt(request.getParameter("start"));
			this.endRow = this.startRow + Integer.parseInt(request.getParameter("limit"));
			this.pageIndex = this.startRow / 60 + 1;
		} catch (Exception E) {
			// TODO
		}
		
	}

	@Override
	public void buildDisplayPriority() {
		String[] englishPriorityArray = null;
		if (super.isMobile()) {
			englishPriorityArray = new String[] { "DATE_NAME", "videoLengthTypeLabel", "HOUR_ID", "SITE_NAME", "PLATFORM_TYPE", "CLIENT_TYPE", "TYPE_NAME", "PROVINCE_NAME", "CITY_NAME",
					"CHANNEL_NAME",
					/* "SUB_CHANNEL_NAME", */"RADI"/* , "SLOT_NAME" */};
		} else {
			
			englishPriorityArray = new String[] { "DATE_NAME", "VIDEO_GROUP_ID", 
					"VIDEO_GROUP_NAME", "SITE_NAME", 
					"SLOT_NAME", "videoLengthTypeLabel", "RADI"};
		}
		this.setEnglishPriorityArray(englishPriorityArray);

		super.generateDisplayedList();
	}

	@Override
	protected void updateDisplayedListWithOptionalProperties( List< String > list ) {
		// TODO Auto-generated method stub
		list.add("DATE_NAME");
		
		list.add("videoLengthTypeLabel");
		
		
		list.add("SITE_NAME");		
		list.add("SLOT_NAME");
		list.add("VIDEO_GROUP_ID");
		list.add("VIDEO_GROUP_NAME");
	}

	@Override
	protected void updateDisplayedListWithRequiredProperties( List< String > list ) {
		// TODO Auto-generated method stub
		list.add("RADI");
	}

	@Override
	protected void updateTitleListWithOptionalProperties( List< PropertyWrapper > list ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateTitleListWithRequiredProperties( List< PropertyWrapper > list ) {
		// TODO Auto-generated method stub

	}

	@Override
	protected BaseKVObject doItemProcess( String name, String value ) {
		// TODO Auto-generated method stub
		return null;
	}

}
