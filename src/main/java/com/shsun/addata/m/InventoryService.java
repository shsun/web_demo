package com.shsun.addata.m;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.vo.InventoryHttpServletRequestParameter;
import com.shsun.addata.vo.InventoryRowItem;
import com.shsun.addata.vo.InventoryRowItemMapper;
import com.shsun.addata.vo.InventoryRowItemProcessor;
import com.shsun.addata.vo.InventoryRowItemWrapper;
import com.shsun.addata.vo.InventorySqlParameterSource;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletResponseItem;
import com.shsun.addata.vo.base.IRowItemWrapper;
import com.shsun.addata.vo.base.IRowResultSetItem;
import com.shsun.addata.vo.base.ITableSelectionStrategy;
import com.shsun.addata.vo.base.InventoryTableSelectionStrategy;

/**
 * 
 * @author shsun
 * 
 */
public class InventoryService extends AbstractHttpServletService {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(InventoryService.class);

	private static final int ITEM_NUM = 60;

	@Autowired
	private InventoryRowItemMapper inventoryRowItemMapper;

	/**
	 * 
	 * @param parameter
	 */
	public void service(IHttpServletRequestParameter p) {
		long startTime;
		//
		InventoryHttpServletRequestParameter parameter = (InventoryHttpServletRequestParameter) p;
		InventorySqlParameterSource source = new InventorySqlParameterSource(p);
		//
		super.updateSqlParameterSourceWithView(source, parameter);

		source.inlineProperties();
		
		//
		(new InventoryTableSelectionStrategy(parameter, source)).select();
		
		parameter.buildDisplayPriority();
		
		// init pager.
		startTime = (new Date()).getTime();
		
		int totalRows;
		if (parameter.isMobile()) {
			totalRows = parameter.getGroupByVO().hasSelectedGroup() ? inventoryRowItemMapper.mgcountBy(source) : inventoryRowItemMapper.mcountBy(source);
		} else {
			totalRows = parameter.getGroupByVO().hasSelectedGroup() ? inventoryRowItemMapper.gcountBy(source) : inventoryRowItemMapper.countBy(source);
		}
		parameter.sqlList.add(source.getSQL());
		parameter.setTimecost(parameter.getTimecost() + "totalRows=" + (((new Date()).getTime() - startTime) / 1000) + ", ");
		parameter.initPager(totalRows, ITEM_NUM);
		super.updateSqlParameterSourceWithPageing(source, parameter);
		
		startTime = (new Date()).getTime();
		List< InventoryRowItem > list;
		if (parameter.isMobile()) {
			list = parameter.getGroupByVO().hasSelectedGroup() ? inventoryRowItemMapper.mgretrievePage(source) : inventoryRowItemMapper.mretrievePage(source);
		} else {
			list = parameter.getGroupByVO().hasSelectedGroup() ? inventoryRowItemMapper.gretrievePage(source) : inventoryRowItemMapper.retrievePage(source);
		}
		parameter.sqlList.add(source.getSQL());
		parameter.setTimecost(parameter.getTimecost() + "data=" + (((new Date()).getTime() - startTime) / 1000));
		//
		super.translate(parameter, list);
	}
	
	@Override
	protected IHttpServletResponseItem doTranslate( IHttpServletRequestParameter parameter, IRowResultSetItem item ) {
		IRowItemWrapper wrapper = new InventoryRowItemWrapper(parameter, item);
		return (new InventoryRowItemProcessor()).process((InventoryRowItemWrapper) wrapper);
	}
	
	public InventoryRowItemMapper getInventoryRowItemMapper() {
		return inventoryRowItemMapper;
	}
}
