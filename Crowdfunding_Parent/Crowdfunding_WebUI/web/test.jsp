<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/10/9
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="UTF-8">
<script src="static/Jquery/jquery-3.3.1.min.js"></script>
<script>
    $(function (){
        $("#async").click(function (){

            //函数进入，执行
            console.log("ajax之前")
            // ajax请求
            $.ajax({
                url: "test/ajax/async.html",
                type: "post",
                dataType:"text",
                async:false,//关闭异步模型，使用同步方式工作
                //success只会在服务器响应后执行
                success:function (resp){
                    console.log("ajxa内部")
                }
            })
            //普通请求，在你的ajax执行之后，执行
            console.log("ajax之后")

        //    可以通过jQuery的方法，执行延后,这也证明了，ajax的success和普通的函数方法确实不在同一个线程上
        //     setTimeout(function () {
        //         console.log("ajax之后")
        //     },6000)
        })
    })

</script>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
             <button id="async">button</button>
        </div>
    </div>
</div>

</body>
</html>
