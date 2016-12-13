var GeoVO = Objs("com.shsun.addata.model.vo.GeoVO",
{
	provinces : {},

    /*
	initialize: function( cityArrayOfChina )
	{
		for ( var i = 0; i < cityArrayOfChina.length; i++) {
			var tmpCityJSONObject = cityArrayOfChina[i];
			var tmpProvince = this.provinces[tmpCityJSONObject.PROVINCE_ID];
			if (tmpProvince == null) {
				tmpProvince = new ProvinceVO(tmpCityJSONObject);
			}
			if (tmpProvince.PROVINCE_ID == tmpCityJSONObject.PROVINCE_ID) {
				tmpProvince.addCity(tmpCityJSONObject);
			}
			this.provinces[tmpCityJSONObject.PROVINCE_ID] = tmpProvince;
		}
	},
	*/
    initialize: function(jsonGeo)
    {
        if (jsonGeo.success) {
            for (var i = 0; i < jsonGeo.data.length; i ++) {
                var tmpProvince = new ProvinceVO(jsonGeo.data[i]);
                this.provinces[tmpProvince.PROVINCE_ID] = tmpProvince;
            }
        }
    },
	
	getAllCitiesByProvinceId : function(id/* :String */)/* :Array */
	{
		return this.provinces[id].cityes;
	}		
});
