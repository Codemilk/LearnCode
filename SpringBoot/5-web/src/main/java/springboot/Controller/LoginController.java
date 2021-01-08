package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        Map<String,String> map, HttpSession session) {
        if(!StringUtils.isEmpty(username)&&password.equals("123456")) {
        //登入成功
           session.setAttribute("username",username);
        return "redirect:dashboard.html";
        }   else {
        //登入失败
            map.put("errorMessage", "您的用户名或密码错误");
            return "index" ;
        }
    }

}
