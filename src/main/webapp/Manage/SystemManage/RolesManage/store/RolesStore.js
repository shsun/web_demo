Ext.define('RolesModel', {
		extend : 'Ext.data.Model',
		idProperty:'roles_pk',
		fields : [{
					name : 'roles_pk',
					type : 'string'
				}, {
					name : 'roles_name',
					type : 'string'
				},{
					name : 'roles_remark',
					type : 'string'
				}
				]
	});

var RolesStore=	 Ext.create('Ext.data.Store', {
	storeId : 'RolesStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	model : 'RolesModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
		url : '/WebWms/roles/list.action',
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});