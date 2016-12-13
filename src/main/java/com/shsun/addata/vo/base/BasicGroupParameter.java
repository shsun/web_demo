package com.shsun.addata.vo.base;

/**
 * 
 * @author shsun
 * 
 */
public class BasicGroupParameter {

	// ------------------------------------------------
	public GroupVO PROVINCE_ID;
	public GroupVO CITY_ID;
	public GroupVO CHANNEL_AGENT_ID;
	public GroupVO SUB_CHANNEL_AGENT_ID;
	public GroupVO DATE_TIME;
	public GroupVO HOUR_ID;
	public GroupVO SITE_ID;
	// ------------------------------------------------
	public GroupVO PLATFORM_ID;
	public GroupVO CLIENT_ID;
	public GroupVO VIDEO_LENGTH_ID;

	// ------------------------------------------------
	private String driverTable;

	/**
	 * 
	 * @param driverTable
	 */
	public BasicGroupParameter(String driverTable) {
		this.setDriverTable(driverTable);
		this.PROVINCE_ID = new GroupVO(this.getDriverTable(), "PROVINCE_ID", null, false);
	}
	
	public String getDriverTable() {
		return driverTable;
	}

	public void setDriverTable( String driverTable ) {
		this.driverTable = driverTable;
	}

	/**
	 * 
	 * @author shsun
	 * 
	 */
	public static class GroupVO {

		private String table;
		private String field;
		private String title;
		
		public boolean selected;

		/**
		 * 
		 * @param selected
		 *            true indicate group by this property, otherwise not.
		 * @param field
		 *            the property which be group-by.
		 * @param title
		 *            the property which be shown in GUI
		 */
		public GroupVO(String driverTableName, String field, String title, boolean selected) {
			this.setTable(driverTableName);
			this.setField(field);
			this.setTitle(title);
			this.setSelected(selected);
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

		public String getTable() {
			return table;
		}

		public void setTable( String table ) {
			this.table = table;
		}

		public boolean isSelected() {
			return selected;
		}

		public void setSelected( boolean selected ) {
			this.selected = selected;
		}
	}

}
