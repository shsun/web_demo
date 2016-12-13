//var ycate=[{id:'a',name:'资讯'},{id:'b',name:'原创'},{id:'c',name:'电影'},{id:'d',name:'电视剧'},{id:'e',name:'体育'},{id:'f',name:'音乐'},{id:'g',name:'游戏'},{id:'h',name:'动漫'},{id:'i',name:'女性'},{id:'j',name:'搞笑'},{id:'k',name:'自拍'},{id:'key',name:'全频道关键字'},{id:'l',name:'广告'},{id:'m',name:'生活'},{id:'n',name:'汽车'},{id:'o',name:'科技'},{id:'p',name:'无分类'},{id:'q',name:'时尚'},{id:'r',name:'母婴'},{id:'s',name:'旅游'},{id:'t',name:'教育'},{id:'u',name:'娱乐'},{id:'v',name:'综艺'},{id:'w',name:'纪录片'},{id:'z',name:'其他'},{id:'zw',name:'站外'}];
//var tcate=[{id:'1',name:'娱乐'},{id:'5',name:'搞笑'},{id:'9',name:'动画'},{id:'10',name:'游戏'},{id:'100',name:'分享'},{id:'104',name:'城市'},{id:'12',name:'商品'},{id:'14',name:'音乐'},{id:'15',name:'体育'},{id:'21',name:'科技'},{id:'22',name:'电影'},{id:'23',name:'其他'},{id:'24',name:'财富'},{id:'25',name:'教育'},{id:'26',name:'汽车'},{id:'27',name:'女性'},{id:'28',name:'纪录片'},{id:'29',name:'热点'},{id:'3',name:'乐活'},{id:'30',name:'电视剧'},{id:'31',name:'综艺'},{id:'32',name:'风尚'},{id:'33',name:'美容'},{id:'34',name:'健康'},{id:'35',name:'土豆站外'},{id:'99',name:'原创'}];

