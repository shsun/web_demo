var DEBUG = true;

if(DEBUG == false){
	console && ( console.log =console.debug = function(){} )
}

var ycate = null;
var tcate = null;

function requestChannel(path,callback) {
	/*
	 * NOTE : 
	 * Pass 'isMobile=1' if request under mobile-mode, otherwise skip this parameter. 
	 * So, please update the function to function requestChannel(path,callback,isMobile)
	 * 
	 * 
	 * e.g :
	 * $.post(path+'/as/queryChannel.sdo',function(data){
	 * 
	 * $.post(path+'/as/queryChannel.sdo?isMobile=1',function(data){
	 */
	var mobi =""
	if(location.href.indexOf('isMobile') != -1 ){
		mobi ="?isMobile=1";
	}
	$.post(path+'/as/queryChannel.sdo' + mobi,function(data){
		var returnVal = eval("("+data+")");
		if(returnVal.success){
			ycate=returnVal.a;
			tcate=returnVal.b;
			callback.call(this);
		}
	});
}
function requestCity(path, callback) {
	$.post(path + '/as/queryGEO.sdo', function(data) {
		var returnVal = eval("(" + data + ")");
		if(returnVal.success){
			// TODO
			//GeoSingleton.getInstance(returnVal.data);
			callback.call(this);
		}
	});
}
String.prototype.replaceAll=function(s1,s2) {   
	return this.replace(new RegExp(s1,"gm"),s2);   
};  

$.fn.datebox.defaults.formatter = function(date) {
    return dateFormat(date);
};

function dateFormat(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+m+'-'+d;
}

function submitForm(id,url,pageNumber){
	var prefix='?';
	if(url.indexOf('?') > 0){
		prefix='&';
	}
	dealWithAdType();
	$('#'+id).form("submit",{url:url+prefix+'pageIndex='+pageNumber});
}



function exportForm(iframeid,formid,url) {
	var prefix='?';
	if(url.indexOf('?') > 0){
		prefix='&';
	}
	var token=new Date().getTime();
	url=url+prefix+"timestamp="+token;
	var frame = $('#'+iframeid);
	var form = $('#'+formid);
	var target = form.attr('target');
	var originurl = form.attr('action');
	form.attr('action',url);
	form.attr('target', iframeid);
	var fileDownloadCheckTimer = null;
	try {
		$('body').showLoading();
		fileDownloadCheckTimer = window.setInterval(function () {
		      var cookieValue = $.cookie("fileDownloadTimestamp");
		      if (cookieValue == token) clear();
		}, 1000);
		setTimeout(function(){dealWithAdType();form[0].submit();},2000);
	} catch(e) {
		clear();
	}
	
	function clear(){
		$('body').hideLoading();
		form.attr('action', originurl);
		form.removeAttr('target');
		window.clearInterval(fileDownloadCheckTimer);
		$.removeCookie("fileDownloadTimestamp",{path:"/"});
		$('#exportmode').val('0');
	}
}

function createGrid(id,data,formid) {
	var options = {
	        width: "auto",  
	        height: "480",  
	        pagination:true,
	        fitColumns:true,
	        pageList : [60],
	        pageSize: 60,
	        autoRowHeight:false,
	        remoteSort : false
    };  
	options.total=data.data[0].totalRows;
	options.pageNumber=data.data[0].currentPage;
	options.pageSize=data.data[0].totalRows;
	var perwidth = parseInt(900/data.columns[0].length)-50;
	for(var i=0;i<data.columns[0].length;i++){
		data.columns[0][i].width=perwidth;
		data.columns[0][i].sortable=true;
		var field = data.columns[0][i].field;
		if(field=='radi'||field=='imp'||field=='impover'||field=='click'){
			//自定义排序
			data.columns[0][i].sorter=function(a,b){return numberSort(a,b);};
		}else if(field=='clickRate'||field=='percentComplete'){
			//自定义排序
			data.columns[0][i].sorter=function(a,b){return percentSort(a,b);};
		}
	}
	options.columns=data.columns;
	var dataGrid = $('#'+id);
    dataGrid.datagrid(options); //根据配置选项，生成datagrid
    var gridpanel = dataGrid.datagrid("getPanel");
    if(gridpanel){
    	gridpanel.css('display','');
    }
	pageEvent(dataGrid,formid);
    flushGrid(dataGrid , data);
}

