Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tip.*']);

	var gridpanel=Ext.create('Ext.grid.Panel', {
		//title : '库位信息列表',
		store : LocationStore,
		defaults:{  
		//子元素平均分配宽度
        	flex:1  
      	},  
		id:'list',
		stripeRows:true,//斑马线效果  
		forceFit: true, //列表宽度自适应 
		enableKeyNav : true,
		columnLines : true,
		multiSelect : true,
		border : 0,
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
					text : '库位编号',
					dataIndex : 'location_number',
					align: 'center',
				    editor:{  
	                    allowBlank:false,
	                    emptyText: '请填写库位编号'
	                }
				},
				{
					text : '库位名称',
					dataIndex : 'location_name',
					align: 'center',
				    editor:{  
	                    allowBlank:false,
	                    emptyText: '请填写库位名称',
                        regexText: '只能输入汉字，请输入库位名称！'
                        //regex: /^[\u4E00-\u9FA5]+$/
	                }
				},
				{
					text : '库位备注',
					dataIndex : 'location_remark',
	       			align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				}, 
				{
					text : '库位类型',
					dataIndex : 'location_type',
	       			align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text:'存放库区',
					dataIndex:'fk_area_pk',
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
			        store: 'LocationStore', //主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。 store中的load函数中的pagesize设置数据显示的实际条数。
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
   							{ xtype: 'label', width: 80,text: '库位编号',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入库位编号', name: 'location_number' },
				            { xtype: 'label', width: 80,text: '库位名称',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入库位名',  name: 'location_name' },
				            { xtype: 'label', width: 80,text: '存放库区',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入存放库区', name: 'fk_area_pk' },
				            { xtype: 'label', width: 80,text: '库位类型',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入库位类型', name: 'location_type' }
		            	]
		          }
//		            {
//                	    xtype: 'container',
//                        height: 30,
//                        layout: 'hbox',
//                        layoutConfig: {
//                            align: 'middle'
//                        },
//                        items: [
//				            { xtype: 'label', width: 80,text: '客户手机',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入库位编号', name: 'location.location_number' },
//				            { xtype: 'label', width: 80,text: '客户地址',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入库位名',  name: 'location.location_name' },
//				            { xtype: 'label', width: 80,text: '客户联系人',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入库位备注', name: 'location.location_remark' },
//				            { xtype: 'label', width: 80,text: '客户备注',style: 'text-align:center;margin-left:10px;'},
//				            { xtype: 'textfield', emptyText: '请输入库位类型', name: 'location.location_type' }
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
			//title : '库位信息管理',
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
 
var select=function(btn)
{
	Ext.Msg.alert("查询",Ext.encode(formaction.getForm().getValues()));
	Ext.getCmp("list").store.load({ 
	    params: formaction.getForm().getValues()//获取form表单的值
	});
};
//添加一个空行
var add=function (btn) {
    var r = Ext.create('LocationModel', {
    	 location_name:"",
    	 location_number:"",
    	 location_pk:"",
    	 location_remark:"",
    	 location_type:"",
    	 fk_area_pk:""
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
		Ext.Msg.alert("修改数据",Ext.encode(jsonArray));
		if(jsonArray.length>0)
	        {
	        	Ext.Ajax.request({
                    url: '/WebWms/location/save.action', //保存
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
		Ext.Msg.alert("新增数据",Ext.encode(jsonArray));
		if(jsonArray.length>0)
	        {
	        	Ext.Ajax.request({
                    url: '/WebWms/location/save.action', //保存
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
	        	ids += rowsSelected[i].get("location_pk") + ",";
	        }
           Ext.Msg.show({
                title: '消息提示',
                message: '您确定删除数据?',
                buttons: Ext.Msg.YESNOCANCEL,
                icon: Ext.Msg.QUESTION,
                fn: function (btn) {//用户点击交互后调用的函数，btn是指用户点了那个按钮
                    if (btn === 'yes') {
                        Ext.Ajax.request({
                            url: "/WebWms/location/delete.action", //批量删除
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
