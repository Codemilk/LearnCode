package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Request_demo1")
public class Request_demo1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                 /* 1. 获取请求方式 ：GET
						* String getMethod()
					2. (*)获取虚拟目录：/day14
						* String getContextPath()
					3. 获取Servlet路径: /demo1
						* String getServletPath()
					4. 获取get方式请求参数：name=zhangsan
						* String getQueryString()
					5. (*)获取请求URI：/day14/demo1
						* String getRequestURI():		/day14/demo1
						* StringBuffer getRequestURL()  :http://localhost/day14/demo1

						* URL:统一资源定位符 ： http://localhost/day14/demo1	中华人民共和国
						* URI：统一资源标识符 : /day14/demo1					共和国

					6. 获取协议及版本：HTTP/1.1
						* String getProtocol()

					7. 获取客户机的IP地址：
						* String getRemoteAddr()
         */
         //1.获取请求方式
        System.out.println(request.getMethod());
        //2.获取虚拟目录
        System.out.println(request.getContextPath());
        //3.获取Servlet路径
        System.out.println(request.getServletPath());
        //4.获取get方式请求参数
        System.out.println(request.getQueryString());
        //5.获取请求URI
        System.out.println(request.getRequestURI());
        //5.1获取请求URI
        System.out.println(request.getRequestURL());
        //6.获取协议及版本
        System.out.println(request.getProtocol());
        //7. 获取客户机的IP地址
        System.out.println(request.getRemoteHost());
    }
}
