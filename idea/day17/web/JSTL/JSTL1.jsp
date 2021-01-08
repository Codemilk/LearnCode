<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>JSTL1</title>
</head>
<body>
<h1>if标签</h1>

<c:if test="true">
    <h1>我是你爸爸！！！！</h1>
</c:if>
<%--c:if标签--%>
<%--    1.属性：--%>
<%--       *test 必须属性，接受boolean表达式--%>
<%--             如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容--%>

<%
  //判断requers域中的一个list集合是否为空，如果不为null则显示遍历集合
    ArrayList List = new ArrayList();
//    List.add("giao");
    request.setAttribute("List", List);
    request.setAttribute("number", 3);
%>
   <C:if test="${ not empty requestScope.List}">
       <h1>遍历集合....</h1>
   </C:if>

   <c:if test="${requestScope.number %2 !=0}">
       ${number}为奇数
   </c:if>


</body>
</html>
