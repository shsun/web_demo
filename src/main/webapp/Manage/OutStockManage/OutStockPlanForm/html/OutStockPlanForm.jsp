<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/ExtJS/resources/ext-theme-neptune-all.css" />
<script type="text/javascript" src="<%=path%>/ExtJS/ext-all.js"></script>
<!-- JSON数据源 -->
<script type="text/javascript" src="<%=path%>/Manage/OutStockManage/OutStockPlanForm/store/OutStockPlanFormStore.js"></script>
<script type="text/javascript" src="<%=path%>/Manage/OutStockManage/OutStockPlanForm/store/OutStockPlanContentStore.js"></script>
<!-- 显示界面 -->
<script type="text/javascript" src="<%=path%>/Manage/OutStockManage/OutStockPlanForm/uijs/OutStockPlanForm.js"></script>
<!-- 出库单计划内容 -->
<script type="text/javascript" src="<%=path%>/Manage/OutStockManage/OutStockPlanForm/uijs/OutStockPlanContent.js"></script>

<!-- goods（货物） store -->
<script type="text/javascript" src="<%=path%>/Manage/ProductionManage/ProductionPlanForm/store/GoodsStore.js"></script>
<!-- user（员工） store -->
<script type="text/javascript" src="<%=path%>/Manage/ProductionManage/ProductionPlanForm/store/UserStore.js"></script>
<!-- customer（客户）store -->
<script type="text/javascript" src="<%=path%>/Manage/OutStockManage/OutStockForm/store/CustomerStore.js"></script>
<!-- location（库位）store -->
<script type="text/javascript" src="<%=path%>/Manage/OutStockManage/OutStockPlanForm/store/LocationStore.js"></script>
</head>
<body>

</body>
</html>