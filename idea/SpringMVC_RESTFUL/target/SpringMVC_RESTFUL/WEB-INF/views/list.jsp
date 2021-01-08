
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>


    <title>Title</title>
    <script type="text/javascript" src="webjars/jquery/3.4.1/jquery.js"></script>

    <script>
        $(function () {
            $(".delete").click(function () {
                var href=$(this).attr("href");
                $("form").attr("action",href).submit()
                return false;
            })

        })
    </script>
</head>
<body>

<%--1.问题原因：
             SpringMVC处理静态资源，dispatcherServlet会拦截所有的需求，css，js，jquery...都会被拦截，且没有对应的解析器，也就无法映射到响应url
    2.解决方法：在SpringMVC的配置文件中配置<mvc:default-servlet-handler>
    3.

--%>


    <form action=""  method="post">
        <input type="hidden" name="_method" value="DELETE">
    </form>
<c:if test="${empty requestScope.employees}">
    sorry 没有您所需要的数据
</c:if>

<c:if test="${not empty requestScope.employees}">

    <table>
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="emp" items="${requestScope.employees}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender==0?"female":"male"}</td>
                <td>${emp.department.departmentName}</td>
                <td><a class="delete" href="emp/${emp.id} ">删除</a></td>
                <td><a href="emp/${emp.id}">更新</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>

<br>
<a href="emp" >add method </a>
</body>

</html>
