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

            <div class="modal fade" id="MyModalDelete" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">警告</h4>
                    </div>
                    <div class="modal-body">
                        <h4>请确认您是否要删除选中的信息</h4>
                        <span id="roleNameSpan"></span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" id="deleteModalBtn">是的！我确认删除</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
