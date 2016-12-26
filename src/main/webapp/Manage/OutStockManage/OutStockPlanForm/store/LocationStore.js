Ext.define('LocationModel', {
		extend : 'Ext.data.Model',
		idProperty:'location_pk',
		fields : [{
					name : 'location_pk',
					type : 'string'
				}, {
					name : 'fk_goods_pk',
					type : 'string'
				},{
					name : 'sum_count',
					type : 'string'
				}, 
				{
					name : 'location_name',
					type : 'string'
				}
				]
	});

var LocationStore=Ext.create('Ext.data.Store', {
	storeId : 'LocationStore',
	autoLoad:true,//自动加载，页面打开后不需要调用store.load()
	//fields : ['goods_pk','fk_customer_pk', 'goods_name', 'goods_number','goods_type','goods_price','goods_model_count','goods_standard_weight','goods_weight_remark','goods_fact_density','goods_moldel_cycle','goods_material_type','goods_pack_type','goods_pack1_type','goods_pack1_count','goods_pack1_description','goods_pack2_type','goods_pack2_count','goods_pack2_description','goods_location1','goods_location2','goods_location_temp','goods_location_description','goods_model_position','goods_unit','goods_unit_cube','goods_unit_tonne','goods_unit_square','goods_unit_tower','goods_create_date','goods_update_date','goods_pack_plasticize'],
	model : 'LocationModel',
  	totalProperty: 'totalCount',
    baseParams: {
        start: 0,
        limit: 20
    },
	proxy : {
		type : 'ajax',
	 	url: '/WebWms/outStockPlanContent/cbb_list.action', //保存
		method:'post',
		reader : {
			type : 'json',
			root:'rows'
			//rootProperty : 'users'
		}
	}
});