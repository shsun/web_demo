if (!Function.prototype.bind) {
  Function.prototype.bind = function (oThis) {
    if (typeof this !== "function") {
      // closest thing possible to the ECMAScript 5 internal IsCallable function
      throw new TypeError("Function.prototype.bind - what is trying to be bound is not callable");
    }

    var aArgs = Array.prototype.slice.call(arguments, 1), 
        fToBind = this, 
        fNOP = function () {},
        fBound = function () {
          return fToBind.apply(this instanceof fNOP
                                 ? this
                                 : oThis,
                               aArgs.concat(Array.prototype.slice.call(arguments)));
        };

    fNOP.prototype = this.prototype;
    fBound.prototype = new fNOP();

    return fBound;
  };
}

/**
 * 弹出选择器 Select
 */
function SelectPop(config){
	if(!config)return;
	$.extend(this,config);
	this.init();
	if(this.url){
		this.loadOptions();
		console.log('loadOptions');
	}
}

SelectPop.prototype={
	className:null,
	nameName:'name',
	onClass:'active',
	itemClass:'item',
	listClass:'list',
	url:null,
	init:function(){
		this.renderWindow();
		this.bindEvent();
		this.$open.data('SelectPop',this);
		this.close();
	},

	popWin:'<div class="popSelect" style="position:absolute; z-index: 10000; top: 160px; display: none; width: 650px;">'
		+'<table class="pop_dialog_table" style="width: 650px;"><tbody>'
		+'<tr><td class="pop_topleft"></td><td class="pop_border"></td><td class="pop_topright"></td></tr>'
		+'<tr><td class="pop_border"></td><td class="pop_content">'
			+'<h2 class="dialog_title"></h2>'
			+'<div class="dialog_content"><div class="dialog_body"></div></div></div>'
		+'<div id="pop_buttons" class="dialog_buttons"><input type="button" class="submit" value="确定"/></div></div></td><td class="pop_border"></td></tr>'
		+'<tr><td class="pop_bottomleft"></td><td class="pop_border"></td><td class="pop_bottomright"></td></tr></tbody></table></div>',
	
	title:"请选择",

	renderWindow:function(){
		console.log('渲染窗口');
		this.$win=$(this.popWin).appendTo($("body"));
		if(this.className){
			this.$win.addClass(this.className);
		}
		this.$win.show();
		this.$win.find('.dialog_title').text(this.title);
		this.$body = this.$win.find('.dialog_body');
	},

	bindEvent:function(){
		var self = this;
		console.log('parent bindEvent()',this);
		this.$body.on('click','.' + this.itemClass,function(e){
			$(this).toggleClass(self.onClass);
			self.save();
		});
		// this.$body.on('click','.' + this.listClass,function(e){
		// 	if($(this).find('.'+this.itemClass).not('.'+self.onClass).length === 0){
		// 		$(this.find('.all').data('on',true).text('清空'));
		// 	}else{
		// 		$(this.find('.all').data('on',false).text('全选'));
		// 	}
		// }
		this.$open.on('click',function(e){
			self.open();
		});

		this.$win.on('click','.submit',function(e){
			self.close();
		});

		this.$body.on('click','.all', this.selectAll.bind(this));
	},

	//后端数据接口
	url:null,
	
	//向后端请求选项
	loadOptions:function(){
		var self = this;
		if(!this.url)return;
		$.getJSON(this.url, function(json){
			console.log('取回数据',json);
			self.$body.html(self.renderOptions.call(self, json, self.listClass, self.itemClass));
			self.$list = self.$body.find('.'+self.listClass);
		});
	},

	renderOptions:function( json, listClass, itemClass){
		console.log('渲染列表',json);
		var html='<ul class="'+ listClass +'">'
		for(var i = 0, l = json.length; i < l; ++i ){
		    html += this.renderOption( json[i], itemClass );
		}
		return html + '<li class="all">全选</li></ul>';
	},

	renderOption:function( item, itemClass ){
		return '<li class="' + itemClass + '" id="' + itemClass + item.id + '" data-id="' + item.id + '">' + item[this.nameName] + '</li>';
	},

	// 存取数据到表单项
	//=====

	dataName:"data",
	save:function(){
		this.saveValue(this.DOM2Value());
	},

	DOM2Value:function(){
		var $selected = this.$list.children('.' + this.itemClass + '.' + this.onClass ),
			list = $selected.map( this.item2json ).get().join(','),
			name = $selected.map( this.item2name ).get().join(',');
		console.log( '已选择项', list, name, $selected.length );
		debugger;
		return {
			"list": list,
			"length": $selected.length + this.catName,
			"name": name
		}
	},

	//存储数据到表单项
	saveValue:function(obj){
		console.log("保存数据",obj);
		this.$json.val( '{"' + this.dataName + '":[' + obj.list + ']}' );
		this.$count.text( obj.length ).attr( 'title', obj.name );
	},

	item2json:function( i, v ){
		return '{"id":"' + v.getAttribute( 'data-id' ) + '","'+ this.nameName +'":"' + v.innerHTML + '"}';
	},
	
	item2name:function(i,v){
		return v.innerHTML;
	},
	
	//从表单项读取数据
	loadValue:function(json){
		var json = $.parseJSON(this.$json.val());
		console.log('读取到的json',JSON.stringify(json));
		console.log('选择数据',json[this.dataName]);
		this.offAll();

		for(var i = 0, l= json[this.dataName].length; i < l; ++i ){
   			var item = json[this.dataName][i];
   			this.on(this.findItem(item))
		}
	},
	selectAll:function(e){
		var $target=$(e.target),
		
		$allItem=$target.siblings();
		
		if($target.data('on')){
			this.off($allItem);
			$target.data('on',false).text('全选');
		}else{
			this.on($allItem);
			$target.data('on',true).text('清空');
		}
		this.save();
	},
	offAll:function(){
		this.$list.children().removeClass(this.onClass);
		this.$body.find('.all').data('on',false).text('全选');
	},
	
	findItem:function(item){
		return this.$list.find('#' + this.itemClass + item.id);
	},

	on:function($item){
		$item.addClass(this.onClass);
	},
	
	off:function($item){
		$item.removeClass(this.onClass);
	},

	// 窗口开关
	open:function(){
		this.$win.show();
	},

	close:function(){
		this.$win.hide();
	}
};

