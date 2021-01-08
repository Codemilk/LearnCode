<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="UTF-8">
<%@include file="include-head.jsp" %>
<%--引入Ztree--%>
<link rel="stylesheet" href="static/ztree/zTreeStyle.css">
<script src="static/ztree/jquery.ztree.all-3.5.min.js"></script>
<script src="static/Myjs/my-menu.js"></script>
<script type="text/javascript" >
    $(function (){

    //    1.创建JSON对象用于存储对xTree所做的设置
        var settings = {
            view:{

                "addDiyDom":myAddDiyDom,
                "removeHoverDom":myRemoveHoverDom,
                "addHoverDom":myAddHoverDom
            },
            data:{
                key:{
                    //给所有的组件的超链接设置随机url，使组件不会跳转
                    url:"hehe"
                }
            }
        }

    //    准备Json数据，数据来源是Ajax请求得到
        generateTree(settings)


        $("#treeDemo").on("click",".deleBtn",function (){
            //准备id
            window.id= this.id
            //展示模态框
            $("#menuConfirmModal").modal('show')

            //通过查看文档可知，$.fn.zTree.getZTreeObj(”html中zTree的最终父标签“)获取zTreeObj对象
            var zTreeObj=$.fn.zTree.getZTreeObj("treeDemo")

            var key="id"

            var value=window.id

            var currentNode=zTreeObj.getNodeByParam(key,value)

            $("#removeNodeSpan").text(currentNode.name)

            return false;

        })

        $("#confirmBtn").click(function (){

            $.ajax({
                url:"Menu/delMenu.json",
                type:"POST",
                data:{
                 "id":window.id
                },
                success:function () {
                    $("#menuConfirmModal").modal('hide')

                    generateTree(settings)
                }
            })
        })

        /**更新*/
        $("#treeDemo").on("click",".editBtn",function (){
          //zTree可以直接通过节点属性来获取其他属性，所以知道当前节点的id就可以了
            window.id= this.id

            $("#menuEditModal").modal('show')

            //回显数据

            //通过查看文档可知，$.fn.zTree.getZTreeObj(”html中zTree的最终父标签“)获取zTreeObj对象
            var zTreeObj=$.fn.zTree.getZTreeObj("treeDemo")

            var key="id"

            var value=window.id

            //根据id通过zTree当前节点查询属性
            var currentNode=zTreeObj.getNodeByParam(key,value)

            //回显
            $("#menuEditModal [name=name]").val(currentNode.name)
            $("#menuEditModal [name=url]").val(currentNode.url)
            //radio回显的本质是value属性与回显的节点对应的value( 不一定是value例如我这里就是icon)一样
            //具体做法就是把icon放入数组中

            $("#menuEditModal  [name=icon]").val([currentNode.icon])


            return false;
        })

        $("#menuEditBtn").click(function () {

            //  选定图标
            var MenuFunction=$(".modal-body :checked").val()
            //  选定名称
            var MenuName=$("#menuEditModal [name=name]").val()
            //  选定url
            var MenuUrl=$("#menuEditModal [name=url]").val()


            $.ajax({
                url:"Menu/updateMenu.json",
                data: {
                    //后端的数据更新使用updateSelective
                    "id": window.id,
                    "name":MenuName,
                    "url":MenuUrl,
                    "icon":MenuFunction,
                },
                type:"POST",
                datatype:"JSON",
                success:function (response) {
                    console.log(response)
                    // layer.msg(response.staus)
                    //重新生成树形结构
                    generateTree(settings)

                },
                error:function (response){
                    // layer.msg(response.staus)
                }

            })

            $("#menuEditModal").modal('hide')

        })


        /**保存*/
    //    给节点按钮 添加按钮绑定事件
        $("#treeDemo").on("click",".addBtn",function (){

            // 加入节点后要分配节点,所以要加入对应的父id，也就当前节点的id
               window.menuPid=this.id

            // alert(window.menuPid)
              $("#menuAddModal").modal('show')
            //return false 为了防止他乱跑，测试方便



            return false;
        })

        //保存按钮添加单击事件
        $("#menuSaveBtn").click(function (){

          //  选定图标
          var MenuFunction=$(".modal-body :checked").val()
          //  选定名称
          var MenuName=$("#menuAddModal [name=name]").val()
          //  选定url
          var MenuUrl=$("#menuAddModal [name=url]").val()


            $.ajax({
               url:"Menu/saveMenu.json",
               data: {
                  "name":MenuName,
                  "pid":window.menuPid,
                  "url":MenuUrl,
                  "icon":MenuFunction
               },
                type:"POST",
                datatype:"json",
                success:function (response) {

                   console.log(response)
                    //重新生成树形结构
                    generateTree(settings)
                   // layer.msg(response.staus)
                },
                error:function (response){
                   layer.msg(response.staus)
                }

            })

            $("#menuAddModal").modal('hide')



            //清空表单
            $("#menuResetBtn").click()

        })

        /**   2.准备生成属性结构的JSON数据
        var zNodes =[
            { name:"父节点1 - 展开", open:true,
                children: [
                    { name:"父节点11 - 折叠",
                        children: [
                            { name:"叶子节点111"},
                            { name:"叶子节点112"},
                            { name:"叶子节点113"},
                            { name:"叶子节点114"}
                        ]},
                    { name:"父节点12 - 折叠",
                        children: [
                            { name:"叶子节点121"},
                            { name:"叶子节点122"},
                            { name:"叶子节点123"},
                            { name:"叶子节点124"}
                        ]},
                    { name:"父节点13 - 没有子节点", isParent:true}
                ]},
            { name:"父节点2 - 折叠",
                children: [
                    { name:"父节点21 - 展开", open:true,
                        children: [
                            { name:"叶子节点211"},
                            { name:"叶子节点212"},
                            { name:"叶子节点213"},
                            { name:"叶子节点214"}
                        ]},
                    { name:"父节点22 - 折叠",
                        children: [
                            { name:"叶子节点221"},
                            { name:"叶子节点222"},
                            { name:"叶子节点223"},
                            { name:"叶子节点224"}
                        ]},
                    { name:"父节点23 - 折叠",
                        children: [
                            { name:"叶子节点231"},
                            { name:"叶子节点232"},
                            { name:"叶子节点233"},
                            { name:"叶子节点234"}
                        ]}
                ]},
            { name:"父节点3 - 没有子节点", isParent:true}

        ];
     */

    })
</script>
<body>
<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-setbar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="panel panel-default">
                <div class="panel-heading"><i class="glyphicon glyphicon-th-list"></i> 权限菜单列表
                    <div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i
                            class="glyphicon glyphicon-question-sign"></i></div>
                </div>
                <div class="panel-body">
                    <ul id="treeDemo" class="ztree">
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="modal-menu-add.jsp"%>
<%@include file="modal-menu-edit.jsp"%>
<%@include file="modal-menu-confirm.jsp"%>
</body>
</html>
