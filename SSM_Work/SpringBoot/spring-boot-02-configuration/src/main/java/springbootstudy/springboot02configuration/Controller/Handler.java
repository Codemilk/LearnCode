package springbootstudy.springboot02configuration.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lenovo
 */
@RestController
public class Handler {

    @RequestMapping("/hello")
    public String test(){

        return "hello";
    }
}
