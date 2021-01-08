    <%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/9/29
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="static/Jquery/jquery-3.3.1.min.js" ></script>
<script type="text/javascript" src="static/layer/layer.js"></script>
<html>
<%--base标签：
<base> 标签为页面上的所有链接规定默认地址或默认目标。

通常情况下，浏览器会从当前文档的 URL 中提取相应的元素来填写相对 URL 中的空白

使用 <base> 标签可以改变这一点。浏览器随后将不再使用当前文档的 URL，而使用指定的基本 URL 来解析所有的相对 URL。这其中包括 <a>、<img>、<link>、<form> 标签中的 URL。--%>
<%--尽量这样写因为他是动态的，注意${pageContext.request.contextPath}本身带有/所以提前去掉，后面的/要留着--%>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<script>



    // 加载
    $(function () {
<%--Layer弹窗测试--%>

        $("#btn_Layer").click(function () {

            layer.msg("layer弹窗成功")

        })

        //测试异常处理器
        $("#btn3").click(function () {
            // 创建Json对象
            var student={
                // private Integer stuId;
                // private String strName;
                // private Address address;
                // private List<Subject> SubjectList;
                // private Map<String,String> map;
                "stuId":"1",
                "strName":"LiSi",
                "address":{
                    // private String province;
                    // private String city;
                    // private String street;
                    "province":"Guangdong",
                    "city":"Wuhu",
                    "street":"facai"},
                "SubjectList":[{
                    // private String subjectName;
                    // private Integer subjectNumber;
                    "subjectName":"Math",
                    'subjectNumber':1
                },{
                    // private String subjectName;
                    // private Integer subjectNumber;
                    "subjectName":"Chinese",
                    'subjectNumber':0
                }],
                "map":{
                    "k1":"1k",
                    "k2":"2k"
                }

            }

            var student = JSON.stringify(student);

            $.ajax({
                url:"test/ExceptionHandler.json",
                type:"POST",
                data:student,
                contentType:"application/json;charset=UTF-8",
                dateType:"JSON",
                success:function (param) {
                    alert(param)
                },
                error:function (param) {
                    alert(param)
                }
            })
        })

        //传入json形式的复杂对象
        $("#btn2").click(function () {
            // 创建Json对象
            var student={
            // private Integer stuId;
            // private String strName;
            // private Address address;
            // private List<Subject> SubjectList;
            // private Map<String,String> map;
                "stuId":"1",
                "strName":"LiSi",
                "address":{
                    // private String province;
                    // private String city;
                    // private String street;
                       "province":"Guangdong",
                       "city":"Wuhu",
                       "street":"facai"},
                "SubjectList":[{
                    // private String subjectName;
                    // private Integer subjectNumber;
                    "subjectName":"Math",
                    'subjectNumber':1
                },{
                    // private String subjectName;
                    // private Integer subjectNumber;
                    "subjectName":"Chinese",
                    'subjectNumber':0
                }],
                "map":{
                    "k1":"1k",
                    "k2":"2k"
                }

        }

        var student = JSON.stringify(student);

        $.ajax({
            url:"test/testConfuseJson.json",
            type:"POST",
            data:student,
            contentType:"application/json;charset=UTF-8",
            dateType:"JSON",
            success:function (param) {
                alert(param)
            },
            error:function (param) {
                alert(param)
            }
        })
        })
        // 传入json形式的数组
        $("#btn1").click(function () {
            <%--
                注意当你当然可以使用$.post() $.get()，但是$.post() $.get()这两个都是服务器成功处理之后，响应状态码必须是200才可以执行回调函数
                $.ajax()不管响应状态码是多少，都可处理
             --%>
            // 第二种方法
            // json数组
            var array=[6,9,5,4,1,8,7,4,6]

            // 将json数组转换为json字符串
            //注意无论是json数组还是对象都要像这样转换为字符串
            var requestBody = JSON.stringify(array);
            // json对象
            var obj={"name":"tom","age":12}
                             $.ajax({
                                 url:"test/testJson.html",      //请求地址
                                 type:"POST",                    //请求方式
                                 // 第一种方案：将@requestBody下入value="arrat[]"
                                 // data: {"array":[6,9,5,4,1,8,7,4,6]},      //要发送的请求参数
                                 // 第二种方案
                                 //必须设置contentType，告诉服务器发给我的数据类型化
                                 data: requestBody,      //要发送的请求参数
                                 contentType:"application/json;charset=UTF-8",
                                 datatype:"text",               //如何对待服务器返回的数据
                                 success:function (param) {      //服务器成功处理参数返后调用的回调函数，param是服务器返回参数
                                     alert(param)
                                 },
                                 error:function (param) {        //服务器失败处理参数返后调用的回调函数，param是服务器返回参数
                                     alert(param)
                                 }

                             })
                         })
                     })
                 </script>
                 <head>
                     <title>Title</title>
                 </head>
                 <body>
                 <%--${pageContext.request.contextPath}/--%>
<%--如果不写拓展名，dispatchservlet不回去拦截，直接访问tomcat有没有此文件
    一般来说应该写的,但是我们的tomcat路径设置的就是http://localhost:8080/Crowdfunding/
--%>
<%--记住 请求的uil不可以有/开头，例如：/test/ssm.html, 这样就不参考base标签了--%>
<a href="test/ssm.html">TestSSM</a>
<br>

<button id="btn1">Send [5,8,13] array</button>
<br>


<button id="btn2">Send Confuse Json</button>
<br><br>
<button id="btn3">Test ExceptionHandler</button>
<br><br>
<button id="btn_Layer">layer 弹窗测试</button>

<br>
<a href="UserTalk.html">userTalk</a>
</body>
</html>
