package cn.itcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/index.jsp")
//@WebFilter("/user/*")
//@WebFilter("*.jsp")
public class FilterDemo4 implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo4 被调用了");
        chain.doFilter(req, resp);
    }

    public void destroy() {

    }


}
