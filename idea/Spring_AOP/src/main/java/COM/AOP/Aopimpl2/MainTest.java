package COM.AOP.Aopimpl2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    @Test
    public void tst(){
        ApplicationContext container=new ClassPathXmlApplicationContext("AopImp2.xml");

        Calculator calculator=(Calculator)container.getBean("calculatorImpl");

//        System.out.println(calculator.getClass().getName());
        int add = calculator.add(1, 2);
        System.out.println(add);
    }
}
