package com.shsun.addata.support.vo;

/**
 * 
 * @author shsun
 * 
 */
public class FieldTitlePairVO {

	private String field;
	private String title;

	public boolean selected;

	/**
	 * 
	 * @param selected
	 * @param title
	 */
	public FieldTitlePairVO(boolean selected, String groupbyedProperty) {
		this(selected, groupbyedProperty, groupbyedProperty);
	}

	/**
	 * 
	 * @param selected
	 *            true indicate group by this property, otherwise not.
	 * @param field
	 *            the property which be group-by.
	 * @param title
	 *            the property which be shown in GUI
	 */
	public FieldTitlePairVO(boolean selected, String field, String title) {
		this.selected = selected;
		this.setField(field);
		this.setTitle(title);
	}

	public String getField() {
		return field;
	}

	public void setField( String groupbyedProperty ) {
		this.field = groupbyedProperty;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle( String displayedProperty ) {
		this.title = displayedProperty;
	}
}
