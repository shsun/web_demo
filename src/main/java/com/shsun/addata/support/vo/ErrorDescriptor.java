package com.shsun.addata.support.vo;

import net.sf.json.JSONObject;
import com.youdo.m.IJSONObjectParsable;

/**
 * 
 * @author shsun
 * 
 */
public class ErrorDescriptor implements IJSONObjectParsable {

	private String code;
	private String message;

	/**
	 * 
	 * @param code
	 * @param message
	 */
	public ErrorDescriptor(String code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}

	public String getCode() {
		return code;
	}

	public void setCode( String code ) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage( String message ) {
		this.message = message;
	}

	public JSONObject toJSONObject() {
		return JSONObject.fromObject(this);
	}
}
