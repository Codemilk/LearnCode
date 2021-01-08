
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <!DOCTYPE html>
    <html lang="UTF-8">
    <%@include file="include-head.jsp" %>
<%--    引入自定义script文件--%>
    <script type="text/javascript" src="static/Myjs/my-role.js"></script>
    <script>
        $(function (){
            //建立window全局变量
            window.pageNum=1
            window.keyWord=""
            window.pageSize=5
            //刷新页面
            generate()

            //关键字查询
            $("#searchBykeyWord").click(function (){
                //获取keyWord的内容，并赋给window.keyWord
                window.keyWord=$("#keyWord").val()
                alert(window.keyWord)
                //刷新页面
                generate()
            })

            /** 用户添加 */
            //点击打开模态框
            $("#addRegisterBth").click(function (){
                $('#MyModal').modal('show')
            })


            $("#MyModalSave").click(function (){

                //获取表单数据，
                var RoleName=$("#RoleName").val()

                alert(RoleName)
                $.ajax({
                    url : "Role/addRole.json",
                    data : {
                        "RoleName" : RoleName
                    },
                    type : "POST",
                    datatype: "JSON",
                    async : false,
                    success : function (response){
                       var result=response.result

                        if(result=="SUCCESS"){
                            layer.msg("操作成功")
                        }
                        //重新加载分页数据
                        //设置最大页数
                        window.pageNum = 695418
                        generate()
                    },
                    error : function (response){
                        var result=response.result

                        if(result=="FAILSE"){
                            layer.msg("操作失败")
                        }
                    }
                 })
                //关闭模态框
                $('#MyModal').modal('hide')
                //刷新输入栏，方便下次操作
                $("#keyWord").val(" ")
            })


            //在页面上的铅笔绑定单机响应函数，目的是打开模态框
            //传统的事件绑定方式只能在第一个页面有效，翻页后失效
            // $(".pencil-btn").click(function (){
            //
            //     alert($("#editBtn").attr(id))
            //
            //     $('#MyModalUpdate').modal('show')
            //
            // })

            /** 更新操作 */
            // 使用Jquery的on函数解决这个问题
            // 首先找到所有动态生成的元素所依附的静态元素，例如role内容依附的静态元素时tbody
               /*
               *  on函数参数：
               *           1.事件类型
               *           2.真正要绑定的事件的元素的选择器
               *           3.响应函数
               * */
            $("#RoleBody").on("click",".pencil-btn",function (){
                // this表示当前按钮，按钮的父组件是<td>
                // prev():用来上一个同级元素
                // 获取当前属性的name
                window.roleName= $(this).parent().prev().text()

                // 获取id
                window.roleId= $(".pencil-btn").attr("id")
                // 值的回显
                $('#MyModalUpdate #RoleName').val(window.roleName)
                // 打开模态框
                $('#MyModalUpdate').modal('show')

            });

            $("#MyModalupdateBtn").click(function (){

              var rolename=  $('#MyModalUpdate #RoleName').val()


                $.ajax({
                    url : "Role/updateRole.json",
                    type: "POST",
                    data : {
                            "name" : rolename,
                            "id" :  window.roleId
                           },
                    datatype: "JSON",
                    success:function (resp){
                        //加载数据
                        // console.log(resp)
                        //关闭模态框
                        $('#MyModalUpdate').modal('hide')
                        //清空数据
                        $('#MyModalUpdate #RoleName').val("")
                        //更新页面
                        generate()

                    }
                })           })

            /**删除操作*/
            $("#deleteModalBtn").click(function (){

                  //将JSON数组中转换为json数据

                var requestBody=JSON.stringify(window.roleIdArray)

                layer.msg(requestBody)

                  $.ajax({
                      url:"Role/deleteRole.json",
                      data:requestBody,
                      datatype:"json",
                      contentType: "application/json;charset=UTF-8",
                      type: "POST",
                      success:function (resp){
                          //加载数据
                          // console.log(resp)
                          //关闭模态框
                          $('#MyModalDelete').modal('hide')
                          //更新页面
                          generate()
                      },
                      error : function (response) {

                              layer.msg("操作失败")

                      }

                  })
            })
                //单例删除
                $("#RoleBody").on("click",".removeBtn",function (){

                    // this表示当前按钮，按钮的父组件是<td>
                    // prev():用来上一个同级元素
                    // 获取当前属性的name
                    window.roleName= $(this).parent().prev().text()

                    // 获取id
                    window.roleId= $(".removeBtn").attr("id")

                    var roleArray=[{
                        roleId:window.roleId,
                        roleName:window.roleName
                    }]

                    layer.msg(roleArray.length)
                    confirmModalAlert(roleArray)

                });
                //全选或者全部选删除
                $("#summaryBox").click(function (){

                     //获取单个选择
                    var checkBoxStatus=this.checked;



                    $(".itemCheckBox").prop("checked",checkBoxStatus)
                })

            //全选或全不选的优化
            $("#RoleBody").on("click",".itemCheckBox",function (){

              // 选择的checkBox
              var itemCheckBoxNum=$(".itemCheckBoxc:checked").length
              //所有的checkBox
              var totalCheckBox=$(".itemCheckBox").length

                //进行判定，倘若达到相等，那么所有的都会被选中
                $("#summaryBox").prop("checked",itemCheckBoxNum==totalCheckBox)

            });

            $("#deleteBtn").click(function (){

                var  roleArray=[]
                //遍历素有的被选中的CheckBox
                $(".itemCheckBox:checked").each(function (){

                    var roleName=$(this).parent().next().text()
                    var roleId = this.id

                    roleArray.push({
                        roleId:roleId,
                        roleName:roleName

                    })
                })


                confirmModalAlert(roleArray)

                // generate()

            })


            //给分配权限按钮绑定单机函数
            $("#RoleBody").on("click",".checkBtn",function (){
                //打开模态框
                $("#assignModal").modal('show')

                /*因为roleId在前面获取role的时候已经将id赋给每个按钮了,
                 在My-role.js下的FillBody()所以,再这里直接可以获取this.id,
                 顺便将id赋给全局变量,方便后边使用*/
                window.roleID=this.id

                // alert(window.roleID)
                //在模态框中转载书Auth的树形结构图
                fillAuthTree();

                //14.给分配权限模态框中的“分配”按钮绑定单机响应

                $("#assignBtn").click(function () {

                    //建立authid数组
                    var authIdArray=[]
                 //   获取zTreeObj对象
                 var zTreeObj=$.fn.zTree.getZTreeObj("authTreeDemo")
                 //  获取全部被勾选的节点
                 var checkedNodes=zTreeObj.getCheckedNodes()

                   // 依次加入每个节点的id
                   for(var i=0;i<checkedNodes.length;i++){
                     authIdArray.push(checkedNodes[i].id)
                   }


                   var requestbody={
                        "authIdArray":authIdArray,
                            "rolesId":[window.roleID]
                    }
                  var requestBody=JSON.stringify(requestbody)
                   $.ajax({
                       url:"Assign/saveAuth.json",
                       type:"POST",
                       data:requestBody,
                       contentType:"application/json;charset=UTF-8",
                       datatype:"json",
                       async:false,
                       success:function (resp){
                           $("#assignModal").modal('hide')
                           layer.msg("操作成功")
                       },
                       error:function (resp){
                           layer.msg("操作失败")
                       }
                   })
                })

            })

        })
    </script>
    <body>
    <%@include file="include-nav.jsp" %>
    <div class="container-fluid">
        <div class="row">
            <%@include file="include-setbar.jsp" %>
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-inline" role="form" style="float:left;">
                            <div class="form-group has-feedback">
                                <div class="input-group">
                                    <div class="input-group-addon">查询条件</div>
                                    <input class="form-control has-success" id="keyWord" type="text" placeholder="请输入查询条件">
                                </div>
                            </div>
                            <button type="button" id="searchBykeyWord" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                        </form>
                        <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;" id="deleteBtn"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
                        <button type="button" class="btn btn-primary" style="float:right;" id="addRegisterBth"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                        <br>
                        <hr style="clear:both;">
                        <div class="table-responsive">
                            <table class="table  table-bordered">
                                <thead>
                                <tr >
                                    <th width="30">#</th>
                                    <th width="30"><input id="summaryBox" type="checkbox"></th>
                                    <th>名称</th>
                                    <th width="100">操作</th>
                                </tr>
                                </thead>
                                <tbody id="RoleBody">
                                </tbody>
                                <tfoot>
                                <tr >
                                    <td colspan="6" align="center">
                                        <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>
                                    </td>
                                </tr>
                                </tfoot>
                            </table >
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%--引入功能页面--%>
    <%@include file="model-Role-add.jsp"%>
    <%@include file="model-Role-update.jsp"%>
    <%@include file="model-Role-delete.jsp"%>
    <%@include file="modal-role-assign-auth.jsp"%>
    </body>
    </html>
