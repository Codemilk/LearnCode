package cn.itcast.web.listener;

import cn.itcast.web.Filter.FilterDemo5;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ContextLoader implements ServletContextListener {
    /*
      contextInitialized:
            监听ServletContext，监听ServletContext创建之后，执行该方法
            ServletContext服务器创建后建立的对象
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       //加载资源文件

        //1.获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        //2.加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("ContextConfigLocation");

        //3.获取真实路径
        String realPath = servletContext.getRealPath(contextConfigLocation);
        try {
            FileInputStream fs=new FileInputStream(realPath);
            System.out.println(fs);
         } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext被创建了");

    }

    /*
         contextDestroyed:
               监听ServletContext，监听ServletContext销毁之前，执行该方法
               ServletContext服务器销毁前销毁        */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext被销毁了");

    }
}
