package COM.AOP.Aopimpl_xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    ApplicationContext container=new ClassPathXmlApplicationContext("Aopimpl_xml.xml");

    @Test
    public void test1(){

        Calculator calculator= (Calculator)container.getBean("calculator");

        int result = calculator.add(1, 2);

        System.out.println(calculator.getClass().getName()  );
        System.out.println(result);


    }



}
