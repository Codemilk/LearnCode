package springbootinitializerquick.springbootinitializer.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lenovo
 *
 *@RestController 就是@controller和@Response的集合
 * RestController类的代码头：
 * @Target(ElementType.TYPE)
 * @Retention(RetentionPolicy.RUNTIME)
 * @Documented
 * @Controller
 * @ResponseBody
 * public @interface RestController {
 *
 */
@RestController
public class RestHandler {

    @RequestMapping("/hello")
    public String  test(){

        return "hello world";
    }
}
