<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>


<head>
    <title>清单</title>
</head>
<body>
List
<c:if test="${empty requestScope.emps}">
    不好意思没有得到任何数据
</c:if>
<c:if test="${!empty requestScope.emps}">
    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>DepartName</th>
            <th>Gender</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        <c:forEach var="emp" items="${requestScope.emps}">
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
<script>
    // $(function () {
    //
    //     $.ajax({
    //             url:"Rest/emps",
    //             type:"GET",
    //             success:function (result) {
    //
    //             }
    //
    //     }
    //     )
    //     }
    // )
</script>
</body>
</html>
