package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/Request_demo4")
public class Request_demo4 extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //获取请求消息体--请求参数

    //1.获取字符流
        BufferedReader reader = request.getReader();
    //2.读取数据
       String line=null;
       while ((line=reader.readLine())!=null){
           response.getWriter().write(line);
       }
    }
}
