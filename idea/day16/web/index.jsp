<%@ page contentType="text/html;charset=GBK" language="java" %>
<
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<%--jsp脚本--%>
<%-- 1.<%代码%>：被转换后放在配置文件的service里面，也就是说service能干什么，它就能干什么

--%>
     <%
         System.out.println("我是java代码");
     %>
<%-- 2.<%!代码%>:

--%>
    <%!
        int i=3;
    %>


   <h1>hello</h1>
  </body>
</html>
