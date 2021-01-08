
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>REST</title>
</head>
<script src="./static/jquery-3.2.1.min.js"></script>
<script>

</script>
<body>
<a href="Rest/emps">LIST</a>
<br>
<a href="Rest/emp" >ADD</a>
<br>
<a  id="testJson（resp）" href="Rest/testJson">testJson</a>


<br>

<form action="Rest/testJson2" method="get">
   userName <input type="text" name="UserName"> <br>
    <input type="submit" value="SUBMIT">
</form>



<%--HttpMessageCon--%>
<%--<form action="Rest/testJson" enctype="multipart/form-data" method="post">--%>
<%--    File:<input type="file" name="file">--%>
<%--    DESc:<input type="text" name="desc">--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
文件上传
<form action="Rest/CommonsMultipartResolver"  method="post"  enctype="multipart/form-data">
    File:<input type="file" name="file">
    DESc:<input type="text" name="desc">
    <input type="submit" value="提交">
</form>

</body>
<script>

    $(function () {
        $("#testJson").click(function () {
            $.ajax({
                url:"Rest/testJson",
                method:"POST",

            })
               return false;
        })
    })
</script>
</html>
