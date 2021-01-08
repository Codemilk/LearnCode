 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/login.css">
    <script src="static/Jquery/jquery-3.3.1.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<script>



    $(function () {
        $("#btn").click(function () {
            //相当于浏览器的后退按钮
            window.location.href="/login.html"
        })
    })
</script>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">

    <h2 class="form-signin-heading"><i class="glyphicon glyphicon-log-in" style="text-align: center"></i> 尚筹网系统消息</h2>
    <%--        表示req.getattribute("ex").getmessage--%>
    <h3>${requestScope.exception.message}</h3>

    <button id="btn" class="btn btn-l btn-success btn-block">点我回到上一步 </button>
</div>

</body>
</html>