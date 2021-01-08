package MVC.Controller;

import CrowedFunding_Entity.Auth;
import CrowedFunding_Entity.Role;
import Service.service.AdminServie;
import Service.service.AuthService;
import Service.service.RoleService;
import Util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Action;
import java.util.List;
import java.util.Map;

/**
 * @author lenovo
 */
@Controller
@RequestMapping("/Assign")
public class AssignHandler {

    @Autowired
    private AdminServie adminServie;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    @ResponseBody
    @RequestMapping("/saveAuth.json")
    public ResultEntity<String> saveAuth(@RequestBody Map<String,List<Integer>> map){

     //  因为传过来的数据有重复所有在service需要删除在添加
        System.out.println(map);
      authService.saveAuth(map);

      return  ResultEntity.successWithoutData();
    }
    @ResponseBody
    @RequestMapping("/getAuthsId.json")
    public ResultEntity<List<Integer>>  getAuthsId(@RequestBody Integer roleIds){
        List<Integer> authsId = authService.getAuthsId(roleIds);
        return  ResultEntity.successWithData(authsId);

    }

    @RequestMapping("/getAuth.json")
    @ResponseBody
    public ResultEntity<List<Auth>> getAuth(){

        List<Auth> auth = authService.getAuth();


        return  ResultEntity.successWithData(auth);
    }

    @RequestMapping("/assign.html")
    public String assign(@RequestParam("adminId") Integer adminId,
                         @RequestParam("pageNum")Integer pageNum,
                         @RequestParam("keyWord")String keyWord,
                         //required = false 表示当前的对象可以不为空，我们允许用户在页面取消所有的已分配角色在提交表单，所以可以不提供roleIdList请求参数
                         @RequestParam(value = "roleIdList",required = false)List<Integer> roleIdList){

        System.out.println(roleIdList);
        adminServie.saveRoleWithAdmin(adminId,roleIdList);

        return "redirect:/Admin/getPageInfo.html?pageNum="+pageNum+"&keyWord="+keyWord;
    }

    @RequestMapping("/Page.html")
    public String toPage(@RequestParam(value = "id",defaultValue = "") Integer id, @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "keyWord",defaultValue = "") String  keyWord, ModelMap modelMap){

       //查询已分配角色
        List<Role> assignRole = roleService.getAssignRole(id);

        //查询未分配角色
        List<Role> unAssignRole = roleService.getUnAssignRole(id);

        //存入模型
        modelMap.addAttribute("AssignRole",assignRole);
        modelMap.addAttribute("unAssignRole",unAssignRole);


        return "assignRole";
    }


}
