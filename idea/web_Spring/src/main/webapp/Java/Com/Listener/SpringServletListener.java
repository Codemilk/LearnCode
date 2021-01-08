package Com.Listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //0.获取Spring配置文件

        ServletContext servletContext = servletContextEvent.getServletContext();


        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");



        //1.在服务器开始servletContextEvent被创建的时候，创建IOC

        //2.创建IOC
        ApplicationContext ctx=new ClassPathXmlApplicationContext(contextConfigLocation);


        servletContext.setAttribute("ApplicationContext", ctx);





    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {


    }
}