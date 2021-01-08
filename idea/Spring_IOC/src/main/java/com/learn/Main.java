package com.learn;


import com.learn.Collection.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
       /*
        //创建对象
        App app=new App();
        //为name属性赋值
        app.setName("yajituo");
        app.hello();*/

//       App.hello();



//1.运用Spring来执行hello

        //1.创建Spring的IOC容器对象
        //ApplicationContext
        ApplicationContext ctx=new ClassPathXmlApplicationContext("application.xml");

                //2.从IOC容器获取bean实例
        //        App bean = (App)ctx.getBean("app");
        //        App bean1 = ctx.getBean(App.class);

                //3.调用hello方法
        //        bean.hello();
        //        bean1.hello();

//2.通过构造参数来赋值

        //        CAR car = (CAR)ctx.getBean(CAR.class);
        //
        //        System.out.println(car.toString());

//3.引用其他的Bean
        //属性注入
        Person person =(Person)ctx.getBean("person");

        System.out.println(person);

        //构造器注入
        Person person1= (Person) ctx.getBean("person1");

        System.out.println(person1);
    }
}
