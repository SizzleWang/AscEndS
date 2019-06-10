<%--
  Created by IntelliJ IDEA.
  User: Chuan
  Date: 2018/10/17
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> ${title} </title>
    <%
        out.println("Your IP address is " + request.getRemoteAddr());
    %>
</head>
<body>

</body>
</html>
