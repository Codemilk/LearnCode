package cn.idcast.web.servlet;

import cn.idcast.domain.User;
import cn.idcast.service.impl.userServiceImpl;
import cn.idcast.service.userService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //测试Filter
//        System.out.println(request);
     //1.设置编码
        request.setCharacterEncoding("utf-8");
    //2.获取数据

     //对验证码进行校验
    //3.封装user对象
        String verifycode = request.getParameter("verifycode");
//        System.out.println(verifycode);

        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
//        System.out.println(checkcode_server);
        session.removeAttribute("CHECKCODE_SERVER");//确保session验证码冗余

        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //提示错误信息
           request.setAttribute("login_error", "验证码错误");
           request.getRequestDispatcher("/login.jsp").forward(request, response);
            System.out.println("错误");
        }
        Map<String, String[]> parameterMap = request.getParameterMap();

        User user=new User();
            try {
                BeanUtils.populate(user,parameterMap);
            } catch (Exception e) {
                e.printStackTrace();
            }




    //4.调用service查询
        userService userService=new userServiceImpl();
        User loginuser= userService.findUserByUsernameAndPassword(user);
    //5.判断是否对错
        if(loginuser!=null) {
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginuser);

            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }else{
            //登陆失败
            //提示信息
            request.setAttribute("login_error", "用户名或密码错误啊我丢");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);
    }
}
