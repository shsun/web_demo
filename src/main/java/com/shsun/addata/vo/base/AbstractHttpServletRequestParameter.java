package com.shsun.addata.vo.base;

import java.beans.PropertyDescriptor;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.shsun.addata.ApplicationConstants;
import com.shsun.addata.ApplicationConstants.ReportType;
import com.shsun.addata.support.CEMapper;
import com.shsun.addata.support.PropertyWrapper;
import com.shsun.addata.utils.io.ExcelExporter;
import com.youdo.m.BaseKVObject;
import com.youdo.net.ECMAScriptCoder;
import com.youdo.util.lang.StringUtils;
import com.youdo.util.lang.TreeNode;
import com.shsun.addata.support.vo.ErrorDescriptor;
import com.shsun.addata.support.vo.GroupByVO;
import com.shsun.addata.support.vo.FieldTitlePairVO;

/**
 * 
 * @author shsun
 * 
 */
public abstract class AbstractHttpServletRequestParameter implements IHttpServletRequestParameter {

	/**
	 * 
	 */
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AbstractHttpServletRequestParameter.class);
	/**
	 * true indicate export excel, otherwise show data in data-grid of web.
	 */
	public boolean isExportExcelMode = false;
	public int startRow;
	public int endRow;
	// -----------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 */
	private String timecost = "";

	/**
	 * 
	 */
	public ApplicationConstants.Site site;
	//
	// -----------------------------------------------------------------------------------------------------------------------
	/**
	 * province -- city
	 */
	private SecondLevelParameter citySLP;
	/**
	 * channel -- sub-channel
	 */
	private SecondLevelParameter channelSLP;

	/**
	 * time
	 */
	public SecondLevelParameter timeSLP;
	// -----------------------------------------------------------------------------------------------------------------------

	public TreeNode geo;
	public TreeNode channel;
	public TreeNode time;

	//
	public ReportType reportType;
	// public AdType adType;
	/**
	 * 
	 */
	public ApplicationConstants.SLOT_TYPE_ID_DESCRIPTOR descriptor;
	public Short typeOrSlotId;
	public String slotIds;
	public String video_length_id = null;
	/**
	 * 
	 */
	public ApplicationConstants.TableLevel timeLevel;
	//
	public String startDate;
	public String endDate;
	//
	private GroupByVO groupByVO = new GroupByVO();

	//
	public int pageIndex;
	private com.youdo.mybatis.Page< IRowResultSetItem > pager;

	//
	private String[] englishPriorityArray;

	public PropertyWrapper[] titles;
	/**
	 * for debug
	 */
	public List< String > sqlList = new ArrayList< String >();

	//
	private String timestamp;

	//
	// ------------------------------------ for mobile
	public String videoLengthType = null;
	public String segment = "";
	private boolean isMobile = false;
	//
	//
	//
	private HttpServletRequest request;
	private HttpServletResponse response;

	//
	private ErrorDescriptor errorDescriptor;

	/**
	 * 
	 * @param request
	 */
	public AbstractHttpServletRequestParameter(HttpServletRequest request, HttpServletResponse response) {
		this.setHttpServeltRequest(request);
		this.setHttpServletResponse(response);

		//
		this.setTimestamp(request.getParameter("timestamp"));
		//
		this.isExportExcelMode = "1".equals(request.getParameter("exportExcelMode"));
		try {
			this.startRow = Integer.parseInt(request.getParameter("startRow"));
			this.endRow = Integer.parseInt(request.getParameter("endRow"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		//
		this.site = ApplicationConstants.Site.getHolder().get(request.getParameter("site"));
		//
		this.citySLP = new SecondLevelParameter((request.getParameter("cityName") == null) ? "{data:[]}" : request.getParameter("cityName"));
		this.channelSLP = new SecondLevelParameter((request.getParameter("channelName") == null) ? "{data:[]}" : request.getParameter("channelName"));
		this.timeSLP = new SecondLevelParameter((request.getParameter("timeName") == null) ? "{data:[]}" : request.getParameter("timeName"));
		//
		/*
		 * this.geo = this.convertJSON2Tree(request.getParameter("cityName"));
		 * this.channel =
		 * this.convertJSON2Tree(request.getParameter("channelName")); this.time
		 * = this.convertJSON2Tree(request.getParameter("timeName"));
		 */
		//
		this.startDate = request.getParameter("start_date");
		this.endDate = request.getParameter("end_date");
		//
		this.reportType = "1".equals(request.getParameter("report_type")) ? ReportType.STATISTICAL : ReportType.DETAILS;
		//
		//
		try {
			this.descriptor = ApplicationConstants.SLOT_TYPE_ID_DESCRIPTOR.getHolder().get(request.getParameter("type"));
		} catch (Exception e) {
		}
		try {
			this.typeOrSlotId = new Short(request.getParameter("key"));
		} catch (Exception e) {
		}
		try {
			//
			this.slotIds = request.getParameter("value");
			//
			this.video_length_id = request.getParameter("video_length_id");
			if (Integer.parseInt(this.video_length_id) < 0) {
				this.video_length_id = null;
			}
		} catch (Exception e) {
		}
		//
		// ------------------------------------------------------------------------------------------------------------------------------------------------------
		//
		try {
			this.pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		//
		// mobile parameters.
		this.videoLengthType = request.getParameter("isLongVideo");
		this.segment = request.getParameter("segment");
		this.isMobile = StringUtils.isValidValue(this.segment);
		//
		this.groupByVO.parse(request);
		//
		this.setEnglishPriorityArray(new String[0]);
		this.titles = new PropertyWrapper[0];
	}

	/**
	 * 
	 */
	public void buildDisplayPriority() {

	}

	/**
	 * 
	 * @return true indicate is mobile mode, otherwise PC mode.
	 */
	public boolean isMobile() {
		return this.isMobile;
	}

	/**
	 * 
	 * @param request
	 */
	public void setHttpServeltRequest( HttpServletRequest request ) {
		this.request = request;
	}

	/**
	 * 
	 * @return
	 */
	public HttpServletRequest getHttpServeltRequest() {
		return this.request;
	}

	public SecondLevelParameter getCitySLP() {
		return citySLP;
	}

	public void setCitySLP( SecondLevelParameter citySLP ) {
		this.citySLP = citySLP;
	}

	public SecondLevelParameter getChannelSLP() {
		return channelSLP;
	}

	public void setChannelSLP( SecondLevelParameter channelSLP ) {
		this.channelSLP = channelSLP;
	}

	public GroupByVO getGroupByVO() {
		return groupByVO;
	}

	public void setGroupByVO( GroupByVO groupByVO ) {
		this.groupByVO = groupByVO;
	}

	/**
	 * 
	 * @param response
	 */
	public void setHttpServletResponse( HttpServletResponse response ) {
		this.response = response;
	}

	/**
	 * 
	 * @return
	 */
	public HttpServletResponse getHttpServletResponse() {
		return this.response;
	}

	/**
	 * 
	 */
	protected void generateDisplayedList() {
		List< PropertyWrapper > wrappers = new ArrayList< PropertyWrapper >();
		List< String > list = new ArrayList< String >();
		if (this.groupByVO.hasSelectedGroup()) {
			List< FieldTitlePairVO > gplist = this.groupByVO.getSelectedGroup();
			for (int i = 0; i < gplist.size(); i++) {
				list.add(gplist.get(i).getTitle());
			}
		} else {
			this.updateDisplayedListWithOptionalProperties(list);
			this.updateTitleListWithOptionalProperties(wrappers);
		}
		this.updateDisplayedListWithRequiredProperties(list);
		this.updateTitleListWithRequiredProperties(wrappers);
		//
		this.setEnglishPriorityArray(StringUtils.generateSortedArrayByFixedArray(this.getEnglishPriorityArray(), list));
	}

	/**
	 * add optional fields
	 * 
	 * @param list
	 */
	protected abstract void updateDisplayedListWithOptionalProperties( List< String > list );

	/**
	 * add required fields
	 * 
	 * @param list
	 */
	protected abstract void updateDisplayedListWithRequiredProperties( List< String > list );

	/**
	 * add optional fields
	 * 
	 * @param list
	 */
	protected abstract void updateTitleListWithOptionalProperties( List< PropertyWrapper > list );

	/**
	 * add required fields
	 * 
	 * @param list
	 */
	protected abstract void updateTitleListWithRequiredProperties( List< PropertyWrapper > list );

	/**
	 */

	public JSONObject toJSONObject() {
		/*
		 * JSONObject object = new JSONObject(); object.put("version", "1.0");
		 * object.put("success", "false"); object.put("sql",
		 * ECMAScriptCoder.escape(this.toSQL())); object.put("timecost",
		 * this.timecost); if (this.getErrorDescriptor() != null) {
		 * object.put("errorCode", this.getErrorDescriptor().getCode());
		 * object.put("errorMessage", this.getErrorDescriptor().getMessage()); }
		 * if (this.getPager().getTotalCount() > 0 &&
		 * this.getPager().getResult().size() > 0) { object.put("success",
		 * "true"); } if (this.getPager().getTotalCount() == 0 ||
		 * this.getPager().getResult().size() == 0) { object.put("success",
		 * "empty"); } // if (this.getPager().getTotalCount() > 0) { JSONObject
		 * resultObj = new JSONObject(); // JSONArray fields = new JSONArray();
		 * List<String> enHeader =
		 * Arrays.asList(this.getEnglishPriorityArray()); for (int i = 0; i <
		 * enHeader.size(); i++) { this.addChild2Columns(fields,
		 * this.createTitleJSONObj(enHeader.get(i))); }
		 * 
		 * JSONArray array2d = new JSONArray(); array2d.add(fields);
		 * resultObj.put("columns", array2d); // JSONArray dataArray = new
		 * JSONArray(); dataArray.add(this.page2JSONObject());
		 * resultObj.put("data", dataArray); object.put("result", resultObj); }
		 * return object;
		 */
		return null;
	}

	/**
	 * 
	 * @param totalCount
	 * @param pageSize
	 */
	public void initPager( int totalCount, int pageSize ) {
		this.pager = new com.youdo.mybatis.Page< IRowResultSetItem >(this.pageIndex, pageSize, totalCount);
		// this.pager.gotoPage(this.pageIndex);
	}

	public com.youdo.mybatis.Page< IRowResultSetItem > getPager() {
		return this.pager;
	}

	public JSONObject page2JSONObject() {
		JSONObject pageObject = this.convertPageInfo2JSONObject();
		pageObject.put("rows", this.convertCurrentPageItems2JSONArray());
		return pageObject;
	}

	private JSONObject convertPageInfo2JSONObject() {
		JSONObject object = new JSONObject();
		object.put("currentPage", this.getPager().getThisPageNumber());
		object.put("totalPages", this.getPager().getLastPageNumber());
		object.put("totalRows", this.getPager().getTotalCount());
		return object;
	}

	protected abstract BaseKVObject doItemProcess( String name, String value );

	protected void addTitleObj( JSONArray fields, FieldTitlePairVO vo ) {
		if (vo.selected) {
			JSONObject titleObj = this.createTitleJSONObj(vo.getTitle());
			this.addChild2Columns(fields, titleObj);
		}
	}

	/**
	 * 
	 * @param array
	 * @param obj
	 */
	protected void addChild2Columns( JSONArray array, JSONObject obj ) {
		if (obj.size() > 0) {
			array.add(obj);
		}
	}

	/**
	 * 
	 * @param fieldName
	 * @return
	 */

	protected JSONObject createTitleJSONObj( String fieldName ) {
		JSONObject object = new JSONObject();
		object.put("field", fieldName);
		object.put("title", CEMapper.getInstance(this).getChineseName(fieldName));
		return object;
	}

	@SuppressWarnings("rawtypes")
	private JSONArray convertCurrentPageItems2JSONArray() {
		List< String > enHeader = Arrays.asList(this.getEnglishPriorityArray());

		JSONArray array = new JSONArray();
		List< IRowResultSetItem > resultes = this.getPager().getResult();
		for (int i = 0; i < resultes.size(); i++) {
			JSONObject obj = new JSONObject();
			//
			Object responseRowItem = null;
			try {
				responseRowItem = resultes.get(i);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			PropertyDescriptor[] list = PropertyUtils.getPropertyDescriptors(responseRowItem);
			for (int j = 0; j < list.length; j++) {
				String name = list[j].getName();
				String value = null;
				try {
					value = list[j].getReadMethod().invoke(responseRowItem).toString();
					BaseKVObject kvObject = this.doItemProcess(name, value);
					obj.put(kvObject.getKey(), kvObject.getValue());
				} catch (Exception e) {
					// logger.error(j+"--"+e.getMessage());
				}
			}
			array.add(obj);
		}
		return array;
	}

	@SuppressWarnings("rawtypes")
	public void exportFile( OutputStream out ) {
		List< String > enHeader = Arrays.asList(this.getEnglishPriorityArray());

		List< String > cnHeader = new ArrayList< String >();
		Map< String, String > header_column = new HashMap< String, String >();
		ArrayList< Map< String, String >> recordSet = new ArrayList< Map< String, String >>();
		//
		int i = 0;
		//
		for (i = 0; i < enHeader.size(); i++) {
			String enLabel = enHeader.get(i);
			String cnLabel = CEMapper.getInstance(this).getChineseName(enLabel);
			cnHeader.add(cnLabel);
			header_column.put(cnLabel, enLabel);
		}

		//
		List< IRowResultSetItem > resultes = this.getPager().getResult();
		for (int rowIndex = 0; rowIndex < resultes.size(); rowIndex++) {
			Map< String, String > obj = new HashMap< String, String >();
			//
			Object responseRowItem = null;
			try {
				responseRowItem = resultes.get(rowIndex);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			//
			for (i = 0; i < enHeader.size(); i++) {
				String name = enHeader.get(i);
				String value = "";
				try {
					PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(responseRowItem, name);
					value = descriptor.getReadMethod().invoke(responseRowItem).toString();
					BaseKVObject kvObject = this.doItemProcess(name, value);
					value = (String) kvObject.getValue();
				} catch (Exception e) {
					value = "";
				}
				obj.put(name, value);
			}
			recordSet.add(obj);
		}
		ExcelExporter.export(cnHeader, header_column, recordSet, out);
	}

	private void addJSON2Tree( TreeNode parentNode, JSONArray array ) {
		for (int i = 0; i < array.size(); i++) {
			JSONObject jsonObj = array.getJSONObject(i);
			int nodeId = Integer.parseInt(jsonObj.getString("id"));
			String nodeName;
			try {
				nodeName = jsonObj.getString("name");
			} catch (Exception e) {
				nodeName = nodeId + "";
			}
			TreeNode node = new TreeNode(nodeId, nodeName);
			parentNode.addChildNode(node);
			//
			JSONArray cs;
			try {
				cs = jsonObj.getJSONArray("cs");
			} catch (Exception e) {
				cs = new JSONArray();
			}
			this.addJSON2Tree(node, cs);
		}
	}

	public String toSQL() {
		String sql = "***************************************************\n";
		for (int i = 0; i < this.sqlList.size(); i++) {
			sql += this.sqlList.get(i) + "\n***************************************************\n";
		}
		return sql;

	}

	public void setErrorDescriptor( ErrorDescriptor errorDescriptor ) {
		this.errorDescriptor = errorDescriptor;
	}

	public ErrorDescriptor getErrorDescriptor() {
		return this.errorDescriptor;
	}

	public String getTimecost() {
		return timecost;
	}

	public void setTimecost( String timecost ) {
		this.timecost = timecost;
	}

	public String[] getEnglishPriorityArray() {
		return englishPriorityArray;
	}

	public void setEnglishPriorityArray( String[] englishPriorityArray ) {
		this.englishPriorityArray = englishPriorityArray;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp( String timestamp ) {
		this.timestamp = timestamp;
	}

	// ----------------------------------------------------------------------------------------------------------------------------------
	public boolean isOnlyCity() {
		return this.getCitySLP().has2ndLevelParameter() || this.getGroupByVO().getCity().selected;
	}

	public boolean isOnlySubChannel() {
		return this.getChannelSLP().has2ndLevelParameter() || this.getGroupByVO().getSubchannel().selected;
	}

}
