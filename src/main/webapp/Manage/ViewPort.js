var panel = new Ext.Panel({
			//title : '入库计划信息管理',
			id:'panel', 
			//autoHeight:true,
			layout: 'vbox',
			height: 76,
			bodyStyle: {  
                 background: 'url(Images/newimg/top.png)'
            },  
			items : [
				{
					xtype:'container',
					style:'margin-top:43px',
//					bodyStyle : 'width:100%',
					autoWidth:true,
					layout: {
				        type: 'hbox',
				        pack: 'end',              //纵向对齐方式 start：从顶部；center：从中部；end：从底部
				        align: 'right'             //对齐方式 center、left、right：居中、左对齐、右对齐；stretch：延伸；stretchmax：以最大的元素为标准延伸
				    },
					items:[
//							{
//								xtype:'button',
//								width: 100,
//								height: 30,
//								text: '收缩'
//							}
					]
				}
			]
});
Ext.onReady(function() {
	
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
	  	defaults : {
            autoScroll : true
        },
		items : [
					{ 
						//collapsible : true,//收缩菜单栏
						region : 'north',
						//html : ' <div text-align:center; region="north" split="true" border="false" style="overflow: hidden; height: 30px;line-height:30px;background: #157FCC repeat-x center 50%; color: #fff; font-family: Verdana, 微软雅黑,黑体"><span style="float: right; padding-right: 20px;" class="head">欢迎您使用！ <font color="red"><%=Session["Roles_Name"]%></font>&nbsp;&nbsp;<font color="red"><%=Session["RealName"]%></font>&nbsp;&nbsp;<a href="#" id="editpass" onclick="modifyPwd()"><font color="white">修改密码</font></a> <a href="#" id="loginOut" onclick="logOut()"><font color="white">安全退出</font></a></span> <span style="padding-left: 10px;font-size: 16px;"><img src="Images/blocks.gif" width="20" height="20" align="absmiddle" /><font color="white">仓库管理系统</font></span></div>', 
						//html:'<div style="text-align:center;vertical-align: middle;background:url(Images/newimg/top.png);height:76px;"></div>',
						border : false,
						items:[
						 panel
						],
						margin : '0 0 5 0' 
				     }, 
			         {
						region : 'west',
						collapsible : true,//收缩菜单栏
						split : true, 
						title : '管理菜单',
						width : 200,
						layout : 'fit',
						items:[tree]
						//折叠展开事件
//						listeners:{
//							collapse:{
//								fn:function(p,options){
//									dorefresh();
//								}
//							},
//							expand:{
//								fn:function(p,options){
//									dorefresh();
//								}
//							}
//						}
					},
					 { 
						 region : 'south', 
						 //title : 'South Panel', 
						 //collapsible :true, 
						 html : '<div style="background: #157FCC;text-align:center"> <font color="white">天津市小蜜蜂计算机技术有限公司  CopyRight © 2010-2014 By ACBEE </font> </div>'
						 //split : true
						 //height :20 
						 //minHeight : 100 
					 },
					/*
					 * { region : 'east', title : 'East Panel', collapsible : true,
					 * split : true, width : 150 },
					 */
					{
						region : 'center',
						animate: true, //动画效果启用 
						layout:'fit',
						items:[contentPanel]
					}
				]
	});
});


var contentPanel=new Ext.TabPanel({
	id:'centerP',
	enableTabScroll:true,//能够滚动收缩
	autoScroll:true,
	//resizeTabs : true,  
	activeTab:0,//激活第一个标签
	items:[{
	id:'homePage',
	layout:'fit',
	title:'首页',
	html:'<iframe id="hpdiv" scrolling="auto" frameborder="0" width="100%" height="100%" src="Welecome.jsp"></iframe>'
	}]

});

