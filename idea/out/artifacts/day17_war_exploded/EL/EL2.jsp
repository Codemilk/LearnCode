<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/19
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL2</title>
</head>
<body>
<%
    //存入数据
    request.setAttribute("rs", "这里是request.setAttribute");



    HttpSession session1 = request.getSession();
    session1.setAttribute("session1", "这里是session");

    ServletContext servletContext = request.getServletContext();
    servletContext.setAttribute("sc", "这里是servletContext");

//   使用${键名}，来查找name 会先找到request中的name
    request.setAttribute("name", "张三");
    request.getSession().setAttribute("name", "李四");


%>

${requestScope.rs}<br>
 ${sessionScope.session1}<br>
${applicationScope.sc}<br>
${name}
</body>
</html>
