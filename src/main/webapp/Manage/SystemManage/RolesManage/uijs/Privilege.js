/**
 * 权限设置 author myd 2015-6-2 version 1.0
 */
var tree = Ext.create('Ext.tree.Panel', {
			useArrows : true,// 展开按钮图标是箭头还是+-
			id:'tree_list',
			height : 430,
			store : TreeStore,
			bodyStyle : 'overflow-x:hidden; overflow-y:scroll',
			rootVisible : false

		});
tree.on("checkchange", treeClick);
// 创建panel
var treepanel = new Ext.Panel({
			id : 'treepanel',
			items : [{
						xtype : 'container',
						layout : 'hbox',
						layoutConfig : {
							align : 'middle'
						},
						items : [{
									xtype : 'button',
									width : 80,
									text : '确定',
									style : 'margin-left:50px;',
									handler : 'treeadd',
									scope : this
								}]
					}]
		});

var wind = new Ext.Window({
			title : '权限设置',
			height : 500,
			// autoScroll : true,
			width : 200,
			resizable : true,
			modal : true,
			closable : true,
			closeAction : 'hide',
			items : [tree, treepanel]
//			listeners : {
//					"close":function(){
//						Ext.getCmp('tree_list').getStore().removeAll();
//					}
//				}

		});

var treeadd = function(btn)
{
//	var ck_ids = "";
//	var uk_ids = "";
	var privilegeroles_pk="";
	var fk_privilege_pk="";
	var checked="";
	var jsonArray = [];
	var roonodes = tree.getRootNode().childNodes; // 获取主节点
	findchildnode(roonodes); // 开始递归
	function findchildnode(node)
	{
		for (var i = 0; i < node.length; i++)
		{ // 从节点中取出子节点依次遍历
			var rootnode = node[i];
//			if(rootnode.data.checked ==true)
//			{
////				privilegeroles_pk=rootnode.data.privilegeroles_pk;
////				fk_privilege_pk=rootnode.data.id;
////				checked=true;
//				jsonArray.push(rootnode.data)
//				//ck_ids+=rootnode.data.id+",";
//			}
//			else
//			{
//				privilegeroles_pk=rootnode.data.privilegeroles_pk;
//				fk_privilege_pk=rootnode.data.id;
//				checked=true;
//				//uk_ids+=rootnode.data.id+",";
//			}
			jsonArray.push(rootnode.data);
			var child=node[i].childNodes;
			if (child.length > 0)
			{ // 判断子节点下是否存在子节点，个人觉得判断是否leaf不太合理，因为有时候不是leaf的节点也可能没有子节点
				findchildnode(child); // 如果存在子节点 递归
			}
		}
	}

	if (jsonArray.length > 0)
	{
		Ext.Ajax.request({
					url : '/WebWms/privilege/save.action', // 保存
					method : 'POST',
					params : {
						datas : Ext.encode(jsonArray)
					},
					// params:{datas:jsonArray[i].data},
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
							TreeStore.reload();// 添加成功后刷新数据
						}
					},
					failure : function()
					{
						Ext.Msg.alert("提示信息", "出现异常！");
					}
				});
	}
};
// 首先给树添加checkchange监听事件
// tree.on('checkchange',function(node, checked){
// checkboxSelected(node,checked);
// });

function treeClick(node, checked)
{
	setChildChecked(node, checked);
	setParentChecked(node, checked);
}
// 选择子节点树
function setChildChecked(node, checked)
{
	node.expand();
	node.set('checked', checked);
	if (node.hasChildNodes())
	{
		node.eachChild(function(child)
				{
					setChildChecked(child, checked);
				});
	}
}
// 选择父节点树
function setParentChecked(node, checked)
{
	node.set({
				checked : checked
			});
	var parentNode = node.parentNode;
	if (parentNode != null)
	{
		var flag = false;
		parentNode.eachChild(function(childnode)
				{
					if (childnode.get('checked'))
					{
						flag = true;
					}
				});
		if (checked == false)
		{
			if (!flag)
			{
				setParentChecked(parentNode, checked);
			}
		} else
		{
			if (flag)
			{
				setParentChecked(parentNode, checked);
			}
		}
	}
}
