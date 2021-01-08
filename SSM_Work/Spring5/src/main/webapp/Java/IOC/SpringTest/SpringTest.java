package IOC.SpringTest;

import IOC.Bean.*;
import IOC.Config.SpringConfig;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import IOC.dao.UserDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import IOC.service.UserService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void testDI(){
        Book book = (Book) new ClassPathXmlApplicationContext("Spring_Rumen.xml").getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testBean(){

        ApplicationContext ioc=new ClassPathXmlApplicationContext("Spring_Rumen.xml");

        Emp emp = ioc.getBean("emp", Emp.class);
        System.out.println(emp);

    }
    @Test
    public void testRONGQI(){
        ApplicationContext ioc=new ClassPathXmlApplicationContext("Spring_Rumen.xml");
        Stu stu = ioc.getBean("stu", Stu.class);
        System.out.println(stu);

        Book book2 = ioc.getBean("book2", Book.class);
        System.out.println(book2);

    }

    @Test
    public void testMyFactoryBean(){

        ApplicationContext ioc=new ClassPathXmlApplicationContext("Spring_Rumen.xml");

        Book myFactoryBean = ioc.getBean("myFactoryBean", Book.class);

        System.out.println(myFactoryBean);

    }

    @Test
    public void testBeanScope(){
        ApplicationContext ioc =new ClassPathXmlApplicationContext("Spring_Rumen.xml");

        Book book1 = ioc.getBean("book", Book.class);
        Book book2 = ioc.getBean("book", Book.class);

        System.out.println(book1==book2);
    }

    @Test
    public void testBeanLifecycle(){
        ApplicationContext ioc =new ClassPathXmlApplicationContext("Spring_Rumen.xml");

        Orders orders = ioc.getBean("orders", Orders.class);

        System.out.println(orders);
        //手动销毁IOC容器
        ((ClassPathXmlApplicationContext)ioc).close();

    }

    @Test
    public void testAutowire(){
        ApplicationContext ioc =new ClassPathXmlApplicationContext("Spring_Rumen.xml");

        Emp emp2 = ioc.getBean("emp2", Emp.class);

        System.out.println(emp2);
    }

    @Test
    public void testPropertyPlaceholder() throws SQLException {
        ApplicationContext ico=new ClassPathXmlApplicationContext("Spring_Rumen.xml");

        DruidDataSource dataSourceFactory = ico.getBean("dataSourceFactory", DruidDataSource.class);
        DruidPooledConnection connection = dataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_emp where emp_id = 90");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("gender"));
        }

    }

    @Test
    public void testAnnotation(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("Spring_annotation.xml");

        UserDaoImpl userDaoImpl = (UserDaoImpl) ioc.getBean("userDaoImpl");

        userDaoImpl.update();
    }

    @Test
    public void testDiAutoWired(){

        ApplicationContext ioc = new ClassPathXmlApplicationContext("Spring_annotation.xml");

        UserService userService = ioc.getBean("userService", UserService.class);

        userService.add();
    }

    @Test
    public void testAllAutoWired(){

        ApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Emp bean = annotationConfigApplicationContext.getBean(Emp.class);

        System.out.println(bean);

    }
}
