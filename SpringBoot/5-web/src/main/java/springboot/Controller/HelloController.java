package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.Exception.UserNotExistException;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String testJsonWithException(@RequestParam("username") String username) {

        if(StringUtils.isEmpty(username)){
            throw new UserNotExistException("yonghubucunzai");
        }

        return "HelloWorld";
    }
}
