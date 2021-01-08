package ANLI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie_Test")
public class cookie_Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头数据格式以及编码个格式
        response.setContentType("text/html;charset=utf-8");
        boolean flag=false;
        Cookie[] cookies = request.getCookies();
        if(cookies!=null&&cookies.length>0){
            for (Cookie c:cookies){
                String name = c.getName();
                if("lasttime".equals(name)){
                    Date date=new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");                    //响应数据
                    String format = simpleDateFormat.format(date);
                    //因为在tomcat8后虽然已经支持中文，但是特殊字符还要编码
                    System.out.println("编码前"+format);
                    //编码工具
                    String encode = URLEncoder.encode(format, "utf-8");
                    System.out.println("编码后"+encode);
                    c.setValue(encode);
                    System.out.println();
                    c.setMaxAge(60*60*24*30);
                    flag=true;
                    String value=c.getValue();
                    response.addCookie(c);
                    //url解码
                    value= URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("欢迎回来"+value);
                    break;
                }
            }

        }

        if (cookies==null||cookies.length==0||flag==false){
            Date date=new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年mm月dd日 HH：mm：ss");                    //响应数据
            String encode = URLEncoder.encode(simpleDateFormat.format(date), "utf-8");
             Cookie cookie = new Cookie("lasttime",encode);
            cookie.setMaxAge(60*60*24*30);
            String value=URLDecoder.decode(cookie.getValue(), "utf-8");
            response.addCookie(cookie);

            response.getWriter().write("欢迎你首次访问"+value);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }
}
