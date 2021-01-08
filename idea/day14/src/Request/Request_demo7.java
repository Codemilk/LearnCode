package Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Request_demo7")
public class Request_demo7 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Request_demo7被访问了");
       //通过request对象获取请求转发器对象
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Request_demo8");
       //使用RequestDispatcher对象来进行转发
//        requestDispatcher.forward(req, resp);
       //和 req.setCharacterEncoding("utf-8");一样只调用一次，所以尽量将代码简化，可写成👇面那样
        req.getRequestDispatcher("/Request_demo8").forward(req,resp);
        //实现资源共享req.setAttribute(对象, 值);
        req.setAttribute("msg", "hello");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
     }
}
