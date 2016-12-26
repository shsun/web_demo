Ext.require([ 'Ext.data.*', 'Ext.grid.*', 'Ext.util.*', 'Ext.tip.*' ]);

var gridwindow = Ext
		.create(
				'Ext.grid.Panel',
				{
					store : OutStockFormContentStore,
					layout : 'fit',
					id : 'listwindow',
					stripeRows : true,// 斑马线效果
					// forceFit: true, //列表宽度自适应
					height : 400,
					width : 1150,
					// invalidateScrollerOnRefresh: false,//刷新数据时不改变滚动条的位置
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
					columns : [
							{// 行号
								text : '序号',
								xtype : 'rownumberer',
								width : 60,
								align : 'center',
								sortable : false
							},
							{
								text : '基本信息',
								// dataIndex : '',
								align : 'center',
								columns : [
										{
											text : '货物编码',
											dataIndex : 'fk_goods_pk',
											align : 'center',
											field : {
												xtype : 'combobox',
												typeAhead : true,
												triggerAction : 'all',
												queryMode : 'local',
												selectOnTab : true,
												store : 'GoodsStore',
												lazyRender : true,
												triggerAction : 'all',
												listeners : {
													select : function(combox,
															record, index) {

														LocationStore
																.load({
																	params : {
																		start : 0,
																		limit : 20,
																		fk_goods_pk : combox.value
																	}
																});
														// alert("ss");
													}
												},
												displayField : 'goods_number',
												valueField : 'goods_pk'
											},
											renderer : function(value,
													metadata, record) {
												var index = GoodsStore.find(
														'goods_pk', value);
												if (index != -1) {
													return GoodsStore
															.getAt(index).data.goods_number;
												}
												return value;
											},

										},
										{
											text : '客户名称',
											dataIndex : 'fk_customer_pk',
											align : 'center',
											field : {
												xtype : 'combobox',
												typeAhead : true,
												triggerAction : 'all',
												queryMode : 'local',
												selectOnTab : true,
												store : 'CustomerStore',
												lazyRender : true,
												displayField : 'customer_name',
												valueField : 'customer_pk'
											},
											renderer : function(value,
													metadata, record) {
												var index = CustomerStore.find(
														'customer_pk', value);
												if (index != -1) {
													return CustomerStore
															.getAt(index).data.customer_name;
												}
												return value;
											}
										},

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
										}, {
											dataIndex : 'delivery_date',
											align : 'center',
											text : '交货时间',
											editor : {
												allowBlank : true
											}
										} ]
							},

							{
								text : '库存分析',
								// dataIndex : '',
								align : 'center',
								columns : [
										{
											dataIndex : '',
											align : 'center',
											text : '总计划',
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

										}, {
											dataIndex : 'already_count',
											align : 'center',
											text : '已出库',
											editor : {
												allowBlank : true
											}
										}

								]
							},
							{
								text : '出库单制作',
								// dataIndex : '',
								align : 'center',
								columns : [
										{
											dataIndex : 'outstock_count1',
											align : 'center',
											text : '出库数量',
											editor : {
												allowBlank : true
											}
										},

										// {
										// dataIndex : 'fk_location_pk1',
										// align : 'center',
										// text : '出库位置',
										// editor : {
										// allowBlank : true
										// }
										// }
										{
											text : '出库位置',
											dataIndex : 'fk_location_pk1',
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
										},
										{
											dataIndex : 'outstock_count2',
											align : 'center',
											text : '出库数量',
											editor : {
												allowBlank : true
											}
										},
										{
											text : '出库位置',
											dataIndex : 'fk_location_pk2',
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

										} ]
							},

							{
								text : '交货时间及数量',
								// dataIndex : '',
								align : 'center',
								columns : [
										{

											dataIndex : 'delivery_time8_count',
											align : 'center',
											text : '8',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'delivery_time9_count',
											align : 'center',
											text : '9',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'delivery_time11_count',
											align : 'center',
											text : '11',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'delivery_time13_count',
											align : 'center',
											text : '13',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'delivery_time15_count',
											align : 'center',
											text : '15',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'delivery_time16_count',
											align : 'center',
											text : '16',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'delivery_time18_count',
											align : 'center',
											text : '18',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'delivery_time20_count',
											align : 'center',
											text : '20',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'outstockplancontent_count',
											align : 'center',
											text : '顺线',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'outstockplancontent_damage',
											align : 'center',
											text : '备损',
											editor : {
												allowBlank : true
											}
										},
										{
											dataIndex : 'outstockplancontent_other',
											align : 'center',
											text : '其他',
											editor : {
												allowBlank : true
											}
										},
										{
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
										} ]
							}

					],
					plugins : [// grid可编辑插件
					Ext.create('Ext.grid.plugin.CellEditing', {
						clicksToEdit : 2
					// 2双击可编辑1单击可编辑
					}) ],
					bbar : new Ext.PagingToolbar({
						xtype : 'paging',
						height : '30',
						store : 'OutStockFormContentStore', // 主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。
						// store中的load函数中的pagesize设置数据显示的实际条数。
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

var formwindow = new Ext.form.FormPanel({
	height : 130,
	width : '100%',
	items : [ {
		xtype : 'fieldset',
		title : '<style="height:20; width:20;">查询条件',
		height : 80,
		width : '100%',
		layout : "vbox",
		autoWidth : true,
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
				text : '客户编号',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户编号',
				name : 'customer.customer_number'
			}, {
				xtype : 'label',
				width : 80,
				text : '客户姓名',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户姓名',
				name : 'customer.customer_name'
			}, {
				xtype : 'label',
				width : 80,
				text : '客户邮箱',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户邮箱',
				name : 'customer.customer_email'
			}, {
				xtype : 'label',
				width : 80,
				text : '客户电话',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户电话',
				name : 'customer.customer_telephone'
			}, ]
		}, {
			xtype : 'container',
			height : 30,
			layout : 'hbox',
			layoutConfig : {
				align : 'middle'
			},
			items : [ {
				xtype : 'label',
				width : 80,
				text : '客户手机',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户手机',
				name : 'customer.customer_mobilephone'
			}, {
				xtype : 'label',
				width : 80,
				text : '客户地址',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户地址',
				name : 'customer.customer_address'
			}, {
				xtype : 'label',
				width : 80,
				text : '客户联系人',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户联系人',
				name : 'customer.fk_linkman_pk'
			}, {
				xtype : 'label',
				width : 80,
				text : '客户备注',
				style : 'text-align:center;margin-left:10px;'
			}, {
				xtype : 'textfield',
				emptyText : '请输入客户备注',
				name : 'customer.customer_remark'
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
		} , {
			xtype : 'button',
			width : 100,
			height : 30,
			text : '出库确认',
			style : 'margin-left:25px;',
			icon : "../../../../Images/btnimg/excel_imports.png",
			handler : 'win_sure',
			scope : this
		} ]
	} ]
});

// 创建panel
var wind = new Ext.Window({
	title : '出库 ',
	// id:'panel',
	closeAction : 'hide',
	modal : true,
	// maximizable: true,
	// height:500,
	layout : 'vbox',
	layoutConfig : {
		align : 'middle'
	},
	autoHeight : true,
	autoWidth : true,
	items : [ formwindow, gridwindow ]

// formwindow,gridwindow
});

// 添加一个空行
var win_add = function(btn) {
	// alert(ProductionPlanFormContentStore,ProductionPlanFormContentModel);
	var r = Ext.create(OutStockFormtContentModel, {});
	Ext.getCmp('listwindow').getStore().insert(0, r);
};

// 保存数据
var win_save = function(btn) {
	alert("save");

	var records = gridwindow.getStore().getUpdatedRecords();// 获取修改的行的数据
	var newRecords = gridwindow.getStore().getNewRecords();// 获得新增行的数据
	// 保存修改数据
	if (records.length > 0) {
		Ext.Msg.alert("修改数据", "修改数据");
		var jsonArray = [];
		for (var i = 0; i < records.length; i++) {
			jsonArray.push(records[i].data);

		}
		Ext.Msg.alert("修改数据", Ext.encode(jsonArray));
		if (jsonArray.length > 0) {
			Ext.Ajax.request({
				url : '/WebWms/productionPlanFormContent/save.action', // 保存
				method : 'POST',
				params : {
					datas : Ext.encode(jsonArray)
				},
				success : function(response, options) {
					var res = response.responseText;
					if (res == null) {
						Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
						return;
					} else {
						Ext.Msg.alert("提示信息", "保存成功！");
						gridwindow.getStore().reload();// 添加成功后刷新数据
					}
				},
				failure : function() {
					Ext.Msg.alert("提示信息", "出现异常！");
				}
			});
		}

	}
	// 保存新增的数据
	if (newRecords.length > 0) {
		Ext.Msg.alert("新增数据", "新增数据");
		var jsonArray = [];
		for (var i = 0; i < newRecords.length; i++) {
			jsonArray.push(newRecords[i].data);
		}
		Ext.Msg.alert("新增数据", Ext.encode(jsonArray));
		if (jsonArray.length > 0) {
			Ext.Ajax.request({
				url : '/WebWms/productionPlanFormContent/save.action', // 保存
				method : 'POST',
				params : {
					datas : Ext.encode(jsonArray)
				},
				success : function(response, options) {
					var res = response.responseText;
					if (res == null) {
						Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
						return;
					} else {
						Ext.Msg.alert("提示信息", "保存成功！");
						gridwindow.getStore().reload();// 添加成功后刷新数据
					}
				},
				failure : function() {
					Ext.Msg.alert("提示信息", "出现异常！");
				}
			});
		}

	}
};

// 删除数据
var win_del = function(btn) {
	var ids = "";
	var rowsSelectedModel = gridwindow.getSelectionModel(); // 记录在一个数据绑定组件内部被选择的记录
	var rowsSelected = rowsSelectedModel.getSelection(); // 返回一个当前被选择的记录的数组。
	var len = rowsSelected.length;
	if (len > 0) {
		// 选中多行
		for (var i = 0; i < len; i++) {
			ids += rowsSelected[i].get("outstockplancontent_pk") + ",";
		}
		Ext.Msg
				.show({
					title : '消息提示',
					message : '您确定删除数据?',
					buttons : Ext.Msg.YESNOCANCEL,
					icon : Ext.Msg.QUESTION,
					fn : function(btn) {// 用户点击交互后调用的函数，btn是指用户点了那个按钮
						if (btn === 'yes') {
							Ext.Ajax
									.request({
										url : '/WebWms/productionPlanFormContent/delete.action', // 保存
										params : {
											'ids' : ids
										},
										success : function(response, options) {
											var res = response.responseText;
											if (res == null) {
												Ext.Msg.alert("提示信息", "错误消息",
														"出现异常！");
												return;
											} else {
												Ext.Msg.alert("提示信息", "删除成功！");
												gridwindow.getStore().reload();// 成功后刷新数据
											}
										},
										failure : function() {
											Ext.Msg.alert("提示信息", "删除出现异常！");
										}
									});
						} else if (btn === 'no') {
							return null;
						} else {
							return null;
						}
					}
				});
	} else {
		Ext.Msg.alert("提示", "未勾选数据");
	}
};

var outstockwd;
//出库操作弹出
var win_sure = function(btn)
{
	var rowsSelectedModel = gridwindow.getSelectionModel(); // 记录在一个数据绑定组件内部被选择的记录
	var rowsSelected = rowsSelectedModel.getSelection(); // 返回一个当前被选择的记录的数组。
	Ext.getCmp('listwindow1').getStore().insert(0,rowsSelected);
	outstockwd = wind1;
	outstockwd.show();
	outstockwd.maximize();
};
