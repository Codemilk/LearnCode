package com.Handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {


    @RequestMapping("/helloWorld")
    public String helloWorld(){

        System.out.println("HelloWorld");
        return "success";
    }


}
