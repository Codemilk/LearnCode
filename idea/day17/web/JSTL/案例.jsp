<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="userdao.userdao" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/28
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>案例</title>
</head>
<body>
<%
    List list =new ArrayList ();
    list.add(new userdao("张三", 16, new Date()));
    list.add(new userdao("李四", 12, new Date()));
    list.add(new userdao("王五", 33, new Date()));

    request.setAttribute("list",list);
%>

<table border="1" width="500" align="center">
    <tr>
        <th>
            编号
        </th>

        <th>
            姓名
        </th>

        <th>
            年龄
        </th>

        <th>
            生日
        </th>
        <c:forEach items="${list}" var="user" varStatus="s">

        <c:if test="${s.count%2==0}">

        <tr bgcolor="red">
            <td>${s.count}</td>
             <td>${user.name}</td>
            <td>${user.age}</td>
             <td>${user.bitStr}</td>
         </tr>
         </c:if>

    <c:if test="${s.count%2==1}">

        <tr bgcolor="green">
            <td>${s.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.bitStr}</td>
        </tr>
    </c:if>

</c:forEach>
    </tr>
</table>
</body>
</html>
