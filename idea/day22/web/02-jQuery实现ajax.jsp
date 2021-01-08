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
          //使用$.ajax()发送异步
          $.ajax({
              url:"ajaxServlet",//请求路径
              type:"post",//请求方式
              // data:"username=jack&age=23",//请求参数
              data:{"username":"jack","age":23},

              success:function (data) {
                  //响应成功后执行这个函数
                  alert(data)
              },
              //如果请求响应出现错误，执行这个函数
              error:(function () {
                  alert("出错了")
              }),
              dataType:"text"//设置接收到的响应数据的格式
          })
      }
</script>
<body>
      <input type="button" value="发送异步请求" onclick="fun()">

      <input>
</body>
</html>
