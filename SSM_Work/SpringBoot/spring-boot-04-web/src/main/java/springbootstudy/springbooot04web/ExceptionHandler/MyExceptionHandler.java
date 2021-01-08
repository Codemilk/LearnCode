package springbootstudy.springbooot04web.ExceptionHandler;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import springbootstudy.springbooot04web.Exception.testException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lenovo
 */
@ControllerAdvice
public class MyExceptionHandler {

//    1.原始写法
//    @ExceptionHandler(testException.class)
//    @ResponseBody
//    public Map ResolvetestException(Exception ex){
//
//        Map map=new HashMap();
//        map.put("message", ex.getMessage());
//        map.put("code","testException");
//
//        return map;
//
//    }

//    2.自适应写法

    @ExceptionHandler(testException.class)
    public String  ResolvetestException(Exception ex, HttpServletRequest request){

        Map map=new HashMap();
        System.out.println(ex.getMessage());
//        一定要设置状态码，到指定的error，不写状态码就不会进入指定的
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("message", ex.getMessage());
        map.put("code","蛤蟆荼蘼");

//        传入req域，为了方便后续将自定义异常信息加入到自适应异常页面
        request.setAttribute("ex",map);

//        这里一定要接forward，不写的话会变成视图解析，直接去templates里面去找
        return "forward:/error";
    }
}
