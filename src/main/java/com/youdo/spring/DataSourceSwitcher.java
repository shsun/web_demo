package com.youdo.spring;

/**
 * 
 * @author shsun
 * 
 */
public class DataSourceSwitcher {

	public enum Type {
		MASTER("MASTER", 1), SLAVE("SLAVE", 2);

		private String name;
		private int id;

		private Type(String name, int id) {
			this.name = name;
			this.id = id;
		}

		public static String getName( int id ) {
			String name = null;
			for (Type c : Type.values()) {
				if (c.getId() == id) {
					name = c.getName();
					break;
				}
			}
			return name;
		}

		public String getName() {
			return name;
		}

		public void setName( String name ) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId( int id ) {
			this.id = id;
		}
	}

	private static final ThreadLocal< String > contextHolder = new ThreadLocal< String >();

	public static void setDataSourceType( DataSourceSwitcher.Type type ) {
		contextHolder.set(type.getName());
	}

	public static String getDataSourceType() {
		return (String) contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}
}
