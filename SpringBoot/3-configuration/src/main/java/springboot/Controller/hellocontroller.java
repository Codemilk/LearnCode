package springboot.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellocontroller {

    @Value("${person.name}")
    private String name;

    @RequestMapping("/hello")
    public String sayHello(){
         return "hello,"+name;
    }
}
