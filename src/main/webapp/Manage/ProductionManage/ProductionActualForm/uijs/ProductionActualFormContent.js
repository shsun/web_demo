Ext.require([ 'Ext.data.*', 'Ext.grid.*', 'Ext.util.*', 'Ext.tip.*' ]);

var gridwindow = Ext.create('Ext.grid.Panel', {
	store : ProductionPlanFormContentStore,
	layout : 'fit',
	id : 'listwindow',
	stripeRows : true,// 斑马线效果
	// forceFit: true, //列表宽度自适应
	height : 400,
	width : 1150,
	// invalidateScrollerOnRefresh: false,//刷新数据时不改变滚动条的位置
	selModel : Ext.create('Ext.selection.CheckboxModel'), // 每行前面加一个勾选框
	columns : [ {// 行号
		text : '序号',
		xtype : 'rownumberer',
		width : 60,
		align : 'center',
		sortable : false
	}, {
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
			displayField : 'goods_number',
			valueField : 'goods_pk'
		},
		renderer : function(value, metadata, record) {
			var index = GoodsStore.find('goods_pk', value);
			if (index != -1) {
				return GoodsStore.getAt(index).data.goods_number;
			}
			return value;
		}
	}

	, {
		text : '计划数量',
		dataIndex : 'instockplancontent_count',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '生产实际数量',
		dataIndex : 'instockactualcontent_count',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '设备号',
		dataIndex : 'instockplancontent_device',
		align : 'center',
		editor : new Ext.form.TextField({
			allowBlank : false
		})
	}, {
		text : '计划时间',
		// dataIndex : '',
		align : 'center',
		columns : [ {
			dataIndex : 'instockplancontent_date1',
			align : 'center',
			text : '日期',
			editor : {
				allowBlank : true
			}
		}, {
			dataIndex : 'instockplancontent_time1',
			align : 'center',
			text : '时间',
			editor : {
				allowBlank : true
			}
		}, {
			dataIndex : 'instockplancontent_date2',
			align : 'center',
			text : '日期',
			editor : {
				allowBlank : true
			}
		}, {
			dataIndex : 'instockplancontent_time2',
			align : 'center',
			text : '时间',
			editor : {
				allowBlank : true
			}
		} ]
	}, {
		text : '包装方式',// 手动填写的
		dataIndex : 'instockplancontent_way',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '备注',
		dataIndex : 'instockplancontent_remark',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '客户名称',// 大类
		dataIndex : 'customer_name',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '原料类型',//
		dataIndex : 'goods_material_type',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '单模个数',// 单模个数
		dataIndex : 'goods_model_count',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '成型周期',
		dataIndex : 'goods_moldel_cycle',
		align : 'center',
		editor : {
			allowBlank : true
		}
	}, {
		text : '包装方式1',
		dataIndex : '',
		align : 'center',
		columns : [ {
			dataIndex : 'goods_pack1_type',
			align : 'center',
			text : '类型',
			editor : {
				allowBlank : true
			}
		}, {
			dataIndex : 'goods_pack1_count',
			align : 'center',
			text : '包装数量',
			editor : {
				allowBlank : true
			}
		}, {
			dataIndex : 'goods_pack1_description',
			align : 'center',
			text : '说明',
			editor : {
				allowBlank : true
			}
		} ]
	}, {
		text : '包装方式2',
		dataIndex : '',
		columns : [ {
			dataIndex : 'goods_pack2_type',
			align : 'center',
			text : '类型',
			editor : {
				allowBlank : true
			}
		}, {
			dataIndex : 'goods_pack2_count',
			align : 'center',
			text : '包装数量',
			editor : {
				allowBlank : true
			}
		}, {
			dataIndex : 'goods_pack2_description',
			align : 'center',
			text : '说明',
			editor : {
				allowBlank : true
			}
		} ]
	}, {
		text : '模具位置',
		align : 'center',
		dataIndex : 'goods_model_position',
		editor : {
			allowBlank : true
		}
	} ],
	plugins : [// grid可编辑插件
	Ext.create('Ext.grid.plugin.CellEditing', {
		clicksToEdit : 2
	// 2双击可编辑1单击可编辑
	}) ],
	bbar : new Ext.PagingToolbar({
		xtype : 'paging',
		height : '30',
		store : 'ProductionPlanFormContentStore', // 主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。
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
items : [{
			xtype : 'fieldset',
			title : '<style="height:20; width:20;">查询条件',
			height : 80,
			width : '100%',
			layout : "vbox",
			autoWidth : true,
			items : [{
						xtype : 'container',
						height : 30,
						layout : 'hbox',
						layoutConfig : {
							align : 'middle'
						},
						items : [{
									xtype : 'label',
									width : 80,
									text : '货物编码',
									style : 'text-align:center;margin-left:10px;'
								}, {
									xtype : 'textfield',
									emptyText : '请输入货物编码',
									name : 'goods_name'
								}, {
									xtype : 'label',
									width : 80,
									text : '客户姓名',
									style : 'text-align:center;margin-left:10px;'
								}, {
									xtype : 'textfield',
									emptyText : '请输入客户姓名',
									name : 'customer_name'
								}, {
									xtype : 'label',
									width : 80,
									text : '设备号',
									style : 'text-align:center;margin-left:10px;'
								}, {
									xtype : 'textfield',
									emptyText : '请输入设备号',
									name : 'instockplancontent_device'
								}, {
									xtype : 'label',
									width : 80,
									text : '计划日期',
									style : 'text-align:center;margin-left:10px;'
								}, {
									xtype : 'textfield',
									emptyText : '请输入日期',
									name : 'instockplancontent_date1'
								}]
					}]
		}, {
			xtype : 'container',
			height : 50,
			layout : 'column',
			items : [{
						xtype : 'button',
						width : 100,
						height : 30,
						text : '查询',
						icon : "../../../../Images/btnimg/select.png",
						handler : 'win_select',
						scope : this
					}, {
						xtype : 'button',
						width : 100,
						height : 30,
						text : '添加',
						style : 'margin-left:25px;',
						icon : "../../../../Images/btnimg/add.png",
						handler : 'win_add',
						scope : this
					}, {
						xtype : 'button',
						width : 100,
						height : 30,
						text : '保存',
						style : 'margin-left:25px;',
						icon : "../../../../Images/btnimg/save.gif",
						handler : 'win_save',
						scope : this
					}, {
						xtype : 'button',
						width : 100,
						height : 30,
						text : '删除',
						style : 'margin-left:25px;',
						icon : "../../../../Images/btnimg/delete.png",
						handler : 'win_del',
						scope : this
					}, {
						xtype : 'button',
						width : 100,
						height : 30,
						text : '导出',
						style : 'margin-left:25px;',
						icon : "../../../../Images/btnimg/excel_exports.png",
						handler : 'win_export_excel',
						scope : this
					}, {
						xtype : 'button',
						width : 100,
						height : 30,
						text : '导入',
						style : 'margin-left:25px;',
						icon : "../../../../Images/btnimg/excel_imports.png",
						handler : 'win_import_excel',
							scope : this
						}]
			}]
});

// 创建panel
var wind = new Ext.Window({
	title : '生产计划内容',
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
	var r = Ext.create(ProductionPlanFormContentModel, {});
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

//删除数据
var win_del=function(btn){
	  var ids = "";
	    var rowsSelectedModel = gridwindow.getSelectionModel(); //记录在一个数据绑定组件内部被选择的记录
	    var rowsSelected = rowsSelectedModel.getSelection(); //返回一个当前被选择的记录的数组。
	    var len = rowsSelected.length;
	    if (len > 0) {
	    	//选中多行
	        for (var i = 0; i < len; i++) 
	        {
	        	ids += rowsSelected[i].get("instockplancontent_pk") + ",";
	        }
           Ext.Msg.show({
                title: '消息提示',
                message: '您确定删除数据?',
                buttons: Ext.Msg.YESNOCANCEL,
                icon: Ext.Msg.QUESTION,
                fn: function (btn) {//用户点击交互后调用的函数，btn是指用户点了那个按钮
                    if (btn === 'yes') {
                        Ext.Ajax.request({
                        	url: '/WebWms/productionPlanFormContent/delete.action', //保存
                            params: { 'ids': ids },
                            success: function (response, options) {
                                var res = response.responseText;
                                if (res == null) {
                                    Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
                                    return;
                                }
                                else{
                                    Ext.Msg.alert("提示信息", "删除成功！");
                                    gridwindow.getStore().reload();//成功后刷新数据
                                }
                            },
                            failure: function () {
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
	    }
	    else {
	        Ext.Msg.alert("提示", "未勾选数据");
	    }
};