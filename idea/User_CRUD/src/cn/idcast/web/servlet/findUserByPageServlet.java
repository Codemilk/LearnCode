package cn.idcast.web.servlet;

import cn.idcast.domain.PageBean;
import cn.idcast.domain.User;
import cn.idcast.service.impl.userServiceImpl;
import cn.idcast.service.userService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class findUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //当前页码

        String currentPage = request.getParameter("currentPage");
        //每页条数
        String rows = request.getParameter("rows");
        //调用Service查询
        //防止index.jsp进入时，出现错误（空字符转换错误），
        if(currentPage==null||"".equals(currentPage)){
                 currentPage="1";
        }
        if(rows==null||"".equals(rows)){
            rows="5";
        }
        //防止上一页，已经封顶但是点击错误
//        if(Integer.parseInt(currentPage)<=0){
//                     currentPage="1";
//        }
        //获取条件查询的参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        userService  userService=new userServiceImpl();
        PageBean <User> pb=userService.findUserByPage(currentPage,rows,parameterMap);

        //将数据存入request中
        request.setAttribute("pb", pb);
        request.setAttribute("parameterMap",parameterMap);
        request.getRequestDispatcher("/list.jsp").forward(request, response);

       }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
