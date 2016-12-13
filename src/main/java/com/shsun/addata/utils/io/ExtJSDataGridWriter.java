package com.shsun.addata.utils.io;

import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;

import com.youdo.util.JSONGrid;
import com.youdo.util.io.AjaxOut;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
public class ExtJSDataGridWriter extends AbstractAdDataWriter implements IAdDataWriter {
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ExtJSDataGridWriter.class);
	
	public ExtJSDataGridWriter(IHttpServletRequestParameter parameter, IBeforeWritingItemProcessor processor) {
		super(parameter, processor);

		try {
			JSONObject object = JSONGrid.toJSon(parameter.getPager().getResult(),parameter.getPager().getTotalCount(), new SimpleDateFormat("yyyy-MM-dd"), parameter.getTimecost());
			String s = object.toString();
			
			System.out.println("+++++++------>" + this.getHttpServletRequestParameter().getHttpServletResponse());
			System.out.println("+++++++------>" + s);
		
			AjaxOut.responseText(this.getHttpServletRequestParameter().getHttpServletResponse(), object.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
