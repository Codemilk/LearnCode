package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("这是demo1");
        //访问/ResponseDemo1，会自动跳转到/ResponseDemo2资源
     //1.设置状态码为302
//        response.setStatus(302);
//        response.setHeader("location", "/day15/ResponseDemo2");
        //为了防止以后麻烦的大片的更改虚拟目录，我们建议使用getContextPath()的方法，因为：此方法是动态的随着服务器变化
        String contextPath = request.getContextPath();
        response.sendRedirect("/"+contextPath+"/ResponseDemo2");
    //在重定向中不可以使用资源共享也就是dispatcher因为是两个装箱之后就是两个对象
//    request.setAttribute("mgs", "mgs");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }
}
