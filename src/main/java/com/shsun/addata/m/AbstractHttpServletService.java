package com.shsun.addata.m;

import java.util.ArrayList;
import java.util.List;

import com.youdo.spring.DataSourceSwitcher;
import com.youdo.util.lang.StringUtils;
import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.support.vo.channel.ChannelVO;
import com.shsun.addata.vo.base.ApplicationSharedObject;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletResponseItem;
import com.shsun.addata.vo.base.IHttpServletService;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IRowResultSetItem;
import com.shsun.addata.vo.base.BasicSqlParameterSource;

/**
 * 
 * @author shsun
 * 
 */
public abstract class AbstractHttpServletService implements IHttpServletService {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AbstractHttpServletService.class);
	
	protected void updateSqlParameterSourceWithView(BasicSqlParameterSource source, AbstractHttpServletRequestParameter parameter) {
		source.SITE_ID = (parameter.site != ApplicationConstants.Site.FULL) ? parameter.site.getCode() : "";
		source.SLOT_ID = parameter.slotIds;// (2,3,9) or (2) or (2,3), ....
		source.level = parameter.timeSLP.has1stLevelParameter() ? ApplicationConstants.TableLevel.HOUR.getCode() : ApplicationConstants.TableLevel.DAY.getCode();
		//
		DataSourceSwitcher.Type type = ApplicationConstants.TableLevel.DAY.getCode().equals(source.level) ? DataSourceSwitcher.Type.MASTER : DataSourceSwitcher.Type.SLAVE;
		DataSourceSwitcher.setDataSourceType(type);
		//
		List<String> tmpProvinceIds = StringUtils.addPrefixAndSuffix(parameter.getCitySLP().getStandaloneIds(), "", "0000");
		String provinceIds = StringUtils.convert2String(tmpProvinceIds, "", "", ",");
		if (provinceIds.trim().length() > 0) {
			provinceIds = StringUtils.addPrefixAndSuffix(provinceIds, "(", ")");
		}
		String cityIds = StringUtils.convert2String(parameter.getCitySLP().getAllLeafs(), "", "", ",");
		if (cityIds.trim().length() > 0) {
			cityIds = StringUtils.addPrefixAndSuffix(cityIds, "(", ")");
		}
		source.PROVINCE_ID = provinceIds.trim().length() > 0 ? provinceIds : "";
		source.CITY_ID = cityIds.trim().length() > 0 ? cityIds : "";
		//		
		List<String> ids = parameter.getChannelSLP().getAllIds();
		List<String> agentIds = new ArrayList<String>();
		for (int i = 0; i < ids.size(); i++) {
			Integer channelAgentId = Integer.parseInt(ids.get(i));
			ChannelVO channelVO = ApplicationSharedObject.getInstance().getChannelVOCollector().getChannelVOByChannelAgentId(channelAgentId);
			//
			agentIds.add(channelVO.getWrappedObj().getCHANNEL_AGENT_ID().toString());
		}
		String agentChannelIds = StringUtils.convert2String(agentIds, "", "", ",");
		if (agentChannelIds.trim().length() > 0) {
			agentChannelIds = StringUtils.addPrefixAndSuffix(agentChannelIds, "(", ")");
		}
		String subchannelIds = StringUtils.convert2String(parameter.getChannelSLP().getAllLeafs(), "", "", ",");
		if (subchannelIds.trim().length() > 0) {
			subchannelIds = StringUtils.addPrefixAndSuffix(subchannelIds, "(", ")");
		}
		source.CHANNEL_AGENT_ID = agentChannelIds.trim().length() > 0 ? agentChannelIds : "";
		source.SUB_CHANNEL_AGENT_ID = subchannelIds.trim().length() > 0 ? subchannelIds : "";
		//
		//
		source.START_DATE = parameter.startDate;
		source.END_DATE = parameter.endDate;
		//
		//
		String time_ids = StringUtils.convert2String(parameter.timeSLP.getStandaloneIds(), "", "", ",");
		if (time_ids.trim().length() > 0) {
			time_ids = StringUtils.addPrefixAndSuffix(time_ids, "(", ")");
		}
		source.HOUR_ID = time_ids.trim().length() > 0 ? time_ids : "";
		
		// 
		source.MOBILE_SEGMENT_ID = parameter.segment;
		source.VIDEO_LENGTH_ID = parameter.videoLengthType;
		if (!StringUtils.isValidValue(source.VIDEO_LENGTH_ID)) {
			source.VIDEO_LENGTH_ID = parameter.video_length_id;
		}
		
		// group by
		if (parameter.getGroupByVO().getDate().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("DATE_TIME");
		}
		if (parameter.getGroupByVO().getProvince().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("PROVINCE_ID");
		}
		if (parameter.getGroupByVO().getCity().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("CITY_ID");
		}
		if (parameter.getGroupByVO().getChannel().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("CHANNEL_AGENT_ID");
		}
		if (parameter.getGroupByVO().getSubchannel().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("SUB_CHANNEL_AGENT_ID");
		}
		if (parameter.getGroupByVO().getHour().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("HOUR_ID");
		}
		if (parameter.getGroupByVO().getSite().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("SITE_ID");
		}
		if (parameter.getGroupByVO().getVideolength_type().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("VIDEO_LENGTH_ID");
		}
		//
		if (parameter.getGroupByVO().getType().selected) {
			source.SLOT_GROUP_BY_PROPERTIES.addProperty("TYPE_ID");
		}
		//
		if(parameter.getGroupByVO().getMobile_platform_type().selected){
			source.MOBILE_SEGMENT_GROUP_BY_PROPERTIES.addProperty("PLATFORM_TYPE");
		}
		if(parameter.getGroupByVO().getMobile_client_type().selected){
			source.MOBILE_SEGMENT_GROUP_BY_PROPERTIES.addProperty("CLIENT_TYPE");
		}
		
	}
	
	protected void updateSqlParameterSourceWithPageing(BasicSqlParameterSource source, AbstractHttpServletRequestParameter parameter) {
		source.START_ROW = "" + (parameter.isExportExcelMode ? parameter.startRow : parameter.getPager().getStartRow());
		source.END_ROW = "" + (parameter.isExportExcelMode ? parameter.endRow : (parameter.getPager().getStartRow() + parameter.getPager().getPageSize()));
	}
	
	@SuppressWarnings({ "rawtypes" })
	protected void translate(IHttpServletRequestParameter parameter, List rowItems) {
		List<IRowResultSetItem> results = new ArrayList<IRowResultSetItem>();
		for (int i = 0; i < rowItems.size(); i++) {
			IHttpServletResponseItem responseItem = null;
			try {
				responseItem = this.doTranslate(parameter, (IRowResultSetItem) rowItems.get(i));
			} catch (Exception e) {
				// TODO
			} finally {
				results.add(responseItem);
			}
		}
		parameter.getPager().setResult(results);
	}
	
	/**
	 * 
	 * @param parameter
	 * @param item
	 */
	protected abstract IHttpServletResponseItem doTranslate(IHttpServletRequestParameter parameter, IRowResultSetItem item);
}
