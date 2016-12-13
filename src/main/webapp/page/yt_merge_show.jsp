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
        <script type="text/javascript" src="${path}/bin/popcity.js"></script>
        <script type="text/javascript" src="${path}/bin/popprovince.js"></script>
        <script type="text/javascript" src="${path}/bin/popcate.js"></script>
        <script type="text/javascript" src="${path}/bin/popsubcate.js"></script>
        <script type="text/javascript" src="${path}/bin/poptime.js"></script>
        <script type="text/javascript" src="${path}/bin/base.js"></script>
	</head>
	<body>
		<div id="layout_div" class="easyui-layout" style="width:1100px; height:720px;">
		     <div data-options="region:'north'" style="height:230px">
		          <div id="formPanel" class="easyui-panel" data-options="fit:true" title="优酷土豆效果统计" style="padding:10px;background-color: #fafafa">  
        	 			<form id="ad_tracking_form" method="post"><div>
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
	        					   <!--
	        					   <option value="2">前贴广告查询</option>
	        					   <option value="-3">长前贴广告查询</option>
	        					   <option value="-1">短前贴/全屏前贴/赞助标版广告查询</option>
	        					   <option value="5">后贴广告查询</option>
	        					   <option value="13">贴片广告查询</option>
	        					   <option value="4">暂停广告查询</option>
	        					   <option value="8">中插广告查询</option>
	        					   <option value="11">播放页Banner广告查询</option>
	        					   <option value="10">角标广告查询</option>
	        					   <option value="12">页面广告查询</option>	        					   
	        					   -->
        					   		<option value="2">前贴广告查询</option>
        					   	<option value="3">长前贴广告查询</option>
        					   <option value="1">短前贴</option>
        					   <option value="6">全屏前贴</option>
        					   <option value="7">赞助标版广告查询</option>
        					   <option value="5">后贴广告查询</option>
        					   <option value="13">贴片广告查询</option>
        					   <option value="4">暂停广告查询</option>
        					   <option value="8">中插广告查询</option>
        					   <option value="11">播放页Banner广告查询</option>
        					   <option value="10">角标广告查询</option>
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
        					    <option value="-999">优酷+土豆</option>
        					    <option value="1">优酷</option>  
        					    <option value="2">土豆</option>
       						 </select>
       						 <span class="lspan10">订单ID:</span>
       						 <select class="easyui-combobox" name="orderId" style="width:80px;" data-options=""></select>
       						 <span class="lspan10" >合同名称:</span>	
       						 <select class="easyui-combobox" name="orderName" style="width:200px;" data-options=""></select>
							 
    						<span id="durationSpan">
	       						<span class="lspan10">视频时长:</span> 
	       						<select id="durationsel" class="easyui-combobox" name="isLongVideo" style="width:50px;" data-options="editable:false">
	        					   <option value="">全部</option>
	        					   <option value="1">长</option>
	        					   <option value="0">短</option>
	       						 </select>
       						 </span>
							 
							 
       						 <div id="longvideopos" style="float: right; margin-right: 80px; display: none">
       						 <span class="lspan10">长视频广告位:</span>	
       						 <select class="easyui-combobox"  name="typeId" style="width:72px;" data-options="">
       						 	<option value="(2,3,9,20)">全部</option>
        					   	<option value="(2)">长一前贴</option>
        					   	<option value="(3)">长二前帖</option>
        					   	<option value="(9)">长三前帖</option>
        					   	<option value="(20)">长四前帖</option>
       						 </select>
       						 </div>
							 <div style="float: right; margin-right: 15px; ">
							  <input type="checkbox" name="includeSupplement" value="1" onclick="javascript:handleIncludeSupplementCheckBoxClick(this);"/>是否关联补量合同
							 </div>
       				    </div>
       				    <div class="formbox">
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
		       						 		</div>
								          </td>
								        </tr>
