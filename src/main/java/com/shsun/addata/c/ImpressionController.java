package com.shsun.addata.c;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsun.addata.m.ImpressionService;
import com.shsun.addata.utils.io.ImpressionBeforeWritingProcessor;
import com.shsun.addata.utils.io.JQueryEasyUIDataGridWriter;
import com.shsun.addata.utils.io.MicrosoftExcelWriter;
import com.shsun.addata.vo.ImpressionHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 */
@Controller
@RequestMapping(value = "/ad")
public class ImpressionController extends AbstractController {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ImpressionController.class);

	private static final String DOWN_LOAD_FILE_NAME = "impression";

	@Autowired
	private ImpressionService impressionService;

	@RequestMapping(value = "queryImpression.sdo")
	public void queryImpression(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IHttpServletRequestParameter parameter = new ImpressionHttpServletRequestParameter(request, response);
		this.impressionService.service(parameter);
		/*
		JSONObject object = parameter.toJSONObject();
		logger.info(object.toString());
		AjaxOut.responseText(response, object.toString());*/
		
		new JQueryEasyUIDataGridWriter(parameter, new ImpressionBeforeWritingProcessor()).write();
	}

	@RequestMapping(value = "exportexcel.sdo")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IHttpServletRequestParameter parameter = new ImpressionHttpServletRequestParameter(request, response);
		this.impressionService.service(parameter);
		//
		super.initializeExcelDownloadingSettings(DOWN_LOAD_FILE_NAME, parameter);
		//
		//parameter.exportFile(response.getOutputStream());
		new MicrosoftExcelWriter(parameter, new ImpressionBeforeWritingProcessor()).write();
	}
}
