package com.shsun.addata.m;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shsun.addata.vo.ImpressionHttpServletRequestParameter;
import com.shsun.addata.vo.ImpressionRowItem;
import com.shsun.addata.vo.ImpressionRowItemMapper;
import com.shsun.addata.vo.ImpressionRowItemProcessor;
import com.shsun.addata.vo.ImpressionRowItemWrapper;
import com.shsun.addata.vo.ImpressionSqlParameterSource;
import com.youdo.util.lang.StringUtils;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletResponseItem;
import com.shsun.addata.vo.base.IRowItemWrapper;
import com.shsun.addata.vo.base.IRowResultSetItem;
import com.shsun.addata.vo.base.ImpressionTableSelectionStrategy;

/**
 * 
 * @author shsun
 * 
 */
public class ImpressionService extends AbstractHttpServletService {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ImpressionService.class);

	private static final int ITEM_NUM = 60;

	@Autowired
	private ImpressionRowItemMapper impressionRowItemMapper;

	public void service(IHttpServletRequestParameter p) {
		long startTime;
		//
		ImpressionHttpServletRequestParameter parameter = (ImpressionHttpServletRequestParameter) p;
		ImpressionSqlParameterSource source = new ImpressionSqlParameterSource(p);

		super.updateSqlParameterSourceWithView(source, parameter);
		//		
		if (parameter.includeSupplement) {
			source.AMOUNT_SOUR_ID = StringUtils.isValidValue(parameter.orderId) ? parameter.orderId : null;
			source.CONTRACT_ID = null;		
		} else {
			source.AMOUNT_SOUR_ID = null;
			source.CONTRACT_ID = StringUtils.isValidValue(parameter.orderId) ? parameter.orderId : null;		
		}
		source.CONTRACT_NAME = StringUtils.isValidValue(parameter.orderName) ? parameter.orderName : null;
		
		//
		if (parameter.getGroupByVO().getSlot().selected) {
			source.DRIVER_GROUP_BY_PROPERTIES.addProperty("SLOT_ID");
		}
		//
		if (parameter.getGroupByVO().getCast().selected) {
			source.CREATIVE_GROUP_BY_PROPERTIES.addProperty("CAST_ID");
			source.CREATIVE_GROUP_BY_PROPERTIES.addProperty("CAST_NAME");
		}
		if (parameter.getGroupByVO().getIdea().selected) {
			source.CREATIVE_GROUP_BY_PROPERTIES.addProperty("CREATIVE_ID");
			source.CREATIVE_GROUP_BY_PROPERTIES.addProperty("CREATIVE_NAME");
		}
		if (parameter.getGroupByVO().getOrder().selected) {
			source.CREATIVE_GROUP_BY_PROPERTIES.addProperty("CONTRACT_ID");
			source.CREATIVE_GROUP_BY_PROPERTIES.addProperty("CONTRACT_NAME");
		}
		//
		if (parameter.getGroupByVO().getIsAmount().selected) {
			source.CONTRACT_GROUP_BY_PROPERTIES.addProperty("IS_AMOUNT");
		}
		
		source.inlineProperties();
		
		//
		(new ImpressionTableSelectionStrategy(parameter, source)).select();
		
		//
		parameter.buildDisplayPriority();
		
		//
		// init pager.
		startTime = (new Date()).getTime();
		int totalRows;
		if (parameter.isMobile()) {
			totalRows = parameter.getGroupByVO().hasSelectedGroup() ? impressionRowItemMapper.mgcountBy(source) : impressionRowItemMapper.mcountBy(source);
		} else {
			totalRows = parameter.getGroupByVO().hasSelectedGroup() ? impressionRowItemMapper.gcountBy(source) : impressionRowItemMapper.countBy(source);
		}
		parameter.sqlList.add(source.getSQL());		
		parameter.setTimecost(parameter.getTimecost() + "totalRows=" + (((new Date()).getTime() - startTime) / 1000) + ", ");
		parameter.initPager(totalRows, ITEM_NUM);
		super.updateSqlParameterSourceWithPageing(source, parameter);
		logger.info("totalRows-->" + totalRows + ", currentPage=" + parameter.getPager().getThisPageNumber() + ", totalPage="
				+ parameter.getPager().getLastPageNumber());
		startTime = (new Date()).getTime();
		List<ImpressionRowItem> list;
		if (parameter.isMobile()) {
			list = parameter.getGroupByVO().hasSelectedGroup() ? impressionRowItemMapper.mgretrievePage(source) : impressionRowItemMapper.mretrievePage(source);
		} else {
			list = parameter.getGroupByVO().hasSelectedGroup() ? impressionRowItemMapper.gretrievePage(source) : impressionRowItemMapper.retrievePage(source);
		}
		parameter.sqlList.add(source.getSQL());
		parameter.setTimecost(parameter.getTimecost() + "data=" + (((new Date()).getTime() - startTime) / 1000));
		logger.info("list.size=" + list.size());
		//
		super.translate(parameter, list);
	}

	@Override
	protected IHttpServletResponseItem doTranslate( IHttpServletRequestParameter parameter, IRowResultSetItem item ) {
		IRowItemWrapper wrapper = new ImpressionRowItemWrapper(parameter, (ImpressionRowItem) item);
		return (new ImpressionRowItemProcessor()).process((ImpressionRowItemWrapper) wrapper);
	}
}
