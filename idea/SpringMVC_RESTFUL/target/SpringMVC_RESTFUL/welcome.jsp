<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
    <script type="text/javascript" src="webjars/jquery/3.4.1/jquery.min.js"></script>

    <script>

        $(function () {
            $("#testJson").click(function () {

                var url=this.href;
                var args={}
                $.post(url,args,function (data) {
                   for( var i=0;i<data.length;i++){
                             var id =data[i].id;
                             var lastname=data[i].lastName;

                             alert(id+":"+lastname)
                   }
                })
                return false;
            })
        })
    </script>


</head>
<body>

<a href="emps" >list of all employee</a>
<br><br>

<a href="testJson" id="testJson">Test Json</a>
</body>

<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
    File: <input type="file" name="file">
    Desc: <input type="text" name="desc">
    <input type="submit" value="Submit">
</form>

<a href="testResponseEntity" >testResponseEntity</a>

<%--关于国际化：
         1.在页面上能够根据浏览器语言设置的情况对文本（不是内容），时间，数值进行本地化处理
         2.可以在bean中获取国际化资源文件Locale对应的消息
         3.可以通过超链接切换Locale，而不依赖于浏览器的语言设置情况

    解决:
         1.使用JSTL的fmt标签
         2.在bean中注入ResouceBundleMessageSource的实例，使用其对应的getMessage方法即可
         3.配置LocalResolver和LocaleChangeInterceptor
--%>

<br>

<a href="i18n">I18N PAGE</a>
<br>

<a href="i18n?locale=zh_CH">中文</a>
<br>
<a href="i18n?locale=en_US">英文</a>
<br>

<form action="testFilerUpload" method="post" enctype="multipart/form-data">
    File: <input type="file" name="file">
    Desc: <input type="text" name="desc">
    <input type="submit" value="Submit">
</form>


<a href="testExceptionHandlerExceptionResolver?i=10">testExceptionHandlerExceptionResolver</a>
<br>
<a href="testStatusException?i=10"> testResponseStatusException</a>
<br>
<a href="testDefaultHandExceptionResolver">testDefaultHandExceptionResolver</a>
<br>

<a href="testSimpleMappingExceptionResolver?i=2">testSimpleMappingExceptionResolver</a>
<br>

</html>
