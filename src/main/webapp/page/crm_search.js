Ext.namespace('com.shsun.ad.crm.crm_third.Crm_SearchGridPanel');
com.shsun.ad.crm.crm_third.Crm_SearchGridPanel=Ext.extend(Ext.Panel, {
	
	//定义全的header
	allColumns: [
	    { header:'日期', dataIndex: 'DATE_TIME',statCondtionName: 'group_date', menuDisabled: true, resizable: true,sortable: true},
		{ header:'ID',  dataIndex: 'VIDEO_GROUP_ID',statCondtionName: 'group_video_group_id', menuDisabled: true, resizable: true,sortable: true},
		{ header:'名称',  dataIndex:'VIDEO_GROUP_NAME',statCondtionName: 'group_video_group_name', menuDisabled: true, resizable: true,sortable: true},
		{ header:'网站',   dataIndex: 'SITE_NAME', statCondtionName: 'group_site', menuDisabled: true, resizable: true,sortable: true},
		{ header:'广告类型',   dataIndex: 'SLOT_NAME',statCondtionName: 'group_slot_id', menuDisabled: true, resizable: true,sortable: true},
		{ header:'视频时长',  dataIndex: 'videoLengthTypeLabel',statCondtionName: 'group_videolength_type', menuDisabled: true, resizable: true,sortable: true}
	],
	initComponent: function() {
		var h = parseInt(document.body.clientHeight*0.5);
		
		//广告类型选择
		var selectAD2 = {
			layout: 'column',
			items: [
				{
					width: 360,
					xtype: 'fieldset',
				    title: '请选择广告类型',
				    labelWidth: 1,
				    items: [{
				    	xtype: 'checkboxgroup',
				    	name: 'myGroup',
				        items:[
							{
								boxLabel: '全选',
							    name: 'all',
							    listeners: {
							    	'check': {
							    		scope: this,
							    		fn: function(cb, checked) {
								    		var cbitems = this.fp.getForm().findField('myGroup').items;
								    		for (var i = 1; i < cbitems.length; i++) {    
								    			cbitems.items[i].setValue(checked);
					                        }   
								    	}
							    	}
							    }
							},  
							{
								boxLabel: '前贴', 
								inputValue: 1,
								checked:true,
								name:'slot_preroll_selected',
								scope: this,
								listeners:{
									'check':{
										scope: this,
							    		fn: function(cb, checked) {
							    			if(!checked){
							    				this.fp.getForm().findField('all').el.dom.checked = false;
							    				this.fp.getForm().findField('all').checked = false;
							    			}
							    		}
									}
								}
							},
							{
								boxLabel: '中插', 
								inputValue: 1,
								name: 'slot_midroll_selected' ,
								listeners:{
									'check':{
										scope: this,
							    		fn: function(cb, checked) {
							    			if(!checked){
							    				this.fp.getForm().findField('all').el.dom.checked = false;
							    				this.fp.getForm().findField('all').checked = false;
							    			}
							    		}
									}
								}
							}, 
							{
								boxLabel: '暂停', 
								inputValue: 1,
								name: 'slot_pause_selected',
								listeners:{
									'check':{
										scope: this,
							    		fn: function(cb, checked) {
							    			if(!checked){
							    				this.fp.getForm().findField('all').el.dom.checked = false;
							    				this.fp.getForm().findField('all').checked = false;
							    			}
							    		}
									}
								}
							}, 
							{
								boxLabel: '后贴', 
								inputValue: 1,
								name: 'slot_postroll_selected',
								listeners:{
									'check':{
										scope: this,
							    		fn: function(cb, checked) {
							    			if(!checked){
							    				this.fp.getForm().findField('all').el.dom.checked = false;
							    				this.fp.getForm().findField('all').checked = false;
							    			}
							    		}
									}
								}
							}
				        ]
				    }]
				},
				{
					width: 200, layout: 'form',labelWidth: 80,
					items: [
						new Ext.form.ComboBox({
							fieldLabel:'视频时长',
							name:'video_length_id',
							hiddenName: 'video_length_id',
							triggerAction:'all',
							editable:false,
							anchor : '95%',
							mode:'local',
							valueField:'value',
							displayField:'text',
							value:'-999',
							store : new Ext.data.SimpleStore({
								fields: ['value', 'text'],
								data: [['-999', '全部'],['1', '长'],['0', '短']]		    					
							})
						}),
						new Ext.form.ComboBox({
							fieldLabel:'选择网站',
							name:'site',
							hiddenName: 'site',
							triggerAction:'all',
							editable:false,
							anchor : '95%',
							mode:'local',
							valueField:'value',
							value:'1',
							displayField:'text',
							store : new Ext.data.SimpleStore({
								fields: ['value', 'text'],
								data: [['1', '优酷'],['2', '土豆'],['-999', '优酷+土豆']]		    					
							})
						})
					]
				},
				{
					width: 300,
					layout: 'hbox',
					xtype: 'fieldset',
				    title: '选择时间',
				    labelWidth: 1,
				    layoutConfig: {
                        padding:'5',
                        align:'middle'
                    },
                    defaults:{margins:'0 7 0 0'},
				    items: [
						{xtype:'displayfield', value:'起始'},
						{xtype: 'datefield',name : 'start_date', format:'Y-m-d',editable:false,anchor : '99%',value:new Date(new Date()-1000*60*60*24)},
						{xtype:'displayfield', value:'结束'},
						{xtype: 'datefield',name : 'end_date', format:'Y-m-d', editable:false,anchor : '99%',value:new Date()}
				    ]
				}
			]
		};
		
	    //请选择视频
	    var radioGroup = {
            xtype: 'fieldset',
            title: '视频选项组',
            width: 820,
            layout: 'column',
            items: [
				{
				    xtype: 'radiogroup',
				    width: 180,
				    items: [
				        {boxLabel: '视频组查询', name: 'is_video_group', inputValue:1, checked: true},
				        {boxLabel: '节目组查询', name: 'is_video_group', inputValue:0}
				    ]
				},
	            {
					layout: 'form',
					items: [
					     {
					    	 xtype: 'numberfield', name: 'video_group_id', fieldLabel: '视频组(节目)ID', anchor: '98%'
					     }   
					]
	            },
	            {
	            	layout: 'form',
                	items: [
					     {
					    	 xtype: 'textfield', name: 'video_group_name', fieldLabel: '视频组(节目)名称', width:'180px'
					     }   
					]
	            }
			]
        };
	    
	    //选择=数据导出条数
	    var exportData_CountForm = this.exportData_CountForm = new Ext.form.FormPanel({
	    	labelAlign: 'right',
			labelWidth: 70,
			frame: true,
			height:50,
			xtype: 'fieldset',
			width: 400,
	        layout: 'column',
	        items: [
		          {
						layout: 'form',
						items: [
						     {
						    	 xtype: 'numberfield', width:100,name: 'start_count', fieldLabel: '开始条数',allowBlank:true,blankText:'开始条数',value:'1'
						     }   
						]
		            },
		            {
		            	layout: 'form',
	                	items: [
						     {
						    	 xtype: 'numberfield',width:100,name: 'end_count', fieldLabel: '结束条数',allowBlank:true,blankText:'开始条数',value:'5000'
						     }   
						]
		            }
			]
	    })
	    
	    var statCondition = {
			layout:'column',
			items:[
			    {
			    	width: 590,
					xtype: 'fieldset',
				    title: '选择汇总条件',
				    labelWidth: 1,
				    layout: 'form',
				    items: [
				            {
				    	xtype: 'checkboxgroup',
				    	name: 'statConditionGroup',
				        items:[
			               	{ boxLabel: 'ID汇总',      name: 'group_video_group_id' ,inputValue:'1'},
			               	{ boxLabel: '名称汇总',     name: 'group_video_group_name' ,inputValue:'1'},
			                { boxLabel: '视频时长汇总',  name: 'group_videolength_type',inputValue:'1'}, 
			                { boxLabel: '日期汇总',     name: 'group_date' ,inputValue:'1'}, 
			                { boxLabel: '广告类型汇总',  name: 'group_slot_id' ,inputValue:'1'},  
			                { boxLabel: '网站汇总',     name: 'group_site',inputValue:'1'} 
				        ]
				    }
				            ]
			    },  
			    {
			    	width: 255,
			    	layout: 'hbox',
			    	layoutConfig: {
                        padding:'5',
                        align:'middle'
                    },
                    items:[{
				    	buttons: [{
			    			text:'查询',
			    			scope: this,
							handler:function() {
//								alert(!this.fp.getForm().isValid());
//								console.log("!this.fp.getForm().isValid()) = "+!this.fp.getForm().isValid());
								if(!this.fp.getForm().isValid())
									return;
								var bool = this.validateSP();
								var sum=0;
								var f = this.fp.getForm().findField("myGroup").items;
								for(var i = 0; i < f.length;i++){
									if(f.items[i].checked==true)
										sum++;
								}
								if(sum <= 0){
									Ext.MessageBox.alert('提示', "广告类型不能为空");
									return;
								}else if(!bool){
									Ext.MessageBox.alert('提示', "节目组ID和节目组名称不能同时为空！");
									return;
								}
								else {
									this.reconfigGrid();
									this.doSearch();
								}
							}
			    		},
			    		{
			    			text:'导出',
			    			scope: this,
			    			handler:function(){
			    				if(!this.fp.getForm().isValid())
									return;
			    				var bool = this.validateSP();
			    				var sum=0;
								var f = this.fp.getForm().findField("myGroup").items;
								for(var i = 0; i < f.length;i++){
									if(f.items[i].checked==true)
										sum++;
								}
								if(sum <= 0 ){
									Ext.MessageBox.alert('提示', "广告类型不能为空");
									return;
								}else if(!bool){
									Ext.MessageBox.alert('提示', "节目组ID和节目组名称不能同时为空！");
									return;
								}
								else {
				    				this.doExport_init();
								}
			    			}
			    		},
			    		{
			    			text:'清空',
			    			handler:function(){
			    				fp.form.reset();
			    			}
			    		}
			    	]
			    }]
			 }]
		}
	    
	    //属性面板
		 var fp = this.fp = new Ext.FormPanel({
		 	region:'north',
			frame: true,
			height: 200,
			split: true,
			labelAlign: 'right',
	        items: [selectAD2,radioGroup,statCondition]
		 });
		 
		 //加载数据列表
		 var store = this.store = new Ext.data.Store({
	 		proxy : new Ext.data.HttpProxy({url:this.ctx + "/videogroup/queryvideogroupinventory.sdo"}),
	 		reader : new Ext.data.JsonReader({
	 			totalProperty:"total",
	 			root:"invdata"
	 		},[
	 			{name: 'VIDEO_GROUP_ID'},//ID
	            {name: 'VIDEO_GROUP_NAME'},//名称
	            {name: 'SITE_NAME'},//网站 
	            {name: 'SLOT_NAME'},//广告类型
	            {name: 'videoLengthTypeLabel'},//视频时长
	            {name: 'DATE_TIME'},//日期
	            {name: 'RADI'}//容量
	 		])
		 });
		
	    
	    var cm = this.cm = new Ext.grid.ColumnModel([
			new Ext.grid.RowNumberer(),
            { header:'广告类型',  dataIndex: 'SLOT_NAME',menuDisabled: false, resizable: false,sortable: true},
            { header:'视频时长',  dataIndex: 'videoLengthTypeLabel',menuDisabled: false, resizable: false,sortable: true},
            { header:'日期',     dataIndex: 'DATE_TIME',menuDisabled: false, resizable: false,sortable: true},
            { header:'容量',     dataIndex: 'RADI',menuDisabled: false, resizable: false,sortable: true}
   		]);
	    
	    var grid = this.grid = new Ext.grid.GridPanel({
	    	region: 'center',
	        store: store,
	        colModel: cm, 
	        loadMask: true,
	        columnLines:true,
	        viewConfig: {
				forceFit: true
			},
			bbar: new Ext.CostPagingToolbar({
	            pageSize: 60,
				store: store,
				displayInfo: true,
				displayMsg: '显示第{0}条到{1}条记录,一共{2}条, 共耗时{3}秒',
				emptyMsg: '当前条件下没有记录'
	        })
	    });
	    
		 Ext.apply(this, {  
            iconCls: 'tabs',  
            autoScroll: false,  
            closable: true,
            layout: 'border',
            items:[fp,grid]
        });  
	 
		//调用父类构造函数（必须）  
		 com.shsun.ad.crm.crm_third.Crm_SearchGridPanel.superclass.initComponent.apply(this, arguments);
	},
	
	initMethod: function() {
	},
	
	//动态生成列
	reconfigGrid: function() {
		var myColumns = [];
		var sc = this.fp.getForm().findField('statConditionGroup').getValue();
		for(var i = 0; i < this.allColumns.length; i++) {
			if(sc.length == 0) {
				myColumns.push(this.allColumns[i]);
			}
			else {
				for(var j = 0; j < sc.length; j++) {
					if(sc[j].name == this.allColumns[i].statCondtionName) {
						myColumns.push(this.allColumns[i]);
					}
				}
			}
		}
		myColumns.push({ header:'容量', dataIndex: 'RADI', menuDisabled: true,resizable: true,sortable:true,align:'right',renderer:rmbMoneyRender});
		
		this.cm = new Ext.grid.ColumnModel({
			columns: myColumns
		});
		this.grid.reconfigure(this.grid.store, this.cm);
		this.grid.store.removeAll();
	},
	
	//数据查询
	doSearch: function() {
		this.grid.store.baseParams= this.fp.getForm().getValues();
		this.grid.store.load({params: {"start":0, "limit":60}});
	},
	
	//初始化数据导出面板
	doExport_init: function(){
		 var th = this;
		 var  win = this.win =  new Ext.Window({
             layout:'fit',
             title:'填写导出数据条数',
             width:400,
             closeAction:'hide',
             buttonAlign:'center',
             modal: true,
             items: [this.exportData_CountForm],
             buttons: [
             {
                 text:'确定',
                 scope:th,
                 onClick:function(){
                	 th.doExport_Sub();
                 }
             },{
                 text: '关闭',
                 handler: function(){
                     win.hide();
                 }
             }]
         });
		 win.show();
	},
	//提交导出请求
	doExport_Sub: function(){
		var start_count = this.exportData_CountForm.getForm().findField("start_count").getValue(); 
		var end_count = this.exportData_CountForm.getForm().findField("end_count").getValue(); 
   	    var s = this;
     	if(start_count > end_count){
     		Ext.MessageBox.alert('提示', "开始条数不能大于结束条数！",function(but){
     			 Ext.get("start_count").frame("red",1,{duration : 1});
     			 Ext.get("end_count").frame("red",1,{duration : 1});
			});
     	}else{
     		var expUrl = ctx + "/videogroup/exportexcel.sdo";//定义访问路径
     		
     		var paramObj = {};
     		var ex_baseParameObj = this.fp.getForm().getValues();
     		Ext.apply(paramObj, ex_baseParameObj);
     		paramObj.startRow = start_count;
     		paramObj.endRow = end_count;
     		paramObj.exportExcelMode = 1;
     		
     		//获取当前选择表单条件和数据条数
//    		var ex_baseParames = this.fp.getForm().getValues(true);
    		var cms = this.grid.getColumnModel();//处理需要传递的参数
//
			var coloumnNames = "";//列显示名称
			var coloumnIndexs = "";//列物理名称
			for(var i = 0; i < cms.getColumnCount(); i++) {
				
				//判断列是空或是操作列除外
				if(cms.getColumnHeader(i) == '' || cms.getColumnHeader(i) == '操作')
					continue;
				
				//获取非隐藏列	
				if (!cms.isHidden(i)) {
					var dataIndex = cms.getDataIndex(i);
					if(dataIndex) {
						coloumnIndexs += cms.getDataIndex(i) + ',';
						coloumnNames += cms.getColumnHeader(i) + ',';	
					}
				}
			}
			
			var pf = expUrl + '?exp_coloumnNames=' + encodeURI(encodeURI(coloumnNames)) + '&exp_coloumnIndexs=' + coloumnIndexs;		
			var url = Ext.urlEncode(paramObj, pf);
			if(Ext.isIE6 || Ext.isIE7 || Ext.isIE8) {
				window.location.href = url;
			}
			else {
				window.open(url);
			}
			this.win.hide();
     	}
     	this.exportData_CountForm.getForm().findField("start_count").setValue("1");
     	this.exportData_CountForm.getForm().findField("end_count").setValue("5000");
	},
	//当选择了节目组查询（is_video_group），视频组(节目)ID(video_group_id)和视频组(节目)名称(video_group_name) 不能同时为空。
	validateSP:function(){
		var is_video_group_State = this.fp.getForm().findField("is_video_group").getValue();
		if(!is_video_group_State){
			
			var video_group_id = this.fp.getForm().findField("video_group_id").getValue();
			var video_group_name = encodeURI(encodeURI(this.fp.getForm().findField("video_group_name").getValue()));
			
			if(video_group_id == '' && video_group_name == '')
				return false;
			else
				return true;
		}
		return true;
	}
})