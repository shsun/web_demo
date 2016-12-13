/**
 * @usage
 * 
 * // 
 * GeoSingleton.getInstance(cityArrayOfChina).getAllCitiesByProvinceId( id );
 * 
 * // 
 * var provinceArray = GeoSingleton.getInstance(cityArrayOfChina).provinces;
 * for(var i=0; i<provinceArray.length;i++){ 
 * 		var selectedCityArray =
 * 		provinceArray[i].getSelectedCities;
 * }
 * 
 * 
 * // ------------------------------------------------------------------------------------------
 * 
 * // select all citis of certain province
 * GeoSingleton.getInstance(cityArrayOfChina).provinces[province_id].selectAllCities( true );
 * 
 * // get ids of selected cities. 
 * GeoSingleton.getInstance(cityArrayOfChina).provinces[province_id].getSelectedCityIds( );
 * 
 */
var City = {
	createNew : function(cityJSONObject/* :Object */)/* :City */{
		return {
			'CITY_NAME' : cityJSONObject.CITY_NAME,
			'CITY_ID' : cityJSONObject.CITY_ID,
			'PROVINCE_ID' : cityJSONObject.PROVINCE_ID,
			'selected' : false
		};
	}
};
var Province = {
	/**
	 * cityJSONObject
	 */
	createNew : function(cityJSONObject/* :Object */)/* :Province */{
		var o = {
			'PROVINCE_NAME' : cityJSONObject.PROVINCE_NAME,
			'PROVINCE_ID' : cityJSONObject.PROVINCE_ID,
			'cityes' : {}
		};
		o.addCity = function(cityJSONObject/* :Object */)/* :void */{
			this.childNum += (this.cityes[cityJSONObject.CITY_ID] == null) ? 1 : 0;
			this.cityes[cityJSONObject.CITY_ID] = City.createNew(cityJSONObject);
		};
		o.getSelectedCities = function()/* :Array[City] */{
			var arr = [];
			for ( var pro in this.cityes) {
				if (this.cityes[pro].selected) {
					arr.push(this.cityes[pro]);
				}
			}
			return arr;
		};
		o.getSelectedCityIds = function()/* :Array[String] */{
			var arr = [];
			for ( var pro in this.cityes) {
				if (this.cityes[pro].selected) {
					arr.push(this.cityes[pro].CITY_ID);
				}
			}
			return arr;
		}
		o.selectAllCities = function( b ) {
			for ( var pro in this.cityes) {
				this.cityes[pro].selected = b;
			}
		}
		return o;
	}
};

var GeoSingleton = (function() {
	var instantiated;
	function initialize(cityArrayOfChina/* :Array */) {
		var o = {
			'provinces' : {}
		};
		// parse the cityArrayOfChina
		for ( var i = 0; i < cityArrayOfChina.length; i++) {
			var tmpCityJSONObject = cityArrayOfChina[i];
			var tmpProvince = o.provinces[tmpCityJSONObject.PROVINCE_ID];
			if (tmpProvince == null) {
				tmpProvince = Province.createNew(tmpCityJSONObject);
			}
			if (tmpProvince.PROVINCE_ID == tmpCityJSONObject.PROVINCE_ID) {
				tmpProvince.addCity(tmpCityJSONObject);
			}
			o.provinces[tmpCityJSONObject.PROVINCE_ID] = tmpProvince;
		}
		o.getAllCitiesByProvinceId = function(id/* :String */)/* :Array */{
			return o[id];
		};
		return o;
	}
	// 
	return {
		getInstance : function(cityArrayOfChina/* :Array */) {
			if (!instantiated) {
				instantiated = initialize(cityArrayOfChina);
			}
			return instantiated;
		}
	};
})();
