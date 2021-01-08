<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/17
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="HelloWorld">HelloWorld</a>
<br>
<br>

<a href="SpringMvc/SpringTest1">类路径测试</a>
<br>
<br>

<a href="SpringMvc/method">HelloWorld</a>
<br>
<br>

<a href="SpringMvc/paramTest?username=guigu&age=100">TestParam</a>
<br>
<br>

<a href="SpringMvc/AntTest/mn/ant">AntTest</a>
<br>
<br>

<a href="SpringMvc/testPathVariable/1">PathVariableTest</a>
<br>
<br>

Rest获取方式的测试
<a href="SpringMvc/testRest/1">testRest Get</a>
<br>
<br>

<form action="SpringMvc/testRest" method="post">
    <input type="submit" value="TestRest POST">
</form>
<br>
<br>

<form action="SpringMvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="TestRest DELETE">
</form>
<br>
<br>

<form action="SpringMvc/testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="TestRest put">
</form>
<br>
<br>

映射请求参数
<a href="SpringMvc/RequestParam?username=murder">RequestParamTest</a>
<br>
<br>

映射请求头
<a href="SpringMvc/RequestHeader">RequestParamTest</a>
<br>
<br>

映射请求Cookie
<a href="SpringMvc/CookieTest">CookieTest</a>
<br>
<br>

给pojo对象自动赋值
<form action="SpringMvc/autoPojo"  >
    username: <input type="text" name="username">
    <br>
    password: <input type="password" name="password">
    <br>
    email：<input type="text" name="email" >
    <br>
    age: <input  type="text" name="age">
    <br>
    city:<input type="text" name="address.city">
    <br>
    province:<input type="text" name="address.province">

    <input type="submit" value="提交">

</form>
<br>
<br>

获取ServletApi以及其他的一些组件
<a href="SpringMvc/testServlet">testServlet</a>
<br>
<br>

测试处理数据模型M&&C
model和view
<a href="SpringMvc/TestModelAndView">TestModelAndView</a>
<br>
<br>

map和model
<a href="SpringMvc/testMap">testMap</a>
<br>
<br>

Session
<a href="SpringMvc/testSessionAttributes">testMap</a>
<br>
<br>

ModelAttribute
模拟修改数据：
       1.原始数据为：1，tom，123456，tom@com.com,12
       2.密码不可修改
       3.表单回显，模拟操作直接在表单填写对应属性值
<form  action="SpringMvc/ModelAttribute" method="post">
     <input type="hidden" name="id" value="1">
    username <input  type="text" value="Tom"  name="username" ><br>
    email <input  type="text" value="695418746@qq.ocm"  name="email" ><br>
    age <input  type="text" value="18"  name="age" ><br>
    <input type="submit" value="Submit">

</form>
<br>
<br>
测试视图解析器
<a href="SpringMvc/testViewAndViewResolver" >testViewAndViewResolver</a>
<br>
<br>

自定义视图解析器
<a href="SpringMvc/testView" >testView</a>
<br>
<br>

重定向
<a href="SpringMvc/testRedirect" >testRedirect</a>
<br>
<br>

</body>
</html>
