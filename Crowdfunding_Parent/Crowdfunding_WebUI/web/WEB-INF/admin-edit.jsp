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
<%@include file="include-head.jsp" %>
<body>
<%@include file="include-nav.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@include file="include-setbar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <ol class="breadcrumb">
                    <li><a href="Admin/getPageInfo.html" >首页</a></li>
                    <li><a href="Admin/login.html" >数据列表</a></li>
                    <li class="active">更新</li>
                </ol>
                <div class="panel panel-default">
                    <div class="panel-heading">表单数据<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
                    <div class="panel-body">
                        <form action="Admin/update.html" role="form" method="post">
                            <input type="hidden" name="id" value="${param.id}">
                            <input type="hidden" name="keyWord" value="${param.keyWord}">
                            <input type="hidden" name="pageNum" value="${param.pageNum}">
                            <div class="form-group">
                                <label for="loginAcct">登陆账号</label>
                                <input type="text" class="form-control" name="loginAcct" id="loginAcct" value="${admin.loginAcct}">
                                <p>${requestScope.exception.message}</p>
                            </div>
                            <div class="form-group">
                                <label for="userPswd">用户密码</label>
                                <input type="text" class="form-control" name="userPswd" id="userPswd" placeholder="请输入用户名称">
                                <p>${requestScope.exception.message}</p>
                            </div>
                            <div class="form-group">
                                <label for="userName">用户名</label>
                                <input type="text" class="form-control" name="userName" id="userName" value="${admin.userName}">
                                <p>${requestScope.exception.message}</p>
                            </div>
                            <div class="form-group">
                                <label for="email">邮箱地址</label>
                                <input type="email" class="form-control" name="email" id="email" value="${admin.email}">
                                <p class="help-block label label-warning">请输入合法的邮箱地址, 格式为： xxxx@xxxx.com</p>
                                <p>${requestScope.exception.message}</p>
                            </div>
                            <button type="submit" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                            <button type="reset" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
