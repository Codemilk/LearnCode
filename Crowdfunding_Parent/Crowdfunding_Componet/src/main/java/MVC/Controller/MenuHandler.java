package MVC.Controller;


import CrowedFunding_Entity.Menu;
import Service.service.MenuService;
import Util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Menu")
public class MenuHandler {

    @Autowired
    private MenuService menuService;


    @RequestMapping("/delMenu.json")
    @ResponseBody
    public ResultEntity<String> delMenu(@RequestParam("id") Integer id){

        System.out.println(id);
        menuService.deleteMenu(id);

        return ResultEntity.successWithoutData();
    }
    @RequestMapping("/updateMenu.json")
    @ResponseBody
    public ResultEntity<String> updateMenu(Menu menu) {
         System.out.println(menu);
          menuService.updateMenu(menu);
        return ResultEntity.successWithoutData();
    }

    @RequestMapping("/saveMenu.json")
    @ResponseBody
    public ResultEntity saveMenu(Menu menu){

//        System.out.println(menu);

        menuService.saveMenu(menu);

        return ResultEntity.successWithoutData();
    }

    @ResponseBody
    @RequestMapping("/getWhole.json")
    public ResultEntity<Menu> getWholeNew(){

        List<Menu> all = menuService.getAll();

        Menu root =null;

        Map<Integer, Menu> menuList = new HashMap<>();

        for (Menu menu: all) {
//           将数据存入Map中通过Pid和map中的键id对应 来和value取值
            menuList.put(menu.getId(), menu);

        }

        for(Menu menu:all){

            if(menu.getPid()==null){
                root =menu;

                continue;
            }

            //表示当前的map里面的menu是你的当foreach里面的父节点
            if(menuList.containsKey(menu.getPid())){

                //获取父节点
                Menu menuFather = menuList.get(menu.getPid());

                List<Menu> children = menuFather.getChildren();

                children.add(menu);

                continue;

            }
        }
        return ResultEntity.successWithData(root);
    }


//   //时间复杂度太大，所以不适用
//    public ResultEntity<Menu> getWholeOld(){
//
//        /**1.查询全部的Menu对象*/
//        List<Menu> all = menuService.getAll();
//
//        /**声明一个变量用来存储找到的根节点*/
//
//        Menu root=null;
//
//        for (Menu menu:all){
//
//            //获取menu的pid
//            Integer pid = menu.getPid();
//
//            //判断当前的Pid是否为空,因为只有根节点的PId为空
//            if(pid==null){
//                root=menu;
//
//                //停止本次循环，继续下次循环
//                continue;
//            }
//            //如果不为空，说明当前的节点menu有父节点，要建立父子关系
//            for (Menu menuFather:all) {
//                // 表示当前的id等于Pid，也就是当前的menuFather是menu的父类
//                if(pid.equals(menu.getId())){
//
//                    //将子节点存入父节点的children集合
//                    List<Menu> children = menuFather.getChildren();
//
//                    children.add(menu);
//
//                    break;
//                }
//            }
//
//        }


//     return ResultEntity.successWithData(root);
//    }


}
