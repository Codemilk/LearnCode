package com.genneric;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class generic_Test {

    @Test
    public void test1(){

        ApplicationContext ac=new ClassPathXmlApplicationContext("Beans-generic-id.xml");


       UserService us= (UserService)ac.getBean("userService");


        us.add();
    }

}
