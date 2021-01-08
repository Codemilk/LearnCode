package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Request_demo2")
public class Request_demo2 extends HttpServlet {
    /*2. 获取请求头数据
	* 方法：
	* (*)String getHeader(String name):通过请求头的名称获取请求头的值
	* Enumeration<String> getHeaderNames():获取所有的请求头名称
	*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();

      while (headerNames.hasMoreElements()){
          String name=headerNames.nextElement();
          System.out.println(name+":"+req.getHeader(name));
      }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
