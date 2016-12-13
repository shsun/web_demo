package com.shsun.addata.c;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.shsun.addata.utils.io.ExcelExporter;
import com.shsun.addata.vo.base.AbstractHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
public abstract class AbstractController {	
	/**
	 * 
	 * @return
	 */
	protected void initializeExcelDownloadingSettings(String fileName, IHttpServletRequestParameter parameter) {
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		String fullFileName = (fileName + " -- " + df.format(new Date()) + ".xls");
		parameter.getHttpServletResponse().setHeader("Content-Disposition", "fileName=" + fullFileName);
		parameter.getHttpServletResponse().setContentType("application/octet-stream");
		//
		Cookie cookie = new Cookie("fileDownloadTimestamp", parameter.getTimestamp());
		cookie.setMaxAge(16 * 60 * 60);// 16 hours
		cookie.setPath("/");
		parameter.getHttpServletResponse().addCookie(cookie);
	}	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "downloadExcelTest.sdo")
	public void downloadExcelTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		response.setHeader("Content-Disposition", "filename=测试.xls");
		//
		List<String> header = new ArrayList<String>();
		header.add("标题1");
		header.add("标题2");
		//
		Map<String, String> header_column = new HashMap<String, String>();
		header_column.put("标题1", "title_1");
		header_column.put("标题2", "title_2");
		//
		ArrayList<Map<String, String>> recordSet = new ArrayList<Map<String, String>>();
		Map<String, String> r1 = new HashMap<String, String>();
		r1.put("title_2", "第一行数据：这个是标题2对应的数据");
		r1.put("title_1", "第一行数据：这个是标题1对应的数据");
		//
		Map<String, String> r2 = new HashMap<String, String>();
		r2.put("title_1", "第2行数据：这个是标题1对应的数据3489734892");
		r2.put("title_2", "第2行数据：这个是标题2对应的数据dhfahdhasdfhl");
		//
		recordSet.add(r1);
		recordSet.add(r2);
		// 
		ArrayList<List<String>> recordSet2 = new ArrayList<List<String>>();
		List<String> record_1 = new ArrayList<String>();
		record_1.add("第一行数据：这个是标题1对应的数据");
		record_1.add("第一行数据：这个是标题2对应的数据");
		//
		List<String> record_2 = new ArrayList<String>();
		record_2.add("第2行数据：这个是标题1对应的数据3489734892");
		record_2.add("第2行数据：这个是标题2对应的数据dhfahdhasdfhl");
		//
		recordSet2.add(record_1);
		recordSet2.add(record_2);
		//
		ExcelExporter.export(header, header_column, recordSet, response.getOutputStream());
	}
}
