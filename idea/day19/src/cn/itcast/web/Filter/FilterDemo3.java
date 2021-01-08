package cn.itcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class  FilterDemo3 implements Filter {
   //注意：Filter在每一次请求被拦截资源时，会执行



    //服务器关闭后,Filter对象销毁，如果服务器正常关闭，则会调用Destroy，一般用于销毁资源
    public void destroy() {
        System.out.println("destory启动了");
    }

    //用于加载,逻辑判断。

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {


        System.out.println("Filter启动了");
        chain.doFilter(req, resp);



    }
     //服务器启动后，建立Filter之后调用init，一般用来加载资源
    public void init(FilterConfig config) throws ServletException {
        System.out.println("inti启动了");
    }

}
