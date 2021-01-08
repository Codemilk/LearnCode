<%@ page import="userdao.userdao" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/19
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL3</title>
</head>
<body>
<%
    userdao user=new userdao();
    user.setAge(23);
    user.setName("赵四");
    user.setBirthday(new Date());
    request.setAttribute("user", user);

    List list=new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list", list);

    Map map=new HashMap();
    map.put("name", "giao哥");
    map.put("gender", "男");
    map.put("user", user);
    request.setAttribute("map", map);


%>

${requestScope.user.name}<br>
${requestScope.user.age}<br>
${requestScope.user.birthday.year}<br>
${requestScope.user.bitStr}<br>
<hr color="blue">

${requestScope.list}<br>
${requestScope.list [0]}<br>
${list [1]}<br>
${list [100086]}<br>
${requestScope.list[2].name}<br>

<hr>
${requestScope.map.name}<br>
${requestScope.map.user.name}
</body>
</html>
