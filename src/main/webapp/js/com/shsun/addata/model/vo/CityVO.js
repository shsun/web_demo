var CityVO = Objs("com.shsun.addata.model.vo.CityVO",
{
	CITY_NAME : null,
	CITY_ID : null,
	PROVINCE_ID : null,
	selected : false,
	
	initialize: function( jsonCity )
	{
		this.CITY_NAME = jsonCity.CITY_NAME;
		this.CITY_ID = jsonCity.CITY_ID;
		this.PROVINCE_ID = jsonCity.PROVINCE_ID;
		this.selected = false;
	}
});
