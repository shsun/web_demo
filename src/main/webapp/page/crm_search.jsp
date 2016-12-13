<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<c:set var="version" value="${applicationScope.SysVersion}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="${ctx}/ExtJS/resources/css/ext-all.css?v=${version}"/>
		<link rel="stylesheet" type="text/css" title="blue" href="${ctx}/ExtJS/resources/css/xtheme-blue.css?v=${version}" />
		<link rel="stylesheet" type="text/css" title="gray" href="${ctx}/ExtJS/resources/css/xtheme-gray.css?v=${version}" />
		
		<style type="text/css">
			.x-form-display-field{padding-top: 3px;}
			.x-selectable, .x-selectable * {  
				-moz-user-select: text!important;  
				-khtml-user-select: text!important;  
				-webkit-user-select: text!important;
			}
		</style>
		
		<script type="text/javascript" src="${ctx}/ExtJS/adapter/ext/ext-base.js?v=${version}"></script>
		<script type="text/javascript" src="${ctx}/ExtJS/ext-all.js?v=${version}"></script>
		<script type="text/javascript" src="${ctx}/ExtJS/src/locale/ext-lang-zh_CN.js?v=${version}"></script>
		
		<script type="text/javascript" src="${ctx}/ExtJS/plugin/cellselect.js?v=${version}"></script>
		<script type="text/javascript" src="${ctx}/ExtJS/plugin/CommonRenderer.js?v=${version}"></script>
		<script type="text/javascript" src="${ctx}/ExtJS/plugin/CostPagingToolbar.js?v=${version}"></script>
		<script type="text/javascript" src="${ctx}/ExtJS/plugin/chrome18up_grid_bug_fix.js?v=${version}"></script>
		<script type="text/javascript" src="crm_search.js?v=${version}"></script>
		
		<script type="text/javascript">
			Ext.BLANK_IMAGE_URL = '${ctx}/ExtJS/resources/images/default/s.gif';
			var ctx = '${ctx}';
			Ext.onReady(function() {
				var crm_SearchGridPanel = new com.shsun.ad.crm.crm_third.Crm_SearchGridPanel({ctx:ctx, region: 'center'});
				crm_SearchGridPanel.initMethod();
				var viewport = new Ext.Viewport({
					layout: 'border',
					items: [crm_SearchGridPanel]
				});
			});
		</script>
	</head>
	<body>
	</body>
</html>