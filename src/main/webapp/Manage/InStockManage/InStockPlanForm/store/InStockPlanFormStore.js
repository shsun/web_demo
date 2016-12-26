Ext.define('InStockPlanFormModel', {
		extend : 'Ext.data.Model',
		idProperty:'instockplanform_pk',
		fields :[{
					name : 'instockplanform_pk',
					type : 'string'
				}, {
					name : 'instockplanform_number',
					type : 'string'
				},{
					name : 'instockplanform_state',
					type : 'string'
				}, 
				{
					name : 'instockplanform_remark',
					type : 'string'
				},
					{
					name : 'instockplanform_date',
					type : 'date'
				},
					{
					name : 'fk_user_pk',
					type : 'string'
				}]
	});

var InStockPlanFormStore=Ext.create('Ext.data.Store', {
	storeId : 'InStockPlanFormStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['location_pk','location_number', 'location_name', 'location_remark','location_type','fk_area_pk'],
	model : 'InStockPlanFormModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
	 	url: '/WebWms/instockplanform/list_view.action', //保存
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});