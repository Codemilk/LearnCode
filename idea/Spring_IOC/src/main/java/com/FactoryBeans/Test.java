package com.FactoryBeans;

import com.bean_factory.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void test(){


        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean_factory.xml");


        Car car=(Car)ctx.getBean("car");

        System.out.println(car);
    }
}
