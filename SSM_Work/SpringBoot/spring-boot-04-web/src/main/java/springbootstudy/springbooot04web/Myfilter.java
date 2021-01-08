package springbootstudy.springbooot04web;

import javax.servlet.*;
import java.io.IOException;

public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Myfilter执行了");
//        放行

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
