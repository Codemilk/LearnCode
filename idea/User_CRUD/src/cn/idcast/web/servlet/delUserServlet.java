package cn.idcast.web.servlet;

import cn.idcast.service.impl.userServiceImpl;
import cn.idcast.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class delUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //1.设置编码
//        request.setCharacterEncoding("utf-8");
     //2.获取id
        System.out.println("来了");
        String id = request.getParameter("id");
        userService userService=new userServiceImpl();
        userService.delete(id);

        //3.跳转查询所有的servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request, response);
    }
}
