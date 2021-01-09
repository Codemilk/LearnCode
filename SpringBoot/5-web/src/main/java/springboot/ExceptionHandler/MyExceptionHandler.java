    package springboot.ExceptionHandler;


    import org.springframework.web.bind.annotation.ControllerAdvice;
    import org.springframework.web.bind.annotation.ExceptionHandler;
    import org.springframework.web.bind.annotation.ResponseBody;
    import springboot.Exception.UserNotExistException;

    import javax.servlet.http.HttpServletRequest;
    import java.util.HashMap;
    import java.util.Map;

    @ControllerAdvice
    public class MyExceptionHandler {


    //    @ExceptionHandler(UserNotExistException.class)
    //    //这样其实不好，是手动写好你的浏览器和客户端都返回json的，我们需要自适应
    //    @ResponseBody
    //    public Map hadnleUserNotExistException(Exception e){
    //
    //        Map map=new HashMap<>();
    //        map.put("code", "user.notexitst");
    //        map.put("message", e.getMessage());
    //        return map;
    //    }

    //   自适应
        @ExceptionHandler(UserNotExistException.class)
        public String hadnleUserNotExistException(Exception e, HttpServletRequest request){

            Map map=new HashMap<>();
            map.put("code", "user.notexitst");
            map.put("message", "用户信息不对");
            //转发到error请求,也就是说BasicErrorController会拦截到  "${server.error.path:${error.path:/error}}" 请求
            request.setAttribute("javax.servlet.error.status_code",500);
            //将数据传入域对象中
            request.setAttribute("except",map);
            return "forward:/error";
        }
    }
