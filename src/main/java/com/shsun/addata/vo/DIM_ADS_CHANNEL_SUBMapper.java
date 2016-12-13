package com.shsun.addata.vo;

import java.util.List;

/**
 * 
 * @author shsun
 * 
 */
public interface DIM_ADS_CHANNEL_SUBMapper {
	/**
	 * 
	 * @param agentId
	 * @return
	 */
	public List<DIM_ADS_CHANNEL_SUB> retrieveAllByAgentId(Integer agentId);
}