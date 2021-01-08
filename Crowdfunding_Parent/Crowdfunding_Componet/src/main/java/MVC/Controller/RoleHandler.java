package MVC.Controller;

import CrowedFunding_Entity.Role;
import Service.service.RoleService;
import Util.ResultEntity;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lenovo
 */
@Controller
@RequestMapping("/Role")
public class RoleHandler {

     @Autowired
    private RoleService roleService;


     @RequestMapping("/deleteRole.json")
     public ResultEntity<String> deleteRole(@RequestBody List<Integer> list){

         if (list.size()==0||list.isEmpty()){
             return ResultEntity.Failed("您没并没有选择删除的对象");
         }

         System.out.println("laile");


         roleService.deleteRole(list);

         return ResultEntity.successWithoutData();
     }

     @RequestMapping("/updateRole.json")
     @ResponseBody
     public ResultEntity<String> updateRole(@RequestParam("name")String roleName,@RequestParam("id") Integer id){

         Logger logger = LoggerFactory.getLogger(RoleHandler.class);

         Role role = new Role(id, roleName);

         logger.info("此方法确实有访问到"+String.valueOf(role));

         roleService.updateRole(role);

         return ResultEntity.successWithoutData();
     }


     @RequestMapping("/getRoles.json")
     @ResponseBody
    public ResultEntity<PageInfo<Role>> getRoles(@RequestParam(value = "keyWord",defaultValue = "") String keyWord, @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,@RequestParam(value = "pageSize",defaultValue = "5") int pageSize){

         //获取数据
         PageInfo<Role> page = roleService.getPage(keyWord, pageNum, pageSize);

         //封装到结果集，如果成功返回数据，异常则交给异常处理器

         return  ResultEntity.successWithData(page);
     }

     @PostMapping("/addRole.json")
     @ResponseBody
     public ResultEntity<String> addRole(@RequestParam("RoleName") String RoleName) {


         System.out.println("Role:"+RoleName);

//         判断书是否为空
         if(!StringUtils.isEmpty(RoleName)){
         roleService.saveRole(new Role(null, RoleName));

         return  ResultEntity.successWithoutData();
         }

         return ResultEntity.Failed("失败了");

     }
}
