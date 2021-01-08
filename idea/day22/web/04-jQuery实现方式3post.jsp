<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/16
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
      function fun() {
        $.post("ajaxServlet",{username:"rose"},function (data) {
                alert(data)
        },"text")
      }
</script>
<body>
      <input type="button" value="发送异步请求" onclick="fun()">

      <input>
</body>
</html>
