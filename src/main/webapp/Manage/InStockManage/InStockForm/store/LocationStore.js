Ext.define('LocationModel', {
		extend : 'Ext.data.Model',
		idProperty:'location_pk',
		fields :[{
					name : 'location_pk',
					type : 'string'
				}, {
					name : 'location_number',
					type : 'string'
				},{
					name : 'location_name',
					type : 'string'
				}, 
				{
					name : 'location_remark',
					type : 'string'
				},
					{
					name : 'location_type',
					type : 'string'
				},
					{
					name : 'fk_area_pk',
					type : 'string'
				}]
	});

var LocationStore=	 Ext.create('Ext.data.Store', {
	storeId : 'LocationStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['location_pk','location_number', 'location_name', 'location_remark','location_type','fk_area_pk'],
	model : 'LocationModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 25
    },
	proxy : {
		type : 'ajax',
		url : '/WebWms/location/list.action',
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});