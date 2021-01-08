package Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView HandlerArithmeticException(Exception ex){
        System.out.println("异常出现了:"+ex);
        ModelAndView mv=new ModelAndView("error");

        mv.addObject("ex",ex);
        return mv;
    }
}
