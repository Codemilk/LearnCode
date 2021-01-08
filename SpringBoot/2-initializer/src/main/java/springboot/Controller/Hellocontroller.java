package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hellocontroller {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "initializer success";
    }
}
