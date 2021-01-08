package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo4")
public class CookieDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象
         Cookie c  = new Cookie("msg", "setmaxage");
        //调用cookie的setmaxage方法，是cookie可以持久化储存
        //1. 3000(正数)代表将cookie持久化到硬盘，持续3000秒
//        c.setMaxAge(3000);
        //2. -1(负数)代表是默认值，代表不保存
//        c.setMaxAge(-1);
        //3. 0代表是删除cookie信息
//        c.setMaxAge(0);
        //发送cookie
         response.addCookie(c);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doPost(request, response);
    }
}
