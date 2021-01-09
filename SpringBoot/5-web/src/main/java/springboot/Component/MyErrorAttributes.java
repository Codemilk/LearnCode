package springboot.Component;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;


@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        //调用方法从webRequest获取数据
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        //从req域中取出自定义的json数据
        Map except =(Map)webRequest.getAttribute("except", 0);
        //再讲取出的值存入errorAttributes
        errorAttributes.put("exceptionMessage",except);
        //自定义异常数据
        errorAttributes.put("message", "MyErrorAttributes的错误");
        return      errorAttributes;
    }
}
