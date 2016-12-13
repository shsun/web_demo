(function($){
	function selCate(e){
		 var me=$(e.target).parent();
		 if(me.attr('class')=='active'){
			 me.removeClass('active');
		 }else{
			 me.addClass('active');
		 }
	}
	
	function createCate(contain,win,site){
		var CN=$(contain);
		var pro_ui=win.find('#popcate-cate');
		var cate = null;
		var suf = "";
		if(site=='a'){
			cate=ycate; 
		}else {
			cate=tcate;
		}
		for(var i=0;i<cate.length;i++){
			var chk='';
			var isShow=false;
			var pro=cate[i];
			var id=null;
			var name=null;
			if(site=='a'){
				//id=pro.CHANNEL_CODE;
				id=pro.CHANNEL_AGENT_ID;
				name=pro.CHANNEL_NAME;
			}else{
				//id=pro.CHANNEL_NUMBER;
				id=pro.CHANNEL_AGENT_ID;
				name=pro.CHANNEL_NAME;
			}
			var name=pro.CHANNEL_NAME;
			var p_li = $('<li id="pro_'+id+'" '+chk+' rel="'+site+'" style="width:70px"><a>'+name+suf+'</a></li>').bind('click',function(e){selCate(e);});
			pro_ui.append(p_li);
		}
	}
	
	function createButton(contain,win) {
		var selall=$('<input type="checkbox" style="float:left;margin-top:2px;" value="全选" class="sel_checkbox" id="procate_selall">');
		var commit=$('<input type="button" value="确定" class="input-submit" id="procate_commit">');
		var close=$('<input type="button" value="关闭" class="input-submit" id="procate_close">');
		commit.bind('click' , function() {
			var returndata = new Array();
			$('#popcate-cate > li.active').each(function(){
				 var _pro=$(this);
				 var id=_pro.attr('id').split('_')[1];
				 var name=_pro.find('a').html();
				 var site = _pro.attr('rel');
				 var obj=new Object();
				 obj.id=id;
				 obj.name=name;
				 obj.p=site=='a'?'1':'2';
				 obj.cs=new Array();
				 returndata.push(obj);
			});
			if(win.procate.callback) {
				win.procate.callback.call(contain,returndata);
			}
			contain.catclose();
		});
		selall.bind('click',function(){
			if($(this).attr('checked')){
				win.find("#popcate-cate > li").each(function(){
					var ckli = $(this);
					if(ckli.css('display')!='none') ckli.addClass('active');
				});
			}else{
				win.find("#popcate-cate > li").removeClass();
			}
		});
		close.bind('click',function(){
			contain.catclose();
		});
		var but_div=win.find('#popcate_buttons');
		but_div.append(selall);
		but_div.append('<span style="float:left;">全选</span>');
		but_div.append(commit);
		but_div.append(close);
	}
	
	 $.fn.popcate=function(option){
		 var deft = {
					check:'more',
					defpro:'11',
					callback:function(data){}
		 };
		 var $self=this;
	     $self.procate=$.extend(deft,option);
	     var procate_win=$('<div style="position: absolute; z-index: 9000; left: 160px; top: 160px; display: none; width: 650px;" id="_popcatewin_"><table style="width:490px; height: 240px" class="pop_dialog_table"><tbody><tr><td class="pop_topleft"></td><td class="pop_border"></td><td class="pop_topright"></td></tr><tr><td class="pop_border"></td><td class="pop_content"><h2><span>选择分类</span></h2><div class="dialog_content"><div class="dialog_body"><div style="position: static; width:auto;" id="procatelist"><div><ul id="popcate-cate"></ul><div class="dialog_buttons" id="popcate_buttons"></div></div></div></div></td><td class="pop_border"></td></tr><tr><td class="pop_bottomleft"></td><td class="pop_border"></td><td class="pop_bottomright"></td></tr></tbody></table></div>');
	     createCate($self,procate_win,'a');
	     createCate($self,procate_win,'b');
	     $self.__procatewin__=procate_win;
	 	 $self.catopen=$.fn.popcate.open;
		 $self.catclose=$.fn.popcate.close;
		 $self.catclean=$.fn.popcate.clean;
		 createButton($self,procate_win);
		 $('body').append($self.__procatewin__);
		 return $self;
	 };
	 
	 // [{id:'11',name:'北京'},{id:'12',name:'天津'}]
	 $.fn.popcate.open=function(site,data,callback){
		var $self=$(this);
		var $body=$('body');
		var pop_win=$body.find('#_popcatewin_');
		var lis=$self.__procatewin__.find("#popcate-cate > li");
		if(data&&data.length>0) {
			for(var j=0;j<data.length;j++) {
				var id = data[j].id;
				var me = $self.__procatewin__.find('li #pro_'+id);
				me.addClass('active');
			}
		}
		lis.show();
		if(site=='a'){
			lis.filter("[rel='b']").hide();
		} else if(site=='b'){
			lis.filter("[rel='a']").hide();
		}
		$self.__procatewin__.data('ReturnData',data);//保存对象
		$self.__procatewin__.procate.callback=callback;
		if(pop_win.size()==1){
			pop_win.show();
		}else{
		   $body.append($self.__procatewin__);
		}
	 };
	 
	 $.fn.popcate.close=function(){
		  var $self=$(this);
		  $self.__procatewin__.hide();
	 };
	 
	 $.fn.popcate.clean=function(){
		 var $self=$(this);
		 $self.__procatewin__.find("#popcate-cate > li").removeClass();
		 $self.__procatewin__.find(".sel_checkbox").attr('checked',false);
	 };
})(jQuery);