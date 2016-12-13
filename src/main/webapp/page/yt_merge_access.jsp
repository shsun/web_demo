<%@page language="java" pageEncoding="UTF-8" %><%@include file="taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="${path}/lib/easyui/themes/default/easyui.css">  
        <link rel="stylesheet" type="text/css" href="${path}/lib/easyui/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="${path}/css/main.css">
        <link rel="stylesheet" type="text/css" href="${path}/css/atooltip.css">
        <link rel="stylesheet" type="text/css" href="${path}/css/popcity.css">
		<script type="text/javascript" src="${path}/lib/jquery-1.8.0.js"></script>
		<script type="text/javascript" src="${path}/lib/jquery.showLoading.js"></script>  
        <script type="text/javascript" src="${path}/lib/easyui/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${path}/lib/jquery.atooltip.js"></script>
        
        <script type="text/javascript" src="${path}/lib/Delegate.js"></script>
        <!-- Signals library -->
        <script type="text/javascript" src="${path}/lib/signals.js"></script>
		<!-- Objs library -->
		<script type="text/javascript" src="${path}/lib/objs-2.1.2-min.js"></script>
		<!-- PureMVC framework for JavaScript based on Objs -->
		<script type="text/javascript" src="${path}/lib/puremvc-objs-2.0-min.js"></script>
		
		
		<script type="text/javascript" src="${path}/bin/application_constants.js"></script>
		<script type="text/javascript" src="${path}/bin/application_base.js"></script>
		<script type="text/javascript" src="${path}/bin/base.js"></script>
        <script type="text/javascript" src="${path}/bin/popcity.js"></script>
        <script type="text/javascript" src="${path}/bin/popprovince.js"></script>
        <script type="text/javascript" src="${path}/bin/popcate.js"></script>
        <script type="text/javascript" src="${path}/bin/popsubcate.js"></script>

        <script type="text/javascript" src="${path}/bin/popSelect.js"></script>

        <script type="text/javascript" src="${path}/bin/poptime.js"></script>
        
        <!-- application code -->		
		<!--
		<script type="text/javascript" src="${path}/bin/application.js"></script>
		-->
        <link rel="stylesheet/less" type="text/css" href="${path}/css/popSelect.less"/>
        <style>
		.channels .topList li{
			width: 80px;
		}
        </style>
        <script type="text/javascript" src="${path}/bin/less.js"></script>
	</head>
	<body>
		<div id="layout_div" class="easyui-layout" style="width:1100px; height:720px;">
		     <div data-options="region:'north'" style="height:220px">
		          <div id="formPanel" class="easyui-panel" data-options="fit:true" title="AB容量统计" style="padding:10px;background-color: #fafafa">  
        	 			<form id="access_form" method="post"><div>

        	 			<div style="margin-bottom: 6px;">
        	 				<c:choose>
    					    <c:when test="${empty param.isMobile or param.isMobile ne '1'}">选择统计类型:</c:when>
        					<c:otherwise>选择广告类型:</c:otherwise>
	        			    </c:choose>
        	 			
    					  <c:choose>
    					    <c:when test="${empty param.isMobile or param.isMobile ne '1'}">
        	 			    <select class="easyui-combobox" name="video_ad_type" style="width:220px;" data-options="editable:false,onSelect:selAdtype">
  							  <%-- See Also: http://docs.oracle.com/javaee/1.4/tutorial/doc/JSPIntro2.html#wp100157 --%>
							  <%-- See Also: http://docs.oracle.com/javaee/1.4/tutorial/doc/JSPIntro7.html#wp74145 --%>
							   	   <!--  <option>页面广告查询</option> -->
	        					   <option value="2">前贴广告查询</option>
	        					   <option value="-3">长前贴广告查询</option>
	        					   <option value="-1">短前贴/全屏前贴/赞助标版广告查询</option>
	        					   <option value="5">后贴广告查询</option>
	        					   <option value="13">贴片广告查询</option>
	        					   <option value="4">暂停广告查询</option>
	        					   <option value="8">中插广告查询</option>
	        					   <option value="11">播放页Banner广告查询</option>
	        					   <option value="12">页面广告查询</option>
								   <option value="200">前贴crazy</option>
								
        					 </select>
						     
						     </c:when>
        					 <c:otherwise>

        					 <span class="button pop">详细<span class="num">1</span></span>
        					 <div class="drop-checkbox" style="display:none">
       				    		<a class="ok" href="#">确定</a>
									<label><input type="checkbox" name="video_ad_type" checked="checked" value="2">移动前贴</label>
									<label><input type="checkbox" name="video_ad_type" value="5">移动后贴</label>
									<label><input type="checkbox" name="video_ad_type" value="4">移动暂停</label>
									<label><input type="checkbox" name="video_ad_type" value="10">移动角标</label>
									<label><input type="checkbox" name="video_ad_type" value="21">移动开机图</label>
       				    	</div>

						    </c:otherwise>
	        			    </c:choose>
       						 <div style="display: none">
       						   <input id="ad_type" type="hidden" name="type" value=""/>
       						   <input id="ad_type_key" type="hidden" name="key" value=""/>
       						   <input id="ad_type_value" type="hidden" name="value" value=""/>
       						    <input id="video_length_id" type="hidden" name="video_length_id" value=""/>
       						 </div> 
       						
       						<span class="lspan10">选择网站:</span> 
       						<select id="sitesel" class="easyui-combobox" name="site" style="width:100px;" data-options="editable:false,onSelect:selSite">  
        					   <option value="-999">A+B</option>
        					   <option value="1">A</option>  
        					   <option value="2">B</option>
       						 </select>
       						<span id="durationSpan">
	       						<span class="lspan10">视频时长:</span> 
	       						<select id="durationsel" class="easyui-combobox" name="isLongVideo" style="width:50px;" data-options="editable:false">
	        					   <option value="">全部</option>
	        					   <option value="1">长</option>
	        					   <option value="0">短</option>
	       						 </select>
       						 </span>
       				    </div>
       				    <div>
       				    	
       				    </div>
       				    <div class="formbox">
