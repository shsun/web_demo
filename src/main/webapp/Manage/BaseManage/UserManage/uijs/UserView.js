Ext.require([
    'Ext.data.*',
    'Ext.grid.*',
    'Ext.tip.*']);

SexStore = new Ext.data.SimpleStore({
    fields: ['sexid', 'sexname'],
    data: [['男', '男'], ['女', '女']]
});  

 var rendersex = function (value) {
    if (value == "女") {
        return "<span style='text-align:center;color:red'>" + value + "</span>";
    }
    else {
        return "<span style='text-align:center;color:green'>" + value + "</span>";
    }
};

//var rowEditing = Ext.create('Ext.grid.plugin.RowEditing', {
//    clicksToMoveEditor: 1,
//    autoCancel: false
//});
	var gridpanel=Ext.create('Ext.grid.Panel', {
		store : UserStore,
		defaults:{  
		//子元素平均分配宽度
        	flex:1  
      	},  
		//layout:'fit',
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
					//text: '',
					text : '序号',
					width:60,
        			xtype: 'rownumberer',
        			align: 'center',
        			sortable: false
				},
				{
					text : '姓名',
					dataIndex : 'user_name',
					align: 'center',
				    editor:{  
	                    allowBlank:false,
	                    emptyText: '请填写员工姓名',
                        regexText: '只能输入汉字，请输入真实姓名！'
                        //regex: /^[\u4E00-\u9FA5]+$/
	                }
				},
				{
					text:'员工编号',
					dataIndex:'user_number',
					align: 'center',
					editor:{  
	                    allowBlank:false  
	                }
				},
				{
					text : '性别',
					dataIndex : 'user_sex',
					align: 'center',
					renderer:rendersex,
					field: { 
	                xtype: 'combobox', 
	                typeAhead: true, 
	                triggerAction: 'all', 
	                queryMode: 'local',  
	                selectOnTab: true, 
	                store: SexStore, 
	                lazyRender: true, 
	                displayField:'sexname', 
	                valueField:'sexid', 
                	listeners:{     
                    select : function(combo, record,index){ 
                        	isEdit = true; 
                    		} 
                		} 
					}
//					renderer:function(value)
//					{
//					 	Ext.Msg.alert("渲染",value);
//					    if (value == "女") {
//					        return "<span style='text-align:center;color:red'>" + value + "</span>"
//					    }
//					    else {
//					        return "<span style='text-align:center;color:green'>" + value + "</span>"
//					    }
//					}
				}, 
				{
					text : '生日',
					dataIndex : 'user_birthday',
					align: 'center',
					xtype : 'datecolumn', 
					format : 'Y-m-d', 
					field : {
						xtype : "datefield",
						format : "y-m-d",
						altFormats: 'Y-m-d'
					},
					renderer:new Ext.util.Format.dateRenderer('Y-m-d')
				},
				{
					text : '电话',
					dataIndex : 'user_phone',
					align: 'center',
					editor:{  
	                    allowBlank:false,
	                    regex: /^1\d{10}$/,    //正则表达式在/...../之间
                        regexText: "请输入正确的手机号码!" //正则表达式错误提示
	                }
				},
				{
					text : '邮箱',
					dataIndex : 'user_email',
					align: 'center',
					editor:{  
	                    allowBlank:true,
	                    regex: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
                        regexText: "请填写正确的邮箱"
	                }
				},
				{
					text : '入职时间',
					dataIndex : 'user_intime',
					align: 'center',
					xtype : 'datecolumn', 
					format : 'Y-m-d', 
					field : {
						xtype : "datefield",
						format : "Y-m-d"
					}
				},
				{
					text : '密码',
					dataIndex : 'user_password',
					align: 'center',
					editor:{  
	                    allowBlank:false  
	                }
				},
				{
					text:'工位',
					dataIndex:'fk_station_pk',
					align: 'center',
					editor:{  
	                    allowBlank:true  
	                }
				},
				{
					text : '职位',
					dataIndex : 'fk_roles_pk',
					align: 'center',
				    field: { 
		                xtype: 'combobox', 
		                typeAhead: true, 
		                triggerAction: 'all', 
		                queryMode: 'local',  
		                selectOnTab: true, 
		                store: RolesStore, 
		                lazyRender: true, 
		                displayField:'roles_name', 
		                valueField:'roles_pk'
					},
				   renderer: function(value,metadata,record){  
                        var index = RolesStore.find('roles_pk',value);  
                        if(index!=-1){  
                            return RolesStore.getAt(index).data.roles_name;  
                        }  
                        return value;  
                    }  
				}
			],
			 plugins: [//grid可编辑插件
			           Ext.create('Ext.grid.plugin.CellEditing', {
			               clicksToEdit: 2,//2双击可编辑1单击可编辑
			               autoCancel: false
			           })
			           //RowEditing
			           //CellEditing
			           ],
			 bbar: new Ext.PagingToolbar({
			        xtype: 'paging',
			        height: '30',
			        store: 'UserStore', //主要是取store中从后台返回的totalCount，以及在store中设置的pagesize，就可以进行分页。具体的数据分页在后台的sql语句中进行。 store中的load函数中的pagesize设置数据显示的实际条数。
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
//			    tbar:
//			      {
//			         xtype: 'toolbar',
//			         items:
//			         [
//			            { xtype: 'button', text: '查询', icon: "../../../../Images/btnimg/select.png", handler: 'select', scope: this },
//			            { xtype: 'button', text: '添加', icon: "../../../../Images/btnimg/add.png", handler: 'add', scope: this },
//			            { xtype: 'button', text: '保存', icon: "../../../../Images/btnimg/save.gif", handler: 'save', scope: this },
//			            { xtype: 'button', text: '删除', icon: "../../../../Images/btnimg/delete.png", handler: 'del', scope: this },
//			            { xtype: 'button', text: '导出', icon: "../../../../Images/btnimg/excel_exports.png", handler: 'export_excel', scope: this },
//			            { xtype: 'button', text: '导入', icon: "../../../../Images/btnimg/excel_imports.png", handler: 'import_excel', scope: this }
//			        ]
//			     }
		});

