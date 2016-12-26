/**
 * 魏正钦
 * 2015-5-12
 * 生产计划单
 */

Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tip.*']);

	var gridpanel=Ext.create('Ext.grid.Panel', {
		//title : '入库计划单信息',
		store : InStockPlanFormStore,
		layout:'fit',
		id:'list',
		bodyStyle : "width:100%",
		autoScroll: true,
		stripeRows:true,//斑马线效果  
		forceFit: true, //列表宽度自适应 
		selModel: Ext.create('Ext.selection.CheckboxModel'), //每行前面加一个勾选框
		columns : 
			[   {//行号
			    text: '主键',
			    dataIndex : 'instockplanform_pk',
			    hidden: true
		      	},				{//行号
				    text: '序号',
				    xtype: 'rownumberer',
        			width: 60,
        			align: 'center',
        			sortable: false
				},
				{
					text : '入库计划单号',
					dataIndex : 'instockplanform_number',
					align: 'center',
				    editor:{  
	                    allowBlank:false,
	                    emptyText: '请填写入库计划单号'
	                }
				},
				{
					text : '创单人员',
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
					dataIndex : 'instockplanform_date',
				    align: 'center',
					xtype : 'datecolumn', 
					format : 'Y-m-d', 
					field : {
						xtype : "datefield",
						format : "y-m-d",
						altFormats: 'Y-m-d',
						allowBlank:false  
					},
					renderer:new Ext.util.Format.dateRenderer('Y-m-d')
				}, 
				{
					text : '备注',
					dataIndex : 'instockplanform_remark',
	       			align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text:'状态',
					dataIndex:'instockplanform_state',
	       			align: 'center',
//					editor:{  
//	                    allowBlank:true  
//	                },
	       		   renderer : function(value) {
        				return "<span style='margin-right:10px'><a href='#' onclick='win()'  >"+value+"</a></span>";
    				} 
				}
				
			],
			 plugins: [//grid可编辑插件
			   			Ext.create('Ext.grid.plugin.CellEditing', {
			               clicksToEdit: 2//2双击可编辑1单击可编辑
			           	})
			           ],
			 bbar: new Ext.PagingToolbar({
			        xtype: 'paging',
			        height: '30',
			        store: 'InStockPlanFormStore', //主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。 store中的load函数中的pagesize设置数据显示的实际条数。
			        displayMsg: '{0}--{1},共{2}条记录',
			        emptyMsg: '没有记录',
			        displayInfo: true,
			        beforePageText: '第',
			        afterPageText: '页，共{0}页',
			        firstText: '首页',
			        laseText: '末页',
			        nextText: '下页',
			        prevText: '上页'
			 
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
					text : '生产计划单号',
					style : 'text-align:center;margin-left:10px;'
				}, {
					xtype : 'textfield',
					emptyText : '请输入生产计划单号',
					name : 'instockplanform_number'
				}, {
					xtype : 'label',
					width : 80,
					text : '创单人员',
					style : 'text-align:center;margin-left:10px;'
				}, {
					xtype : 'textfield',
					emptyText : '请输入创单人员',
					name : 'user_name'
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
				text : '添加',
				style : 'margin-left:25px;',
				icon : "../../../../Images/btnimg/add.png",
				handler : 'add',
				scope : this
			}, {
				xtype : 'button',
				width : 100,
				height : 30,
				text : '保存',
				style : 'margin-left:25px;',
				icon : "../../../../Images/btnimg/save.gif",
				handler : 'save',
				scope : this
			}, {
				xtype : 'button',
				width : 100,
				height : 30,
				text : '删除',
				style : 'margin-left:25px;',
				icon : "../../../../Images/btnimg/delete.png",
				handler : 'del',
				scope : this
			}, {
				xtype : 'button',
				width : 100,
				height : 30,
				text : '查看订单内容',
				style : 'margin-left:25px;',
				icon : "../../../../Images/btnimg/delete.png",
				handler : 'checktxt',
				scope : this
			}, {
				xtype : 'button',
				width : 100,
				height : 30,
				text : '导出',
				style : 'margin-left:25px;',
				icon : "../../../../Images/btnimg/excel_exports.png",
				handler : 'export_excel',
				scope : this
			}, {
				xtype : 'button',
				width : 100,
				height : 30,
				text : '导入',
				style : 'margin-left:25px;',
				icon : "../../../../Images/btnimg/excel_imports.png",
				handler : 'import_excel',
				scope : this
			} ]
		} ]
	});
 
//创建panel	
var panel = new Ext.Panel({
			//title : '入库计划信息管理',
			id:'panel',
			autoHeight:true,
			items : [formaction,gridpanel]
});
//初始化界面					
Ext.onReady(function () {	
	panel.render(Ext.getBody());
    //调整窗口的高度
     Ext.getCmp('list').setHeight(document.documentElement.clientHeight-130);//动态设置窗口的大小
     Ext.getCmp('listwindow').setHeight(document.documentElement.clientHeight-173);//动态设置窗口的大小
});

