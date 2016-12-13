var ProvinceVO = Objs("com.shsun.addata.model.vo.ProvinceVO",
{
	PROVINCE_NAME : null,
	PROVINCE_ID : null,
	cityes : {},

    /*
	initialize: function( cityJSONObject )
	{
		this.PROVINCE_NAME = cityJSONObject.PROVINCE_NAME;
		this.PROVINCE_ID = cityJSONObject.PROVINCE_ID;
		this.cityes = {};
	},*/

    initialize: function(jsonProvince)
    {
        this.cityes = {};
        this.PROVINCE_NAME = jsonProvince.PROVINCE_NAME;
        this.PROVINCE_ID = jsonProvince.PROVINCE_ID;
        for(var i = 0; i < jsonProvince.children.length; i++) {
            var tmpCity = new CityVO(jsonProvince.children[i]);
            this.cityes[tmpCity.CITY_ID] = tmpCity;
        }
    },
	
	addCity : function(cityJSONObject/* :Object */)/* :void */{
		this.childNum += (this.cityes[cityJSONObject.CITY_ID] == null) ? 1 : 0;
		this.cityes[cityJSONObject.CITY_ID] = new CityVO(cityJSONObject);
	},
	
	getSelectedCities : function()/* :Array[City] */{
		var arr = [];
		for ( var pro in this.cityes) {
			if (this.cityes[pro].selected) {
				arr.push(this.cityes[pro]);
			}
		}
		return arr;
	},
	
	getSelectedCityIds : function()/* :Array[String] */{
		var arr = [];
		for ( var pro in this.cityes) {
			if (this.cityes[pro].selected) {
				arr.push(this.cityes[pro].CITY_ID);
			}
		}
		return arr;
	},
	
	selectAllCities : function( b ) {
		for ( var pro in this.cityes) {
			this.cityes[pro].selected = b;
		}
	}	
});