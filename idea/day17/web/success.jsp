<%--
  Created by IntelliJ IDEA.
  USER.User: lenovo
  Date: 2019/12/1
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>

<body>
<h1>欢迎您<%=request.getSession().getAttribute("user")%></h1>
</body>
</html>
