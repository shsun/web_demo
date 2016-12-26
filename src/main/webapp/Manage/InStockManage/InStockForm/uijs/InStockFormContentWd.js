Ext.require(['Ext.data.*', 'Ext.grid.*', 'Ext.util.*', 'Ext.tip.*']);

var gridwd = Ext.create('Ext.grid.Panel', {
			store : InStockFormContentStore,
			layout : 'fit',
			id : 'listwindowwd',
			stripeRows : true,// 斑马线效果
		    forceFit: true, // 列表宽度自适应
		    invalidateScrollerOnRefresh: false,// 刷新数据时不改变滚动条的位置
			selModel : Ext.create('Ext.selection.CheckboxModel'), // 每行前面加一个勾选框
			columns : [{// 行号
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
				renderer : function(value, metadata, record)
				{
					var index = GoodsStore.find('goods_pk', value);
					if (index != -1)
					{
						return GoodsStore.getAt(index).data.goods_number;
					}
					return value;
				}
			}, {
				text : '计划数量',
				dataIndex : 'instockplancontent_count',
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
				text : '包装方式',// 手动填写的
				dataIndex : 'instockplancontent_way',
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
				text : '数量',//
				dataIndex : 'goods_count',
				align : 'center',
				editor : {
					allowBlank : true
				}
			}, {
				text : '位置',// 单模个数
				dataIndex : 'goods_location',
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
				renderer : function(value, metadata, record)
				{
					var index = LocationStore.find('location_pk', value);
					if (index != -1)
					{
						return LocationStore.getAt(index).data.location_name;
					}
					return value;
				}
			}],
			plugins : [// grid可编辑插件
			Ext.create('Ext.grid.plugin.CellEditing', {
				clicksToEdit : 2
					// 2双击可编辑1单击可编辑
				})],
			bbar : new Ext.PagingToolbar({
						xtype : 'paging',
						height : '30',
						store : 'InStockFormContentStore', // 主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。
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

var formwd = new Ext.form.FormPanel({
	height : 60,
	width : '100%',
	items : [
		{
				xtype : 'fieldset',
				title : '<style="height:20; width:20;">查询条件',
				height : 60,
				width : '100%',
				layout : "vbox",
				autoWidth : true,
				items : [
				{
				xtype : 'container',
				height : 50,
				layout : 'column',
				items : [{
							xtype : 'button',
							width : 100,
							height : 30,
							text : '查询',
							icon : "../../../../Images/btnimg/select.png",
							handler : 'wd_select',
							scope : this
						}, {
							xtype : 'button',
							width : 100,
							height : 30,
							text : '添加',
							style : 'margin-left:25px;',
							icon : "../../../../Images/btnimg/add.png",
							handler : 'wd_add',
							scope : this
						}, {
							xtype : 'button',
							width : 100,
							height : 30,
							text : '保存',
							style : 'margin-left:25px;',
							icon : "../../../../Images/btnimg/save.gif",
							handler : 'wd_save',
							scope : this
						}, {
							xtype : 'button',
							width : 100,
							height : 30,
							text : '删除',
							style : 'margin-left:25px;',
							icon : "../../../../Images/btnimg/delete.png",
							handler : 'wd_del',
							scope : this
						}]
			}]
		}]
});

// 创建panel
var windwd = new Ext.Window({
	title : '这是窗口',
	closeAction : 'hide',
	modal : true,
	layout : 'vbox',
	layoutConfig : {
		align : 'middle'
	},
	autoHeight : true,
	autoWidth : true,
	items : [formwd, gridwd]
		// formwindow,gridwindow
	});

// 添加一个空行
var wd_add = function(btn)
{
	var r = Ext.create(InStockFormContentModel, {});
	Ext.getCmp('listwindowwd').getStore().insert(0, r);
};

// 保存数据
var wd_save = function(btn)
{
	var records = gridwd.getStore().getUpdatedRecords();// 获取修改的行的数据
	var newRecords = gridwd.getStore().getNewRecords();// 获得新增行的数据
	// 保存修改数据
	if (records.length > 0)
	{
		Ext.Msg.alert("修改数据", "修改数据");
		var jsonArray = [];
		for (var i = 0; i < records.length; i++)
		{
			jsonArray.push(records[i].data);
		}
		Ext.Msg.alert("修改数据", Ext.encode(jsonArray));
		if (jsonArray.length > 0)
		{
			Ext.Ajax.request({
						url : '/WebWms/stock/save.action', // 保存
						method : 'POST',
						params : {
							datas : Ext.encode(jsonArray)
						},
						success : function(response, options)
						{
							var res = response.responseText;
							if (res == null)
							{
								Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
								return;
							} else
							{
								Ext.Msg.alert("提示信息", "保存成功！");
								gridwindow.getStore().reload();// 添加成功后刷新数据
							}
						},
						failure : function()
						{
							Ext.Msg.alert("提示信息", "出现异常！");
						}
					});
		}

	}
	// 保存新增的数据
	if (newRecords.length > 0)
	{
		Ext.Msg.alert("新增数据", "新增数据");
		var jsonArray = [];
		for (var i = 0; i < newRecords.length; i++)
		{
			jsonArray.push(newRecords[i].data);
		}
		Ext.Msg.alert("新增数据", Ext.encode(jsonArray));
		if (jsonArray.length > 0)
		{
			Ext.Ajax.request({
						url : '/WebWms/stock/save.action', // 保存
						method : 'POST',
						params : {
							datas : Ext.encode(jsonArray)
						},
						success : function(response, options)
						{
							var res = response.responseText;
							if (res == null)
							{
								Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
								return;
							} else
							{
								Ext.Msg.alert("提示信息", "保存成功！");
								gridwindow.getStore().reload();// 添加成功后刷新数据
							}
						},
						failure : function()
						{
							Ext.Msg.alert("提示信息", "出现异常！");
						}
					});
		}

	}
};

// 删除数据
var wd_del = function(btn)
{
	var ids = "";
	var rowsSelectedModel = gridwd.getSelectionModel(); // 记录在一个数据绑定组件内部被选择的记录
	var rowsSelected = rowsSelectedModel.getSelection(); // 返回一个当前被选择的记录的数组。
	var len = rowsSelected.length;
	if (len > 0)
	{
		// 选中多行
		for (var i = 0; i < len; i++)
		{
			ids += rowsSelected[i].get("instockplancontent_pk") + ",";
		}
		Ext.Msg.show({
			title : '消息提示',
			message : '您确定删除数据?',
			buttons : Ext.Msg.YESNOCANCEL,
			icon : Ext.Msg.QUESTION,
			fn : function(btn)
			{// 用户点击交互后调用的函数，btn是指用户点了那个按钮
				if (btn === 'yes')
				{
					Ext.Ajax.request({
						url : '/WebWms/productionPlanFormContent/delete.action', // 保存
						params : {
							'ids' : ids
						},
						success : function(response, options)
						{
							var res = response.responseText;
							if (res == null)
							{
								Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
								return;
							} else
							{
								Ext.Msg.alert("提示信息", "删除成功！");
								gridwindow.getStore().reload();// 成功后刷新数据
							}
						},
						failure : function()
						{
							Ext.Msg.alert("提示信息", "删除出现异常！");
						}
					});
				} else if (btn === 'no')
				{
					return null;
				} else
				{
					return null;
				}
			}
		});
	} else
	{
		Ext.Msg.alert("提示", "未勾选数据");
	}
};