package ANLI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkcode = request.getParameter("checkcode");
        //判断验证码是否正确
        HttpSession session = request.getSession();
        String s1 = (String) session.getAttribute("s1");
        //为了进行后退等操作的验证码的刷新，每次当你获取验证码的时候都将验证码清空
        session.removeAttribute("s1");
         if(s1.equalsIgnoreCase(checkcode)){
             //忽略大小写比较字符串
            //验证码正确
            if("zhangsan".equals(username)&&"123456".equals(password)){
                 //登录成功
                 //重定向到success
                session.setAttribute("user", username);
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else{

                //存储信息到request
                request.setAttribute("loginerror", "用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            }
            //判断用户名密码是否一致

        }else{
            //验证码不一致
            //存储信息到request
            request.setAttribute("error", "验证码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request, response);
    }
}
