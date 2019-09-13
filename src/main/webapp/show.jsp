<%--
  Created by IntelliJ IDEA.
  User: 预见
  Date: 2018-11-22
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String aname=(String)application.getAttribute("name");
    String sname=(String)session.getAttribute("name");
    String rname=(String)request.getAttribute("name");

%>
application：<%=aname%>
<br>
session:<%=sname%>
<br>
request:<%=rname%>
</body>
</html>
