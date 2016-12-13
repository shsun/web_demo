<%@ page pageEncoding="utf-8"%>
<%
String start = request.getParameter("start");
String limit = request.getParameter("limit");
String robj = request.getParameter("robj");
try {
    int index = Integer.parseInt(start);
    int pageSize = Integer.parseInt(limit);

    String json = "{totalProperty:100,root:[";
    for (int i = index; i < pageSize + index; i++) {
        json += "{id:" + i + ",name:'牙膏" + i + "',type:'国外" + "',web:'www.shsun.com"  + "',adtype:'商业"+ "',videoleng:'29分钟"+ "',time:'2013-03-23" +"',volume:'4G'}";
        if (i != pageSize + index - 1) {
            json += ",";
        }
    }
    json += "]}";
    System.out.println(json.toString());
    response.getWriter().write(json);
} catch(Exception ex) {
}
%>
