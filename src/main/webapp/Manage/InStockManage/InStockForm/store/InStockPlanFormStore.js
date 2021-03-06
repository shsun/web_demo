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
				},
				{
					name : 'user_pk',
					type : 'string'
				}, {
					name : 'user_name',
					type : 'string'
				},{
					name : 'user_sex',
					type : 'string'
				}, 
				{
					name : 'user_birthday',
					type : 'date'
				},
					{
					name : 'user_phone',
					type : 'string'
				},
					{
					name : 'user_email',
					type : 'string'
				},
				{
		         	name:'user_number',
					type:'string'
				},
				{
					name:'user_password',
					type:'string'
				},
				{
					name:'user_intime',
					type : 'date'
				},
				{
					name:'fk_roles_pk',
					type:'string'
				},
				{
					name:'fk_station_pk',
					type:'string'
				}
				]
	});

var InStockPlanFormStore=Ext.create('Ext.data.Store', {
	storeId : 'InStockPlanFormStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	model : 'InStockPlanFormModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
	 	url: '/WebWms/productionPlanForm/list_view.action', //保存
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});