<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/4
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

success
<br>
testModelAndView:<h>${requestScope.get("time")}</h><br>

testMap<h>${requestScope.get("zj")}</h>

testSessionAttribute:  <br>
req:<h2>${requestScope.User}</h2>
session:<h2>${sessionScope.user}</h2><br>
testModelAttribute:<h2>${requestScope.user}</h2><br>
</body>
</html>