var store = Ext.create('Ext.data.TreeStore', {
root : {
		expanded : false,//树形菜单合并
		children : [
		            {
					text : "基本管理",
					//iconCls:'add',
					icon:"Images/newimg/base.png",
					//icon:'base',
					expanded : true,//菜单展开
					children : [{
								text : "客户信息",
								icon:"Images/newimg/customer.png",
								url:'Manage/BaseManage/CustomerManage/html/Customer.jsp',
								leaf : true
								}, {
									text : "货物信息",
									icon:"Images/newimg/goods.png",
									url:'Manage/BaseManage/GoodsManage/html/Goods.jsp',
									leaf : true
								}, {
									text : "库位信息",
									icon:"Images/newimg/location.png",
									url:'Manage/BaseManage/LocationManage/html/Location.jsp',
									leaf : true
								}, {
									text : "员工信息",
									icon:"Images/newimg/usermsg.png",
									url:'Manage/BaseManage/UserManage/html/User.jsp',
									leaf : true
								}]
		            },
		            {
					text : " 生产管理",
					icon:"Images/newimg/inmsg.png",
					//expanded : true,
					children : [{
								text : "生产计划",
								icon:"Images/newimg/inplan.png",
								url:'Manage/ProductionManage/ProductionPlanForm/html/ProductionPlanForm.jsp',
								leaf : true
							}, {
								text : "生产实际",
								icon:"Images/newimg/goodsin.png",
								url:'Manage/ProductionManage/ProductionActualForm/html/ProductionActualForm.jsp',
								leaf : true
							}
							]
		            },
		            {
					text : "入库管理",
					icon:"Images/newimg/inmsg.png",
					//expanded : true,
					children : [{
								text : "入库计划",
								icon:"Images/newimg/inplan.png",
								url:'Manage/InStockManage/InStockPlanForm/html/InStockPlanForm.jsp',
								leaf : true
							}, {
								text : "货物入库",
								icon:"Images/newimg/goodsin.png",
								url:'Manage/InStockManage/InStockForm/html/InStockPlanForm.jsp',
								leaf : true
							}, {
								text : "未入库查询",
								icon:"Images/newimg/stockselect.png",
								url:'Manage/InStockManage/CheckInStock/html/InStockPlanFormContent.jsp',
								leaf : true
							}
							]
		            },
		            {
						text : "出库管理",
						icon:"Images/newimg/outmsg.png",
						//expanded : true,
						children : [{
									text : "出库计划",
									icon:"Images/newimg/outplan.png",
									url:'Manage/OutStockManage/OutStockPlanForm/html/OutStockPlanForm.jsp',
									leaf : true
								}, {
									text : "货物出库",
									icon:"Images/newimg/goodsout.png",
									url:'Manage/OutStockManage/OutStockForm/html/OutStockForm.jsp',
									leaf : true
								},
								{
									text : "出库单据",
									icon:"Images/newimg/goodsout.png",
									url:'Manage/OutStockManage/OutStockFormPrint/html/OutStockFormPrint.jsp',
									leaf : true
								},
								{
									text : "显示看板",
									icon:"Images/newimg/show.png",
									url:'Manage/OutStockManage/OutStockBoard/html/OutStockBoard.jsp',
									leaf : true
								}]
			          },
			          {
							text : "库存管理",
							icon:"Images/newimg/stockmsg.png",
							//expanded : true,
							children : [{
										text : "库存查询",
										icon:"Images/newimg/stockselect.png",
										url:'Admin/UserManage/html/User.html',
										leaf : true
									}, {
										text : "流水查询",
										icon:"Images/newimg/logselect.png",
										url:'register.jsp',
										leaf : true
									},{
										text : "流量统计",
										icon:"Images/newimg/liulang.png",
										url:'register.jsp',
										leaf : true
									},{
										text : "容积率统计",
										icon:"Images/newimg/rongji.png",
										url:'register.jsp',
										leaf : true
									}]
				          },
				          {
								text : "系统管理",
								icon:"Images/newimg/sysmsg.png",
								//expanded : true,
								children : [{
											text : "权限设置",
											icon:"Images/newimg/roles.png",
											url:'Manage/SystemManage/RolesManage/html/Roles.jsp',
											leaf : true
										}, {
											text : "备份还原",
											icon:"Images/newimg/bf.png",
											url:'register.jsp',
											leaf : true
										}]
					         }
				          ]
		}
});

var tree=Ext.create('Ext.tree.Panel', {
	useArrows : true,//展开按钮图标是箭头还是+-
	store : store,
	rootVisible : false

});

tree.on("itemclick", treeClick);

function treeClick(view, record, item, index, e) {
	var text = record.get('text');// 获取tree的叶子节点的值
	var leaf = record.get('leaf');
	var url= record.get('url');
	var tabPage = contentPanel.getComponent(text);// 判断面板中是否存在该页面
	if (leaf)// 判断是否是叶子节点
	{
		if (!tabPage) {
			var id = text;
			//var index = contentPanel.items.length + 1;
			tabPage = contentPanel.add({// 动态添加tab页
				// tabPanel.add({//动态添加tab页
				"id" : id,
				title : text,
			    layout:'fit',
				html : '<iframe id="hpdiv" scrolling="no" frameborder="0" width="100%" height="100%" src='+url+'></iframe>',
			    //autoLoad : {url: record.data.url, scripts: true},
				closable : true// 允许关闭
			});
			contentPanel.setActiveTab(tabPage);// 激活当前tab页
		} else {
			contentPanel.setActiveTab(tabPage);// 激活当前tab页
		}
	}
}