function pageEvent(dataGrid,formid){
	if(dataGrid){
		dataGrid.datagrid('getPager').pagination({
		       onBeforeRefresh:function(){},
		       onRefresh:function(pageNumber,pageSize){},
		       onSelectPage:function(pageNumber,pageSize){
		    	   var form = $('#'+formid);
		    	   var fullurl = form.get(0).action;
		    	   var inx = fullurl.lastIndexOf('?');
		    	   var url = fullurl.substring(0,inx);
		    	   submitForm(formid,url,pageNumber);
		       },
		       onChangePageSize:function(){}
		   });
	}
}

function pageGrid(id , data) {
	 var dataGrid = $('#'+id);
	 flushGrid(dataGrid , data);
}

function flushGrid(grid , data){
	 var flushData = new Object();
	 flushData.total = data.data[0].totalRows;
	 flushData.rows = data.data[0].rows;
	 grid.datagrid("loadData",flushData); 
}

function clearGrid(id){
	var dataGrid = $('#'+id);
	if(dataGrid.datagrid()){
		var gridpanel = dataGrid.datagrid("getPanel");
		if(gridpanel){
			gridpanel.css('display','none');
		}
	}
}

function numberSort(a,b){
	a=a.replaceAll(",",'');
	b=b.replaceAll(",",'');
	return (parseFloat(a)>parseFloat(b))?1:-1;
}

function percentSort(a,b){
	a=a.replaceAll("%",'');
	b=b.replaceAll("%",'');
	return (parseFloat(a)>parseFloat(b))?1:-1;
}

function formError(text){
	    jQuery('body').hideLoading();
		$.messager.alert('警告','<div style="text-align:center"><b>'+text+'</b></div>'); 
		return false;
}

//用于提pop组建中返回的数据
function getViewData(data) {
		var view = '';
		var g=0;
		var reArry = new Array();
		if(data&&data.length>0){
			if(data[0].cs&&data[0].cs.length>0){
				for(var i = 0;i<data.length;i++){
					for(var j=0;j<data[i].cs.length;j++){
						view=view+data[i].cs[j].name+',';
						g++;
					}
				}
			}else{
				for(var i = 0;i<data.length;i++){
					view=view+data[i].name+',';
					g++;
				}
			}
		}
		reArry.push(g);
		reArry.push(view);
		return reArry;
}

// access --- show 页面公用函数

function getsite(id){
	if(id==-999) return 'a_b';
	if(id==1) return 'a';
	if(id==2) return 'b';
}

