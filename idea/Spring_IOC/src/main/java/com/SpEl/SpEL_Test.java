package com.SpEl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpEL_Test {

    @Test
    public void test1(){


        ApplicationContext ctx=new ClassPathXmlApplicationContext("SpEl_beans.xml");

        Address address=(Address) ctx.getBean("address");


        System.out.println(address);

    }

    @Test
    public void test2(){
        ApplicationContext ctx =new ClassPathXmlApplicationContext("SpEl_beans.xml");

        Car car = (Car)ctx.getBean("car");

        System.out.println(car);

    }
}
