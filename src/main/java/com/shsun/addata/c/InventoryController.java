package com.shsun.addata.c;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shsun.addata.m.InventoryService;
import com.shsun.addata.utils.io.IAdDataWriter;
import com.shsun.addata.utils.io.InventoryBeforeWritingProcessor;
import com.shsun.addata.utils.io.JQueryEasyUIDataGridWriter;
import com.shsun.addata.utils.io.MicrosoftExcelWriter;
import com.shsun.addata.vo.InventoryHttpServletRequestParameter;
import com.youdo.util.io.AjaxOut;
import com.shsun.addata.vo.base.IHttpServletRequestParameter;

/**
 * 
 * @author shsun
 * 
 */
@Controller
@RequestMapping(value = "/inventory")
public class InventoryController extends AbstractController {

	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(InventoryController.class);

	private static final String DOWN_LOAD_FILE_NAME = "inventory";

	@Autowired
	private InventoryService inventoryService;

	@RequestMapping(value = "queryInventory.sdo")
	public void queryInventory( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		IHttpServletRequestParameter parameter = new InventoryHttpServletRequestParameter(request, response);
		//
		this.inventoryService.service(parameter);
		//
		/*
		JSONObject object = parameter.toJSONObject();
		logger.info(object.toString());
		AjaxOut.responseText(response, object.toString());
		*/
		
		//JQueryEasyUIDataGridWriter
		new JQueryEasyUIDataGridWriter(parameter, new InventoryBeforeWritingProcessor()).write();
		
	}

	@RequestMapping(value = "exportexcel.sdo")
	public void exportExcel( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		IHttpServletRequestParameter parameter = new InventoryHttpServletRequestParameter(request, response);
		//
		this.inventoryService.service(parameter);
		//
		super.initializeExcelDownloadingSettings(DOWN_LOAD_FILE_NAME, parameter);
		//
		//parameter.exportFile(response.getOutputStream());
		new MicrosoftExcelWriter(parameter, new InventoryBeforeWritingProcessor()).write();
	}

	public String nameString;

	@RequestMapping(value = "queryTest.sdo")
	public void queryTest( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		System.out.println("in-->>" + request.getParameter("name"));
		this.nameString = request.getParameter("name");
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}
}