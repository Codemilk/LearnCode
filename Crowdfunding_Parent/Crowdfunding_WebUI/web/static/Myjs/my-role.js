//声明专门的函数来分配Auth的模态框显示Auth的属性结构数据
function fillAuthTree() {

    //1.发送ajax
    var ajaxAuth = $.ajax({
        url: "Assign/getAuth.json",
        dataType: "JSON",
        type: "POST",
        async: false
    })

    if (ajaxAuth.status != 200) {
        layer.msg("请求出错，响应状态码是:" + ajaxAuth.status + "说明是" + ajaxAuth.statusText)
        return false;
    }
    //获取Auth数组
    var  authList= ajaxAuth.responseJSON.data;

    //zTree配置文件
    var settings = {
        data: {
            //通过设定参数simpleData的子属性enable来使得有Pid和id关系的list交给zTree
            simpleData: {
                enable:true,
                pIdKey:"categoryId"
            },
            //通过指定key子属性name指定zTree使用子节点那个属性作为name
            key:{
                name:"title"
            }
        },
        //通过设定参数check的子属性enable来使得zTree展开单选框/多选框
        check: {
            enable: true
        },
    }

    // 生成树形结构
    $.fn.zTree.init($("#authTreeDemo"), settings, authList);

    //获取zTreeNode对象
    var zTreeObj=$.fn.zTree.getZTreeObj("authTreeDemo")
    //通过zTreeObj来使树形结构展开
    zTreeObj.expandAll(true)
    // 查询已分配的Auth的id组成的数组

      //因为roleId在前面获取role的时候已经加id赋给全局变量window.roleID了所以这里直接取
     var authIds=$.ajax({
        url:"Assign/getAuthsId.json",
        contentType:"application/json;charset=UTF-8",
        data:window.roleID,
        dataType:"json",
        type:"POST",
        async : false
    })

    // console.log(authIds)
    if(authIds.status!=200){
        layer.msg("错误状态码:"+authIds.status+"\n"+"错误信息"+authIds.statusText)
    }
    //获取成功
    var authIdList=authIds.responseJSON.data
    // console.log(authIdList)
    // 根据authidArray把树形结构对应的节点选上
        //表示
        var checked=true
    for (var i=0;i<authIdList.length; i++){

        //节点id
        var authId=authIdList[i]
        //通过zTreeObj的getNodeByParam(key（key的意思就是对应的键）,value),方法获取对应authId的对象
        var authNode=zTreeObj.getNodeByParam("id",authId)
        //表示选中的意思
        var checked=true
        //表示是否子父节点选中联动，我们不使用联动，不联动是为了避免把不该勾选的勾选上
        var checkTypeFlag=false
    zTreeObj.checkNode(authNode,checked,checkTypeFlag)
    }

}
//确认模态框
function confirmModalAlert(roleArray) {

    //打开模态框
    $("#MyModalDelete").modal("show")

    //设置全局id数组
    window.roleIdArray = []

    //清除数据
    $("#roleNameSpan").empty()

    //遍历id数组
    for (var i = 0; i < roleArray.length; i++) {

        var role = roleArray[i]
        var roleName = role.roleName
        var roleId = role.roleId

        //添加内容
        $("#roleNameSpan").append(roleName + "<br></br>")
        //通过push方法将数组对象，添加到id数组
        window.roleIdArray.push(role.roleId)
    }
}

//生成函数
function generate() {

    //1.获取数据
    var pageInfo = getPageInfoRemote();
    //2.填充表格
    FillBody(pageInfo)

}

//访问远程端程序获取pageInfo
function getPageInfoRemote() {

    var resp = $.ajax({
        url: "Role/getRoles.json",
        data: {
            "pageNum": window.pageNum,
            "keyWord": window.keyWord,
            "pageSize": window.pageSize
        },
        type: "POST",
        dataType: "JSON",
        async: false,
        success: function (response) {
            return response
        },
        error: function (response) {
            return response
        }
    })
    //获取状态码
    var status = resp.status

    //当前响应码不为200表示响应失败，判断服务器是否请求成功
    if (status != 200) {
        layer.msg("响应失败")
        return null
    }

    //获取json数据
    var ResultEntity = resp.responseJSON

    //判断是否获取数据成功
    if (ResultEntity.result != "SUCCESS") {
        layer.msg("服务器访问成功，但是数据获取失败，错误：" + ResultEntity.message)
        //return null相当于停止执行下面的方法
        return null;
    }

    //这里表示运行成功，获取页面元素
    var pageInfo = ResultEntity.data
    return pageInfo

}

//填充表格
function FillBody(pageInfo) {
    // 每次append之前要清除否则会追加
    $("#RoleBody").empty()
    $("#Pagination").empty()
    //检查pageInfo，true:表示运行成功，pageInfo带有数据,false:表示获取失败，在tbody填入失败信息
    if (pageInfo == null || pageInfo == undefined || pageInfo.list == null || pageInfo.list.length == 0) {
        $("#RoleBody").append("<tr><td colspan='4'>抱歉！没有查询到您要的信息</td></tr>")
        return null
    }

    for (var i = 0; i < pageInfo.list.length; i++) {

        //数据成员
        var role = pageInfo.list[i]
        var roleId = role.id
        var roleName = role.name
        //真实表格数据
        var IdTd = "<td >" + roleId + "</td>"
        var checkBoxTd = "<td><input id='" + roleId + "' class='itemCheckBox' type='checkbox'></td>"
        var formNameTd = "<td>" + roleName + "</td>"

        var checkBtn = "<button id='" + roleId + "' type='button' class='btn btn-success btn-xs checkBtn'><i class='glyphicon glyphicon-check'></i></button>"
        var pencilBtn = "<button id='" + roleId + "' type='button'  class='btn btn-primary btn-xs pencil-btn'><i class='glyphicon glyphicon-pencil'></i></button>"
        var removeBtn = "<button id='" + roleId + "' type='button' class='btn btn btn-danger btn-xs removeBtn'><i class='glyphicon glyphicon-remove'></i></button>"

        var buttonTd = "<td>" + "" + checkBtn + " " + pencilBtn + " " + removeBtn + "</td>"
        var tr = "<tr>" + IdTd + checkBoxTd + formNameTd + buttonTd + "</tr>"

        $("#RoleBody").append(tr)


    }

    generateNavigator(pageInfo)

}

//翻页时的回调函数
function paginationCallBack(pageIndex, JQuery) {
    //根据pageIndex计算得到的PageNum
    window.pageNum = pageIndex + 1;

    //调用分页函数
    generate()

    //    由于每个页码按钮都是超链接，所以在这个函数最后取消超链接的默认行为
    return false
}

//生成页码导航栏
function generateNavigator(pageInfo) {

    //总记录数
    var totalRecord = pageInfo.total
    //声明一个JSON对象存储Pagination要设置的属性
    var properties = {
        num_edge_entries: 3,                            //边缘页数
        num_display_entries: 5,                         //主体页数
        items_per_page: pageInfo.pageSize,               // 每页显示1项
        callback: paginationCallBack,                   //回调函数
        current_page: pageInfo.pageNum - 1,                //因为Pagination这个组件索引是从0开始的，所以我们要减一
        prev_text: "上一页",                             //上一页文本显示的文本
        next_text: "下一页",
    };

    $("#Pagination").pagination(totalRecord, properties);

}
