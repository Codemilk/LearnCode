<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  USER.User: lenovo
  Date: 2019/12/10
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL</title>
</head>
<body>

    ${3>4}

    \${3>4}
<hr>
<h1>
    <%="算数运算符"%><br>
</h1>

        ${3+4}<br>
        ${3-4}<br>
        ${3*4}<br>
        ${3/4}<br>
        ${3 div 4}<br>
        ${3%4}<br>
        ${3 mod 4}<br>

<hr>
<h1>
    <%="比较运算符"%><br>
</h1>

    ${3==4}

    <hr>
    <h1>
        <%="逻辑运算符"%><br>
    </h1>

    ${3>4&&3<4}

    <hr>

<h1>空运算符empty</h1>

<%
    String str="abc";
    request.setAttribute("str", str);
    List list=new ArrayList();
    request.setAttribute("list", list);

%>

${ not empty str}
${ not empty flase}

</body>
</html>
