package com.beans_annocation.resporsity.service.controller;


import com.beans_annocation.resporsity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService us;



    public void execute(){
        System.out.println("userController execute .....");
        us.add();
    }

}
