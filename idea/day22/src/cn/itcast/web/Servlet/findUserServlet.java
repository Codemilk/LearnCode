package cn.itcast.web.Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class findUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        String username = request.getParameter("username");
        response.setContentType("text/html;charset=utf-8");
        //防止输出流乱码，
        Map<String,Object> map=new HashMap<String,Object>();

        //调用service判断用户名是否存在
        if("tom".equals(username)){
            map.put("userExsit",true );
            map.put("msg","此用户名太受欢迎，请更换一个");
        }else{
            map.put("userExsit",false );
            map.put("msg","用户名可以使用");
        }
       //将map转化为json，传递给浏览器
        ObjectMapper ob=new ObjectMapper();
        ob.writeValue(response.getWriter(), map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doPost(request, response);
    }
}
