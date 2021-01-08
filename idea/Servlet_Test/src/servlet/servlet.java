package servlet;

import USER.User;
import org.apache.commons.beanutils.BeanUtils;
import userdao.userdaos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     this.doGet(req, resp);


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //方法一
//        User us=new User();
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        us.setUsername(username);
//        us.setPassword(password);
//        userdaos ud=new userdaos();
//        User login = ud.login(us);
        //方法二：
        //1.获取所有参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        //2.创建User对象
        User us=new User();
        //3.使用BeanUtils封装
        try {

            BeanUtils.populate(us,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userdaos ud=new userdaos();
        User login = ud.login(us);
        if(login==null){
        req.getRequestDispatcher("/failservlet").forward(req, resp);

         }else{
            req.setAttribute("user",login);
            req.getRequestDispatcher("/sucessservlet").forward(req, resp);
        }
    }
}
