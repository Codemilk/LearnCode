 <%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/5/18
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!-- Bootstrap -->
<link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
<script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
<![endif]-->

<%--
     推荐的web路径查找方法：
                         /项目名表示当前路径
                         可以用这个方法表示
                         <%
                            request.setAttribute("app_Path",request.getContextPath());
                         %>
                           <script src="${app_Path}}/static/jquery-3.2.1.min.js"></script>


--%>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="./static/jquery-3.2.1.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="./static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<head>
    <title>Title</title>
</head>
<body>
<!-- Modal:模态框，员工添加表-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="emp_table">

                    <div class="form-group">
                        <label for="empName" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="empName" id="empName" placeholder="***">
                            <span  class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" id="email" placeholder="***@**.com">
                            <span  class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" name="gender" id="genderM" value="M"> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="inlineRadioOptions" name="gender" id="genderF" value="F"> 女
                        </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">部门</label>
                        <div class="col-sm-10">
<%--                             部门，提交ID即可--%>
                            <select class="form-control" name="dId" id="deptId_deptName"></select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save">保存</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal:模态框，员工修改表-->
<div class="modal fade" id="empUpdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" method="post" id="emp_update_table">
                    <div class="form-group">
                        <label for="emp_updateName" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="emp_updateName"></p>
                            <span  class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="_updateemail" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" id="_updateemail" placeholder="***@**.com">
                            <span  class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" name="gender" id="_updategenderM" value="M"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" name="gender" id="_updategenderF" value="F"> 女
                            </label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">部门</label>
                        <div class="col-sm-10">
                            <%--                             部门，提交ID即可--%>
                            <select class="form-control" name="dId" id="deptId_update_deptName"></select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_updateName_save">更新</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <%--           标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>

    <%--按钮--%>
    <div class="row">
        <div  class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary btn-lg" id="emp_add_model">创建</button>
            <button type="button" class="btn btn-danger btn-lg" id="emp_deleteAll_model">删除</button>
        </div>
    </div>
    <%--表格行数--%>
    <div class="row">
        <div class="col-md-12">
            <table class=" table table-hover" id="emps_table">
                <thead>
                <tr>
                    <th><input type="checkbox" id="checkAll"></th>
                    <th>#</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>email</th>
                    <th>deptName</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>

                </tbody>
            </table>
        </div>
    </div>
    <%--分页--%>
    <div class="row">
<%--        分页信息 --%>
        <div class="col-md-6" id="Paging_information"></div>
<%--    分页条--%>
        <div class="col-md-6" id="Pagination_column"></div>
    </div>


