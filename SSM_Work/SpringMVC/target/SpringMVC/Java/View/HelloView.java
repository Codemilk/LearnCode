package View;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.Date;
import java.util.Map;
@Component
public class HelloView implements View {

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("自定义视图testHelloView加载成功");
         response.getWriter().print("hello view, time:"+new Date());

    }

}
