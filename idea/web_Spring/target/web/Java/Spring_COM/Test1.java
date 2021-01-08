package Spring_COM;

import Com.Beans.testBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    @Test
    public void test(){

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");


        testBean testbean = (testBean)applicationContext.getBean("testBean");
        testbean.test();
    }
}
