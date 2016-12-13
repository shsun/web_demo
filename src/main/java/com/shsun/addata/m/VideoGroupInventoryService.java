package com.shsun.addata.m;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shsun.addata.vo.VideoGroupInventoryHttpServletRequestParameter;
import com.shsun.addata.vo.VideoGroupInventoryRowItem;
import com.shsun.addata.vo.VideoGroupInventoryRowItemMapper;
import com.shsun.addata.vo.VideoGroupInventoryRowItemProcessor;
import com.shsun.addata.vo.VideoGroupInventoryRowItemWrapper;
import com.shsun.addata.vo.VideoGroupInventorySqlParameterSource;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.BasicSqlParameterSource;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletResponseItem;
import com.shsun.addata.vo.base.IRowItemWrapper;
import com.shsun.addata.vo.base.IRowResultSetItem;
import com.shsun.addata.vo.base.VideoGroupInventoryTableSelectionStrategy;

/**
 * 
 * @author shsun
 * 
 */
public class VideoGroupInventoryService extends AbstractHttpServletService {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VideoGroupInventoryService.class);

	private static final int ITEM_NUM = 60;

	@Autowired
	private VideoGroupInventoryRowItemMapper videoGroupInventoryRowItemMapper;

	public void service(IHttpServletRequestParameter p) {
		long startTime;
		//
		
		VideoGroupInventoryHttpServletRequestParameter parameter = (VideoGroupInventoryHttpServletRequestParameter) p;

		//
		VideoGroupInventorySqlParameterSource source = new VideoGroupInventorySqlParameterSource(p);
		
		
		(new VideoGroupInventoryTableSelectionStrategy(parameter, source)).select();
		
		//
		this.updateSqlParameterSourceWithView(source, parameter);
		
		
		//
		if (parameter.getGroupByVO().getSlot().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("SLOT_ID");
		}
		
		
		
		source.inlineProperties();
		
		//
		//(new VideoGroupInventoryTableSelectionStrategy(parameter, source)).select();

		parameter.buildDisplayPriority();

		// init pager.
		startTime = (new Date()).getTime();

		int totalRows = 0;

		if (parameter.isMobile()) {
			totalRows = parameter.getGroupByVO().hasSelectedGroup() ? videoGroupInventoryRowItemMapper.mgcountBy(source)
					: videoGroupInventoryRowItemMapper.mcountBy(source);
		} else {
			totalRows = parameter.getGroupByVO().hasSelectedGroup() ? videoGroupInventoryRowItemMapper.gcountBy(source)
					: videoGroupInventoryRowItemMapper.countBy(source);
		}

		parameter.sqlList.add(source.getSQL());
		parameter.setTimecost(parameter.getTimecost() + (((new Date()).getTime() - startTime) / 1000));
		parameter.initPager(totalRows, ITEM_NUM);
		super.updateSqlParameterSourceWithPageing(source, parameter);

		startTime = (new Date()).getTime();
		List<VideoGroupInventoryRowItem> list;
		if (parameter.isMobile()) {
			list = parameter.getGroupByVO().hasSelectedGroup() ? videoGroupInventoryRowItemMapper.mgretrievePage(source)
					: videoGroupInventoryRowItemMapper.mretrievePage(source);
		} else {
			list = parameter.getGroupByVO().hasSelectedGroup() ? videoGroupInventoryRowItemMapper.gretrievePage(source)
					: videoGroupInventoryRowItemMapper.retrievePage(source);
		}

		parameter.sqlList.add(source.getSQL());
		parameter.setTimecost("" + (Integer.parseInt(parameter.getTimecost()) + (((new Date()).getTime() - startTime) / 1000)));
		//
		super.translate(parameter, list);
	}

	@Override
	protected IHttpServletResponseItem doTranslate(IHttpServletRequestParameter parameter, IRowResultSetItem item) {
		IRowItemWrapper wrapper = new VideoGroupInventoryRowItemWrapper(parameter, item);
		return (new VideoGroupInventoryRowItemProcessor()).process((VideoGroupInventoryRowItemWrapper) wrapper);
	}
	
	@Override
	protected void updateSqlParameterSourceWithView(BasicSqlParameterSource source, AbstractHttpServletRequestParameter parameter) {
		super.updateSqlParameterSourceWithView(source, parameter);
		// VideoGroupInventorySqlParameterSource s =
		// (VideoGroupInventorySqlParameterSource)source;
		if (parameter.getGroupByVO().getVideogpid().selected) {
			((VideoGroupInventorySqlParameterSource) source).PROGRAMME_GROUP_BY_PROPERTIES
					.addProperty(((VideoGroupInventorySqlParameterSource) source).P_KEY_NAME);
		}
		if (parameter.getGroupByVO().getVideogpname().selected) {
			((VideoGroupInventorySqlParameterSource) source).PROGRAMME_GROUP_BY_PROPERTIES
					.addProperty(((VideoGroupInventorySqlParameterSource) source).NAME);
		}
		if (((VideoGroupInventoryHttpServletRequestParameter) parameter).is_video_group) {
			((VideoGroupInventorySqlParameterSource) source).VIDEO_GROUP_ID = ((VideoGroupInventoryHttpServletRequestParameter) parameter).video_group_id;
			((VideoGroupInventorySqlParameterSource) source).VIDEO_GROUP_NAME = ((VideoGroupInventoryHttpServletRequestParameter) parameter).video_group_name;
		} else {
			((VideoGroupInventorySqlParameterSource) source).PROGRAMME_AGENT_ID = ((VideoGroupInventoryHttpServletRequestParameter) parameter).video_group_id;
			((VideoGroupInventorySqlParameterSource) source).PROGRAMME_NAME = ((VideoGroupInventoryHttpServletRequestParameter) parameter).video_group_name;
		}
	}

}
