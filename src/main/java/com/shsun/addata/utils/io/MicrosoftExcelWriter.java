package com.shsun.addata.utils.io;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import com.shsun.addata.support.CEMapper;
import com.youdo.m.BaseKVObject;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;
import com.shsun.addata.vo.base.IRowResultSetItem;

/**
 * 
 * @author shsun
 * 
 */
public class MicrosoftExcelWriter extends AbstractAdDataWriter implements IAdDataWriter {

	/**
	 * 
	 * @param parameter
	 */
	public MicrosoftExcelWriter(IHttpServletRequestParameter parameter, IBeforeWritingItemProcessor processor) {
		super(parameter, processor);
	}

	@Override
	public void write() {
		
		List<String> enHeader = Arrays.asList(this.getHttpServletRequestParameter().getEnglishPriorityArray());
		
		List<String> cnHeader = new ArrayList<String>();
		Map<String, String> header_column = new HashMap<String, String>();
		ArrayList<Map<String, String>> recordSet = new ArrayList<Map<String, String>>();
		//
		int i = 0;
		//
		for (i = 0; i < enHeader.size(); i++) {
			String enLabel = enHeader.get(i);
			String cnLabel = CEMapper.getInstance(this.getHttpServletRequestParameter()).getChineseName(enLabel);
			cnHeader.add(cnLabel);
			header_column.put(cnLabel, enLabel);
		}

		//
		List<IRowResultSetItem> resultes = this.getHttpServletRequestParameter().getPager().getResult();
		for (int rowIndex = 0; rowIndex < resultes.size(); rowIndex++) {
			Map<String, String> obj = new HashMap<String, String>();
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
					//BaseKVObject kvObject = this.doItemProcess(name, value);
					//value = (String) kvObject.getValue();
				} catch (Exception e) {
					value = "";
				}
				obj.put(name, value);
			}
			recordSet.add(obj);
		}
		
		try {
			OutputStream out = this.getHttpServletRequestParameter().getHttpServletResponse().getOutputStream();
			ExcelExporter.export(cnHeader, header_column, recordSet, out);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	
	
}
