<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
<head>
    <title>JSTL1-foreach</title>
</head>
<body>
<%--  foreach:相当于java代码的for语句
       1.完成重复的操作
          属性：
              begin：开始值
              end：结束值
              var：临时变量
              step：步长
              varStatis:循环状态对象
                     index:容器中元素的索引，从0开始
                     count：循环次数，从1开始
       2.遍历容器
         List <User> list
        for(User user: list){

        }
        属性：
            items:容器对象
            var：容器中元素的临时变量
--%>
<%
    ArrayList arrayList = new ArrayList();
    arrayList.add("aaa");
    arrayList.add("bbb");
    arrayList.add("ccc");
   request.setAttribute("list", arrayList);
%>
<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
     ${i} ${s.index} ${s.count} <br>

</c:forEach>

<c:forEach items="${list}"  var="c" varStatus="s">
    ${s.index} ${s.count} ${c}
</c:forEach>
</body>
</html>
