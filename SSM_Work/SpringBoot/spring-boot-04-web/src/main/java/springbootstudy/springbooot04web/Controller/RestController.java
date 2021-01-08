package springbootstudy.springbooot04web.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springbootstudy.springbooot04web.Exception.testException;
import springbootstudy.springbooot04web.dao.EmployeeDao;
import springbootstudy.springbooot04web.entities.Employee;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

@Controller
public class RestController {

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping("/testException")
    public String testException(){



        int a=0;
        if(a+1>0){
            throw new testException("testException");
        }

        return "index";
    }

    @GetMapping("/emps")
    public String getEmps(Map map){

        Collection<Employee> all = employeeDao.getAll();
        map.put("emps", all);

        return  "emp/list";
    }

/**PostMapping就是post类型的@RequestMapping
 * 登入
 * */
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Map<String,Object> map,
            HttpSession session
    ){

        if(!StringUtils.isEmpty(username)&& "123456".equals(password)){
//          将数据放入Session中，判断是否登入用户
          session.setAttribute("loginUser", username);

            return "redirect:main.html";

        }else {
            map.put("exMsg", "账号或密码错误");
        return "index";
        }
    }
}
