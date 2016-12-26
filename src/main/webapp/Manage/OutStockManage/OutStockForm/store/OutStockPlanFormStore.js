Ext.define('OutStockModel', {
		extend : 'Ext.data.Model',
		idProperty:'outstockplanform_pk',
		fields :[{
					name : 'outstockplanform_pk',
					type : 'string'
				}, {
					name : 'outstockplanform_number',
					type : 'string'
				},{
					name : 'outstockplanform_state',
					type : 'string'
				}, 
				{
					name : 'outstockplanform_remark',
					type : 'string'
				},
					{
					name : 'outstockplanform_date',
					type : 'date'
				},
					{
					name : 'fk_user_pk',
					type : 'string'
				}]
	});

var OutStockPlanFormStore=Ext.create('Ext.data.Store', {
	storeId : 'OutStockPlanFormStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['location_pk','location_number', 'location_name', 'location_remark','location_type','fk_area_pk'],
	model : 'OutStockModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
		url : '/WebWms/outstockplanform/list.action',
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});