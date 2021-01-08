package springbootstudy.springbooot04web.ExceptionHandler;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttrbutes extends DefaultErrorAttributes {

    // 这里获取的map就是页面和json可以获取的所有页面
     @Override
     public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

      //  调用父类方法，获得异常信息
      Map<String, Object> map = super.getErrorAttributes(webRequest, options);

      map.put("giao","giao");

/**   获取异处理器携带的数据，在异常处理器我们已经标识可状态码，并将异常数据传入了req中,
 *     WebRequest是对req类的封装，getAttribute方法有两个参数，存入值的id，域代表的id
 */
      Map ex = (Map) webRequest.getAttribute("ex", 0);

//      将异常信息传入DefaultErrorAttributes所携带的map中
      map.put("ex", ex);

      return  map;
     }
}
