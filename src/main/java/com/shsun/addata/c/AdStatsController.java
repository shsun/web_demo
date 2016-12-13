package com.shsun.addata.c;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.youdo.util.io.AjaxOut;
import com.shsun.addata.vo.base.ApplicationSharedObject;

/**
 * 
 * @author shsun
 * 
 */
@Controller
@RequestMapping(value = "/as")
public class AdStatsController extends MultiActionController {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(AdStatsController.class);

	@RequestMapping(value = "queryChannel.sdo")
	public void queryChannel( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String result;
		if ("1".equals(request.getParameter("isMobile"))) {
			result = ApplicationSharedObject.getInstance().getChannelVOCollector().toMobileJSONObject().toString();
		} else {
			result = ApplicationSharedObject.getInstance().getChannelVOCollector().toJSONObject().toString();
		}
		logger.info(result);
		AjaxOut.responseText(response, result);
	}

	@RequestMapping(value = "queryBlock.sdo")
	public void queryBlock( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String result = "{'success':0}";
		logger.info(result);
		AjaxOut.responseText(response, result);
	}

	@RequestMapping(value = "queryGEO.sdo")
	public void queryGEO( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String result = ApplicationSharedObject.getInstance().getRegionVOContainer().toJSONObject().toString();
		logger.info(result);
		AjaxOut.responseText(response, result);
	}
	
	
	@RequestMapping(value = "queryGEO2.sdo")
	public void queryGEO2( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String result = ApplicationSharedObject.getInstance().getGeoVOCollector().toJSONObject().toString();
		logger.info(result);
		AjaxOut.responseText(response, result);
	}
}
