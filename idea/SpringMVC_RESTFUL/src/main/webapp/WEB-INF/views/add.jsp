<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=GBK" isELIgnored="false" language="java" %>
<%--SpringMVC表单标签--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

       <form action="testConversionService" method="post">
<%--           LastName-email-gender-department.id 例如:GG-gg@qq.com-0-105--%>
           employee: <input type="text" name="employee">

            <input value="提交" type="submit">
       </form>


<%--1.谁用SpringMVCform标签的原因
        1.因为标签可以更快开发出表单页面
        2.可以更方便表单回显
    2.注意：
      可以通过modelAttribute属性指定绑定的模型属性，若没有指定该属性，则默认从request域对象中读取command的表单bean
--%>


  <form:form action="${pageContext.request.contextPath}/emp" method="post"
             modelAttribute="employee">


      <%--      Path属性就是html标签里的name--%>
     <c:if test="${employee.id==null}">
      LastName:<form:input path="lastName" ></form:input>
         <form:errors path="lastName"></form:errors>
         <br>

     </c:if>

      <c:if test="${employee.id!=null}">
<%--           对于_method不能使用form:hidden标签，因为modelAttribute对应的bean中没有_method这个属性--%>
           <form:hidden path="id"></form:hidden>
           <input type="hidden",name="_method" value="PUT">
      </c:if>
      <br>
      Email:<form:input path="email"></form:input>

      <form:errors path="email"></form:errors>
      <br>
      <%
          Map<String,String> genders=new HashMap<>();
          genders.put("1", "male");
          genders.put("0", "female");

          request.setAttribute("genders", genders);
      %>
      Gender:<form:radiobuttons path="gender" items="${genders}"></form:radiobuttons>
      <br>


      Department:<form:select path="department.id" itemLabel="departmentName" itemValue="id" items="${departments}"></form:select>
      <br>

      Birth:    <form:input path="birth"></form:input>

      <form:errors path="birth"></form:errors>
      <br>
      Salary:    <form:input path="salary"></form:input>
      <br>
     <%--因为表单输入是字符串，但目标类实体类型，是Date类型所以要：
                 1.数据类型转换
                 2.数据类型格式化
 ·               3.数据校验:
                     1.如何校验？注解？
                           1.使用JSR303验证标准
                           2.需要加入hibernate validator验证框架jar包
                           3.在SpringMVC配置文件中添加加入<mvc:annotation-driven>
                           4.需要在bean的属性上加入对应的注解
                           5.在目标方法bean类型的前面添加@Valid注解
                     2.验证出错转向到哪一个页面？

                     3.错误消息？如何显示，如何把错误消息进行国际化


     --%>
<%--      Birth:<form:input path="birth"></form:input>--%>
      <input type="submit" value="Submit">

  </form:form>


</body>
</html>
