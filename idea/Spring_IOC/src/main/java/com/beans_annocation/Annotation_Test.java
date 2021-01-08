package com.beans_annocation;

import com.beans_annocation.resporsity.UserRepostoryImpl;
import com.beans_annocation.resporsity.service.UserService;
import com.beans_annocation.resporsity.service.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Annotation_Test {

    @Test
    public void test(){

        ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-annotation.xml");

        //获取component
//        TestObject to=(TestObject) ctx.getBean("testObject");
//
//        System.out.println(to);

       //获取controller
        UserController uc=(UserController)ctx.getBean("userController");

        System.out.println(uc);
        uc.execute();

        //获取Repostory
//        UserRepostoryImpl uri=(UserRepostoryImpl)ctx.getBean("userRepostoryImpl");
//
//        System.out.println(uri);

        //获取service
//        UserService us=(UserService)ctx.getBean("userService");
//
//        System.out.println(us);




    }
}
