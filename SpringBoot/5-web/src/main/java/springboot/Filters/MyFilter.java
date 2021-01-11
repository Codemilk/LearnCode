package springboot.Filters;

import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MyFilter_doFilter");
        //放行Filter
        chain.doFilter(request, response);
    }

}