//界面大小动态调整
Ext.EventManager.onWindowResize(function(){ 
    fillBrowser(panel);
   
    fillBrowserWidth(gridwindow);
    fillBrowserWidth(formwindow);
    fillBrowser(wd);
});

 function fillBrowser(obj){
 	if(obj != null){
 	    obj.setWidth(document.body.clientWidth);
    	    obj.setHeight(document.body.clientHeight);
 	}
 }
 function fillBrowserWidth(obj){
 	if(obj != null){
 	    obj.setWidth(document.body.clientWidth);
 	}
 }
 
var select=function(btn)
{
	//Ext.Msg.alert("查询",Ext.encode(formaction.getForm().getValues()));
	Ext.getCmp("list").store.load({ 
	    params: formaction.getForm().getValues()//获取form表单的值
	});
};
//添加一个空行
var add=function (btn) {
    var r = Ext.create('InStockPlanFormModel', {
    });
    Ext.getCmp('list').getStore().insert(0, r);
};
//保存数据
var save=function(btn)
{	  
	var records = gridpanel.getStore().getUpdatedRecords();//获取修改的行的数据   
	var newRecords = gridpanel.getStore().getNewRecords();//获得新增行的数据   
	//保存修改数据
	if(records.length>0){  
		Ext.Msg.alert("修改数据","修改数据");
		var jsonArray = [];
		for(var i=0;i<records.length;i++){   
	        jsonArray.push(records[i].data);
	        
		}
		//Ext.Msg.alert("修改数据",Ext.encode(jsonArray));
		if(jsonArray.length>0)
	        {
	        	Ext.Ajax.request({
	        		url: '/WebWms/productionPlanForm/save.action', //保存
                    method:'POST',  
                    params:{datas:Ext.encode(jsonArray)},
                    success: function (response, options) {
                        var res = response.responseText;
                        if (res == null) {
                            Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
                            return;
                        }
                        else{
                        	Ext.Msg.alert("提示信息", "保存成功！");
                        	gridpanel.getStore().reload();//添加成功后刷新数据
                        }
                    },
                    failure: function () {
                        Ext.Msg.alert("提示信息", "出现异常！");
                    }
                });
	        }
	 	
	}
	//保存新增的数据
	if(newRecords.length>0){  
		Ext.Msg.alert("新增数据","新增数据");
		var jsonArray = [];
		for(var i=0;i<newRecords.length;i++){   
	        jsonArray.push(newRecords[i].data);
		}
		//Ext.Msg.alert("新增数据",Ext.encode(jsonArray));
		if(jsonArray.length>0)
	        {
	        	Ext.Ajax.request({
	        		url: '/WebWms/productionPlanForm/save.action', //保存
                    method:'POST',  
                    params:{datas:Ext.encode(jsonArray)},
                    success: function (response, options) {
                        var res = response.responseText;
                        if (res == null) {
                            Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
                            return;
                        }
                        else{
                        	Ext.Msg.alert("提示信息", "保存成功！");
                        	gridpanel.getStore().reload();//添加成功后刷新数据
                        }
                    },
                    failure: function () {
                        Ext.Msg.alert("提示信息", "出现异常！");
                    }
                });
	        }
	 	
	}
};
//删除数据
var del=function(btn){
	  var ids = "";
	    var rowsSelectedModel = gridpanel.getSelectionModel(); //记录在一个数据绑定组件内部被选择的记录
	    var rowsSelected = rowsSelectedModel.getSelection(); //返回一个当前被选择的记录的数组。
	    var len = rowsSelected.length;
	    if (len > 0) {
	    	//选中多行
	        for (var i = 0; i < len; i++) 
	        {
	        	ids += rowsSelected[i].get("instockplanform_pk") + ",";
	        }
           Ext.Msg.show({
                title: '消息提示',
                message: '您确定删除数据?',
                buttons: Ext.Msg.YESNOCANCEL,
                icon: Ext.Msg.QUESTION,
                fn: function (btn) {//用户点击交互后调用的函数，btn是指用户点了那个按钮
                    if (btn === 'yes') {
                        Ext.Ajax.request({
                        	url: '/WebWms/productionPlanForm/delete.action', //保存
                            params: { 'ids': ids },
                            success: function (response, options) {
                                var res = response.responseText;
                                if (res == null) {
                                    Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
                                    return;
                                }
                                else{
                                    Ext.Msg.alert("提示信息", "删除成功！");
                                    gridpanel.getStore().reload();//成功后刷新数据
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
//
var wd;
var checktxt=function(){
    wd=wind;
    var rowsSelectedModel = gridpanel.getSelectionModel(); //记录在一个数据绑定组件内部被选择的记录
    var rowsSelected = rowsSelectedModel.getSelection(); //返回一个当前被选择的记录的数组。
    var len = rowsSelected.length;
    if(len>1){
    	
    	return ;
    }
   var instockplanform_pk2=rowsSelected[0].get("instockplanform_pk");
   ProductionPlanFormContentStore.load({ params: { start: 0, limit: 20, instockplanform_pk2: instockplanform_pk2} }); 
   wd.show();
   wd.maximize();
	//Ext.Msg.alert("提示", "弹出窗口");
};

