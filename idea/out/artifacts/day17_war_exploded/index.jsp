<%@ page contentType="text/html;charset=UTF-8" errorPage="500.jsp" language="java" buffer="16kb" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--jsp脚本--%>
  <%-- 1.<%代码%>：被转换后放在配置文件的service里面，也就是说service能干什么，它就能干什么--%>
  <%
    String contextPath = request.getContextPath();
    out.print(contextPath);
  %>
  <%-- 2.<%!代码%>:定义java代码，在jsp转后的java类的成员位置，定义的成员变量，成员方法--%>
  <%!
    int i=3;
  %>
  <%-- 3.<%=%>代码%>:定义的java代码，可以输出到页面是，输出语句能干什么，它就能干什么--%>
  <%="hello,dd"%>
  <%    response.getWriter().write("response...");
  %>
  <h1>hello</h1>
  </body>
</html>
