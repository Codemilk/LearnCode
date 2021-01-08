package com.learn;

import com.learn.Collection.DataSource;
import com.learn.Collection.Person;
import com.learn.Collection.Person2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

public class Main2 {

    public static void main(String[] args) {

        //获取容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("application.xml");
//
//        Person person1 = (Person) ctx.getBean("person3");
//
//        System.out.println(person1);

        //展示map例子

//        Person2 person2=(Person2)ctx.getBean("person3");


//        System.out.println(person2);

        DataSource properties=(DataSource)ctx.getBean("datasource");

        System.out.println(properties);

        Person p4=(Person)ctx.getBean("person4");
        System.out.println(p4);
    }
}
