var time_json=[{id:'0',name:'0点'},{id:'1',name:'1点'},{id:'2',name:'2点'},{id:'3',name:'3点'},{id:'4',name:'4点'},{id:'5',name:'5点'},{id:'6',name:'6点'},{id:'7',name:'7点'},{id:'8',name:'8点'},{id:'9',name:'9点'},{id:'10',name:'10点'},{id:'11',name:'11点'},{id:'12',name:'12点'},{id:'13',name:'13点'},{id:'14',name:'14点'},{id:'15',name:'15点'},{id:'16',name:'16点'},{id:'17',name:'17点'},{id:'18',name:'18点'},{id:'19',name:'19点'},{id:'20',name:'20点'},{id:'21',name:'21点'},{id:'22',name:'22点'},{id:'23',name:'23点'}];
(function($){
	function selCate(e){
		 var me=$(e.target).parent();
		 if(me.attr('class')=='active'){
			 me.removeClass('active');
		 }else{
			 me.addClass('active');
		 }
	}
	
	function createCate(contain,win){
		var CN=$(contain);
		var pro_ui=win.find('#poptime-time');
		for(var i=0;i<time_json.length;i++){
			var chk='';
			var isShow=false;
			var pro=time_json[i];
			var id=pro.id;
			var name=pro.name;
			var p_li = $('<li id="pro_'+id+'" '+chk+'><a>'+name+'</a></li>').bind('click',function(e){selCate(e);});
			pro_ui.append(p_li);
		}
	}
	
	function createButton(contain,win) {
		var commit = $('<input type="button" value="确定"class="input-submit" id="procate_commit">');
		var close = $('<input type="button" value="关闭"class="input-submit" id="procate_close">');
		commit.bind('click' , function() {
			var returndata = new Array();
			$('#poptime-time > li.active').each(function(){
				 var _pro=$(this);
				 var id=_pro.attr('id').split('_')[1];
				 var name=_pro.find('a').html();
				 var obj=new Object();
				 obj.id=id;
				 obj.name=name;
				 obj.cs=new Array();
				 returndata.push(obj);
			});
			if(win.procate.callback) {
				win.procate.callback.call(contain,returndata);
			}
			contain.tclose();
		});
		
		close.bind('click',function(){
			contain.tclose();
			if(win.procate.closeback){
				win.procate.closeback.call(contain);
			}
		});
		var but_div=win.find('#poptime_buttons');
		but_div.append(commit);
		but_div.append(close);
	}
	
	 $.fn.poptime=function(option){
		 var deft = {
					check:'more',
					defpro:'11',
					callback:function(data){},
					closeback:function(){}
		 };
		 var $self=this;
	     $self.procate=$.extend(deft,option);
	     var poptimewin=$('<div style="position: absolute; z-index: 9000; left: 160px; top: 160px; display: none; width: 650px;" id="_poptimewin_"><table style="width:300px; height: 195px" class="pop_dialog_table"><tbody><tr><td class="pop_topleft"></td><td class="pop_border"></td><td class="pop_topright"></td></tr><tr><td class="pop_border"></td><td class="pop_content"><h2><span>选择时间</span></h2><div class="dialog_content"><div class="dialog_body"><div style="position: static; width:auto;" id="procatelist"><div><ul id="poptime-time"></ul><div class="dialog_buttons" id="poptime_buttons"></div></div></div></div></td><td class="pop_border"></td></tr><tr><td class="pop_bottomleft"></td><td class="pop_border"></td><td class="pop_bottomright"></td></tr></tbody></table></div>');
	     createCate($self,poptimewin);
	     $self.__protimewin__=poptimewin;
	 	 $self.topen=$.fn.poptime.open;
		 $self.tclose=$.fn.poptime.close;
		 $self.tclean=$.fn.poptime.clean;
		 createButton($self,poptimewin);
		 $('body').append($self.__protimewin__);
		 return $self;
	 };
	 
	 $.fn.poptime.open=function(data,clickcallback){
		var $self=$(this);
		var $body=$('body');
		var pop_win=$body.find('#_poptimewin_');
		if(data&&data.length>0) {
			for(var j=0;j<data.length;j++){
				var id = data[j].id;
				var me = $self.__protimewin__.find('li #pro_'+id);
				 me.addClass('active');
			}
		}
		$self.__protimewin__.data('ReturnData',data);//保存对象
		$self.__protimewin__.procate.callback=clickcallback;
		if(pop_win.size()==1){
			pop_win.show();
		}else{
		   $body.append($self.__protimewin__);
		}
	 };
	 
	 $.fn.poptime.close=function(){
		  var $self=$(this);
		  $self.__protimewin__.hide();
	 };
	 
	 $.fn.poptime.clean=function(){
		 var $self=$(this);
		  $self.__protimewin__.find('#poptime-time > li').removeClass();
	 };
	
})(jQuery);