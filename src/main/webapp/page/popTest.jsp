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
        
        <!-- Signals library -->
        <script type="text/javascript" src="${path}/lib/signals.js"></script>
		<!-- Objs library -->
		<script type="text/javascript" src="${path}/lib/objs-2.1.2-min.js"></script>
		<!-- PureMVC framework for JavaScript based on Objs -->
		<script type="text/javascript" src="${path}/lib/puremvc-objs-2.0-min.js"></script>
		
		
		<script type="text/javascript" src="${path}/bin/application_constants.js"></script>
		<script type="text/javascript" src="${path}/bin/base.js"></script>
        <!--<script type="text/javascript" src="${path}/bin/popcity.js"></script>
        <script type="text/javascript" src="${path}/bin/popprovince.js"></script>
        <script type="text/javascript" src="${path}/bin/popcate.js"></script>
        <script type="text/javascript" src="${path}/bin/popsubcate.js"></script>
        <script type="text/javascript" src="${path}/bin/poptime.js"></script>
        -->
        <script type="text/javascript" src="${path}/bin/popSelect.js"></script>
        <!-- application code -->		
		<script type="text/javascript" src="${path}/bin/application.js"></script>
        <link rel="stylesheet/less" type="text/css" href="${path}/css/popSelect.less"/>
	</head>
<div class="dbox">

	<div id="content"></div>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tbody>
	<tr><td colspan="2"><strong>选择城市</strong></td></tr>
	<tr>
	  <td>
	  	<div class="cityspanarea" style="margin-left:5px;margin-top: 3px;width: 180px;height: 30px;padding-top: 10px;">
				<span class="unchecked" name="city_Span" id="selectProvence" rel="1" checked="false" sel="chk"> 省份</span> 
				<span class="unchecked" name="city_Span" id="selectCity" rel="2" checked="false" sel="chk"> 城市</span>
			<input id="cityjson" type="hidden" name="cityName" value="{&quot;data&quot;:[]}"/>
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
		<td>
			<div class="cityspanarea" style="margin-left:5px;margin-top: 3px;width: 180px;height: 30px;padding-top: 10px;">
				<span class="unchecked" name="channel_Span" rel="3" checked="false" sel="chk">分类</span> 
				<span class="unchecked" name="channel_Span" rel="4" checked="false" sel="chk">二级分类</span>
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
</div>
<script type="text/javascript" src="${path}/bin/less.js"></script>
