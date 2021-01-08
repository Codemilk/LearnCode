package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo5")
public class CookieDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         Cookie c  = new Cookie("msg", "大哥大嫂过年好");
         //在tomcat8之后支持中文编码
        //让cookie设置为当前文件下（localhost）让所有人可以获取到cookie
         c.setPath("/");
        //使用cookie的
        response.addCookie(c);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request, response);
    }
}
