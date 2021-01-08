<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/11/25
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<head>
    <meta charset="utf-8">
    <title>记事本</title>
    <style type="text/css">
        *{margin:0; padding:0;}
        body,input{font-size:14px; line-height:24px; color:#333; font-family:Microsoft yahei, Song, Arial, Helvetica, Tahoma, Geneva;}
        h1{margin-bottom:15px; height:100px; line-height:100px; text-align:center; font-size:24px; color:#fff; background:black;}
        #content #post,#comment p{zoom:1;}
        #content #post:after,#comment p:after{display:block; height:0; clear:both; visibility:hidden; overflow:hidden; content:'.';}
        .transition{-webkit-transition:all 0.5s linear; -moz-transition:all 0.5s linear; -o-transition:all 0.5s linear; -ms-transition:all 0.5s linear; transition:all 0.5s linear;}
        #content{margin:0 auto; width:960px; overflow:hidden;}
        #content #post{margin-bottom:15px; padding-bottom:15px; border-bottom:1px #d4d4d4 dashed;
            height: 556px;
        }
        #content #post textarea{display:block; margin-bottom:10px; padding:5px; width:948px; height:390px; border:1px #d1d1d1 solid; border-radius:5px; resize:none; outline:none;}
        #content #post textarea:hover{border:1px #9bdf70 solid; background:#f0fbeb;}
        #content #post #postBt,#content #post #clearBt{margin-left:5px; padding:3px; float:right;}
        #comment{overflow:hidden;}
        #comment p{margin-bottom:10px; padding:10px; border-radius:5px;}
        #comment p:nth-child(odd){border:1px solid #e3e197; background:#ffd;}
        #comment p:nth-child(even){border:1px solid #adcd3c; background:#f2fddb;}
        /*#comment p span{display:inline; float:left;}*/
        #comment p .right{text-align:right;}
        #comment p .msg{width:738px;}
        #comment p .datetime{width:200px; color:#999; text-align:right;}
        .footc{
            background-color: #F3D5ED;
            display: flex;
            justify-content: center;
        }
        a{
            text-decoration: none
        }
        .pagination{
            letter-spacing: 3px;
        }
        tfoot{
            display: flex;
            justify-content: space-between;
        }

    </style>
    <script src="static/Jquery/jquery-3.3.1.min.js"></script>
    <script src="static/Jquery/jquery.pagination.js"></script>
    <script type="text/javascript">
        // $(function (){
        //     $("#postBt").click(function (){
        //         // alert("dsd")
        //         var text=$("#textAreas").val()
        //
        //         // var text = window.textArea
        //         alert(text)
        //
        //         $.ajax({
        //             url: "Role/getRoles.json",
        //             // data:{
        //             //     "textArea":text
        //             // },
        //             method:"POST",
        //             dataType:"JSON",
        //             success:function (data){
        //
        //                 console.log(data)
        //
        //             }
        //         })
        //     })
        // })

        $(function () {

            window.pageInfo=null;
                    $.ajax({
                        url: "Role/getRoles.json",
                        // data:{
                        //     "textArea":text
                        // },
                        method:"POST",
                        dataType:"JSON",
                        contentType: "application/json;charset=UTF-8",
                        // async:false,
                        success:function (res){

                            //加载导航条

                            //总记录数
                            console.log(res)
                            let totalRecord=res.data.total

                            console.log(totalRecord)
                            // alert(totalRecord)
                            //声明一个JSON对象存储Pagination要设置的属性
                            var properties={
                                num_edge_entries: 3,                            //边缘页数
                                num_display_entries: 5,                         //主体页数
                                items_per_page:res.data.pageSize,// 每页显示1项
                                callback: pageselectCallback,                   //回调函数
                                current_page:res.data.pageNum-1,//因为Pagination这个组件索引是从0开始的，所以我们要减一
                                prev_text: "上一页",                             //上一页文本显示的文本
                                next_text: "下一页",
                            };

                            $("#Pagination").pagination(totalRecord,properties);
                        }
                    })
            // initPagination();


        })
        //生成页码导航条的函数
        // function initPagination() {
        //
        // }
        //回调函数的含义：声明以后不是自己调用，而是交个系统或者框架调用
        //用户点击“上一页，下一页，1,2,3”这样的页码是调用这个函数实现页面跳转
        //PageIndex时候Pageination传给我们那个“从零开始”的页码

        function pageselectCallback(pageIndex,jquery) {

            //根据pageIndex计算得到的PageNum
            var pageNum=pageIndex+1;

            //跳转页面
            window.location.href="Admin/getPageInfo.html?pageNum="+pageNum+"&keyWord=${param.keyWord}";

            //    由于每个页码按钮都是超链接，所以在这个函数最后取消超链接的默认行为
            return false
        }
    </script>

</head>

<body>
<h1>留言板</h1>
<div  id="content">
    <div id="post">
        <div style="background:#3EADC5 ;height:30px;">
            昵称：<input type="submit" id="shangtian" name="Submit3" style="border:none; background-color:#3EADC5; color:white;" value="默认用户点击改变" onclick="prom()" />
            <input type="text" id="ritian" style="border:none; background-color:#3EADC5; color:white;"   onclick="prom()"/>
            <!--disabled="disabled"-->
        </div>
        <div>
            <textarea class="transition" id="textAreas"></textarea>
        </div>
        <input id="postBt" type="button" style="border:none; background-color:#3EADC5; color:white;border-radius:5px; width:80px; height:30px;" value="发表留言"/>
        <input id="clearBt" type="button" style="border:none; background-color:#3EADC5; color:white;border-radius:5px; width:80px; height:30px;" value="清空"/>
    </div >
    <div class="footc">    <table >
        <tfoot>
        <tr >
            <td colspan="6" align="center">
                <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>

            </td>
        </tr>
        </tfoot>
    </table></div>

    <div id="comment"></div>

</div>


</body>
</html>