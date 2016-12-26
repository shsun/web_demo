Ext.define('CustomerModel', {
		extend : 'Ext.data.Model',
		idProperty:'customer_pk',
		fields : [{
					name : 'customer_pk',
					type : 'string'
				}, {
					name : 'customer_name',
					type : 'string'
				},{
					name : 'customer_address',
					type : 'string'
				}, 
				{
					name : 'customer_remark',
					type : 'string'
				},
					{
					name : 'customer_telephone',
					type : 'string'
				},
				{
					name : 'customer_mobilephone',
					type : 'string'
				},
					{
					name : 'customer_email',
					type : 'string'
				},
				{
					name:'customer_number',
					type:'string'
				},
				{
					name:'fk_linkman_pk',
					type:'string'
				}]
	});

var CustomerStore=	 Ext.create('Ext.data.Store', {
	storeId : 'CustomerStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['customer_pk','customer_name', 'customer_address', 'customer_remark','customer_telephone','customer_mobilephone','customer_email','customer_number','fk_linkman_pk'],
	model : 'CustomerModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
		url : '/WebWms/customer/list.action',
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'customers'
		}
	}
});