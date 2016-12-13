package com.shsun.addata.vo.base;

public class ImpressionGroupParameter extends BasicGroupParameter {

	public GroupVO CAST_ID;
	public GroupVO CREATIVE_ID;
	public GroupVO CONTRACT_ID;
	public GroupVO SLOT_ID;
	public GroupVO IS_AMOUNT;

	public ImpressionGroupParameter(String driverTable) {
		super(driverTable);
	}

}
