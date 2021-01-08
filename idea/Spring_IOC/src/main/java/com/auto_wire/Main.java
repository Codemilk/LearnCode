package com.auto_wire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


    public static void main(String[] args) {

        //获得容器
        // ApplicationContext ctx=new ClassPathXmlApplicationContext("auto_wire.xml");
        //Person person=(Person) ctx.getBean("person");
        //System.out.println(person);


        ApplicationContext ctx=new ClassPathXmlApplicationContext("bean_relationship.xml");

//        Address address=(Address)ctx.getBean("address");
//
//        System.out.println(address);

//        Address address2=(Address)ctx.getBean("address2");
//
//        System.out.println(address2);

//
//        Person person =(Person)ctx.getBean("person");
//
//        System.out.println(person);




    }
}
