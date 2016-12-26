Ext.define('GoodsModel', {
		extend : 'Ext.data.Model',
		idProperty:'goods_pk',
		fields : [{
					name : 'goods_pk',
					type : 'string'
				}, {
					name : 'fk_customer_pk',
					type : 'string'
				},{
					name : 'goods_name',
					type : 'string'
				}, 
				{
					name : 'goods_number',
					type : 'string'
				},
				{
					name:'goods_type',
					type:'string'
				},
				{
					name:'goods_price',
					type:'string'
				},
				{
					name:'goods_model_count',
					type:'string'
				},
				{
					name:'goods_standard_weight',
					type:'string'
				},
				{
					name:'goods_weight_remark',
					type:'string'
				},
				{
					name:'goods_fact_density',
					type:'string'
				},
				{
					name:'goods_moldel_cycle',
					type:'string'
				},
				{
					name:'goods_material_type',
					type:'string'
				},
				{
					name:'goods_material_parenttype',
					type:'string'
				},
				{
					name:'goods_pack_type',
					type:'string'
				}
				,
				{
					name:'goods_pack1_type',
					type:'string'
				},
				{
					name:'goods_pack1_count',
					type:'string'
				},
				{
					name:'goods_pack1_description',
					type:'string'
				},
				{
					name:'goods_pack2_type',
					type:'string'
				},
				{
					name:'goods_pack2_count',
					type:'string'
				},
				{
					name:'goods_pack2_description',
					type:'string'
				},
				{
					name:'goods_location1',
					type:'string'
				},
				{
					name:'goods_location2',
					type:'string'
				},
				{
					name:'goods_location_temp',
					type:'string'
				},
				{
					name:'goods_location_description',
					type:'string'
				},{
					name:'goods_model_position',
					type:'string'
				},
				{
					name:'goods_unit',
					type:'string'
				},
				{
					name:'goods_unit_cube',
					type:'string'
				},
				{
					name:'goods_unit_tonne',
					type:'string'
				},
				{
					name:'goods_unit_square',
					type:'string'
				},
				{
					name:'goods_unit_tower',
					type:'string'
				},
				{
					name:'goods_create_date',
					type:'string'
				},
				{
					name:'goods_update_date',
					type:'string'
				},
				{
					name:'goods_pack_plasticsize',
					type:'string'
				}
				]
	});

var GoodsStore=Ext.create('Ext.data.Store', {
	storeId : 'GoodsStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['goods_pk','fk_customer_pk', 'goods_name', 'goods_number','goods_type','goods_price','goods_model_count','goods_standard_weight','goods_weight_remark','goods_fact_density','goods_moldel_cycle','goods_material_type','goods_pack_type','goods_pack1_type','goods_pack1_count','goods_pack1_description','goods_pack2_type','goods_pack2_count','goods_pack2_description','goods_location1','goods_location2','goods_location_temp','goods_location_description','goods_model_position','goods_unit','goods_unit_cube','goods_unit_tonne','goods_unit_square','goods_unit_tower','goods_create_date','goods_update_date','goods_pack_plasticize'],
	model : 'GoodsModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
	 	url: '/WebWms/goods/list.action', //保存
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});