package cn.idcast.web.servlet;

import cn.idcast.domain.User;
import cn.idcast.service.impl.userServiceImpl;
import cn.idcast.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService
        userService service=new userServiceImpl();
        List<User> userList = service.findAll();
        //2.将list存入request中
        request.setAttribute("users", userList);
        //3.转发到list.jsp中
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }
}