function radiochange(span,spname)  
{  
	var site = getsite($('input[name="site"]').val());
    $('span[name="'+spname+'"]').each(function(){
    	var self = $(this);
    	self.attr('class','unchecked');
    	self.attr('checked','false');
    });  
	$(span).attr('class','checked');
	$(span).attr('checked','true');
	pop.cclose();
	poppro.pclose();
	popcate.catclose();
	popsubcate.sclose();
	var popcode=parseInt($(span).attr('rel'));
	switch(popcode) {
		case 1 : pop.cclean();poppro.pclean();poppro.popen(null,createCity); break;
		case 2 : poppro.pclean();pop.cclean();pop.copen(null,createCity); break;
		case 3 : popsubcate.sclean();popcate.catclean();popcate.catopen(site,null,createCate); break;
		case 4 : popcate.catclean();popsubcate.sclean();popsubcate.sopen(site,null,createCate);break;
	}
	clearSelect(spname.split('_')[0]);
} 

	function timeDetail(obj,sel_id) {
		if($(obj).attr('checked')){
			$('#hours_detail').show();
			poptime.topen(null,createTime);
		} else {
			$('#hours_detail > input').attr("checked",false);
			$('#hours_detail').hide();
			poptime.tclose();
			poptime.tclean();
			clearSelect(sel_id);
		}
	}
	
	function handleIncludeSupplementCheckBoxClick(obj) {
		if($(obj).attr('checked')){
			$('#groupByIncludeSupplementCheckBox').show();
		} else {
			$('#groupByIncludeSupplementCheckBox > input').attr("checked",false);
			$('#groupByIncludeSupplementCheckBox').hide();
		}
	}
	
	
	function clearSelect(id_prefix){
		$('#'+id_prefix+'json').val('{data:[]}');
		$('#'+id_prefix+'text').html('');
		$('#'+id_prefix+'num').html('0');
	}
	
	function clearForm(formid) {
		//$('#'+formid).form('clear');
		$('#ad_type').val('');
		$('#ad_type_key').val('');
		$('#ad_type_value').val('');
		$('span[sel="chk"]').attr('class','unchecked');
		clearSelect('city');
		clearSelect('channel');
		clearSelect('time');
		poptime.tclean();
		pop.cclean();
		poppro.pclean();
		popsubcate.sclean();
		popcate.catclean();
		$('.c_checkbox').attr("checked",false);
		$('#type_detail').hide();
		$('#hours_detail').hide();
		$('#hours_detail > input').attr("checked",false);
		//
		$('#groupByIncludeSupplementCheckBox').hide();
		$('#groupByIncludeSupplementCheckBox > input').attr("checked",false);
		//
		pop.cclose();
		poppro.pclose();
		popcate.catclose();
		popsubcate.sclose();
		poptime.tclose();
	}
	
	function clearDetailTime() {
		$('#timedetail').attr("checked",false);
		$('#hours_detail > input').attr("checked",false);
		$('#hours_detail').hide();
	}
	
	function valiExportRow(srow,erow) {
		var reg= /^[0-9]*[1-9][0-9]*$/;
		if(!reg.test(srow) || !reg.test(erow)){
			formError('行号请填写正整数!');
			return false;
		}
		if(parseInt(erow)-parseInt(srow)<=0){
			formError('结束行号要大于起始行号!');
			return false;
		}
		if(parseInt(erow)-parseInt(srow)>5000){
			formError('一次最多导出5000行数据!');
			return false;
		}
		return true;
	}
	
	function showLog(message){
		  try {
			  console.debug( message.replace(/&lt;/g,"<").replace(/&gt;/g,">") ); 
		  } catch (e) {
			  
		  }
	}
	function dealWithAdType() {
		var $ad_type = $("input[name='video_ad_type']");
		if($ad_type.length > 1){
			var value    = "";
			$ad_type.filter(':checked').map(function(i,v){
				value = unionList(value, ad_type_object[ v.value ][2]);
			})
			//移动不需要type key 参数
			$('#ad_type_value').val( '(' + value + ')');
		}else{
			var video_ad_type = $ad_type.val();
			$('#video_length_id').val('');
			var typeArry = ad_type_object[video_ad_type];
			$('#ad_type').val(typeArry[0]);
			$('#ad_type_key').val('(' + typeArry[1] + ')' );
			$('#ad_type_value').val('(' + typeArry[2] + ')' );
			//if(typeArry.length == 4) { //控制长短视频
				$('#video_length_id').val(typeArry[3]);
			//}
			if($("input[name='typeId']")[0]) {
				if(parseInt(video_ad_type) == 3) {
					$('#ad_type_value').val($("input[name='typeId']").val());
				}
			}
			
		}

	}
	//取并集
	function unionList(listA,listB){
		var sp     = ','
		,   arrA   = listA.split(sp)
		,   arrB   = listB.split(sp)
		,   result = {}
		,   arr    = []
		,   a
		,   b
		,   i;
		if (listA != "") for(i = 0, la = arrA.length; i < la; ++i ){
		   result[ arrA[i] ] = 0;
		}
		if (listB != "") for(i = 0, lb = arrB.length; i < lb; ++i ){
		   result[ arrB[i] ]= 0;
		}
		for(i in result){
			arr.push(i);
		}
		return arr.join(',');
	}

	//取交集
	function mergeList(listA,listB){
    	var sp=',',
    		arrA = listA.split(sp),arrB = listB.split(sp),
    		result =[],
    		a,b;
    	for(var ia = 0, la = arrA.length; ia < la; ++ia ){
		    var a = arrA[ia];
		    for(var ib = 0, lb = arrB.length; ib < lb; ++ib ){
			    var b = arrB[ib];
			    if(a == b){
			    	result.push(a);
			    	break;
			    }
			}
		}
		return result.join(sp)
    }

//弹出复选框逻辑
$(function(){
	$('.pop').click(function(e){
		var $button = $(e.target)
		,   $win    = $button.siblings('.drop-checkbox');
		$button.data('win',$win);
		$win.data('button',$button).show();
	});
	$('.drop-checkbox').on('click','.ok',function(e){
		var $win    = $(e.target).parent()
		,   $button = $win.data('button')
		,   num     = $win.find(":checked").length;
		if(num ==0){
			alert('请至少选择一项');
			return false;
		}
		$button.find('.num').text(num);
		$win.hide();
	})
})