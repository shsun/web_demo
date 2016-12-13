package com.shsun.addata.vo.base;

/**
 * 
 * @author shsun
 * 
 */
public interface ITableSelectionStrategy {

	/**
	 * select the most suitable table for querying.
	 * 
	 * @param parameter
	 * @param source
	 * @return table name.
	 */
	public void select();
}
