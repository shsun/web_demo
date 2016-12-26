fileuploadwd = Ext.extend(Ext.Window, {
	xtype : "window",
	title : "文件上传",
	width : 400,
	modal : true,
	resizable : true,
	buttonAlign : 'center',
	initComponent : function() {
		this.items = [{
		xtype : "form",
		id : "form",
		fileUpload : true,
		// url: "upload.action",
		layout : "form",
		items : [{
			xtype : "container",
			style : "margin-top:20px;",
			height : 40,
			region : 'center',
			layout : {
				type : 'hbox',
				align : 'middle ',
				pack : 'center'
			},
			items : [{
						xtype : 'filefield',
						name : 'file',
						fieldLabel : '上传',
						allowbBlank : false,
						msgTarget : 'side',
						buttonText : '选择文件'
					}

			]
		}, {
			xtype : "container",
			style : "margin-top:20px;",
			region : 'center',
			layout : {
				type : 'hbox',
				align : 'middle ',
				pack : 'center'
			},
			height : 40,
			items : [{
						xtype : "button",
						text : "上传",
						height : 30,
						style : "margin-left:20px;",
						handler : btnsubmitclick
					}, {
						xtype : "button",
						text : "关闭",
						height : 30,
						style : "margin-left:10px;",
						handler:btnclose
					}]
		}]
	  }];
	fileuploadwd.superclass.initComponent.call(this);
	}
});

//关闭
var btnclose = function() {
	v.destroy();
};
//上传
var btnsubmitclick = function() {
	Ext.Msg.alert("提示", "上传");
	var form = Ext.getCmp("form");
	if (form.isValid()) {
		form.submit({
					url : 'userupload.action',
					waitMsg : '正在上传',
					success : function(fp, o) {
						Ext.Msg.show({
									title : '提示信息',
									msg : '文件上传成功，上传文件名为：'
											+ o.result.fileFileName,
									buttons : Ext.Msg.OK
								});
					}
				});
	}
};