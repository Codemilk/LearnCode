<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=GBK" isELIgnored="false" language="java" %>
<%--SpringMVC����ǩ--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

       <form action="testConversionService" method="post">
<%--           LastName-email-gender-department.id ����:GG-gg@qq.com-0-105--%>
           employee: <input type="text" name="employee">

            <input value="�ύ" type="submit">
       </form>


<%--1.˭��SpringMVCform��ǩ��ԭ��
        1.��Ϊ��ǩ���Ը��쿪������ҳ��
        2.���Ը����������
    2.ע�⣺
      ����ͨ��modelAttribute����ָ���󶨵�ģ�����ԣ���û��ָ�������ԣ���Ĭ�ϴ�request������ж�ȡcommand�ı�bean
--%>


  <form:form action="${pageContext.request.contextPath}/emp" method="post"
             modelAttribute="employee">


      <%--      Path���Ծ���html��ǩ���name--%>
     <c:if test="${employee.id==null}">
      LastName:<form:input path="lastName" ></form:input>
         <form:errors path="lastName"></form:errors>
         <br>

     </c:if>

      <c:if test="${employee.id!=null}">
<%--           ����_method����ʹ��form:hidden��ǩ����ΪmodelAttribute��Ӧ��bean��û��_method�������--%>
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
     <%--��Ϊ���������ַ�������Ŀ����ʵ�����ͣ���Date��������Ҫ��
                 1.��������ת��
                 2.�������͸�ʽ��
 ��               3.����У��:
                     1.���У�飿ע�⣿
                           1.ʹ��JSR303��֤��׼
                           2.��Ҫ����hibernate validator��֤���jar��
                           3.��SpringMVC�����ļ�����Ӽ���<mvc:annotation-driven>
                           4.��Ҫ��bean�������ϼ����Ӧ��ע��
                           5.��Ŀ�귽��bean���͵�ǰ�����@Validע��
                     2.��֤����ת����һ��ҳ�棿

                     3.������Ϣ�������ʾ����ΰѴ�����Ϣ���й��ʻ�


     --%>
<%--      Birth:<form:input path="birth"></form:input>--%>
      <input type="submit" value="Submit">

  </form:form>


</body>
</html>
