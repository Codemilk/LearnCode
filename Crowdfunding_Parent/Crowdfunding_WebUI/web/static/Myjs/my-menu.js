//获取树形结构
function generateTree(settings,zNodes){
    $.ajax({
        url:"Menu/getWhole.json",
        datatype:"JSON",
        type: "POST",
        success:function (response){

            var result= response.result

            if(result=="SUCCESS"){
                var zNodes = response.data
                //表示zTree的初始化开始,初始化树形结构
                $.fn.zTree.init($("#treeDemo"), settings, zNodes);
            }
            if(result=="FAILED"){
                layer.msg(response.message)
            }
        }
    })

}

//鼠标移出节点范围移除按钮组
function myRemoveHoverDom(treeId, treeNode) {

    var btnGroupId = treeNode.tId + "_btnGrp"

    //移除自己本身
    $("#" + btnGroupId).remove()
}

//鼠标移入节点范围添加按钮组
function myAddHoverDom(treeId, treeNode) {

//    按钮组的标签结构：<span><a><i></i></a></span>
//    按钮出现的位置：节点中treeDemo_n_a超链接的后面

//    为了在需要移除按钮能够净赚定位到按钮组所在<span>。需要Span设置有规律的id
    var btnGroupId = treeNode.tId + "_btnGrp"
//    找到节点按钮
    var tID = treeNode.tId + "_a"

    // alert("laiel")

    //按钮的准备
    // <a class="btn btn-info dropdown-toggle btn-xs" style="margin-left:10px;padding-top:0px;" href="#">&nbsp;&nbsp;<i class="fa fa-fw fa-plus rbg "></i></a>
    var deleteBtn = "<a id='" + treeNode.id + "' class=\"btn btn-info dropdown-toggle btn-xs deleBtn\" style=\"margin-left:10px;padding-top:0px;\" href=\"#\">&nbsp;&nbsp;<i class=\"fa fa-fw fa-times rbg \"></i></a>"
    var editBtn =   "<a id='" + treeNode.id + "' class=\"btn btn-info dropdown-toggle btn-xs editBtn\" style=\"margin-left:10px;padding-top:0px;\" href=\"#\" title=\"修改权限信息\">&nbsp;&nbsp;<i class=\"fa fa-fw fa-edit rbg \"></i></a>"
    var addBtn =    "<a id='" + treeNode.id + "' class=\"btn btn-info dropdown-toggle btn-xs addBtn\" style=\"margin-left:10px;padding-top:0px;\" href=\"#\">&nbsp;&nbsp;<i class=\"fa fa-fw fa-plus rbg \"></i></a>"


    //判断目前节点的级别
    var level = treeNode.level

    // alert(level)
    var htmlBtn;
    switch (level) {
        case 0:
            htmlBtn =""+ addBtn
            break;
        case 1:
            if (treeNode.children.length == 0) {
                htmlBtn = addBtn + "" + deleteBtn + "" + editBtn
                break;
            } else {
                htmlBtn = addBtn + "" + editBtn
                break;
            }
        case 2:
            htmlBtn = deleteBtn + "" + editBtn
            break;
    }

    //判断以前是否已经添加了按钮组,id为btnGroupId的组件表示已经加入组件了
    if ($("#" + btnGroupId).length > 0) {
        return;
    }
    //将组件加入到超连接节点按钮的后面
    $("#" + tID).after("<span id='" + btnGroupId + "'>" + htmlBtn + "</span>")


}

//加载node 并且修改图标
function myAddDiyDom(treeId, treeNode) {

    //treeId就是treeDemo 也就是整个树形结构附着的id模拟
    // console.log("treeId" + treeId)
    //
    // //每一个treeNode代表一个节点  ，也就是后端查询得到的Menu对象的全部属性
    // console.log(treeNode)

    //根据控制图标的Span标签的id找到这个Span标签

    //例子id="treeDemo_4_a"
    //解析：ul的id_当前节点的序号_功能
    // ul的id_当前节点的序号也就是Tid
    var id = treeNode.tId + "_ico"

    //删除旧的class
    $("#" + id).removeClass()

    //添加新的class

    $("#" + id).prop("class", treeNode.icon)
}

