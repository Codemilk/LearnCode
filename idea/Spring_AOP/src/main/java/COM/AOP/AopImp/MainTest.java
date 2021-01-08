package COM.AOP.AopImp;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//把这个类声明为一个切面，首先把这个类放到Ioc容器中，在声明为一个切面

public class MainTest {

    @Test
    public void test1(){

        //创建SpringIoc容器
        ApplicationContext  container=new ClassPathXmlApplicationContext("AopImp.xml");


        //从ico中取出bean
        Calculator calculator=(Calculator)container.getBean("calculatorImpl");


        //使用bean
      int result=  calculator.add(1,2);


        System.out.println(result);

        result=calculator.div(2,6);
        System.out.println(result);
    }
}