(function($){

  function selProvince(win,e) {
	    var me=$(e.target).parent();
		if(me.attr('class')=='active') return;
		win.find('#pop-category > li').each(function(i){
			$(this).removeClass();
		});
		me.addClass('active');
		var proid = me.attr('id').split('_')[1];
		changeCity(win,proid);
	}
	
	function changeCity(win,proid){
		win.find('.popup-unis').hide();
		win.find('#u_'+proid).show();	
	}
	
	function createProAndCity(contain,site,win){
		var CN=$(contain);
		var pro_ui=win.find('#pop-category');
		var in_cate_json = null;
		var suf = "";
		if(site=='a'){
			in_cate_json= ycate;
		}else{
			in_cate_json= tcate;
		}	
		for(var i=0;i<in_cate_json.length;i++){
			var chk='';
			var isShow=false;
			var pro=in_cate_json[i];
			var id=null;
			var name=null;
			if(id==CN.opts.defpro){
				chk='class="active"';
				isShow=true;
			}
			if(site=='a') {
				id=pro.CHANNEL_CODE;
				name=pro.CHANNEL_NAME;
			} else {
				id=pro.CHANNEL_NUMBER;
				name=pro.CHANNEL_NAME;
			}
			id=pro.CHANNEL_AGENT_ID;
			var p_li = $('<li id="p_'+id+'" '+chk+' rel='+site+' style="width:70px;"><a>'+name+suf+'</a></li>').bind('click',function(e){selProvince(win,e)});
			pro_ui.append(p_li);
			createCity(win,id,isShow,site,pro.children);
		}
		
	}
	
	function createCity(win,proid,show,site,citys){
		var unis=$('<ul id="u_'+proid+'" class="popup-unis"></ul>');
		var subcat_perfix = null;
		if(!citys) return;
		for(var i=0;i<citys.length;i++){
			var cy=citys[i];
			var id="";
			var name="";
			var siteid=0;
			if(site=='a'){
				id = cy.SUB_CHANNEL_AGENT_ID;
				name = cy.SUB_CHANNEL_NAME;
				siteid=1;
			}else{
				id = cy.SUB_CHANNEL_AGENT_ID;
				name = cy.SUB_CHANNEL_NAME;
				siteid=2;
			}
			var cityli=$('<li id="cat_'+id+'"></li>');
			$('<input class="subcate_checkbox" id="cak_'+id+'" pro="'+proid+'" type="checkbox" site="'+siteid+'"/>').appendTo(cityli);
			var cityname=$('<span id="sbm_'+id+'">'+name+'</span>');
			cityli.append(cityname);
			unis.append(cityli);		
		}
		var selallli=$('<li></li>');
		$('<input class="sel_checkbox" type="checkbox">').appendTo(selallli).bind('click',function(e){
			if($(this).attr('checked')){
				unis.find('input[pro='+proid+']').attr('checked','checked');
			}else{
				unis.find('input[pro='+proid+']').attr('checked',false);
			}
		});
		selallli.append('<span style="color:red;"><b>全选</b></span>');
		unis.append(selallli);
		if(show) unis.show();
		else unis.hide();
		win.find('#popup-subcates').append(unis);
	}
	
//	function selCity(win,e,site){
//		var chbox=$(e.target);
//		var cid=chbox.attr('id').split('_')[1];
//		var pid=chbox.attr('pro');
//		var cname=win.find('#sbm_'+cid).html();
//		var city=new Object();
//		city.id=cid;
//		city.name=cname;
//		var selobj=win.data('ReturnData');
//		var isCheck=chbox.attr('checked');
//		if(selobj){
//			if(isCheck){
//				var k=0;
//				for(var i=0;i<selobj.length;i++){
//					var d=selobj[i];
//					if(d.id==pid){
//						d.cs.push(city);
//						k++;
//						break;
//					}
//				}
//				if(k==0){
//					var province=new Object();
//					province.id=pid;
//					province.p=site=='a'?'1':'-1';
////					for(var i=0;i<_pro_json_.length;i++){
////						var p=_pro_json_[i];
////						if(p.id==pid){
////							province.name=p.name;
////							break;
////						}
////					}
//					province.cs=new Array();
//					province.cs.push(city);
//					selobj.push(province);
//				}
//			}else{
//				for(var i=0;i<selobj.length;i++){
//					var d=selobj[i];
//					if(d.id==pid){
//						var inx=Array.objIndexOf(d.cs,city);
//						Array.remove(d.cs,inx);
//						if(!selobj[i].cs || selobj[i].cs==0){
//							Array.remove(selobj,i);
//						}
//						break;
//					}
//				}
//			}
//		}
//	}
	
	function createButtons(contain,win){
		var commitb=$('<input id="subcate_commit" type="button" class="input-submit" value="确定">').bind('click',function(){
			var returnArray = new Array();
			win.find('.subcate_checkbox').each(function(){
				var $chk = $(this);
				if($chk.attr('checked')){
					var cid=$chk.attr('id').split('_')[1];
					var pid=$chk.attr('pro');
					var site=$chk.attr('site');
					var cname=win.find('#sbm_'+cid).html();
					var subcat=new Object();
					subcat.id=cid;
					subcat.name=cname;
					var k=0;
					for(var i=0;i<returnArray.length;i++){
						var d=returnArray[i];
						if(d.id==pid){
							d.cs.push(subcat);
							k++;
							break;
						}
					}
					if(k==0){
						var cate=new Object();
						cate.id=pid;
						cate.p=site;
						cate.cs=new Array();
						cate.cs.push(subcat);
						returnArray.push(cate);
					}
				}
			});
			if(contain.opts.callback){
				//var selobj=win.data('ReturnData');
				contain.opts.callback.call(contain,returnArray);
			}
			contain.sclose();
		});
		var closeb=$('<input id="subcate_close" type="button" class="input-submit" value="关闭">').bind('click',function(){
			contain.sclose();
		});
		win.find('#pop_catbuttons').append(commitb);
		win.find('#pop_catbuttons').append(closeb);
	}
	
  $.fn.popsubcate=function(option){
	var deft={
		check:'more',
		defpro:'a',
		callback:function(data){}
	};
	var $self=this;
	
	$self.opts=$.extend(deft,option);
	
	var pop_win=$('<div id="_popsubcatewin_" style="position: absolute; z-index: 10000; left: 160px; top: 160px; display: none; width: 620px;"><table class="pop_dialog_table" style="width: 620px; height: 240px"><tbody>'+
	'<tr><td class="pop_topleft"></td><td class="pop_border"></td><td class="pop_topright"></td></tr>'+
	'<tr><td class="pop_border"></td><td class="pop_content"><h2><span>选择二级分类</span></h2>'+
	'<div class="dialog_content"><div class="dialog_body"><div id="catelist" style="position: static;"><div><ul id="pop-category"></ul><div id="popup-subcates"><div></div></div></div>'+
	'<div id="pop_catbuttons" class="dialog_buttons"></div></div></td><td class="pop_border"></td></tr><tr><td class="pop_bottomleft"></td><td class="pop_border"></td><td class="pop_bottomright"></td></tr></tbody></table></div>');
	//构建空返回对象
	pop_win.data('ReturnData',new Array());
	createProAndCity($self,'a',pop_win);
	createProAndCity($self,'b',pop_win);
	//changeCity(pop_win,$self.opts.defpro);
	$self.__popsubcatewin__=pop_win;
	$self.sopen=$.fn.popsubcate.open;
	$self.sclose=$.fn.popsubcate.close;
	$self.sclean=$.fn.popsubcate.clean;
	createButtons($self,pop_win);
	$('body').append($self.__popsubcatewin__);
	return $self;
  };
  
  $.fn.popsubcate.open=function(site,selobj,callback){
	var $self=$(this);
	var $body=$('body');
	var pop_win=$body.find('#_popsubcatewin_');
	var lis=$self.__popsubcatewin__.find("#pop-category > li");
	if(selobj && selobj.length>0) {
	    var selproid=selobj[0].id;
		var selcitys=[];
		for(var j=0;j<selobj.length;j++){
			for(var k=0;k<selobj[j].cs.length;k++){
				selcitys.push(selobj[j].cs[k]);
			}
		}
	    var chboxs=$self.__popsubcatewin__.find('.subcate_checkbox');
		chboxs.each(function(i){
			var chbox=$(this);
			var cid=chbox.attr('id').split('_')[1];
			for(var k=0;k<selcitys.length;k++){
				if(selcitys[k].id==cid){
					chbox.attr('checked','checked');
				}
			}
		});
		var me=$self.__popsubcatewin__.find('#p_'+selproid);
		if(me.attr('class')=='active') return;
		lis.each(function(i){
			$(this).removeClass();
		});
		me.addClass('active');
		changeCity($self.__popsubcatewin__,selproid);
		$self.__popsubcatewin__.data('ReturnData',selobj);//保存对象
	}
	lis.show();
	if(site=='a'){
		lis.filter("[rel='b']").hide();
	} else if(site=='b'){
		lis.filter("[rel='a']").hide();
	}
	$self.__popsubcatewin__.opts.callback=callback;
	if(pop_win.size()==1){
		pop_win.show();
	}else{
	   $body.append($self.__popsubcatewin__);
	}
  };
  
  $.fn.popsubcate.close=function(){
	  var $self=$(this);
	  $self.__popsubcatewin__.hide();
  };
  
  $.fn.popsubcate.distory=function(){
      var $self=$(this);
	  $self.__popsubcatewin__.remove();
  };
  
  $.fn.popsubcate.clean=function(){
	  var $self=$(this);
	  $self.__popsubcatewin__.find('.subcate_checkbox').attr('checked',false);
	  $self.__popsubcatewin__.find(".popup-unis").css('display','none');
	  $self.__popsubcatewin__.find("#pop-category > li").removeClass();
	  $self.__popsubcatewin__.find(".sel_checkbox").attr('checked',false);
  };
})(jQuery);