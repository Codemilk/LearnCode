package SpringMvc_handeler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
//使用@RequestMapping来映射请求的URL
//返回值会通过视图解析器为实际的物理视图，对于InternalResourceViewResolver视图解析器，会做如下的解析：
//用过 prefix+returnVal+后缀 这样的方式得到实际的物理视图，然后做转发操作
    @RequestMapping("/HelloWorld")
    public String hello(){
        System.out.println("hello world");
        return "/success";
    }


}
