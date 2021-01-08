package Transaction.test;

import Transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class SpringTest {

    @Test
    public void testSpringTransaction_Aop(){



        ApplicationContext ioc=new ClassPathXmlApplicationContext("SpringTransaction_Aop.xml");
        UserService userService = ioc.getBean("userService", UserService.class);

        userService.TransferMoney();
    }

    @Test
    public void testSpringTransaction_Xml(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("SpringTransaction_xml.xml");
        UserService userService = ioc.getBean("userService", UserService.class);

        userService.TransferMoney();
    }

    @Test
    public void testFunctional_style(){
//        1.创建GenericApplicationContext对象
        GenericApplicationContext  context=new GenericApplicationContext();
//        2.调用context的方法对象注册
        context.refresh();
//        context.registerBean(User.class,()-> new User() );


    }
}
