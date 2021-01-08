package MVC.Controller;

import CrowedFunding_Entity.Admin;
import Service.service.AdminServie;
import Util.CrowedConstant;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author lenovo
        */
@Controller
@RequestMapping("/Admin")
public class AdminHandler {

    @Autowired
    private AdminServie adminServie;

    //更新操作
    @RequestMapping("/update.html")
    public String update(Admin admin, @RequestParam("id")Integer id, @RequestParam("pageNum")Integer pageNum, @RequestParam("keyWord") String keyWord){


        adminServie.update(admin);

        return "redirect:/Admin/getPageInfo.html?pageNum="+pageNum+"&keyWord="+keyWord;

    }

    //通过id查询单个用户
    /**URI:Admin/editAdminById/id=${item.id}&pageNum=${PageInfo.pageNum}&keyWord=${param.keyWord}*/
    @RequestMapping("/editAdminById.html")
    public String getAdminById(@RequestParam("id")Integer id,@RequestParam("pageNum")Integer pageNum,@RequestParam("keyWord") String keyWord,ModelMap modelMap){

        Admin admin = adminServie.getAdminByid(id);

        modelMap.put("admin",admin);

        return "admin-edit";

    }

    @RequestMapping(value = "/Register.html",method = RequestMethod.POST)
    public String  Register(Admin admin){

        adminServie.saveAdmin(admin);

        return   "redirect:/Admin/getPageInfo.html?pageNum="+ Integer.MAX_VALUE;

    }
    /***
     * 通过@PathVariable的方式来传入参数
     * @param id
     * @param pageNum
     * @param keyword
     * @return
     */
    @RequestMapping("deleteUser/{id}/{pageNum}/{keyWord}.html")
   public String  deleteUser(@PathVariable("id") Integer id,@PathVariable("pageNum")String pageNum,@PathVariable("keyWord") String keyword){
        adminServie.deleteUser(id);
        //返回路径直接就是查找数据
        return   "redirect:/Admin/getPageInfo.html?pageNum="+pageNum+"&keyWord="+keyword;

    }


    @RequestMapping("/getPageInfo.html")
    public String getPageInfo(@RequestParam(value = "keyWord",defaultValue = "") String keyWord, @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, @RequestParam(value = "PageSize",defaultValue = "5") Integer PageSize, ModelMap modelMap){

//       获取info对象存入模型
        PageInfo<Admin> admins = adminServie.selectAdmins(keyWord, pageNum, PageSize);

        modelMap.addAttribute(CrowedConstant.ATTR_PAGE_INFO,admins);

        return  "admin-main";
    }

    @RequestMapping("/logout.html")
    public String doLogout(HttpSession session){

        //强制刷新session
        session.invalidate();

        //这里也要重定向，防止重复提交表单，没意义

        return "redirect:/logout.html";

    }

    //登录
    @RequestMapping("/login.html")
    public String doLogin(@RequestParam("loginAcct") String userName, @RequestParam("userPswd") String password, HttpSession session){

        //若返回admin对象说明登录成功，若果账号密码不正确则会抛出异常
        Admin adminByLogAct = adminServie.getAdminByLogAct(userName, password);

        session.setAttribute(CrowedConstant.ATTR_LOGIN_ADMIN, adminByLogAct);

        /*要重定向，否则刷新就相当于重新提交表单，也即是在访问下handler方法，就再一次查找了数据库
        但是我们不能直接写访问这个jsp，因为是交给jsp访问的，所以要写对应的url,因为重定向是再给浏览器一个url
        这里的不可以直接转发web-inf下面的jsp因为被保护，所以得写入访问路径，这里我们直接写入新的url，让视图转换器跳转
        */
        return "redirect:/Page.html";
    }

}
