package com.bean_factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {

    }
    @org.junit.Test
    public void test(){


        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean_factory.xml");


        Car car=(Car)ctx.getBean("car1");

        System.out.println(car);
    }




}
