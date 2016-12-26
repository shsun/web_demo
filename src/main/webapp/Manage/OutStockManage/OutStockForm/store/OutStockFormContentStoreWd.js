Ext.define('OutStockFormtContentModelWd', {
	extend : 'Ext.data.Model',
	idProperty : 'outstockplancontent_pk',
	fields : [ {
		name : 'outstockplancontent_pk',
		type : 'string'
	}, {
		name : 'fk_goods_pk',
		type : 'string'
	}, {
		name : 'fk_customer_pk',
		type : 'string'
	}, {
		name : 'delivery_location',
		type : 'string'
	}, {
		name : 'delivery_date',
		type : 'string'
	}, {
		name : 'outstockplancontent_count',
		type : 'int'
	}, {
		name : 'outstockplancontent_damage',
		type : 'int'
	}, {
		name : 'outstockplancontent_other',
		type : 'int'
	}, {
		name : 'fk_outstockform_pk',
		type : 'string'
	}, {
		name : 'delivery_time8_count',
		type : 'int'
	}, {
		name : 'delivery_time9_count',
		type : 'int'
	}, {
		name : 'delivery_time13_count',
		type : 'int'
	}, {
		name : 'delivery_time11_count',
		type : 'int'
	}, {
		name : 'delivery_time15_count',
		type : 'int'
	}, {
		name : 'delivery_time16_count',
		type : 'int'
	}, {
		name : 'delivery_time18_count',
		type : 'int'
	}, {
		name : 'delivery_time20_count',
		type : 'int'
	},//already_count
	{	
		name : 'already_count',
		type : 'int'
	}
	, {
		name : 'outstock_count1',
		type : 'int'
	}, {
		name : 'fk_location_pk1',
		type : 'string'
	}, {
		name : 'outstock_count2',
		type : 'int'
	}, {
		name : 'fk_location_pk2',
		type : 'string'
	}, {
		name : 'delivery_time20_count',
		type : 'int'
	}, {
		name : 'outstockcount_sum',
		type : 'int'
	},
	{
		//already_count
		name : 'already_count',
		type : 'int'
	}
	]
});

var OutStockFormContentStoreWd = Ext
		.create(
				'Ext.data.Store',
				{
					storeId : 'OutStockFormContentStoreWd',
					autoLoad : true,// 自动加载，页面打开后不需要调用store.load()
					// fields : ['goods_pk','fk_customer_pk', 'goods_name',
					// 'goods_number','goods_type','goods_price','goods_model_count','goods_standard_weight','goods_weight_remark','goods_fact_density','goods_moldel_cycle','goods_material_type','goods_pack_type','goods_pack1_type','goods_pack1_count','goods_pack1_description','goods_pack2_type','goods_pack2_count','goods_pack2_description','goods_location1','goods_location2','goods_location_temp','goods_location_description','goods_model_position','goods_unit','goods_unit_cube','goods_unit_tonne','goods_unit_square','goods_unit_tower','goods_create_date','goods_update_date','goods_pack_plasticize'],
					model : 'OutStockFormtContentModelWd',
					totalProperty : 'totalCount',
					baseParams : {
						start : 0,
						limit : 20
					},
					proxy : {
						type : 'ajax',
						//url : '/WebWms/outStockFormContent/list.action', // 保存
						method : 'post',
						reader : {
							type : 'json',
							root : 'rows'
						// rootProperty : 'users'
						}
					}
				});