/**
 * 马玉德 2015-5-12 出库单
 */
Ext.require([ 'Ext.data.*', 'Ext.grid.*', 'Ext.tip.*' ]);

var gridpanel = Ext
		.create(
				'Ext.grid.Panel',
				{
					// title : '入库计划单信息',
					store : OutStockFormStore,
					layout : 'fit',
					id : 'list',
					bodyStyle : "width:100%",
					autoScroll : true,
					stripeRows : true,// 斑马线效果
					forceFit : true, // 列表宽度自适应
					selModel : Ext.create('Ext.selection.CheckboxModel'), // 每行前面加一个勾选框
					columns : [
							{// 行号
								text : '序号',
								xtype : 'rownumberer',
								width : 60,
								align : 'center',
								sortable : false
							},
							{
								text : '出库单号',
								dataIndex : 'outstockform_number',
								align : 'center',
								editor : {
									allowBlank : false,
									emptyText : '请填写出库计划单号'
								}
							}
							,
							{
								text : '操作员',
								dataIndex : 'fk_user_pk',
								align : 'center',
								field : {
									xtype : 'combobox',
									typeAhead : true,
									triggerAction : 'all',
									queryMode : 'local',
									selectOnTab : true,
									store : 'UserStore',
									lazyRender : true,
									displayField : 'user_name',
									valueField : 'user_pk'
								},
								renderer : function(value, metadata, record) {
									var index = UserStore.find('user_pk',
											value);
									if (index != -1) {
										return UserStore.getAt(index).data.user_name;
									}
									return value;
								}
							},
							{
								text : '创单日期',
								dataIndex : 'outstockform_date',
								align : 'center',
								xtype : 'datecolumn',
								format : 'Y-m-d',
								field : {
									xtype : "datefield",
									format : "y-m-d",
									altFormats : 'Y-m-d',
									allowBlank : false
								},
								renderer : new Ext.util.Format.dateRenderer(
										'Y-m-d')
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
						store : 'OutStockFormStore', // 主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。
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
		}, {
			xtype : 'button',
			width : 100,
			height : 30,
			text : '打印',
			style : 'margin-left:25px;',
			icon : "../../../../Images/btnimg/add.png",
			handler : 'form_print',
			scope : this
		}]
	} ]
});

// 创建panel
var panel = new Ext.Panel({
	// title : '入库计划信息管理',
	id : 'panel',
	autoHeight : true,
	items : [ formaction, gridpanel ]
});
// 初始化界面
Ext.onReady(function() {
	// new GoodsStore();
	panel.render(Ext.getBody());
	// 调整窗口的高度
	Ext.getCmp('list').setHeight(document.documentElement.clientHeight - 130);// 动态设置窗口的大小
});

// 界面大小动态调整
Ext.EventManager.onWindowResize(function() {
	fillBrowser(panel);

	fillBrowserWidth(gridwindow);
	fillBrowserWidth(formwindow);
	fillBrowser(wd);
});

function fillBrowser(obj) {
	if (obj != null) {
		obj.setWidth(document.body.clientWidth);
		obj.setHeight(document.body.clientHeight);
	}
}

var select = function(btn) {
	Ext.Msg.alert("查询", Ext.encode(formaction.getForm().getValues()));
	Ext.getCmp("list").store.load({
		params : formaction.getForm().getValues()
	// 获取form表单的值
	});
};


var form_print = function() {
	var rowsSelectedModel = gridpanel.getSelectionModel(); //记录在一个数据绑定组件内部被选择的记录
	var rowsSelected = rowsSelectedModel.getSelection(); //返回一个当前被选择的记录的数组。
    var len = rowsSelected.length;
    if(len>1){
    	Ext.Msg.alert("提示信息", "每次只能查看一条记录！");
    	return;
    }
    var stockformNumber= rowsSelected[0].get("outstockform_pk")
    var sUrl  =  window.location.host ; 
	var url1="http://"+sUrl+"/WebWms/outStockForm/list_view.action?stockformNumber="+stockformNumber+"";
    alert(url1);
	win1 = new Ext.Window({
	    title:'入库计划单号为：'+stockformNumber+'的出库单',
	    layout:'fit',
	    forceFit: true, //列表宽度自适应 
	    html:' <iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="'+url1+'"> </iframe>', 
	    scripts: true,	    
	});
	
//	Ext.Ajax.request({
//		url : "/WebWms/outStockForm/list_view.action", // 批量删除
//		params : {
//			'stockformNumber' : stockformNumber
//		},
//		success : function(response, options) {
//			var res = response.responseText;
//			if (res == null) {
//				Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
//				return;
//			} else {
//				Ext.Msg.alert("提示信息", "删除成功！");
//				gridpanel.getStore().reload();// 成功后刷新数据
//			}
//		},
//		failure : function() {
//			Ext.Msg.alert("提示信息", "删除出现异常！");
//		}
//	});
	win1.show();
	win1.maximize();
};
