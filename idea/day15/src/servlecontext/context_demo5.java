package servlecontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/context_demo5")
public class context_demo5 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取servletContext对象
        ServletContext servletContext = this.getServletContext();
       //获取文件的服务器路径
        String b = servletContext.getRealPath("/b.txt");//web目录下
        String c = servletContext.getRealPath("/WEB-INF/c.txt");//WEB=INF目录下
         String a = servletContext.getMimeType("/WEB-INF/classes/a.txt");//src目录下
        System.out.println(b);
        System.out.println(c);
        System.out.println(a);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
