package com.shsun.addata.vo;

import java.util.List;

/**
 * 
 * @author shsun
 * 
 */
public interface DIM_COM_CITYMapper {

	public List< DIM_COM_CITY > retrieveAll();

	public List< DIM_COM_CITY > retrieveAllByProvinceId( Integer provinceId );
}