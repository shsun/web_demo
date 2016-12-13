package com.shsun.addata.vo;

import java.util.List;

public interface ImpressionRowItemMapper {

	/**
	 * 
	 * @param searchEty
	 * @return
	 */
	public int countBy( ImpressionSqlParameterSource source );

	/**
	 * 
	 * @param adi
	 * @return
	 */
	public int gcountBy( ImpressionSqlParameterSource source );

	/**
	 * 
	 * @return
	 */
	public List< ImpressionRowItem > retrievePage( ImpressionSqlParameterSource source );

	//DW_ADS_ADI_P_CHANNEL_DAY
	//public List< ImpressionRowItem > retrievePageNoCitySubChannel( ImpressionSqlParameterSource source );
	//DW_ADS_ADI_CITY_CHANNEL_DAY	
	//public List< ImpressionRowItem > retrievePageNoSubChannel( ImpressionSqlParameterSource source );	
	
	/**
	 * 
	 * @return
	 */
	public List< ImpressionRowItem > gretrievePage( ImpressionSqlParameterSource source );

	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * 
	 * @param searchEty
	 * @return
	 */
	public int mcountBy( ImpressionSqlParameterSource source );

	/**
	 * 
	 * @param adi
	 * @return
	 */
	public int mgcountBy( ImpressionSqlParameterSource source );

	/**
	 * 
	 * @return
	 */
	public List< ImpressionRowItem > mretrievePage( ImpressionSqlParameterSource source );

	/**
	 * 
	 * @return
	 */
	public List< ImpressionRowItem > mgretrievePage( ImpressionSqlParameterSource source );
}