</div>
<script>
    //1.页面加载完成以后，直接放松一个ajax请求，要到分页数据
    $(function () {

        //定义当前页面
        var currentPage;
        //去首页
        to_page(1)

       //跳转页面
        function to_page(pn) {
            $.ajax({
                url:"emps",
                data:"pn="+pn,
                type:"get",
                // 请求成功,返回result
                success:function (result) {
                    //1.拿到数据，在表格显示员工数据

                    build_emps_table(result);

                    //2.解析并显示分页信息

                    build_page_info(result)

                    // 3.解析显示分页条

                    build_page_nav(result)

                }
            })
        }


        function build_emps_table(result) {

            //要清空数据，否则页面不刷新，会一直覆盖
            $("#emps_table tbody").empty()

              var emps=result.extend.pageInfo.list;

              $.each(emps,function (index, item) {
                  var checkbox=$("<td><input type='checkbox' class='checkItem'></td>").attr("delID",item.empId)
                  var empIdTd=$("<td></td>").append(item.empId)
                  var empIdName=$("<td></td>").append(item.empName)
                  var empgender=$("<td></td>").append(item.gender=="M"?"男":"女")
                  var email=$("<td></td>").append(item.email)
                  var deptName=$("<td></td>").append(item.department.deptName)
                  var editButton=$("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>").addClass("glyphicon glyphicon-pencil btn-xs")).append("编辑").attr("edit_id",item.empId)
                  var deleteButton=$("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon glyphicon-trash btn-xs")).append("删除").attr("edit_id",item.empId)



                  //append方法执行完成以后返回原来的元素，所以可以连续使用
                  $("<tr></tr>").
                  append(checkbox).
                  append(empIdTd).
                  append(empIdName).
                  append(empgender).
                  append(email).
                  append(deptName).
                  append(editButton).
                  append(deleteButton).
                  appendTo("#emps_table tbody")

               });
        }

        //解析显示分页信息
        function build_page_info(result
        ) {
            $("#Paging_information").empty()

            $("#Paging_information").append("当前第"+result.extend.pageInfo.pageNum+"页，总"+result.extend.pageInfo.pages+"页，一共有"+result.extend.pageInfo.total+"条记录")
            currentPage=result.extend.pageInfo.pageNum

        }


        //解析显示分页条
        function build_page_nav(result
        ) {
            $("#Pagination_column").empty()

            //分别创建
            var ul = $("<ul></ul>").addClass("pagination")
            var firstLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"))
            var endLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"))
            var PrePage = $("<li></li>").append($("<a></a>").append("<<").attr("href", "#"))
            var nextPage = $("<li></li>").append($("<a></a>").append(">>").attr("href", "#"))
            //分布加入

            //设置跳转
            firstLi.click(function () {
                to_page(1)
            })

            ul.append(firstLi)

            //设置如果上一页,或下一页没有东西，不可使用
                if(result.extend.pageInfo.hasPreviousPage){
                    PrePage.click(function () {
                        to_page(result.extend.pageInfo.pageNum-1)
                    })
                    ul.append(PrePage)
                 }
            //index表示角标，item表示对应单个的结果集
            $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
                //表示选中状态
                   var liNum=$("<li></li>").append($("<a></a>").append(item).attr("href","#"))
                if(item==result.extend.pageInfo.pageNum){
                    liNum.addClass("active")
               }
                liNum.click(function () {

                    to_page(item)

                })
                ul.append(liNum)


            })

            if(result.extend.pageInfo.hasNextPage==true){
                 nextPage.click(function () {
                     to_page(result.extend.pageInfo.pageNum+1)
                 })
                ul.append(nextPage)

                }

            endLi.click(function () {
                to_page(result.extend.pageInfo.pages)
            })

            ul.append(endLi)

           var nav= $("<nav></nav>").append(ul)
            nav.appendTo("#Pagination_column")
        }

            //点击创建按钮，弹出模态框吗，
            $("#emp_add_model").click(function () {
                //发送ajax请求，得到部门信息,建立方法
                getDeptS("#deptId_deptName")
                // 弹出模态框
                $('#myModal').modal({
                    keyboard :true
                })

            })

        function getDeptS(ele) {

            $(ele).empty()
            $.ajax({
                url:"depts",
                type: "get",
                success:function (result) {
                    // 1.遍历部门信息
                    $.each(result.extend.depts,function (index,item) {
                        //显示部门信息在下拉列表中
                              var optionDept=$("<option></option>").append(item.deptName).attr("value",item.deptId)

                             $(ele).append(optionDept)
                    })
                }

            })
        }

        // 表单重置方法
        function resetForm(Xform){

            Xform[0].reset();
            //情况样式
            Xform.find("*").removeClass("has-error has-success")
            Xform.find(".help-block").text("")

        }
        //为模态框表单保存按钮，设置提交时间
        $("#emp_save").click(function () {


            //1.模态框中填写的表单数据提交给服务器进行保存
            //校验数据是否合法

            if(!validate_add_form()){
                 return false
            }

            //校验用户名是否重复，若果成功了会进行
            if($(this).attr("ajax_p")=="error"){
                return  false
            }

               $.ajax({
                   url:"emp",
                   type:"POST",
                       //serialize()这个方法是将表单要提交的数据转化为字符串
                   data:$("#emp_table").serialize(),
                   success:function (result) {
                       //测试是否成功
                       // alert(result.msg)
                      /*如果成功：1.关闭模态框
                                 2.转发到最后一页查看是否成功
                       */


                      if(result.code==100){

                          // 表示成功,我们才关闭模态框
                          $("#myModal").modal("hide")

                          //之前配置的mybatis pagehelper的属性reasonable 页面合理化
                          //在弹出模态框，要刷新模态框

                          to_page(9999)

                      }else{

                          // 表示失败
                          alert("服务器检测"+result.extend.fieldErrors)

                      }
                       //清除表单数据（表单完整重置，表单的数据，表单的样式）

                       // resetForm($("#myModal form"))
                   }
                  })

        })
        //刷新数据,验证数据信息
    function validate_add_form(){
        //拿到数据,通过正则表达式
        // 验证empName
         var empName=$("#empName").val();
         var regName=/(^[A-Za-z0-9]{6,16}$)|(^[\u2E80-\u9FFF]{2,5}$)/;
         if(!regName.test(empName)){
             // alert("名字必须是2-5个中文或者6-16位英文数字组合")
             //数据校验错误，提供特效
             show_validate_msg("#empName","error","名字必须是2-5个中文或者6-16位英文数字组合")
             return false
         }else{
             show_validate_msg("#empName","success",null)
         }


         //验证email
         var email=$("#email").val();
         var regemail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
         if(!regemail.test(email)){

             show_validate_msg("#email","error","邮箱格式不正确")

             return false
           }else{
             show_validate_msg("#email","success",null)

         }
         return true
       }

       function show_validate_msg(ele,status,msg) {
            //防止组件的状态叠加，无论成功与否，我们都应该刷新
           $(ele).parent().removeClass("has-error has-success")
           $(ele).next("span").text("")
            if("error"==status){
                $(ele).parent().addClass("has-error")
                $(ele).next("span").text(msg)
            }else{
                $(ele).parent().addClass("has-success")
                $(ele).next("span").text(msg)
            }
       }

       //查询是否重复
       $("#empName").change(function () {
           //向数据库发送ajax请求是否可用

           $.ajax({
               url:"checkUser",
               data:"empName="+this.value,
               type:"get",
               success:function (result){
                  if(result.code==100){
                     //成功
                        show_validate_msg("#empName","success","姓名可用")
                        //如果成功，会提交
                        $("#emp_save").attr("ajax_p","success")
                  }else{
                     //失败
                     //为了合法字符和用户名重复同样适用，
                        show_validate_msg("#empName","error",result.extend.Valid_msg)
                        $("#emp_save").attr("ajax_p","error")

                  }
               }
           })
       })
        //直接拿拿不到的，因为按钮也是ajax请求完事之后获得的，先执行JS绑定代码，在发送ajax
        //解决办法：1.可以在创建的时候绑定事件 2.可以使用live()(无论当前元素时什么时候传进来的)绑定，但是现在不行了，被他淘汰了
        //         2.可是使用on方法进行替代，可以指定某个元素的子元素指定事件
        //
        $(document).on("click",".edit_btn",function () {

            //查出员工信息，显示员工信息

            //1.弹出模态框，查出部门信息，查出员工信息
            // 弹出模态框
            getDeptS("#deptId_update_deptName")

            // alert()
            getEmp($(this).attr("edit_id"))


            //为了修改，将id传给模态框的更新按钮
            $("#emp_updateName_save").attr("edit_id",$(this).attr("edit_id"))
            $('#empUpdate').modal({
                keyboard :true
            })

        })
        //查找emp，id通过前面单位emp表单刷新时，给按钮设置值
         function getEmp(id) {
             $('#emp_updateName ').empty()
             $.ajax(
                 {
                     url:"getEmp/"+id,
                     type:"get",
                     success:function (result) {
                              console.log(result)
/*
                         alert(result.extend.email)
*/
                         $("#emp_updateName").append(result.extend.emp.empName)
                         $("#_updateemail").val(result.extend.emp.email)

                         // var emp_updateName=$("#emp_updateName").append(result.extend.empName)
                         $("#empUpdate input[name=gender]").val([result.extend.emp.gender])


                         $("#empUpdate select").val[result.extend.emp.dId]

                     }
                 }
             )
         }
         //点击更新，更新员工
        $("#emp_updateName_save").click(
            function () {
                //先验证是否合法
                //验证email

                // var email=$("#_updateemail").val();
                // var regemail=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
                // if(!regemail.test(email)){
                //     show_validate_msg("#_updateemail","error","邮箱格式不正确")
                //     return false
                // }else{
                //     show_validate_msg("#_updateemail","success",null)
                //
                // }
                $.ajax({
                    data:$("#empUpdate form").serialize()+"&_method=PUT",
                    url:"emp/"+$(this).attr("edit_id"),
                    type:"POST",
                    success:function (result) {
                     //1.关闭模态框
                        $("#empUpdate").modal('hide')

                        to_page(currentPage)
                    }})
            }
        )

        $(document).on("click",".delete_btn",function () {
               //1.弹出是否弹出确认框
           var empName=$(this).parents("tr").find("td:eq(2)").text()
            if(confirm("确认删除"+empName+"吗？")){
                //确定删除
                $.ajax({
                    url:"emp/"+$(this).attr("edit_id"),
                    // data:"&_method=DELETE",
                    type:"DELETE",
                    success:function (result) {
                        to_page(currentPage)
                        confirm("删除成功")
                    }
                })
            }
        })
        $("#checkAll").click(function () {
            //dom原生属性通过prop获取，attr获取自定义属性
            $(".checkItem").prop("checked",$(this).prop("checked"))
        })

        $(document).on("click",".checkItem",function () {
            //判断当前选择的元素是否五个,.checkItem:checked表示被选中的状态个数
            var flag=$(".checkItem:checked" ).length==$(".checkItem").length
           $("#checkAll").prop("checked",flag)
        })

        $("#emp_deleteAll_model").click(
               function () {
                   //
                   var empNames="";
                   var dels="";
                   $.each($(".checkItem:checked"),function (index,item) {
                      empNames+=$(this).parents("tr").find("td:eq(2)").text()+","
                       dels+=$(item).parents("tr").find("td:eq(1)").text()+"-"

                   })
                   // 去掉字符串多余的东西
                    empNames=empNames.substring(0,empNames.length-1)
                   dels=dels.substring(0,dels.length-1)
                   if(confirm("是否删除"+empNames+"这些信息")){
                       $.ajax({
                           url:"emp/"+dels,
                           type:"delete",
                            success:function (result) {
                                // if(result.Msg.code==100){
                                    alert("删除成功")
                                // }
                                to_page(currentPage)
                            }
                       })
                   }
               }
        )

    })
</script>

</body>
</html>
