<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/19
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL4</title>
</head>
<body>

<%--这里是获取当前的request，并调用方法getcontextpath.只不过是EL表达式是属性--%>
<h1>在jsp页面动态获取虚拟目录</h1>
${pageContext.request.contextPath}

</body>
</html>
