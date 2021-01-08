package HelloWorld;

import Bean.Bean;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.plugin2.util.PojoUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/Recover")
@SessionAttributes(value = {"User"})
public class HelloWord {
/*1.使用@RequestMapping 来映射请求的URL
* 2.返回值会通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver 视图解析器，会进行如下解析：
*  先通过 dispatchServlet 获取前端的跳转请求，到@Controller这里找到 @RequestMapping("/hello") 来指定方法 在通过 视图解析器 prefix+returnVal+suffix
*
* */
     @RequestMapping(value = "/hello",method = RequestMethod.GET)
//     @RequestMapping不仅可以加在方法上 也可以加在类上 ，相当于加了一层目录，在你的前端对应的href：HelloWord/hello
     public String hello(){
            System.out.println("hello world");
            return "success";
        }

        @RequestMapping("/PathVariable/{id}")
     public String testPathVariable(@PathVariable Integer id){
            System.out.println(id);
         return "success" ;
        }

//REST

        @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public String testREST_GET(@PathVariable Integer id){
            System.out.println("this is get"+id);
         return "success";
    }
        @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public String testREST_POST(){
        System.out.println("this is POST");

        return "success";
    }
        @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public String testREST_PUT(@PathVariable Integer id){
        System.out.println("this is PUT"+id);

        return "success";
    }
        @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public String testREST_DELETE(@PathVariable Integer id){
        System.out.println("this is DELETE"+id);

        return "success";
    }

    @RequestMapping("/RequestParam")
    public String testRequestParam(@RequestParam(value = "id",defaultValue = "0",required = false) String id){
        System.out.println("RequestParam: "+id);
         return "success";
    }

    @RequestMapping("/RequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept-Encoding") String RequestHeader){
        System.out.println("RequestParam: "+RequestHeader);
        return "success";
    }
    @RequestMapping("/CookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String CookieValue){
        System.out.println("CookieValue: "+CookieValue);
        return "success";
    }

    @RequestMapping("/testPOJO")
    public String testPOJO(Bean bean){
        System.out.println(bean);
        return "success";

    }

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request, HttpServletResponse response){
        System.out.println("request: "+request+"response"+response);
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){

         //创建mv 然后写入view映射的名字
         ModelAndView mv=new ModelAndView("success");

//         mv默认数据会自己传入request中
         mv.addObject("time",new Date().getTime());

         return mv;

    }

    @RequestMapping("/testMap")
    public String testMap(Map <String,Object> map){

        map.put("zj", "zqh");

         return "success";
    }

    @RequestMapping("testSessionAttribute")
    public String testSessionAttribute(Map<String,Object> map){

         Bean bean=new Bean("tom", "M", "6954832494@qq.com");

            map.put("User", bean);

         return "success";
    }

}