<!--        				    	<div class="dbox">

								<div id="content"></div>
								<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tbody>
								<tr><td colspan="2"><strong>选择城市</strong></td></tr>
								<tr>
								  <td>
								  	<div class="cityspanarea" style="margin-left:5px;margin-top: 3px;width: 180px;height: 30px;padding-top: 10px;">
											<span class="unchecked" name="city_Span" id="selectCity" rel="2" checked="false" sel="chk">选择</span>
										<input id="cityjson" type="hidden" name="cityName" value="{&quot;data&quot;:[]}"/>
										<span id="citytext" style="display: none"></span>
									</div>
								  </td>
								</tr>
								<tr><td><div class="flowbar" rel="citytext" tip=""><span id="citynum" class="num">0</span></div></td></tr>
								</tbody>
								</table>
															  
							</div> -->
       				   			<div class="dbox">
								      <div id="content"></div>
								      <table width="100%" border="0" cellpadding="0" cellspacing="0">
								      <tbody>
								        <tr><td colspan="2"><strong>选择城市</strong></td></tr>
								        <tr>
								          <td>
								          	<div class="cityspanarea" style="margin-left:5px;margin-top: 3px;width: 180px;height: 30px;padding-top: 10px;">
								  				<span class="unchecked" name="city_Span" rel="1" checked="false" sel="chk" onclick="javascript:radiochange(this,'city_Span');" > 省份</span> 
							      				<span class="unchecked" name="city_Span" rel="2" checked="false" sel="chk" onclick="javascript:radiochange(this,'city_Span');" > 城市</span>
												<input id="cityjson" type="hidden" name="cityName" value="{data:[]}"/>
												<span id="citytext" style="display: none"></span>
											</div>
								          </td>
								        </tr>
								        <tr><td><div class="flowbar" rel="citytext" tip=""><span id="citynum" class="num">0</span></div></td></tr>
								      </tbody>
								    </table>
								  </div>
								  <div class="dbox">
								      <div id="content"></div>
								      <table width="100%" border="0" cellpadding="0" cellspacing="0">
								      <tbody>
								      <tr>
								          <td colspan="2"><strong>选择分类</strong></td>
								        </tr>
								        <tr>
								          <td >
								          	<div class="cityspanarea" style="margin-left:5px;margin-top: 3px;width: 180px;height: 30px;padding-top: 10px;">
								          		
								  				<span class="unchecked" name="channel_Span" rel="3" checked="false" sel="chk" onclick="javascript:radiochange(this,'channel_Span');"> 分类</span> 
							      				<span class="unchecked subchannelWrap" name="channel_Span" rel="4" checked="false" sel="chk" onclick="javascript:radiochange(this,'channel_Span');">二级分类</span>
												<input id="channeljson" type="hidden" name="channelName" value="{data:[]}"/>
												<span id="channeltext" style="display: none"></span>
											</div>
								          </td>
								        </tr>
								        <tr>
								          <td><div class="flowbar" rel="channeltext" tip="true"><span id="channelnum" class="num">0</span></div></td> 
								        </tr>
								      </tbody>
								    </table>
								  </div>
 								
 								  <div class="dbox" id="mobiPlateform">
								      <div id="content"></div>
								      <table width="100%" border="0" cellpadding="0" cellspacing="0">
								      <tbody>
								      <tr>
								          <td colspan="2"><strong>选择平台</strong></td>
								      </tr>
								      <tr>
								          <td style="margin-left:2px;margin-top: 3px;width: 220px;height: 25px;padding-top: 5px;">
							          		<span class="lspan10">平台:</span>
							          		<input type="hidden" name="segment" id="segment" value="">
											<!-- <select id="platformsel" class="easyui-combobox" style="width:100px;" data-options="editable:false" comboname="platform" multiple="multiple">   -->
	        					   			<!-- <option value="1,2,3,4,5,6,7,8" selected="selected">全部</option> -->
	        					   			<!-- <option value="2,6">Apple IPad</option>
	        					   			<option value="4,8">Apple IPhone</option>  
	        					   			<option value="1,5">Android Pad</option>
	        					   			<option value="3,7">Android Phone</option> -->
	       						 			<!-- </select> -->
	       						 			<span class="button pop">详细<span class="num">4</span></span>
	       						 			<div class="drop-checkbox">
	       						 				<a class="ok" href="#">确定</a>
	       						 				<label><input type="checkbox" class="data-platform" checked="checked" value="2,6">Apple IPad</label>
		        					   			<label><input type="checkbox" class="data-platform" checked="checked" value="4,8">Apple IPhone</label>  
		        					   			<label><input type="checkbox" class="data-platform" checked="checked" value="1,5">Android Pad</label>
		        					   			<label><input type="checkbox" class="data-platform" checked="checked" value="3,7">Android Phone</label>
	       						 			</div>
       						 			  </td>
       						 		   </tr>
       						 		   <tr>
       						 		   	  <td>
       						 				<div style="margin-top:8px">
										        <span class="lspan10">子平台:</span>
												<select id="clientsel" class="easyui-combobox" style="width:60px;" data-options="editable:false" comboname="clientsel">  
		        					   			<option value="1,2,3,4">Web</option>
		        					   			<option value="5,6,7,8">App</option>
		        					   			<option value="1,2,3,4,5,6,7,8" selected="selected">全部</option>
		       						 			</select>
								          </td>
								        </tr>
								        <!-- <tr>
								          <td><div class="flowbar" rel="channeltext" tip="true"><span id="channelnum" class="num">0</span></div></td> 
								        </tr> -->
								      </tbody>
								    </table>
								  </div>			
								  					  
								  <div class="dbox" style="width:200px;">
								      <div id="content"></div>
								      <table width="100%" border="0" cellpadding="0" cellspacing="0">
								      <tbody>
								        <tr><td colspan="2"><strong>选择时间</strong></td></tr>
								        <tr>
								          <td>
								          	<div style="margin-left:2px;margin-top: 3px;width: 220px;height: 20px;padding-top: 5px;">
								  				起始:<input id="start_date" class="easyui-datebox" data-options="editable:false" name="start_date" value="2012-12-21"><span class="timedetailWrap"><input id="timedetail" class="c_checkbox" type="checkbox" onclick="javascript:timeDetail(this,'time');"/>&nbsp;小时</span>
											</div>
								          </td>
								        </tr>
								        <tr><td><div style="margin-left:2px;margin-top: 3px;width: 180px;height: 20px;padding-top: 5px;">
								        		结束:<input id="end_date" class="easyui-datebox" data-options="editable:false" name="end_date" value=""></div>
								        		<input id="timejson" type="hidden" name="timeName" value="{data:[]}"/>
												<span id="timetext" style="display: none"></span>
								        	</td>
								        </tr>
								        <tr class="timedetailWrap">
								          <td><div class="flowbar" rel="timetext" style="margin-top: 6px;" tip=""><span id="timenum" class="num">0</span></div></td> 
								        </tr>
								      </tbody>
								    </table>
								  </div>		  
								  <div class="dbox">
								      <div id="content"></div>
								      <table width="100%" border="0" cellpadding="0" cellspacing="0">
								      <tbody>
								        <tr>
								          <td colspan="2"><strong>选择汇总条件</strong></td>
								        </tr>
								        <tr>
								          <td >
								          	<div style="margin-left:2px;width: 300px;">
								  				<label class="lspan5"><input class="c_checkbox" name="group_province" type="checkbox" value="1"/>&nbsp;按省份</label>
								  				<label class="lspan5"><input class="c_checkbox" name="group_city" type="checkbox" value="1"/>&nbsp;按城市</label><br/>
								  				<label class="lspan5"><input class="c_checkbox" name="group_channel" type="checkbox" value="1"/>&nbsp;按一级分类</label>
								  				<label class="lspan5 subchannelWrap"><input class="c_checkbox" name="group_subchannel" type="checkbox" value="1"/>&nbsp;按二级分类</label><br/>
								  				<label class="lspan5"><input class="c_checkbox" name="group_date" type="checkbox" value="1"/>&nbsp;按天汇总</label>
								  				<label class="lspan5"><input class="c_checkbox" name="group_site" type="checkbox" value="1"/>&nbsp;按网站</label>
								  				<label id="hours_detail" class="lspan5" style="margin-top: 5px;display: none"><input class="c_checkbox" name="group_hour" type="checkbox" value="1"/>&nbsp;按小时</label>
												<label class="lspan5" style="margin-top: 5px; display: none;"><input class="c_checkbox" name="group_cast" type="checkbox" value="1"/>&nbsp;按投放顺序</label>
								          	    <label class="lspan5" style="margin-top: 5px; display: none;"><input class="c_checkbox" name="group_idea" type="checkbox" value="1"/>&nbsp;按素材ID</label>
								          	    <label class="lspan5" style="margin-top: 5px; display: none;"><input class="c_checkbox" name="group_order" type="checkbox" value="1"/>&nbsp;按合同ID</label>
								          	    <label id="group_type_label"  class="lspan5"><input class="c_checkbox" name="group_type_id" type="checkbox" value="1"/>&nbsp;按广告类型</label>
												<label id="group_platform" class="lspan5"><input class="c_checkbox" name="group_platform" type="checkbox" value="1"/>&nbsp;按平台</label>
												<label id="group_client" class="lspan5"><input class="c_checkbox" name="group_client" type="checkbox" value="1"/>&nbsp;按子平台</label>
												<label id="group_videolength_type" class="lspan5"><input class="c_checkbox" name="group_videolength_type" type="checkbox" value="1"/>&nbsp;按视频时长</label>
											</div>
								          </td>
								        </tr>
								      </tbody>
								    </table>
								  </div>
       				     </div>
       				     <div style="float:right;margin-right:80px;">
       				     	<a id="searchbutton" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">查询</a> <a id="exportbutton" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">导出</a>
       				     	<a id="clearbutton" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">清空</a>
       				     	<input id="exportmode" type="hidden" name="exportExcelMode" value="0"/>
       				     </div>
       				     </div>
       				     </form>
        	      </div>
        	       <div id="exportDialog" class="easyui-dialog" title="导出" style="width:300px;height:160px;padding: 4px;"  data-options="resizable:false,modal:true,left:$('#exportbutton').offset().left-400,top:$('#exportbutton').offset().top+40,buttons:'#exportButn',closed:true">  
    						<div style="margin-top: 10px;margin-left: 42px;display: none;">出于性能考虑一次最多导出5000行数据！</div>
    						<div style="margin-top: 20px;margin-left: 42px;"> 从 <span class="combo" style="width: 130px;"><input class="exportInput" id="startRow" name="startRow"  style="border: 0 none; height: 20px;" value="1"/></span>  行 </div>
    						<div style="margin-top: 10px;margin-left: 42px;"> 到 <span class="combo" style="width: 130px;"><input class="exportInput" id="endRow" name="endRow"  style="border: 0 none; height: 20px;" value="5000"/></span>  行 </div>
				   </div>
				   <div id="exportButn">
				  			<a id="exportCommit" href="#" class="easyui-linkbutton" data-options="">确定</a>
							<a id="exportCancel" href="#" class="easyui-linkbutton" data-options="">取消</a>
				   </div>  
		      </div>  
		      <div data-options="region:'center'">
		      		<div id="Data_Grid_Div">
    				</div>
    				<span id="grid_create" style="display: none" rel=""/>
		     </div>
		    </div>
		    <iframe id="exportIframe" name="exportIframe" style="display: none;width:1px;height:1px;" src="about:blank"></iframe>

       <script>
        var debug = true;
        //var pop,poppro,popcate,popsubcate,poptime;
        $(function(){
        	// 
        	//ApplicationFacade.getInstance().startup( $("body") );
        	try {
        		console.debug("jquery.ready");
        	} catch( ex ) {
        		
        	}
        	requestChannel('${path}',function(){
        	  	pop = jQuery.fn.popcity();
            	poppro = jQuery.fn.popprovince();
            	//
            	popcate = jQuery.fn.popcate();
            	popsubcate = jQuery.fn.popsubcate();
            	poptime = jQuery.fn.poptime({closeback:function(){
            		clearDetailTime();
            		poptime.tclean();
            	}});
         //    	//
            	

        	});
        	

        	requestCity('${path}', function( ) {
          	  //alert(GeoSingleton.getInstance().provinces);
          	  	
          	  
          	  
          	  	
          	  	
          	  	
          	});
        	
        	// /*
        	// $('.flowbar').bind('mouseover',function(){
        	// 	$(this).css('background-color','#e1e1e1');
        	// });
        	// $('.flowbar').bind('mouseout',function(){
        	// 	$(this).css('background-color','#f4f4f4');
        	// }); */
        	var now = dateFormat(new Date());
        	$('#start_date').datebox('setValue',now);
        	$('#end_date').datebox('setValue',now);
        	$('div.flowbar').aToolTip({
        		fixed: true,
        		tipContent : function(obj){
        			var targetid = obj.attr('rel');
        			var text=$('#'+targetid).html();
        			if(text!=''){
        				text=text.substring(0,text.length-1);
        			}
        			return text;
        		},
        		xOffset: -80,
        		yOffset:-18,
        		width:'140px'
        	}); 
        });
        </script>
        <script type="text/javascript">
 		function createTime(data) {
 			var jstr = JSON.stringify(data);
 			var rearry = getViewData(data);
 			$("#timejson").val("{data:"+jstr+"}");
 			$('#timetext').html(rearry[1]);
 			$('#timenum').html(rearry[0]);
 			if(rearry[0]=='0'){
 				clearDetailTime();
 			}
 		}
 		
 		function createCity(data) {
 			var jstr = JSON.stringify(data);
 			var rearry = getViewData(data);
 			$("#cityjson").val("{data:"+jstr+"}");
 			$('#citytext').html(rearry[1]);
 			$('#citynum').html(rearry[0]);
 		}
 		
 		function createCate(data) {
 			var jstr = JSON.stringify(data);
 			var rearry = getViewData(data);
 			$("#channeljson").val("{data:"+jstr+"}");
 			$('#channeltext').html(rearry[1]);
 			$('#channelnum').html(rearry[0]);
 		}
 		
		function selSite(data) {
			popcate.catclean();
			popsubcate.sclean();
			$('#channeljson').val('{data:[]}');
			$('#channeltext').html('');
			$('#channelnum').html('0');
			$('#channelnum').parent().attr('tip','');
			return true;
			// var selectPop = $('#selectCat').data('SelectPop'),
			// 	site ={
			// 		"1":"a",
			// 		"2":"b",
			// 	},
			// 	//要清空另一个site，不是当前选中的
			// 	otherSite = {
			// 		"1":"b",
			// 		"2":"a"
			// 	},
			// 	$topItems,
			// 	$subLists;

			// if(data.value !="-999"){

			// 	$topItems=selectPop.$body.find('li.'+selectPop.topItemClass+'[data-site=' + otherSite[ data.value ] +']'),
			// 	$subLists=selectPop.$body.find('ul.'+selectPop.subListClass+'[data-site=' + otherSite[ data.value ] +']');
			// 	//处理一级选项
			// 	$topItems.removeClass(selectPop.onClass).find('input').attr('checked',false);
			// 	$subLists.find('li').removeClass(selectPop.onClass);
			// 	$subLists.find('.all').data('on',false).text('全选');
			// 	selectPop.save();
			
			// 	$topItems.hide();
			// 	$subLists.hide();
			// 	selectPop.$body.find('li.'+selectPop.topItemClass+'[data-site=' + site[ data.value ] +']').show();
			// }else{
			// 	selectPop.$body.find('li.'+selectPop.topItemClass).show();
			// }

		}
		
		
		//function selPlatform( data ) {
			// TODO	
			//alert( "select certain platfrom. data="+data );
		//}
		//function selClient( data ) {
			// TODO
			//alert( "select certain client. data="+data );
		//}
		
		function selAdtype(data) {}
		
        function valiform() {
        	var startdate = $('[name="start_date"]').val();
        	var enddate = $('[name="end_date"]').val();
        	if(startdate=='' || enddate==''){
        		return formError('请填写完整的起始和结束日期！');
        	}
        	var starttime=Date.parse(startdate.replace('-',"/"));
        	var endtime=Date.parse(enddate.replace('-',"/"));
        	if(parseFloat(endtime)<parseFloat(starttime)){
        		return formError('查询的结束日期要大于起始日期！');
        	}
        	return true;
        }
   		function mapGetValue(i,v){return v.value;}
   		function inputsToValueList($inputs){
   			return $inputs.map(mapGetValue).get().join(',');
   		}
        $.fn.form.defaults={
				type:'post',
				onSubmit: function() {

					//$('[name=video_ad_type]').val('(' + inputsToValueList($['name=video_ad_type_box']) + ')');
					//计算平台值
					$("#segment").val('('+
						mergeList(
							//转换多选成一个值
							//由于各选项互斥，直接连接
							inputsToValueList( $('.data-platform:checked') ),
							inputsToValueList( $('[name=' +$('#clientsel').attr('comboname')+']') )
						)
						+')'
					);
					var vali = valiform();
					if(vali) $('body').showLoading();
					return vali;	// 返回false将停止form提交 
				},
				success: function(data) {
					var obj = null;
					try{
						obj = JSON.parse(data);
					}catch(e){
						formError('加载数据错误！请联系管理员！');
					}
					if(obj&&obj.success=='true') {
						if($('#grid_create').attr('rel')) {
							pageGrid('Data_Grid_Div',obj.result);
						}else{
							createGrid('Data_Grid_Div',obj.result,"access_form");
							$('#grid_create').attr('rel',true);
						}
						$('body').hideLoading();	// 当成功提交之后隐藏进度条
					} else if(obj&&obj.success=='empty') {
						clearGrid('Data_Grid_Div');
						formError('此条件下，没有数据！');
					} else {
						formError( obj.errorMessage!=null ? obj.errorMessage : '加载数据错误！请联系管理员！' );
					}
					if(debug&&obj&&obj.sql){
						showLog("sql---- "  + unescape(obj.sql) );
					}
					if(debug&&obj&&obj.timecost){
						showLog("timecost---- " +obj.timecost);
					}
				}
		};

 		$(function(){

	 		$('#searchbutton').bind('click',function(e){
	 			$('#exportmode').val('0');
	 			$('#grid_create').attr('rel',"");
	 			if(parseInt($('input[name="video_ad_type"]').val())!=12){
	 				submitForm('access_form','${path}/inventory/queryInventory.sdo','1');
	 			} else {
	 				formError('页面广告数据正在开发中!');
	 			}
	 		});
	 		
	 		$('#clearbutton').bind('click' , function(e){
	 			clearForm('ad_tracking_form');
	 		});
	 		
	 		$('#exportbutton').bind('click',function(e){
	 			$('#exportDialog').dialog('open');
	 			return false;
	 		});
	 		
	 		$('#exportCommit').bind('click',function(e){
	 			var startrow = $('#startRow').val();
	 			var endrow = $('#endRow').val();
	 			if(valiExportRow(startrow,endrow)) {
		 			$('#exportmode').val('1');
	 				startrow=startrow-1;
	 				var param='startRow='+startrow+'&endRow='+endrow;
	 	 			exportForm('exportIframe','access_form','${path}/inventory/exportexcel.sdo?'+param);
	 	 			$('#exportDialog').dialog('close');
	 			}
	 		});
	 		
	 		$('#exportCancel').bind('click',function(e){
	 			$('#exportDialog').dialog('close');
	 			//FIX : ADS-4712
	 			//$('.exportInput').val('');
	 		});
 		})

	$(function(){
		if(location.href.indexOf('isMobile') == -1){
			//没有isMobile参数，隐藏移动分类
			
			$('.panel-title').text('ABPC容量统计')
			
			//隐藏时长
			$('#segment,#durationSpan').remove();
			//隐藏
			//  移动平台选择器
			//  按平台汇总
			//  按子平台汇总
			//  按视频时长汇总
			//  时间小时
			
			$('#mobiPlateform,#group_platform,#group_client,#group_videolength_type,#group_type_label').hide();
		}else{

			$('.panel-title').text('AB移动容量统计')
			
			//含有小时文字的选项卡和底部计数
			$('.timedetailWrap').remove();
			//隐藏
			//  二级分类
			$('.subchannelWrap').hide()
		}
 	// 	new SelectPop2({
		// 	title: "请选择城市",
		// 	catName: "省",
		// 	subCatName: "市",
		// 	jsonDataName: "data",
		// 	itemPrefix: "c",
		// 	listClass: "topList",
		// 	subListClass: "subList",
		// 	topItemClass: "topItem",
		// 	$open: $('#selectCity'),
		// 	$json: $('#cityjson'),
		// 	$count: $('#citynum'),
		// 	url: '${path}/bin/City.json'
		// });
		// var mobi = "";
		// if(location.href.indexOf('isMobile') != -1){
		// 	mobi = "?isMobile=1"
		// }
		// new SelectPop2({
		// 	className:"channels",
		// 	nameName:"CHANNEL_NAME",
		// 	childrenName:"children",
		// 	title: "请选择分类",
		// 	catName: "大类",
		// 	subCatName: "子类",
		// 	jsonDataName: "data",
		// 	itemPrefix: "c",
		// 	listClass: "topList",
		// 	subListClass: "subList",
		// 	topItemClass: "topItem",
		// 	$open: $('#selectCat'),
		// 	$json: $('#channeljson'),
		// 	$count: $('#channelnum'),
		// 	url: '${path}/as/queryChannel.sdo' + mobi,
		// 	renderOptions:function( json, listClass, itemClass){
		// 		console.log('渲染两级分类列表',json);
		// 		var a=this.renderSiteOption(json, "a", listClass, itemClass),
		// 			b=this.renderSiteOption(json, "b", listClass, itemClass);
		// 		return '<ul class="'+ listClass +'">' + a[0] + b[0] + '<li class="all top">全选</li></ul>' + a[1] + b[1];
		// 	},
		// 	renderSiteOption:function( json, site, listClass, itemClass){
		// 		var html='', subHtml = '',siteJSON=json[site];
		// 		for(var i = 0, l = siteJSON.length; i < l; ++i ){
		// 		    html +=  this.renderOption( siteJSON[i], site, this.topItemClass, siteJSON[i][this.childrenName].length == 1 ? 'single':'');
					
		// 		    subHtml += this.renderList( siteJSON[i], site, this.subListClass, itemClass);
		// 		}
		// 		return [html,subHtml];
		// 	},
		// 	renderOption:function(item, site, itemClass, single){
		// 		single = single || '';
		// 		var id = this.getId(item);
		// 		return '<li class="' + itemClass +' ' +single + '" id="' + itemClass + id + '" data-id="' + id + '" data-site="'+ site+'">' 
		// 			+ ( itemClass.indexOf(this.topItemClass) !== -1 ? '<input type="checkbox">' :'') 
		// 			+ item[this.nameName] + '</li>';
		// 	},
		// 	renderList:function(list, site, listClass, itemClass){
		// 		var id = this.getId(list),
		// 			html = '<ul class="' + listClass + '" id="' + listClass + id + '" data-id="' + id + '" data-name="' + list[ this.nameName ]+ '" data-site="'+ site +'">',
		// 			json = list[this.childrenName];
		// 		if(json.length == 0){
		// 			return "";
		// 		}
		// 		else if(json.length == 1){
					
		// 			return html + this.renderSubOption( json[0], itemClass, 'single') + '</ul>';
				
		// 		}else{

		// 			for(var i = 0, l = json.length; i < l; ++i ){

		// 			    html += this.renderSubOption( json[i], itemClass );
		// 			}

		// 			return html + '<li class="all">全选</li>' + '</ul>';
		// 		}

		// 	},
		// 	renderSubOption:function(item, itemClass, single){
		// 		single = single || '';

		// 		return '<li class="' + itemClass +' ' +single + '" id="' + itemClass + item.SUB_CHANNEL_ID + '" data-id="' + item.SUB_CHANNEL_ID + '">' 
		// 			+ item.SUB_CHANNEL_NAME + '</li>';
		// 	},
		// 	getId:function(node){
		// 		if(node.SITE_ID == 1){
		// 			return node.CHANNEL_CODE;
		// 		}else{
		// 			return node.CHANNEL_NUMBER;
		// 		}
		// 	},
		// 	item2json:function( i, v ){
		// 		return '{"id":"' + v.getAttribute( 'data-id' ) + '","'+ this.nameName +'":"' + v.innerHTML + '"}';
		// 	},
		// 	DOM2Value:function(){
		// 		var name=[],
		// 			self = this,
		// 			$onList  = this.$body.find('.' + this.subListClass + ':has(.' + this.onClass + ')');
				
		// 		//console.log("含有选中项的子列表",$onList.html());
		// 		var json=$onList.map(function(i,v){

		// 			var $v = $(v), cs = $(v).find('.' + self.onClass ).map(function(i, sItem){
		// 				//console.log('子选项',sItem);
		// 				name.push( $v.data('name') + '-' + sItem.innerHTML );
		// 				return self.item2json.call(self, i, sItem);
		// 			}).get().join(',');

		// 			return '{"id":"' + $v.data('id') + '","name":"' + $v.data('name') + '","cs":[' + cs + ']}';
		// 		}).get().join(',');
				
		// 		return {
		// 			"list"  : json,
		// 			"length": $onList.length + self.catName + ',' + name.length + self.subCatName,
		// 			"name"  : name.join(',')
		// 		}
		// 	}
		// });
	});
 		</script>

</html>