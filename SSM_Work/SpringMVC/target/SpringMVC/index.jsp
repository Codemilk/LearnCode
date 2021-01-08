<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/8/4
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="Recover/hello">hello</a>
<br>
PathVariable
<a href="Recover/PathVariable/4">PathVariable</a>
<br>

REST

<br>
<a href="Recover/testRest/1">GET:获取</a>
<br>

POST:新增
<form method="post" action="Recover/testRest">
    <input type="submit" value="提交">
</form>
<br>

PUT：更新<form action="Recover/testRest/2" METHOD="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="提交">
        </form>
<br>
DELETE：删除<form  action="Recover/testRest/3" METHOD="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="提交">
           </form>


<br>

RequestParam
<form method="post" action="Recover/RequestParam">
    <input type="text" name="id">
    <input type="submit">
</form>
<br>

RequestHeader
<a href="Recover/RequestHeader">RequestHeader</a>
<br>

CookieValue
<a href="Recover/CookieValue">CookieValue</a>
<br>
POJO
<form action="Recover/testPOJO">
    name<input type="text" name="name"> <br>
    gender<input type="text" name="gender"> <br>
    email<input type="text" name="email"><br>
    city<input type="text" name="address.city"><br>
    province<input type="text" name="address.province"> <br>
    <input type="submit" value="提交"> <br>
</form>
<br>
servletAPI
<a href="Recover/testServletAPI">servletAPI</a>
<br>
testModelAndView
<a href="Recover/testModelAndView">testModelAndView</a>
<br>
testMap
<a href="Recover/testMap">testMap</a>
<br>
testSessionAttribute
<a href="Recover/testSessionAttribute">testSessionAttribute</a>
<br>
testModelAttribute
<%--模拟修改数据：密码不可以被修改--%>
<form action="testModelAttribute">
    ID:<input type="text" name="id" value="1"><br>
    UserName:<input type="text" name="userName" value="tom"><br>
    age <input type="text" name="age" value="13"><br>
    Email:<input type="email" name="email" value="666@qq.com"><br>
    <input type="submit" value="提交">
</form>
<br>

testViewAndViewResolver
<a href="testViewAndViewResolver">testViewAndViewResolver</a><br>

testJSTL<br>
<fmt:bundle basename="i18n">
    <fmt:message key="i18n.username"></fmt:message><br>
    <fmt:message key="i18n.password"></fmt:message><br>
</fmt:bundle>
<br>

testMvc-view-controller
<a href="success">testMvc-view-controller</a> <br>
HelloView
<a href="testHelloView" >testHelloView</a> <br>
testRedirect
<a href="testRedirect">testRedirect</a>
<br>
Rest
<a href="Rest/emps">LIST</a>
testInterceptor
<a href="testInterceptor">testInterceptor</a> <br>>

testHandlerExceptionResolver
<a href="testHandlerExceptionResolver?i=0">testHandlerExceptionResolver</a>
</body>
</html>
