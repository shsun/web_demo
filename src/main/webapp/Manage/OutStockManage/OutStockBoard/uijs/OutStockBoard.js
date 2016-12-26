/**
 * 马玉德 2015-5-12 出库单
 */
Ext.require([ 'Ext.data.*', 'Ext.grid.*', 'Ext.tip.*' ]);

var gridpanel = Ext.create('Ext.grid.Panel', {
	// title : '入库计划单信息',
	store:OutStockBoardStore,
	layout : 'fit',
	id : 'list',
	stripeRows : true,// 斑马线效果
	//forceFit : true, // 列表宽度自适应
	invalidateScrollerOnRefresh: false,//刷新数据时不改变滚动条的位置
	selModel : Ext.create('Ext.selection.CheckboxModel'), // 每行前面加一个勾选框
	listeners : {
		'rowdblclick' : function(index,e) {
			//alert("gridwindow！"+gridwindow);
			//alert("选中行！");
			//alert("选中行index！"+index);
			//alert("选中行E！"+e);
			var rowsSelectedModel = gridwindow.getSelectionModel(); // 记录在一个数据绑定组件内部被选择的记录
			var rowsSelected = rowsSelectedModel.getSelection(); // 返回一个当前被选择的记录的数组。
			var len = rowsSelected.length;
			//alert("len"+len);
			var fk_goods_pk = rowsSelected[0].get("fk_goods_pk");
			//alert("fk_goods_pk:"+fk_goods_pk);
			LocationStore.load({
				params : {
					start : 0,
					limit : 20,
					fk_goods_pk : fk_goods_pk
				}
			});
		}
	},
	columns : [ {// 行号
		text : '序号',
		xtype : 'rownumberer',
		width : 60,
		align : 'center',
		sortable : false
	}
	, {
		dataIndex : 'fk_goods_pk',
		align : 'center',
		text : '货物编号',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'fk_customer_pk',
		align : 'center',
		text : '客户名称',
		editor : {
			allowBlank : true
		}
	}
	, 

	{
		text : '送货位置',
		dataIndex : 'fk_location_pk',
		align : 'center',
		field : {
			xtype : 'combobox',
			typeAhead : true,
			triggerAction : 'all',
			queryMode : 'local',
			selectOnTab : true,
			store : 'LocationStore',
			lazyRender : true,
			displayField : 'location_name',
			valueField : 'location_pk'
		},
		renderer : function(value,
				metadata, record) {
			var index = LocationStore.find(
					'location_pk', value);
			if (index != -1) {
				return LocationStore
						.getAt(index).data.location_name;
			}
			return value;
		}
	}
	, {
		dataIndex : 'outstockplancontent_damage',
		align : 'center',
		text : '交货日期',
		editor : {
			allowBlank : true
		}
	}, {

		dataIndex : 'delivery_time8_count',
		align : 'center',
		text : '8',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'delivery_time9_count',
		align : 'center',
		text : '9',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'delivery_time11_count',
		align : 'center',
		text : '11',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'delivery_time13_count',
		align : 'center',
		text : '13',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'delivery_time15_count',
		align : 'center',
		text : '15',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'delivery_time16_count',
		align : 'center',
		text : '16',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'delivery_time18_count',
		align : 'center',
		text : '18',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'delivery_time20_count',
		align : 'center',
		text : '20',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'outstockplancontent_count',
		align : 'center',
		text : '顺线',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'outstockplancontent_damage',
		align : 'center',
		text : '备损',
		editor : {
			allowBlank : true
		}
	}, {
		dataIndex : 'outstockplancontent_other',
		align : 'center',
		text : '其他',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : 'outstockcount_sum',
		align : 'center',
		text : '合计',
		renderer : function(value,
				metadata, record) {
			var sumValue = 0;
			sumValue = record
					.get("delivery_time8_count")
					+ record
							.get("delivery_time9_count")
					+ record
							.get("delivery_time11_count")
					+ record
							.get("delivery_time13_count")
					+ record
							.get("delivery_time15_count")
					+ record
							.get("delivery_time16_count")
					+ record
							.get("delivery_time18_count")
					+ record
							.get("delivery_time20_count")
					+ record
							.get("outstockplancontent_count")
					+ record
							.get("outstockplancontent_damage")
					+ record
							.get("outstockplancontent_other");
			value = sumValue;
			return value;
		}
	}
	
	, {
		dataIndex : 'already_count',
		align : 'center',
		text : '已出库',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : 'noStockCount',
		align : 'center',
		text : '未出库',
		renderer : function(value,
				metadata, record) {
			var sumValue = 0;
			sumValue = record
					.get("outstockcount_sum")- record.get("already_count")
					
			value = sumValue;
			return value;
		}
	}
	, {
		dataIndex : 'outstockplancontent_other',
		align : 'center',
		text : '缺货（现库存-未出库数量）',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : 'goods_location1',
		align : 'center',
		text : '库存位置',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : '',
		align : 'center',
		text : '库存数量',
        
	}
	, {
		dataIndex : 'goods_location2',
		align : 'center',
		text : '库存位置',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : 'goods_location2count',
		align : 'center',
		text : '库存数量',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : 'goods_location_temp',
		align : 'center',
		text : '库存位置',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : 'goods_location_tempcount',
		align : 'center',
		text : '库存数量',
		editor : {
			allowBlank : true
		}
	}
	, {
		dataIndex : 'outstockcount_sum',
		align : 'center',
		text : '入库计划',
		renderer : function(value,
				metadata, record) {
			var sumValue = 0;
			sumValue = record
					.get("delivery_time8_count")
					+ record
							.get("delivery_time9_count")
					+ record
							.get("delivery_time11_count")
					+ record
							.get("delivery_time13_count")
					+ record
							.get("delivery_time15_count")
					+ record
							.get("delivery_time16_count")
					+ record
							.get("delivery_time18_count")
					+ record
							.get("delivery_time20_count")
					+ record
							.get("outstockplancontent_count")
					+ record
							.get("outstockplancontent_damage")
					+ record
							.get("outstockplancontent_other");
			value = sumValue;
			return value;
		}
	}
	, {
		dataIndex : 'already_count',
		align : 'center',
		text : '已入库数',
		editor : {
			allowBlank : true
		}
	}
	],
	plugins : [// grid可编辑插件
	Ext.create('Ext.grid.plugin.CellEditing', {
		clicksToEdit : 2
	// 2双击可编辑1单击可编辑
	// RowEditing
	// CellEditing
	}) ],
	bbar : new Ext.PagingToolbar({
		xtype : 'paging',
		height : '30',
		store : 'OutStockBoardStore', // 主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。					// store中的load函数中的pagesize设置数据显示的实际条数。
		displayMsg : '{0}--{1},共{2}条记录',
		emptyMsg : '没有记录',
		displayInfo : true,
		beforePageText : '第',
		afterPageText : '页，共{0}页',
		firstText : '首页',
		laseText : '末页',
		nextText : '下页',
		prevText : '上页'

	})
});

