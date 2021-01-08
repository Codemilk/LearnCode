package MVC.Interceptor;

import CrowedFunding_Entity.Admin;
import Util.CrowedConstant;
import exception.AccessForbiddenException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.获取Session对象
        HttpSession session = request.getSession();

        //2.尝试从session中取出数据Admin

        Admin attribute = (Admin) session.getAttribute(CrowedConstant.ATTR_LOGIN_ADMIN);

        //3.进入管理主界面之前，判断是否有用户信息

        if (attribute==null){
            throw new AccessForbiddenException(CrowedConstant.MESSAGE_ACCESS_FORBIDEN);
        }

        //4.验证不为空，所以返回true
        return true;
    }
}


