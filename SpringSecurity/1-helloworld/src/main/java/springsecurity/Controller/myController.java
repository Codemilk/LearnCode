package springsecurity.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

    @RequestMapping("/hello")
    public String hello(){
                                
        return "Hello Security";
    }
}
