package Request;

import sun.management.Agent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Request_demo3")
public class Request_demo3 extends HttpServlet {
    /*2. 获取请求头数据
	* 方法：
	* (*)String getHeader(String name):通过请求头的名称获取请求头的值
	* Enumeration<String> getHeaderNames():获取所有的请求头名称
	*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        演示获取请求头数据：user-agent
//        String header = req.getHeader("user-agent");
//        判断浏览器版本,解决浏览器的兼容性问题
//        if(header.contains("Chrome")){
//            System.out.println("谷歌");
//        }else if((header.contains("MetaSr"))){
//            System.out.println("搜狗");
//        }

        //演示获取请求头数据：referer
        String referer=req.getHeader("referer");
        System.out.println(referer);
        //防盗取链接
        if(referer!=null)
        {if(referer.contains("/day14")){
//            System.out.println("please look me");
            resp.getWriter().write("please look me");
        }else{
//            System.out.println("你现在所在的观看方式,已经侵权，请推出并哦通过正版方式观看");
            resp.getWriter().write("你现在所在的观看方式,已经侵权，请推出并哦通过正版方式观看");

        }}

    }

}
