package SpringTest;

import Bean.Book;
import Bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void test(){
//        获取ioc容器
        ApplicationContext IOC = new ClassPathXmlApplicationContext("Spring_Rumen.xml");

        User spring_user = IOC.getBean("SpringUser", User.class);

        System.out.println(spring_user);
        spring_user.add();

    }
    
    @Test
    public void test2(){
        Book book = (Book) new ClassPathXmlApplicationContext("Spring_Rumen.xml").getBean("book", Book.class);
        System.out.println(book);
    }
}
