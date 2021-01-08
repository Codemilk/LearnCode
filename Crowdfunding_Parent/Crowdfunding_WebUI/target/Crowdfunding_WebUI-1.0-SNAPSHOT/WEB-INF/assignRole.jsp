<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/10/9
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="UTF-8">
<%@include file="include-head.jsp" %>
<script type="text/javascript">
    $(function (){

         $("#toRightButton").click(function () {
             // select:eq(0)>表示第一个select标签，>option:selected表示子元素(标签)选中的
             $("select:eq(0)>option:selected").appendTo("select:eq(1)")

         })

        $("#toLeftButton").click(function () {
            // select:eq(0)>表示第一个select标签，>option:selected表示子元素(标签)选中的
            $("select:eq(1)>option:selected").appendTo("select:eq(0)")

        })

        //表单提交按钮设定单击函数,是选择结果全部选中
        $("#submitButton").click(function (){
            $("select:eq(1)>option").prop("selected","selected")
            //测试结果，暂时不让表单提交返回false
            // return false;
        })

    })
</script>
<body>
<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-setbar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="#">首页</a></li>
                <li><a href="#">数据列表</a></li>
                <li class="active">分配角色</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-body">
                    <form action="Assign/assign.html" method="post"  class="form-inline">
                        <input type="hidden" name="adminId" value="${param.id}">
                        <input type="hidden" name="pageNum" value="${param.pageNum}">
                        <input type="hidden" name="keyWord" value="${param.keyWord}">
                        <div class="form-group">
                            <label>未分配角色列表</label><br>
                            <select class="form-control" multiple size="10" style="width:100px;overflow-y:auto;">
                            <c:forEach items="${unAssignRole}" var="uaRole">
                                <option value="${uaRole.id}">${uaRole.name}</option>
                            </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <ul>
                                <li id="toRightButton" class="btn btn-default glyphicon glyphicon-chevron-right"></li>
                                <br>
                                <li id="toLeftButton" class="btn btn-default glyphicon glyphicon-chevron-left" style="margin-top:20px;"></li>
                            </ul>
                        </div>
                        <div class="form-group" style="margin-left:40px;">
                            <label>已分配角色列表</label><br>
                            <select name="roleIdList" class="form-control" multiple size="10" style="width:100px;overflow-y:auto;">
                                <c:forEach items="${AssignRole}" var="aRole">
                                    <option value="${aRole.id}">${aRole.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <button type="submit" id="submitButton" class="btn btn-lg btn-success ">提交保存</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