var formaction = new Ext.form.FormPanel({
	id : 'formconditions',
	height : 130,
	items : [ {
		xtype : 'fieldset',
		id : 'fieldset1',
		title : '<style="height:20; width:20;">查询条件',
		height : 80,
		layout : "vbox",
		items : [ {
			xtype : 'container',
			height : 30,
			layout : 'hbox',
			layoutConfig : {
				align : 'middle'
			},
			items : [ {
				xtype : 'label',
				width : 80,
				text : '入库计划单号',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入出库计划单号',
				name : 'instockplanform_number'
			}, {
				xtype : 'label',
				width : 80,
				text : '创单人员',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入创单人员',
				name : 'fk_user_pk'
			}, {
				xtype : 'label',
				width : 80,
				text : '创单日期',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入创单日期',
				name : 'instockplanform_date'
			}, {
				xtype : 'label',
				width : 80,
				text : '状态',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请选择状态',
				name : 'instockplanform_state'
			} ]
		} ]
	}, {
		xtype : 'container',
		height : 50,
		layout : 'column',
		items : [ {
			xtype : 'button',
			width : 100,
			height : 30,
			text : '查询',
			icon : "../../../../Images/btnimg/select.png",
			handler : 'select',
			scope : this
		}]
	} ]
});

//创建panel	
var panel = new Ext.Panel({
				//title : '用户信息管理',
				id:'panel',
				autoHeight:true,
				items : [formaction,gridpanel]
	});
//初始化界面					
Ext.onReady(function () {	
	 panel.render(Ext.getBody());
    //调整窗口的高度
     Ext.getCmp('list').setHeight(document.documentElement.clientHeight-130);//动态设置窗口的大小
});

//界面大小动态调整
Ext.EventManager.onWindowResize(function(){ 
    fillBrowser(panel);
});

 function fillBrowser(obj){
 	if(obj != null){
 	    obj.setWidth(document.body.clientWidth);
    	    obj.setHeight(document.body.clientHeight);
 	}
 }
 
 //添加一个空行
var add=function (btn) {
    var r = Ext.create('GoodsModel', {
    });
    Ext.getCmp('list').getStore().insert(0, r);
};

//查询数据
var select=function(btn)
{
	//Ext.Msg.alert("查询",Ext.encode(formaction.getForm().getValues()));
	Ext.getCmp("list").store.load({ 
	    params: formaction.getForm().getValues()//获取form表单的值
	});
};
