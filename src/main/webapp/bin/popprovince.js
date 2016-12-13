(function($){
	function selProvince(e){
		 var me=$(e.target).parent();
		 if(me.attr('class')=='active'){
			 me.removeClass('active');
		 }else{
			 me.addClass('active');
		 }
	}
	
	function createProvince(contain,win){
		var CN=$(contain);
		var pro_ui=win.find('#popprovin-province');
		for(var i=0;i<_pro_json_.length;i++){
			var chk='';
			var isShow=false;
			var pro=_pro_json_[i];
			var id=pro.id;
			var name=pro.name;
			var p_a = $('<a>'+name+'</a>').bind('click',function(e){selProvince(e);});
			var p_li = $('<li id="pro_'+id+'" '+chk+'></li>');
			p_li.append(p_a);
			pro_ui.append(p_li);
		}
	}
	
	function createButton(contain,win) {
		var selall=$('<input type="checkbox" style="float:left;margin-top:2px;" value="全选" class="sel_checkbox" id="procate_selall">');
		var commit = $('<input type="button" value="确定"class="input-submit" id="popprovin_commit">');
		var close = $('<input type="button" value="关闭"class="input-submit" id="popprovin_close">');
		commit.bind('click' , function() {
			var returndata = new Array();
			$('#popprovin-province > li.active').each(function(){
				 var _pro=$(this);
				 var id=_pro.attr('id').split('_')[1];
				 var name=_pro.find('a').html();
				 var obj=new Object();
				 obj.id=id;
				 obj.name=name;
				 obj.cs=new Array();
				 returndata.push(obj);
			});
			if(win.proopts.callback) {
				win.proopts.callback.call(contain,returndata);
			}
			contain.pclose();
		});
		
		selall.bind('click',function(){
			if($(this).attr('checked')){
				win.find("#popprovin-province > li").each(function(){
					var ckli = $(this);
					if(ckli.css('display')!='none') ckli.addClass('active');
				});
			}else{
				win.find("#popprovin-province > li").removeClass();
			}
		});
		close.bind('click',function(){
			contain.pclose();
		});
		var but_div=win.find('#popprovin_buttons');
		but_div.append(selall);
		but_div.append('<span style="float:left;">全选</span>');
		but_div.append(commit);
		but_div.append(close);
	}
	
	 $.fn.popprovince=function(option){
		 var deft = {
					check:'more',
					defpro:'11',
					callback:function(data){}
		 };
		 var $self=this;
	     $self.proopts=$.extend(deft,option);
	     var propop_win=$('<div style="position: absolute; z-index: 9000; left: 160px; top: 160px; display: none; width: 650px;" id="_popprovincewin_"><table style="width:300px; height: 240px"class="pop_dialog_table"><tbody><tr><td class="pop_topleft"></td><td class="pop_border"></td><td class="pop_topright"></td></tr><tr><td class="pop_border"></td><td class="pop_content"><h2><span>选择城市</span></h2><div class="dialog_content"><div class="dialog_body"><div style="position: static; width:auto;" id="proivlist"><div><ul id="popprovin-province"></ul><div class="dialog_buttons" id="popprovin_buttons"></div></div></div></div></td><td class="pop_border"></td></tr><tr><td class="pop_bottomleft"></td><td class="pop_border"></td><td class="pop_bottomright"></td></tr></tbody></table></div>');
	     createProvince($self,propop_win);
	     $self.__provincewin__=propop_win;
	 	 $self.popen=$.fn.popprovince.open;
		 $self.pclose=$.fn.popprovince.close;
		 $self.pclean=$.fn.popprovince.clean;
		 createButton($self,propop_win);
		 $('body').append($self.__provincewin__);
		 return $self;
	 };
	 
	 // [{id:'11',name:'北京'},{id:'12',name:'天津'}]
	 $.fn.popprovince.open=function(data,callback){
		var $self=$(this);
		var $body=$('body');
		var pop_win=$body.find('#_popprovincewin_');
		if(data&&data.length>0) {
			for(var j=0;j<data.length;j++){
				var id = data[j].id;
				var me = $self.__provincewin__.find('li #pro_'+id);
				 me.addClass('active');
			}
		}
		$self.__provincewin__.data('ReturnData',data);//保存对象
		$self.__provincewin__.proopts.callback=callback;
		if(pop_win.size()==1){
			pop_win.show();
		}else{
		   $body.append($self.__provincewin__);
		}
	 };
	 
	 $.fn.popprovince.close=function(){
		  var $self=$(this);
		  $self.__provincewin__.hide();
	 };
	 
	 $.fn.popprovince.clean=function(){
		 var $self=$(this);
		 $self.__provincewin__.find('#popprovin-province > li').removeClass();
		 $self.__provincewin__.find(".sel_checkbox").attr('checked',false);
	 };
})(jQuery);