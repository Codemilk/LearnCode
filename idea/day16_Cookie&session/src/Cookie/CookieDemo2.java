package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
*
*  Cookie快速入门
*
* */

@WebServlet("/CookieDemo1")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //3.获取Cookie
        Cookie[] cookies =  req.getCookies();
    //遍历cookie
    if(cookies!=null){
     for(Cookie c:cookies){
         String name=c.getName();
         String value=c.getValue();
     }
    }


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     this.doGet(req, resp);
    }
}
