package com.shsun.addata.support;

/**
 * 
 * @author shsun
 * 
 */
public class PropertyWrapper {

	// --------------------------------------------------------------------------------------------------------------------------------
	private boolean isGroupby = false;

	private String id;
	//
	private String field;
	private String title;

	public PropertyWrapper(String id, String title) {
		this(false, id, id, title);
	}

	public PropertyWrapper(String id, String field, String title) {
		this(false, id, field, title);
	}

	public PropertyWrapper(boolean groupby, String id, String field, String title) {
		this.setGroupby(groupby);
		this.setId(id);
		this.setField(field);
		this.setTitle(title);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isGroupby() {
		return isGroupby;
	}

	public void setGroupby(boolean isGroupby) {
		this.isGroupby = isGroupby;
	}

}
