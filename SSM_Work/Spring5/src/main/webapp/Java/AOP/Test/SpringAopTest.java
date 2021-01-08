package AOP.Test;

import AOP.AOP_annotation.User;
import AOP.AOP_xml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopTest {



    @Test
    public void testAop_Annotation(){

        ApplicationContext ioc=new ClassPathXmlApplicationContext("SpringAop_annotation.xml");
        User user = ioc.getBean("user", User.class);

        user.add();
    }
    @Test
    public  void testAop_Xml(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("SpringAop_xml.xml");

        Book book = ioc.getBean("book", Book.class);
        book.buy();
    }
}
