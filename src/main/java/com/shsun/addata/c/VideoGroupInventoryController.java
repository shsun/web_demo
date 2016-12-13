package com.shsun.addata.c;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsun.addata.m.VideoGroupInventoryService;
import com.shsun.addata.utils.io.ExtJSDataGridWriter;
import com.shsun.addata.utils.io.MicrosoftExcelWriter;
import com.shsun.addata.utils.io.VideoGroupInventoryBeforeWritingProcessor;
import com.shsun.addata.vo.VideoGroupInventoryHttpServletRequestParameter;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
@Controller
@RequestMapping(value = "/videogroup")
public class VideoGroupInventoryController extends AbstractController {
	
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VideoGroupInventoryController.class);

	private static final String DOWN_LOAD_FILE_NAME = "video_group_inventory";

	@Autowired
	private VideoGroupInventoryService videoGroupInventoryService;

	@RequestMapping(value = "queryvideogroupinventory.sdo")
	public void queryImpression( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		IHttpServletRequestParameter parameter = new VideoGroupInventoryHttpServletRequestParameter(request, response);
		this.videoGroupInventoryService.service(parameter);

		new ExtJSDataGridWriter(parameter, new VideoGroupInventoryBeforeWritingProcessor()).write();
	}

	@RequestMapping(value = "exportexcel.sdo")
	public void exportExcel( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		IHttpServletRequestParameter parameter = new VideoGroupInventoryHttpServletRequestParameter(request, response);
		this.videoGroupInventoryService.service(parameter);
		//
		super.initializeExcelDownloadingSettings(DOWN_LOAD_FILE_NAME, parameter);
		//
		new MicrosoftExcelWriter(parameter, new VideoGroupInventoryBeforeWritingProcessor()).write();
	}
}
