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

     var person={"name":"张三","age":13,"gender":true}

     var ps=[{"name":"张三","age":24,"gender":"男"},
         {"name":"李四","age":14,"gender":"男"},
         {"name":"王五","age":234,"gender":"男"}]

     //获取person对象中所有的键和值
     //  for(var key in person){
     //      //这样的方式获取不行因为相当于  person."name"
     //      // alert(key+":"+person.key)
     //      alert(key+":"+person[key])
     //  }
    //获取ps中的所有的键和值
    // for(var key in ps){
    //     for(var key1 in ps[key]){
    //         alert(ps[key][key1])
    //     }
    // }
       for(var i=0;i<ps.length;i++){
           var p=ps[i];
           for(key in p){
               alert(p[key])
           }
       }
</script>
<body>

</body>
</html>
