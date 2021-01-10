package springboot.Listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web开始了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web结束了");
    }
}