function SelectPop2(options){
	SelectPop.call(this,options);
}
SelectPop2.prototype = new SelectPop();
$.extend(SelectPop2.prototype,{
	childrenName:"cs",
	topListClass:"topList",
	bindEvent:function(){
		var self = this;
		SelectPop.prototype.bindEvent.call(this);
		this.$body.on('click','.' + this.topItemClass, function(e){

			var $target  = $(e.target),
				$checkbox,
				$subList = self.$body.find('#' + self.subListClass + $target.data( 'id' ) );
			//console.log("顶部切换到",$target.text());
			//点击到选择框
			if($target.is('input')){
				//console.log("checkbox");
				$checkbox = $target;
				$target = $target.parent();
				$subList = self.$body.find('#' + self.subListClass + $target.data( 'id' ) );
				if($target.hasClass('single')){
					var op = $checkbox.is(':checked') ? "on" : "off";
					//console.log(op,$subList.children('.' + self.itemClass).text());
					self[op]($subList.children('.' + self.itemClass));
					self.save();
				}else{
					$subList.find('.all').trigger('click');
				}
			}
			self.curItem && self.curItem.removeClass('cur');
			self.curItem = $target.addClass('cur');

			self.curList && self.curList.hide();
			self.curList = $subList.show();
		});
		this.$body.on('click','.'+ this.subListClass+' .single',function(e){
			var $target = $(e.target);
				self.$body.find('#'+self.topItemClass + $target.parent().data('id') +' input')
					.attr('checked',$target.hasClass(self.onClass));
		})
	},
	renderOptions:function( json, listClass, itemClass){
		console.log('渲染两级列表',json);
		var html='<ul class="'+ listClass +'">', subHtml = '';
		for(var i = 0, l = json.length; i < l; ++i ){
		    html += this.renderOption( json[i], this.topItemClass, json[i][this.childrenName].length == 1 ? 'single':'');
		    subHtml += this.renderList( json[i], this.subListClass, itemClass);
		}
		return html + '<li class="all top">全选</li></ul>' + subHtml;
	},
	renderOption:function(item, itemClass, single){
		single = single || '';

		return '<li class="' + itemClass +' ' +single + '" id="' + itemClass + item.id + '" data-id="' + item.id + '">' + ( itemClass.indexOf(this.topItemClass) !== -1 ? '<input type="checkbox">' :'') + item[this.nameName] + '</li>';
	},
	renderList:function(list, listClass, itemClass){
		var html = '<ul class="' + listClass + '" id="' + listClass + list.id + '" data-id="' + list.id + '" data-name="' + list[this.nameName] + '">',
			json = list[this.childrenName];
		if(json.length == 1){
			
			return html + this.renderOption( json[0], itemClass, 'single') + '</ul>';
		
		}else{

			for(var i = 0, l = json.length; i < l; ++i ){

			    html += this.renderOption( json[i], itemClass );
			}

			return html + '<li class="all">全选</li>' + '</ul>';
		}

	},
	DOM2Value:function(){
		var name=[],
			self = this,
			$onList  = this.$body.find('.' + this.subListClass + ':has(.' + this.onClass + ')');
		
		//console.log("含有选中项的子列表",$onList.html());
		var json=$onList.map(function(i,v){

			var $v = $(v), cs = $(v).find('.' + self.onClass ).map(function(i, sItem){
				//console.log('子选项',sItem);
				name.push( $v.data('name') + '-' + sItem.innerHTML );
				return self.item2json.call(self, i, sItem);
			}).get().join(',');

			return '{"id":' + $v.data('id') + ',"' + self.nameName + '":"' + $v.data('name') + '","' + self.childrenName + '":[' + cs + ']}';
		}).get().join(',');
		
		return {
			"list"  : json,
			"length": $onList.length + self.catName + ',' + name.length + self.subCatName,
			"name"  : name.join(',')
		}
	},
	selectAll:function(e){
		var $el = $( e.target ),
			op = "on",
			val= {on:true,off:false},
			text= {on:'清空',off:'全选'};
		if($el.data('on')){
			op = "off";
		}
		console.log(' op=', op, this.$body.find( '.' + this.itemClass ));
		if($el.hasClass('top')){
			this[op]( this.$body.find('.' + this.topItemClass + ', .' + this.itemClass ) );
			this.$body.find('.all').data('on',val[op]).text(text[op]);
		}else{
			this[op]( $el.siblings( '.' + this.itemClass ) );
			$el.data('on',val[op]).text(text[op]);
			this.$body.find('#' + this.topItemClass + $el.parent().data('id') + ' input').attr('checked',val[op]);
		}
		this.save();
	},
	on:function($item){
		$item.addClass(this.onClass);
		if($item.is('.' + this.topItemClass)){
			$item.find('input').attr('checked','checked');
		}
	},
	off:function($item){
		$item.removeClass(this.onClass);
		if($item.is('.' + this.topItemClass)){
			$item.find('input').attr('checked','false');
		}
	},
	//从表单项读取数据
	loadValue:function(json){
		var json = $.parseJSON(this.$json.val()),
			data = json[this.dataName],
			$allItem = this.$body.find('.'+this.itemClass),
			count = 0;
		console.log('读取到的json',JSON.stringify(json));
		console.log('选择数据',json[this.dataName]);
		this.offAll();

		for(var i = 0, l= data.length; i < l; ++i ){
   			var item = data[i],
   				sub = item[this.childrenName],
   				$topItem = this.$body.find('#'+this.topItemClass + item.id);
   				$subList = this.$body.find('#'+this.subListClass + item.id);
   			console.log(item);
   			//debugger;
   			if(sub){
   				for(var j = 0, k = sub.length; j < k; j++, count++){
   					var $item = $subList.find('#'+this.itemClass + sub[j].id);
   					this.on($item);
   				}
   				if(j == $subList.children('.'+this.itemClass).length){
   					console.log("全选子列表" + item.id);
   					$subList.find('.all').data('on',true).text('清空');
   					$topItem.find('input').attr('checked','checked');
   				}
   			}
		}
		if(count == $allItem.length){
			this.$body.find('.' + this.topListClass + ' .all').data('on',true).text('清空');
		}
		this.save();
	},
});

// $(function($){

// 	// var ProvenceSelect = new SelectPop({
// 	// 	title: "请选择省份",
// 	// 	dataName: "data",
// 	// 	itemPrefix: "p",
// 	// 	catName: "省",
// 	// 	$open: $('#selectProvence'),
// 	// 	$json: $('#cityjson'),
// 	// 	$count: $('#citynum'),
// 	// 	url: '/addata/bin/City.json'
// 	// });

// 	window['c'] = new SelectPop2({
// 		title: "请选择城市",
// 		catName: "省",
// 		subCatName: "市",
// 		jsonDataName: "data",
// 		itemPrefix: "c",
// 		listClass: "topList",
// 		subListClass: "subList",
// 		topItemClass: "topItem",
// 		$open: $('#selectCity'),
// 		$json: $('#cityjson'),
// 		$count: $('#citynum'),
// 		url: '/addata/bin/City.json'
// 	});
// })