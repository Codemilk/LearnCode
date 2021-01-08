<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/2/16
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="js/jquery-3.3.1.min.js"></script>
<script>
     //1.基本格式
     var person={"name":"张三","age":13,"gender":true}
     // alert(person["gender"])

     //2.嵌套格式:[]嵌套{}
     var persons={
                  "persons":[
                             {"name":"张三","age":24,"gender":"男"},
                             {"name":"李四","age":14,"gender":"男"},
                             {"name":"王五","age":234,"gender":"男"}
                             ]
                 }
     // alert(persons.persons[1].name)
     //{}嵌套[]
     var ps=[{"name":"张三","age":24,"gender":"男"},
         {"name":"李四","age":14,"gender":"男"},
         {"name":"王五","age":234,"gender":"男"}]


     alert(ps[1].name)
    // alert(ps)
</script>
<body>

</body>
</html>
