<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script>
    $(function () {


        //加载导航条
        initPagination();
    })
    //生成页码导航条的函数
    function initPagination() {
        //总记录数
        var totalRecord=${requestScope.PageInfo.total}
        //声明一个JSON对象存储Pagination要设置的属性
        var properties={
            num_edge_entries: 3,                            //边缘页数
            num_display_entries: 5,                         //主体页数
            items_per_page:${requestScope.PageInfo.pageSize},// 每页显示1项
            callback: pageselectCallback,                   //回调函数
            current_page:${requestScope.PageInfo.pageNum-1},//因为Pagination这个组件索引是从0开始的，所以我们要减一
            prev_text: "上一页",                             //上一页文本显示的文本
            next_text: "下一页",
        };



        $("#Pagination").pagination(totalRecord,properties);
    }
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
<div class="container-fluid">
    <div class="row">
        <%@include file="include-setbar.jsp" %>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" action="Admin/getPageInfo.html" method="post" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input class="form-control has-success" name="keyWord" type="text" placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="submit" class="btn btn-warning"><i class="glyphicon glyphicon-search"></i> 查询</button>
                    </form>
                    <button type="button"  class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>
<%--                旧代码
                    button type="button" class="btn btn-primary" style="float:right;" onclick="window.location.href='add.html'"><i class="glyphicon glyphicon-plus"></i> 新增</button>
                    新代码
--%>
                    <a href="Register.html" class="btn btn-primary" style="float:right;"><i class="glyphicon glyphicon-plus"></i> 新增</a>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr >
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:if test="${empty requestScope.PageInfo.list}">
                                <tr>
                                    <th>
                                    <td colspan="6" align="center">抱歉！没有查到您要的信息</td>
                                    </th>
                                </tr>
                            </c:if>

                            <c:if test="${!empty requestScope.PageInfo.list}">
                                <c:forEach var="item" items="${requestScope.PageInfo.list}">
                            <tr>
                                <td>${item.id}</td>
                                <td><input type="checkbox"></td>
                                <td>${item.loginAcct}</td>
                                <td>${item.userName}</td>
                                <td>${item.email}</td>
                                <td>
                                    <a type="button" href="Assign/Page.html?id=${item.id}&pageNum=${PageInfo.pageNum}&keyWord=${param.keyWord}" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></a>
                                    <a type="button" class="btn btn-primary btn-xs" href="Admin/editAdminById.html?id=${item.id}&pageNum=${PageInfo.pageNum}&keyWord=${param.keyWord}"><i class=" glyphicon glyphicon-pencil"></i></a>
<%--                                    <button  type="button" class="btn btn-danger btn-xs" id="deleteButton" ><i   class=" glyphicon glyphicon-remove"></i></button>--%>
<%--                                    --%>
                                    <a href="Admin/deleteUser/${item.id}/${requestScope.PageInfo.pageNum}/${param.keyWord}.html" id="delete"><i   class=" glyphicon glyphicon-remove"></i></a>
                                </td>
                            </tr>
                                </c:forEach>
                            </c:if>
                            </tbody>
<%--                            原始代码--%>
<%--                            <tfoot>--%>
<%--                            <tr >--%>
<%--                                <td colspan="6" align="center">--%>
<%--                                    <ul class="pagination">--%>
<%--                                        <li class="disabled"><a href="#">上一页</a></li>--%>
<%--                                        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>--%>
<%--                                        <li><a href="#">2</a></li>--%>
<%--                                        <li><a href="#">3</a></li>--%>
<%--                                        <li><a href="#">4</a></li>--%>
<%--                                        <li><a href="#">5</a></li>--%>
<%--                                        <li><a href="#">下一页</a></li>--%>
<%--                                    </ul>--%>
<%--                                </td>--%>
<%--                            </tr>--%>

<%--                            </tfoot>--%>
<%--                            新代码--%>
                            <tfoot>
                            <tr >
                                <td colspan="6" align="center">
                                    <div id="Pagination" class="pagination"><!-- 这里显示分页 --></div>

                                </td>
                            </tr>

                            </tfoot>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</div>

</body>
</html>
