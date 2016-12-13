package com.shsun.addata.vo;

import java.util.List;

/**
 * 
 * @author shsun
 * 
 */
public interface InventoryRowItemMapper {

	/**
	 * 
	 * @param searchEty
	 * @return
	 */
	public int countBy( InventorySqlParameterSource source );

	/**
	 * 
	 * @param adi
	 * @return
	 */
	public int gcountBy( InventorySqlParameterSource source );

	/**
	 * 
	 * @return
	 */
	public List< InventoryRowItem > retrievePage( InventorySqlParameterSource source );

	/**
	 * 
	 * @return
	 */
	public List< InventoryRowItem > gretrievePage( InventorySqlParameterSource source );

	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * 
	 * @param searchEty
	 * @return
	 */
	public int mcountBy( InventorySqlParameterSource source );

	/**
	 * 
	 * @param adi
	 * @return
	 */
	public int mgcountBy( InventorySqlParameterSource source );

	/**
	 * 
	 * @return
	 */
	public List< InventoryRowItem > mretrievePage( InventorySqlParameterSource source );

	/**
	 * 
	 * @return
	 */
	public List< InventoryRowItem > mgretrievePage( InventorySqlParameterSource source );

}
