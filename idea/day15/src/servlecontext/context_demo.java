package servlecontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context_demo")
public class context_demo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        //servletContext对象获取
            //1.通过Request.getservletcontextpath
        ServletContext servletContext  = req.getServletContext();
        //2.通话httpservlet自己获取
        ServletContext servletContext1= this.getServletContext();
        System.out.println(servletContext);
        System.out.println(servletContext1);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doGet(req,resp);
    }
}
