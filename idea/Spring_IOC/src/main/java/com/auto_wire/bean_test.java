package com.auto_wire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bean_test {

       @Test
       public void test1(){

              //bean作用域
              ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-scope.xml");
              Car car=(Car)ctx.getBean("car");
              Car car2=(Car)ctx.getBean("car");
              System.out.println(car==car2);
              System.out.println(car);

       }

       @Test
       public void test2() throws SQLException {
              //bean外部文件的引用，这次是c3p0

              ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-property.xml");

              DataSource datasource =(DataSource) ctx.getBean("datasource");
             System.out.println(datasource);


       }


}
