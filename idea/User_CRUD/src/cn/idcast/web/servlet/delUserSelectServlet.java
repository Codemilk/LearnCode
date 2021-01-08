package cn.idcast.web.servlet;

import cn.idcast.service.impl.userServiceImpl;
import cn.idcast.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserSelectServlet")
public class delUserSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("utf-8");
      //1.获取所有的id
        String[] uids = request.getParameterValues("uid");
        userService userService=new userServiceImpl();

        userService.deleteSelect(uids);

      response.sendRedirect(request.getContextPath()+"/userListServlet");
     }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);
    }
}
