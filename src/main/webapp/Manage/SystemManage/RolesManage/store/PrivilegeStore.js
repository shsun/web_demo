/**
 * 
 */
 Ext.define('PrivilegeModel', {
		extend : 'Ext.data.Model',
		idProperty:'privilege_pk',
		fields : [{
					name : 'privilege_pk',
					type : 'string',
					mapping:'id'
				}, {
					name : 'privilege_name',
					type : 'string',
					mapping:'text'
				},{
					name : 'privilege_url',
					type : 'string',
					mapping:'url'
				},{
					name : 'privilege_icon',
					type : 'string',
					mapping:'ico'
				},{
					name : 'privilege_parent',
					type : 'string'
				}
				]
	});

var PrivilegeStore=	 Ext.create('Ext.data.Store', {
	storeId : 'PrivilegeStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	model : 'PrivilegeModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
		url : '/WebWms/privilege/list_menu.action',
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});