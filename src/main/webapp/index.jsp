<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html;charset=utf-8" language="java" %>
<html>
<body>
<h2>jsp示例</h2>
<%
    application.setAttribute("name","admin");
    application.setAttribute("list",new ArrayList());
    String obj=(String)application.getAttribute("name");
    List list=(List)application.getAttribute("list");

    session.setAttribute("name","zhangsan");
    String name=(String)session.getAttribute("name");

    request.getParameter("key");//这个是获得提交过来的参数
    request.setAttribute("name","李四");
    String name1=(String)request.getAttribute("name");
%>
</body>
</html>