//var formaction = new Ext.form.FormPanel({
//     id: 'formconditions',
//     height: 30,
//     layout: "hbox",
//     layoutConfig: {
//         align: "middle"
//     },
//     items: 
//    	 [
//            { xtype: 'textfield', emptyText: '请输入员工编号',submitValue:true, name: 'user.user_number' },
//            { xtype: 'textfield', emptyText: '请输入员工姓名',submitValue:true, name: 'user.user_name' },
//            { xtype: 'textfield', emptyText: '请输入职位', submitValue:true,name: 'user.fk_roles_pk' },
//            { xtype: 'textfield', emptyText: '请输入生日', submitValue:true,name: 'user.user_birthday' },
//            { xtype: 'textfield', emptyText: '请输入工位', submitValue:true,name: 'user.fk_station_pk' },
//            { xtype: 'textfield', emptyText: '请输入入职时间',submitValue:true, name: 'user.user_intime' }
//         ]
// });
 
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
		                	{ xtype: 'label', width: 80,text: '员工姓名',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入员工姓名',submitValue:true, name: 'user_name' },
				            { xtype: 'label', width: 80,text: '员工编号',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入员工编号',submitValue:true, name: 'user_number' },
				            { xtype: 'label', width: 80,text: '员工职位',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入职位', submitValue:true,name: 'fk_roles_pk' },
				            { xtype: 'label', width: 80,text: '员工电话',style: 'text-align:center;margin-left:10px;'},
				            { xtype: 'textfield', emptyText: '请输入电话', submitValue:true,name: 'user_phone' }
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
			//title : '员工信息管理',
			id:'panel',
			autoHeight:true,
			aoutWidth:true,  
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



 
//查询
var select=function(btn)
{
	//第一种实现查询的方法
//	    var user_name = Ext.getCmp('User_name').getValue();
//	    var user_number=Ext.getCmp('User_number').getValue();
//	    var user_group=Ext.getCmp('User_group').getValue();
//	    var user_birthday=Ext.getCmp('User_birthday').getValue();
//	    var user_intime=Ext.getCmp('User_intime').getValue();
//	   	Ext.Msg.alert("提示信息","查询");
//	    Ext.getCmp("list").store.load({ 
//	    	params: { 
//		    	start: 0, limit: 20, 
//	        	'user.user_name': user_name,
//	        	'user.user_number':user_number,
//	        	'user.user_birthday':user_birthday,
//	        	'user.user_intime':user_intime,
//	        	'user.fk_roles_pk':user_group
//	    	} 
//	    });
	//第二种查询的方法
	Ext.Msg.alert("查询",Ext.encode(formaction.getForm().getValues()));
	Ext.getCmp("list").store.load({ 
	    params: formaction.getForm().getValues()//提交form表单
	});
};
//添加一个空行
var add=function (btn) {
	//gridpanel.getStore().insert(0, UserModel);  
//    rowEditing.cancelEdit();	
    // Create a model instance
    var r = Ext.create('UserModel', {
    	 user_name:"",
    	 user_sex:"",
    	 user_pk:"",
    	 user_number:"",
    	 user_birthday:"",
    	 user_intime:"",
    	 user_password:"",
    	 fk_station_pk:"",
    	 fk_roles_pk:""
    });
    Ext.getCmp('list').getStore().insert(0, r);
//    rowEditing.startEdit(0, 0);
};

var v;
//导入excel
var import_excel=function()
{
	v = new fileuploadwd();
    v.show();
};

//导出excel 第一种实现方式
//var export_excel = function () {          
//    Ext.Msg.minWidth = 250;
//    //params: formaction.form.getValues();
//    var user_name=Ext.getCmp('user.user_name').getValue();
//    Ext.Msg.confirm("提示信息", "确认要导出吗？", function (btn) {
//        if (btn == "no") { return false}
//        else {
//            if (btn == "yes") {
//            	waitMsg : "正在导出";
//        		//var url=Ext.urlEncode("user.user_name='"+user_name+"'")
//            	var url="user.user_name="+user_name+"";
//            	window.location="export.action?"+url;
//            }
//        }
//    })
//}

//导出excel第二种实现方式
var export_excel=function()
{   
	//获取form表单的所有值
	 //var formValues=formaction.getForm().getValues();
	 var formValues=Ext.getCmp('formconditions').form.getValues();
	 //var params=Ext.encode(formValues);
	 var params=Ext.urlEncode(formValues);//此处必须这样写，否则后台无法接收数据
	 window.location="user_export.action?"+params;
	 Ext.Msg.alert("表单对象",Ext.urlEncode(formValues));
};

var save=function(){
	var records = gridpanel.getStore().getUpdatedRecords();//获取修改的行的数据   
	var newRecords = gridpanel.getStore().getNewRecords();//获得新增行的数据   
	//保存修改数据
	if(records.length>0){  
		var jsonArray = [];
		for(var i=0;i<records.length;i++){   
	        jsonArray.push(records[i].data);
	        console.log(records[i].data);
		}
		Ext.Msg.alert("修改数据",Ext.encode(records[0].data));
		if(jsonArray.length>0)
	        {
	        	Ext.Ajax.request({
                    url: '/MyCompany/user/save.action', //保存
                    method:'POST',  
                    contentType:'application/json',
                    params:{datas:Ext.encode(jsonArray)},
                    //params:{datas:JSON.stringify(jsonArray)},
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
                    url: '/MyCompany/user/save.action', //保存
                    method:'POST',  
                    params:{datas:Ext.encode(jsonArray)},
                    //params:{datas:jsonArray[i].data},
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
////保存数据
//var save=function(btn)
//{	  
//	var records = gridpanel.getStore().getUpdatedRecords();//获取修改的行的数据   
//	var newRecords = gridpanel.getStore().getNewRecords();//获得新增行的数据     
//	//保存新增的数据
//	if(newRecords.length>0){  
//		var jsonArray = [];
//		for(var i=0;i<newRecords.length;i++){  
//	        data = newRecords[i];  
//	        jsonArray.push(data);
//	        if(jsonArray.length>0)
//            {
//	        	var user_name=data.get('user_name');
//	        	var user_sex=data.get('user_sex');
//	        	var user_pk=data.get('user_pk');
//	        	var user_number=data.get('user_number');
//	        	var user_birthday=data.get('user_birthday');
//	        	var user_intime=data.get('user_intime');
//	        	var user_password=data.get('user_password');
//	        	var fk_station_pk=data.get('fk_station_pk');
//	        	var user_phone=data.get('user_phone');
//	        	var user_email=data.get('user_email');
//	        	var fk_roles_pk=data.get('fk_roles_pk');
//                Ext.Ajax.request({
//                    url: 'save.action', //保存
//                    params: { 
//                    	'user.user_name': user_name,
//                    	'user.user_sex':user_sex,
//                    	'user.user_pk':user_pk,
//                    	'user.user_number':user_number,
//                    	'user.user_birthday':user_birthday,
//                    	'user.user_phone':user_phone,
//                    	'user.user_email':user_email,
//                    	'user.user_intime':user_intime,
//                    	'user.user_password':user_password,
//                    	'user.fk_station_pk':fk_station_pk,
//                    	'user.fk_roles_pk':fk_roles_pk
//                    },
//                    success: function (response, options) {
//                        var res = response.responseText;
//                        if (res == null) {
//                            Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
//                            return;
//                        }
//                        else{
//                        	Ext.Msg.alert("提示信息", "保存成功！");
//                        	gridpanel.getStore().reload();//添加成功后刷新数据
//                        }
//                    },
//                    failure: function () {
//                        Ext.Msg.alert("提示信息", "出现异常！");
//                    }
//                });
//            }	 
//		}  
//	}
//	//保存修改的数据
//	if(records.length>0){  
//		var jsonArray = [];
//		for(var i=0;i<records.length;i++){  
//	        data = records[i];  
//	        jsonArray.push(data);
//	        if(jsonArray.length>0)
//            {
//	        	var user_name=data.get('user_name');
//	        	var user_sex=data.get('user_sex');
//	        	var user_pk=data.get('user_pk');
//	        	var user_number=data.get('user_number');
//	        	var user_birthday=data.get('user_birthday');
//	        	var user_phone=data.get('user_phone');
//	        	var user_email=data.get('user_email');
//	        	var user_intime=data.get('user_intime');
//	        	var user_password=data.get('user_password');
//	        	var fk_station_pk=data.get('fk_station_pk');
//	        	var fk_roles_pk=data.get('fk_roles_pk');
//                Ext.Ajax.request({
//                    url: 'save.action', //保存
//                    params: { 
//                    	'user.user_name': user_name,
//                    	'user.user_sex':user_sex,
//                    	'user.user_pk':user_pk,
//                    	'user.user_number':user_number,
//                    	'user.user_birthday':user_birthday,
//                    	'user.user_phone':user_phone,
//                    	'user.user_email':user_email,
//                    	'user.user_intime':user_intime,
//                    	'user.user_password':user_password,
//                    	'user.fk_station_pk':fk_station_pk,
//                    	'user.fk_roles_pk':fk_roles_pk
//                    },
//                    success: function (response, options) {
//                        var res = response.responseText;
//                        if (res == null) {
//                            Ext.Msg.alert("提示信息", "错误消息", "出现异常！");
//                            return;
//                        }
//                        else{
//                        	Ext.Msg.alert("提示信息", "保存成功！");
//                        	gridpanel.getStore().reload();//成功后刷新数据
//                        }
//                    },
//                    failure: function () {
//                        Ext.Msg.alert("提示信息", "出现异常！");
//                    }
//                });
//            }	 
//		}
//	}
//};
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
	        	ids += rowsSelected[i].get("user_pk") + ",";
	        }
           Ext.Msg.show({
                title: '消息提示',
                message: '您确定删除数据?',
                buttons: Ext.Msg.YESNOCANCEL,
                icon: Ext.Msg.QUESTION,
                fn: function (btn) {//用户点击交互后调用的函数，btn是指用户点了那个按钮
                    if (btn === 'yes') {
                        Ext.Ajax.request({
                            url: '/Wms/user/delete.action', //批量删除
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
