Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.util.*',
    'Ext.tip.*']);

var gridpanel=Ext.create('Ext.grid.Panel', {
		store : GoodsStore,
		layout:'fit',
		id:'list',
		stripeRows:true,//斑马线效果  
		//forceFit: true, //列表宽度自适应 
		invalidateScrollerOnRefresh: false,//刷新数据时不改变滚动条的位置
		selModel: Ext.create('Ext.selection.CheckboxModel'), //每行前面加一个勾选框
		columns : 
			[
				{//行号
				    text: '序号',
				    xtype: 'rownumberer',
				    width: 60,
				    align: 'center',
				    sortable: false
				},
				{
					text : '货物编号',
					dataIndex : 'goods_number',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}, 
				{
					text:'货物名称',
					dataIndex:'goods_name',
					align: 'center',
					editor:{
	                allowBlank:true  
	                }
				},
				{
					text : '货物类型',
					dataIndex : 'goods_type',
					align: 'center',
				    editor: new Ext.form.TextField({
			           allowBlank: false
					 })
				},
				{
					text : '单位',
					dataIndex : 'goods_unit',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text : '客户名称',
					dataIndex : 'fk_customer_pk',
					align: 'center',
				    editor: new Ext.form.TextField({
			           allowBlank: false
					 })
				},
				{
					text : '产品单价',
					dataIndex : 'goods_price',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text : '单模个数',
					dataIndex : 'goods_model_count',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text : '标准克重',
//					dataIndex : '',
					align: 'center',
	                columns : 
	                [{ 
	                	dataIndex : 'goods_weight_remark', 
	                	align: 'center',
	                	text : '重量说明',
	                	editor:{  
		                    allowBlank:true  
		                }
            		}, 
            		{ 
	                	dataIndex : 'goods_standard_weight', 
	                	align: 'center',
	                	text : '标准重量',
	                	editor:{  
		                    allowBlank:true  
		                }
            		}]
				},
				{
					text:'原料类型(发料克重)',
					dataIndex:'goods_material_type',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text : '成型周期',
					dataIndex : 'goods_moldel_cycle',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}
				,
				{
					text : '原料类型',// 大类
					dataIndex : 'goods_material_parenttype',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}
				,
				{
					text : '包装类型',//包装方式
					dataIndex : 'goods_pack_type',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}
				,
				{
					text : '包装方式1',
					dataIndex : '',
					align: 'center',
					columns : 
	                [{ 
	                	dataIndex : 'goods_pack1_type', 
	                	align: 'center',
	                	text : '类型',
	                	editor:{  
	                    allowBlank:true  
	                }
            		}, 
            		{ 
	                	dataIndex : 'goods_pack1_count', 
	                	align: 'center',
	                	text : '包装数量',
	                	editor:{  
	                    allowBlank:true  
	                }
            		},
            		{ 
	                	dataIndex : 'goods_pack1_description', 
	                	align: 'center',
	                	text : '说明',
	                	editor:{  
	                    allowBlank:true  
	                }
            		}
            		]
				},
				{
					text : '包装方式2',
					dataIndex : '',
					columns : 
	                [{ 
	                	dataIndex : 'goods_pack2_type', 
	                	align: 'center',
	                	text : '类型',
	                	editor:{  
	                    allowBlank:true  
	                }
            		}, 
            		{ 
	                	dataIndex : 'goods_pack2_count', 
	                	align: 'center',
	                	text : '包装数量' ,
	                	editor:{  
	                    allowBlank:true  
	                }
            		},
            		{ 
	                	dataIndex : 'goods_pack2_description', 
	                	align: 'center',
	                	text : '说明' ,
	                	editor:{  
	                    allowBlank:true  
	                }
            		}
            		]
				},
				{
					text : '仓库位置',
					dataIndex : '',
					align: 'center',
					columns : 
	                [{ 
	                	dataIndex : 'goods_location1', 
	                	align: 'center',
	                	text : '库位1',
	                	editor:{  
	                    allowBlank:true  
	                }
            		}, 
            		{ 
	                	dataIndex : 'goods_location2', 
	                	align: 'center',
	                	text : '库位2',
	                	editor:{  
	                    allowBlank:true  
	                }
            		},
            		{ 
	                	dataIndex : 'goods_location_temp', 
	                	align: 'center',
	                	text : '临时',
	                	editor:{  
	                    allowBlank:true  
	                }
            		},
            		{ 
	                	dataIndex : 'goods_location_description', 
	                	align: 'center',
	                	text : '说明',
	                	editor:{  
	                    allowBlank:true  
	                }
            		}]
				},
				{
					text : '模具位置',
					align: 'center',
					dataIndex : 'goods_model_position',
					editor:{  
	                    allowBlank:true  
	                }
				}
				,
				{
					text : '每托盘数量',
					dataIndex : 'goods_pack_plasticsize',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}
				,
				{
					text : '立方米/单位',
					dataIndex : 'goods_unit_cube',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}
				,
				{
					text : '吨/单位',
					dataIndex : 'goods_unit_tonne',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}
				,
				{
					text : '平方米/单位',
					dataIndex : 'goods_unit_square',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text : '新增日期',
					dataIndex : 'goods_create_date',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text : '修改日期',
					dataIndex : 'goods_update_date',
					align: 'center',
					editor:{  
	                    allowBlank:true  
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
			        store: 'GoodsStore', //主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。 store中的load函数中的pagesize设置数据显示的实际条数。
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
     id: 'formconditions',
     height: 130,
     items: 
    	 [
	    	 {
    	   		xtype: 'fieldset',
                id: 'fieldset1',
                title: '<style="height:20; width:20;">查询条件',
                height: 80,
                layout: "vbox",
                items: [
                {
                	    xtype: 'container',
                        height: 30,
                        layout: 'hbox',
                        layoutConfig: {
                            align: 'middle'
                        },
                        items: [
		                	{ xtype: 'label', width: 80,text: '货物编号',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入货物编号', name: 'goods_number' },
				            { xtype: 'label', width: 80,text: '货物名称',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输货物名称', name: 'goods_name' },
				            { xtype: 'label', width: 80,text: '客户名称',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入客户名称', name: 'fk_customer_pk' },
				            { xtype: 'label', width: 80,text: '货物类型',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入货物类型', name: 'goods_type' },
		            	]
		          },
//		            {
//                	    xtype: 'container',
//                        height: 30,
//                        layout: 'hbox',
//                        layoutConfig: {
//                            align: 'middle'
//                        },
//                        items: [
//				            { xtype: 'label', width: 80,text: '客户手机',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入客户手机', name: 'customer.customer_mobilephone' },
//				            { xtype: 'label', width: 80,text: '客户地址',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入客户地址', name: 'customer.customer_address' },
//				            { xtype: 'label', width: 80,text: '客户联系人',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入客户联系人', name: 'customer.fk_linkman_pk' },
//				            { xtype: 'label', width: 80,text: '客户备注',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入客户备注', name: 'customer.customer_remark' }
//		            ]}
	            ]
	    	 },
	    	  {
                xtype: 'container',
                height: 50,
                layout: 'column',
                items: [
			    	    { xtype: 'button', width: 100,height: 30, text: '查询', icon: "../../../../Images/btnimg/select.png", handler: 'select', scope: this },
			            { xtype: 'button', width: 100,height: 30, text: '添加',  style: 'margin-left:25px;',icon: "../../../../Images/btnimg/add.png", handler: 'add', scope: this },
			            { xtype: 'button', width: 100,height: 30, text: '保存',  style: 'margin-left:25px;',icon: "../../../../Images/btnimg/save.gif", handler: 'save', scope: this },
			            { xtype: 'button', width: 100,height: 30, text: '删除',  style: 'margin-left:25px;',icon: "../../../../Images/btnimg/delete.png", handler: 'del', scope: this },
			            { xtype: 'button', width: 100,height: 30, text: '导出',  style: 'margin-left:25px;',icon: "../../../../Images/btnimg/excel_exports.png", handler: 'export_excel', scope: this },
			            { xtype: 'button', width: 100,height: 30, text: '导入',  style: 'margin-left:25px;',icon: "../../../../Images/btnimg/excel_imports.png", handler: 'import_excel', scope: this }
	            	]
	           }
         ]
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

//保存数据
var save=function(){
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
                    url: '/WebWms/goods/save.action', //保存
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
                    url: '/WebWms/goods/save.action', //保存
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
	        	ids += rowsSelected[i].get("goods_pk") + ",";
	        }
           Ext.Msg.show({
                title: '消息提示',
                message: '您确定删除数据?',
                buttons: Ext.Msg.YESNOCANCEL,
                icon: Ext.Msg.QUESTION,
                fn: function (btn) {//用户点击交互后调用的函数，btn是指用户点了那个按钮
                    if (btn === 'yes') {
                        Ext.Ajax.request({
                        	 url: '/WebWms/goods/delete.action', //保存
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
