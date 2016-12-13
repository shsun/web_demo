package com.youdo.log4j;

/**
 * 
 * @author shsun
 * 
 */
public class YouDoLevel extends org.apache.log4j.Level {

	/**
	 */
	private static final long serialVersionUID = -12594408375642121L;

	/**
	 * 
	 * @param level
	 * @param levelStr
	 * @param syslogEquivalent
	 */
	protected YouDoLevel(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}

	public static YouDoLevel toLevel( int val, org.apache.log4j.Level defaultLevel ) {
		return SQL;
	}

	public static YouDoLevel toLevel( String sArg, org.apache.log4j.Level defaultLevel ) {
		return SQL;
	}

	/**
	 * 
	 */
	public static final int SQL_INT = org.apache.log4j.Level.INFO_INT + 1;
	private static String SQL_STR = "SQL";
	public static final com.youdo.log4j.YouDoLevel SQL = new com.youdo.log4j.YouDoLevel(SQL_INT, SQL_STR, 0);
}