<!-- 								        <tr>
								          <td><div class="flowbar" rel="channeltext" tip="true"><span id="channelnum" class="num">0</span></div></td> 
								        </tr> -->
								      </tbody>
								    </table>
								  </div>
								  <div class="dbox" style="width: 230px">
								      <div id="content"></div>
								      <table width="100%" border="0" cellpadding="0" cellspacing="0">
								      <tbody>
								        <tr><td colspan="2"><strong>选择时间</strong></td></tr>
								        <tr>
								          <td>
								          	<div style="margin-left:2px;margin-top: 3px;width: 220px;height: 20px;padding-top: 5px;">
								  				起始:<input id="start_date" class="easyui-datebox" data-options="editable:false" name="start_date" value="">
								  				<span class="timedetailWrap"><input id="timedetail" class="c_checkbox" type="checkbox" onclick="javascript:timeDetail(this,'time');"/>&nbsp;小时</span>
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
								  <div class="dbox" style="width: 320px">
								      <div id="content"></div>
								      <table width="100%" border="0" cellpadding="0" cellspacing="0">
								      <tbody>
								        <tr>
								          <td colspan="2"><strong>选择汇总条件</strong></td>
								        </tr>
								        <tr>
								          <td >
								          	<div style="">
								  				<label class="lspan5"><input class="c_checkbox" name="group_province" type="checkbox" value="1"/>&nbsp;按省份</label>

								  				<label class="lspan5"><input class="c_checkbox" name="group_city" type="checkbox" value="1"/>&nbsp;按城市</label>
								  				<label id="groupByIncludeSupplementCheckBox" class="lspan5" style="display: none;width:95px;"><input class="c_checkbox" name="group_isAmount" type="checkbox" value="1"/>&nbsp;按(主量/补量)</label>
								  				<br/>
								  				<label class="lspan5"><input class="c_checkbox" name="group_channel" type="checkbox" value="1"/>&nbsp;按一级分类</label>

								  				<label class="lspan5 subchannelWrap"><input class="c_checkbox" name="group_subchannel" type="checkbox" value="1"/>&nbsp;按二级分类</label>
								  				<br/>
								  				<label class="lspan5"><input class="c_checkbox" name="group_order" type="checkbox" value="1"/>&nbsp;按订单ID</label>
								  				 
								  				<label class="lspan5"><input class="c_checkbox" name="group_cast" type="checkbox" value="1"/>&nbsp;按投放ID</label>
								  				
								          	    <label class="lspan5"><input class="c_checkbox" name="group_idea" type="checkbox" value="1"/>&nbsp;按素材ID</label>
								          	    <br/> 	    
								          	    <label class="lspan5"><input class="c_checkbox" name="group_date" type="checkbox" value="1"/>&nbsp;按天</label>
								          	    
								          	    <label class="lspan5"><input class="c_checkbox" name="group_site" type="checkbox" value="1"/>&nbsp;按网站</label>
								          	    <label id="group_videolength_type" class="lspan5"><input class="c_checkbox" name="group_videolength_type" type="checkbox" value="1"/>&nbsp;按视频时长</label>

								          	    
												<label id="hours_detail" class="lspan5" style="margin-top: 5px;display: none"><input class="c_checkbox" name="group_hour" type="checkbox" value="1"/>&nbsp;按小时</label>
												<br/>
								          	    
								          	    <label id="type_detail"  class="lspan5"><input class="c_checkbox" name="group_slot_id" type="checkbox" value="1"/>&nbsp;按投放顺序</label>

												<label id="group_type_label"  class="lspan5"><input class="c_checkbox" name="group_type_id" type="checkbox" value="1"/>&nbsp;按广告类型</label>
												
												<label id="group_platform" class="lspan5"><input class="c_checkbox" name="group_platform" type="checkbox" value="1"/>&nbsp;按平台</label>

												<label id="group_client" class="lspan5"><input class="c_checkbox" name="group_client" type="checkbox" value="1"/>&nbsp;按子平台</label>

												
											</div>
								          </td>
								        </tr>
								      </tbody>
								    </table>
								  </div>
       				     </div>
       				     <div style="float:right;margin-right:90px;margin-top: 8px;">
       				     	<a id="searchbutton" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">查询</a> <a id="exportbutton" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">导出</a>
       				     	<a id="clearbutton" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">清空</a>
       				     	<input id="exportmode" type="hidden" name="exportExcelMode" value="0"/>
       				     	<input type="hidden" name="tableName" value="DW_ADS_IMP_HOUR_1"/>
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
    				<span id="grid_create" style="display: none;" rel=""/>
		     </div>
		    </div>
		     <iframe id="exportIframe" name="exportIframe" style="display: none;width:1px;height:1px;" src="#"></iframe>
       <script type="text/javascript">
       var debug = true;
        var pop,poppro,popcate,popsubcate,poptime;
        $(document).ready(function(){
        	requestChannel('${path}',function(){
        	  	pop = jQuery.fn.popcity();
            	poppro = jQuery.fn.popprovince();
            	popcate = jQuery.fn.popcate();
            	popsubcate = jQuery.fn.popsubcate();
            	poptime = jQuery.fn.poptime({closeback:function(){
            		clearDetailTime();
            		poptime.tclean();
            	}});
            	
            	
            	requestCity('${path}',function() {
            	  	// TODO
            	  	// alert(arguments);
            	});
        	});
        	/*
        	$('.flowbar').bind('mouseover',function(){
        		$(this).css('background-color','#e1e1e1');
        	});
        	$('.flowbar').bind('mouseout',function(){
        		$(this).css('background-color','#f4f4f4');
        	}); */
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

        	
        	if(location.href.indexOf('isMobile') == -1){
        		//PC版本
				//没有isMobile参数，隐藏
				$('.panel-title').text('优酷土豆PC效果统计')
				
				// 平台，时长选择
				$('#segment, #durationSpan, mobiPlateform').remove();
				//隐藏
				//  移动平台选择器
				//  按平台汇总
				//  按子平台汇总
				//  按视频时长汇总
				//  首行时长选择框
				//  按投放顺序
				//  按广告位
				$('#mobiPlateform,#group_platform,#group_client,#group_videolength_type, #type_detail, #group_type_label').hide();
				
			}else{
				//移动版本
				$('.panel-title').text('优酷土豆移动效果统计')
				//含有小时文字的选项卡
				$('.timedetailWrap').remove();
				 
				//隐藏
				//  二级分类
				$('.subchannelWrap').hide();
				
				// 
				$('#type_detail,#group_slot_id').hide();
			}

        });
        </script>
        <script type="text/javascript">
 		function createTime(data) {
 			var jstr = JSON.stringify(data);
 			var rearry = getViewData(data);
 			$("#timejson").val("{data:"+jstr+"}");
 			$('#timetext').html(rearry[1]);
 			$('#timenum').html(rearry[0]);
 			if(rearry[0]=='0') {
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
		}
		
		function selAdtype(data) {
			if(parseInt(data.value)==3){
				$('#longvideopos').show();
				$('#type_detail').show();
			}else{
				$('#longvideopos').hide();
				$('#type_detail').hide();
				$('#type_detail > input').attr('checked',false);
			}
		}
		
        function valiform(){
        	var orderId = $.trim($('[name="orderId"]').val());
    		var startdate = $('[name="start_date"]').val();
        	var enddate = $('[name="end_date"]').val();
        	if(orderId==''){
            	if(startdate=='' || enddate==''){
            		return formError('请填写完整的起始和结束日期！');
            	}
        	}
        	if(startdate!='' && enddate!='' ) {
        		var starttime=Date.parse(startdate.replace('-',"/"));
            	var endtime=Date.parse(enddate.replace('-',"/"));
            	if(parseFloat(endtime)<parseFloat(starttime)){
            		return formError('查询的结束日期要大于起始日期！');
            	}
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
					//mergeList
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
						} else {
							createGrid('Data_Grid_Div',obj.result,"ad_tracking_form");
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
						showLog("sql---- " +unescape(obj.sql));
					}
					if(debug&&obj&&obj.timecost){
						showLog("timecost---- " +obj.timecost);
					}
				}
		};
 		
 		$('#searchbutton').bind('click',function(e){
 			$('#exportmode').val('0');
 			$('#grid_create').attr('rel',"");
 			if(parseInt($('input[name="video_ad_type"]').val())!=12){
 				submitForm('ad_tracking_form','${path}/ad/queryImpression.sdo','1');
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
 			if(valiExportRow(startrow,endrow)){
 				$('#exportmode').val('1');
 				startrow=startrow-1;
 				var param='startRow='+startrow+'&endRow='+endrow;
 	 			exportForm('exportIframe','ad_tracking_form','${path}/ad/exportexcel.sdo?'+param);
 	 			$('#exportDialog').dialog('close');
 			}
 		});
 		
 		$('#exportCancel').bind('click',function(e){
 			$('#exportDialog').dialog('close');
 			//FIX : ADS-4712
 			//$('.exportInput').val('');
 		});
 		</script>
</body>
</html>