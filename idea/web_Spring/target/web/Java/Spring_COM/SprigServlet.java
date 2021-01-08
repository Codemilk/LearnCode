package Spring_COM;

import Com.Beans.testBean;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/SprigServlet1")
public class SprigServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取servletContext
        ServletContext servletContext = request.getServletContext();

        //2.从servlet域中获取IOC容器
        ApplicationContext applicationContext = (ApplicationContext)servletContext.getAttribute("ApplicationContext");

        //3.获取bean
        testBean testbean = (testBean)applicationContext.getBean("testBean");


        testbean.test();
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
}
}
