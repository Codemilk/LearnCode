package cn.itcast.web;

import javax.servlet.*;
import java.io.IOException;

/*
 servlet的方法

 */
public class SevletDemo2 implements Servlet {
    /*
        初始化方法：在servlet被创建的时候，只会执行一次

     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("我是init");
    }
    /*
        获取Servletconfig对象
         ServletConfig：Servlet的配置对象
         @return

     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    /*
       提供服务
              ：每一次servlet被访问是，执行：执行多次

     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我是service");
    }
    /*
    * 获取servlet的一些信息，版本，坐着
     */
    @Override
    public String getServletInfo() {
        return null;
    }
    /*
    * 销毁方法
    * 在服务器正常关闭时，执行，执行一次
    * */
    @Override
    public void destroy() {
        System.out.println("我是destory");
    }
}
