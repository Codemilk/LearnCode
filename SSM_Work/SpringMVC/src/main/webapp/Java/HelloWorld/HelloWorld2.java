package HelloWorld;

import Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@SessionAttributes(value = {"user"})
@Controller
public class HelloWorld2 {
    private static final String SUCCESS="success";


    @ModelAttribute
    public void getUser(@RequestParam(value = "id",required = false) Integer id, Map<String,User> map){

        if(id!=null){

            User user = new User(1, "tom", "123456", "123456@qq.com", 12);
            System.out.println(user);
            map.put("user", user);
        }


    }
    @RequestMapping(value = "/testModelAttribute")
    private String testModelAttribute(@ModelAttribute("user") User user){

        System.out.println("testModelAttribute："+user);

        return SUCCESS;
    }

    @RequestMapping("/testViewAndViewResolver")
    private String testViewAndViewResolver(){

        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }

    @RequestMapping("/testHelloView")
    public String testHelloView(){

        return "helloView";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){

        System.out.println("重定向了");

        return "redirect:/index.jsp";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){return  SUCCESS;}

//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView HandlerArithmeticException(Exception ex){
//        System.out.println("异常出现了:"+ex);
//        ModelAndView mv=new ModelAndView("error");
//
//        mv.addObject("ex",ex);
//        return mv;
//    }

    @RequestMapping("/testHandlerExceptionResolver")
    public String testHandlerExceptionResolver(@RequestParam("i") int i){

        System.out.println("result"+(10/i));

        return SUCCESS;
    }
}
