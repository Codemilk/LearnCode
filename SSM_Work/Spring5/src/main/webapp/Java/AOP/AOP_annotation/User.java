package AOP.AOP_annotation;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//被增强类
@Component()
public class User {
//    被增强方法
    public int add(){
        System.out.println("this is add()");
        return 1;
    }
}
