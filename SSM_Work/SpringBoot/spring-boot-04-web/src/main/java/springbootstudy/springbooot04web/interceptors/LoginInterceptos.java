package springbootstudy.springbooot04web.interceptors;

import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptos implements HandlerInterceptor {
//设置拦截器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();

        Object loginUser = session.getAttribute("loginUser");

        if(StringUtils.isEmpty(loginUser)){
//          没有登入
            LoggerFactory.getLogger(this.getClass()).info("error : 没有登入");
            request.setAttribute("exMsg", "您没有登入");
            request.getRequestDispatcher("/login.html").forward(request, response);
            return  false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
