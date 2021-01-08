package com.beans_cycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beans_cycleTest {

    @Test
    public void test1(){


        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean_cycle.xml");


       car car1= (car)ctx.getBean("car");

        System.out.println(car1);

       //关闭容器
        ctx.close();

    }
}
