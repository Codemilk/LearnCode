package cn.idcast.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class loginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

       //1.判断资源请求路径,但要强转一下，因为这不是HttpRequest
        HttpServletRequest request= (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
      //要排除掉所有的关于登陆的资源
        if(requestURI.contains("/login.jsp")||requestURI.contains("LoginServlet")||requestURI.contains("/css/")||requestURI.contains("/js/")||requestURI.contains("/fonts/")||requestURI.contains("/CheckCodeServlet")){
            //包含这些表名用户就是想登陆
            chain.doFilter(req, resp);

        }else{
            //不包含，需要验证用户是否登陆
            //3.从session中获取user

            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //登陆了，放行
               chain.doFilter(req, resp);
            }else{
                //没有登陆
                request.setAttribute("login_error", "您尚未登陆，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void destroy() {

    }


}
