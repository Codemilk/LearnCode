package views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;
//自定义视图解析器
@Component
public class hello implements View {


    @Override
    public String getContentType() {

        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {

        response.getWriter().write("hello view ,time is:"+new Date());

    }
}
