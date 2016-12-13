package com.shsun.addata.vo;

import java.util.List;

/**
 * 
 * @author shsun
 * 
 */
public interface VideoGroupInventoryRowItemMapper {

	/**
	 * 
	 * @param source
	 * @return
	 */
	public int countBy( VideoGroupInventorySqlParameterSource source );

	/**
	 * 
	 * @param source
	 * @return
	 */
	public int gcountBy( VideoGroupInventorySqlParameterSource source );

	/**
	 * 
	 * @param source
	 * @return
	 */
	public List< VideoGroupInventoryRowItem > retrievePage( VideoGroupInventorySqlParameterSource source );

	/**
	 * 
	 * @param source
	 * @return
	 */
	public List< VideoGroupInventoryRowItem > gretrievePage( VideoGroupInventorySqlParameterSource source );

	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param source
	 * @return
	 */
	public int mcountBy( VideoGroupInventorySqlParameterSource source );

	/**
	 * 
	 * @param source
	 * @return
	 */
	public int mgcountBy( VideoGroupInventorySqlParameterSource source );

	/**
	 * 
	 * @param source
	 * @return
	 */
	public List< VideoGroupInventoryRowItem > mretrievePage( VideoGroupInventorySqlParameterSource source );

	/**
	 * 
	 * @param source
	 * @return
	 */
	public List< VideoGroupInventoryRowItem > mgretrievePage( VideoGroupInventorySqlParameterSource source );

}
