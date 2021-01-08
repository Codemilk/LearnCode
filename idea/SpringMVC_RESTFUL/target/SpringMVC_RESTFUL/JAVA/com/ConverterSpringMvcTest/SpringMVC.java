package com.ConverterSpringMvcTest;

import com.HandlerException.UserEx;
import com.SpringCRUD.Dao.Employee;
import com.SpringCRUD.DaoImpl.EmployeeDao;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@Controller
public class SpringMVC {


    @Autowired
    private EmployeeDao employeeDao;


//    国际化解析器
    @Autowired
    private ResourceBundleMessageSource messageSource;


    @RequestMapping("/testConversionService")
    public String testConverter(@RequestParam("employee")Employee employee){
        System.out.println("save"+employee);
        employeeDao.save(employee);


        return "redirect:/emps";
    }

    @ResponseBody
    @RequestMapping("/testJson")
        public Collection<Employee> testJson(){

        return employeeDao.getAll();
    }

    //@ResponseBody 在目标方法的返回值 可以将得到的数据通过输出流返回到页面
    @ResponseBody
    @RequestMapping("/testHttpMessageConverter")
    //@RequestBody 在目标方法的入参 可以将页面的数据通过输入流获取到SpringMvc
    public String  testHttpMessageConverter(@RequestBody String body){

        System.out.println(body);

        return "hello world"+new Date();

    }


    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte []> testResponseEntity( HttpSession httpSession) throws IOException {
        byte [] body=null;
        ServletContext servletContext = httpSession.getServletContext();

        InputStream in = servletContext.getResourceAsStream("/WEB-INF/classes/Test.txt");

        System.out.println(in);

         //in.available() :此方法返回的实际字节数，也就是总大小
        body=new byte[in.available()];
        in.read(body);

        //设置请求头
        HttpHeaders headers=new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=Test.txt");

        HttpStatus statusCode=HttpStatus.OK;

        ResponseEntity<byte []> responseEntity=new ResponseEntity<byte []>(body,headers,statusCode);


        return responseEntity;


    }

    @RequestMapping("/i18n")
    public  String testi18n(Locale locale){
        String val= messageSource.getMessage("i18n.user", null, locale);

        System.out.println(val);

        return "i18n";

    }

    @RequestMapping("/testFilerUpload")
    public  String testFilerUpload(@RequestParam("desc") String desc,
                                   @RequestParam("file") MultipartFile multipartFile) throws IOException {

        System.out.println(desc);
        System.out.println(multipartFile.getName());
        System.out.println(multipartFile.getInputStream());

    return "success";
    }

    @RequestMapping("testExceptionHandlerExceptionResolver")
    public String testExceptionHandlerExceptionResolver(@RequestParam("i")Integer i){

        System.out.println("result:"+(10/i));

        return "success";
    }

   /* 1.在@ExceptionHandler方法的入参中可以加入Exception类型的参数，该参数及对应异常
      2.@ExceptionHandler方法的入参不能传入Map，若希望把异常信息传到页面，需要使用ModelAndView作为返回值
      3.@ExceptionHandler方法标记的异常优先级的问题
      4.@ControllerAdvice如果在Handler中找不到@ExceptionHandler方法中当前的异常
      则将去@ControllerAdivice标记的类中查找@ExceptionHandler标记的方法来处理异常

*
*/

   /*
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handlerArithmeticException(Exception ex){
        System.out.println("出Arithmetic异常了"+ex);
        ModelAndView mv=new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }


    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handlerArithmeticException2(Exception ex){
        System.out.println("出Runtime异常了"+ex);
        ModelAndView mv=new ModelAndView("error");
        mv.addObject("exception",ex);
        return mv;
    }
    */

   @RequestMapping("/testStatusException")
      public String testStatusException(@RequestParam("i")Integer i){


           System.out.println("jin");
          if(i==13){
              throw new UserEx();
          }


              System.out.println("success");

          return "success";
      }

      @RequestMapping(value = "/testDefaultHandExceptionResolver",method = RequestMethod.POST)
      public String testDefaultHandExceptionResolver(){

          System.out.println("testDefaultHandExceptionResolver");


       return "success";
      }

      @RequestMapping("/testSimpleMappingExceptionResolver")
      public String testSimpleMappingExceptionResolver(@RequestParam("i") Integer i){
       String val[]=new String[10];

          System.out.println(val[i]);


       return "success";
      }
}
