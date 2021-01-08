package Test;

import POJO.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
@SessionAttributes(value = {"user"},types = {String.class})
@RequestMapping("/SpringMvc")
@Controller
public class SpringTest {

    private  static final String SUCCESS="success";

    //@RequestMapping注解除了可以修饰方法，还可以修饰类
    //-类定义处：提供初步的请求映射信息。相对于WEB应用的根目录
    //-方法处：提供进一步的细分映射，相对于类定义处的URL。若类定义处未标注
    @RequestMapping(value = "/SpringTest1",method = RequestMethod.GET)
    public String SpringTest1(){
            System.out.println("testOk");
            return  SUCCESS;
    }

    //使用method 属性来指定请求方式
    @RequestMapping(value = "/method",method = RequestMethod.POST)
    public String method(){

        System.out.println("testMethod");
        return SUCCESS;
    }

    //使用params和headers属性来指定请求方式
    @RequestMapping(value = "/paramTest",params = {"username","age!=10"})
    public String paramTest(){
        return  SUCCESS;
    }

    //通配符演示
    @RequestMapping("/AntTest/*/ant")
    public String AntTest(){
        return SUCCESS;
    }

    /*  @PathVariable演示
        来映射URL中的占位符到目标方法的参数中
    */
    @RequestMapping("/testPathVariable/{id}")
    public String PathVariableTest(@PathVariable("id") int id){
        System.out.println(id);
        return SUCCESS;
    }
/*   HiddenHttpMethodFilter来转换请求的演示
     Rest风格的URL
       以CRUD为例
         增：/order POST
         改：/order/1 put
         获取：/order/1 GET
         删除：/order/1 delete

         如何发送请求PUT请求和DELETE请求呢？
         1.需要配置HiddenHttpMethodFilter
         2.需要先发送post请求
         3.需要发送Post请求时携带一个隐藏域 name=_method,value=post/delete像这样：
             <form action="SpringMvc/testRest/1" method="post">
                <input type="hidden" name="_method" value="PUT">
                <input type="submit" value="TestRest put">
             </form>
        4.在SpringMvc的目标方法中如何得到id呢？
          使用@PathVariable注解

    */
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.GET)
    public  String testRestGET(@PathVariable("id") int id){
        System.out.println("GET"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest",method = RequestMethod.POST)
    public  String testRestPOST(){
        System.out.println("POST");
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.DELETE)
    public  String testRestDELETE(@PathVariable("id") int id){
        System.out.println("DELETE"+id);
        return SUCCESS;
    }
    @RequestMapping(value = "/testRest/{id}",method = RequestMethod.PUT)
    public  String testRestPUT(@PathVariable("id") int id){
        System.out.println("PUT"+id);
        return SUCCESS;
    }

    @RequestMapping("/RequestParam")
    //value:参数名
    //required：是否必须，默认为true表示请求参数中必须包含对应的参数，若不存在，将抛出异常
    //defaultValue：可以设置默认值
    public String TestRequestParam(@RequestParam("username") String username,@RequestParam(value = "age",defaultValue ="0") int age){
        System.out.println(username);
        System.out.println(age);
        return SUCCESS;
    }


    @RequestMapping("/RequestHeader")
    public String TestRequestHeader(@RequestHeader("Accept-Language") String al){

        System.out.println(al);

        return SUCCESS;
    }

    @RequestMapping("/CookieTest")
    public String CookieTest(@CookieValue("JSESSIONID") String jessionId){
        System.out.println("cookieValue:"+jessionId);
        return  SUCCESS;
    }

//user(我觉得就是javabean)的自动装填
    @RequestMapping("/autoPojo")
    public String pojoTest(User user){
        System.out.println(user);
        return SUCCESS;
    }
     /*
     * 可是使用Servlet原生API作为目标方法的参数，可以支持：
     *HttpServletRequest
     *HttpServletResponse
     *HttpSession
     *Principal
     *InputStream
     *outStream
     * Reader
     * Writer
   */

    @RequestMapping("/testServlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response, Writer writer) throws IOException {

        System.out.println("testServlet:"+request);
        System.out.println("testServlet:"+response);

        writer.write("helloSpringMvc");
    }


/*处理模型数据：
ModelAndView类型：
             目标方法的返回值可以是ModelAndView类型
             其中可以包含视图和模型
             SpringMVC会把ModelAndView的model中数据放入到request域对象中
*/
    @RequestMapping("/TestModelAndView")
    public ModelAndView TestModelAndView(HttpServletRequest req
    ){
        String viewName=SUCCESS;
        ModelAndView modelAndView=new ModelAndView(viewName);


        //   添加模型数据到ModelAndView中
        modelAndView.addObject("time", new Date());
        return modelAndView;
    }

/*Map及Model
     目标方法可以在入参添加Map类型（实际上也可以是Model类型或ModelMap）

*/
     @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
         map.put("names", Arrays.asList("tom","jerry","mark"));
         System.out.println(map.getClass().getName());

         return SUCCESS;
     }
/*@SessionAttributes:
         可以通过属性名指定需要放到会话的属性，还可以通过模型属性的对象类型指定那些模型属性需要放到会话中
          这个注解需要放到类的上面
    */
     @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes( Map<String,Object> map){
         User user =new User("Tom", "9669", "xxx", 18);
           map.put("user", user);
           map.put("name","guigu");
         return SUCCESS;
     }
/*
     ModelAttribute：
                    *1.有@ModelAttribute标记的方法，会在每个目标方法执行之前被SpringMvc调用
                    *2.@ModelAttribute注解也可以修饰目标方法的POJO的入参其value属性值有如下的作用：
                              1).SpringMVC会使用value属性值在implicitModel中查找对应的和随行，若存在，直接传入到目标方法的入参中
                              2).SpringMVC会以value为key，POJO类型的对象为value，存入到request中
                    2.运行流程：1.执行@ModelAttribute注解修饰的方法；从数据库汇中取出做对象，键：user
                               2.SpringMvc从map中取出user对象，并把表单的请求参数赋给user对象的对应属性
                               3.SpringMVC 把上述对象传入目标参数
                    3.注意：在@ModelAttribute的方法中，放入map时的键需要和目标方法入参类型的第一个字母小写的字符串一直
                    4.源码分析流程：1.调用@ModelAttribute注解修饰的方法，实际上把@ModelAttribute方法中Map中的数据放在了implicitModel中
                                   2.解析请求处理的的目标参数，实际上该目标参数来自于WebDataBinder对象的target属性
                                   WebDataBinder的创建：
                                                       1.可以确定objectName属性：若传入的attrName属性值为""，则objectName为类名第一个字母小写.
                                                             注意：若目标方法的参数使用了@ModelAttribute修饰，那么若attrName可以通过的属性value获取
                                                       2. 可以确定target属性:在implicitModel中查找attrName ,存在则继续运行，若不存在，则验证当前
                                                                           的handler是否使用@SessionAttributes() ,则尝试从Session中获取，没有则会报错抛出异常
                                                                           如果Handler中没有使用@SessionAttributes()进行修饰，或@SessionAttributes()中没有使
                                                                           用value值确定的key，则会自动创建当前使用的POJO
                                                       3.SpringMvc把表单的请求参数赋给了WebDataBinder的target对应的属性，
                                                       3.1.在通过把WebDataBinder传入dobind()，来将表单信息覆盖，在通过implicitModel的put方法将其已经被覆盖的对象传入，这样implicitModel的POJO就是赋完值的POJO了
                                                       4.SpringMvc会把WebDataBinder的attrName(key)和target(value)给到implicitModel进而传到request中
                                                       5.把WebDataBinder的target作为参数传递给目标方法的入参
                                                          大概是args从WebDataBinder中get到一个target然后return


                  5.SpringMvc确定目标方法POJO类型入参的过程：
                                                       1.确定一个key
                                                            若目标方法POJO类型的目标参数没有使用@ModelAttribute作为修饰，则key为Pojo类名第一个字母的小写，若使用@ModelAttribute则key为@ModelAttribute的value值
                                                       2.在implicitModel查找key对应的对象，若存在，则作为入参传入

                                                       3.如implicitModel不存在，则检查当前的Handler是否使用@SessionAttrbutes注解修饰
                                                       若使用了@SessionAttribu若在@ModelAttribute （不是方法而是参数）标记的方法中的map中保存过，且key和1tes注解的value属性值中包含了key，则会从HttpSession中来获取key所对应的value值，若存在则直接传入到目标方法的入参中，如不存在抛出异常

                                                       4.若handler没有标识@SessionAttributes或这个注解value不包含key，则会通过反射创建当前POJO的对象，作为目标方法的参数传入
                                                       5.SpringMVC会把key和value保存到implicitModel中，进而会保存到request中

                */
     @ModelAttribute
     public void getUser(@RequestParam(value = "id",required = false) Integer id,Map<String,Object> map){
         System.out.println("ModelAttribute执行了");
         if(id!=null){
             //模拟从数据库汇中获取对象
             User user=new User(1,"Tom","123456","695418746@qq.com",12);
             System.out.println("@ModelAttribute执行了");
             System.out.println("成功获取一个对象"+user);
             map.put("user", user);
         }
     }

     @RequestMapping("/ModelAttribute")
     public String ModelAttributeTest(@ModelAttribute("user")  User user){

         System.out.println("修改"+ user);
         return SUCCESS;
     }

     @RequestMapping("/testViewAndViewResolver")
     public String testViewAndViewResolver(HttpServletRequest request) throws UnsupportedEncodingException {
         System.out.println("testViewAndViewResolver");

         return SUCCESS;
     }
/*自定义视图解析器*/
     @RequestMapping("/testView")
    public String testView(){

         System.out.println("testView");
         return  "hello";
     }
/*关于重定向：

 */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/index.jsp";
    }
}
