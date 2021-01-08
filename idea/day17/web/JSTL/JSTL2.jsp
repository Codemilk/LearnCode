 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
<head>
    <title>JSTL1-Choose</title>
</head>
<body>
<%--    完成数字编号对应星期几的案例
          1.域中储存数字
          2.使用choose标签取出数字            相当于switcch声明
          3.使用when标签做数字判断            相当于case
          4.使用otherwise标签做其他情况的什么 相当于default
--%>

  <%
      request.setAttribute("number", 3);
  %>
 <c:choose>
     <c:when test="${number==1}"><h1>礼拜一</h1></c:when>
     <c:when test="${number==2}"><h1>礼拜二</c:when>
     <c:when test="${number==3}"><h1>礼拜三</c:when>
     <c:when test="${number==4}"><h1>礼拜四</c:when>
     <c:when test="${number==5}"><h1>礼拜五</c:when>
     <c:when test="${number==6}"><h1>礼拜六</c:when>
     <c:when test="${number==7}"><h1>礼拜日</c:when>
     <c:otherwise><h1>数字有误</c:otherwise>
 </c:choose>
</body>
</html>
