package com.youdo.ad.entry;

/**
 * 
 * @author shsun
 * 
 */
public abstract class IdNameObject {

	private int id;
	private String name;

	public IdNameObject(int id, String name) {
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId( int id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

}
