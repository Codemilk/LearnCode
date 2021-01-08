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
<script>
      //定义方法
    function fun() {
        //发送异步请求
        //创建核心对象
        var xhttp;
        if (window.XMLHttpRequest) {
            xhttp = new XMLHttpRequest();
        } else {
            // code for IE6, IE5
            xhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

        //2.建立连接
        /*
           参数：
               1.请求方式：get，post
                         get:请求参数在url后边拼接，send方法为空参
                         post：请求参数在Send中定义
               2.请求url路径：
               3.同步或异步请求：async：true（异步）或 false（同步）

         */
        xhttp.open("GET", "ajaxServlet?username=tom", true);

        //3.发送请求
        xhttp.send();

        //4.接受并处理来自服务器的响应结果
        //获取方式：xmlHttp.responseText
        //什么时候获取？当服务器响应成功后在获取

        //当xmlhttp对象的准备状态改变时，会触发一个事件onreadystatechange
        xhttp.onreadystatechange=function()
        {
            //判断readyState是否为4（请求响应都已完成），再次判断status是否为200（成功）
            if (xhttp.readyState==4 && xhttp.status==200)
            {
               var res=xhttp.responseText;
               alert(res);
            }
        }

    }
</script>
<body>
      <input type="button" value="发送异步请求" onclick="fun()">

      <input>
</body>
</html>
