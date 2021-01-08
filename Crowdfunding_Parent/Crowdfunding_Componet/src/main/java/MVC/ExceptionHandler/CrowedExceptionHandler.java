package MVC.ExceptionHandler;

import MVC.Controller.TestHandler;
import Util.CrowdUtil;
import Util.CrowedConstant;
import Util.ResultEntity;
import com.google.gson.Gson;
import exception.AccessForbiddenException;
import exception.LoginFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @ ControllerAdvice是一个基于注解的异常处理类 */
@ControllerAdvice
public class CrowedExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //数据库唯一键异常
    @ExceptionHandler(value = {RuntimeException.class})
    public ModelAndView ResolvedRuntimeExceptionException(
            Exception e,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {


        if (e instanceof DuplicateKeyException) {
            //这表示唯一键异常
            String view = "system-error";
            e=new DuplicateKeyException("您的id已经被注册了");
            return CommonExceptionResolved(view, e, request, response);
        }

        return null;
    }
//老版本
/**  @ ExceptionHandler可以将一个具体的异常类型和一个方法关联起来
    @ ExceptionHandler(value = {NullPointerException.class})
//  注解可以从参数中获取，异常

    public ModelAndView ResolveNullPointerException(
            //实际捕获的异常
            NullPointerException nullPointerException ,
            //当前请求对象
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

         //首先获得当前请求时什么请求


        boolean b = CrowdUtil.judgeRequestType(request);

        if(b){
            //说明是ajax

            LoggerFactory.getLogger(TestHandler.class).info("异常处理器");

            //返回ResultEntity对象
            ResultEntity<Object> failed = ResultEntity.Failed(nullPointerException.getMessage());

            //将ResultEntity转换为json字符串
            //1.创建Gson对象
            Gson gson=new Gson();
            //2.进行转换
            String s = gson.toJson(failed);

            //3.将json数据传入到网页
            response.getWriter().write(s);

            return null;
        }

        ModelAndView mv=new ModelAndView("system-error");
        mv.addObject("exception", nullPointerException);

        return mv;
    }
*/
//更新版
    private ModelAndView CommonExceptionResolved(
            //不同的错误可能有不同的视图
            String view,
            //对应的异常,这里时向上转型
            Exception exception,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        //首先获得当前请求判定什么请求
        boolean b = CrowdUtil.judgeRequestType(request);

        if(b){
            //说明是ajax

            //LoggerFactory.getLogger(TestHandler.class).info("异常处理器");

            //返回ResultEntity对象
            ResultEntity<Object> failed = ResultEntity.Failed(exception.getMessage());

            // 将ResultEntity转换为json字符串
            //1.创建Gson对象
            Gson gson=new Gson();
            //2.进行转换
            String s = gson.toJson(failed);

            //3.将json数据传入到网页
            response.getWriter().write(s);

            return null;
        }

        ModelAndView mv=new ModelAndView(view);
        mv.addObject(CrowedConstant.ATTR_Name_exception, exception);

        return mv;

    }

/**登录异常*/
    @ExceptionHandler(value = {LoginFailedException.class})
    public ModelAndView LoginFailedException(
            Exception e,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
//            登录失败回显
        System.out.println("LoginFailedException来了");

        String view="login";
        return  CommonExceptionResolved(view, e,request,response);
    }
//没有登录
    @ExceptionHandler(value = {AccessForbiddenException.class})
    public ModelAndView AccessForbiddenException(
            Exception e,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

        String view="login";
        System.out.println("AccessForbiddenException来了");

        return CommonExceptionResolved(view,e,request,response);
    }
    /**
     *
     * 父类异常，总父类，当出现一个异常，所有子类都不符合标准，这时候就交给父类异常了
     * @param e
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView ResolvedException(
            Exception e,
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {

          String view="system-error";


          return CommonExceptionResolved(view,e,request,response);


    }

}
