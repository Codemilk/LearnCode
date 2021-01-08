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
    <script src="../../static/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="../../static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<head>
    <title>Title</title>
</head>
<body>

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
                <button type="button" class="btn btn-primary btn-sm">创建</button>
                <button type="button" class="btn btn-danger btn-sm">删除</button>
            </div>
        </div>
        <%--表格行数--%>
        <div class="row">
            <div class="col-md-12">
              <table class=" table table-hover">
                  <tr>
                      <th>#ID</th>
                      <th>Name</th>
                      <th>Gender</th>
                      <th>email</th>
                      <th>deptName</th>
                      <th>操作</th>
                  </tr>
                  <c:forEach items="${pageInfo.list}" var="emp">
                  <tr>
                      <th>${emp.empId}</th>
                      <th>${emp.empName}</th>
                      <th>${emp.gender==M?"男":"女"}</th>
                      <th>${emp.email}</th>
                      <th>${emp.department.deptName}</th>
                      <th>
                          <button class="btn btn-primary">
                              <span class="glyphicon glyphicon-pencil btn-xs" aria-hidden="true"> </span>
                              编辑</button>
                          <button class="btn btn-danger">
                              <span class="glyphicon glyphicon-trash btn-xs" aria-hidden="true"> </span>
                              删除</button>
                      </th>
                  </tr>
                  </c:forEach>
              </table>
            </div>
        </div>
        <%--分页--%>
        <div class="row">
            <div class="col-md-6">
                   当前第${requestScope.pageInfo.pageNum}页，总${pageInfo.pages}页，一共有${pageInfo.total}条记录
            </div>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">

                        <li><a href="emps?pn=1">首页</a></li>

                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li >
                                <a href="emps?pn=${pageNum-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>


                        <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                            <c:if test="${num==requestScope.pageInfo.pageNum}">
                                <li class="active"> <a href="emps?pn=${num}">${num}</a></li>
                            </c:if>
                            <c:if test="${num!=requestScope.pageInfo.pageNum}">
                                <li> <a href="emps?pn=${num}">${num}</a></li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <li><a  href="emps?pn=${pageInfo.pages}" >末页</a></li>

                    </ul>
                </nav>
            </div>
        </div>


     </div>


</body>
</html>
