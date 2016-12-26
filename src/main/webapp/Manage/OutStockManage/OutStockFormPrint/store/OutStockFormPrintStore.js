Ext.define('OutStockFormModel', {
		extend : 'Ext.data.Model',
		idProperty:'outstockform_pk',
		fields : [{
					name : 'outstockform_pk',
					type : 'string'
				}, {
					name : 'outstockform_number',
					type : 'string'
				},{
					name : 'outstockform_date',
					type : 'string'
				}, 
				{
					name : 'fk_user_pk',
					type : 'string'
				}, 
				{
					name : 'outstockform_remark',
					type : 'string'
				}]
	});

var OutStockFormStore=	 Ext.create('Ext.data.Store', {
	storeId : 'OutStockFormStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['customer_pk','customer_name', 'customer_address', 'customer_remark','customer_telephone','customer_mobilephone','customer_email','customer_number','fk_linkman_pk'],
	model : 'OutStockFormModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
		url : '/WebWms/outStockForm/list.action',
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'customers'
		}
	}
});