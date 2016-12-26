/**
 * 马玉德
 * 入库计划单内容store
 */
Ext.define('InStockPlanFormContentModel', {
		extend : 'Ext.data.Model',
idProperty:'instockplancontent_pk',
		fields : [{
					name : 'instockplancontent_pk',
					type : 'string'
				}, {
					name : 'instockactualcontent_count',
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
					name:'fk_instockplanform_pk',
					type:'string'
				},
				{
					name:'goods_count1',
					type:'string'
				},
				{
					name:'goods_location1',
					type:'string'
				},
				{
					name:'goods_count2',
					type:'string'
				},
				{
					name:'goods_location2',
					type:'string'
				},
				{
					name:'goods_count3',
					type:'string'
				},
				{
					name:'goods_location3',
					type:'string'
				},
				{
					name:'instockplancontent_remark',
					type:'string'
				}
		]
});

var InStockPlanFormContentStore=Ext.create('Ext.data.Store', {
	storeId : 'InStockPlanFormContentStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	model : 'InStockPlanFormContentModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
	 	url: '/WebWms/inStockPlanFormContent/list_instockplancontent.action', //保存
		method:'post',
		reader : {
			type :'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});