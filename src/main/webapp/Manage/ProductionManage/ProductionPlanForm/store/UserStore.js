Ext.define('UserModel', {
		extend : 'Ext.data.Model',
		idProperty:'user_pk',
		fields : [{
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
				}]
	});

var UserStore=	 Ext.create('Ext.data.Store', {
	storeId : 'UserStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['user_pk','user_name', 'user_sex', 'user_birthday','user_number','user_password','user_phone','user_email','fk_roles_pk','user_intime','fk_station_pk'],
	model : 'UserModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
		url : '/WebWms/user/cbb_list.action',
		//url : 'http://localhost:8080/ProduceWms/list.action',
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});