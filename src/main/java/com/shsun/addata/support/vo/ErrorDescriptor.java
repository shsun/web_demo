package com.shsun.addata.support.vo;

import com.youdo.interfaces.IJSONObjectParsable;

import net.sf.json.JSONObject;

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
