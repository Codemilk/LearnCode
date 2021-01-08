package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/Request_demo5")
public class Request_demo5 extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过参数名称获取参数值
//        String username = req.getParameter("username");
//        System.out.println(username);

        //根据参数名称获取参数值的数组
//        String[] hobbies = req.getParameterValues("hobby");
//        for(String s:hobbies){
//            System.out.println(s);
//        }
        //获取所有的名称
//        Enumeration<String> parameterNames = req.getParameterNames();
//       while (parameterNames.hasMoreElements()){
//           String s = parameterNames.nextElement();
//           System.out.println(s+":"+req.getParameter(s));
//           System.out.println("--------------");
//       }
    //获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> strings = parameterMap.keySet();
       for(String name:strings){

           String[] n = parameterMap.get(name);
           System.out.println(name+":");
          for (String s1:n){
              System.out.println(s1);
          }
           System.out.println("----------------");
       }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         this.doPost(req, resp);
    }
}
