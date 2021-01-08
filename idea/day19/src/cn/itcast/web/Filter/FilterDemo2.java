package cn.itcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //在放行前，对request数据进行加强
        System.out.println("filterDemo2....执行了");
        //放行
        chain.doFilter(req, resp);
        //在放行后，对response数据进行加强

        System.out.println("filterDemo2....回来了");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
