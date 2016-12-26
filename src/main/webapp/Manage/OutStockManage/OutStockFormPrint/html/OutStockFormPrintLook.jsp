<%@page import="org.springframework.web.context.request.RequestScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>出库单打印</title>

</head>
<script type="text/javascript">
	function doPrint() {
		bdhtml = window.document.body.innerHTML;
		sprnstr = "<!--startprint-->";
		eprnstr = "<!--endprint-->";
		prnhtml = bdhtml.substr(bdhtml.indexOf(sprnstr) + 17);
		prnhtml = prnhtml.substring(0, prnhtml.indexOf(eprnstr));
		window.document.body.innerHTML = prnhtml;
		window.print();
	}
</script>
<body>

	

		<a href="javascript:;"onClick="doPrint()">打印</a>
         
	
	<br>
		<!--startprint-->
	<table border="1" style="border-collapse: collapse; font-size: 9px">
		<tr height="10">
			<td colspan="5" align="center"><font size="5"
				style="font-weight: bold;">天津天物金佰出库单</font></td>
			<td colspan="3"><font size="5" style="font-weight: bold;">车辆：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：</font>
			</td>
			<td rowspan="1111111" width="70">第一联 随车发送 营业留存</td>
		</tr>
		<tr bgcolor="#C0C0C0">
			<td width="100"><font style="font-weight: bold;"> 日期 </font></td>
			<td width="100"><font style="font-weight: bold;">货物编号</font></td>
			<td width="150"><font style="font-weight: bold;">货物名称</font></td>
			<td width="200"><font style="font-weight: bold;">客户名称</font></td>
			<td width="100"><font style="font-weight: bold;">送货位置</font></td>
			<td width="100"><font style="font-weight: bold;">数量合计</font></td>
			<td width="100"><font style="font-weight: bold;">被损数量</font></td>
			<td width="100"><font style="font-weight: bold;">备注</font></td>

		</tr>
	    <c:forEach items="${requestScope.printFormList }" var="stocklist">
				<tr>
					<td>${stocklist.outstockform_date}</td>
					<td>${stocklist.goods_number}</td>
					<td>${stocklist.goods_name}</td>
					<td>${stocklist.customer_name}</td>
					<td>${stocklist.location_name}</td>
					<td>${stocklist.outstock_count2+stocklist.outstock_count1}</td>
					<td>${stocklist.outstockplancontent_damage}</td>
					<td width="100"></td>
				</tr>
        </c:forEach>
		<tr>
			<td colspan="8">出库操作员 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 库管
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收货人：</td>

		</tr>
	</table>

	------------------------------------------------------------------------------------------------------------------------

	<table border="1" style="border-collapse: collapse; font-size: 9px">
		<tr height="10">
			<td colspan="5" align="center"><font size="5"
				style="font-weight: bold;">天津天物金佰出库单</font></td>
			<td colspan="3"><font size="5" style="font-weight: bold;">车辆：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：</font>
			</td>
			<td rowspan="1111111" width="70">第二联 财务留存</td>
		</tr>
		<tr bgcolor="#C0C0C0">
			<td width="100"><font style="font-weight: bold;"> 日期 </font></td>
			<td width="100"><font style="font-weight: bold;">货物编号</font></td>
			<td width="150"><font style="font-weight: bold;">货物名称</font></td>
			<td width="200"><font style="font-weight: bold;">客户名称</font></td>
			<td width="100"><font style="font-weight: bold;">送货位置</font></td>
			<td width="100"><font style="font-weight: bold;">数量合计</font></td>
			<td width="100"><font style="font-weight: bold;">被损数量</font></td>
			<td width="100"><font style="font-weight: bold;">备注</font></td>

		</tr>
        <c:forEach items="${requestScope.printFormList }" var="stocklist">
				<tr>
					<td>${stocklist.outstockform_date}</td>
					<td>${stocklist.goods_number}</td>
					<td>${stocklist.goods_name}</td>
					<td>${stocklist.customer_name}</td>
					<td>${stocklist.location_name}</td>
					<td>${stocklist.outstock_count2+stocklist.outstock_count1}</td>
					<td>${stocklist.outstockplancontent_damage}</td>
					<td width="100"></td>
				</tr>
        </c:forEach>
		<tr>
			<td colspan="8">出库操作员 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 库管
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收货人：</td>

		</tr>
	</table>

		------------------------------------------------------------------------------------------------------------------------
	<table border="1" style="border-collapse: collapse; font-size: 9px">
		<tr height="10">
			<td colspan="5" align="center"><font size="5"
				style="font-weight: bold;">天津天物金佰出库单</font></td>
			<td colspan="3"><font size="5" style="font-weight: bold;">车辆：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：</font>
			</td>
			<td rowspan="1111111" width="70">第三联 统计留存</td>
		</tr>
		<tr bgcolor="#C0C0C0">
			<td width="100"><font style="font-weight: bold;"> 日期 </font></td>
			<td width="100"><font style="font-weight: bold;">货物编号</font></td>
			<td width="150"><font style="font-weight: bold;">货物名称</font></td>
			<td width="200"><font style="font-weight: bold;">客户名称</font></td>
			<td width="100"><font style="font-weight: bold;">送货位置</font></td>
			<td width="100"><font style="font-weight: bold;">数量合计</font></td>
			<td width="100"><font style="font-weight: bold;">被损数量</font></td>
			<td width="100"><font style="font-weight: bold;">备注</font></td>

		</tr>
	    <c:forEach items="${requestScope.printFormList }" var="stocklist">
				<tr>
					<td>${stocklist.outstockform_date}</td>
					<td>${stocklist.goods_number}</td>
					<td>${stocklist.goods_name}</td>
					<td>${stocklist.customer_name}</td>
					<td>${stocklist.location_name}</td>
					<td>${stocklist.outstock_count2+stocklist.outstock_count1}</td>
					<td>${stocklist.outstockplancontent_damage}</td>
					<td width="100"></td>
				</tr>
        </c:forEach>
		<tr>
			<td colspan="8">出库操作员 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 库管
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;收货人：</td>

		</tr>
	</table>
		------------------------------------------------------------------------------------------------------------------------
	<!--endprint-->
</body>
</html>