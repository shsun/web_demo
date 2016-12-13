  	                     <%@page language="java" pageEncoding="UTF-8" %><%@include file="taglib.jsp" %>
  	                       <div class="timebox" style="width: 860px;">
    							<div class="title"><strong>选择时间</strong></div>
							   	<div>开始时间:<input class="easyui-datebox"><span class="lspan10">结束时间:</span><input class="easyui-datebox"></input>
							   	 <span class="lspan10"><input class="c_checkbox" type="checkbox" /><span class="lspan3">明细</span>
							   	 <span class="lspan10"></span>
							   	 </span>
							   	</div>
  							</div>
  							<div class="timebox" style="width: 860px;">
    							<div class="title"><strong><strong>选择省份/城市</strong></strong></div>
								<div class="cityspanarea" style="margin-top: 3px;">
								  <span class="checked"  name="citySpan" checked="false" onclick="javascript:radiochange(this);" > 省份</span> 
							      <span class="unchecked" name="citySpan" checked="false" onclick="javascript:radiochange(this);" >省份+城市</span>
								</div>
								<div>
									<img style="cursor : pointer;" src="${path}/images/application_form_add.png">
								</div>
  							</div>
  							<div class="timebox" style="width: 860px;">
    							<div class="title"><strong><strong>选择频道/二级频道</strong></strong></div>
								<div class="cityspanarea" style="margin-top: 3px;">
								  <span class="checked"  name="citySpan" checked="false" onclick="javascript:radiochange(this);" > 频道</span> 
							      <span class="unchecked" name="citySpan" checked="false" onclick="javascript:radiochange(this);" >频道+二级频道</span>
								</div>
								<div>
									<img style="cursor : pointer;" src="${path}/images/application_form_add.png">
								</div>
  							</div>