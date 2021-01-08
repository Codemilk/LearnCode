<%--
  Created by IntelliJ IDEA.
  USER.User: lenovo
  Date: 2019/12/1
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload=function (ev) {
                document.getElementById("img").onclick=function (ev1) {
                       var time = new Date().getTime();
                       this.src="/day17/checkResponseDemo?time="+time;
                }
         }
    </script>
</head>

<body>
<form action="/day17/loginServlet" method="post">
    <table>
       <tr>
           <td>用户名</td>
           <td><input type="text" name="username"></td>
       </tr>

        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>

        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkcode"></td>
        </tr>

        <tr>
           <td ><img src="/day17/checkResponseDemo" id="img"></td>
        </tr>

        <tr>
            <td>
                <input value="登录" type="submit">
            </td>
        </tr>
    </table>
</form>
<%--有数据显示无数据不显示--%>
${requestScope.loginerror}

${requestScope.error}

</body>
</html>
