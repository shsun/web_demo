package com.shsun.addata.utils.io;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.shsun.addata.support.CEMapper;
import com.youdo.m.BaseKVObject;
import com.youdo.net.ECMAScriptCoder;
import com.youdo.util.io.AjaxOut;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IRowResultSetItem;

/**
 * 
 * @author shsun
 * 
 */
public class JQueryEasyUIDataGridWriter extends AbstractAdDataWriter implements IAdDataWriter {

	/**
	 * 
	 * @param parameter
	 */
	public JQueryEasyUIDataGridWriter(IHttpServletRequestParameter parameter, IBeforeWritingItemProcessor processor) {
		super(parameter, processor);
	}

	@Override
	public void write() {
		JSONObject object = new JSONObject();
		object.put("version", "1.0");
		object.put("success", "false");
		object.put("sql", ECMAScriptCoder.escape(this.getHttpServletRequestParameter().toSQL()));
		object.put("timecost", this.getHttpServletRequestParameter().getTimecost());
		if (this.getHttpServletRequestParameter().getErrorDescriptor() != null) {
			object.put("errorCode", this.getHttpServletRequestParameter().getErrorDescriptor().getCode());
			object.put("errorMessage", this.getHttpServletRequestParameter().getErrorDescriptor().getMessage());
		}
		if (this.getHttpServletRequestParameter().getPager().getTotalCount() > 0 && this.getHttpServletRequestParameter().getPager().getResult().size() > 0) {
			object.put("success", "true");
		}
		if (this.getHttpServletRequestParameter().getPager().getTotalCount() == 0 || this.getHttpServletRequestParameter().getPager().getResult().size() == 0) {
			object.put("success", "empty");
		}

		// TODO
		
		
		if (this.getHttpServletRequestParameter().getPager().getTotalCount() > 0) {
			JSONObject resultObj = new JSONObject();
			//
			JSONArray fields = new JSONArray();			
			
			List< String > enHeader = Arrays.asList(this.getHttpServletRequestParameter().getEnglishPriorityArray());
			for (int i = 0; i < enHeader.size(); i++) {
				this.addChild2Columns(fields, this.createTitleJSONObj(enHeader.get(i)));
			}
			
			JSONArray array2d = new JSONArray();
			array2d.add(fields);
			resultObj.put("columns", array2d);
			//
			JSONArray dataArray = new JSONArray();
			dataArray.add(this.page2JSONObject());
			resultObj.put("data", dataArray);
			object.put("result", resultObj);
		}
		
		AjaxOut.responseText(this.getHttpServletRequestParameter().getHttpServletResponse(), object.toString());
	}
	
	
	@SuppressWarnings("rawtypes")
	private JSONArray convertCurrentPageItems2JSONArray() {
		List< String > enHeader = Arrays.asList(this.getHttpServletRequestParameter().getEnglishPriorityArray());
		JSONArray array = new JSONArray();
		List< IRowResultSetItem > resultes = this.getHttpServletRequestParameter().getPager().getResult();
		for (int i = 0; i < resultes.size(); i++) {
			JSONObject obj = new JSONObject();
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
					//BaseKVObject kvObject = this.doItemProcess(name, value);
					BaseKVObject kvObject = new BaseKVObject(name, value);
					//this.processItem(kvObject);
					this.getBeforeWritingItemProcessor().process(kvObject);
					obj.put(kvObject.getKey(), kvObject.getValue());
				} catch (Exception e) {
					// logger.error(j+"--"+e.getMessage());
				}
			}
			array.add(obj);
		}
		return array;
	}

	public JSONObject getJSONObjectFromHttpParameter() {
		//IHttpServletRequestParameter p = this.getHttpServletRequestParameter();
		JSONObject object = new JSONObject();
		object.put("version", "1.0");
		object.put("success", "false");
		object.put("sql", ECMAScriptCoder.escape(this.getHttpServletRequestParameter().toSQL()));
		object.put("timecost", this.getHttpServletRequestParameter().getTimecost());
		if (this.getHttpServletRequestParameter().getErrorDescriptor() != null) {
			object.put("errorCode", this.getHttpServletRequestParameter().getErrorDescriptor().getCode());
			object.put("errorMessage", this.getHttpServletRequestParameter().getErrorDescriptor().getMessage());
		}
		if (this.getHttpServletRequestParameter().getPager().getTotalCount() > 0 && this.getHttpServletRequestParameter().getPager().getResult().size() > 0) {
			object.put("success", "true");
		}
		if (this.getHttpServletRequestParameter().getPager().getTotalCount() == 0 || this.getHttpServletRequestParameter().getPager().getResult().size() == 0) {
			object.put("success", "empty");
		}
		//
		if (this.getHttpServletRequestParameter().getPager().getTotalCount() > 0) {
			JSONObject resultObj = new JSONObject();
			//
			JSONArray fields = new JSONArray();			
			List<String> enHeader = Arrays.asList(this.getHttpServletRequestParameter().getEnglishPriorityArray());
			for (int i = 0; i < enHeader.size(); i++) {
				this.addChild2Columns(fields, this.createTitleJSONObj(enHeader.get(i)));
			}
			
			JSONArray array2d = new JSONArray();
			array2d.add(fields);
			resultObj.put("columns", array2d);
			//
			JSONArray dataArray = new JSONArray();
			dataArray.add(this.page2JSONObject());
			resultObj.put("data", dataArray);
			object.put("result", resultObj);
		}
		return object;
	}
	
	/**
	 * 
	 * @param fieldName
	 * @return
	 */
	protected JSONObject createTitleJSONObj(String fieldName) {
		JSONObject object = new JSONObject();
		object.put("field", fieldName);
		object.put("title", CEMapper.getInstance(this.getHttpServletRequestParameter()).getChineseName(fieldName));
		return object;
	}
	
	/**
	 * 
	 * @param array
	 * @param obj
	 */
	protected void addChild2Columns(JSONArray array, JSONObject obj) {
		if (obj.size() > 0) {
			array.add(obj);
		}
	}
	
	private JSONObject page2JSONObject() {
		JSONObject pageObject = this.convertPageInfo2JSONObject();
		pageObject.put("rows", this.convertCurrentPageItems2JSONArray());
		return pageObject;
	}
	
	private JSONObject convertPageInfo2JSONObject() {
		JSONObject object = new JSONObject();
		object.put("currentPage", this.getHttpServletRequestParameter().getPager().getThisPageNumber());
		object.put("totalPages", this.getHttpServletRequestParameter().getPager().getLastPageNumber());
		object.put("totalRows", this.getHttpServletRequestParameter().getPager().getTotalCount());
		return object;
	}
}
