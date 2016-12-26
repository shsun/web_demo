/**
 * 马玉德
 * 2015-6-12
 */
Ext.define('InStockFormContentModel', {
		extend : 'Ext.data.Model',
		idProperty:'instockplancontent_pk',
		fields : [{
					name : 'instockplancontent_pk',
					type : 'string'
				}, {
					name : 'instockplancontent_count',
					type : 'string'
				}
				, {
					name : 'instockplancontent_device',
					type : 'string'
				}
				,{
					name : 'instockplancontent_way',
					type : 'string'
				}, 
				{
					name:'customer_name',
					type:'string'
				},
				{
					name:'fk_goods_pk',
					type:'string'
				},
				{
					name:'goods_count',
					type:'string'
				},
				{
					name:'goods_location',
					type:'string'
				}
			]
	});

var InStockFormContentStore=Ext.create('Ext.data.Store', {
	storeId : 'InStockFormContentStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	model : 'InStockFormContentModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
	 	url: '', //保存
		method:'post',
		reader : {
			type :'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});