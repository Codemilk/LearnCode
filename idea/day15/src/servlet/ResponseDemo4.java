package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //因为流这个东西是Tomcat给你的所以他的编码是拉丁编码也就是ISO-8859-1 设置为GBK
//        response.setCharacterEncoding("GBK");
    //但是不同的客户端有可能用不同的编码形式，索性统一使用setheader
    response.setHeader("Content-Type","text/html;charset=utf-8");
//      response.setContentType();
        //1.获取字符输出流
      PrintWriter pw =response.getWriter();
      pw.write(" 你好 World ");

     }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
